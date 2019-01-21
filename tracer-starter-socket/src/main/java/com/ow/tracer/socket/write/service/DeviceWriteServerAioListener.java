package com.ow.tracer.socket.write.service;

import com.ow.tracer.socket.write.common.DeviceWritePacket;
import com.ow.tracer.socket.write.common.ShowcaseSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioListener;
import org.tio.utils.json.Json;

/**
 * @author tanyaowu
 * 2017年3月26日 下午8:22:31
 */
public class DeviceWriteServerAioListener implements ServerAioListener {
	private static Logger log = LoggerFactory.getLogger(DeviceWriteServerAioListener.class);

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
	public DeviceWriteServerAioListener() {
	}



	/**
	 * @param channelContext
	 * @param isConnected
	 * @param isReconnect
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect) throws Exception {
		log.info("onAfterConnected channelContext:{}, isConnected:{}, isReconnect:{}", channelContext, isConnected, isReconnect);

		channelContext.setAttribute(new ShowcaseSessionContext());
		//连接后，需要把连接会话对象设置给channelContext
		Tio.bindBsId(channelContext, "123");
		ShowcaseSessionContext showcaseSessionContext = (ShowcaseSessionContext) channelContext.getAttribute();
		showcaseSessionContext.setUserid("123");

		DeviceWritePacket deviceReadPacket = new DeviceWritePacket();
		byte [] d={-1,-1};
		byte [] number={1,1,1,1,1,1,1,1,1,1};
		byte [] datas={1,1,1,1,1,1,1,1,1,1};

		deviceReadPacket.setIdentifier(d);
		deviceReadPacket.setVersion((byte)1);
		deviceReadPacket.setNumber(number);
		deviceReadPacket.setIpAddress("192.168.2.188");
		deviceReadPacket.setType((byte)1);
		deviceReadPacket.setData(datas);
		Tio.sendToId(channelContext.groupContext,"123",deviceReadPacket);

	}



	/**
	 * @param channelContext
	 * @param packet
	 * @param isSentSuccess
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess) throws Exception {
		log.info("onAfterSent channelContext:{}, packet:{}, isSentSuccess:{}", channelContext, Json.toJson(packet), isSentSuccess);
	}

	@Override
	public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String remark, boolean isRemove) {
	}

	/** 
	 * @param channelContext
	 * @param packet
	 * @param packetSize
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize) throws Exception {
	}

	/** 
	 * @param channelContext
	 * @param receivedBytes
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes) throws Exception {
	}

	/** 
	 * @param channelContext
	 * @param packet
	 * @param cost
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public void onAfterHandled(ChannelContext channelContext, Packet packet, long cost) throws Exception {
	}
}
