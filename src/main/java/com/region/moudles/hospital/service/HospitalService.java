package com.region.moudles.hospital.service;

import java.util.ArrayList;
import java.util.List;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.hospital.domain.HospitalEmr;
import com.region.moudles.hospital.domain.HospitalImage;
import com.region.moudles.hospital.domain.HospitalInfto;
import com.region.moudles.hospital.domain.HospitalJc;
import com.region.moudles.hospital.domain.HospitalOrder;
import com.region.moudles.hospital.domain.HospitalOrderItem;
import com.region.moudles.hospital.domain.HospitalOutCost;
import com.region.moudles.hospital.domain.HospitalOutMingXi;
import com.region.moudles.hospital.domain.HospitalZd;

public interface HospitalService {

	ArrayList<String> saveHospital(List<HospitalInfto> list, String orgCode);
	ArrayList<String> saveDiagnosis(List<HospitalZd> list, String orgCode);
	ArrayList<String> saveInspect(List<HospitalJc> list, String orgCode);
	ArrayList<String> saveoutcost(List<HospitalOutCost> list, String orgCode);
	ArrayList<String> savehospitalcost(String outId, List<HospitalOutMingXi> list);
	ArrayList<String> saveImage(List<HospitalImage> list);

	// 查询住院列表(公卫)
	void getHospitalZYInfoPage(String sfzh, PageModel page);
	// 查询入院登记详情(公卫)
	HospitalInfto getZYDJDetail(String zyId);
	// 查询出院结算列表(公卫)
	void getCYJSInfoPage(String sfzh, PageModel page);
	// 查询出院结算详情(公卫)
	HospitalOutCost getCYJSDetail(String cyId);
	// 查询住院病案列表(公卫)
	void getZYBAList(String sfzh, PageModel page);
	// 查询住院病案详情(公卫)
	HospitalEmr getZYBADetail(String emrId, String admissionId, String orgCode);
	// 查询住院列表(健康浏览器和惠民平台)
	void getHospitalPage(String sfzh, PageModel page);
	// 查询住院详情(健康浏览器和惠民平台)
	HospitalInfto getHospitalDetail(String id);
	// 查询住院详情(健康浏览器和惠民平台)
	HospitalInfto getAppHospitalDetail(String id);
	// 查询住院明细详情(健康浏览器和惠民平台)
	List<HospitalOutCost> getHospitalCostList(String zyId, String startTime, String endTime, String name);
	// 查询住院诊断的详情(健康浏览器和惠民平台)
	List<HospitalZd> getHospitalZDList(String zyId) throws Exception;
	// 查询住院影像的详情(健康浏览器和惠民平台)
	List<HospitalImage> getHospitalImageList(String zyId) throws Exception;
	//更新影像的jpg路径
    void updateImageJpgPath(String imageId, String imageJpgPath);
	// 查询住院检查的详情(健康浏览器和惠民平台)
	List<HospitalJc> getHospitalJcList(String zyId, String itemType) throws Exception;
	//查询住院医嘱的列表(健康浏览器和惠民平台)
	List<HospitalOrder> getHospitalOrderList(String zyId) throws Exception;
	//查询住院医嘱的详情(健康浏览器和惠民平台)
	HospitalOrder getHospitalOrderDetail(String id) throws Exception;
	//查询住院医嘱明细的详情(健康浏览器和惠民平台)
	List<HospitalOrderItem> getHospitalOrderItemList(String zyId) throws Exception;
	
}
