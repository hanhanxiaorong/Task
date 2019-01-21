package com.ow.tracer.shop.store.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [实体类]
 * Date:        [2019-01-09 18:27:32]
 * Coder:       [江雪立]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("store_uas_time")
public class StoreUasTime extends BaseDTO<StoreUasTime> {

    /**店铺ID*/
    private String storeId;

    /**增值业务*/
    private String uasId;

    /**开始时间*/
    private Date startTime;

    /**到期时间*/
    private Date endTime;

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUasId() {
        return this.uasId;
    }

    public void setUasId(String uasId) {
        this.uasId = uasId;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("StoreUasTime{\n");
        strBuf.append("storeId:").append(this.storeId).append(",\n");
        strBuf.append("uasId:").append(this.uasId).append(",\n");
        strBuf.append("startTime:").append(this.startTime).append(",\n");
        strBuf.append("endTime:").append(this.endTime).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
