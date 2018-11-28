package com.ow.tracer.common.cache.listener;

import com.ow.tracer.common.cache.RedisEhcacheCacheManager;
import com.ow.tracer.common.cache.message.CacheMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @auther: Easy
 * @date: 18-11-21 01:00
 * @description:
 */
public class CacheMessageListener implements MessageListener {
    private Logger log = LoggerFactory.getLogger(CacheMessageListener.class);

    private RedisTemplate<Object, Object> redisTemplate;

    private RedisEhcacheCacheManager redisEhcacheCacheManager;

    public CacheMessageListener(RedisTemplate<Object, Object> redisTemplate,
                                RedisEhcacheCacheManager redisEhcacheCacheManager) {
        super();
        this.redisTemplate = redisTemplate;
        this.redisEhcacheCacheManager = redisEhcacheCacheManager;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        CacheMessage cacheMessage = (CacheMessage) redisTemplate.getValueSerializer().deserialize(message.getBody());
        log.debug("recevice a redis topic message, clear local cache, the cacheName is {}, the key is {}", cacheMessage.getCacheName(), cacheMessage.getKey());
        redisEhcacheCacheManager.clearLocal(cacheMessage.getCacheName(), cacheMessage.getKey(), cacheMessage.getSender());
    }

}

