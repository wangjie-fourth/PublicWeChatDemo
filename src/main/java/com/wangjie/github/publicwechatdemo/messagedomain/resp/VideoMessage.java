package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Data;

/**
 * @ClassName VideoMessage
 * @Description 回复视频消息
 * @Author 25127
 * @Date 2019/9/7 13:08
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class VideoMessage extends RespBaseMessage {
    // 视频
    private Video Video;
}
