package com.ow.tracer.shop.usr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.shop.usr.dto.UsrReal;
import com.ow.tracer.shop.usr.mapper.UsrRealMapper;
import com.ow.tracer.shop.usr.service.IUsrRealService;
import org.springframework.stereotype.Service;

/**
 * 类描述:     [业务接口实现类]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
@Service
public class UsrRealServiceImpl extends ServiceImpl<UsrRealMapper, UsrReal> implements IUsrRealService {

    @Override
    public UsrReal selectByUserId(String userId){
        UsrReal usrReal = this.baseMapper.selectByUserId(userId);
        return usrReal;
    }
}
