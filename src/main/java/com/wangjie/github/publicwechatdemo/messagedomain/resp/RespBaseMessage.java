package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Data;

/**
 * @ClassName RespBaseMessage
 * @Description 返回给用户的消息
 * @Author 25127
 * @Date 2019/9/7 13:04
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class RespBaseMessage {
    // 接收方帐号（收到的OpenID）
    private String ToUserName;
    // 开发者微信号
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型
    private String MsgType;
}
