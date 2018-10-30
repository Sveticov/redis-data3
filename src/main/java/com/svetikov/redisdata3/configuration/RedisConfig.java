package com.svetikov.redisdata3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
@ComponentScan("com.svetikov.redisdata3")
public class RedisConfig {

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory(){
//      //  RedisStandaloneConfiguration configuration=new RedisStandaloneConfiguration("server",6379);
//       // return new JedisConnectionFactory(configuration);
//        return new JedisConnectionFactory();
//    }
    @Bean
    LettuceConnectionFactory jedisConnectionFactory(){
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost",6379));
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate(){
        final RedisTemplate<String,Object> template=new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }
}
