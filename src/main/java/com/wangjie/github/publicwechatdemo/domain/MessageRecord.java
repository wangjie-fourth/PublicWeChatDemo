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

    private Date createTime;

    private Date updateTime;

    public Date getCreateTime() {
        return (Date) createTime.clone();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = (Date) createTime.clone();
    }

    public Date getUpdateTime() {
        return (Date) updateTime.clone();
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = (Date) updateTime.clone();
    }
}
