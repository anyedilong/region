package com.region.moudles.outpatient.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.outpatient.dao.repository.MedicalrecordRepository;
import com.region.moudles.outpatient.domain.Medicalrecord;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;


@Named
public class MedicalrecordDao extends BaseDao<MedicalrecordRepository,Medicalrecord> {

    //查看本次门诊标识号是否存在
    public String getNum(String num, String orgCode){
          Map<String,String> map=new HashMap<String,String>();
          StringBuffer sb=new StringBuffer();
          sb.append("select a.id from medical_record a ");
          sb.append(" where a.outpatient_num = :outpatient_num ");
          sb.append(" and a.org_code = :orgCode");
          map.put("outpatient_num", num);
          map.put("orgCode", orgCode);
          return queryOne(sb.toString(), map, String.class);
    }

    
    /**
     * @Description: 查询单个居民门诊病历列表（公卫）
     * @param @param sfzh
     * @param @param page
     * @return void
     * @throws
     */
    public void getOutpatientBLList(String sfzh, PageModel page) {
    	StringBuffer sql = new StringBuffer();
    	sql.append("select id, case_num, org_name, dep_name, name, sex, age, visiting_time, doctor_name, outpatient_num, sfzh");
    	sql.append("  from medical_record");
    	sql.append(" where sfzh = :sfzh");
    	sql.append(" order by visiting_time desc");
		Map<String, Object> map = new HashMap<>();
		map.put("sfzh", sfzh);
        queryPage(sql.toString(), map, page, Medicalrecord.class);
    }
    
    
    public Medicalrecord getMedicalRecordById(String medicalRecordId) {
    	return repository.getOne(medicalRecordId);
    }
    
    /**
     * @Description: 查询单个居民门诊病历列表（健康浏览器）
     * @param @param sfzh
     * @param @param page
     * @return void
     * @throws
     */
    public void getOutpatientPage(String sfzh, PageModel page) {
    	StringBuffer sql = new StringBuffer();
    	sql.append("select a.* ");
    	sql.append("  from medical_record a ");
    	sql.append(" where sfzh = :sfzh ");
    	sql.append(" order by visiting_time desc ");
		Map<String, Object> map = new HashMap<>();
		map.put("sfzh", sfzh);
        queryPage(sql.toString(), map, page, Medicalrecord.class);
    }

}
