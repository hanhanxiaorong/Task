package com.ow.tracer.admin.account.rest;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ow.tracer.admin.account.dto.Dept;
import com.ow.tracer.admin.account.dto.Menu;
import com.ow.tracer.admin.account.dto.MenuTree;
import com.ow.tracer.admin.account.service.IMenuService;
import com.ow.tracer.admin.account.util.TreeUtil;
import com.ow.tracer.common.base.BaseController;
import com.ow.tracer.common.base.BaseEnums;
import com.ow.tracer.common.base.Result;
import com.ow.tracer.common.constats.CommonConstant;
import com.ow.tracer.common.util.Results;
import com.ow.tracer.common.vo.MenuVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @auther: Easy
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

        return TreeUtil.bulid(menuTreeList, "-1");
    }
    @GetMapping(value="menuTree")
    public Result  menuTree(){
            List<Menu> list = new ArrayList<>();
        QueryWrapper queryWrapper  = new QueryWrapper();
        list = menuService.list(queryWrapper);
        List<MenuTree> menuTreeList = new ArrayList<>();
        list.forEach(menu -> {
            menuTreeList.add(new MenuTree(menu));
        });
        CollUtil.sort(menuTreeList, Comparator.comparingInt(MenuTree::getSort));

        return Results.successWithData(TreeUtil.bulid(menuTreeList, "-1"), BaseEnums.SUCCESS.desc());
    }

    /**
     * @param id 菜单编号
     * @return 菜单实体数据
     */
    @GetMapping("/{id}")
    public Result getObj(@PathVariable String id){
        Menu menu = menuService.getById(id);
        return Results.successWithData(menu,BaseEnums.SUCCESS.desc());
    }
    /**
     * 添加
     *
     * @param menu 菜单实体
     * @return success/false
     */
    @PostMapping("/add")
    public Result add(@RequestBody Menu menu) {

        boolean  boo = menuService.insertMenu(menu);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

}
