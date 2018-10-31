package com.ow.tracer.admin.account.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.admin.account.dto.Dept;
import com.ow.tracer.admin.account.dto.Role;
import com.ow.tracer.admin.account.service.IRoleService;
import com.ow.tracer.common.base.BaseController;
import com.ow.tracer.common.base.BaseEnums;
import com.ow.tracer.common.base.Result;
import com.ow.tracer.common.util.Results;
import com.ow.tracer.common.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * RoleController class
 * @author Easy
 * @date 18-10-27 00:42
 * @description:
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
    @Autowired
    private IRoleService iRoleService;

    /**
     * @param current 分页页数
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/pageList")
    private Result pageList(Integer current) throws Exception{
        Page<Role> page = new Page<>();
        page.setCurrent(current);
        IPage<Role> iPage =  iRoleService.selectPage(page);
        return Results.successWithData(iPage, BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }

    /**
     * 新增角色管理
     * @param row 角色数据
     * @return true/false
     */
    @PostMapping(value="/add")
    private Result add(@RequestBody Role row){
        boolean  boo = iRoleService.save(row);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

    /**
     * @param id
     * @return 删除成功/失败
     */
    @DeleteMapping("/{id}")
    private Result del(@PathVariable String id){
        System.out.println(id);
        boolean  boo = iRoleService.delRoleById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

    /**
     * @param role 操作的role对象，以及记录的user对象
     * @param userVO 操作人对象
     * @return 操作成功或者失败状态
     */
    @PutMapping("/edit")
    public Result edit(@RequestBody Role role , UserVO userVO){
        role.setUpdateDate(new Date());
        role.setUpdateBy(userVO.getId());
        role.setUpdater(userVO.getUserName());
        boolean boo = iRoleService.updateById(role);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }
}
