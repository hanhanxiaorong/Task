package com.ow.tracer.admin.account.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.admin.account.dto.Dept;
import com.ow.tracer.admin.account.service.IDeptService;
import com.ow.tracer.admin.account.vo.DeptTree;
import com.ow.tracer.core.base.BaseController;
import com.ow.tracer.core.base.BaseEnums;
import com.ow.tracer.core.base.Result;
import com.ow.tracer.core.constats.CommonConstant;
import com.ow.tracer.core.util.Results;
import com.ow.tracer.core.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @auther: Easy
 * @Date: 18-10-18 23:04
 * @Description:
 */
/**
 * @auther: Easy
 * @Date: 18-9-25 23:52
 * @Description:
 */
@RestController
@RequestMapping("/dept")
public class DeptController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IDeptService deptService;
    @GetMapping(value="/pageList")
    public Result pageList(Integer current){
        Page page = new Page();
        page.setCurrent(current);
        page.setSize(20);
        IPage<Dept> userVOIPage = deptService.page(page,null);
        return Results.successWithData(userVOIPage, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
    @GetMapping(value="/allList")
    public Result allList(){
        List<Dept> deptList =  deptService.list(new QueryWrapper<>());
        return Results.successWithData(deptList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
    @GetMapping(value="/tree")
    public Result getTree() {
        Dept condition = new Dept();
        condition.setDelFlag(CommonConstant.STATUS_NORMAL);
        List<DeptTree> treeList = deptService.selectListTree(new QueryWrapper<>(condition));
        logger.info("treeList查出有+："+treeList.size());
        return Results.successWithData(treeList, BaseEnums.SUCCESS.desc());
    }
    /**
     * 通过ID查询
     *
     * @param id ID
     * @return Dept
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        Dept dept = new Dept();
        dept=deptService.getById(id);
        return Results.successWithData(dept, BaseEnums.SUCCESS.desc());
    }
    /**
     * 添加
     *
     * @param sysDept 实体
     * @return success/false
     */
    @PostMapping("/add")
    public Result add(@RequestBody Dept  sysDept) {

        boolean  boo = deptService.insertDept(sysDept);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }
    /**
     * 删除部门
     * 确定部门下无实际用户则可删除
     *
     * @param id 实体
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Result del(@PathVariable String  id) {
        boolean  boo = deptService.delDept(id);
        return Results.successWithData(boo, BaseEnums.SUCCESS.desc());
    }
    @PutMapping("/edit")
    public Result edit(@RequestBody Dept dept ,UserVO userVO){

        dept.setUpdateDate(new Date());
        dept.setUpdateBy(userVO.getId());
        dept.setUpdater(userVO.getUserName());
        boolean boo = deptService.updateById(dept);
        return  Results.successWithData(boo,BaseEnums.SUCCESS.desc());
    }
}

