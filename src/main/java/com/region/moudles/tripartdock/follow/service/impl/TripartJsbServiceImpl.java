package com.region.moudles.tripartdock.follow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.follow.dto.JsbDto;
import com.region.moudles.tripartdock.follow.dto.JsbJbDto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.follow.dao.FollowJsbDao;
import com.region.moudles.tripartdock.follow.dao.FollowJsbJbDao;
import com.region.moudles.tripartdock.follow.domain.FollowJsb;
import com.region.moudles.tripartdock.follow.domain.FollowJsbJb;
import com.region.moudles.tripartdock.follow.service.TripartJsbService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartJsbServiceImpl
 * @Description: 三方对接 保存精神病信息
 * @author Administrator
 * @date 2019年8月1日
 */
@Named
public class TripartJsbServiceImpl implements TripartJsbService {

	@Autowired
	private FollowJsbJbDao jsbJbDao;
	@Autowired
	private FollowJsbDao jsbDao;

	@Override
	public Map<String, Object> saveJsbJbInfo(List<FollowJsbJb> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String jbId = "";
		try {
			for (FollowJsbJb info : list) {
				jbId = info.getId();
				// 精神病的基本信息
				info.setId(UUIDUtil.getUUID());
				jsbJbDao.save(info);
			}
		} catch (Exception e) {
			map.put(jbId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowJsbJb getJsbJbInfo(String id) throws Exception {
		return jsbJbDao.getById(id);
	}

	@Override
	public JsonResult getJsbJbList(RequestDto request) throws Exception {
		List<JsbJbDto> list = jsbJbDao.getAll(request);
		int count = jsbJbDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveJsbSfInfo(List<FollowJsb> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String jsbId = "";
		try {
			for (FollowJsb info : list) {
				jsbId = info.getId();
				// 精神病的随访信息
				info.setId(UUIDUtil.getUUID());
				jsbDao.save(list);
			}
		} catch (Exception e) {
			map.put(jsbId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowJsb getJsbSfInfo(String id) throws Exception {
		return jsbDao.getById(id);
	}

	@Override
	public JsonResult getJsbSfList(RequestDto request) throws Exception {
		List<JsbDto> list = jsbDao.getAll(request);
		int count = jsbDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

}
