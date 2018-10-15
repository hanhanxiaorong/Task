package com.ow.tracer.core.base;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Auther: Easy
 * @Date: 18-9-6 17:45
 * @Description:通用Service，可以自定义服务
 */
public interface BaseService<T>extends IService <T>{
    //这里可以定义通用的service方法
}
