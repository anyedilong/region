package com.region.moudles.his.authcode.service.impl;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.his.authcode.dao.SysAuthDao;
import com.region.moudles.his.authcode.domain.SysAuth;
import com.region.moudles.his.authcode.service.SysAuthService;

import javax.inject.Named;

@Named
public class SysAuthServiceImpl extends BaseServiceImpl<SysAuthDao,SysAuth> implements SysAuthService {

    @Override
    public void updateAuth(String id,String status) {
       dao.updateAuth(id,status);
    }

    @Override
    public void queryAuth(SysAuth auth, PageModel page) {
       dao.queryAuth(auth, page);
    }
}
