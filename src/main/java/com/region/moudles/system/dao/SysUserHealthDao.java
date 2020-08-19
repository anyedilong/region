package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dao.repository.SysUserHealthRepository;
import com.region.moudles.system.domain.SysUserHealth;
import com.region.moudles.system.dto.SysUserHealthDto;
import com.region.until.StringUntil;

import javax.inject.Named;


@Named
public class SysUserHealthDao extends BaseDao<SysUserHealthRepository, SysUserHealth>{

   
	/**
     *	 获取卫生人员
     * @param orgCode
     * @param depCode
     * @return
     */
    public void getUserHealthPage(SysUserHealthDto userHealth, PageModel page) {
            StringBuffer sb=new StringBuffer();
            sb.append(" select o.org_name, a.id, a.doctor_name, a.dep_name, case when role = '1' then '医生'  else '护士'  end as role  ");
            sb.append(" from sys_user_health a ");
            sb.append(" join sys_org o on a.org_code = o.org_code ");
            sb.append(" where 1 = 1 ");
            if(!StringUntil.isNull(userHealth.getDoctorName())) {
            	sb.append(" and a.doctor_name like concat(concat('%', :doctorName), '%') ");
            }
            if(!StringUntil.isNull(userHealth.getOrgCode())) {
            	sb.append(" and o.org_code like concat(:orgCode, '%') ");
            }
            queryPage(sb.toString(), userHealth, page, SysUserHealthDto.class);
    }
   
}
