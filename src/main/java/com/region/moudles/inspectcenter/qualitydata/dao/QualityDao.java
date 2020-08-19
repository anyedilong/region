package com.region.moudles.inspectcenter.qualitydata.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.inspectcenter.qualitydata.dao.repository.QualityDataRepository;
import com.region.moudles.inspectcenter.qualitydata.domain.QualityData;
import com.region.moudles.outpatient.dto.JcDto;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Named;
import java.util.List;

@Named
public class QualityDao extends BaseDao<QualityDataRepository, QualityData> {

    public void getQualityPage(JcDto req) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select t.* from ( ");
        sql.append(" select d.org_name,d.apparatus_name,d.apparatus_model,t.project_name,d.control_result,d.control_type,d.control_date, ");
        sql.append(" row_number() over(partition by d.apparatus_name,d.apparatus_model order by control_date desc nulls last) flg ");
        sql.append(" from blt_quality_data d ");
        sql.append(" join (select wm_concat(to_char(project_name)) project_name,apparatus_name,apparatus_model from blt_quality_data group by apparatus_name,apparatus_model) t ");
        sql.append(" on t.apparatus_name = d.apparatus_name and t.apparatus_model = d.apparatus_model ");
        sql.append(" where 1=1 ");
        if (StringUtils.isNotBlank(req.getOrgCode())) {
            sql.append(" and d.org_code like concat(:orgCode ,'%') ");
        }
        if (StringUtils.isNotBlank(req.getApparatusModel())) {
            sql.append(" and d.apparatus_model = :apparatusModel ");
        }
        if (StringUtils.isNotBlank(req.getApparatusName())) {
            sql.append(" and d.apparatus_name = :apparatusName ");
        }
        if (req.getControlDate() != null) {
            sql.append(" and d.control_date >= :controlDate ");
        }
        if (req.getNextControlDate() != null) {
            sql.append(" and d.control_date < :nextControlDate ");
        }
        sql.append(" ) t where t.flg = '1' ");
        sql.append(" order by control_date desc nulls last ");
        queryPage(sql.toString(), req, req.getPage(), QualityData.class);
    }

    public List<QualityData> getQualityList(JcDto req) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select (d.apparatus_name || '-' || d.apparatus_model) apparatus_name,d.apparatus_model,d.project_name,d.control_date, ");
        sql.append(" d.result1,d.result2,d.result3,d.result4,d.result5,d.result6,d.result7,d.result8 ");
        sql.append(" from blt_quality_data d ");
        sql.append(" where 1=1 ");
        if (StringUtils.isNotBlank(req.getApparatusModel())) {
            sql.append(" and d.apparatus_model = :apparatusModel ");
        }
        if (StringUtils.isNotBlank(req.getApparatusName())) {
            sql.append(" and d.apparatus_name = :apparatusName ");
        }
        if (req.getControlDate() != null) {
            sql.append(" and d.control_date >= :controlDate ");
        }
        if (req.getNextControlDate() != null) {
            sql.append(" and d.control_date < :nextControlDate ");
        }
        sql.append(" order by project_name desc nulls last ");
        return queryList(sql.toString(), req, QualityData.class);
    }

}
