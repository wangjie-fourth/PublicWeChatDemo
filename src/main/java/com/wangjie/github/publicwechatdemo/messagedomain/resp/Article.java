package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Data;

/**
 * @ClassName Article
 * @Description
 * @Author 25127
 * @Date 2019/9/7 13:09
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class Article {
    // 图文消息名称
    private String Title;
    // 图文消息描述
    private String Description;
    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
    private String PicUrl;
    // 点击图文消息跳转链接
    private String Url;
}
