package com.region.moudles.tripartdock.archive.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.archive.dao.repository.JbxxjlbRepository;
import com.region.moudles.tripartdock.archive.domain.Jbxxjlb;
import com.region.moudles.tripartdock.archive.dto.ArchiveFamilyInfo;
import com.region.moudles.tripartdock.archive.dto.ArchiveQueryCon;
import com.region.moudles.tripartdock.health.bean.BaseCustomerDomain;
import com.region.moudles.tripartdock.yunzhi.dto.ResidentInfoDto;
import com.region.until.StringUntil;


@Named
public class JbxxjlbDao extends BaseDao<JbxxjlbRepository, Jbxxjlb> {
	
	/**
	 * @Description: 档案列表(健康浏览器)
	 * @param @param sysmenu
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public void getArchivePage(Jbxxjlb jbxxjlb, PageModel page){
       StringBuffer sql=new StringBuffer();
       sql.append(" select a.id, a.sfzh, a.zjlx, a.hzmc, a.xb,  ");
       sql.append(" s.id as signId, a.rqlx, a.lxdh, a.xzz, a.csrq ");
       sql.append(" from blt_jbxxjlb a ");
       sql.append(" left join blt_sign s on a.id = s.jmid and  status = '1' and delete_flg = '0' ");
       sql.append(" where (a.sfsc = 'N' or a.sfsc is null) ");
       if(!StringUntil.isNull(jbxxjlb.getHzmc())) {
    	   sql.append(" and a.hzmc like concat(concat('%', :hzmc), '%') ");
       }
       if(!StringUntil.isNull(jbxxjlb.getZjlx())) {
    	   sql.append(" and a.zjlx = :zjlx "); 
       }
       if(!StringUntil.isNull(jbxxjlb.getSfzh())) {
    	   sql.append(" and a.sfzh like concat(concat('%', :sfzh), '%') "); 
       }
       if(!StringUntil.isNull(jbxxjlb.getStartTime())) {
    	   sql.append(" and a.csrq >= to_date(:startTime, 'yyyy-mm-dd') "); 
       }
       if(!StringUntil.isNull(jbxxjlb.getEndTime())) {
    	   sql.append(" and a.csrq <= to_date(:endTime, 'yyyy-mm-dd')"); 
       }
       queryPage(sql.toString(), jbxxjlb, page, Jbxxjlb.class);
   }
	
	/**
	 * @Description: 档案列表(健康浏览器)
	 * @param @param sysmenu
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public void getArchivePageByCon(ArchiveQueryCon info, PageModel page){
       StringBuffer sql=new StringBuffer();
       sql.append(" select a.id, a.sfzh, a.zjlx, a.hzmc, a.xb,  ");
       sql.append(" s.id as signId, a.rqlx, a.lxdh, a.xzz, a.csrq ");
       sql.append(" from blt_jbxxjlb a ");
       sql.append(" left join blt_sign s on a.id = s.jmid and  status = '1' and delete_flg = '0' ");
       sql.append(" where (a.sfsc = 'N' or a.sfsc is null) ");
       if(!StringUntil.isNull(info.getIsMedical()) || !StringUntil.isNull(info.getIsOutCost()) 
    		   || !StringUntil.isNull(info.getIsOutImage()) || !StringUntil.isNull(info.getIsOutJcz()) 
			   || !StringUntil.isNull(info.getIsOutZd())) {
		   sql.append(" and exists (select 1 from medical_record h where h.sfzh = a.sfzh ");
           if(!StringUntil.isNull(info.getIsOutCost())) {
        	   sql.append(" and exists (select 1 from outpatient_cost b where b.medical_record_id = h.id) ");
           }
           if(!StringUntil.isNull(info.getIsOutImage())) {
        	   sql.append(" and exists (select 1 from outpatient_image c where c.medical_record_id = h.id) ");
           }
           if(!StringUntil.isNull(info.getIsOutJcz())) {
        	   sql.append(" and exists (select 1 from outpatient_jcz d where d.medical_record_id = h.id) ");
           }
           if(!StringUntil.isNull(info.getIsOutRx())) {
        	   sql.append(" and exists (select 1 from outpatient_rx e where e.medical_record_id = h.id) ");
           }
           if(!StringUntil.isNull(info.getIsOutZd())) {
        	   sql.append(" and exists (select 1 from outpatient_zd f where f.medical_record_id = h.id) ");
           }
		   if(!StringUntil.isNull(info.getStartTime())) {
			   sql.append(" and h.visiting_time >= to_date(:startTime, 'yyyy-mm-dd') ");
		   }
		   if(!StringUntil.isNull(info.getEndTime())) {
			   sql.append(" and h.visiting_time <= to_date(:endTime, 'yyyy-mm-dd') ");
		   }
           sql.append(" ) ");
       }
       if(!StringUntil.isNull(info.getIsHospital()) || !StringUntil.isNull(info.getIsHosImage()) 
    	    || !StringUntil.isNull(info.getIsHosJcz()) || !StringUntil.isNull(info.getIsHosOutCost()) 
    		   || !StringUntil.isNull(info.getIsHosZd()) || !StringUntil.isNull(info.getIsHosEmr())) {
    	   sql.append(" and exists (select 1 from hospital_infto h where h.sfzh = a.sfzh ");
    	   if(!StringUntil.isNull(info.getIsHosImage())) {
        	   sql.append(" and exists (select 1 from hospital_image b where b.hospital_id = h.id) ");
           }
    	   if(!StringUntil.isNull(info.getIsHosJcz())) {
        	   sql.append(" and exists (select 1 from hospital_jcz c where c.hospital_id = h.id) ");
           }
    	   if(!StringUntil.isNull(info.getIsHosOutCost())) {
        	   sql.append(" and exists (select 1 from hospital_out_cost d where d.hospital_id = h.id) ");
           }
    	   if(!StringUntil.isNull(info.getIsHosZd())) {
        	   sql.append(" and exists (select 1 from hospital_zd e where e.hospital_id = h.id) ");
           }
    	   if(!StringUntil.isNull(info.getIsHosEmr())) {
			   sql.append(" and exists (select 1 from hospital_emr f where f.hospital_id = h.id) ");
           }
    	   if(!StringUntil.isNull(info.getStartTime())) {
    		   sql.append(" and h.admission_date >= to_date(:startTime, 'yyyy-mm-dd') "); 
    	   }
    	   if(!StringUntil.isNull(info.getEndTime())) {
    		   sql.append(" and h.admission_date <= to_date(:endTime, 'yyyy-mm-dd') ");
    	   }
           sql.append(" ) ");
       }
       
       queryPage(sql.toString(), info, page, Jbxxjlb.class);
   }
	
	/**
	 * @Description: 查询档案详情-管理员登录
	 * @param @param archiveId sfzh
	 * @return void
	 * @throws
	 */
	public Jbxxjlb queryArchiveDetail(String archiveId, String sfzh){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_jbxxjlb a ");
        if(!StringUntil.isNull(archiveId)) {
        	sql.append(" where id = :archiveId ");
        	paramMap.put("archiveId", archiveId);
        }
        if(!StringUntil.isNull(sfzh)) {
        	sql.append(" where sfzh = :sfzh ");
        	paramMap.put("sfzh", sfzh);
        }
        return queryOne(sql.toString(), paramMap, Jbxxjlb.class);
   }
	
