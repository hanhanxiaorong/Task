package com.ow.tracer.admin.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.admin.account.dto.Menu;
import com.ow.tracer.admin.account.dto.Role;
import com.ow.tracer.admin.account.dto.User;
import com.ow.tracer.admin.account.dto.UserRole;
import com.ow.tracer.admin.account.mapper.MenuMapper;
import com.ow.tracer.admin.account.mapper.RoleMapper;
import com.ow.tracer.admin.account.service.IMenuService;
import com.ow.tracer.admin.account.service.IRoleService;
import com.ow.tracer.admin.account.service.IUserRoleService;
import com.ow.tracer.admin.account.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: Easy
 * @Date: 18-10-16 23:46
 * @Description:
 */
@Service("iRoleService")
public class RoleServiceImpl  extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    IUserRoleService userRoleService;
    @Override
    public IPage<Role> selectPage(Page page) {
        IPage<Role> iPage = this.baseMapper.selectRolePage(page);
        return iPage;
    }

    @Override
    public boolean delRoleById(String id) {
        System.out.println(id);
    QueryWrapper contion = new QueryWrapper();
    contion.eq("role_id",id);
        List<UserRole> roles = userRoleService.list(contion);
        if(null== roles || roles.size()==0){
            return this.removeById(id);
        }
        return false;
    }
}
