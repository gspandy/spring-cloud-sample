package com.github.user.service.stream.producer;

import com.github.user.service.stream.binding.UserLogProducerBinding;
import com.github.user.service.stream.message.UserLogMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(UserLogProducerBinding.class)
public class UserLogProducer {

    @Autowired
    private UserLogProducerBinding binding;

    public void produce(UserLogMessage message) {
        binding.channel().send(MessageBuilder.withPayload(message).build());
    }
}