	/**
	 * @Description: 查询档案详情-his嵌入
	 * @param @param archiveId
	 * @return void
	 * @throws
	 */
	public Jbxxjlb queryArchiveDetailByCon(String hzmc, String zjlx, String sfzh){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_jbxxjlb a ");
        sql.append(" where a.hzmc = :hzmc ");
        sql.append(" and a.zjlx = :zjlx and a.sfzh = :sfzh ");
        paramMap.put("hzmc", hzmc);
        paramMap.put("zjlx", zjlx);
        paramMap.put("sfzh", sfzh);
        return queryOne(sql.toString(), paramMap, Jbxxjlb.class);
   }
	
	/**
	 * @Description: 查询患者的基本信息
	 * @param @param jmId
	 * @return void
	 * @throws
	 */
	public BaseCustomerDomain getCustomerInfoById(String jmId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.id, a.jlh ");
        sql.append(" from blt_jbxxjlb a ");
        sql.append(" where id = :jmId ");
        paramMap.put("jmId", jmId);
        return queryOne(sql.toString(), paramMap, BaseCustomerDomain.class);
   }
	
	
	public ArchiveFamilyInfo queryFamilyInfo(String sfzh) {
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.hzmc as hzxm, b.householder_idcard as hzsfzh, b.family_count as familyCount, b.live_condite as liveCondite ");
        sql.append(" from blt_jbxxjlb a ");
        sql.append(" join blt_family b on a.id = b.jmid ");
        sql.append(" join blt_family_user c on b.id = c.family_id ");
        sql.append(" where c.user_idcard = :sfzh ");
        paramMap.put("sfzh", sfzh);
        return queryOne(sql.toString(), paramMap, ArchiveFamilyInfo.class);
	}

	public BaseCustomerDomain getInfoBySfzh(String sfzh){
		Map<String, Object> paramMap = new HashMap<>();
		StringBuffer sql=new StringBuffer();
		sql.append(" select b.* ");
		sql.append(" from blt_jbxxjlb b ");
		sql.append(" where b.sfzh = :sfzh ");
		paramMap.put("sfzh", sfzh);
		return queryOne(sql.toString(), paramMap, BaseCustomerDomain.class);
	}
	
	/**
	 * @Description: 居民档案列表(云智)
	 * @param @param sysmenu
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public void getResidentPage(String orgId, PageModel page){
       StringBuffer sql=new StringBuffer();
       Map<String, Object> paramMap = new HashMap<>();
       sql.append(" select r.id, r.hzmc, r.jlh, r.ys, r.xb, r.sfzh, r.csrq,  ");
       sql.append(" floor(MONTHS_BETWEEN(sysdate, r.csrq)/12) as nl, r.guoji as mz, ");
       sql.append(" r.sj, r.hyqk, r.whcd, r.gz, r.gzdw, r.jtzz, r.jdr, r.create_time, o.area_id as regionId ");
       sql.append(" from blt_jbxxjlb r ");
       sql.append(" left join sys_org o on r.jdjg = o.id ");
       sql.append(" where (r.sfsc = 'N' or r.sfsc is null) ");
       if(!StringUntil.isNull(orgId)) {
    	   sql.append(" and r.jdjg = :orgId ");
    	   paramMap.put("orgId", orgId);
       }
       queryPage(sql.toString(), paramMap, page, ResidentInfoDto.class);
   }
	
}
