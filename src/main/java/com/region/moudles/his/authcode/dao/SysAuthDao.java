package com.region.moudles.his.authcode.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.his.authcode.dao.repository.SysAuthRepository;
import com.region.moudles.his.authcode.domain.SysAuth;
import com.region.until.StringUntil;

import javax.inject.Named;

@Named
public class SysAuthDao extends BaseDao<SysAuthRepository,SysAuth> {


    public void  updateAuth(String id,String status){
         repository.updateAuth(id,status);
    }

    public void queryAuth(SysAuth auth, PageModel page){
       StringBuffer sql=new StringBuffer();
       sql.append("select a.auth_code, a.id, b.org_name");
       sql.append(" from sys_auth a");
       sql.append(" join sys_org b");
       sql.append(" on a.org_id = b.id");
       sql.append(" where 1 = 1 ");
       if(!StringUntil.isNull(auth.getAuthCode())) {
    	   sql.append(" and a.auth_code like concat('%', concat(:authCode, '%')) ");
       }
       if(!StringUntil.isNull(auth.getOrgName())) {
    	   sql.append(" and b.org_name like concat('%', concat(:orgName, '%')) ");
       }
       queryPage(sql.toString(), auth, page, SysAuth.class);
    }

}
