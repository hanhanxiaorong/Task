package com.ow.tracer.shop.usr.service;

import com.ow.tracer.shop.usr.dto.UsrCoupon;
import com.ow.tracer.common.base.BaseService;

import java.util.List;

/**
 * 类描述:     [业务接口]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
public interface IUsrCouponService extends BaseService<UsrCoupon> {

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    List<UsrCoupon> listByUserId(String userId);

}
