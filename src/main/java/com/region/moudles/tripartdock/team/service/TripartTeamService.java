package com.region.moudles.tripartdock.team.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.tripartdock.team.domain.SysTeam;

/**
 * @ClassName: TripartTeamService
 * @Description: 三方对接 保存团队项目相关信息
 * @author Administrator
 * @date 2019年7月25日
 */

public interface TripartTeamService {

	//保存服务包相关信息
	Map<String, Object> saveTeamInfo(List<SysTeam> list) throws Exception;
    
}
