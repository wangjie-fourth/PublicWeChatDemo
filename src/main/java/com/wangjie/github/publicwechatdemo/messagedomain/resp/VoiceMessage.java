package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName VoiceMessage
 * @Description 回复语音消息
 * @Author 25127
 * @Date 2019/9/7 13:07
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class VoiceMessage extends RespBaseMessage {
    // 语音
    private Voice Voice;
}
