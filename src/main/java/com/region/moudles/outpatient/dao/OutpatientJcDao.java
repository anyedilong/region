package com.region.moudles.outpatient.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.outpatient.dao.repository.OupatientJcRepository;
import com.region.moudles.outpatient.domain.OutpatientJc;
import com.region.moudles.outpatient.dto.JcDto;
import com.region.until.StringUntil;

import org.apache.commons.lang3.StringUtils;

@Named
public class OutpatientJcDao extends BaseDao<OupatientJcRepository, OutpatientJc> {


    /**
     * @param @param mzId
     * @return void
     * @throws
     * @Description: 根据门诊id查询病历检查列表（健康浏览器）
     */
    public List<OutpatientJc> getOutpatientJcList(String mzId) {
        StringBuffer sql = new StringBuffer();
        sql.append("select a.item_type,a.diagnosis_time ");
        sql.append(" from outpatient_jcz a ");
        sql.append(" where a.medical_record_id = :mzId");
        sql.append(" group by a.item_type,a.diagnosis_time");
        sql.append(" order by a.diagnosis_time desc");
        Map<String, Object> map = new HashMap<>();
        map.put("mzId", mzId);
        return queryList(sql.toString(), map, OutpatientJc.class);
    }

    public List<OutpatientJc> getJcListByType(String mzId, String itemType) {
        StringBuffer sql = new StringBuffer();
        sql.append("select a.* ");
        sql.append(" from outpatient_jcz a ");
        sql.append(" where a.medical_record_id = :mzId");
        sql.append(" and a.item_type = :itemType");
        sql.append(" order by a.diagnosis_time desc");
        Map<String, Object> map = new HashMap<>();
        map.put("mzId", mzId);
        map.put("itemType", itemType);
        return queryList(sql.toString(), map, OutpatientJc.class);
    }

