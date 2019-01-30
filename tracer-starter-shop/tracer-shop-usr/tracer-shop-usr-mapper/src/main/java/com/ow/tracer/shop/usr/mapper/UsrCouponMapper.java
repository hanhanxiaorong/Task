package com.ow.tracer.shop.usr.mapper;

import com.ow.tracer.common.base.Mapper;
import com.ow.tracer.shop.usr.dto.UsrCoupon;

import java.util.List;


/**
 * 类描述:     [数据处理接口]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
public interface UsrCouponMapper extends Mapper<UsrCoupon> {

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    List<UsrCoupon> listByUserId(String userId);

}
