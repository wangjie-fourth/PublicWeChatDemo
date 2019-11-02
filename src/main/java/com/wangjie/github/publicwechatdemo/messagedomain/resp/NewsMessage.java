package com.wangjie.github.publicwechatdemo.messagedomain.resp;

import lombok.Data;

import java.util.List;

/**
 * @ClassName NewsMessage
 * @Description 回复图文消息
 * @Author 25127
 * @Date 2019/9/7 13:10
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class NewsMessage extends RespBaseMessage {
    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<Article> Articles;
}
