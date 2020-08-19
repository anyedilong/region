package com.region.moudles.tripartdock.check.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.check.domain.Check;
import com.region.moudles.tripartdock.check.domain.Jkjc;
import com.region.moudles.tripartdock.check.domain.Jkwtb;
import com.region.moudles.tripartdock.check.domain.Jzbcs;
import com.region.moudles.tripartdock.check.domain.Jzs;
import com.region.moudles.tripartdock.check.domain.Pgzdjlb;
import com.region.moudles.tripartdock.check.domain.Shfs;
import com.region.moudles.tripartdock.check.domain.Xzjcjlb;
import com.region.moudles.tripartdock.check.domain.Ybzzb;
import com.region.moudles.tripartdock.check.domain.Yjjlb;
import com.region.moudles.tripartdock.check.domain.Zqgnb;
import com.region.moudles.tripartdock.check.domain.Zys;

/**
 * @ClassName: TripartCheckService
 * @Description: 三方对接 保存体检信息
 * @author Administrator
 * @date 2019年7月29日
 */
public interface TripartCheckService {

	//保存体检相关信息
	Map<String, Object> saveCheckInfo(List<Check> list) throws Exception;
	//获取最近两次体检的数据
	Map<String, Object> getCompareCheckInfo(String sfzh, String jcrq, PageModel page) throws Exception;
	//体检列表(健康浏览器)
	void getCheckPage(String jmId, PageModel page) throws Exception;
	//查询体检详情(健康浏览器)
	Check queryCheckDetail(String tjId) throws Exception;
	//查询健康检查详情(健康浏览器)
	Jkjc queryJkjcDetail(String tjId) throws Exception;
	//查询健康问题详情(健康浏览器)
	Jkwtb queryJkwtbDetail(String tjId) throws Exception;
	//查询评估指导详情(健康浏览器)
	Pgzdjlb queryPgzdjlbDetail(String tjId) throws Exception;
	//查询生活方式详情(健康浏览器)
	Shfs queryShfsDetail(String tjId) throws Exception;
	//查询辅助检查详情(健康浏览器)
	Xzjcjlb queryXzjcjlbDetail(String tjId) throws Exception;
	//查询辅助检查详情(健康浏览器)
	Ybzzb queryYbzzbDetail(String tjId) throws Exception;
	//查询脏器功能详情(健康浏览器)
	Zqgnb queryZqgnbDetail(String tjId) throws Exception;
	//查询家族病床史详情(健康浏览器)
	List<Jzbcs> queryJzbcsDetail(String tjId) throws Exception;
	//查询接种史详情(健康浏览器)
	List<Jzs> queryJzsDetail(String tjId) throws Exception;
	//查询药剂记录详情(健康浏览器)
	List<Yjjlb> queryYjjlbDetail(String tjId) throws Exception;
	//查询住院史详情(健康浏览器)
	List<Zys> queryZysDetail(String tjId) throws Exception;
	
	
}
