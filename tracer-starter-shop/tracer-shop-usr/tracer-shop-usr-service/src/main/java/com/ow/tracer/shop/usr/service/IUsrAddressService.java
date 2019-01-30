package com.ow.tracer.shop.usr.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ow.tracer.shop.usr.dto.UsrAddress;
import com.ow.tracer.common.base.BaseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 类描述:     [业务接口]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
public interface IUsrAddressService extends BaseService<UsrAddress> {

    IPage<UsrAddress> listAll(Page page, QueryWrapper queryWrapper);

    List<UsrAddress> allByUserId(String userId);

    UsrAddress selectTypeByUserId(String userId);

}
