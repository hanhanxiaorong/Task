package com.ow.tracer.shop.coupon.rest;

import com.ow.tracer.shop.coupon.dto.CouponWarehouse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.common.base.BaseController;
import com.ow.tracer.common.base.BaseEnums;
import com.ow.tracer.common.base.Result;
import com.ow.tracer.common.util.Results;
import com.ow.tracer.common.vo.UserVO;
import com.ow.tracer.shop.coupon.service.ICouponWarehouseService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 类描述:     [控制器]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-23 20:39:37]
 * 版本:       [v1.0]
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/couponWarehouse")
public class CouponWarehouseController extends BaseController {
    @Autowired
    private ICouponWarehouseService couponWarehouseService;
    private Logger logger = LoggerFactory.getLogger(CouponWarehouseController.class);

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
        IPage<CouponWarehouse> couponWarehouseIPage = couponWarehouseService.page(page,null);
        return Results.successWithData(couponWarehouseIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<CouponWarehouse> couponWarehouseList =  couponWarehouseService.list(new QueryWrapper<>());
        return Results.successWithData(couponWarehouseList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        CouponWarehouse couponWarehouse = new CouponWarehouse ();
        couponWarehouse=couponWarehouseService.getById(id);
        return Results.successWithData(couponWarehouse, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = couponWarehouseService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       * @param couponWarehouse {data.describe}
       * @return success/false
       */
       @PostMapping("/add")
       public Result add(@RequestBody CouponWarehouse  couponWarehouse ) {
           boolean  boo = couponWarehouseService.save(couponWarehouse);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新
         * @param couponWarehouse {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody CouponWarehouse   couponWarehouse ,UserVO userVO){
        couponWarehouse .setUpdateDate(new Date());
        couponWarehouse .setUpdateBy(userVO.getId());
        couponWarehouse .setUpdater(userVO.getUserName());
        boolean boo = couponWarehouseService.updateById( couponWarehouse);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }

}
