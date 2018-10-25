package com.ow.tracer.admin.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.admin.account.dto.Menu;
import com.ow.tracer.admin.account.dto.Role;
import com.ow.tracer.admin.account.mapper.MenuMapper;
import com.ow.tracer.admin.account.mapper.RoleMapper;
import com.ow.tracer.admin.account.service.IMenuService;
import com.ow.tracer.admin.account.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * @auther: Easy
 * @Date: 18-10-16 23:46
 * @Description:
 */
@Service("iRoleService")
public class RoleServiceImpl  extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}
