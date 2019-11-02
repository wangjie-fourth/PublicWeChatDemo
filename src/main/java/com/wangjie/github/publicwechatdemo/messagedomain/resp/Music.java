package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Data;

/**
 * @ClassName Music
 * @Description
 * @Author 25127
 * @Date 2019/9/7 13:09
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class Music {

    // 音乐标题
    private String Title;
    // 音乐描述
    private String Description;
    // 音乐链接
    private String MusicUrl;
    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String HQMusicUrl;
    // 缩略图的媒体id，通过上传多媒体文件得到的id
    private String ThumbMediaId;
}
