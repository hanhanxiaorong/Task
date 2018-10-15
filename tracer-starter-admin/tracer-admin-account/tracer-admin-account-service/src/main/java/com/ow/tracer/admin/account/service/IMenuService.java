package com.ow.tracer.admin.account.service;

import com.ow.tracer.admin.account.dto.Menu;
import com.ow.tracer.core.base.BaseService;
import com.ow.tracer.core.vo.MenuVO;

import java.util.List;

/**
 * @Auther: Easy
 * @Date: 18-9-25 21:46
 * @Description:
 */
public interface IMenuService extends BaseService<Menu> {
    List<MenuVO> findMenuByRoleName(String role);

}
