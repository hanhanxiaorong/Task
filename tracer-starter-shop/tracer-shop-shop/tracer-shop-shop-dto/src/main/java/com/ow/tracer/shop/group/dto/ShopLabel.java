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
  @TableName("shop_label")
public class ShopLabel extends BaseDTO<ShopLabel> {

    /**标签标题*/
    private String title;

    /**开启状态*/
    private int openStatus;

    /**审批状态*/
    private int approveStatus;

    /**标签类型*/
    private int type;

    /**用户ID*/
    private String userId;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOpenStatus() {
        return this.openStatus;
    }

    public void setOpenStatus(int openStatus) {
        this.openStatus = openStatus;
    }

    public int getApproveStatus() {
        return this.approveStatus;
    }

    public void setApproveStatus(int approveStatus) {
        this.approveStatus = approveStatus;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("ShopLabel{\n");
        strBuf.append("title:").append(this.title).append(",\n");
        strBuf.append("openStatus:").append(this.openStatus).append(",\n");
        strBuf.append("approveStatus:").append(this.approveStatus).append(",\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("userId:").append(this.userId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
