package com.ow.tracer.shop.group.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;

import java.util.ArrayList;

/**
 * Explain:     [分类信息表实体类]
 * Date:        [2019-01-09 11:15:58]
 * Coder:       [JiangYanpeng]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
public class ShopClassTree extends TreeNode {

    private String className;
    private int display;
    private int level;
    private int recommend;
    private int sequence;
    private String parentId;
    private String seoDescription;
    private String seoKeywords;
    private String iconClass;


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


    public ShopClassTree(ShopClass shopclass) {
        this.setClassName(shopclass.getClassName());
        this.setDisplay(shopclass.getDisplay());
        this.setLevel(shopclass.getLevel());
        this.setRecommend(shopclass.getRecommend());
        this.setSequence(shopclass.getSequence());
        this.setParentId(shopclass.getParentId());
        this.setSeoDescription(shopclass.getSeoDescription());
        this.setSeoKeywords(shopclass.getSeoKeywords());
        this.setIconClass(shopclass.getIconClass());
        this.setId(shopclass.getId());
    }

    public ShopClassTree(String className, int display, int level, int recommend, int sequence, String parentId, String seoDescription, String seoKeywords, String iconClass) {
        this.className = className;
        this.display = display;
        this.level = level;
        this.recommend = recommend;
        this.sequence = sequence;
        this.parentId = parentId;
        this.seoDescription = seoDescription;
        this.seoKeywords = seoKeywords;
        this.iconClass = iconClass;
    }

    public ShopClassTree(String id, String name, String parentId) {
        this.id = id;
        this.parentId = parentId;
        this.className = name;
    }
}
