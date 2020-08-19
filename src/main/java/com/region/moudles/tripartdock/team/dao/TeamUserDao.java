package com.region.moudles.tripartdock.team.dao;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.team.dao.repository.TeamUserRepository;
import com.region.moudles.tripartdock.team.domain.SysTeamUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class TeamUserDao extends BaseDao<TeamUserRepository, SysTeamUser> {

    public List<SysTeamUser> getTeamUserByTeamId(String teamId){
        Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select tu.* ");
        sql.append(" from sys_team_user tu ");
        sql.append(" join sys_team t on t.id = tu.team_id ");
        sql.append(" where (tu.status = '1' or tu.status is null) and (t.status = '1' or t.status is null)  ");
        sql.append(" and t.id = :teamId  ");
        paramMap.put("teamId", teamId);
        return queryList(sql.toString(), paramMap, SysTeamUser.class);

    }

	
}
