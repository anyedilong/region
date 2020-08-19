package com.region.moudles.tripartdock.follow.dao;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.follow.dao.repository.FollowJsbJbRepository;
import com.region.moudles.tripartdock.follow.domain.FollowJsbJb;
import com.region.moudles.tripartdock.follow.dto.JsbJbDto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Named
public class FollowJsbJbDao extends BaseDao<FollowJsbJbRepository, FollowJsbJb> {

    public List<JsbJbDto> getAll(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (select t.*,ROWNUM rn from( select b.*,jb.hzmc,o.id org_id,o.org_name");
        sql.append(" from blt_jsbjbxxb b");
        sql.append(" join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg where 1=1 ");

        if (StringUtils.isNotBlank(request.getZjlx()) && StringUtils.isNotBlank(request.getSfzh())) {
            sql.append("  and jb.zjlx = :zjlx and jb.sfzh = :sfzh");
        }
        if (StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.scbfsj, 'yyyy') = :searchTime ");
        }

        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) order by b.jbrq ");
        sql.append(") t where ROWNUM <= :pageSize * :pageNo) where rn > :pageSize * (:pageNo-1)");
        List<JsbJbDto> list = queryList(sql.toString(), request, JsbJbDto.class);
        return list;
    }

    public int getCount(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select b.id from blt_jsbjbxxb b join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg where 1=1 ");

        if (StringUtils.isNotBlank(request.getZjlx()) && StringUtils.isNotBlank(request.getSfzh())) {
            sql.append("  and jb.zjlx = :zjlx and jb.sfzh = :sfzh");
        }
        if (StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.scbfsj, 'yyyy') = :searchTime ");
        }
        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) ");
        Map<String, Object> map = new HashMap<>();
        getParam(sql.toString(), map, request);
        int count = (int) queryCount(sql.toString(), map);
        return count;
    }
	
}
