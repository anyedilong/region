package com.region.moudles.tripartdock.follow.dao;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.follow.dao.repository.FollowNczRepository;
import com.region.moudles.tripartdock.follow.domain.FollowNcz;
import com.region.moudles.tripartdock.follow.dto.NczDto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Named
public class FollowNczDao extends BaseDao<FollowNczRepository, FollowNcz> {

    public List<NczDto> getAll(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (select t.*,ROWNUM rn from( ");
        sql.append(" select b.id,b.followupdate sfrq,b.followuptype sffs,b.followupdoctor sfys,jb.hzmc hzxm,o.id org_id,o.org_name,b.followupdoctor as sfys_name");
        sql.append(" from blt_mxnczsfb b");
        sql.append(" join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg ");
        sql.append(" where 1=1 ");
        if ( StringUtils.isNotBlank(request.getJmid())) {
            sql.append("  and b.jmid = :jmid ");
        }
        if (StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.followupdate, 'yyyy') = :searchTime ");
        }
        
        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) order by b.followupdate ");
        sql.append(") t where ROWNUM <= :pageSize * :pageNo) where rn > :pageSize * (:pageNo-1)");
        List<NczDto> list = queryList(sql.toString(), request, NczDto.class);
        return list;
    }

    public int getCount(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select b.id from blt_mxnczsfb b join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg ");
        sql.append(" where 1=1 ");
        if ( StringUtils.isNotBlank(request.getJmid())) {
            sql.append("  and b.jmid = :jmid ");
        }
        if (StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.followupdate, 'yyyy') = :searchTime ");
        }
        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) ");
        Map<String, Object> map = new HashMap<>();
        getParam(sql.toString(), map, request);
        int count = (int) queryCount(sql.toString(), map);
        return count;
    }

    public FollowNcz getNczInfo(String id) {
    	Map<String, Object> map = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select b.* from blt_mxnczsfb b where id = :id ");
        map.put("id", id);
        return queryOne(sql.toString(), map, FollowNcz.class);
    }
    public int getSFCountByJmId(String jmId) {
        StringBuilder sql = new StringBuilder();
        sql.append("select a.id from blt_mxnczsfb a ");
        sql.append(" where a.jmid = :jmId ");
        Map<String, Object> map = new HashMap<>();
        map.put("jmId", jmId);
        return (int) queryCount(sql.toString(), map);
    }
}
