package com.region.moudles.system.service;

import com.region.moudles.common.service.BaseService;
import com.region.moudles.system.domain.SysDiseaseDomain;
import com.region.moudles.system.domain.SysDiseaseTypeDomain;
import com.region.moudles.system.dto.SysDiseaseDto;
import com.region.moudles.system.dto.SysDiseaseTypeDto;

import java.util.List;

public interface SysDiseaseService extends BaseService<SysDiseaseDomain> {

    //查询疾病
    List<SysDiseaseDto>  getDisease(String type);
    //查询疾类型
    List<SysDiseaseTypeDto> getType();

}
