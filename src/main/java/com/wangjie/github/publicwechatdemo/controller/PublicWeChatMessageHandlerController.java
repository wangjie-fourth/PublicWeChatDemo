package com.wangjie.github.publicwechatdemo.controller;

import com.wangjie.github.publicwechatdemo.service.impl.CoreMessageHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName PublicWeChatMessageHandlerController
 * @Description 接收用户向微信公众号发送的消息
 * @Author 25127
 * @Date 2019/11/2 12:30
 * @Email jie.wang13@hand-china.com
 **/
@RestController
@Slf4j
public class PublicWeChatMessageHandlerController {

    /**
     * 处理微信服务器发来的消息
     *
     * @param request  http请求
     * @param response http响应
     * @throws IOException  IO异常
     */
    @PostMapping("/verification")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 消息的接收、处理、响应
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respXml = CoreMessageHandlerService.processRequest(request);

        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respXml);
        out.close();
    }

}
