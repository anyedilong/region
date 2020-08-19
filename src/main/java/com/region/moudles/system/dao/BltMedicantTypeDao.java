package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dao.repository.BltMedicantTypeRepository;
import com.region.moudles.system.domain.BltMedicantType;
import com.region.moudles.system.dto.MedicantTypeDto;
import com.region.moudles.system.dto.SysDrugDto;
import com.region.until.StringUntil;

import java.util.List;

import javax.inject.Named;


@Named
public class BltMedicantTypeDao extends BaseDao<BltMedicantTypeRepository, BltMedicantType>{

	/**
     *	 获取药品列表（分页）
     * @param
     * @param page
     * @return
     */
    public void getMedicantTypePage(MedicantTypeDto info, PageModel page){
            StringBuffer sql = new StringBuffer();
    		sql.append(" select r.id, r.code,r.simple_py as simplePinyin, r.name, r.usage, r.class_level, r.class_base, r.class_zw, ")
    			.append(" to_char(r.update_time, 'yyyy-mm-dd') as updateTime ")
    			.append(" from blt_medicant_type r ")
    			.append(" where r.status ='0' ");
    		if(!StringUntil.isNull(info.getName())) {
    			sql.append(" and r.name like concat('%', concat(:name, '%'))");
    		}
    		if(!StringUntil.isNull(info.getSimplePinyin())) {
    			sql.append(" and r.simple_py like concat('%', concat(:simplePinyin, '%'))");
    		}
    		if(!StringUntil.isNull(info.getClassLevel())) {
    			sql.append(" and r.class_level = :classLevel ");
    		}
    		if(!StringUntil.isNull(info.getClassZw())) {
    			sql.append(" and r.class_zw = :classZw ");
    		}
    		if(!StringUntil.isNull(info.getClassBase())) {
    			sql.append(" and r.class_base = :classBase ");
    		}
    		if(!StringUntil.isNull(info.getStartDate())) {
    			sql.append(" and r.update_time >= to_date(:startDate, 'yyyy-mm-dd') ");
    		}
    		if(!StringUntil.isNull(info.getEndDate())) {
    			sql.append(" and r.update_time <= to_date(:endDate, 'yyyy-mm-dd') ");
    		}
    		//sql.append(" order by r.update_time desc ");
            queryPage(sql.toString(), info, page, MedicantTypeDto.class);
    }

    /**
     *	 获取药品列表
     * @param
     * @return List<SysRoleDto>
     */
    public List<MedicantTypeDto> getMedicantTypeList(MedicantTypeDto info){
            StringBuffer sql = new StringBuffer();
            sql.append(" select r.id, r.code,r.simple_py as simplePinyin,r.name, r.usage, r.class_level, r.class_base, r.class_zw ")
            .append(" to_char(r.update_time, 'yyyy-mm-dd') as updateTime ")
			.append(" from blt_medicant_type r ")
			.append(" where r.status ='0' ");
            if(!StringUntil.isNull(info.getName())) {
    			sql.append(" and r.name like concat('%', concat(:name, '%'))");
    		}
    		if(!StringUntil.isNull(info.getSimplePinyin())) {
    			sql.append(" and r.simple_py like concat('%', concat(:simplePinyin, '%'))");
    		}
    		if(!StringUntil.isNull(info.getClassLevel())) {
    			sql.append(" and r.class_level = :classLevel");
    		}
    		if(!StringUntil.isNull(info.getStartDate())) {
    			sql.append(" and r.update_time >= to_date(:startDate, 'yyyy-mm-dd') ");
    		}
    		if(!StringUntil.isNull(info.getEndDate())) {
    			sql.append(" and r.update_time <= to_date(:endDate, 'yyyy-mm-dd') ");
    		}
    		sql.append(" order by r.update_time desc ");
            return queryList(sql.toString(), info, MedicantTypeDto.class);
    }

    public List<SysDrugDto>  getdrug(){
    	 StringBuffer sb=new StringBuffer();
    	 sb.append("select m.code drugCode,m.name drugName,m.class_level drugType,m.class_base drugHeds,m.class_zw drugCountries,m.units drugUnit from blt_medicant_type m ");
    	 return  queryList(sb.toString(),null,SysDrugDto.class);
	}
}
