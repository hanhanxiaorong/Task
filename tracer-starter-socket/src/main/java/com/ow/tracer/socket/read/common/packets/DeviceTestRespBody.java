package com.ow.tracer.socket.read.common.packets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 登录响应
 * @author tanyaowu
 * 2017年3月25日 上午8:39:02
 */
public class DeviceTestRespBody extends BaseBody {
	public static interface Code {
		Integer SUCCESS = 1;
		Integer FAIL = 2;
	}

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(DeviceTestRespBody.class);

	/**
	 * @param args
	 *
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	private Integer code;

	private String msg;

	/**
	 *
	 * @author tanyaowu
	 */
	public DeviceTestRespBody() {

	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}



	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
