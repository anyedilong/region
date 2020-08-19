package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dao.repository.SysManufacturerRepository;
import com.region.moudles.system.domain.SysManufacturer;
import com.region.moudles.system.dto.SysManufacturerDto;
import com.region.until.StringUntil;

import java.util.List;

import javax.inject.Named;


@Named
public class SysManufacturerDao extends BaseDao<SysManufacturerRepository, SysManufacturer>{

   /**
    *	 获取生产厂商列表（分页）
    * @param sysManufacturerDto
    * @param page
    * @return
    */
   public void getManufacturerPage(SysManufacturerDto sysManufacturerDto, PageModel page){
        StringBuffer sql = new StringBuffer();
   		sql.append(" select r.id, r.code, r.name, r.phone, r.address, r.update_time, r.remark, ");
   		sql.append(" r.update_user ");
   	    sql.append(" from sys_manufacturer r ");
   	    sql.append(" where r.status = '1' ");
   	    if(!StringUntil.isNull(sysManufacturerDto.getName())) {
   	    	sql.append(" and r.name like concat(concat('%', :name), '%') ");
   	    }
   	    if(!StringUntil.isNull(sysManufacturerDto.getCode())) {
   	    	sql.append(" and r.code like concat(concat('%', :code), '%') ");
   	    }
   		sql.append(" order by r.update_time desc ");
        queryPage(sql.toString(), sysManufacturerDto, page, SysManufacturerDto.class);
   }

   /**
    *	 获取生产厂商列表
    * @param sysManufacturerDto
    * @return List<SysManufacturerDto>
    */
   public List<SysManufacturerDto> getManufacturerList(SysManufacturerDto sysManufacturerDto){
           StringBuffer sb = new StringBuffer();
           sb.append(" select r.id, r.code, r.name, r.phone, r.address, r.update_time, r.remark, ");
           sb.append(" r.update_user ");
           sb.append(" from sys_manufacturer r ");
           sb.append(" where r.status = '1' ");
           sb.append(" order by r.update_time desc ");
           return queryList(sb.toString(), sysManufacturerDto, SysManufacturerDto.class);
   }
   
}
