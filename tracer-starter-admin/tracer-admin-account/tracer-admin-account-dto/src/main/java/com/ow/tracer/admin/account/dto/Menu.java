package com.ow.tracer.admin.account.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.core.base.BaseDTO;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther: Easy
 * @Date: 18-9-25 21:43
 * @Description:
 */
@TableName("admin_menu")

public class Menu extends BaseDTO<Menu> {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单权限标识
     */
    private String permission;
    /**
     * 请求链接
     */
    private String url;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 父菜单ID
     */
    private String parentId;
    /**
     * 图标
     */
    private String icon;
    /**
     * VUE页面
     */
    private String component;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private String type;

    private String delFlag;
    /**
     * 前端URL
     */
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }

    @Override
    public String toString() {
        return "Menu{" +
                ", name=" + name +
                ", permission=" + permission +
                ", url=" + url +
                ", method=" + method +
                ", parentId=" + parentId +
                ", icon=" + icon +
                ", component=" + component +
                ", sort=" + sort +
                ", type=" + type +

                ", delFlag=" + delFlag +
                "}";
    }
}
