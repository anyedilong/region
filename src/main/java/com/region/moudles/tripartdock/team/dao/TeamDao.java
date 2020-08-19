package com.region.moudles.tripartdock.team.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.team.dao.repository.TeamRepository;
import com.region.moudles.tripartdock.team.domain.SysTeam;
import com.region.moudles.tripartdock.team.domain.SysTeamUser;

@Named
public class TeamDao extends BaseDao<TeamRepository, SysTeam> {

	/**
	 * @Description: 根据签约团队信息
	 * @param @param signId
	 * @return void
	 * @throws
	 */
	public SysTeam queryTeamInfoBySignId(String teamId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.*, (select b.org_name from sys_org b where b.id = a.org_id) as orgName ");
        sql.append(" from sys_team a ");
        sql.append(" where a.status = '1' ");
        sql.append(" and id = :teamId ");
        paramMap.put("teamId", teamId);
        SysTeam team = queryOne(sql.toString(), paramMap, SysTeam.class);
        if(team != null) {
        	List<SysTeamUser> userList = queryTeamUserInfo(team.getId());
        	if(userList != null && userList.size() > 0) {
        		team.setTeamUserList(userList);
        	}else {
        		team.setTeamUserList(new ArrayList<>());
        	}
        }
        return team;
   }

	/**
	 * @Description: 根据签约团队信息
	 * @param @param signId
	 * @return void
	 * @throws
	 */
	public List<SysTeamUser> queryTeamUserInfo(String teamId){
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select distinct b.user_id, b.team_role as teamRole ");
        sql.append(" from sys_team_his b ");
        sql.append(" where b.team_id = :teamId ");
        paramMap.put("teamId", teamId);
        return queryList(sql.toString(), paramMap, SysTeamUser.class);
   }
}
