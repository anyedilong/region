package com.region.moudles.system.dao;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dao.repository.SysPOCTResultRepository;
import com.region.moudles.system.domain.SysPOCTResult;
import com.region.moudles.system.dto.SysPOCTResultDto;
import com.region.until.StringUntil;


@Named
public class SysPOCTResultDao extends BaseDao<SysPOCTResultRepository, SysPOCTResult>{

   /**
    *	 获取供应商列表（分页）
    * @param sysSupplierDto
    * @param page
    * @return
    */
   public void getNucleinResultPage(SysPOCTResultDto nucleinResultDto, PageModel page){
        StringBuffer sql = new StringBuffer();
   		sql.append(" select j.sfzh, j.hzmc as residentName, j.xb, floor(MONTHS_BETWEEN(sysdate, j.csrq)/12) as nl,  ");
   		sql.append(" 	j.jtzz, r.pro_name, r.pro_group_name, r.check_result, r.check_time, r.unit, r.pro_desc, o.org_name, r.doctor_name ");
   		sql.append(" from sys_poct_result r ");
   	    sql.append(" join sys_org o on r.org_code = o.org_code ");
   	    sql.append(" join blt_jbxxjlb j on r.resident_id = j.id ");
   	    sql.append(" where (j.sfsc = 'N' or j.sfsc is null) ");
   	    if(!StringUntil.isNull(nucleinResultDto.getOrgName())) {
   	    	sql.append(" and o.org_name like concat('%', concat(:orgName, '%')) ");
   	    }
   	    if(!StringUntil.isNull(nucleinResultDto.getOrgCode())) {
   	    	sql.append(" and o.org_code like concat('%', concat(:orgCode, '%')) ");
	    }
   	    if(!StringUntil.isNull(nucleinResultDto.getSfzh())) {
   	    	sql.append(" and j.sfzh like concat('%', concat(:sfzh, '%')) ");
	    }
   	    if(!StringUntil.isNull(nucleinResultDto.getResidentName())) {
   	    	sql.append(" and r.resident_name like concat('%', concat(:residentName, '%')) ");
	    }
   		sql.append(" order by r.check_time desc ");
        queryPage(sql.toString(), nucleinResultDto, page, SysPOCTResultDto.class);
   }

   
}
