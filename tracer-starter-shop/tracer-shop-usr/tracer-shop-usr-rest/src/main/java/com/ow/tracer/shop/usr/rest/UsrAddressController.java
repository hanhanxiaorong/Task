package com.ow.tracer.shop.usr.rest;

import com.ow.tracer.shop.usr.dto.UsrAddress;
import com.ow.tracer.shop.usr.service.IUsrAddressService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.common.base.BaseController;
import com.ow.tracer.common.base.BaseEnums;
import com.ow.tracer.common.base.Result;
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
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/usrAddress")
public class UsrAddressController extends BaseController {
    @Autowired
    private IUsrAddressService usrAddressService;
    private Logger logger = LoggerFactory.getLogger(UsrAddressController.class);

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
        IPage<UsrAddress> usrAddressIPage = usrAddressService.listAll(page,null);
        return Results.successWithData(usrAddressIPage , BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
        /**
    	 * 全部list
    	 * @return List实体集合
    	 */
    @GetMapping(value="/allList")
    public Result allList(){
        List<UsrAddress> usrAddressList =  usrAddressService.list(new QueryWrapper<>());
        return Results.successWithData(usrAddressList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    /**
     * 通过ID查询
     * @param id ID
     * @return Dept
     */

    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        UsrAddress usrAddress = new UsrAddress ();
        usrAddress=usrAddressService.getById(id);
        return Results.successWithData(usrAddress, BaseEnums.SUCCESS.desc());
    }

    /**
     * 根据ID删除
     * @param id 编号
     * @return success/false
     */

    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = usrAddressService.removeById(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }

     /**
       * 添加{data.describe}
       *
       * @param usrAddress {data.describe}
       * @return success/false
       */

       @PostMapping("/add")
       public Result add(@RequestBody UsrAddress  usrAddress ) {
           usrAddress.setUserId("156156165156");//测试写死了一个，回头删掉
           if(usrAddress.getType()==1) {
               UsrAddress usrAddress1 = usrAddressService.selectTypeByUserId(usrAddress.getUserId());
               if (usrAddress1 != null) {
                   usrAddress1.setType(0);
                   usrAddressService.updateById(usrAddress1);
               }
           }
           boolean  boo = usrAddressService.save(usrAddress);
           return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
       }
     /**
       	 * 更新
         * @param usrAddress {data.describe} UserVO user操作用户
         * @return success/false
       	 */
        @PutMapping("/edit")
       public Result edit(@RequestBody UsrAddress   usrAddress ,UserVO userVO){
        usrAddress .setUpdateDate(new Date());
        usrAddress .setUpdateBy(userVO.getId());
        usrAddress .setUpdater(userVO.getUserName());
        if(usrAddress.getType()==1){
            //查询他有没有默认收获地址
            UsrAddress usrAddress1=usrAddressService.selectTypeByUserId(usrAddress.getUserId());
            if(usrAddress1!=null){
                usrAddress1.setType(0);
                usrAddressService.updateById(usrAddress1);
            }
        }
        boolean boo = usrAddressService.updateById( usrAddress);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }


}
