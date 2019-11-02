package com.wangjie.github.publicwechatdemo.messagedomain.requset;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName VoiceMessage
 * @Description 语音消息类型
 * @Author 25127
 * @Date 2019/9/7 12:51
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class VoiceMessageRqeuest extends RqeuestBaseMessage {
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;
}
