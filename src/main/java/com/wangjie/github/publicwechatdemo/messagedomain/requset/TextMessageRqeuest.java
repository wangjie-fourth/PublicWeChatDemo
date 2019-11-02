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
public class TextMessageRqeuest extends RqeuestBaseMessage {

    // 消息内容
    private String Content;
}
