package com.ow.tracer.shop.store.rest;

import com.ow.tracer.common.util.TreeUtil;
import com.ow.tracer.shop.store.dto.StoreFeature;
import com.ow.tracer.shop.store.dto.StoreFeatureTree;
import com.ow.tracer.shop.store.dto.tree.CurrencyTree;
import com.ow.tracer.shop.store.service.IStoreFeatureService;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 类描述:     [店铺分类规格表
1:n:n 关系控制器]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-09 18:27:32]
 * 版本:       [v1.0]
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/storeFeature")
public class StoreFeatureController extends BaseController {
    @Autowired
    private IStoreFeatureService storeFeatureService;
    private Logger logger = LoggerFactory.getLogger(StoreFeatureController.class);

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
        IPage<StoreFeature> storeFeatureIPage = storeFeatureService.page(page,null);
        return Results.successWithData(storeFeatureIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
    /**
     * 审批树表格
     * @param current 当前页数
     * @return 分页数据
     */
    @ApiOperation(value="获取规格审批数据",notes = "获取规格数据")
    @GetMapping(value="/featureTreeApply")
    public Result featureTreeApply(){
        List<StoreFeatureTree> trees = new ArrayList<>();
        List<StoreFeature> allList =storeFeatureService.list(new QueryWrapper<StoreFeature>());
        allList.forEach(storeFeature -> {
        StoreFeatureTree storeFeatureTree = new StoreFeatureTree(storeFeature);
        trees.add(storeFeatureTree);
        });
        return  Results.successWithData(TreeUtil.bulid(trees, "3"), BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
    /**
     * 审批树表格
     * @param current 当前页数
     * @return 分页数据
     */
    @ApiOperation(value="获取规格数据",notes = "获取规格数据")
    @GetMapping(value="/featureTreeClass")
    public Result featureTreeClass() {
        List<StoreFeature> allList =  storeFeatureService.list(new QueryWrapper<StoreFeature>().eq("approve_status",1).lt("level",3));
        List<CurrencyTree> trees = new ArrayList<>();
        allList.forEach(storeFeature -> {
            CurrencyTree currencyTree = new CurrencyTree(storeFeature);
            trees.add(currencyTree);
        });
        return  Results.successWithData(TreeUtil.bulid(trees, "-1"), BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());

    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<StoreFeature> storeFeatureList =  storeFeatureService.list(new QueryWrapper<>());
        return Results.successWithData(storeFeatureList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        StoreFeature storeFeature = new StoreFeature ();
        storeFeature=storeFeatureService.getById(id);
        return Results.successWithData(storeFeature, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除店铺分类规格表
1:n:n 关系
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = storeFeatureService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }
    /**
     * 根据ID删除店铺分类规格表
     1:n:n 关系
     * @param id 编号
     * @return success/false
     */

    @PutMapping("/checkSuccess/{id}")
    public Result checkSuccess(@PathVariable String   id) {
        System.out.println(id);
        List<StoreFeature> list = storeFeatureService.list(new QueryWrapper<StoreFeature>().eq("id",id).or().eq("parent_id",id));
        list.forEach(storeFeature -> {
            try {
                storeFeature.setApproveStatus(1);
                storeFeatureService.updateById(storeFeature);
            }catch (Exception e){
            }
        });
    return Results.success();
    }

     /**
       * 添加{data.describe}
       *
       * @param storeFeature {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody StoreFeature  storeFeature ) {
           boolean  boo = storeFeatureService.save(storeFeature);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
        /**
       	 * 更新店铺分类规格表
            1:n:n 关系
         * @param storeFeature {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody StoreFeature   storeFeature ,UserVO userVO){
        storeFeature .setUpdateDate(new Date());
        storeFeature .setUpdateBy(userVO.getId());
        storeFeature .setUpdater(userVO.getUserName());
        boolean boo = storeFeatureService.updateById( storeFeature);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }

}
