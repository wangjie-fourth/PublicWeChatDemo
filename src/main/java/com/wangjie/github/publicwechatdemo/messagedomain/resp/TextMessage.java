package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Data;

/**
 * @ClassName TextMessage
 * @Description 回复文本消息
 * @Author 25127
 * @Date 2019/9/7 13:05
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class TextMessage extends RespBaseMessage {
    // 回复的消息内容
    private String Content;
}
