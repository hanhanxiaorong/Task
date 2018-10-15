package com.ow.tracer.admin.account.dto;

import com.ow.tracer.core.base.BaseDTO;

import java.io.Serializable;

/**
 * @Auther: Easy
 * @Date: 18-9-25 21:29
 * @Description:
 */
public class DeptRelation extends BaseDTO<DeptRelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 祖先节点
     */
    private Integer ancestor;
    /**
     * 后代节点
     */
    private Integer descendant;


    @Override
    protected Serializable pkVal() {
        return this.ancestor;
    }

    @Override
    public String toString() {
        return "DeptRelation{" +
                ", ancestor=" + ancestor +
                ", descendant=" + descendant +
                "}";
    }

    public Integer getAncestor() {
        return ancestor;
    }

    public void setAncestor(Integer ancestor) {
        this.ancestor = ancestor;
    }

    public Integer getDescendant() {
        return descendant;
    }

    public void setDescendant(Integer descendant) {
        this.descendant = descendant;
    }
}