package com.ow.tracer.shop.group.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [地区表实体类]
 * Date:        [2019-01-09 11:15:58]
 * Coder:       [JiangYanpeng]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("shop_area")
public class ShopArea extends BaseDTO<ShopArea> {

    private String areaName;

    private int level;

    private int sequence;

    private String parentId;

    private int recommend;

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public int getRecommend() {
        return this.recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("ShopArea{\n");
        strBuf.append("areaName:").append(this.areaName).append(",\n");
        strBuf.append("level:").append(this.level).append(",\n");
        strBuf.append("sequence:").append(this.sequence).append(",\n");
        strBuf.append("parentId:").append(this.parentId).append(",\n");
        strBuf.append("recommend:").append(this.recommend).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
