package com.ow.tracer.socket.read.common.intf;

import com.ow.tracer.socket.read.common.DeviceReadPacket;
import org.tio.core.ChannelContext;

/**
 * @auther: 硬件通道业务处理
 * @date: 18-12-7 21:32
 * @description:根据指令类型，判断指令由谁执行
 */
public interface DeviceBsHandlerIntf {

    public Object handler(DeviceReadPacket deviceReadPacket, ChannelContext channelContext) throws Exception;
}
