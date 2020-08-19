package com.region.moudles.tripartdock.follow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import com.region.moudles.tripartdock.follow.dto.TnbDto;
import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.follow.dao.FollowTnbDao;
import com.region.moudles.tripartdock.follow.domain.FollowTnb;
import com.region.moudles.tripartdock.follow.domain.FollowTnbJb;
import com.region.moudles.tripartdock.follow.service.TripartTnbService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartTnbServiceImpl
 * @Description: 三方对接 保存糖尿病信息
 * @author Administrator
 * @date 2019年7月31日
 */
@Named
public class TripartTnbServiceImpl implements TripartTnbService {

	@Autowired
	private FollowTnbDao tnbDao;
	
	
	@Override
	public Map<String, Object> saveTnbInfo(List<FollowTnb> list) throws Exception {
		java.util.Map<String, Object> map = new HashMap<>();
		String tnbId = "";
		try {
			for(FollowTnb info : list) {
				tnbId = info.getId();
    			//糖尿病的基本信息
    			FollowTnbJb tnbJb = info.getFollowTnbJb();
    			if(tnbJb != null) {
    				tnbJb.setId(UUIDUtil.getUUID());
    				tnbDao.saveTnbJbInfo(tnbJb);
    			}
    			info.setId(UUIDUtil.getUUID());
    			tnbDao.save(info);
			}
		}catch(Exception e) {
			map.put(tnbId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowTnb getTnbInfo(String id) throws Exception {
		return tnbDao.getById(id);
	}

	@Override
	public JsonResult getTnbList(RequestDto request) throws Exception {
		List<TnbDto> list = tnbDao.getAll(request);
		int count = tnbDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

}

