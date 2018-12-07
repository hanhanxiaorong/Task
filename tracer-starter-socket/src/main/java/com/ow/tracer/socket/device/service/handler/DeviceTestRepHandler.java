package com.ow.tracer.socket.device.service.handler;

import com.ow.tracer.socket.device.common.DevicePacket;
import com.ow.tracer.socket.device.common.intf.AbsDeviceBsHandler;
import com.ow.tracer.socket.device.common.packets.DeviceTestRespBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.utils.json.Json;

/**
 * @author tanyaowu
 * 2017年3月27日 下午9:51:28
 */
public class DeviceTestRepHandler extends AbsDeviceBsHandler<DeviceTestRespBody> {
	private static Logger log = LoggerFactory.getLogger(DeviceTestRepHandler.class);

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @author tanyaowu
	 */
	public DeviceTestRepHandler() {
	}

	/**
	 * @return
	 * @author tanyaowu
	 */
	@Override
	public Class<DeviceTestRespBody> bodyClass() {
		return DeviceTestRespBody.class;
	}

	/**
	 * @param packet
	 * @param bsBody
	 * @param channelContext
	 * @return
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public Object handler(DevicePacket packet, DeviceTestRespBody bsBody, ChannelContext channelContext) throws Exception {
		System.out.println("收到登录响应消息:" + Json.toJson(bsBody));
		return null;
	}
}
