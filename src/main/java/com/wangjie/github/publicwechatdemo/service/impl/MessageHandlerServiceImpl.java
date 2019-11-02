package com.wangjie.github.publicwechatdemo.service.impl;

import com.wangjie.github.publicwechatdemo.service.MessageHandlerService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName MessageHandlerServiceImpl
 * @Description
 * @Author 25127
 * @Date 2019/11/2 13:08
 * @Email jie.wang13@hand-china.com
 **/
@Service
public class MessageHandlerServiceImpl implements MessageHandlerService {

    /**
     * 处理文字消息
     *
     * @param request   http请求
     * @return          返回返回给前端的参数
     */
    @Override
    public String handlerString(HttpServletRequest request) {
        return null;
    }
}
