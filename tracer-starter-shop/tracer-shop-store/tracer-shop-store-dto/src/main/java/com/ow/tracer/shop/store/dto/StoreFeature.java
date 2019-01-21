package com.ow.tracer.shop.store.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [店铺分类规格表
1:n:n 关系实体类]
 * Date:        [2019-01-09 18:27:32]
 * Coder:       [江雪立]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("store_feature")
public class StoreFeature extends BaseDTO<StoreFeature> {

    /**特征名称*/
    private String featureName;

    /**店铺ID*/
    private String userId;

    /**类型，0：规格，1：属性*/
    private int type;

    /**级别*/
    private int level;

    /**审核状态*/
    private int approveStatus;

    /**上级ID拼接*/
    private String pId;

    private String classId;

    /**上级ID*/
    private String parentId;

    public String getFeatureName() {
        return this.featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getApproveStatus() {
        return this.approveStatus;
    }

    public void setApproveStatus(int approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getPId() {
        return this.pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getClassId() {
        return this.classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("StoreFeature{\n");
        strBuf.append("featureName:").append(this.featureName).append(",\n");
        strBuf.append("userId:").append(this.userId).append(",\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("level:").append(this.level).append(",\n");
        strBuf.append("approveStatus:").append(this.approveStatus).append(",\n");
        strBuf.append("pId:").append(this.pId).append(",\n");
        strBuf.append("classId:").append(this.classId).append(",\n");
        strBuf.append("parentId:").append(this.parentId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
