package com.ow.tracer.socket.device.common;

import org.tio.core.intf.Packet;

/**
 * @auther: Easy
 * @date: 18-12-7 21:36
 * @description:
 */
public class DevicePacket  extends Packet {

    public static final long serialVersionUID = -5481926483435771100L;
    public static final int HEADER_LENGHT = 20;
    public static final String CHARSET = "utf-8";

    //数组头
    private short identifier;//2
    private short version;//2
    private int ipAddress;//4
    private byte[] number;//10
    private short lenght;//2
    private short type;//2

    private byte[]data;//

    public DevicePacket() {
        super();

    }
    public DevicePacket(short type,byte [] data) {
        super();
        this.type = type;
        this.data = data;
    }


    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public short getIdentifier() {
        return identifier;
    }

    public void setIdentifier(short identifier) {
        this.identifier = identifier;
    }

    public short getVersion() {
        return version;
    }

    public void setVersion(short version) {
        this.version = version;
    }

    public int getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(int ipAddress) {
        this.ipAddress = ipAddress;
    }

    public byte[] getNumber() {
        return number;
    }

    public void setNumber(byte[] number) {
        this.number = number;
    }

    public short getLenght() {
        return lenght;
    }

    public void setLenght(short lenght) {
        this.lenght = lenght;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


}
