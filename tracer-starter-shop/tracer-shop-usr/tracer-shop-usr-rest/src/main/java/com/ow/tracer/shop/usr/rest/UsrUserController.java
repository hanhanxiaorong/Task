package com.ow.tracer.shop.usr.rest;

import com.ow.tracer.shop.usr.dto.UsrReal;
import com.ow.tracer.shop.usr.dto.UsrUser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.common.base.BaseController;
import com.ow.tracer.common.base.BaseEnums;
import com.ow.tracer.common.base.Result;
import com.ow.tracer.common.util.Results;
import com.ow.tracer.common.vo.UserVO;
import com.ow.tracer.shop.usr.service.IUsrRealService;
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
@RequestMapping("/usrUser")
public class UsrUserController extends BaseController {
    @Autowired
    private IUsrUserService usrUserService;
//    @Autowired
//    private IShopAccessoryService shopAccessoryService;
    @Autowired
    private IUsrRealService usrRealService;
    private Logger logger = LoggerFactory.getLogger(UsrUserController.class);
    /**
	 * 分页 PAGE(新，多表联查)
	 * @param current 当前页数
	 * @return 分页数据
	 */
	 @ApiOperation(value="获取分页数据",notes = "获取分页数据")
     @GetMapping(value="/pageList")
    public Result pageList(Integer current){
        Page page = new Page();
        page.setCurrent(current);
        page.setSize(20);
        IPage<UsrUser> usrUserIPage = usrUserService.page(page,null);
        List<UsrUser> list = usrUserIPage.getRecords();
//        for(UsrUser u:list){
//            fillUsrUser(u);//查询关联表填充自定义属性
//        }
        return Results.successWithData(usrUserIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<UsrUser> usrUserList =  usrUserService.list(new QueryWrapper<>());
        return Results.successWithData(usrUserList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        UsrUser usrUser = new UsrUser ();
        usrUser=usrUserService.getById(id);
//        fillUsrUser(usrUser);//查询关联表填充自定义属性
        return Results.successWithData(usrUser, BaseEnums.SUCCESS.desc());
    }
    /**
     * 根据ID删除
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = usrUserService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       *
       * @param usrUser {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody UsrUser  usrUser ) {
           boolean  boo = usrUserService.save(usrUser);
           fillAccessory(usrUser);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新
         * @param usrUser {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody UsrUser   usrUser ,UserVO userVO){
        usrUser .setUpdateDate(new Date());
        usrUser .setUpdateBy(userVO.getId());
        usrUser .setUpdater(userVO.getUserName());
        boolean boo = usrUserService.updateById( usrUser);

        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }

    /**
     * 填充并添加图片表数据
     * @param usrUser
     */
    public void fillAccessory(UsrUser usrUser){
        //ShopAccessory shopAccessory=new ShopAccessory();
        //填充图片表的数据然后添加（把生成的id存到usrUser的photoId中）

    }
//    /**
//     * 填充UsrUser实体自定义属性
//     * @param usrUser
//     */
//    public void fillUsrUser(UsrUser usrUser){
//        UsrReal usrReal=usrRealService.selectByUserId(usrUser.getId());
//        if(usrReal!=null){
//            usrUser.setTrueName(usrReal.getTrueName());
//            usrUser.setIdNumber(usrReal.getIdNumber());
//        }
//        //需要根据photoId查询shop_accessory表 把path字段村到自定义属性中
//
//    }


}
