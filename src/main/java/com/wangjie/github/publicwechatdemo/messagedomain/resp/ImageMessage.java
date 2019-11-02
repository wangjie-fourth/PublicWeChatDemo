package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Data;

/**
 * @ClassName ImageMessage
 * @Description 返回图片消息
 * @Author 25127
 * @Date 2019/9/7 13:06
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class ImageMessage extends RespBaseMessage {
    private Image Image;
}
