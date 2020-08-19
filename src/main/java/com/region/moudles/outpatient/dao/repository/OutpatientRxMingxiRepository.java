package com.region.moudles.outpatient.dao.repository;

import com.region.moudles.outpatient.domain.OutpatientRxMingxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * <p>Title: OutpatientRxMingxiRepository.java</p>
 * <p>Description : 门诊处方详情</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * @date : 2019/8/8 11:26
 * @version : V1.0.0
 */
public interface OutpatientRxMingxiRepository extends JpaRepository<OutpatientRxMingxi,String> {

}
