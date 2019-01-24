package com.ow.tracer.shop.group.rest;

import cn.hutool.core.collection.CollUtil;
import com.ow.tracer.shop.group.dto.ShopClass;
import com.ow.tracer.shop.group.dto.ShopClassTree;
import com.ow.tracer.shop.group.service.IShopClassService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.common.base.BaseController;
import com.ow.tracer.common.base.BaseEnums;
import com.ow.tracer.common.base.Result;
import com.ow.tracer.common.util.Results;
import com.ow.tracer.common.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ow.tracer.shop.group.util.TreeUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 类描述:     [分类信息表控制器]
 * 创建人:     [JiangYanpeng]
 * 创建时间:   [2019-01-09 11:15:58]
 * 版本:       [v1.0]
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/shopClass")
public class ShopClassController extends BaseController {
    @Autowired
    private IShopClassService shopClassService;
    private Logger logger = LoggerFactory.getLogger(ShopClassController.class);

    /**
	 * 分页 PAGE
	 * @param current 当前页数
	 * @return 分页数据
	 */
	 @ApiOperation(value="获取分页数据",notes = "获取分页数据")
     @GetMapping(value="/pageList")
    public Result pageList(Integer current){
        Page page = new Page();
        page.setCurrent(current);
        page.setSize(20);
        IPage<ShopClass> shopClassIPage = shopClassService.page(page,null);
        return Results.successWithData(shopClassIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<ShopClass> shopClassList =  shopClassService.list(new QueryWrapper<>());
        return Results.successWithData(shopClassList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        ShopClass shopClass = new ShopClass ();
        shopClass=shopClassService.getById(id);
        return Results.successWithData(shopClass, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除分类信息表
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = shopClassService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       *
       * @param shopClass {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody ShopClass  shopClass ) {
           boolean  boo = shopClassService.save(shopClass);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新分类信息表
         * @param shopClass {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody ShopClass   shopClass ,UserVO userVO){
        shopClass .setUpdateDate(new Date());
        shopClass .setUpdateBy(userVO.getId());
        shopClass .setUpdater(userVO.getUserName());
        boolean boo = shopClassService.updateById( shopClass);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }


    @ApiOperation(value="获取所有分类",notes ="查询数据库分类集合")
    @GetMapping(value="treeList")
    public Result treeList(){
        List<ShopClass> list = new ArrayList<>();
        QueryWrapper queryWrapper  = new QueryWrapper();
        list = shopClassService.list(queryWrapper);
        List<ShopClassTree> shopClassTreeList = new ArrayList<>();
        list.forEach(shopclass -> {
            shopClassTreeList.add(new ShopClassTree(shopclass));
        });
        CollUtil.sort(shopClassTreeList, Comparator.comparingInt(ShopClassTree::getSequence));
        return Results.successWithData(TreeUtil.buildByRecursive(shopClassTreeList, "0"), BaseEnums.SUCCESS.desc());
    }

}
