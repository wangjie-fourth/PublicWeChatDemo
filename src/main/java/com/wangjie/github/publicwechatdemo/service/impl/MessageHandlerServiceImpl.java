package com.wangjie.github.publicwechatdemo.service.impl;

import com.wangjie.github.publicwechatdemo.domain.MessageRecord;
import com.wangjie.github.publicwechatdemo.mapper.MessageRecordMapper;
import com.wangjie.github.publicwechatdemo.service.MessageHandlerService;
import com.wangjie.github.publicwechatdemo.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    public MessageHandlerServiceImpl(MessageRecordMapper messageRecordMapper) {
        this.messageRecordMapper = messageRecordMapper;
    }

    /**
     * 处理文字消息
     *
     * @param requestMap http请求
     * @return 返回返回给前端的参数
     */
    @Override
    public String handlerString(Map requestMap) {
        String content = (String) requestMap.get("Content");
        char index = content.charAt(0);

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setUserOpenId((String) requestMap.get("FromUserName"));


        // 1【要做的事情】
        if ('1' == index) {
            log.info("记录一件将要做的事情");
            String noteMessage = content.substring(1);
            messageRecord.setMessageContent(noteMessage);
            messageRecord.setMessageType(Constant.MESSAGE_TYPE_MEMORANDUM);
            System.out.println("noteMessage = " + noteMessage);
            messageRecordMapper.add(messageRecord);
            return "添加成功";
        }
        // 2【记录花销】
        else if ('2' == index) {
            log.info("记录今天的花销");
            String expenses = content.substring(1);
            messageRecord.setMessageContent(expenses);
            messageRecord.setMessageType(Constant.MESSAGE_TYPE_EXPENSES);
            System.out.println("expenses = " + expenses);
            messageRecordMapper.add(messageRecord);
            return "添加成功";
        }
        // 0【查询所有信息】
        else if ('0' == index) {
            log.info("查询备忘录和花销记录");

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
            List<MessageRecord> messageList = messageRecordMapper.selectByType(Constant.MESSAGE_TYPE_EXPENSES);
            if (messageList.size() == 0) {
                return "暂无花销记录";
            }
            String collect = messageList.stream().map(MessageRecord::getMessageContent).collect(Collectors.joining("\n"));
            log.info(collect);
            return collect;
        }
        // 0 【清空表数据】
        if ('0' == index) {
            log.info("清空表数据");
            messageRecordMapper.truncate();
            return "清空数据完成";
        }

        return null;
    }
}
