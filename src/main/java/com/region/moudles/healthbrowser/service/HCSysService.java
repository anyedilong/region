package com.region.moudles.healthbrowser.service;

import java.util.List;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.healthbrowser.dto.JyInfoDto;
import com.region.moudles.healthbrowser.dto.ReportInfoDto;

public interface HCSysService {

	//获取检验的列表(惠民平台)
	void getJyList(String sfzh, PageModel page) throws Exception;
	//获取检验的详情（惠民平台）
	List<JyInfoDto> getJyDetail(String id, String type, String itemType) throws Exception;
	//获取检查的列表(惠民平台)
	void getJcList(String sfzh, PageModel page) throws Exception;
	//获取检查的详情（惠民平台）
	ReportInfoDto getJcDetail(String id, String type, String imageType)throws Exception;
}
