package com.region.moudles.tripartdock.servicepackage.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.servicepackage.dao.repository.ServicePackageRepository;
import com.region.moudles.tripartdock.servicepackage.domain.ServicePackage;
import com.region.moudles.tripartdock.servicepackage.domain.ServiceProject;


@Named
public class ServicePackageDao extends BaseDao<ServicePackageRepository, ServicePackage> {


	/**
	 * @Description: 根据签约id查询服务包信息
	 * @param @param signId
	 * @return void
	 * @throws
	 */
	public List<ServicePackage> queryServicePackageInfo(String signId){
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select b.id, b.package_name ");
        sql.append(" from blt_sign_customer_package a ");
        sql.append(" join sys_service_package b on a.package_id = b.id ");
        sql.append(" where b.delete_flg = '0' and a.sign_id = :signId  ");
        paramMap.put("signId", signId);
        List<ServicePackage> list = queryList(sql.toString(), paramMap, ServicePackage.class);
        if(list != null && list.size() > 0) {
        	for(ServicePackage info : list) {
        		info.setServiceProjctList(queryServiceProjectInfo(info.getId()));
        	}
        } else {
        	list = new ArrayList<>();
        }
        return list;
   }
	
	/**
	 * @Description: 根据服务包查询服务项信息
	 * @param @param signId
	 * @return void
	 * @throws
	 */
	public List<ServiceProject> queryServiceProjectInfo(String packageId){
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select b.id, b.project_name ");
        sql.append(" from sys_package_project a ");
        sql.append(" join sys_service_project b on a.project_id = b.id ");
        sql.append(" where b.status = '1' and a.package_id = :packageId  ");
        paramMap.put("packageId", packageId);
        List<ServiceProject> list = queryList(sql.toString(), paramMap, ServiceProject.class);
        if(list == null) {
        	list = new ArrayList<>();
        } 
        return list;
   }
}
