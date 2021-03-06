package com.ow.tracer.shop.usr.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ow.tracer.common.base.Mapper;
import com.ow.tracer.shop.usr.dto.UsrReal;


/**
 * 类描述:     [数据处理接口]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-14 22:16:05]
 * 版本:       [v1.0]
 */
public interface UsrRealMapper extends Mapper<UsrReal> {

    /**
     * <p>
     * 查询 : 分页查询用户，并关联role角色，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @return 分页对象
     */
    IPage<UsrReal> selectPage(Page page);

    UsrReal selectByUserId(String  userId);

}
