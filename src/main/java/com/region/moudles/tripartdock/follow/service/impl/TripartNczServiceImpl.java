package com.region.moudles.tripartdock.follow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.follow.dto.NczDto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.follow.dao.FollowNczDao;
import com.region.moudles.tripartdock.follow.domain.FollowNcz;
import com.region.moudles.tripartdock.follow.service.TripartNczService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartNczServiceImpl
 * @Description: 三方对接 保存脑卒中随访信息
 * @author Administrator
 * @date 2019年8月2日
 */
@Named
public class TripartNczServiceImpl implements TripartNczService {

	@Autowired
	private FollowNczDao nczDao;
	
	
	@Override
	public Map<String, Object> saveNczSdInfo(List<FollowNcz> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String nczId = "";
		try {
			for(FollowNcz info : list) {
				nczId = info.getId();
    			info.setId(UUIDUtil.getUUID());
    			nczDao.save(info);
			}
		}catch(Exception e) {
			map.put(nczId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowNcz getNczInfo(String id) throws Exception {
		return nczDao.getNczInfo(id);
	}

	@Override
	public JsonResult getNczList(RequestDto request) throws Exception {
		List<NczDto> list = nczDao.getAll(request);
		int count = nczDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

}

