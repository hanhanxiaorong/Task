package com.ow.tracer.shop.coupon.dto;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;

/**
 * Explain:     [实体类]
 * Date:        [2019-01-23 20:39:37]
 * Coder:       [江雪立]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("coupon_warehouse")
public class CouponWarehouse extends BaseDTO<CouponWarehouse> {

    /**店铺ID*/
    private String storeId;

    /**优惠券标题*/
    private String title;

    /**优惠券类型：*/
    private int type;

    /**优惠券简介*/
    private String content;

    /**满减限制*/
    private int minfee;

    /**比例*/
    private double proportion;

    /**直降*/
    private double price;

    /**数量*/
    private int num;

    /**时长*/
    private int validity;

    /**有效状态*/
    private int status;

    /**自定义 店铺名称*/
    @TableField(exist = false)
    private String storeName;

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMinfee() {
        return this.minfee;
    }

    public void setMinfee(int minfee) {
        this.minfee = minfee;
    }

    public double getProportion() {
        return this.proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getValidity() {
        return this.validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStoreName() { return storeName; }

    public void setStoreName(String storeName) { this.storeName = storeName; }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("CouponWarehouse{\n");
        strBuf.append("storeId:").append(this.storeId).append(",\n");
        strBuf.append("title:").append(this.title).append(",\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("content:").append(this.content).append(",\n");
        strBuf.append("minfee:").append(this.minfee).append(",\n");
        strBuf.append("proportion:").append(this.proportion).append(",\n");
        strBuf.append("price:").append(this.price).append(",\n");
        strBuf.append("num:").append(this.num).append(",\n");
        strBuf.append("validity:").append(this.validity).append(",\n");
        strBuf.append("status:").append(this.status).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
