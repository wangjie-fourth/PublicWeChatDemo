package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Data;

/**
 * @ClassName Video
 * @Description
 * @Author 25127
 * @Date 2019/9/7 13:08
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class Video {
    // 媒体文件id
    private String MediaId;
    // 缩略图的媒体id
    private String ThumbMediaId;
}
