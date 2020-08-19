package com.region.moudles.tripartdock.health.service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.health.bean.Referral;

public interface ReferralService {
	
	//转诊列表
	void getReferralPage(String jmId, PageModel page) throws Exception;
	
    Referral getInfo (String id);
}
