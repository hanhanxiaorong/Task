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
  @TableName("store_class_taple")
public class StoreClassTaple extends BaseDTO<StoreClassTaple> {

    /**描述*/
    private String info;

    /**类ID*/
    private String gcId;

    /**店铺ID*/
    private String storeId;

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGcId() {
        return this.gcId;
    }

    public void setGcId(String gcId) {
        this.gcId = gcId;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("StoreClassTaple{\n");
        strBuf.append("info:").append(this.info).append(",\n");
        strBuf.append("gcId:").append(this.gcId).append(",\n");
        strBuf.append("storeId:").append(this.storeId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
