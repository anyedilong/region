package com.region.moudles.tripartdock.team.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.team.dao.TeamAreaDao;
import com.region.moudles.tripartdock.team.dao.TeamDao;
import com.region.moudles.tripartdock.team.dao.TeamHisDao;
import com.region.moudles.tripartdock.team.dao.TeamOrgDao;
import com.region.moudles.tripartdock.team.dao.TeamUserDao;
import com.region.moudles.tripartdock.team.domain.SysTeam;
import com.region.moudles.tripartdock.team.domain.SysTeamArea;
import com.region.moudles.tripartdock.team.domain.SysTeamHis;
import com.region.moudles.tripartdock.team.domain.SysTeamOrg;
import com.region.moudles.tripartdock.team.domain.SysTeamUser;
import com.region.moudles.tripartdock.team.service.TripartTeamService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartTeamServiceImpl
 * @Description: 三方对接 保存团队项目相关信息
 * @author Administrator
 * @date 2019年7月25日
 */

@Named
public class TripartTeamServiceImpl implements TripartTeamService {

	@Autowired
	private TeamDao teamDao;
	@Autowired
	private TeamAreaDao teamAreaDao;
	@Autowired
	private TeamHisDao teamHisDao;
	@Autowired
	private TeamOrgDao teamOrgDao;
	@Autowired
	private TeamUserDao teamUserDao;
	
	//保存团队项目相关信息
	@Override
	public Map<String, Object> saveTeamInfo(List<SysTeam> list) throws Exception {
		 Map<String, Object> map = new HashMap<>();
		 String teamId = "";
		 try {
			 for(SysTeam info : list) {
				 teamId = info.getId();
    			//团队的区划信息
    			List<SysTeamArea> areas = info.getTeamAreaList();
    			if(areas != null && areas.size() > 0) {
    				teamAreaDao.save(areas);
    			}
    			//团队的成员责任信息
    			List<SysTeamHis> hiss = info.getTeamHisList();
    			if(hiss != null && hiss.size() > 0) {
    				teamHisDao.save(hiss);
    			}
    			//团队的机构信息
    			List<SysTeamOrg> orgs = info.getTeamOrgList();
    			if(orgs != null && orgs.size() > 0) {
    				teamOrgDao.save(orgs);
    			}
    			//团队的成员信息
    			List<SysTeamUser> users = info.getTeamUserList();
    			if(users != null && users.size() > 0) {
    				teamUserDao.save(users);
    			}
    			info.setId(UUIDUtil.getUUID());
    			teamDao.save(info);
    		}
		 }catch(Exception e) {
			 e.printStackTrace();
			 map.put(teamId, e.getMessage());
		 }
		return map;
	}
	
}

