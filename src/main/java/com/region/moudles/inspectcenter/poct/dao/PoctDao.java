package com.region.moudles.inspectcenter.poct.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.inspectcenter.poct.dao.repository.PoctRepository;
import com.region.moudles.inspectcenter.poct.domain.Poct;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Named;
import java.util.List;

@Named
public class PoctDao extends BaseDao<PoctRepository, Poct> {

    public List<Poct> getPoctList(Poct poct) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select p.id,p.pro_name,p.pro_desc,p.doctor_name,p.create_time ");
        sql.append(" from sys_poct_result p ");
        sql.append(" where 1=1 ");
        if (StringUtils.isNotBlank(poct.getResidentId())) {
            sql.append(" and p.resident_id = :residentId ");
        }
        sql.append(" order by create_time desc nulls last ");
        return queryList(sql.toString(), poct, Poct.class);
    }
}
