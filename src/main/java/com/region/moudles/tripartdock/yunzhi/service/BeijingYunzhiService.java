package com.region.moudles.tripartdock.yunzhi.service;

import java.util.List;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.domain.SysOrg;
import com.region.moudles.system.domain.SysPOCTResult;
import com.region.moudles.tripartdock.yunzhi.domain.FdssUser;

/**
 * @ClassName: TripartTeamService
 * @Description: 三方对接 提供机构、医生信息、患者信息以及核酸检测信息
 * @author Administrator
 * @date 2019年7月25日
 */

public interface BeijingYunzhiService {

	List<SysOrg> getOrgList();
	
	List<FdssUser> getDoctorlList(String orgId);
	
	void getResidentPage(String orgId, PageModel page);
	
	void syncNucleinReslut(SysPOCTResult nuclein);
	
}
