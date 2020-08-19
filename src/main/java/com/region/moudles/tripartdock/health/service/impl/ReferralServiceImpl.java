package com.region.moudles.tripartdock.health.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.archive.dao.JbxxjlbDao;
import com.region.moudles.tripartdock.health.bean.BaseCustomerDomain;
import com.region.moudles.tripartdock.health.bean.Referral;
import com.region.moudles.tripartdock.health.dao.ReferralDao;
import com.region.moudles.tripartdock.health.service.ReferralService;

@Named
public class ReferralServiceImpl implements ReferralService {
    @Autowired
    private ReferralDao referralDao;
    @Autowired
    private JbxxjlbDao jbxxjlbDao;

    @Override
    public Referral getInfo(String id) {
        return referralDao.getById(id);
    }

	@Override
	public void getReferralPage(String jmId, PageModel page) throws Exception {
		referralDao.getReferralPage(jmId, page);
		long count = page.getCount();
		if(count > 0) {
			@SuppressWarnings("unchecked")
			List<Referral> list = page.getList();
			for(int i = 0; i < list.size(); i++) {
				BaseCustomerDomain info = jbxxjlbDao.getCustomerInfoById(list.get(i).getJmId());
				list.get(i).setCustomer(info);
			}
		}
	}
}
