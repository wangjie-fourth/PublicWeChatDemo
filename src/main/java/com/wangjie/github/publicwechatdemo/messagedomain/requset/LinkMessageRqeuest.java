package com.wangjie.github.publicwechatdemo.messagedomain.requset;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName LinkMessage
 * @Description 链接消息类型
 * @Author 25127
 * @Date 2019/9/7 12:53
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class LinkMessageRqeuest extends RqeuestBaseMessage {
    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;
}
