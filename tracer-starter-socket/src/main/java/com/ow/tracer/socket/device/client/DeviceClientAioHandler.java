package com.ow.tracer.socket.device.client;

import cn.hutool.core.convert.Convert;
import com.ow.tracer.socket.client.handler.GroupMsgRespHandler;
import com.ow.tracer.socket.client.handler.JoinGroupRespHandler;
import com.ow.tracer.socket.client.handler.LoginRespHandler;
import com.ow.tracer.socket.client.handler.P2PRespHandler;
import com.ow.tracer.socket.common.ShowcaseAbsAioHandler;
import com.ow.tracer.socket.common.ShowcasePacket;
import com.ow.tracer.socket.common.intf.AbsShowcaseBsHandler;
import com.ow.tracer.socket.device.client.handler.DeviceTestRespHandler;
import com.ow.tracer.socket.device.common.DeviceAbsAioHandler;
import com.ow.tracer.socket.device.common.DevicePacket;
import com.ow.tracer.socket.device.common.Type;
import com.ow.tracer.socket.device.common.intf.AbsDeviceBsHandler;
import org.tio.client.intf.ClientAioHandler;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.utils.json.Json;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tanyaowu
 * 2017年3月27日 上午12:18:11
 */
public class DeviceClientAioHandler extends DeviceAbsAioHandler implements ClientAioHandler {

	private static Map<Short, AbsDeviceBsHandler<?>> handlerMap = new HashMap<>();
	static {
		handlerMap.put(Type.TEST_REQ, new DeviceTestRespHandler());

	}


	/**
	 * 处理消息
	 */
	@Override
	public void handler(Packet packet, ChannelContext channelContext) throws Exception {
		DevicePacket devicePacket = (DevicePacket) packet;
		short type = devicePacket.getType();
		System.out.println("消息处理"+type);
		AbsDeviceBsHandler<?> showcaseBsHandler = handlerMap.get(type);
		showcaseBsHandler.handler(devicePacket, channelContext);
		return;
	}

	/**
	 * 此方法如果返回null，框架层面则不会发心跳；如果返回非null，框架层面会定时发本方法返回的消息包
	 */
	@Override
	public DevicePacket heartbeatPacket() {
		DevicePacket devicePacket = new DevicePacket();
		byte [] data= {0,0};
		short identifiter =(short) 255;
		byte [] iden = {-1,-1};
		byte [] version = {01,00};
		byte [] number={01,01,01,01,01,01,01,01,02,03};
		int [] ip = {192,168,0,1};
		Byte[] ipaddress = Convert.toByteArray(ip);
		DevicePacket reqPacket = new DevicePacket();
		reqPacket.setType(com.ow.tracer.socket.common.Type.HEART_BEAT_REQ);
		reqPacket.setIpAddress(toPrimitives(ipaddress));
		reqPacket.setIdentifier(iden);
		reqPacket.setVersion(version);
		reqPacket.setNumber(number);
		reqPacket.setData(data);
		return reqPacket;
	}
	public static	byte[] toPrimitives(Byte[] oBytes)
	{
		byte[] bytes = new byte[oBytes.length];

		for(int i = 0; i < oBytes.length; i++) {
			bytes[i] = oBytes[i];
		}

		return bytes;
	}
}
