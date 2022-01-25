package com.fumanix.framework.leaf;

import com.fumanix.framework.leaf.support.RedisRepository;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @create: 2021-07-28 15:57
 */
@Configuration
@AutoConfigureBefore(RedisAutoConfiguration.class)
public class LeafAutoConfiguration {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 配置
     *
     * @return
     */
    @Bean
    RedisRepository redisRepository() {
        RedisRepository redisRepository = new RedisRepository();
        redisRepository.setRedisTemplate(stringRedisTemplate);
        return redisRepository;
    }
}
