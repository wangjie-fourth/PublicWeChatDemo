package com.wangjie.github.publicwechatdemo.service.impl;

import com.wangjie.github.publicwechatdemo.domain.HistoryExpenses;
import com.wangjie.github.publicwechatdemo.domain.MessageRecord;
import com.wangjie.github.publicwechatdemo.mapper.HistoryExpensesMapper;
import com.wangjie.github.publicwechatdemo.mapper.MessageRecordMapper;
import com.wangjie.github.publicwechatdemo.service.MessageHandlerService;
import com.wangjie.github.publicwechatdemo.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName MessageHandlerServiceImpl
 * @Description
 * @Author 25127
 * @Date 2019/11/2 13:08
 * @Email jie.wang13@hand-china.com
 **/
@Service
@Slf4j
public class MessageHandlerServiceImpl implements MessageHandlerService {

    private final MessageRecordMapper messageRecordMapper;
    private final HistoryExpensesMapper historyExpensesMapper;

    @Autowired
    public MessageHandlerServiceImpl(MessageRecordMapper messageRecordMapper, HistoryExpensesMapper historyExpensesMapper) {
        this.messageRecordMapper = messageRecordMapper;
        this.historyExpensesMapper = historyExpensesMapper;
    }

    /**
     * 处理文字消息
     * 同一消息格式【1xxx xxx xxx】
     *
     * @param requestMap http请求
     * @return 返回返回给前端的参数
     */
    @Override
    public String handlerString(Map requestMap) {
        String content = (String) requestMap.get("Content");
        char index = content.charAt(0);
        content = content.substring(1);

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setUserOpenId((String) requestMap.get("FromUserName"));
        // 1【要做的事情】
        if ('1' == index) {
            log.info("记录一件将要做的事情");
            messageRecord.setMessageContent(content);
            messageRecord.setMessageType(Constant.MESSAGE_TYPE_MEMORANDUM);
            System.out.println("noteMessage = " + content);
            messageRecordMapper.add(messageRecord);
            return "添加成功";
        }
        // 2【记录花销】
        else if ('2' == index) {// 消息模板【2坐车 花费 20元】
            log.info("记录今天的花销");
            String[] contents = content.split(" ");
            messageRecord.setMessageContent(content);
            if (contents[1].equals("花费")) {
                messageRecord.setMessageType(Constant.MESSAGE_TYPE_EXPENSES_OUT);
            } else if (contents[1].equals("收入")) {
                messageRecord.setMessageType(Constant.MESSAGE_TYPE_EXPENSES_IN);
            }
            System.out.println("expenses = " + content);
            messageRecordMapper.add(messageRecord);
            return "添加成功";
        }
        // 3 【查询备忘录】
        if ('3' == index) {
            log.info("查询了备忘录");
            List<MessageRecord> messageList = messageRecordMapper.selectByType(Constant.MESSAGE_TYPE_MEMORANDUM);
            if (messageList.size() == 0) {
                return "暂无要完成的任务";
            }
            String collect = messageList.stream().map(MessageRecord::getMessageContent).collect(Collectors.joining("\n"));
            log.info(collect);
            return collect;
        }
        // 4 【查询花销】
        if ('4' == index) {
            log.info("查询了花销");
            List<MessageRecord> messageList = messageRecordMapper.selectByType(Constant.MESSAGE_TYPE_EXPENSES_OUT);
            if (messageList.size() == 0) {
                return "暂无花销记录";
            }
            StringBuilder result = new StringBuilder();

            Map<Integer, List<MessageRecord>> collect = messageList.stream().sorted(Comparator.comparing(MessageRecord::getCreateTime).reversed()).collect(Collectors.groupingBy(item -> {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(item.getCreateTime());
                return calendar.get(Calendar.DAY_OF_MONTH);
            }));
            for (Map.Entry<Integer, List<MessageRecord>> entry : collect.entrySet()){
                for (MessageRecord messageRecord1 : entry.getValue()){
                    result.append(messageRecord.getMessageContent());
                    result.append("\n");
                }
                result.append("==============================\n");
            }
            log.info(result.toString());
            return result.toString();
        }
        // 0 【清空表数据】
        if ('0' == index) {
            log.info("清空表数据");
            messageRecordMapper.truncate();
            return "清空数据完成";
        }
        // 5 【将今日花费转入历史花费表】
        if ('5' == index) {
            log.info("将今日花费转入历史花费表");
            List<MessageRecord> messageList = messageRecordMapper.selectByType(Constant.MESSAGE_TYPE_EXPENSES_OUT);
            messageList.addAll(messageRecordMapper.selectByType(Constant.MESSAGE_TYPE_EXPENSES_IN));
            List<HistoryExpenses> historyExpensesList = convertMessageRecordToHistoryExpenses(messageList);
            historyExpensesMapper.insertList(historyExpensesList);
            return "转入完成";
        }
        return null;
    }

    /**
     * 将MessageRecord实体类转换成HistoryExpenses；
     * 其中id不会进行转换
     *
     * @param messageList MessageRecord表数据
     * @return 转换后地数据
     */
    private List<HistoryExpenses> convertMessageRecordToHistoryExpenses(List<MessageRecord> messageList) {
        return messageList.stream().map(item -> {
            HistoryExpenses demo = new HistoryExpenses();
            demo.setType(item.getMessageType());
            demo.setContent(item.getMessageContent());
            demo.setUseDay(new Date());
            return demo;
        }).collect(Collectors.toList());
    }
}
