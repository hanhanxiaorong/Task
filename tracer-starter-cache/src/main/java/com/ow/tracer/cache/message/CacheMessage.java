package com.ow.tracer.cache.message;

import java.io.Serializable;

/**
 * @auther: Easy
 * @date: 18-11-21 00:59
 * @description:
 */
public class CacheMessage implements Serializable {

    private static final long serialVersionUID = 5987219310442078193L;

    private String cacheName;

    private Object key;

    private Integer sender;

    public CacheMessage(String cacheName, Object key) {
        super();
        this.cacheName = cacheName;
        this.key = key;
    }

    public CacheMessage(String cacheName, Object key, Integer sender) {
        super();
        this.cacheName = cacheName;
        this.key = key;
        this.sender = sender;
    }

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }
}
