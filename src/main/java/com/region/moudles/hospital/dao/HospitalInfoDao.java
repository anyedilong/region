package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.hospital.dao.repository.HospitalInfoRepository;
import com.region.moudles.hospital.domain.HospitalInfto;

@Named
public class HospitalInfoDao extends BaseDao<HospitalInfoRepository,HospitalInfto>{

	//查看本次住院标识号是否存在
    public String getNum(String num, String orgCode){
          Map<String,String> map = new HashMap<String,String>();
          StringBuffer sb = new StringBuffer();
          sb.append("select a.id from hospital_infto a ");
          sb.append(" where a.ar_id = :arId ");
          sb.append(" and a.org_code = :orgCode");
          map.put("arId", num);
          map.put("orgCode", orgCode);
          return queryOne(sb.toString(), map, String.class);
    }
	
	/**
     *	 获取入院登记列表（分页）
     * @param String
     * @param page
     * @return
     */
    public void getHospitalZYInfoPage(String sfzh, PageModel page){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_infto a  ")
			.append(" where a.sfzh = :sfzh ")
			.append(" order by a.admission_date desc");
		Map<String, Object> map = new HashMap<>();
		map.put("sfzh", sfzh);
        queryPage(sql.toString(), map, page, HospitalInfto.class);
    }
	
    /**
     *	 获取入院详情列表
     * @param String
     * @return
     */
    public List<HospitalInfto> getHospitalZYInfoList(String sfzh){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.id, a.ar_id ")
			.append(" from hospital_infto a  ")
			.append(" where a.sfzh = :sfzh ")
			.append(" order by a.admission_date desc");
		Map<String, Object> map = new HashMap<>();
		map.put("sfzh", sfzh);
        return queryList(sql.toString(), map, HospitalInfto.class);
    }
	
    /**
     *	 获取入院详情
     * @param String
     * @return
     */
    public HospitalInfto getHospitalDetail(String id){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_infto a  ")
			.append(" where a.id = :id ");
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
        return queryOne(sql.toString(), map, HospitalInfto.class);
    }
    
    /**
     *	 获取入院详情（手机app）
     * @param String
     * @return
     */
    public HospitalInfto getAppHospitalDetail(String id){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.*, b.discharge_date, b.id as outId ")
			.append(" from hospital_infto a  ")
			.append(" left join hospital_out_cost b on a.id = b.hospital_id  ")
			.append(" where a.id = :id ");
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		return queryOne(sql.toString(), map, HospitalInfto.class);
    }
}
