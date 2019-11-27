package com.wangjie.github.publicwechatdemo;

import com.wangjie.github.publicwechatdemo.utils.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class PublicWeChatDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicWeChatDemoApplication.class, args);
    }

    /**
     * 用于验证微信公众号的接口配置消息 ： URL 、token
     *
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return 验证成功，返回echostr；否则返回null
     */
    @GetMapping("/verification")
    public String verificationWeChat(
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam("echostr") String echostr
    ) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            log.info("验证信息成功");
            return echostr;
        }
        log.info("验证信息失败");
        return null;
    }

}
