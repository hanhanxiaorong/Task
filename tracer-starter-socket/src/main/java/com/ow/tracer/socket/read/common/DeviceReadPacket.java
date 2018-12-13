package com.ow.tracer.socket.read.common;

import org.tio.core.intf.Packet;

/**
 * @auther: Easy
 * @date: 18-12-7 21:36
 * @description:
 */
public class DeviceReadPacket extends Packet {

    public static final long serialVersionUID = -5481926483435771100L;
    public static final int HEADER_LENGHT = 19;
    public static final String CHARSET = "utf-8";
    //数组头
    private byte[] identifier;//2
    private byte  version;//2
    private String  ipAddress;//4
    private byte[] number;//10
    private byte lenght;//2
    private byte type;//2

    private byte[]data;//

    public DeviceReadPacket() {
        super();

    }

    public DeviceReadPacket(byte[] identifier, byte  version, String ipAddress, byte[] number, byte lenght, byte type, byte[] data) {
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

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public byte[] getNumber() {
        return number;
    }

    public void setNumber(byte[] number) {
        this.number = number;
    }

    public byte getLenght() {
        return lenght;
    }

    public void setLenght(byte lenght) {
        this.lenght = lenght;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
