package com.ow.tracer.shop.group.rest;

import com.ow.tracer.shop.group.dto.ShopFloor;
import com.ow.tracer.shop.group.service.IShopFloorService;
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
 * 类描述:     [楼层信息表控制器]
 * 创建人:     [JiangYanpeng]
 * 创建时间:   [2019-01-09 11:15:59]
 * 版本:       [v1.0]
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/shopFloor")
public class ShopFloorController extends BaseController {
    @Autowired
    private IShopFloorService shopFloorService;
    private Logger logger = LoggerFactory.getLogger(ShopFloorController.class);

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
        IPage<ShopFloor> shopFloorIPage = shopFloorService.page(page,null);
        return Results.successWithData(shopFloorIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<ShopFloor> shopFloorList =  shopFloorService.list(new QueryWrapper<>());
        return Results.successWithData(shopFloorList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        ShopFloor shopFloor = new ShopFloor ();
        shopFloor=shopFloorService.getById(id);
        return Results.successWithData(shopFloor, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除楼层信息表
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = shopFloorService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       *
       * @param shopFloor {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody ShopFloor  shopFloor ) {
           boolean  boo = shopFloorService.save(shopFloor);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新楼层信息表
         * @param shopFloor {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody ShopFloor   shopFloor ,UserVO userVO){
        shopFloor .setUpdateDate(new Date());
        shopFloor .setUpdateBy(userVO.getId());
        shopFloor .setUpdater(userVO.getUserName());
        boolean boo = shopFloorService.updateById( shopFloor);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }

}
