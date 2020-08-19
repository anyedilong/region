package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dao.repository.SysSupplierRepository;
import com.region.moudles.system.domain.SysSupplier;
import com.region.moudles.system.dto.SysSupplierDto;
import com.region.until.StringUntil;

import java.util.List;

import javax.inject.Named;


@Named
public class SysSupplierDao extends BaseDao<SysSupplierRepository, SysSupplier>{

   /**
    *	 获取供应商列表（分页）
    * @param sysSupplierDto
    * @param page
    * @return
    */
   public void getSupplierPage(SysSupplierDto sysSupplierDto, PageModel page){
        StringBuffer sql = new StringBuffer();
   		sql.append(" select r.id, r.code, r.name, r.phone, r.address, r.update_time, r.remark, ");
   		sql.append(" r.update_user ");
   	    sql.append(" from sys_supplier r ");
   	    sql.append(" where r.status = '1' ");
   	    if(!StringUntil.isNull(sysSupplierDto.getName())) {
   	    	sql.append(" and r.name like concat(concat('%', :name), '%') ");
   	    }
   	    if(!StringUntil.isNull(sysSupplierDto.getCode())) {
   	    	sql.append(" and r.code like concat(concat('%', :code), '%') ");
   	    }
   		sql.append(" order by r.update_time desc ");
        queryPage(sql.toString(), sysSupplierDto, page, SysSupplierDto.class);
   }

   /**
    *	 获取供应商列表
    * @param sysSupplierDto
    * @return List<SysRoleDto>
    */
   public List<SysSupplierDto> getSupplierList(SysSupplierDto sysSupplierDto){
           StringBuffer sb = new StringBuffer();
           sb.append(" select r.id, r.code, r.name, r.phone, r.address, r.update_time, r.remark, ");
           sb.append(" r.update_user ");
           sb.append(" from sys_supplier r ");
           sb.append(" where r.status = '1' ");
           sb.append(" order by r.update_time desc ");
           return queryList(sb.toString(), sysSupplierDto, SysSupplierDto.class);
   }
   
}
