package com.region.moudles.tripartdock.health.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import com.region.moudles.tripartdock.health.bean.Yfjz;
import com.region.moudles.tripartdock.health.dao.repository.YfjzRepository;
import com.region.moudles.tripartdock.health.dto.YfjzDto;

@Named
public class YfjzDao extends BaseDao<YfjzRepository, Yfjz> {
    public List<YfjzDto> getAll(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (select t.*,ROWNUM rn from( ");
        sql.append(" select b.id, b.sfzh, jb.id as jmid, jb.hzmc, b.jzys, b.ymmc as bacterinName, ");
        sql.append(" b.zc as needleNo, b.jzrq as immuDate, b.jzbw as immuSite, b.jzph as bacterinNo, b.jzys as immuDoc,  ");
        sql.append(" b.bz as otherInfo, b.lrjg as immuOrgan, b.scqy as immuProduct, b.lrjg as org_name ");
        sql.append(" from blt_jhnjzdjd b");
        sql.append(" join blt_jbxxjlb jb on b.sfzh = jb.sfzh  ");
        sql.append(" where 1=1 ");
        if ( StringUtils.isNotBlank(request.getJmid())) {
            sql.append("  and jb.id = :jmid ");
        }

        if (StringUtils.isNotBlank(request.getId())) {
            sql.append("  and b.id = :id ");
        }

        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) order by b.create_time ");
        sql.append(") t where ROWNUM <= :pageSize * :pageNo) where rn > :pageSize * (:pageNo-1)");
        List<YfjzDto> list = queryList(sql.toString(), request, YfjzDto.class);
        return list;
    }

    public int getCount(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select b.id from HEALTH_YFJZ b join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = b.immu_organ ");
        sql.append(" where 1=1 ");
        if ( StringUtils.isNotBlank(request.getJmid())) {
            sql.append("  and b.jmid = :jmid ");
        }
        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) ");
        Map<String, Object> map = new HashMap<>();
        getParam(sql.toString(), map, request);
        int count = (int) queryCount(sql.toString(), map);
        return count;
    }
}
