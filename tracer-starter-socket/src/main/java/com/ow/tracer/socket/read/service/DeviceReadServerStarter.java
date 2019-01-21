package com.ow.tracer.socket.read.service;


import com.ow.tracer.socket.read.service.config.Const;
import org.tio.server.ServerGroupContext;
import org.tio.server.TioServer;

import java.io.IOException;

/**
 *
 * @author tanyaowu
 * 2017年3月27日 上午12:16:31
 */
public class DeviceReadServerStarter {
	static DeviceReadServerAioHandler aioHandler = new DeviceReadServerAioHandler();
	static DeviceReadServerAioListener aioListener = new DeviceReadServerAioListener();
	static ServerGroupContext serverGroupContext = new ServerGroupContext(aioHandler, aioListener);
	static TioServer tioServer = new TioServer(serverGroupContext); //可以为空
	static String serverIp = null;
	static int serverPort = Const.PORT;

	public static void main(String[] args) throws IOException {
		tioServer.start(serverIp, serverPort);
	}
}