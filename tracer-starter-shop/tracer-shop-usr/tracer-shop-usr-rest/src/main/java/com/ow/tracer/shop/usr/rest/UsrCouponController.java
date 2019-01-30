package com.ow.tracer.shop.usr.rest;

import com.ow.tracer.shop.usr.dto.UsrCoupon;
import com.ow.tracer.shop.usr.dto.UsrUser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.common.base.BaseController;
import com.ow.tracer.common.base.BaseEnums;
import com.ow.tracer.common.base.Result;
import com.ow.tracer.common.util.Results;
import com.ow.tracer.common.vo.UserVO;

import com.ow.tracer.shop.usr.service.IUsrCouponService;
import com.ow.tracer.shop.usr.service.IUsrUserService;
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
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/usrCoupon")
public class UsrCouponController extends BaseController {
    @Autowired
    private IUsrCouponService usrCouponService;
    @Autowired
    private IUsrCouponService couponService;
    @Autowired
    private IUsrUserService usrUserService;
    private Logger logger = LoggerFactory.getLogger(UsrCouponController.class);

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
        IPage<UsrCoupon> usrCouponIPage = usrCouponService.page(page,null);
        return Results.successWithData(usrCouponIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<UsrCoupon> usrCouponList =  usrCouponService.list(new QueryWrapper<>());
        return Results.successWithData(usrCouponList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        UsrCoupon usrCoupon = new UsrCoupon ();
        usrCoupon=usrCouponService.getById(id);
        return Results.successWithData(usrCoupon, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = usrCouponService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       *
       * @param usrCoupon {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody UsrCoupon  usrCoupon ) {
           boolean  boo = usrCouponService.save(usrCoupon);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新
         * @param usrCoupon {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody UsrCoupon   usrCoupon ,UserVO userVO){
        usrCoupon .setUpdateDate(new Date());
        usrCoupon .setUpdateBy(userVO.getId());
        usrCoupon .setUpdater(userVO.getUserName());
        boolean boo = usrCouponService.updateById( usrCoupon);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据用户id查询他的优惠券集合
     * @return List实体集合
     */
    @PostMapping(value="/listByUserId")
    public Result listByUserId(String userId){
        List<UsrCoupon> usrCouponList =  usrCouponService.listByUserId(userId);
        for(UsrCoupon usrCoupon:usrCouponList){
            fillCouponDetail(usrCoupon);
        }
        return Results.successWithData(usrCouponList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**g
     * 填充优惠券的详细信息
     * @param usrCoupon
     */
    public void fillCouponDetail(UsrCoupon usrCoupon){
        UsrUser usrUser=usrUserService.getById(usrCoupon.getUserId());
        usrCoupon.setUserName(usrUser.getUserName());
        //查店铺信息，把店铺名存到自定义属性里

        //根据优惠券id查优惠券把优惠券信息存到自定义属性,开始时间是领取的当前时间，结束时间根据优惠券信息里的时长去算

    }



}
