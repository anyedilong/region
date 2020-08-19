package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.utils.cache.OrgCache;
import com.region.moudles.system.dao.repository.SysOrgRepository;
import com.region.moudles.system.domain.SysOrg;
import com.region.until.StringUntil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;


@Named
public class SysOrgDao extends BaseDao<SysOrgRepository, SysOrg> {


    public void queryOrgPage(SysOrg sysOrg, PageModel page){
         StringBuffer sql=new StringBuffer();
         sql.append(" select a.id, a.org_name, a.org_code, a.parent_id, a.org_level, a.area_id, a.status, b.area_name ");
         sql.append(" from sys_org a ");
         sql.append(" join sys_area b on a.area_id = b.id ");
         sql.append(" where 1 = 1 ");
         if(!StringUntil.isNull(sysOrg.getOrgName())) {
        	 sql.append(" and a.org_name like concat(concat('%', :orgName), '%') ");
         }
         if(!StringUntil.isNull(sysOrg.getOrgCode())) {
        	 sql.append(" and a.org_code like concat(:orgCode, '%') ");
         }
         queryPage(sql.toString(), sysOrg, page, SysOrg.class);
    }
    
    public List<SysOrg> queryOrgList(){
        StringBuffer sql=new StringBuffer();
        sql.append("select a.id, a.org_name, a.org_code, a.parent_id, a.status from sys_org a");
        return queryList(sql.toString(), null, SysOrg.class);
    }
    
    
    public List<OrgCache> getMrgOrgInfos(String userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select o.id  id, ")
			.append(" o.org_name  orgName, ")
			.append(" o.org_code  orgCode, ")
			.append(" o.org_level orgLevel, ")
			.append(" o.parent_id parentId, ")
			.append(" o.status    status, ")
			.append(" o.area_id   areaId ")
			.append(" from sys_org o where o.status ='1' ")
			.append(" and o.org_code like CONCAT((select org_code from sys_org where id = (select org_id from sys_user where id = :userId)),'%') ");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		return queryList(sql.toString(), paramMap, OrgCache.class);
	}
    
    public OrgCache getOrgInfoByUserId(String userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select o.id  id, ")
			.append(" o.org_name  orgName, ")
			.append(" o.org_code  orgCode, ")
			.append(" o.org_level orgLevel, ")
			.append(" o.parent_id parentId, ")
			.append(" o.status    status, ")
			.append(" o.area_id   areaId ")
			.append(" from sys_org o where o.status ='1' ")
			.append(" and o.id= (select org_id from sys_user where id = :userId) ");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		
		return queryOne(sql.toString(), paramMap, OrgCache.class);
	}
    
    public SysOrg queryOrgByCode(String orgCode) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select o.id  id, ")
			.append(" o.org_name  orgName, ")
			.append(" o.org_code  orgCode, ")
			.append(" o.org_level orgLevel, ")
			.append(" o.parent_id parentId, ")
			.append(" o.status    status, ")
			.append(" o.area_id   areaId ")
			.append(" from sys_org o where o.status ='1' ")
			.append(" and o.org_code = :orgCode ");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orgCode", orgCode);
		
		return queryOne(sql.toString(), paramMap, SysOrg.class);
	}
    
    public String queryOrgCodeByAuthCode(String authCode){
        StringBuffer sql=new StringBuffer();
        sql.append(" select org_code ")
        	.append(" from sys_org ")
        	.append(" where id = (select org_id from sys_auth where auth_code = :authCode) ");
        Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("authCode", authCode);
        return queryOne(sql.toString(), paramMap, String.class);
   }
    
    public List<SysOrg> queryOrgInfoList(){
        StringBuffer sql=new StringBuffer();
        sql.append("select a.id, replace(replace(org_name, '云南省曲靖市'), '街道办事处') as orgName ")
        	.append(" from sys_org a ")
        	.append(" where status = '1'  ")
        	.append(" and org_level in ('4', '5') ");
        return queryList(sql.toString(), null, SysOrg.class);
   }

	public List<OrgCache> getOrgByCode(String orgId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select o.id  id, ")
				.append(" o.org_name  orgName, ")
				.append(" o.org_code  orgCode, ")
				.append(" o.org_level orgLevel, ")
				.append(" o.parent_id parentId ")
				.append(" from sys_org o where o.status ='1' ")
				.append(" and o.org_code like CONCAT((select org_code from sys_org where id = :orgId),'%') ");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orgId", orgId);
		return queryList(sql.toString(), paramMap, OrgCache.class);
	}
    
	public List<SysOrg> getOrgList() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select o.id, o.org_name,  o.org_code,  o.parent_id, ")
			.append(" '' as sortName,  o.org_level,  o.area_id as regionId ")
			.append(" from sys_org o where o.status ='1' ");
		
		return queryList(sql.toString(), null, SysOrg.class);
	}
	
}
