package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.hospital.dao.repository.HospitalEmrRepository;
import com.region.moudles.hospital.domain.HospitalEmr;
import com.region.moudles.hospital.domain.HospitalEmrArea;
import com.region.moudles.hospital.domain.HospitalEmrCost;
import com.region.moudles.hospital.domain.HospitalEmrDep;
import com.region.moudles.hospital.domain.HospitalEmrDoctor;
import com.region.moudles.hospital.domain.HospitalEmrGm;
import com.region.moudles.hospital.domain.HospitalEmrSs;
import com.region.moudles.hospital.domain.HospitalEmrSsDoctor;
import com.region.moudles.hospital.domain.HospitalEmrTel;
import com.region.moudles.hospital.domain.HospitalEmrZd;
import org.apache.commons.lang3.StringUtils;

@Named
public class HospitalEmrDao extends BaseDao<HospitalEmrRepository, HospitalEmr> {
	
	
	@Inject
    private  HospitalEmrAreaDao emrAreaDao;
	@Inject
    private  HospitalEmrCostDao emrCostDao;
	@Inject
    private  HospitalEmrDepDao emrDepDao;
	@Inject
    private  HospitalEmrDoctorDao emrDoctorDao;
	@Inject
    private  HospitalEmrGmDao emrGmDao;
	@Inject
    private  HospitalEmrSsDao emrSsDao;
	@Inject
    private  HospitalEmrSsDoctorDao emrSsDoctorDao;
	@Inject
    private  HospitalEmrTelDao emrTelDao;
	@Inject
    private  HospitalEmrZdDao emrZdDao;
	
	/**
     *	 获取住院病案列表（分页）
     * @param String
     * @param page
     * @return
     */
    public void getZYBAList(String sfzh, PageModel page){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_emr a  ")
			.append(" where a.id_num = :sfzh ");
		Map<String, Object> map = new HashMap<>();
		map.put("sfzh", sfzh);
        queryPage(sql.toString(), map, page, HospitalEmr.class);
    }
    
    
    
    /**
     *	 查询住院病案详情
     * @param String
     * @param page
     * @return
     */
    public HospitalEmr getZYBADetail(String emrId, String admissionId, String orgCode){
		Map<String, Object> map = new HashMap<>();
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_emr a  ")
			.append(" where 1=1 ");
		if (StringUtils.isNotBlank(emrId)) {
			sql.append(" and a.id = :emrId ");
			map.put("emrId", emrId);
		}
		if (StringUtils.isNotBlank(admissionId)) {
			sql.append(" and a.admission_id = :admissionId ");
			map.put("admissionId", admissionId);
		}
		if (StringUtils.isNotBlank(orgCode)) {
			sql.append(" and a.org_code = :orgCode ");
			map.put("orgCode", orgCode);
		}

        HospitalEmr emr = queryOne(sql.toString(), map, HospitalEmr.class);
        if(emr != null) {
        	List<HospitalEmrArea> emrAreaList = emrAreaDao.getEmrAreaList(emr.getHisId());
        	if(emrAreaList != null && emrAreaList.size() > 0) {
        		emr.setEmr_ich_addr(emrAreaList);
        	}
        	List<HospitalEmrCost> emrCostList = emrCostDao.getEmrCostList(emr.getHisId());
        	if(emrCostList != null && emrCostList.size() > 0) {
        		emr.setEmr_ich_charge(emrCostList);
        	}
        	List<HospitalEmrDep> depList = emrDepDao.getDepList(emr.getHisId());
        	if(depList != null && depList.size() > 0) {
        		emr.setEmr_ich_department(depList);
        	}
        	List<HospitalEmrDoctor> emrDoctorList = emrDoctorDao.getEmrDoctorList(emr.getHisId());
        	if(emrDoctorList != null && emrDoctorList.size() > 0) {
        		emr.setEmr_ich_doctor(emrDoctorList);
        	}
        	List<HospitalEmrGm> hospitalGmList = emrGmDao.getHospitalGmList(emr.getHisId());
        	if(hospitalGmList != null && hospitalGmList.size() > 0) {
        		emr.setEmr_ich_allergies(hospitalGmList);
        	}
        	List<HospitalEmrSs> hospitalSsList = emrSsDao.getHospitalSsList(emr.getHisId());
        	if(hospitalSsList != null && hospitalSsList.size() > 0) {
        		emr.setEmr_ich_operation(hospitalSsList);
        	}
        	List<HospitalEmrSsDoctor> hospitalSsDoctorList = emrSsDoctorDao.getHospitalSsDoctorList(emr.getHisId());
        	if(hospitalSsDoctorList != null && hospitalSsDoctorList.size() > 0) {
        		emr.setEmr_ich_operation_doctor(hospitalSsDoctorList);
        	}
        	List<HospitalEmrTel> hospitalTelList = emrTelDao.getHospitalTelList(emr.getHisId());
        	if(hospitalTelList != null && hospitalTelList.size() > 0) {
        		emr.setEmr_ich_tel(hospitalTelList);
        	}
        	List<HospitalEmrZd> hospitalZdList = emrZdDao.getHospitalZdList(emr.getHisId());
        	if(hospitalZdList != null && hospitalZdList.size() > 0) {
        		emr.setEmr_ich_diagnosis(hospitalZdList);
        	}
        }
        return emr;
    }
}
