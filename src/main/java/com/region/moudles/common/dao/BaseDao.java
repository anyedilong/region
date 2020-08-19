package com.region.moudles.common.dao;

import com.region.moudles.common.domain.BaseDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Inject;
import java.util.List;

public class BaseDao<R extends JpaRepository,B extends BaseDomain> extends QueryDao{


    @Inject
    protected  R repository;


    /**
     * 	保存
     * @param domain
     */
    public  void save(B domain){
          repository.save(domain);
    }
    public void save(List<B> list){
        repository.save(list);
    }

    /**
     *	查询单条数据
     * @param id
     * @return
     */
    public B  get(String id){
        return   (B)repository.getOne(id);
    }

    public B  getById(String id){
        return   (B)repository.findOne(id);
    }

    /**
     *	 删除数据
     * @param id
     */
    public void delete(String id){
        repository.delete(id);
    }

    /**
	 * 	数据是否存在
	 */
	public boolean exists(String id) {
		return repository.exists(id);
	}


}
