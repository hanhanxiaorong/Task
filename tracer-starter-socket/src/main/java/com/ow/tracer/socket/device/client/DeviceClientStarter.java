package com.ow.tracer.socket.device.client;

import com.ow.tracer.socket.client.ShowcaseClientAioHandler;
import com.ow.tracer.socket.client.ShowcaseClientAioListener;
import com.ow.tracer.socket.common.Const;
import com.ow.tracer.socket.common.ShowcasePacket;
import com.ow.tracer.socket.common.Type;
import com.ow.tracer.socket.common.packets.*;
import com.ow.tracer.socket.device.common.DevicePacket;
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

	private static ClientAioHandler tioClientHandler = new ShowcaseClientAioHandler();
	private static ClientAioListener aioListener = new ShowcaseClientAioListener();
	private static ClientGroupContext clientGroupContext = new ClientGroupContext(tioClientHandler, aioListener, reconnConf);

	private static TioClient tioClient = null;

	static ClientChannelContext clientChannelContext;



	public static void main(String[] args) throws Exception {
		tioClient = new TioClient(clientGroupContext);
		clientChannelContext = tioClient.connect(serverNode);
		processCommand();
	}

	public static void processCommand() throws Exception {


			HardwareDerReqBody hardwareReqBody = new HardwareDerReqBody();
			byte [] number = new byte[10];
			short identifiter =(short) 255255;
		short version =(short) 1101111;

		hardwareReqBody.setName("12345");
			DevicePacket reqPacket = new DevicePacket();
			reqPacket.setType(Type.LOGIN_REQ);
			reqPacket.setNumber(number);
		    reqPacket.setIpAddress(1921681122);
		    reqPacket.setIdentifier(identifiter);
			reqPacket.setVersion(version);
			reqPacket.setData(Json.toJson(hardwareReqBody).getBytes(DevicePacket.CHARSET));
			Tio.send(clientChannelContext, reqPacket);


	}
}
