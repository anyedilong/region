package com.region.moudles.tripartdock.follow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.follow.dto.GxbDto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.follow.dao.FollowGxbDao;
import com.region.moudles.tripartdock.follow.domain.FollowGxb;
import com.region.moudles.tripartdock.follow.service.TripartGxbService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartGxbServiceImpl
 * @Description: 三方对接 保存冠心病信息
 * @author Administrator
 * @date 2019年8月2日
 */
@Named
public class TripartGxbServiceImpl implements TripartGxbService {

	@Autowired
	private FollowGxbDao gxbDao;
	
	
	@Override
	public Map<String, Object> saveGxbSfInfo(List<FollowGxb> list) throws Exception {
		 Map<String, Object> map = new HashMap<>();
		 String gxbId = "";
		 try {
			 for(FollowGxb gxb : list) {
				 gxbId = gxb.getId();
				 gxb.setId(UUIDUtil.getUUID());
				 gxbDao.save(gxb);
			 }
		 }catch(Exception e) {
			 map.put(gxbId, e.getMessage());
		 }
		 return map;
	}

	@Override
	public FollowGxb getGxbSfInfo(String id) throws Exception {
		return gxbDao.getById(id);
	}

	@Override
	public JsonResult getGxbSfList(RequestDto request) throws Exception {
		List<GxbDto> list = gxbDao.getAll(request);
		int count = gxbDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

}

