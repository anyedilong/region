package com.region.moudles.system.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.system.dao.repository.SysDiseaseRepository;
import com.region.moudles.system.domain.SysDiseaseDomain;
import com.region.moudles.system.dto.InitDictDto;
import com.region.moudles.system.dto.SysDiseaseDto;
import com.region.moudles.system.dto.SysDiseaseTypeDto;
import com.region.until.cache.CacheEmun;
import com.region.until.cache.CacheUtils;

@Named
public class SysDiseaseDao extends BaseDao<SysDiseaseRepository,SysDiseaseDomain> {


    public List<SysDiseaseTypeDto> gettype(){
         StringBuffer sql=new StringBuffer();
         sql.append("select a.disease_type,a.disease_type_code from sys_disease_type a");
       return    queryList(sql.toString(),null,SysDiseaseTypeDto.class);
    }

    public List<SysDiseaseDto> getDisease(String type){
//        Map<String,String> map=new HashMap<String,String>();
//        StringBuffer sql=new StringBuffer();
//        sql.append(" select a.disease_code,a.disease_name,a.disease_type disease_type_code from sys_disease a  where a.disease_type=:type ");
//        map.put("type",type);
//       return   queryList(sql.toString(),map,SysDiseaseDto.class);
          List<SysDiseaseDto> list=CacheUtils.getArray(CacheEmun.SYS_CACHE,CacheUtils.SYS_DISEASE,SysDiseaseDto.class);
          return  list.stream().filter((x) -> type.equals(x.getDiseaseTypeCode())).collect(Collectors.toList());
    }
    
    public List<InitDictDto> queryDiseaseList(){
    	StringBuffer sql=new StringBuffer();
        sql.append(" select a.disease_type as name, a.disease_type_code as code, 'disease_type' as parentCode ")
           .append(" from sys_disease_type a");
        return queryList(sql.toString(), null, InitDictDto.class);
    }
}
