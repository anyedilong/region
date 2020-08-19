package com.region.moudles.tripartdock.yunzhi.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dao.SysOrgDao;
import com.region.moudles.system.dao.SysPOCTResultDao;
import com.region.moudles.system.domain.SysOrg;
import com.region.moudles.system.domain.SysPOCTResult;
import com.region.moudles.tripartdock.archive.dao.JbxxjlbDao;
import com.region.moudles.tripartdock.yunzhi.dao.FdssUserDao;
import com.region.moudles.tripartdock.yunzhi.domain.FdssUser;
import com.region.moudles.tripartdock.yunzhi.service.BeijingYunzhiService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartTeamServiceImpl
 * @Description: 三方对接 保存团队项目相关信息
 * @author Administrator
 * @date 2019年7月25日
 */

@Named
public class BeijingYunzhiServiceImpl implements BeijingYunzhiService {

	@Inject
	private SysPOCTResultDao poctResultDao;
	@Inject
	private SysOrgDao orgDao;
	@Inject
	private FdssUserDao fdssUserDao;
	@Inject
	private JbxxjlbDao jbxxjlbDao;
	
	@Override
	public List<SysOrg> getOrgList() {
		return orgDao.getOrgList();
	}

	@Override
	public List<FdssUser> getDoctorlList(String orgId) {
		return fdssUserDao.getDoctorlList(orgId);
	}

	@Override
	public void getResidentPage(String orgId, PageModel page) {
		jbxxjlbDao.getResidentPage(orgId, page);
	}

	@Override
	public void syncNucleinReslut(SysPOCTResult nuclein) {
		
		nuclein.setId(UUIDUtil.getUUID());
		nuclein.setCreateTime(new Date());
		poctResultDao.save(nuclein);
	}
	
}

