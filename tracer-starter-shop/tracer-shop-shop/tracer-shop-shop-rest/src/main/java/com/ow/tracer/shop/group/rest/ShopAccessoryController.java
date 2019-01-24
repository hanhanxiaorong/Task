package com.ow.tracer.shop.group.rest;

import com.ow.tracer.shop.group.dto.ShopAccessory;
import com.ow.tracer.shop.group.service.IShopAccessoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.common.base.BaseController;
import com.ow.tracer.common.base.BaseEnums;
import com.ow.tracer.common.base.Result;
import com.ow.tracer.common.constats.CommonConstant;
import com.ow.tracer.common.util.Results;
import com.ow.tracer.common.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * 类描述:     [相册图片表控制器]
 * 创建人:     [JiangYanpeng]
 * 创建时间:   [2019-01-09 11:15:58]
 * 版本:       [v1.0]
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/shopAccessory")
public class ShopAccessoryController extends BaseController {
    @Autowired
    private IShopAccessoryService shopAccessoryService;
    private Logger logger = LoggerFactory.getLogger(ShopAccessoryController.class);

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
        IPage<ShopAccessory> shopAccessoryIPage = shopAccessoryService.page(page,null);
        return Results.successWithData(shopAccessoryIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<ShopAccessory> shopAccessoryList =  shopAccessoryService.list(new QueryWrapper<>());
        return Results.successWithData(shopAccessoryList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        ShopAccessory shopAccessory = new ShopAccessory ();
        shopAccessory=shopAccessoryService.getById(id);
        return Results.successWithData(shopAccessory, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除相册图片表
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = shopAccessoryService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       *
       * @param shopAccessory {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody ShopAccessory  shopAccessory ) {
           boolean  boo = shopAccessoryService.save(shopAccessory);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新相册图片表
         * @param shopAccessory {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody ShopAccessory   shopAccessory ,UserVO userVO){
        shopAccessory .setUpdateDate(new Date());
        shopAccessory .setUpdateBy(userVO.getId());
        shopAccessory .setUpdater(userVO.getUserName());
        boolean boo = shopAccessoryService.updateById( shopAccessory);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }

}
