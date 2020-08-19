package com.region.moudles.system.service.impl;

import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.system.dao.SysDiseaseDao;
import com.region.moudles.system.domain.SysDiseaseDomain;
import com.region.moudles.system.domain.SysDiseaseTypeDomain;
import com.region.moudles.system.dto.SysDiseaseDto;
import com.region.moudles.system.dto.SysDiseaseTypeDto;
import com.region.moudles.system.service.SysDiseaseService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SysDiseaseServiceImpl extends BaseServiceImpl<SysDiseaseDao,SysDiseaseDomain> implements SysDiseaseService {

    @Inject
    private  SysDiseaseDao sysDiseaseDao;
    @Override
    public List<SysDiseaseDto> getDisease(String type) {

       return sysDiseaseDao.getDisease(type);

    }

    @Override
    public List<SysDiseaseTypeDto> getType() {
        return  sysDiseaseDao.gettype();
    }
}
