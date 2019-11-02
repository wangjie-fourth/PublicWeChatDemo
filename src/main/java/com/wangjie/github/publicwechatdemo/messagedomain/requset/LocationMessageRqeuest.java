package com.wangjie.github.publicwechatdemo.messagedomain.requset;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName LocationMessage
 * @Description 地理消息位置类型
 * @Author 25127
 * @Date 2019/9/7 12:52
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
public class LocationMessageRqeuest extends RqeuestBaseMessage {
    // 地理位置维度
    private String Location_X;
    // 地理位置经度
    private String Location_Y;
    // 地图缩放大小
    private String Scale;
    // 地理位置信息
    private String Label;
}
