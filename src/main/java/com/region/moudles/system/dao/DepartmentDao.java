package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dao.repository.DepartmentRepository;
import com.region.moudles.system.domain.Department;
import com.region.moudles.system.dto.DepartmentDto;
import com.region.moudles.system.dto.SysDepartmentDto;
import com.region.until.StringUntil;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Named
public class DepartmentDao  extends BaseDao<DepartmentRepository,Department>{

    /**
     * 	获取科室Code
     * @param orgCode
     * @param depCode
     * @return
     */
    public String queryDep(String orgCode,String depCode){
            Map<String,String> map=new HashMap<String,String>();
            StringBuffer sb=new StringBuffer();
            sb.append("select a.depCode from sys_deppartment a where a.org_code=:orgCode and a.dep_code=:depCode");
            map.put("orgCode",orgCode);
            map.put("depCode",depCode);
           return queryOne(sb.toString(),map,String.class);
    }

    
    /**
     *	 获取科室（平台用）
     * @param
     * @param
     * @return
     */
    public void getDepPage(SysDepartmentDto department, PageModel page){
            StringBuffer sb=new StringBuffer();
            sb.append(" select a.id, a.dep_code depCode, a.dep_name depName ");
            sb.append(" from sys_deppartment a ");
            sb.append(" where 1 = 1 ");
            if(!StringUntil.isNull(department.getDepName())) {
            	sb.append(" and a.dep_name like concat(concat('%', :depName), '%') ");
            }
            queryPage(sb.toString(), department, page, SysDepartmentDto.class);
    }

    public List<DepartmentDto>  getdep(){
        StringBuffer sb=new StringBuffer();
        sb.append("select a.dep_code,a.dep_name from sys_deppartment  a");
       return   queryList(sb.toString(),null, DepartmentDto.class);
    }
}
