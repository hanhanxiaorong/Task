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
  @TableName("ic_group_type")
public class IcGroupType extends BaseDTO<IcGroupType> {

    /**类型*/
    private String type;

    /**组织类型*/
    private String name;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        final StringBuilder strBuf = new StringBuilder("IcGroupType{\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("name:").append(this.name).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
