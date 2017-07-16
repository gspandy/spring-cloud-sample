package com.github.user.service.stream.consumer;

import com.github.user.service.entity.Log;
import com.github.user.service.repository.LogRepository;
import com.github.user.service.stream.binding.UserLogBinding;
import com.github.user.service.stream.message.UserLogMessage;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.validation.annotation.Validated;

/**
 * 用户日志消费者
 */
@EnableBinding(UserLogBinding.class)
class UserLogConsumer {

    @Autowired
    private LogRepository logRepository;

    @StreamListener(UserLogBinding.CHANNEL_NAME)
    void consume(@Validated UserLogMessage message) {
        try {
            if (logRepository.getByLogId(message.getLogId()) == null) {
                Log log = new Log();
                BeanUtils.copyProperties(message, log);
                logRepository.create(log);
            }
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
