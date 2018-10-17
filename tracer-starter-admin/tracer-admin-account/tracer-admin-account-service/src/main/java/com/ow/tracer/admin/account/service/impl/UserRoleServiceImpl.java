package com.ow.tracer.admin.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.admin.account.dto.Menu;
import com.ow.tracer.admin.account.dto.UserRole;
import com.ow.tracer.admin.account.mapper.MenuMapper;
import com.ow.tracer.admin.account.mapper.UserRoleMapper;
import com.ow.tracer.admin.account.service.IMenuService;
import com.ow.tracer.admin.account.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Auther: Easy
 * @Date: 18-10-16 23:12
 * @Description:
 */
@Service("iUserRoleService")

public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
}
