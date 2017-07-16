package com.github.user.service.stream.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 用户日志消息通道绑定
 */
public interface UserLogBinding {

    String CHANNEL_NAME = "user_log";

    @Input(CHANNEL_NAME)
    SubscribableChannel channel();
}
