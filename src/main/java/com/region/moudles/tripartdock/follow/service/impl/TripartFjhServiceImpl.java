package com.region.moudles.tripartdock.follow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.follow.dto.FjhDto;
import com.region.moudles.tripartdock.follow.dto.FjhrhDto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.follow.dao.FollowFjhDao;
import com.region.moudles.tripartdock.follow.dao.FollowFjhJbDao;
import com.region.moudles.tripartdock.follow.dao.FollowFjhrhDao;
import com.region.moudles.tripartdock.follow.domain.FollowFjh;
import com.region.moudles.tripartdock.follow.domain.FollowFjhJb;
import com.region.moudles.tripartdock.follow.domain.FollowFjhrh;
import com.region.moudles.tripartdock.follow.service.TripartFjhService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartFjhServiceImpl
 * @Description: 三方对接 保存肺结核信息
 * @author Administrator
 * @date 2019年8月1日
 */
@Named
public class TripartFjhServiceImpl implements TripartFjhService {

	@Autowired
	private FollowFjhJbDao fjhJbDao;
	@Autowired
	private FollowFjhrhDao fjhRhDao;
	@Autowired
	private FollowFjhDao fjhDao;
	
	
	@Override
	public Map<String, Object> saveFjhJbInfo(List<FollowFjhJb> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String jbId = "";
		try {
			for(FollowFjhJb jb : list) {
				jbId = jb.getId();
				//肺结核基本信息
				jb.setId(UUIDUtil.getUUID());
	    		fjhJbDao.save(jb);
			}
		}catch(Exception e) {
			map.put(jbId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowFjhJb getFjhJbInfo(String id) throws Exception {
		return fjhJbDao.getById(id);
	}

	@Override
	public Map<String, Object> saveFjhRhInfo(List<FollowFjhrh> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String rhId = "";
		try {
			for(FollowFjhrh rh : list) {
				rhId = rh.getId();
				//肺结核入户信息
				rh.setId(UUIDUtil.getUUID());
	    		fjhRhDao.save(rh);
			}
		}catch(Exception e) {
			map.put(rhId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowFjhrh getFjhRhInfo(String id) throws Exception {
		return fjhRhDao.getById(id);
	}

	@Override
	public JsonResult getFjhRhList(RequestDto request) throws Exception {
		List<FjhrhDto> list = fjhRhDao.getAll(request);
		int count = fjhRhDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveFjhSfInfo(List<FollowFjh> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String fjhId = "";
		try {
			for(FollowFjh fjh : list) {
				fjhId = fjh.getId();
				//肺结核的随访信息
				fjh.setId(UUIDUtil.getUUID());
	    		fjhDao.save(fjh);
			}
		}catch(Exception e) {
			map.put(fjhId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowFjh getFjhSfInfo(String id) throws Exception {
		return fjhDao.getById(id);
	}

	@Override
	public JsonResult getFjhSfList(RequestDto request) throws Exception {
		List<FjhDto> list = fjhDao.getAll(request);
		int count = fjhDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

}

