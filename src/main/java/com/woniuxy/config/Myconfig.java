package com.woniuxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;


@Configuration
public class Myconfig {
    @Bean
    public RedisTemplate<Object,Object> rt (RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Object> rt = new RedisTemplate();
        rt.setConnectionFactory(redisConnectionFactory);
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer= new GenericJackson2JsonRedisSerializer();
        rt.setKeySerializer(genericJackson2JsonRedisSerializer);
        rt.setValueSerializer(genericJackson2JsonRedisSerializer);
        rt.setHashKeySerializer(genericJackson2JsonRedisSerializer);
        rt.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        //使用redis事务
        rt.setEnableTransactionSupport(true);
        return rt;
    }


}
