package com.wangjie.github.publicwechatdemo.messagedomain.requset;

import lombok.Data;

/**
 * @ClassName VideoMessage
 * @Description 视频消息类型
 * @Author 25127
 * @Date 2019/9/7 12:52
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class VideoMessageRqeuest extends RqeuestBaseMessage {
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String ThumbMediaId;
}
