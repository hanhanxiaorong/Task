package com.ow.tracer.socket.device.common;

import org.tio.core.intf.Packet;

/**
 * @auther: Easy
 * @date: 18-12-7 21:36
 * @description:
 */
public class DevicePacket  extends Packet {

    public static final long serialVersionUID = -5481926483435771100L;
    public static final int HEADER_LENGHT = 22;
    public static final String CHARSET = "utf-8";
    //数组头
    private byte[] identifier;//2
    private byte[] version;//2
    private byte[]  ipAddress;//4
    private byte[] number;//10
    private short lenght;//2
    private short type;//2

    private byte[]data;//

    public DevicePacket() {
        super();

    }

    public DevicePacket(byte[] identifier, byte[] version, byte[] ipAddress, byte[] number, short lenght, short type, byte[] data) {
        this.identifier = identifier;
        this.version = version;
        this.ipAddress = ipAddress;
        this.number = number;
        this.lenght = lenght;
        this.type = type;
        this.data = data;
    }

    public byte[] getIdentifier() {
        return identifier;
    }

    public void setIdentifier(byte[] identifier) {
        this.identifier = identifier;
    }

    public byte[] getVersion() {
        return version;
    }

    public void setVersion(byte[] version) {
        this.version = version;
    }

    public byte[] getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(byte[] ipAddress) {
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

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
