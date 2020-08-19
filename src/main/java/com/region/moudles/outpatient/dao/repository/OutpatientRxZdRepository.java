package com.region.moudles.outpatient.dao.repository;

import com.region.moudles.outpatient.domain.OutpatientRxZd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * <p>Title: OutpatientRxZdRepository.java</p>
 * <p>Description : 门诊处方诊断</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * @date : 2019/8/8 11:27
 * @version : V1.0.0
 */
public interface OutpatientRxZdRepository  extends JpaRepository<OutpatientRxZd,String>{

}
