package com.region.moudles.tripartdock.follow.dao;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.follow.dao.repository.FollowFjhRepository;
import com.region.moudles.tripartdock.follow.domain.FollowFjh;
import com.region.moudles.tripartdock.follow.dto.FjhDto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class FollowFjhDao extends BaseDao<FollowFjhRepository, FollowFjh>{

    public List<FjhDto> getAll(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (select t.*,ROWNUM rn from( ");
        sql.append(" select b.id,b.sfsj sfrq,b.sffs,b.sfys,jb.hzmc hzxm,o.id org_id,o.org_name,b.sfys as sfys_name");
        sql.append(" from blt_pdb_service b");
        sql.append(" join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg ");
        sql.append(" where 1=1 ");
        if ( StringUtils.isNotBlank(request.getJmid())) {
            sql.append("  and b.jmid = :jmid ");
        }
        if ( StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.sfsj, 'yyyy') = :searchTime ");
        }

        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.status != '1' or b.status is null) order by b.sfsj ");
        sql.append(") t where ROWNUM <= :pageSize * :pageNo) where rn > :pageSize * (:pageNo-1)");
        List<FjhDto> list = queryList(sql.toString(), request, FjhDto.class);
        return list;
    }

    public int getCount(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select b.id from blt_pdb_service b join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg ");
        sql.append(" where 1=1 ");
        if ( StringUtils.isNotBlank(request.getJmid())) {
            sql.append("  and b.jmid = :jmid ");
        }
        if ( StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.sfsj, 'yyyy') = :searchTime ");
        }
        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.status != '1' or b.status is null) ");
        Map<String, Object> map = new HashMap<>();
        getParam(sql.toString(), map, request);
        int count = (int) queryCount(sql.toString(), map);
        return count;
    }
    //查询肺结核数量根据jmId
    public int getSFCountByJmId(String jmId) {
        StringBuilder sql = new StringBuilder();
        sql.append("select a.id from blt_pdb_service a ");
        sql.append(" where a.jmid = :jmId ");
        Map<String, Object> map = new HashMap<>();
        map.put("jmId", jmId);
        return (int) queryCount(sql.toString(), map);
    }
	
}