    //查询门诊和住院检查分页
    public void getJcListPage(JcDto dto) {
        //暂时没有急诊
        if ("3".equals(dto.getPatientType()))
            return;
        StringBuilder sql = new StringBuilder();
        sql.append(" select t.* from ( ");
        sql.append(" select p.* ");
        //筛选出最近一次检查
        if ("1".equals(dto.getIsReportReview())) {
            sql.append(" ,row_number() over(partition by sfzh order by report_date desc nulls last) flag ");
        }
        sql.append(" from ( ");
        //根据病人类型不同拼接不同的sql（或查门诊或查住院或全查）
        if (StringUtils.isBlank(dto.getPatientType()) || "1".equals(dto.getPatientType())) {
            sql.append(" select r.sfzh,r.name,r.sex,r.age,'门诊' patient_type, ");
            sql.append(" j.id,j.item_name,j.apply_dept,j.item_qsjg_name,j.apply_date, ");
            sql.append(" j.sample_type,j.item_qssj,j.item_sfyc,j.report_date ");
            sql.append(" from outpatient_jcz j ");
            sql.append(" join medical_record r on r.id = j.medical_record_id ");
            sql.append(" where 1=1");
            if (StringUtils.isNotBlank(dto.getSfzh()))
                sql.append(" and r.sfzh = :sfzh ");
            if (dto.getStartDate() != null)
                sql.append(" and j.").append(dto.getDateColumnName()).append(" >= :startDate ");
            if (dto.getEndDate() != null)
                sql.append(" and j.").append(dto.getDateColumnName()).append(" <= :endDate ");
            if (StringUtils.isNotBlank(dto.getOrgCode()))
                sql.append(" and j.item_qsjg_code like concat(:orgCode ,'%') ");
            //根据检验类型不同查询标准不同
            if ("2".equals(dto.getInspectType()))
                sql.append(" and j.sample_type is not null ");
            if ("3".equals(dto.getInspectType()))
                sql.append(" and j.report_date is not null and j.item_value is not null ");
            //样本类型
            if (StringUtils.isNotBlank(dto.getSampleType()))
                sql.append(" and j.sample_type = :sampleType ");
        }
        if (StringUtils.isBlank(dto.getPatientType())) {
            sql.append(" union all ");
        }
        if (StringUtils.isBlank(dto.getPatientType()) || "2".equals(dto.getPatientType())) {
            sql.append(" select r.sfzh,r.name,r.sex,r.age,'住院' patient_type, ");
            sql.append(" j.id,j.item_name,j.apply_dept,j.item_qsjg_name,j.apply_date, ");
            sql.append(" j.sample_type,j.item_qssj,j.item_sfyc,j.report_date ");
            sql.append(" from hospital_jcz j ");
            sql.append(" join hospital_infto r on r.id = j.hospital_id ");
            sql.append(" where 1=1");
            if (StringUtils.isNotBlank(dto.getSfzh()))
                sql.append(" and r.sfzh = :sfzh ");
            if (dto.getStartDate() != null)
                sql.append(" and j.").append(dto.getDateColumnName()).append(" >= :startDate ");
            if (dto.getEndDate() != null)
                sql.append(" and j.").append(dto.getDateColumnName()).append(" <= :endDate ");
            if (StringUtils.isNotBlank(dto.getOrgCode()))
                sql.append(" and j.item_qsjg_code like concat(:orgCode ,'%') ");
            //根据检验类型不同查询标准不同
            if ("2".equals(dto.getInspectType()))
                sql.append(" and j.sample_type is not null ");
            if ("3".equals(dto.getInspectType()))
                sql.append(" and j.report_date is not null and j.item_value is not null ");
            //样本类型
            if (StringUtils.isNotBlank(dto.getSampleType()))
                sql.append(" and j.sample_type = :sampleType ");
        }
        sql.append(" ) p ");
        sql.append(" ) t ");
        //筛选出最近一次检查
        if ("1".equals(dto.getIsReportReview())) {
            sql.append(" where t.flag = 1 ");
        }
        //根据检验类型不同用不同的时间排序
        if ("2".equals(dto.getInspectType()))
            sql.append(" order by t.item_qssj desc nulls last ");
        else if ("3".equals(dto.getInspectType()))
            sql.append(" order by t.report_date desc nulls last ");
        else
            sql.append(" order by t.apply_date desc nulls last ");
        queryPage(sql.toString(), dto, dto.getPage(), JcDto.class);
    }

    //查询门诊或住院检查详情
    public JcDto getJcInfo(JcDto req) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select r.sfzh,r.name,r.sex,r.age,r.id parent_id, ");
        sql.append(" j.* ");
        sql.append(" from ");
        if ("门诊".equals(req.getPatientType())) {
            sql.append(" outpatient_jcz j ");
            sql.append(" join medical_record r on r.id = j.medical_record_id ");
        } else if ("住院".equals(req.getPatientType())) {
            sql.append(" hospital_jcz j ");
            sql.append(" join hospital_infto r on r.id = j.hospital_id ");
        } else {
            return new JcDto();
        }
        sql.append(" where j.id = :id ");

        return queryOne(sql.toString(), req, JcDto.class);
    }

    //查询门诊或住院检查列表
    public List<JcDto> getJcList(JcDto req) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select j.item_type,j.item_code,j.item_name,j.item_value,j.item_unit, ");
        sql.append(" j.min_value,j.max_value ");
        sql.append(" from ");
        if ("门诊".equals(req.getPatientType())) {
            sql.append(" outpatient_jcz j ");
            sql.append(" join medical_record r on r.id = j.medical_record_id ");
        } else if ("住院".equals(req.getPatientType())) {
            sql.append(" hospital_jcz j ");
            sql.append(" join hospital_infto r on r.id = j.hospital_id ");
        } else {
            return new ArrayList<>();
        }
        sql.append(" where 1=1 ");
        if (StringUtils.isNotBlank(req.getItemType())) {
            sql.append(" and j.item_type = :itemType ");
        }
        if (StringUtils.isNotBlank(req.getParentId())) {
            sql.append(" and r.id = :parentId ");
        }

        return queryList(sql.toString(), req, JcDto.class);
    }



}
