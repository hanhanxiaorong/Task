package com.ow.tracer.socket.write.common.intf;

import com.ow.tracer.socket.write.common.DeviceWritePacket;
import com.ow.tracer.socket.write.common.packets.BaseBody;
import com.ow.tracer.socket.write.service.config.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.utils.json.Json;

/**
 * @auther: Easy
 * @date: 18-12-7 22:53
 * @description:
 */
public abstract class AbsDeviceBsHandler <T extends BaseBody> implements DeviceBsHandlerIntf {
    private static Logger log = LoggerFactory.getLogger(AbsDeviceBsHandler.class);

    /**
     *
     * @author tanyaowu
     */
    public AbsDeviceBsHandler() {
    }
    public abstract Class<T> bodyClass();


    public Object handler(DeviceWritePacket packet, ChannelContext channelContext) throws Exception {
        String jsonStr = null;
        T bsBody = null;
        if (packet.getData() != null&&packet.getType()!=4) {
            jsonStr = new String(packet.getData(), Const.CHARSET);
            System.out.println(jsonStr);
            bsBody = Json.toBean(jsonStr, bodyClass());
        }
        return handler(packet, bsBody, channelContext);
    }

    public abstract Object handler(DeviceWritePacket packet, T bsBody, ChannelContext channelContext) throws Exception;

}
