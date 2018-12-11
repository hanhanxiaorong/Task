package com.ow.tracer.socket.device.client;

import cn.hutool.core.convert.Convert;
import com.ow.tracer.socket.client.ShowcaseClientAioListener;
import com.ow.tracer.socket.common.Const;
import com.ow.tracer.socket.common.ShowcasePacket;
import com.ow.tracer.socket.common.Type;
import com.ow.tracer.socket.common.packets.*;
import com.ow.tracer.socket.device.common.DevicePacket;
import com.ow.tracer.socket.device.common.packets.DeviceTestReqBody;
import com.ow.tracer.socket.device.common.packets.HardwareDerReqBody;
import org.tio.client.ClientChannelContext;
import org.tio.client.ClientGroupContext;
import org.tio.client.ReconnConf;
import org.tio.client.TioClient;
import org.tio.client.intf.ClientAioHandler;
import org.tio.client.intf.ClientAioListener;
import org.tio.core.Node;
import org.tio.core.Tio;
import org.tio.utils.json.Json;

import java.util.Arrays;

/**
 *
 * @author tanyaowu
 */
public class DeviceClientStarter {
	static String serverIp = "127.0.0.1";
	static int serverPort = Const.PORT;

	private static Node serverNode = new Node(serverIp, serverPort);

	//用来自动连接的，不想自动连接请设为null
	private static ReconnConf reconnConf = new ReconnConf(5000L);

	private static ClientAioHandler tioClientHandler = new DeviceClientAioHandler();
	private static ClientAioListener aioListener = new DeviceClientAioListener();
	private static ClientGroupContext clientGroupContext = new ClientGroupContext(tioClientHandler, aioListener, reconnConf);

	private static TioClient tioClient = null;

	static ClientChannelContext clientChannelContext;



	public static void main(String[] args) throws Exception {
		tioClient = new TioClient(clientGroupContext);
		clientChannelContext = tioClient.connect(serverNode);
		processCommand();
	}

	public static void processCommand() throws Exception {

			DeviceTestReqBody hardwareReqBody = new DeviceTestReqBody();
			short identifiter =(short) 255;
			byte [] iden = {-1,-1};
			byte [] version = {01,00};
			byte [] number={01,01,01,01,01,01,01,01,02,03};
			int [] ip = {192,168,0,1};
			Byte[] ipaddress = Convert.toByteArray(ip);
			hardwareReqBody.setLoginname("12345");
			hardwareReqBody.setPassword("45684");
			DevicePacket reqPacket = new DevicePacket();
			reqPacket.setType(Type.HARDWARE);
		    reqPacket.setIpAddress(toPrimitives(ipaddress));
		    reqPacket.setIdentifier(iden);
			reqPacket.setVersion(version);
			reqPacket.setNumber(number);
			reqPacket.setData(Json.toJson(hardwareReqBody).getBytes(DevicePacket.CHARSET));
			Tio.send(clientChannelContext, reqPacket);


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
