package com.region.moudles.tripartdock.servicepackage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.servicepackage.dao.ServicePackageDao;
import com.region.moudles.tripartdock.servicepackage.dao.ServicePackageProjectDao;
import com.region.moudles.tripartdock.servicepackage.dao.ServiceProjectDao;
import com.region.moudles.tripartdock.servicepackage.dao.ServiceProjectOrgDao;
import com.region.moudles.tripartdock.servicepackage.domain.ServicePackage;
import com.region.moudles.tripartdock.servicepackage.domain.ServicePackageProject;
import com.region.moudles.tripartdock.servicepackage.domain.ServiceProject;
import com.region.moudles.tripartdock.servicepackage.domain.ServiceProjectOrg;
import com.region.moudles.tripartdock.servicepackage.service.TripartServicePackageService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartServicePackageServiceImpl
 * @Description: 三方对接 保存服务包和服务项
 * @author Administrator
 * @date 2019年7月25日
 */

@Named
public class TripartServicePackageServiceImpl implements TripartServicePackageService {

	@Autowired
	private ServicePackageDao servicePackageDao;
	@Autowired
	private ServicePackageProjectDao servicePackageProjectDao;
	@Autowired
	private ServiceProjectDao serviceProjectDao;
	@Autowired
	private ServiceProjectOrgDao serviceProjectOrgDao;
	
	ExecutorService es = new ThreadPoolExecutor(20, 25, 5L, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
	
	//保存服务包相关信息
	@Override
	public Map<String, Object> saveServicePackageInfo(List<ServicePackage> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String packageId = "";
		try {
			for(ServicePackage info : list) {
				packageId = info.getId();
    			//服务包与服务项的关系信息
    			List<ServicePackageProject> spList = info.getProjectList();
    			if(spList != null && spList.size() > 0) {
    				servicePackageProjectDao.save(spList);
    			}
    			info.setId(UUIDUtil.getUUID());
    			servicePackageDao.save(info);
    		}
		}catch(Exception e) {
			e.printStackTrace();
			map.put(packageId, e.getMessage());
		}
		return map;
	}
	
	//保存服务项相关信息
	@Override
	public Map<String, Object> saveServiceProjectInfo(List<ServiceProject> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String projectId = "";
		try {
			for(ServiceProject info : list) {
				projectId = info.getId();
    			//服务项与机构的关系信息
    			ServiceProjectOrg spo = info.getServiceProjectOrg();
    			if(spo != null) {
    				spo.setId(UUIDUtil.getUUID());
    				serviceProjectOrgDao.save(spo);
    			}
    			info.setId(UUIDUtil.getUUID());
    			serviceProjectDao.save(info);
    		}
		}catch(Exception e) {
			e.printStackTrace();
			map.put(projectId, e.getMessage());
		}
		return map;
		
	}
	
}

