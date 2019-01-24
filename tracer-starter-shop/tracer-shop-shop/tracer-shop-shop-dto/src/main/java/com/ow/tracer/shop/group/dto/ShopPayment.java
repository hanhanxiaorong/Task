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
  @TableName("shop_payment")
public class ShopPayment extends BaseDTO<ShopPayment> {

    private String weixinAppId;

    private String weixinAppSecret;

    private String weixinPartnerId;

    private String weixinPartnerKey;

    private String weixinPaySignKey;

    private String aliAppId;

    private String sellerId;

    public String getWeixinAppId() {
        return this.weixinAppId;
    }

    public void setWeixinAppId(String weixinAppId) {
        this.weixinAppId = weixinAppId;
    }

    public String getWeixinAppSecret() {
        return this.weixinAppSecret;
    }

    public void setWeixinAppSecret(String weixinAppSecret) {
        this.weixinAppSecret = weixinAppSecret;
    }

    public String getWeixinPartnerId() {
        return this.weixinPartnerId;
    }

    public void setWeixinPartnerId(String weixinPartnerId) {
        this.weixinPartnerId = weixinPartnerId;
    }

    public String getWeixinPartnerKey() {
        return this.weixinPartnerKey;
    }

    public void setWeixinPartnerKey(String weixinPartnerKey) {
        this.weixinPartnerKey = weixinPartnerKey;
    }

    public String getWeixinPaySignKey() {
        return this.weixinPaySignKey;
    }

    public void setWeixinPaySignKey(String weixinPaySignKey) {
        this.weixinPaySignKey = weixinPaySignKey;
    }

    public String getAliAppId() {
        return this.aliAppId;
    }

    public void setAliAppId(String aliAppId) {
        this.aliAppId = aliAppId;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("ShopPayment{\n");
        strBuf.append("weixinAppId:").append(this.weixinAppId).append(",\n");
        strBuf.append("weixinAppSecret:").append(this.weixinAppSecret).append(",\n");
        strBuf.append("weixinPartnerId:").append(this.weixinPartnerId).append(",\n");
        strBuf.append("weixinPartnerKey:").append(this.weixinPartnerKey).append(",\n");
        strBuf.append("weixinPaySignKey:").append(this.weixinPaySignKey).append(",\n");
        strBuf.append("aliAppId:").append(this.aliAppId).append(",\n");
        strBuf.append("sellerId:").append(this.sellerId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
