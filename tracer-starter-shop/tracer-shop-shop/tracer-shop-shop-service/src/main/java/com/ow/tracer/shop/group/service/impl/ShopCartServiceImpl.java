package com.ow.tracer.shop.group.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.shop.group.dto.ShopCart;
import com.ow.tracer.shop.group.mapper.ShopCartMapper;
import com.ow.tracer.shop.group.service.IShopCartService;
import com.ow.tracer.common.constats.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 类描述:     [购物车表业务接口实现类]
 * 创建人:     [JiangYanpeng]
 * 创建时间:   [2019-01-09 11:15:59]
 * 版本:       [v1.0]
 */
@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartMapper, ShopCart> implements IShopCartService {


}
