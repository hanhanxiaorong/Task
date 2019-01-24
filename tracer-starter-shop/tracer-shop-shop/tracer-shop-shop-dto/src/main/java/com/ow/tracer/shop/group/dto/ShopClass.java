package com.ow.tracer.shop.group.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [分类信息表实体类]
 * Date:        [2019-01-09 11:15:58]
 * Coder:       [JiangYanpeng]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("shop_class")
public class ShopClass extends BaseDTO<ShopClass> {

    /**类型名称*/
    private String className;

    /**是否显示*/
    private int display;

    /**等级*/
    private int level;

    /**推荐*/
    private int recommend;

    /**排序*/
    private int sequence;

    /**上级ID*/
    private String parentId;

    /**优化搜索简介*/
    private String seoDescription;

    /**优化搜索关键字*/
    private String seoKeywords;

    /**图标样式*/
    private String iconClass;

    /**拼接所有上级ID*/
    private String pId;

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getDisplay() {
        return this.display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRecommend() {
        return this.recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public int getSequence() {
        return this.sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSeoDescription() {
        return this.seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getSeoKeywords() {
        return this.seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public String getIconClass() {
        return this.iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getPId() {
        return this.pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("ShopClass{\n");
        strBuf.append("className:").append(this.className).append(",\n");
        strBuf.append("display:").append(this.display).append(",\n");
        strBuf.append("level:").append(this.level).append(",\n");
        strBuf.append("recommend:").append(this.recommend).append(",\n");
        strBuf.append("sequence:").append(this.sequence).append(",\n");
        strBuf.append("parentId:").append(this.parentId).append(",\n");
        strBuf.append("seoDescription:").append(this.seoDescription).append(",\n");
        strBuf.append("seoKeywords:").append(this.seoKeywords).append(",\n");
        strBuf.append("iconClass:").append(this.iconClass).append(",\n");
        strBuf.append("pId:").append(this.pId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
