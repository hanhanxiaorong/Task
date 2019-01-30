package com.ow.tracer.shop.usr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.shop.usr.dto.UsrCoupon;
import com.ow.tracer.shop.usr.mapper.UsrCouponMapper;
import com.ow.tracer.shop.usr.service.IUsrCouponService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述:     [业务接口实现类]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
@Service
public class UsrCouponServiceImpl extends ServiceImpl<UsrCouponMapper, UsrCoupon> implements IUsrCouponService {

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    public List<UsrCoupon> listByUserId(String userId){
        List<UsrCoupon> coupons=this.baseMapper.listByUserId(userId);
        return coupons;
    }
}
