package com.region.moudles.outpatient.dao.repository;

import com.region.moudles.outpatient.domain.OutpatientRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * <p>Title: OutpatientRecipeRepository.java</p>
 * <p>Description : 门诊处方</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * @date : 2019/8/8 11:26
 * @version : V1.0.0
 */
public interface OutpatientRecipeRepository extends JpaRepository<OutpatientRecipe,String> {

    /**
     * 根据身份证号查询处方列表
     * @author : 皮雪平
     * @date : 2019/8/7 11:08
     */
    @Query("from OutpatientRecipe t where t.sfzh=?1")
    List<OutpatientRecipe> getOutpatientCfIBySfzh(String sfzh);

    /**
     * 根据身份证号和处方编号查询处方详情
     * @author : 皮雪平
     * @date : 2019/8/7 11:08
     */
    @Query("from OutpatientRecipe t where t.sfzh=?1 and t.recipeNum = ?2")
    OutpatientRecipe getOutpatientCfIBySfzhAndOrID(String sfzh,String orID);
}
