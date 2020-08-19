package com.region.moudles.his.authcode.service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.BaseService;
import com.region.moudles.his.authcode.domain.SysAuth;

public interface SysAuthService extends BaseService<SysAuth> {

    /**
     * 修改授权状态
     * @param id
     */
   void  updateAuth(String id,String status);

    /**
     * 授权列表
     * @param page
     */
   void queryAuth(SysAuth auth, PageModel page);
}
