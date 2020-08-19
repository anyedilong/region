package com.region.moudles.tripartdock.follow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.follow.dto.GxyDto;
import com.region.moudles.tripartdock.follow.dto.GxySzDto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.follow.dao.FollowGxyDao;
import com.region.moudles.tripartdock.follow.domain.FollowGxy;
import com.region.moudles.tripartdock.follow.domain.FollowGxyJb;
import com.region.moudles.tripartdock.follow.domain.FollowGxySz;
import com.region.moudles.tripartdock.follow.domain.FollowGxySzmqyy;
import com.region.moudles.tripartdock.follow.domain.FollowGxySzywzlb;
import com.region.moudles.tripartdock.follow.service.TripartGxyService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartGxyServiceImpl
 * @Description: 三方对接 保存高血压信息
 * @author Administrator
 * @date 2019年7月31日
 */
@Named
public class TripartGxyServiceImpl implements TripartGxyService {

	@Autowired
	private FollowGxyDao gxyDao;
	
	
	@Override
	public Map<String, Object> saveGxyJbInfo(List<FollowGxyJb> list) throws Exception {
		 Map<String, Object> map = new HashMap<>();
		 String jbId = "";
		 try {
			 for(FollowGxyJb info : list) {
				jbId = info.getId();
				//高血压基本信息
				info.setId(UUIDUtil.getUUID());
		    	gxyDao.saveGxyJbInfo(info);
			 }
		 }catch(Exception e) {
			 map.put(jbId, e.getMessage());
		 }
		 return map;
	}

	@Override
	public FollowGxyJb getGxyJbInfo(String id) throws Exception {
		return gxyDao.getGxyJbById(id);
	}

	@Override
	public Map<String, Object> saveGxySfInfo(List<FollowGxy> list) throws Exception {
		 Map<String, Object> map = new HashMap<>();
		 String gxyId = "";
		 try {
			 for(FollowGxy info : list) {
				gxyId = info.getId();
				//高血压随访信息
				info.setId(UUIDUtil.getUUID());
		    	gxyDao.save(info);
			 }
		 }catch(Exception e) {
			 map.put(gxyId, e.getMessage());
		 }
		 return map;
	}

	@Override
	public FollowGxy getGxySfInfo(String id) throws Exception {
		return gxyDao.getById(id);
	}

	@Override
	public JsonResult getGxySfList(RequestDto request) throws Exception {
		List<GxyDto> list = gxyDao.getAll(request);
		int count = gxyDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveGxySzInfo(List<FollowGxySz> list) throws Exception {
		 Map<String, Object> map = new HashMap<>();
		 String szId = "";
		 try {
			 for(FollowGxySz info : list) {
			 	szId = info.getId();
    			//高血压首诊目前用药信息
    			List<FollowGxySzmqyy> mqyys = info.getGxySzmqyy();
    			if(mqyys != null && mqyys.size() > 0) {
    				gxyDao.saveGxySzmqyyInfo(mqyys);
    			}
    			//高血压首诊药物治疗信息
    			List<FollowGxySzywzlb> ywzls = info.getGxySzywzlbs();
    			if(ywzls != null && ywzls.size() > 0) {
    				gxyDao.saveGxySzywlbInfo(ywzls);
    			}
    			//高血压首诊信息
    			info.setId(UUIDUtil.getUUID());
    			gxyDao.saveGxySzInfo(info);
    		}
		 }catch(Exception e) {
			 map.put(szId, e.getMessage());
		 }
		 return map;
	}

	@Override
	public FollowGxySz getGxySzInfo(String id) throws Exception {
		return gxyDao.getGxySzById(id);
	}

	@Override
	public JsonResult getGxySzList(RequestDto request) throws Exception {
		List<GxySzDto> list = gxyDao.getSzAll(request);
		int count = gxyDao.getSzCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

}

