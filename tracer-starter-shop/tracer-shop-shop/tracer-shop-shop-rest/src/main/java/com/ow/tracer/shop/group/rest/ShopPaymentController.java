package com.ow.tracer.shop.group.rest;

import com.ow.tracer.shop.group.dto.ShopPayment;
import com.ow.tracer.shop.group.service.IShopPaymentService;
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
 * 类描述:     [控制器]
 * 创建人:     [JiangYanpeng]
 * 创建时间:   [2019-01-09 11:15:59]
 * 版本:       [v1.0]
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/shopPayment")
public class ShopPaymentController extends BaseController {
    @Autowired
    private IShopPaymentService shopPaymentService;
    private Logger logger = LoggerFactory.getLogger(ShopPaymentController.class);

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
        IPage<ShopPayment> shopPaymentIPage = shopPaymentService.page(page,null);
        return Results.successWithData(shopPaymentIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<ShopPayment> shopPaymentList =  shopPaymentService.list(new QueryWrapper<>());
        return Results.successWithData(shopPaymentList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        ShopPayment shopPayment = new ShopPayment ();
        shopPayment=shopPaymentService.getById(id);
        return Results.successWithData(shopPayment, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = shopPaymentService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       *
       * @param shopPayment {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody ShopPayment  shopPayment ) {
           boolean  boo = shopPaymentService.save(shopPayment);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新
         * @param shopPayment {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody ShopPayment   shopPayment ,UserVO userVO){
        shopPayment .setUpdateDate(new Date());
        shopPayment .setUpdateBy(userVO.getId());
        shopPayment .setUpdater(userVO.getUserName());
        boolean boo = shopPaymentService.updateById( shopPayment);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }

}
