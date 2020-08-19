package com.region.moudles.common.service.impl;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.StringUntil;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

public class BaseServiceImpl<R extends BaseDao,T extends BaseDomain> {

    @Inject
    protected R dao;

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public T get(String id) {
        return (T) dao.get(id);
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param
     */
    @Transactional(readOnly = false)
    public void save(T entity) {

        dao.save(entity);
    }
    /**
     * 删除数据
     *
     * @param
     */
    @Transactional(readOnly = false)
    public void delete(String id) {
        dao.delete(id);
    }

}
