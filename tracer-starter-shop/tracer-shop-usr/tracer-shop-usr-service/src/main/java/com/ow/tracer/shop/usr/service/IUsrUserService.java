package com.ow.tracer.shop.usr.service;

import com.ow.tracer.shop.usr.dto.UsrUser;
import com.ow.tracer.common.base.BaseService;

/**
 * 类描述:     [业务接口]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
public interface IUsrUserService extends BaseService<UsrUser> {



    /**
     * 根据不同条件查询用户是否存在
     * @param usrUser 实体
     * @return
     */
    Long countByMap(UsrUser usrUser);



}
