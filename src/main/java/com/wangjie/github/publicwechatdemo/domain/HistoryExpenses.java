package com.wangjie.github.publicwechatdemo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName HistoryExpenses
 * @Description
 * @Author 25127
 * @Date 2019/12/1 21:23
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class HistoryExpenses {
    private Integer id;

    private String type;

    private String content;

    private Date useDay;

    private Date createdTime;

    private Date updatedTime;

    public Date getUseDay() {
        return (Date) useDay.clone();
    }

    public void setUseDay(Date useDay) {
        this.useDay = (Date) useDay.clone();
    }

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
