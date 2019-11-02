package com.wangjie.github.publicwechatdemo.service.impl;

import com.wangjie.github.publicwechatdemo.messagedomain.requset.TextMessageRqeuest;
import com.wangjie.github.publicwechatdemo.service.StringMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName StringMessageServiceImpl
 * @Description
 * @Author 25127
 * @Date 2019/11/2 17:13
 * @Email jie.wang13@hand-china.com
 **/
@Service
@Slf4j
public class StringMessageServiceImpl implements StringMessageService {

    @Override
    public String handleStringMessage(TextMessageRqeuest textMessageRqeuest) {
        char index = textMessageRqeuest.getContent().charAt(0);
        if (index == '1') { // 记录备忘录
            // 需要存储的信息
            String storeMessage = textMessageRqeuest.getContent().substring(1);
            log.info("【{}】用户发送了{}", textMessageRqeuest.getFromUserName(), textMessageRqeuest.getContent());
            // todo：存储到数据库中
            System.out.println("storeMessage = " + storeMessage);

        } else if (index == '2') { // 记录日常花费
            // 需要存储的信息
            String storeMessage = textMessageRqeuest.getContent().substring(1);
            log.info("【{}】用户需要记录【{}】的花费信息", textMessageRqeuest.getFromUserName(), textMessageRqeuest.getContent());
            System.out.println("storeMessage = " + storeMessage);
        }

        return "您已经成功发送了消息";
    }
}
