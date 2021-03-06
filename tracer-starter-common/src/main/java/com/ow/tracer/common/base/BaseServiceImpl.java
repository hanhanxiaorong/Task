package com.ow.tracer.common.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlHelper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @auther: Easy
 * @date: 18-11-21 18:01
 * @description:
 */
public class BaseServiceImpl < M extends BaseMapper<T>,T extends BaseDTO> extends ServiceImpl<M,T> implements BaseService <T>{
    @Override
    public boolean save(T entity) {
        return retBool(this.baseMapper.insert(entity));
    }
//    @Cacheable(value = "getById",keyGenerator = "caChekeyGenerator")
    @Override
    public T getById(Serializable id) {
        return this.baseMapper.selectById(id);
    }
//    @Cacheable(value = "getOne",keyGenerator = "caChekeyGenerator")
    @Override
public T getOne(Wrapper<T> queryWrapper) {
        return SqlHelper.getObject(this.baseMapper.selectList(queryWrapper));
    }
//    @Caching(
//            put = {
//                    @CachePut(value = "getById",keyGenerator = "caChekeyGenerator"),
//                    @CachePut(value = "getOne",keyGenerator = "caChekeyGenerator"),
//                    @CachePut(value = "list",keyGenerator = "caChekeyGenerator"),
//                    @CachePut(value = "page",keyGenerator = "caChekeyGenerator")
//
//            })

    public boolean saveOrUpdate(T entity) {
        return super.saveOrUpdate(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean updateById(T entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean update(T entity, Wrapper<T> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    public Collection<T> listByIds(Collection<? extends Serializable> idList) {
        return super.listByIds(idList);
    }

    @Override
    public Object getObj(Wrapper<T> queryWrapper) {
        return super.getObj(queryWrapper);
    }
//    @Cacheable(value = "list",keyGenerator = "caChekeyGenerator")
    @Override
    public List<T> list(Wrapper<T> queryWrapper) {
        return super.list(queryWrapper);
    }
//    @Cacheable(value = "page",keyGenerator = "caChekeyGenerator")
    @Override
    public IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper) {
        return super.page(page, queryWrapper);
    }
//    @Cacheable(value = "pageMaps",keyGenerator = "caChekeyGenerator")

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<T> page, Wrapper<T> queryWrapper) {
        return super.pageMaps(page, queryWrapper);
    }
}
