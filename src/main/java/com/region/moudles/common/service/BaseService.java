package com.region.moudles.common.service;

import com.region.moudles.common.domain.BaseDomain;
import com.region.moudles.common.domain.PageModel;

import java.util.List;

public interface BaseService<T extends BaseDomain> {



    /**
     * 保存数据（插入或更新）
     *
     * @param
     */
    public void save(T entity);

    /**
     * 删除数据
     *
     * @param
     */
    public void delete(String id);

    public T get(String id);

}
