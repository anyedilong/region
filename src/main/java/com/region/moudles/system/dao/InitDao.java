package com.region.moudles.system.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;
import com.region.moudles.common.dao.QueryDao;
import com.region.moudles.common.utils.cache.AreaCache;
import com.region.moudles.common.utils.cache.DictCache;
import com.region.moudles.system.dto.MedicantTypeDto;
import com.region.moudles.system.dto.SysDiseaseDto;


@Named
public class InitDao extends QueryDao {

	public List<MedicantTypeDto> getAllMedicantList(){
        StringBuffer sb=new StringBuffer();
        sb.append(" select r.id, r.code,r.simple_py as simplePinyin, r.name, r.usage, r.class_level, r.class_base, r.class_zw from blt_medicant_type r ");
        return queryList(sb.toString(), null, MedicantTypeDto.class);
	}
	public List<SysDiseaseDto>  getAllDisease(){
		StringBuffer sb=new StringBuffer();
		sb.append("select a.disease_code,a.disease_name,a.disease_type disease_type_code from sys_disease a");
		return  queryList(sb.toString(),null,SysDiseaseDto.class);
	}

	public List<DictCache> getDictCache() {
		
		StringBuffer sql = new StringBuffer();		
		sql.append(" select ds.id id, ds.dict_id dictId, ds.text text, ds.value value,ds.order_num orderNum,ds.status, d.code ")
			.append("   from sys_dict_sub ds ")
			.append("   join sys_dict d on d.id = ds.dict_id where ds.status !=3 and d.status != 3 ");
		
		return queryList(sql.toString(), null, DictCache.class);
	}
	
	public List<AreaCache> getAreaCache(String areaCode) {
		
		StringBuffer sql = new StringBuffer();		
		sql.append(" select a.id id, a.area_name areaName, a.area_code areaCode, a.parent_id parentId, a.area_level areaLevel ")
			.append("   from sys_area a ")
			.append("   where a.status = '1' and (a.area_code like concat(:areaCode, '%') ")
			.append("   or a.id = '7c9ff51b995c4480b06d4f96fd1f6dd2') ");
		Map<String, Object> map = new HashMap<>();
		map.put("areaCode", areaCode);
		return queryList(sql.toString(), map, AreaCache.class);
	}
}
