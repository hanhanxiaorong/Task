package com.ow.tracer.socket.device.service;

import com.ow.tracer.socket.server.ShowcaseServerAioHandler;
import com.ow.tracer.socket.server.ShowcaseServerAioListener;
import org.tio.server.ServerGroupContext;
import org.tio.server.TioServer;
import org.tio.server.intf.ServerAioHandler;
import org.tio.server.intf.ServerAioListener;

import java.io.IOException;

/**
 *
 * @author tanyaowu
 * 2017年3月27日 上午12:16:31
 */
public class DeviceServerStarter {
	static ServerAioHandler aioHandler = new ShowcaseServerAioHandler();
	static ServerAioListener aioListener = new ShowcaseServerAioListener();
	static ServerGroupContext serverGroupContext = new ServerGroupContext(aioHandler, aioListener);
	static TioServer tioServer = new TioServer(serverGroupContext); //可以为空

	static String serverIp = null;
	static int serverPort = com.ow.tracer.socket.common.Const.PORT;

	public static void main(String[] args) throws IOException {
		tioServer.start(serverIp, serverPort);
	}
}