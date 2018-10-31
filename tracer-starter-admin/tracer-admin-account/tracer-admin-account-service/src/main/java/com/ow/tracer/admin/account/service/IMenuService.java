package com.ow.tracer.admin.account.service;

import com.ow.tracer.admin.account.dto.Menu;
import com.ow.tracer.common.base.BaseService;
import com.ow.tracer.common.vo.MenuVO;

import java.util.List;

/**
 * @auther: Easy
 * @Date: 18-9-25 21:46
 * @Description:
 */
public interface IMenuService extends BaseService<Menu> {
    List<MenuVO> findMenuByRoleName(String role);
    boolean insertMenu (Menu menu);
}
