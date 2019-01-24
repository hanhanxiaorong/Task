package com.ow.tracer.shop.group.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [楼层信息表实体类]
 * Date:        [2019-01-09 11:15:58]
 * Coder:       [JiangYanpeng]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("shop_floor")
public class ShopFloor extends BaseDTO<ShopFloor> {

    /**名称*/
    private String title;

    /**类型*/
    private int type;

    /**上级ID*/
    private String pId;

    /**分类列表*/
    private String gcList;

    /**分类商品列表*/
    private String gdGcList;

    /**排行列表*/
    private String gdRkList;

    /**样式*/
    private String css;

    /**是否显示*/
    private String display;

    /**商品数量*/
    private int goodsCount;

    /**排序*/
    private int sequence;

    /**左边广告*/
    private String leftAdv;

    /**右边广告*/
    private String rightAdv;

    /**品牌列表*/
    private String gfBrandList;

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

    public String getPId() {
        return this.pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getGcList() {
        return this.gcList;
    }

    public void setGcList(String gcList) {
        this.gcList = gcList;
    }

    public String getGdGcList() {
        return this.gdGcList;
    }

    public void setGdGcList(String gdGcList) {
        this.gdGcList = gdGcList;
    }

    public String getGdRkList() {
        return this.gdRkList;
    }

    public void setGdRkList(String gdRkList) {
        this.gdRkList = gdRkList;
    }

    public String getCss() {
        return this.css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public int getGoodsCount() {
        return this.goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public int getSequence() {
        return this.sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getLeftAdv() {
        return this.leftAdv;
    }

    public void setLeftAdv(String leftAdv) {
        this.leftAdv = leftAdv;
    }

    public String getRightAdv() {
        return this.rightAdv;
    }

    public void setRightAdv(String rightAdv) {
        this.rightAdv = rightAdv;
    }

    public String getGfBrandList() {
        return this.gfBrandList;
    }

    public void setGfBrandList(String gfBrandList) {
        this.gfBrandList = gfBrandList;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("ShopFloor{\n");
        strBuf.append("title:").append(this.title).append(",\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("pId:").append(this.pId).append(",\n");
        strBuf.append("gcList:").append(this.gcList).append(",\n");
        strBuf.append("gdGcList:").append(this.gdGcList).append(",\n");
        strBuf.append("gdRkList:").append(this.gdRkList).append(",\n");
        strBuf.append("css:").append(this.css).append(",\n");
        strBuf.append("display:").append(this.display).append(",\n");
        strBuf.append("goodsCount:").append(this.goodsCount).append(",\n");
        strBuf.append("sequence:").append(this.sequence).append(",\n");
        strBuf.append("leftAdv:").append(this.leftAdv).append(",\n");
        strBuf.append("rightAdv:").append(this.rightAdv).append(",\n");
        strBuf.append("gfBrandList:").append(this.gfBrandList).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
