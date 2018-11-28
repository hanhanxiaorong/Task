package com.ow.tracer.common.config;

import cn.hutool.json.JSONUtil;
import com.ow.tracer.common.cache.RedisEhcacheCacheManager;
import com.ow.tracer.common.cache.listener.CacheMessageListener;
import com.ow.tracer.common.cache.properties.RedisEhcacheProperties;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.*;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.lang.reflect.Method;

/**
 * @auther: Easy
 * @date: 18-11-21 01:04
 * @description:
 */
@Configuration
@ConditionalOnClass({CacheConfig.class})
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(RedisEhcacheProperties.class)
public class CacheRedisEhcacheAutoConfiguration extends CachingConfigurerSupport{

    @Autowired
    private RedisEhcacheProperties redisEhcacheProperties;

    @Bean
    public RedisEhcacheCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        System.out.println("执行了456456454");
        return new RedisEhcacheCacheManager(redisEhcacheProperties, redisTemplate);
    }

    @Bean
    @ConditionalOnBean(RedisEhcacheCacheManager.class)
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisTemplate<Object, Object> redisTemplate,
                                                                       RedisEhcacheCacheManager redisEhcacheCacheManager) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisTemplate.getConnectionFactory());
        CacheMessageListener cacheMessageListener = new CacheMessageListener(redisTemplate, redisEhcacheCacheManager);
        redisMessageListenerContainer.addMessageListener(cacheMessageListener, new ChannelTopic(redisEhcacheProperties.getRedis().getTopic()));
        return redisMessageListenerContainer;
    }
    String prefix = "Tracer:M:";

    public CacheRedisEhcacheAutoConfiguration() {
    }

    @Bean
    public KeyGenerator caChekeyGenerator() {
        return new KeyGenerator() {
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder(CacheRedisEhcacheAutoConfiguration.this.prefix);
                CacheConfig cacheConfig = (CacheConfig)o.getClass().getAnnotation(CacheConfig.class);
                Cacheable cacheable = (Cacheable)method.getAnnotation(Cacheable.class);
                CachePut cachePut = (CachePut)method.getAnnotation(CachePut.class);
                CacheEvict cacheEvict = (CacheEvict)method.getAnnotation(CacheEvict.class);
                String[] cacheNames;
                if (cacheable != null) {
                    cacheNames = cacheable.value();
                    if (ArrayUtils.isNotEmpty(cacheNames)) {
                        sb.append(cacheNames[0]);
                    }
                } else if (cachePut != null) {
                    cacheNames = cachePut.value();
                    if (ArrayUtils.isNotEmpty(cacheNames)) {
                        sb.append(cacheNames[0]);
                    }
                } else if (cacheEvict != null) {
                    cacheNames = cacheEvict.value();
                    if (ArrayUtils.isNotEmpty(cacheNames)) {
                        sb.append(cacheNames[0]);
                    }
                }

                if (cacheConfig != null && sb.toString().equals(CacheRedisEhcacheAutoConfiguration.this.prefix)) {
                    cacheNames = cacheConfig.cacheNames();
                    if (ArrayUtils.isNotEmpty(cacheNames)) {
                        sb.append(cacheNames[0]);
                    }
                }

                if (sb.toString().equals(CacheRedisEhcacheAutoConfiguration.this.prefix)) {
                    sb.append(o.getClass().getName()).append(".").append(method.getName());
                }

                sb.append(":");
                if (objects != null) {
                    Object[] var13 = objects;
                    int var10 = objects.length;

                    for(int var11 = 0; var11 < var10; ++var11) {
                        Object object = var13[var11];
                        sb.append(JSONUtil.toJsonStr(object));
                    }
                }
                System.out.println(sb.toString());
                return sb.toString();
            }
        };
    }
}
