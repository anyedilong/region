package com.region.moudles.system.service.impl;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.common.utils.cache.OrgCache;
import com.region.moudles.system.dao.SysOrgDao;
import com.region.moudles.system.domain.SysOrg;
import com.region.moudles.system.service.SysOrgService;

import java.util.List;

import javax.inject.Named;

@Named
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrgDao,SysOrg> implements SysOrgService {

    @Override
    public void queryOrgPage(SysOrg sysOrg, PageModel page) throws Exception{
           dao.queryOrgPage(sysOrg, page);
    }

	@Override
	public List<SysOrg> queryOrgList() throws Exception {
		return dao.queryOrgList();
	}
	
	@Override
	public SysOrg queryOrgByCode(String orgCode) throws Exception {
		return dao.queryOrgByCode(orgCode);
	}
	
	@Override
	public String queryOrgCodeByAuthCode(String authCode) {
		return dao.queryOrgCodeByAuthCode(authCode);
	}
	
	@Override
	public List<SysOrg> queryOrgInfoList() throws Exception {
		return dao.queryOrgInfoList();
	}

	@Override
	public List<OrgCache> getChildOrg(String orgId) {
		return dao.getOrgByCode(orgId);
	}

}
