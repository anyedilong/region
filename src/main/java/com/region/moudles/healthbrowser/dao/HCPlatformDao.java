package com.region.moudles.healthbrowser.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.QueryDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.healthbrowser.dto.JcInfoDto;
import com.region.moudles.healthbrowser.dto.JyInfoDto;
import com.region.moudles.healthbrowser.dto.ReportInfoDto;

@Named
public class HCPlatformDao extends QueryDao {
	
	/**
	 * @Description: 获取检验的列表(惠民平台)
	 * @param @param sfzh
	 * @param @return
	 * @return List<JyInfoDto>
	 * @throws
	 */
	public void getJyList(String sfzh, PageModel page){
		Map<String, Object> paramMap = new HashMap<>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select distinct s.item_type, s.diagnosis_time as qzrq, s.type, s.id, s.hospital, s.deptName  ");
		sql.append(" from (select a.item_type, a.diagnosis_time, '1' as type, a.medical_record_id as id, ");
		sql.append(" 	b.org_name as hospital, b.dep_name as deptName ");
		sql.append(" 	from outpatient_jcz a ");
		sql.append(" 	join medical_record b on a.medical_record_id = b.id ");
		sql.append(" 	where b.sfzh = :sfzh ");
		sql.append(" union ");
		sql.append(" 	select a.item_type, a.diagnosis_time as qzrq, '2' as type, a.hospital_id as id, ");
		sql.append(" 	b.org_name as hospital, b.dep_name as deptName ");
		sql.append(" 	from hospital_jcz a ");
		sql.append(" 	join hospital_infto b on a.hospital_id = b.id ");
		sql.append("  	where b.sfzh = :sfzh)s  ");
		sql.append("  order by s.diagnosis_time desc, s.item_type ");
		paramMap.put("sfzh", sfzh);
		queryPage(sql.toString(), paramMap, page, JyInfoDto.class);
	}

	public ReportInfoDto getPatientInfo(String id, String type){
		Map<String, Object> paramMap = new HashMap<>();
		StringBuffer sql = new StringBuffer();
		if("1".equals(type)) {
			//门诊
			sql.append(" select a.org_name, a.dep_code, a.dep_name, a.sfzh, a.name, a.sex, a.age from medical_record a ");
		}else if("2".equals(type)) {
			//住院
			sql.append(" select a.org_name, a.dep_code, a.dep_name, a.sfzh, a.name, a.sex, a.age from hospital_infto a ");
		}else {
			return null;
		}
		sql.append(" where a.id = :id ");
		paramMap.put("id", id);
		return queryOne(sql.toString(), paramMap, ReportInfoDto.class);
	}
	
	public List<JyInfoDto> queryJyList(String id, String type, String itemType){
		Map<String, Object> paramMap = new HashMap<>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.item_code as code, a.item_name as name, a.item_value, a.item_unit, a.min_value, a.max_value ");
		if("1".equals(type)) {
			//门诊
			sql.append(" from outpatient_jcz a ");
			sql.append(" where a.medical_record_id = :id ");
		}else if("2".equals(type)) {
			//住院
			sql.append(" from hospital_jcz a ");
			sql.append(" where a.hospital_id = :id ");
		}else {
			return null;
		}
		sql.append(" and a.item_type = :itemType ");
		paramMap.put("id", id);
		paramMap.put("itemType", itemType);
		return queryList(sql.toString(), paramMap, JyInfoDto.class);
	}
	
	/**
	 * @Description: 获取检查的列表(惠民平台)
	 * @param @param sfzh
	 * @param @return
	 * @param @throws Exception
	 * @return List<JcInfoDto>
	 * @throws
	 */
	public void getJcList(String sfzh, PageModel page) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select distinct s.image_type, s.image_time as qzrq, s.type, s.id, s.org_name as hospital ");
		sql.append(" from (select a.image_type, a.image_time, '1' as type, a.medical_record_id as id, ");
		sql.append(" 	b.org_name ");
		sql.append(" 	from outpatient_image a ");
		sql.append(" 	join medical_record b on a.medical_record_id = b.id ");
		sql.append(" 	where b.sfzh = :sfzh ");
		sql.append(" union ");
		sql.append(" 	select a.image_type, a.image_time, '2' as type, a.hospital_id as id, ");
		sql.append(" 	b.org_name ");
		sql.append(" 	from hospital_image a ");
		sql.append(" 	join hospital_infto b on a.hospital_id = b.id ");
		sql.append("  	 where  b.sfzh = :sfzh)s ");
		sql.append("  order by s.image_time desc, s.image_type ");
		paramMap.put("sfzh", sfzh);
		queryPage(sql.toString(), paramMap, page, JcInfoDto.class);
	}
	
	public List<JcInfoDto> queryJcList(String id, String type, String imageType){
		Map<String, Object> paramMap = new HashMap<>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select distinct r.id as imageId, r.image_url, r.image_remake, r.image_jl, r.image_time as qzrq, r.image_type, r.image_jpg_url, ");
		if("1".equals(type)) {
			//门诊
			sql.append(" '1' as type from outpatient_image r ");
			sql.append(" where id in (select max(a.id) from outpatient_image a  ");
			sql.append(" 		where a.medical_record_id = :id and a.image_type = :imageType group by a.image_jl) ");
		}else if("2".equals(type)) {
			//住院
			sql.append(" '2' as type from hospital_image r ");
			sql.append(" where id in (select max(a.id) from hospital_image a ");
			sql.append(" 		where a.hospital_id = :id and a.image_type = :imageType group by a.image_jl) ");
		}else {
			return null;
		}
		paramMap.put("id", id);
		paramMap.put("imageType", imageType);
		return queryList(sql.toString(), paramMap, JcInfoDto.class);
	}
}
