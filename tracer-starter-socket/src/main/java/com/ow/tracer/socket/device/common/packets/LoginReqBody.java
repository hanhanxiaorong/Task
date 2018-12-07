package com.ow.tracer.socket.device.common.packets;

import com.ow.tracer.socket.common.packets.BaseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 登录请求
 * @author tanyaowu
 * 2017年3月25日 上午8:22:06
 */
public class LoginReqBody extends BaseBody {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(LoginReqBody.class);

	/**
	 * @param args
	 *
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}
String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
