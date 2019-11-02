package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName VideoMessage
 * @Description 回复视频消息
 * @Author 25127
 * @Date 2019/9/7 13:08
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class VideoMessage extends RespBaseMessage {
    // 视频
    private Video Video;
}
