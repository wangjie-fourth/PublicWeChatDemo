package com.wangjie.github.publicwechatdemo.dao.impl;

import com.wangjie.github.publicwechatdemo.dao.MessageRecordDao;
import com.wangjie.github.publicwechatdemo.domain.MessageRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;

/**
 * @ClassName MessageRecordDaoImpl
 * @Description
 * @Author 25127
 * @Date 2019/11/5 19:22
 * @Email jie.wang13@hand-china.com
 **/
@Repository
@Slf4j
public class MessageRecordDaoImpl implements MessageRecordDao {

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:h2:file:/F:/ideaWorks/wangbang/PublicWeChatDemo/database/weChatData");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MessageRecord add(MessageRecord messageRecord) {
        String sql = "insert into message_record(user_open_id,message_type,message_content,is_did,notify_time) values (?,?,?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, messageRecord.getUserOpenId());
            statement.setString(2, messageRecord.getMessageType());
            statement.setString(3, messageRecord.getMessageContent());
            statement.setInt(4, messageRecord.getIsDid());
            statement.setDate(5, (Date) messageRecord.getNotifyTime());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.info("插入message_record时失败");
            e.printStackTrace();
        }
        return messageRecord;
    }

    @Override
    public List<MessageRecord> selectByType(String messageType) {
        List<MessageRecord> result = new ArrayList<>();

        String sql = "select * from message_record where message_type = ?";
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, messageType);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MessageRecord messageRecord = new MessageRecord();
                Long id = resultSet.getLong(1);
                String userOpenId = resultSet.getString(2);
                String messageTypes = resultSet.getString(3);
                String messageContent = resultSet.getString(4);
                int isDid = resultSet.getInt(5);
                Date notifyTime = resultSet.getDate(6);
                Date createdTime = resultSet.getDate(7);
                Date updateDate = resultSet.getDate(8);
                messageRecord.setId(id);
                messageRecord.setUserOpenId(userOpenId);
                messageRecord.setMessageType(messageTypes);
                messageRecord.setMessageContent(messageContent);
                messageRecord.setIsDid(isDid);
                messageRecord.setNotifyTime(notifyTime);
                messageRecord.setCreateTime(createdTime);
                messageRecord.setUpdateTime(updateDate);
                result.add(messageRecord);
            }
        } catch (SQLException e) {
            log.info("查询message_record时失败");
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
