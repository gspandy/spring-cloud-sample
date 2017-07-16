package com.github.user.service.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Redis配置
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    RedisTemplate<?, ?> redisTemplate() {
        final RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new RedisSerializer<String>() {
            @Override
            public byte[] serialize(String t) throws SerializationException {
                return ("user_" + t).getBytes();
            }
            @Override
            public String deserialize(byte[] bytes) throws SerializationException {
                return new String(bytes).substring(5);
            }
        });
        redisTemplate.setValueSerializer(new RedisSerializer<Object>() {
            @Override
            public byte[] serialize(Object t) throws SerializationException {
                JSONObject json = (JSONObject) JSON.toJSON(t);
                json.put("@@classname", t.getClass().getName());
                return json.toJSONString().getBytes();
            }
            @Override
            public Object deserialize(byte[] bytes) throws SerializationException {
                if (bytes == null) {
                    return null;
                }
                JSONObject json = JSON.parseObject(new String(bytes));
                try {
                    return JSON.parseObject(json.toJSONString(), Class.forName(json.getString("@@classname")));
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return redisTemplate;
    }
}
