package com.ow.tracer.shop.group.rest;

import com.ow.tracer.shop.group.dto.ShopArea;
import com.ow.tracer.shop.group.service.IShopAreaService;
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
 * 类描述:     [地区表控制器]
 * 创建人:     [JiangYanpeng]
 * 创建时间:   [2019-01-09 11:15:58]
 * 版本:       [v1.0]
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/shopArea")
public class ShopAreaController extends BaseController {
    @Autowired
    private IShopAreaService shopAreaService;
    private Logger logger = LoggerFactory.getLogger(ShopAreaController.class);

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
        IPage<ShopArea> shopAreaIPage = shopAreaService.page(page,null);
        return Results.successWithData(shopAreaIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<ShopArea> shopAreaList =  shopAreaService.list(new QueryWrapper<>());
        return Results.successWithData(shopAreaList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        ShopArea shopArea = new ShopArea ();
        shopArea=shopAreaService.getById(id);
        return Results.successWithData(shopArea, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除地区表
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = shopAreaService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       *
       * @param shopArea {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody ShopArea  shopArea ) {
           boolean  boo = shopAreaService.save(shopArea);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新地区表
         * @param shopArea {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody ShopArea   shopArea ,UserVO userVO){
        shopArea .setUpdateDate(new Date());
        shopArea .setUpdateBy(userVO.getId());
        shopArea .setUpdater(userVO.getUserName());
        boolean boo = shopAreaService.updateById( shopArea);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }

}
