package com.ow.tracer.socket.read.common;

/**
 * 消息类型定义
 * @author tanyaowu
 * 2017年3月26日 下午8:18:13
 */
public interface Type {

	/**
	 * 登录消息请求
	 */
	short TEST_REQ = 4;
	/**
	 * 登录消息响应
	 */
	short TEST_RESP = 2;

	/**
	 * 心跳消息请求
	 */
	short HERAT_REQ = 99;
}
