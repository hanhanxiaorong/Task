package com.ow.tracer.admin.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.admin.account.dto.Menu;
import com.ow.tracer.admin.account.dto.User;
import com.ow.tracer.admin.account.mapper.MenuMapper;
import com.ow.tracer.admin.account.mapper.UserMapper;
import com.ow.tracer.admin.account.service.IMenuService;
import com.ow.tracer.core.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: Easy
 * @Date: 18-9-25 21:46
 * @Description:
 */
@Service
public class MenuServiceImpl  extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

@Autowired
private MenuMapper sysMenuMapper;

    @Override
    @Cacheable(value = "menu_details", key = "#role  + '_menu'")
    public List<MenuVO> findMenuByRoleName(String role) {
        return sysMenuMapper.findMenuByRoleName(role);
    }
}