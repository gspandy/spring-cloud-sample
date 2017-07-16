package com.github.user.service.stream.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 用户日志消息通道绑定（生产者）
 */
public interface UserLogProducerBinding {

    String CHANNEL_NAME = "user_log_producer";

    @Output(CHANNEL_NAME)
    MessageChannel channel();
}
