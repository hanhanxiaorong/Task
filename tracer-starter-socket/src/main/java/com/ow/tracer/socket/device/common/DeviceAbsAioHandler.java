package com.ow.tracer.socket.device.common;

import com.ow.tracer.socket.common.ShowcasePacket;
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
        //可读数据，小于头部的固定长度，直接返回null，这样tio框架会自动把本次收到的数据暂存起来，并和下次收到的数据组合起来
        DevicePacket imPacket = new DevicePacket();

        if (readableLength < DevicePacket.HEADER_LENGHT) {
            return null;
        }
        short identifier = byteBuffer.getShort();
        if(identifier<0){
            imPacket.setIdentifier(identifier);
        }else{
            throw new AioDecodeException("bodyLength [" + identifier + "] is not right, remote:" + channelContext.getClientNode());
        }

        short version = byteBuffer.getShort();
        int ip = byteBuffer.getInt();
        byte [] number = new byte[10];
        byteBuffer.get(number,6,16);
        short length = byteBuffer.getShort();
        short type = byteBuffer.getShort();
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
                imPacket.setIpAddress(ip);
                imPacket.setNumber(number);
                imPacket.setLenght(length);
                imPacket.setType(type);

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

        buffer.putShort(devicePacket.getIdentifier());
        buffer.putShort(devicePacket.getVersion());
        buffer.putInt(devicePacket.getIpAddress());
        buffer.put(devicePacket.getNumber());
        //写入消息体长度
        buffer.putShort(bodyLen);
        //写入消息类型

        buffer.putShort(devicePacket.getType());
//		System.out.println(Arrays.toString(buffer.array()));
        //写入消息体
        if (body != null) {
            buffer.put(body);
        }
        System.out.println(Arrays.toString(buffer.array()));

        return buffer;
    }


}
