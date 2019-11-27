package com.wangjie.github.publicwechatdemo.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName TextMessage
 * @Description 回复文本消息
 * @Author 25127
 * @Date 2019/9/7 13:05
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class TextMessage {
    // 接收方帐号（收到的OpenID）
    private String ToUserName;
    // 开发者微信号
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型
    private String MsgType;
    // 回复的消息内容
    private String Content;
}
