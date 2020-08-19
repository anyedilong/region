package com.region.moudles.tripartdock.archive.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.archive.domain.Bsxx;
import com.region.moudles.tripartdock.archive.domain.Jbxxjlb;
import com.region.moudles.tripartdock.archive.domain.Jzsxxb;
import com.region.moudles.tripartdock.archive.domain.Shhjb;
import com.region.moudles.tripartdock.archive.dto.ArchiveQueryCon;
import com.region.moudles.tripartdock.health.bean.BaseCustomerDomain;

/**
 * @ClassName: TripartArchiveService
 * @Description: 三方对接 保存档案信息
 * @author Administrator
 * @date 2019年7月25日
 */
public interface TripartArchiveService {

	//保存档案相关信息
	Map<String, Object> saveArchiveInfo(List<Jbxxjlb> list) throws Exception;
	
	//档案列表(健康浏览器)
	void getArchivePage(Jbxxjlb jbxxjlb, PageModel page) throws Exception;
	//根据门诊住院条件获取档案的列表(健康浏览器)
	void getArchivePageByCon(ArchiveQueryCon info, PageModel page) throws Exception;
	//查询档案详情(健康浏览器-管理员登录)
	Jbxxjlb queryArchiveDetail(String archiveId, String sfzh) throws Exception;
	//查询档案详情(健康浏览器-his嵌入)
	Jbxxjlb queryArchiveDetailByCon(String hzmc, String zjlx, String sfzh) throws Exception;
	//查询病史信息(健康浏览器)
	List<Bsxx> queryBSxxDetail(String jmId) throws Exception;
	//查询家族史信息详情(健康浏览器)
	Jzsxxb queryJZSxxDetail(String jmId) throws Exception;
	//查询生活环境详情(健康浏览器)
	Shhjb querySHhjDetail(String jmId) throws Exception;

	BaseCustomerDomain getInfoBySfzh(String sfzh);
	
}
