package com.wangjie.github.publicwechatdemo.messagedomain.requset;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName BaseMessage
 * @Description 接收用于发送给微信公众号的消息基本类
 * @Author 25127
 * @Date 2019/9/7 12:49
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class RqeuestBaseMessage {
    // 开发者微信号
    private String ToUserName;

    // 发送方帐号（一个OpenID）
    private String FromUserName;

    // 消息创建时间 （整型）
    private long CreateTime;

    // 消息类型（text/image/location/link）
    private String MsgType;

    // 消息id，64位整型
    private long MsgId;
}
