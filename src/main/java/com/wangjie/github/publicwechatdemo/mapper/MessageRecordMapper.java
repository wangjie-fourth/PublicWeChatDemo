package com.wangjie.github.publicwechatdemo.mapper;

import com.wangjie.github.publicwechatdemo.domain.MessageRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageRecordMapper {
    @Insert("INSERT INTO message_record (user_open_id, message_type, message_content) VALUES(#{userOpenId}, #{messageType}, #{messageContent})")
    void add(MessageRecord messageRecord);

    @Select("SELECT * FROM message_record WHERE message_type = #{messageType}")
    List<MessageRecord> selectByType(String messageType);

    @Delete("truncate message_record")
    void truncate();

}
