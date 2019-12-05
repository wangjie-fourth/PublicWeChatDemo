package com.wangjie.github.publicwechatdemo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName MessageRecord
 * @Description
 * @Author 25127
 * @Date 2019/11/5 19:04
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class MessageRecord {

    private Long id;

    private String userOpenId;

    private String messageType;

    private String messageContent;

    private Date createdTime;

    private Date updatedTime;

    public Date getCreatedTime() {
        return (Date) createdTime.clone();
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = (Date) createdTime.clone();
    }

    public Date getUpdatedTime() {
        return (Date) updatedTime.clone();
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = (Date) updatedTime.clone();
    }
}
