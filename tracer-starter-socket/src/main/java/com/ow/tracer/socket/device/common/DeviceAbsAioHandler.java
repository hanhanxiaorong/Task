package com.ow.tracer.socket.device.common;

import cn.hutool.core.convert.Convert;
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
        System.out.println(Arrays.toString(byteBuffer.array()));
        //可读数据，小于头部的固定长度，直接返回null，这样tio框架会自动把本次收到的数据暂存起来，并和下次收到的数据组合起来
        DevicePacket imPacket = new DevicePacket();
        if (readableLength < DevicePacket.HEADER_LENGHT) {
            return null;
        }
        byte [] identifier= new byte[2];
        byte [] version= new byte[2];
        byte [] ipaddress= new byte[4];
        byte [] number = new byte[10];
        byteBuffer.get(identifier,0,2);
        if(identifier.length>0){
            imPacket.setIdentifier(identifier);
        }else{
            throw new AioDecodeException("bodyLength [" + identifier + "] is not right, remote:" + channelContext.getClientNode());
        }
        byteBuffer.get(version);
        byteBuffer.get(ipaddress);
        byteBuffer.get(number);
        byte l1  = byteBuffer.get();
        byte l2  = byteBuffer.get();
        int length = l1+l2;
        byte t1 = byteBuffer.get();
        byte t2 = byteBuffer.get();
        int type = t1+t2;
        if (length < 0) {
            throw new AioDecodeException("bodyLength [" + length + "] is not right, remote:" + channelContext.getClientNode());
        }
        int neededLength = DevicePacket.HEADER_LENGHT + length;
        int test = readableLength - neededLength;
        System.out.println("取到消息总长度="+readableLength+",消息中长度标识传输的位数为"+length+",+消息头+表示位数="+neededLength+";");

        if (test < 0) // 不够消息体长度(剩下的buffe组不了消息体)
        {
            System.out.println("消息长度不够");
            return null;
        } else {
            imPacket.setType((short) type);
            if (length > 0) {
                byte[] dst = new byte[length];
                byteBuffer.get(dst);
                imPacket.setData(dst);
                imPacket.setNumber(number);
                imPacket.setLenght((short)length);
                imPacket.setVersion(version);
                imPacket.setIpAddress(ipaddress);


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
        buffer.put(devicePacket.getIpAddress());
        if(devicePacket.getNumber()==null){
            byte [] number = {00,00};
            buffer.put(number);
        }else{
            buffer.put(devicePacket.getNumber());
        }
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
