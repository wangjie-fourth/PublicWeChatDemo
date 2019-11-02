package com.wangjie.github.publicwechatdemo.messagedomain.requset;

import lombok.Data;

/**
 * @ClassName ImageMessage
 * @Description 图片消息类型
 * @Author 25127
 * @Date 2019/9/7 12:51
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class ImageMessageRqeuest extends RqeuestBaseMessage {
    // 图片链接
    private String PicUrl;
    private String MediaId;
}
