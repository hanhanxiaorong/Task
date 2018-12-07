package com.ow.tracer.socket.device.common.packets;

import com.ow.tracer.socket.common.packets.BaseBody;

/**
 * @auther: Easy
 * @date: 18-12-7 18:30
 * @description:
 */
public class HardwareDerReqBody {
    String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
