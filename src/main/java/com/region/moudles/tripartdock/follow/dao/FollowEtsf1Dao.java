package com.region.moudles.tripartdock.follow.dao;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.follow.dao.repository.FollowEtSf1Repository;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf1;
import com.region.moudles.tripartdock.follow.dto.Et1Dto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Named
public class FollowEtsf1Dao extends BaseDao<FollowEtSf1Repository, FollowEtSf1> {

    public List<Et1Dto> getAll(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (select t.*,ROWNUM rn from( ");
        sql.append(" select b.id,b.jmid,b.etbh,b.dah,b.bs stage,b.sfzh,b.xb,b.sfrq,jb.hzmc xm,o.id org_id,o.org_name,b.sfysqm sfys_name");
        sql.append(" from blt_1synjkjcjlb b");
        sql.append(" join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg ");

        sql.append(" where 1=1 ");
        if ( StringUtils.isNotBlank(request.getJmid())) {
            sql.append("  and b.jmid = :jmid ");
        }
        if ( StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.sfrq, 'yyyy') = :searchTime ");
        }
        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) order by b.sfrq ");
        sql.append(") t where ROWNUM <= :pageSize * :pageNo) where rn > :pageSize * (:pageNo-1)");
        List<Et1Dto> list = queryList(sql.toString(), request, Et1Dto.class);
        return list;
    }

    public int getCount(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select b.id from blt_1synjkjcjlb b join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg ");

        sql.append(" where 1=1 ");
        if ( StringUtils.isNotBlank(request.getJmid())) {
            sql.append("  and b.jmid = :jmid ");
        }
        if ( StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.sfrq, 'yyyy') = :searchTime ");
        }
        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) ");
        Map<String, Object> map = new HashMap<>();
        getParam(sql.toString(), map, request);
        int count = (int) queryCount(sql.toString(), map);
        return count;
    }
    public int getSFCountByJmId(String jmId) {
        StringBuilder sql = new StringBuilder();
        sql.append("select a.id from blt_1synjkjcjlb a ");
        sql.append(" where a.jmid = :jmId ");
        Map<String, Object> map = new HashMap<>();
        map.put("jmId", jmId);
        return (int) queryCount(sql.toString(), map);
    }
}
