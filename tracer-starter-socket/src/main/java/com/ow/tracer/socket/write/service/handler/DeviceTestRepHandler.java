package com.ow.tracer.socket.write.service.handler;


import com.ow.tracer.socket.write.common.DeviceWritePacket;
import com.ow.tracer.socket.write.common.intf.AbsDeviceBsHandler;
import com.ow.tracer.socket.write.common.packets.DeviceTestReqBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;

/**
 * @author tanyaowu
 * 2017年3月27日 下午9:51:28
 */
public class DeviceTestRepHandler extends AbsDeviceBsHandler<DeviceTestReqBody> {
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
	public Class<DeviceTestReqBody> bodyClass() {
		return DeviceTestReqBody.class;
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
	public Object handler(DeviceWritePacket packet, DeviceTestReqBody bsBody, ChannelContext channelContext) throws Exception {
		//心跳消息,啥也不用做
		return null;
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
