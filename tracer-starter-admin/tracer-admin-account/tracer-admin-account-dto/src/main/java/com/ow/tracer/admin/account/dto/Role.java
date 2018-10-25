package com.ow.tracer.admin.account.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ow.tracer.core.base.BaseDTO;

/**
 * @auther: Easy
 * @Date: 18-9-25 21:02
 * @Description:
 */
@TableName("admin_role")
@SuppressWarnings("serial")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role extends BaseDTO<Role> {
    @TableField("role_name")
    private String roleName;
    @TableField("role_code")
    private String roleCode;
    @TableField("role_desc")
    private String roleDesc;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
