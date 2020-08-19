package com.region.moudles.tripartdock.health.service;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import com.region.moudles.tripartdock.health.dto.YfjzDto;

public interface YfjzService {
    //查询预防接种详情
    YfjzDto getInfo(RequestDto request);

    //查询预防接种列表
    JsonResult getList(RequestDto request) throws Exception;
}
