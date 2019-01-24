package com.ow.tracer.shop.group.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [购物车表实体类]
 * Date:        [2019-01-09 11:15:58]
 * Coder:       [JiangYanpeng]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("shop_cart")
public class ShopCart extends BaseDTO<ShopCart> {

    /**商品ID*/
    private String goodsId;

    /**商品名称*/
    private String goodsName;

    /**商品规格JSON*/
    private String goodsSkuinfo;

    /**商品数量*/
    private int goodsCount;

    /**商品价格*/
    private double goodsPrice;

    /**用户ID*/
    private String userId;

    /**店铺ID*/
    private String storeId;

    /**店铺名称*/
    private String storeName;

    /**状态*/
    private int strtus;

    public String getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSkuinfo() {
        return this.goodsSkuinfo;
    }

    public void setGoodsSkuinfo(String goodsSkuinfo) {
        this.goodsSkuinfo = goodsSkuinfo;
    }

    public int getGoodsCount() {
        return this.goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public double getGoodsPrice() {
        return this.goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getStrtus() {
        return this.strtus;
    }

    public void setStrtus(int strtus) {
        this.strtus = strtus;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("ShopCart{\n");
        strBuf.append("goodsId:").append(this.goodsId).append(",\n");
        strBuf.append("goodsName:").append(this.goodsName).append(",\n");
        strBuf.append("goodsSkuinfo:").append(this.goodsSkuinfo).append(",\n");
        strBuf.append("goodsCount:").append(this.goodsCount).append(",\n");
        strBuf.append("goodsPrice:").append(this.goodsPrice).append(",\n");
        strBuf.append("userId:").append(this.userId).append(",\n");
        strBuf.append("storeId:").append(this.storeId).append(",\n");
        strBuf.append("storeName:").append(this.storeName).append(",\n");
        strBuf.append("strtus:").append(this.strtus).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
