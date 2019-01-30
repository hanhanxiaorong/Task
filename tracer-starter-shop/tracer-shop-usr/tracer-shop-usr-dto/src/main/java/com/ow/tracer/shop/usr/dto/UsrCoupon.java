package com.ow.tracer.shop.usr.dto;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;

import java.util.Date;

/**
 * Explain:     [实体类]
 * Date:        [2019-01-14 22:16:05]
 * Coder:       [江雪立]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("usr_coupon")
public class UsrCoupon extends BaseDTO<UsrCoupon> {

    /**店铺ID*/
    private String storeId;

    /**用户ID*/
    private String userId;

    /**优惠券id*/
    private String couponId;

    /**开始时间*/
    private Date startTime;

    /**截止时间*/
    private Date endTime;

    /**使用状态*/
    private int status;

    /**自定义 用户名*/
    @TableField(exist = false)
    private String userName;
    /**自定义 店铺名*/
    @TableField(exist = false)
    private String storeName;
    /**自定义 优惠券标题*/
    @TableField(exist = false)
    private String title;
    /**自定义 优惠券类型*/
    @TableField(exist = false)
    private Integer type;
    /**自定义 满减优惠券的满多少*/
    @TableField(exist = false)
    private Integer minfee;
    /**自定义 优惠比例*/
    @TableField(exist = false)
    private Double proportion;
    /**自定义 优惠金额*/
    @TableField(exist = false)
    private String price;
    /**自定义 时长*/
    @TableField(exist = false)
    private Integer validity;
    /**自定义 优惠券有效状态*/
    @TableField(exist = false)
    private Integer couponStatus;

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCouponId() {
        return this.couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
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

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public Integer getMinfee() { return minfee; }

    public void setMinfee(Integer minfee) { this.minfee = minfee; }

    public Double getProportion() { return proportion; }

    public void setProportion(Double proportion) { this.proportion = proportion; }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public Integer getValidity() { return validity; }

    public void setValidity(Integer validity) { this.validity = validity; }

    public Integer getCouponStatus() { return couponStatus; }

    public void setCouponStatus(Integer couponStatus) { this.couponStatus = couponStatus; }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("UsrCoupon{\n");
        strBuf.append("storeId:").append(this.storeId).append(",\n");
        strBuf.append("userId:").append(this.userId).append(",\n");
        strBuf.append("couponId:").append(this.couponId).append(",\n");
        strBuf.append("startTime:").append(this.startTime).append(",\n");
        strBuf.append("endTime:").append(this.endTime).append(",\n");
        strBuf.append("status:").append(this.status).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
