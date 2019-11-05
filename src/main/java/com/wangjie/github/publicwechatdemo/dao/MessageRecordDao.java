package com.wangjie.github.publicwechatdemo.dao;


import com.wangjie.github.publicwechatdemo.domain.MessageRecord;

import java.util.List;

public interface MessageRecordDao {

    MessageRecord add(MessageRecord messageRecord);

    List<MessageRecord> selectByType(String messageType);

}
