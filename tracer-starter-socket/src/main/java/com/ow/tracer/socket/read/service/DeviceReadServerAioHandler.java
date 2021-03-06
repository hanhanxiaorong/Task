package com.ow.tracer.socket.read.service;



import com.ow.tracer.socket.read.common.DeviceAbsAioHandler;
import com.ow.tracer.socket.read.common.DeviceReadPacket;
import com.ow.tracer.socket.read.common.Type;
import com.ow.tracer.socket.read.common.intf.AbsDeviceBsHandler;
import com.ow.tracer.socket.read.service.handler.DeviceTestRepHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioHandler;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tanyaowu
 *
 */
public class DeviceReadServerAioHandler extends DeviceAbsAioHandler implements ServerAioHandler {
	private static Logger log = LoggerFactory.getLogger(DeviceReadServerAioHandler.class);

	private static Map<Short, AbsDeviceBsHandler<?>> handlerMap = new HashMap<>();
	static {
		handlerMap.put(Type.TEST_REQ, new DeviceTestRepHandler());


	}

	/**
	 * 处理消息
	 */
	@Override
	public void handler(Packet packet, ChannelContext channelContext) throws Exception {
		DeviceReadPacket showcasePacket = (DeviceReadPacket) packet;
		int type = showcasePacket.getType();

		AbsDeviceBsHandler<?> showcaseBsHandler = handlerMap.get(type);
		if (showcaseBsHandler == null) {
			log.error("{}, 找不到处理类，type:{}", channelContext, type);
			return;
		}
		showcaseBsHandler.handler(showcasePacket, channelContext);
		return;
	}
}
