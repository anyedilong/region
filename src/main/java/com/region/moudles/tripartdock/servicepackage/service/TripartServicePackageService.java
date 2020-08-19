package com.region.moudles.tripartdock.servicepackage.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.tripartdock.servicepackage.domain.ServicePackage;
import com.region.moudles.tripartdock.servicepackage.domain.ServiceProject;

/**
 * @ClassName: TripartServicePackageService
 * @Description: 三方对接 保存服务包和服务项
 * @author Administrator
 * @date 2019年7月25日
 */

public interface TripartServicePackageService {

	//保存服务包相关信息
	Map<String, Object> saveServicePackageInfo(List<ServicePackage> list) throws Exception;
    
    //保存服务项相关信息
	Map<String, Object> saveServiceProjectInfo(List<ServiceProject> list) throws Exception;
    
}
