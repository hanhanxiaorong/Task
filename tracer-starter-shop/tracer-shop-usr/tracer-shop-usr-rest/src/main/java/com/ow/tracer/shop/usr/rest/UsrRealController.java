package com.ow.tracer.shop.usr.rest;

import com.ow.tracer.shop.usr.dto.UsrReal;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.common.base.BaseController;
import com.ow.tracer.common.base.BaseEnums;
import com.ow.tracer.common.base.Result;
import com.ow.tracer.common.util.Results;
import com.ow.tracer.common.vo.UserVO;
import com.ow.tracer.shop.usr.service.IUsrRealService;
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
@RequestMapping("/usrReal")
public class UsrRealController extends BaseController {
    @Autowired
    private IUsrRealService usrRealService;
    private Logger logger = LoggerFactory.getLogger(UsrRealController.class);

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
        IPage<UsrReal> usrRealIPage = usrRealService.page(page,null);
        return Results.successWithData(usrRealIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<UsrReal> usrRealList =  usrRealService.list(new QueryWrapper<>());
        return Results.successWithData(usrRealList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        UsrReal usrReal = new UsrReal ();
        usrReal=usrRealService.getById(id);
        return Results.successWithData(usrReal, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = usrRealService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       *
       * @param usrReal {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody UsrReal  usrReal ) {
           boolean  boo = usrRealService.save(usrReal);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新
         * @param usrReal {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody UsrReal   usrReal ,UserVO userVO){
        usrReal .setUpdateDate(new Date());
        usrReal .setUpdateBy(userVO.getId());
        usrReal .setUpdater(userVO.getUserName());
        boolean boo = usrRealService.updateById( usrReal);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }




}
