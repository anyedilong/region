package com.region.moudles.tripartdock.sign.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.tripartdock.sign.domain.Sign;
import com.region.moudles.tripartdock.sign.dto.SignRecordDto;

/**
 * @author Administrator
 * @ClassName: TripartSignService
 * @Description: 三方对接 保存签约的信息
 * @date 2019年7月25日
 */

public interface TripartSignService {

    //保存签约相关信息
    Map<String, Object> saveSignInfo(List<Sign> list) throws Exception;
    //获取签约详情
    Sign getSignInfo(String jmId) throws Exception;
    //获取履约服务列表
    List<SignRecordDto> getSignServiceList(String jmId) throws Exception;
    //获取履约服务详情
    List<SignRecordDto> getSignServiceInfo(String signId, String packeageId, String projectId) throws Exception;
    
}
