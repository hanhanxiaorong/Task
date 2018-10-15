package com.ow.tracer.admin.account.rest;

import cn.hutool.core.collection.CollUtil;
import com.ow.tracer.admin.account.dto.MenuTree;
import com.ow.tracer.admin.account.service.IMenuService;
import com.ow.tracer.admin.account.util.TreeUtil;
import com.ow.tracer.core.base.BaseController;
import com.ow.tracer.core.constats.CommonConstant;
import com.ow.tracer.core.vo.MenuVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Auther: Easy
 * @Date: 18-9-25 23:52
 * @Description:
 */
@RestController
@RequestMapping("/menu")

public class MenuController extends BaseController {
    @Autowired
    IMenuService menuService;
    private Logger logger = LoggerFactory.getLogger(MenuController.class);
    /**
     * 返回当前用户的树形菜单集合
     *
     * @return 当前用户的树形菜单
     */
    @GetMapping(value = "/userMenu")
    public List<MenuTree> userMenu() {
        // 获取符合条件得菜单
        Set<MenuVO> all = new HashSet<>();
        getRole().forEach(roleName -> all.addAll(menuService.findMenuByRoleName(roleName)));
        List<MenuTree> menuTreeList = new ArrayList<>();
        all.forEach(menuVo -> {
            if (CommonConstant.MENU.equals(menuVo.getType())) {
                menuTreeList.add(new MenuTree(menuVo));
            }
        });
        CollUtil.sort(menuTreeList, Comparator.comparingInt(MenuTree::getSort));
        System.out.println(menuTreeList.size());
        return TreeUtil.bulid(menuTreeList, "-1");
    }
}
