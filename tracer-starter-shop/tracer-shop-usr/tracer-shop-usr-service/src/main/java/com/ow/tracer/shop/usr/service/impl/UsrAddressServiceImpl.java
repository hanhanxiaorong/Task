package com.ow.tracer.shop.usr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.shop.usr.dto.UsrAddress;
import com.ow.tracer.shop.usr.mapper.UsrAddressMapper;
import com.ow.tracer.shop.usr.service.IUsrAddressService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述:     [业务接口实现类]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
@Service
public class UsrAddressServiceImpl extends ServiceImpl<UsrAddressMapper, UsrAddress> implements IUsrAddressService {
    /**
     * 分页查询
     * @param page
     * @param queryWrapper
     * @return
     */
    @Override
    public IPage<UsrAddress> listAll(Page page, QueryWrapper queryWrapper){
        IPage<UsrAddress> usrAddressIPage=this.baseMapper.listAll(page,queryWrapper);
        return usrAddressIPage;
    }

    /**
     *  根据用户id查询所有，默认地址在地一个
     * @param userId
     * @return
     */
    @Override
    public List<UsrAddress> allByUserId(String userId){
        List<UsrAddress> usrAddressList=this.baseMapper.allByUserId(userId);
        return usrAddressList;
    }
    /**
     *  根据用户id查询默认收获地址
     * @param userId
     * @return
     */
    @Override
    public UsrAddress selectTypeByUserId(String userId){
        UsrAddress usrAddress=this.baseMapper.selectTypeByUserId(userId);
        return usrAddress;
    }
}
