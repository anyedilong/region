package com.region.moudles.tripartdock.follow.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.follow.dto.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.follow.dao.FollowYcfCh42Dao;
import com.region.moudles.tripartdock.follow.dao.FollowYcfChDao;
import com.region.moudles.tripartdock.follow.dao.FollowYcfCqDao;
import com.region.moudles.tripartdock.follow.dao.FollowYcfDao;
import com.region.moudles.tripartdock.follow.dao.FollowYcfScDao;
import com.region.moudles.tripartdock.follow.dao.FollowYcfScFzjcDao;
import com.region.moudles.tripartdock.follow.domain.FollowYcfCh;
import com.region.moudles.tripartdock.follow.domain.FollowYcfCh42;
import com.region.moudles.tripartdock.follow.domain.FollowYcfCq;
import com.region.moudles.tripartdock.follow.domain.FollowYcfJb;
import com.region.moudles.tripartdock.follow.domain.FollowYcfSc;
import com.region.moudles.tripartdock.follow.domain.FollowYcfScFzjc;
import com.region.moudles.tripartdock.follow.service.TripartYcfService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartYcfServiceImpl
 * @Description: 三方对接 保存孕产妇信息
 * @author Administrator
 * @date 2019年8月2日
 */
@Named
public class TripartYcfServiceImpl implements TripartYcfService {

	@Autowired
	private FollowYcfScDao ycfScDao;
	@Autowired
	private FollowYcfDao ycfDao;
	@Autowired
	private FollowYcfScFzjcDao ycfScFzjcDao;
	@Autowired
	private FollowYcfCqDao ycfCqDao;
	@Autowired
	private FollowYcfChDao ycfChDao;
	@Autowired
	private FollowYcfCh42Dao ycfCh42Dao;


	@Override
	public JsonResult getYcfList(RequestDto request) throws Exception {
		request.setPageSize(999);
		List ycfScList = ycfScDao.getAll(request);
		List ycfCqList = ycfCqDao.getAll(request);
		List ycfChList = ycfChDao.getAll(request);
		List ycfCh42List = ycfCh42Dao.getAll(request);
		List list = new ArrayList();
		if (ycfScList != null)
			list.addAll(ycfScList);
		if (ycfCqList != null)
			list.addAll(ycfCqList);
		if (ycfChList != null)
			list.addAll(ycfChList);
		if (ycfCh42List != null)
			list.addAll(ycfCh42List);
		return new JsonResult(list);
	}

	@Override
	public Map<String, Object> saveYcfCqSfInfo(List<FollowYcfSc> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String scId = "";
		try {
			for(FollowYcfSc info : list) {
				scId = info.getId();
    			//获取孕产妇基本信息
    			FollowYcfJb ycfJbInfo = info.getFollowYcfJb();
    			if(ycfJbInfo != null) {
    				ycfJbInfo.setId(UUIDUtil.getUUID());
    				ycfDao.save(ycfJbInfo);
    			}
    			//获取孕产妇产前首访辅助信息
    			FollowYcfScFzjc ycfScFzjc = info.getFollowYcfScFzjc();
    			if(ycfScFzjc != null) {
    				ycfScFzjc.setId(UUIDUtil.getUUID());
    				ycfScFzjcDao.save(ycfScFzjc);
    			}
    			//保存孕产妇产前首访信息
    			info.setId(UUIDUtil.getUUID());
    			ycfScDao.save(info);
    		}
		}catch(Exception e) {
			map.put(scId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowYcfSc getYcfscInfo(String id) throws Exception {
		return ycfScDao.getById(id);
	}

	@Override
	public JsonResult getYcfscList(RequestDto request) throws Exception {
		List<YfscDto> list = ycfScDao.getAll(request);
		int count = ycfScDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveCqTwoToFiveInfo(List<FollowYcfCq> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String cqId = "";
		try {
			for(FollowYcfCq info : list) {
				cqId = info.getId();
				//保存产前2到5次随访信息
				info.setId(UUIDUtil.getUUID());
	    		ycfCqDao.save(info);
			}
		}catch(Exception e) {
			map.put(cqId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowYcfCq getYcfcqInfo(String id) throws Exception {
		return ycfCqDao.getById(id);
	}

	@Override
	public JsonResult getYcfcqList(RequestDto request) throws Exception {
		List<YfcqDto> list = ycfCqDao.getAll(request);
		int count = ycfCqDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveYcfChInfo(List<FollowYcfCh> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String chId = "";
		try {
			for(FollowYcfCh info : list) {
				chId = info.getId();
				//保存产后访视信息
				info.setId(UUIDUtil.getUUID());
	    		ycfChDao.save(info);
			}
		}catch(Exception e) {
			map.put(chId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowYcfCh getYcfchInfo(String id) throws Exception {
		return ycfChDao.getById(id);
	}

	@Override
	public JsonResult getYcfchList(RequestDto request) throws Exception {
		List<YfchDto> list = ycfChDao.getAll(request);
		int count = ycfChDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveYcfChFortyTwoInfo(List<FollowYcfCh42> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String ch42Id = "";
		try {
			for(FollowYcfCh42 info : list) {
				ch42Id = info.getId();
				//保存产后42天访视
				info.setId(UUIDUtil.getUUID());
	    		ycfCh42Dao.save(info);
			}
		}catch(Exception e) {
			map.put(ch42Id, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowYcfCh42 getYcfch42Info(String id) throws Exception {
		return ycfCh42Dao.getById(id);
	}

	@Override
	public JsonResult getYcfch42List(RequestDto request) throws Exception {
		List<Yfch42Dto> list = ycfCh42Dao.getAll(request);
		int count = ycfCh42Dao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

}

