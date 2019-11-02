package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName MusicMessage
 * @Description 回复音乐消息
 * @Author 25127
 * @Date 2019/9/7 13:09
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class MusicMessage extends RespBaseMessage {
    // 音乐
    private Music Music;
}
