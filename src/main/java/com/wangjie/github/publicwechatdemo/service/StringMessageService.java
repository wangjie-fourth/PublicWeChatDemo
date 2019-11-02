package com.wangjie.github.publicwechatdemo.service;

import com.wangjie.github.publicwechatdemo.messagedomain.requset.TextMessageRqeuest;

public interface StringMessageService {
     String handleStringMessage(TextMessageRqeuest textMessageRqeuest);
}
