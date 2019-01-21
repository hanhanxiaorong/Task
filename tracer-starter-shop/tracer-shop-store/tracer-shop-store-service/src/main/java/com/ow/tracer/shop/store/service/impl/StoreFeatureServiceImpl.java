package com.ow.tracer.shop.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.shop.store.dto.StoreFeature;
import com.ow.tracer.shop.store.mapper.StoreFeatureMapper;
import com.ow.tracer.shop.store.service.IStoreFeatureService;
import com.ow.tracer.common.constats.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 类描述:     [店铺分类规格表
1:n:n 关系业务接口实现类]
 * 创建人:     [江雪立]
 * 创建时间:   [2019-01-09 18:27:32]
 * 版本:       [v1.0]
 */
@Service
public class StoreFeatureServiceImpl extends ServiceImpl<StoreFeatureMapper, StoreFeature> implements IStoreFeatureService {


}
