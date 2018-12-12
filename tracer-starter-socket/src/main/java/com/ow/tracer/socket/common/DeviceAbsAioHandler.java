package com.ow.tracer.socket.common;

import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.AioHandler;
import org.tio.core.intf.Packet;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @auther: Easy
 * @date: 18-12-8 00:20
 * @description:
 */
public abstract class DeviceAbsAioHandler implements AioHandler {

    @Override
    public DevicePacket decode(ByteBuffer byteBuffer, int limit, int position, int readableLength, ChannelContext channelContext) throws AioDecodeException {
        System.out.println(Arrays.toString(byteBuffer.array()));
        //可读数据，小于头部的固定长度，直接返回null，这样tio框架会自动把本次收到的数据暂存起来，并和下次收到的数据组合起来
        DevicePacket imPacket = new DevicePacket();
        if (readableLength < DevicePacket.HEADER_LENGHT) {
            return null;
        }
        byte [] identifier= new byte[2];
//        short identifier = byteBuffer.getShort();
        byte [] number = new byte[10];
         byteBuffer.get(identifier,0,2);
        if(identifier.length>0){
            System.out.println(identifier);
            imPacket.setIdentifier(identifier);
        }else{
            throw new AioDecodeException("bodyLength [" + identifier + "] is not right, remote:" + channelContext.getClientNode());
        }
       byte version = byteBuffer.get();
        int ip =    byteBuffer.getInt();
        System.out.println(IPv4Util.intToIp(ip));
        byteBuffer.get(number);
        byte length  = byteBuffer.get();
        byte type= byteBuffer.get();
        if (length < 0) {
            throw new AioDecodeException("bodyLength [" + length + "] is not right, remote:" + channelContext.getClientNode());
        }
        int neededLength = DevicePacket.HEADER_LENGHT + length;
        int test = readableLength - neededLength;
        if (test < 0) // 不够消息体长度(剩下的buffe组不了消息体)
        {
            return null;
        } else {
            imPacket.setType(type);
            if (length > 0) {
                byte[] dst = new byte[length];
                byteBuffer.get(dst);
                imPacket.setData(dst);
                imPacket.setNumber(number);
                imPacket.setLenght(length);
                imPacket.setVersion(version);
                imPacket.setIpAddress(IPv4Util.intToIp(ip));
            }

            return imPacket;
        }


    }

    /**
     * 编码：把业务消息包编码为可以发送的ByteBuffer
     * 消息头：type + bodyLength
     * 消息体：byte[]
     */
    @Override
    public ByteBuffer encode(Packet packet, GroupContext groupContext, ChannelContext channelContext) {
        DevicePacket devicePacket = (DevicePacket) packet;
        byte[] body = devicePacket.getData();
        short bodyLen = 0;
        if (body != null) {
            bodyLen = (short) body.length;
        }
        //总长度是消息头的长度+消息体的长度
        int allLen = DevicePacket.HEADER_LENGHT +bodyLen;
        ByteBuffer buffer = ByteBuffer.allocate(allLen);
        buffer.order(groupContext.getByteOrder());
        buffer.put(devicePacket.getIdentifier());
        buffer.put(devicePacket.getVersion());
        buffer.put(IPv4Util.ipToBytesByInet(devicePacket.getIpAddress()));
        if(devicePacket.getNumber()==null){
            byte [] number = {00,00};
            buffer.put(number);
        }else{
            buffer.put(devicePacket.getNumber());
        }
        //写入消息体长度
        buffer.putShort(bodyLen);
        //写入消息类型
        buffer.put(devicePacket.getType());
//		System.out.println(Arrays.toString(buffer.array()));
        //写入消息体
        if (body != null) {
            buffer.put(body);
        }

        return buffer;
    }


}