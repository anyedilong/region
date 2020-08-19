package com.region.moudles.outpatient.dao.repository;

import com.region.moudles.outpatient.domain.OutpatientJc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * <p>Title: OupatientJcRepository.java</p>
 * <p>Description : 门诊检验</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * @date : 2019/8/8 11:21
 * @version : V1.0.0
 */
public interface OupatientJcRepository extends JpaRepository<OutpatientJc,String> {

    /**
     * 根据门诊识别号查询门诊检验信息列表
     * @author : 皮雪平
     * @date : 2019/8/8 11:21
     */
    @Query("from OutpatientJc t where t.outpatientNum=?1")
    List<OutpatientJc> getOutpatientMzjy(String outpatientNum);
}
