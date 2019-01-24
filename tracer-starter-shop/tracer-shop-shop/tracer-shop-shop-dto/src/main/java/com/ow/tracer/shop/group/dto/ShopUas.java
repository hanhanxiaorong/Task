package com.ow.tracer.shop.group.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [实体类]
 * Date:        [2019-01-09 11:15:58]
 * Coder:       [JiangYanpeng]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("shop_uas")
public class ShopUas extends BaseDTO<ShopUas> {

    /**增值业务名称*/
    private String uasTitle;

    /**增值业务价格*/
    private double uasPrice;

    /**增值业务开启状态*/
    private int uasOpen;

    public String getUasTitle() {
        return this.uasTitle;
    }

    public void setUasTitle(String uasTitle) {
        this.uasTitle = uasTitle;
    }

    public double getUasPrice() {
        return this.uasPrice;
    }

    public void setUasPrice(double uasPrice) {
        this.uasPrice = uasPrice;
    }

    public int getUasOpen() {
        return this.uasOpen;
    }

    public void setUasOpen(int uasOpen) {
        this.uasOpen = uasOpen;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("ShopUas{\n");
        strBuf.append("uasTitle:").append(this.uasTitle).append(",\n");
        strBuf.append("uasPrice:").append(this.uasPrice).append(",\n");
        strBuf.append("uasOpen:").append(this.uasOpen).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
