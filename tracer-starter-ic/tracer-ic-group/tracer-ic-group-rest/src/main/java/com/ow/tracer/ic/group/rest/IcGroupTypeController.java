package com.ow.tracer.ic.group.rest;

import com.ow.tracer.ic.group.dto.IcGroupType;
import com.ow.tracer.ic.group.service.IIcGroupTypeService;
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
 * 创建人:     [江雪立]
 * 创建时间:   [2018-12-24 21:04:07]
 * 版本:       [v1.0]
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/icGroupType")
public class IcGroupTypeController extends BaseController {
    @Autowired
    private IIcGroupTypeService icGroupTypeService;
    private Logger logger = LoggerFactory.getLogger(IcGroupTypeController.class);

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
        IPage<IcGroupType> icGroupTypeIPage = icGroupTypeService.page(page,null);
        return Results.successWithData(icGroupTypeIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<IcGroupType> icGroupTypeList =  icGroupTypeService.list(new QueryWrapper<>());
        return Results.successWithData(icGroupTypeList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        IcGroupType icGroupType = new IcGroupType ();
        icGroupType=icGroupTypeService.getById(id);
        return Results.successWithData(icGroupType, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = icGroupTypeService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       *
       * @param icGroupType {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody IcGroupType  icGroupType ) {
           boolean  boo = icGroupTypeService.save(icGroupType);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新
         * @param icGroupType {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody IcGroupType   icGroupType ,UserVO userVO){
        icGroupType .setUpdateDate(new Date());
        icGroupType .setUpdateBy(userVO.getId());
        icGroupType .setUpdater(userVO.getUserName());
        boolean boo = icGroupTypeService.updateById( icGroupType);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }

}
