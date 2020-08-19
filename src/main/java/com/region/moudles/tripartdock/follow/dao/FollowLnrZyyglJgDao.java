package com.region.moudles.tripartdock.follow.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.follow.dao.repository.FollowLnrZyyglJgRepository;
import com.region.moudles.tripartdock.follow.domain.FollowLnrZyyglJg;


@Named
public class FollowLnrZyyglJgDao  extends BaseDao<FollowLnrZyyglJgRepository, FollowLnrZyyglJg> {
	
	public FollowLnrZyyglJg getZyyglJgInfo(String pgId) {
        StringBuilder sql = new StringBuilder();
        sql.append("select b.*  ");
        sql.append(" from blt_lnrzlnlpgjgb b");
        sql.append(" where b.pgid = :pgId ");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pgId", pgId);
        return queryOne(sql.toString(), paramMap, FollowLnrZyyglJg.class);
    }
        
}
