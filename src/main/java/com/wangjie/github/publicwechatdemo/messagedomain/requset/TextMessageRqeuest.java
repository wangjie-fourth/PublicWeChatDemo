package com.wangjie.github.publicwechatdemo.messagedomain.requset;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName TextMessage
 * @Description 文本消息类型
 * @Author 25127
 * @Date 2019/9/7 12:50
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class TextMessageRqeuest {

    // 开发者微信号
    private String ToUserName;

    // 发送方帐号（一个OpenID）
    private String FromUserName;

    // 消息创建时间 （整型）
    private Long CreateTime;

    // 消息类型（text/image/location/link）
    private String MsgType;

    // 消息id，64位整型
    private Long MsgId;

    // 消息内容
    private String Content;

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }
}
