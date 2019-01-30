package com.ow.tracer.shop.usr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.shop.usr.dto.UsrUser;
import com.ow.tracer.shop.usr.mapper.UsrUserMapper;
import com.ow.tracer.shop.usr.service.IUsrUserService;
import org.springframework.stereotype.Service;

/**
 * 类描述:     [业务接口实现类]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
@Service
public class UsrUserServiceImpl extends ServiceImpl<UsrUserMapper, UsrUser> implements IUsrUserService {

    /**
     * 根据不同条件查询用户是否存在
     * @param usrUser 实体
     * @return
     */
    public Long countByMap(UsrUser usrUser){
        Long count=this.baseMapper.countByMap(usrUser);
            return count;
    }


}
