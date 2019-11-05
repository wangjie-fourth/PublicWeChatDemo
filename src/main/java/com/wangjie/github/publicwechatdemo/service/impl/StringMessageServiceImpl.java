package com.wangjie.github.publicwechatdemo.service.impl;

import com.wangjie.github.publicwechatdemo.dao.MessageRecordDao;
import com.wangjie.github.publicwechatdemo.domain.MessageRecord;
import com.wangjie.github.publicwechatdemo.messagedomain.requset.TextMessageRqeuest;
import com.wangjie.github.publicwechatdemo.service.StringMessageService;
import com.wangjie.github.publicwechatdemo.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName StringMessageServiceImpl
 * @Description
 * @Author 25127
 * @Date 2019/11/2 17:13
 * @Email jie.wang13@hand-china.com
 **/
@Service
@Slf4j
public class StringMessageServiceImpl implements StringMessageService {

    @Autowired
    private MessageRecordDao messageRecordDao;

    @Override
    public String handleStringMessage(TextMessageRqeuest textMessageRqeuest) {
        char index = textMessageRqeuest.getContent().charAt(0);
        if (index == '1') { // 记录备忘录
            // 需要存储的信息
            log.info("【{}】用户发送了{}", textMessageRqeuest.getFromUserName(), textMessageRqeuest.getContent());
            // 存储到数据库中
            MessageRecord messageRecord = orignToMessageRecord(textMessageRqeuest, Constant.MESSAGE_TYPE_记录备忘录);
            messageRecordDao.add(messageRecord);
        } else if (index == '2') { // 记录日常花费
            // 需要存储的信息
            String storeMessage = textMessageRqeuest.getContent().substring(1);
            log.info("【{}】用户需要记录【{}】的花费信息", textMessageRqeuest.getFromUserName(), textMessageRqeuest.getContent());
            MessageRecord messageRecord = orignToMessageRecord(textMessageRqeuest, Constant.MESSAGE_TYPE_日常花费);
            messageRecordDao.add(messageRecord);
        } else if (index == '3') {// 查询记录备忘录
            List<MessageRecord> messageRecords = messageRecordDao.selectByType(Constant.MESSAGE_TYPE_记录备忘录);
            StringBuilder result = new StringBuilder();
            for (MessageRecord item : messageRecords) {
                String line = item.getMessageContent();
                result.append(line);
                result.append("\n");
            }
            return result.toString();
        } else if (index == '4') {// 查询日常花费
            List<MessageRecord> messageRecords = messageRecordDao.selectByType(Constant.MESSAGE_TYPE_日常花费);
            StringBuilder result = new StringBuilder();
            for (MessageRecord item : messageRecords){
                String line = item.getMessageContent();
                result.append(line);
                result.append("\n");
            }
            return result.toString();
        }

        return "您已经成功发送了消息 \n 能换行吗";
    }

    /**
     * 将原始数据转换成需要存储得数据
     *
     * @param textMessageRqeuest 文本原始数据
     * @return
     */
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(
            value="NP_NULL_PARAM_DEREF_ALL_TARGETS_DANGEROUS",
            justification="I know what I'm doing")
    private MessageRecord orignToMessageRecord(TextMessageRqeuest textMessageRqeuest, String messageType) {
        MessageRecord result = new MessageRecord();
        result.setUserOpenId(textMessageRqeuest.getFromUserName());
        result.setNotifyTime(null);
        result.setMessageType(messageType);
        result.setMessageContent(textMessageRqeuest.getContent().substring(1));
        result.setIsDid(0);
        result.setCreateTime(new Date(textMessageRqeuest.getCreateTime()));
        return result;
    }
}
