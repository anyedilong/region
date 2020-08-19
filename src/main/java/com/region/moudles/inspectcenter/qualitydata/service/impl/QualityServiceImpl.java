package com.region.moudles.inspectcenter.qualitydata.service.impl;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.inspectcenter.qualitydata.dao.QualityDao;
import com.region.moudles.inspectcenter.qualitydata.domain.QualityData;
import com.region.moudles.inspectcenter.qualitydata.service.QualityService;
import com.region.moudles.outpatient.dto.JcDto;
import com.region.moudles.system.dao.SysOrgDao;
import com.region.moudles.system.domain.SysOrg;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class QualityServiceImpl implements QualityService {

    @Inject
    private QualityDao qualityDao;
    @Inject
    private SysOrgDao sysOrgDao;

    //质控数据列表（分页）
    @Override
    public void getQualityPage(JcDto req) {
        SysOrg org = sysOrgDao.get(req.getOrgId());
        if (org == null)
            return;
        if (StringUtils.isBlank(req.getOrgCode())) {
            req.setOrgCode(org.getOrgCode());
        }
        qualityDao.getQualityPage(req);
    }

    //质控数据结果
    @Override
    public List<QualityData> getResultList(JcDto req) {
        return qualityDao.getQualityList(req);
    }
}
