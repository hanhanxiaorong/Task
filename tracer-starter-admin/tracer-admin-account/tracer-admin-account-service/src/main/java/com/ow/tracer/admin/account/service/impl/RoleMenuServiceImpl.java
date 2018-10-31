package com.ow.tracer.admin.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.admin.account.dto.Menu;
import com.ow.tracer.admin.account.dto.RoleMenu;
import com.ow.tracer.admin.account.mapper.MenuMapper;
import com.ow.tracer.admin.account.mapper.RoleMenuMapper;
import com.ow.tracer.admin.account.service.IMenuService;
import com.ow.tracer.admin.account.service.IRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * @auther: Easy
 * @date: 18-11-1 00:24
 * @description:
 */
@Service
public class RoleMenuServiceImpl  extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {
}
