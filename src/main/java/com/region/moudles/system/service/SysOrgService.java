package com.region.moudles.system.service;

import java.util.List;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.BaseService;
import com.region.moudles.common.utils.cache.OrgCache;
import com.region.moudles.system.domain.SysOrg;

public interface SysOrgService extends BaseService<SysOrg> {

     //查询机构列表（分页）
     void queryOrgPage(SysOrg sysOrg, PageModel page) throws Exception;
     
     List<SysOrg> queryOrgList() throws Exception;
     
     SysOrg queryOrgByCode(String orgCode) throws Exception;
     
     //根据授权code查询授权机构的code
     String queryOrgCodeByAuthCode(String authCode);
     //查询四五级的机构（健康浏览器）
     List<SysOrg> queryOrgInfoList() throws Exception;

     List<OrgCache> getChildOrg(String orgId);
     
}
