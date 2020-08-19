package com.region.moudles.tripartdock.health.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.health.bean.Referral;
import com.region.moudles.tripartdock.health.dao.repository.ReferralRepository;

@Named
public class ReferralDao extends BaseDao<ReferralRepository, Referral> {

	/**
	 * @Description: 转诊列表
	 * @param @param jmId
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public void getReferralPage(String jmId, PageModel page){
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.id, a.referral_time, a.status, a.referral_hospital, a.referral_dept, ");
        sql.append(" a.referral_user_name, a.receive_hospital, a.receive_dept, a.receive_user_name, a.jmid ");
        sql.append(" from blt_referral a ");
        sql.append(" where a.delete_flg = '0' ");
        sql.append(" and a.jmid = :jmId ");
        sql.append(" order by a.referral_time desc ");
        paramMap.put("jmId", jmId);
        queryPage(sql.toString(), paramMap, page, Referral.class);
   }
	
}
