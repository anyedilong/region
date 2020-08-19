package com.region.moudles.outpatient.dao.repository;

import com.region.moudles.outpatient.domain.OutpatientCost;
import com.region.moudles.outpatient.domain.OutpatientJc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * <p>Title: OutpatientCostRepository.java</p>
 * <p>Description : 门诊结算</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * @date : 2019/8/8 11:25
 * @version : V1.0.0
 */
public interface OutpatientCostRepository extends JpaRepository<OutpatientCost,String> {

    /**
     * 根据收据单号查询结算详情
     * @author : 皮雪平
     * @date : 2019/8/8 11:20
     */
    @Query("from OutpatientCost t where t.receiptNum=?1")
    OutpatientCost getOutpatientCost(String receiptNum);

}
