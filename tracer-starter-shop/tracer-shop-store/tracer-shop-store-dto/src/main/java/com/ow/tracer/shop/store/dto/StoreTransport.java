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
  @TableName("store_transport")
public class StoreTransport extends BaseDTO<StoreTransport> {

    /**快递类型*/
    private int transportFeeType;

    /**正常计费范围*/
    private int freightInitWeight;

    /**单价运费*/
    private double transportFee;

    private String storeId;

    /**超出*/
    private int beyond;

    /**超出费用*/
    private double beyondFee;

    private String areaId;

    /**运费类型（0：默认运费1：指定运费）*/
    private int freightType;

    public int getTransportFeeType() {
        return this.transportFeeType;
    }

    public void setTransportFeeType(int transportFeeType) {
        this.transportFeeType = transportFeeType;
    }

    public int getFreightInitWeight() {
        return this.freightInitWeight;
    }

    public void setFreightInitWeight(int freightInitWeight) {
        this.freightInitWeight = freightInitWeight;
    }

    public double getTransportFee() {
        return this.transportFee;
    }

    public void setTransportFee(double transportFee) {
        this.transportFee = transportFee;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public int getBeyond() {
        return this.beyond;
    }

    public void setBeyond(int beyond) {
        this.beyond = beyond;
    }

    public double getBeyondFee() {
        return this.beyondFee;
    }

    public void setBeyondFee(double beyondFee) {
        this.beyondFee = beyondFee;
    }

    public String getAreaId() {
        return this.areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public int getFreightType() {
        return this.freightType;
    }

    public void setFreightType(int freightType) {
        this.freightType = freightType;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("StoreTransport{\n");
        strBuf.append("transportFeeType:").append(this.transportFeeType).append(",\n");
        strBuf.append("freightInitWeight:").append(this.freightInitWeight).append(",\n");
        strBuf.append("transportFee:").append(this.transportFee).append(",\n");
        strBuf.append("storeId:").append(this.storeId).append(",\n");
        strBuf.append("beyond:").append(this.beyond).append(",\n");
        strBuf.append("beyondFee:").append(this.beyondFee).append(",\n");
        strBuf.append("areaId:").append(this.areaId).append(",\n");
        strBuf.append("freightType:").append(this.freightType).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
