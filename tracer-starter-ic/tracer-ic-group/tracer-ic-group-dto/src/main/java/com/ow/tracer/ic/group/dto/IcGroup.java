package com.ow.tracer.ic.group.dto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ow.tracer.common.base.BaseDTO;
import java.io.Serializable;
import java.util.Date;

/**
 * Explain:     [实体类]
 * Date:        [2018-12-24 21:04:07]
 * Coder:       [江雪立]
 * Version:     [1.0]
 */
 @SuppressWarnings("serial")
  @TableName("ic_group")
public class IcGroup extends BaseDTO<IcGroup> {

    /**组织名称*/
    private String groupName;

    private String groupTypeId;

    private int groupUpperLimit;

    /**组织开放状态*/
    private String groupStatus;

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupTypeId() {
        return this.groupTypeId;
    }

    public void setGroupTypeId(String groupTypeId) {
        this.groupTypeId = groupTypeId;
    }

    public int getGroupUpperLimit() {
        return this.groupUpperLimit;
    }

    public void setGroupUpperLimit(int groupUpperLimit) {
        this.groupUpperLimit = groupUpperLimit;
    }

    public String getGroupStatus() {
        return this.groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("IcGroup{\n");
        strBuf.append("groupName:").append(this.groupName).append(",\n");
        strBuf.append("groupTypeId:").append(this.groupTypeId).append(",\n");
        strBuf.append("groupUpperLimit:").append(this.groupUpperLimit).append(",\n");
        strBuf.append("groupStatus:").append(this.groupStatus).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
