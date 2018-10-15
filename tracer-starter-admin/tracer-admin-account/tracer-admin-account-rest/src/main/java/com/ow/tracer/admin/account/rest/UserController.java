package com.ow.tracer.admin.account.rest;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.admin.account.dto.User;
import com.ow.tracer.admin.account.dto.UserInfo;
import com.ow.tracer.admin.account.service.IUserService;
import com.ow.tracer.core.base.BaseController;
import com.ow.tracer.core.base.BaseEnums;
import com.ow.tracer.core.base.Result;
import com.ow.tracer.core.constats.Constants;
import com.ow.tracer.core.util.Dates;
import com.ow.tracer.core.util.Results;
import com.ow.tracer.core.vo.UserVO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: Easy
 * @Date: 18-9-7 22:31
 * @Description:
 */
@RestController
@RequestMapping("/user")

public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ResponseBody
    public Result userInfo(UserVO userVO){
        QueryWrapper<User> ew = new QueryWrapper<User>();
        ew.eq("user_name",userVO.getUserName());
        UserInfo user = iUserService.getUserInfo(userVO);
        return Results.successWithData(user, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
    /**
     * 用户信息校验
     * @param authentication 信息
     * @return 用户信息
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Object user() {
            // 获取当前用户资源
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("authentication:{}",authentication);
        return "order id : " + 12;
    }
    @GetMapping(value="/allUser")
    public Result allUser(Integer pages,Integer total){
        Page page = new Page();
        IPage<UserVO> userVOIPage = iUserService.selectUserPage(page);
        return Results.successWithData(userVOIPage, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }


}