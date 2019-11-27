package com.wangjie.github.publicwechatdemo.controller;

import com.wangjie.github.publicwechatdemo.domain.TextMessage;
import com.wangjie.github.publicwechatdemo.utils.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName PublicWeChatMessageHandlerController
 * @Description 接收用户向微信公众号发送的消息
 * @Author 25127
 * @Date 2019/11/2 12:30
 * @Email jie.wang13@hand-china.com
 **/
@Slf4j
@Controller
public class PublicWeChatMessageHandlerController {

//    @Autowired
//    private CoreMessageHandlerService coreMessageHandlerService;

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

        // 调用核心业务类接收消息、处理消息：目前只接受文本处理
        String respXml = processRequest(request);;

        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respXml);
        out.close();
    }

    /**
     * 处理微信发来的请求
     * @param request
     * @return xml
     */
    public static String processRequest(HttpServletRequest request) {
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXml(request);

            // 发送方帐号
            String fromUserName = requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respContent = "您发送的是文本消息！";
            }
            // 设置文本消息的内容
            textMessage.setContent(respContent);
            // 将文本消息对象转换成xml
            respXml = MessageUtil.messageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }


}
