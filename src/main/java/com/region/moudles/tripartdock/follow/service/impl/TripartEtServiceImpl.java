package com.region.moudles.tripartdock.follow.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.follow.dao.FollowEtJbDao;
import com.region.moudles.tripartdock.follow.dao.FollowEtXseDao;
import com.region.moudles.tripartdock.follow.dao.FollowEtZyygl1Dao;
import com.region.moudles.tripartdock.follow.dao.FollowEtZyygl3Dao;
import com.region.moudles.tripartdock.follow.dao.FollowEtZyygl6Dao;
import com.region.moudles.tripartdock.follow.dao.FollowEtsf1Dao;
import com.region.moudles.tripartdock.follow.dao.FollowEtsf3Dao;
import com.region.moudles.tripartdock.follow.dao.FollowEtsf6Dao;
import com.region.moudles.tripartdock.follow.domain.FollowEtJb;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf1;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf3;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf6;
import com.region.moudles.tripartdock.follow.domain.FollowEtXse;
import com.region.moudles.tripartdock.follow.domain.FollowEtZyygl1;
import com.region.moudles.tripartdock.follow.domain.FollowEtZyygl3;
import com.region.moudles.tripartdock.follow.domain.FollowEtZyygl6;
import com.region.moudles.tripartdock.follow.dto.Et1Dto;
import com.region.moudles.tripartdock.follow.dto.Et3Dto;
import com.region.moudles.tripartdock.follow.dto.Et6Dto;
import com.region.moudles.tripartdock.follow.dto.EtJbDto;
import com.region.moudles.tripartdock.follow.dto.EtZy1Dto;
import com.region.moudles.tripartdock.follow.dto.EtZy3Dto;
import com.region.moudles.tripartdock.follow.dto.EtZy6Dto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import com.region.moudles.tripartdock.follow.dto.XseDto;
import com.region.moudles.tripartdock.follow.service.TripartEtService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartEtServiceImpl
 * @Description: 三方对接 保存儿童信息
 * @author Administrator
 * @date 2019年8月1日
 */
@Named
public class TripartEtServiceImpl implements TripartEtService {

	@Autowired
	private FollowEtJbDao etJbDao;
	@Autowired
	private FollowEtXseDao etXseDao;
	@Autowired
	private FollowEtsf1Dao etsf1Dao;
	@Autowired
	private FollowEtsf3Dao etsf3Dao;
	@Autowired
	private FollowEtsf6Dao etsf6Dao;
	@Autowired
	private FollowEtZyygl1Dao etZyygl1Dao;
	@Autowired
	private FollowEtZyygl3Dao etZyygl3Dao;
	@Autowired
	private FollowEtZyygl6Dao etZyygl6Dao;


	@Override
	public JsonResult getEtList(RequestDto request) throws Exception {
		request.setPageSize(999);
		List xseList = etXseDao.getAll(request);
		List et1List = etsf1Dao.getAll(request);
		List et2List = etsf3Dao.getAll(request);
		List et3List = etsf6Dao.getAll(request);
		List et1ZyyList = etZyygl1Dao.getAll(request);
		List et3ZyyList = etZyygl3Dao.getAll(request);
		List et6ZyyList = etZyygl6Dao.getAll(request);
		List list = new ArrayList();
		if (xseList != null)
			list.addAll(xseList);
		if (et1List != null)
			list.addAll(et1List);
		if (et2List != null)
			list.addAll(et2List);
		if (et3List != null)
			list.addAll(et3List);
		if (et1ZyyList != null)
			list.addAll(et1ZyyList);
		if (et3ZyyList != null)
			list.addAll(et3ZyyList);
		if (et6ZyyList != null)
			list.addAll(et6ZyyList);
		return new JsonResult(list);
	}

	@Override
	public Map<String, Object> saveEtJbInfo(List<FollowEtJb> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String jbId = "";
		try {
			for(FollowEtJb jb : list) {
				jbId = jb.getId();
				// 儿童基本信息
				jb.setId(UUIDUtil.getUUID());
				etJbDao.save(jb);
			}
		}catch(Exception e) {
			map.put(jbId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowEtJb getEtJbInfo(String id) throws Exception {
		return etJbDao.getById(id);
	}

	@Override
	public JsonResult getEtJbList(RequestDto request) throws Exception {
		List<EtJbDto> list = etJbDao.getAll(request);
		int count = etJbDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> savetXsebInfo(List<FollowEtXse> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String xseId = "";
		try {
			for(FollowEtXse xse : list) {
				xseId = xse.getId();
				// 儿童新生儿家庭访视
				xse.setId(UUIDUtil.getUUID());
				etXseDao.save(xse);
			}
		}catch(Exception e) {
			map.put(xseId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowEtXse getXseInfo(String id) throws Exception {
		return etXseDao.getById(id);
	}

	@Override
	public JsonResult getXseList(RequestDto request) throws Exception {
		List<XseDto> list = etXseDao.getAll(request);
		int count = etXseDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveEtOneYearSfInfo(List<FollowEtSf1> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String oneYearId = "";
		try {
			for(FollowEtSf1 ef1 : list) {
				oneYearId = ef1.getId();
				// 儿童一岁以内的儿童随访
				ef1.setId(UUIDUtil.getUUID());
				etsf1Dao.save(ef1);
			}
		}catch(Exception e) {
			map.put(oneYearId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowEtSf1 getEtOneInfo(String id) throws Exception {
		return etsf1Dao.getById(id);
	}

	@Override
	public JsonResult getEtOneList(RequestDto request) throws Exception {
		List<Et1Dto> list = etsf1Dao.getAll(request);
		int count = etsf1Dao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveEtThreeYearInfo(List<FollowEtSf3> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String threeYearId = "";
		try {
			for(FollowEtSf3 ef3 : list) {
				threeYearId = ef3.getId();
				// 儿童1-3岁以内的儿童随访
				ef3.setId(UUIDUtil.getUUID());
				etsf3Dao.save(ef3);
			}
		}catch(Exception e) {
			map.put(threeYearId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowEtSf3 getEtThreeInfo(String id) throws Exception {
		return etsf3Dao.getEtthreeDetail(id);
	}

	@Override
	public JsonResult getEtThreeList(RequestDto request) throws Exception {
		List<Et3Dto> list = etsf3Dao.getAll(request);
		int count = etsf3Dao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveEtSixYearInfo(List<FollowEtSf6> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String sixYearId = "";
		try {
			for(FollowEtSf6 ef6 : list) {
				sixYearId = ef6.getId();
				// 儿童3-6岁以内的儿童随访
				ef6.setId(UUIDUtil.getUUID());
				etsf6Dao.save(ef6);
			}
		}catch(Exception e) {
			map.put(sixYearId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowEtSf6 getEtSixInfo(String id) throws Exception {
		return etsf6Dao.getById(id);
	}

	@Override
	public JsonResult getEtSixList(RequestDto request) throws Exception {
		List<Et6Dto> list = etsf6Dao.getAll(request);
		int count = etsf6Dao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveEtOneYearZyInfo(List<FollowEtZyygl1> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String oneYearZyId = "";
		try {
			for(FollowEtZyygl1 zy1 : list) {
				oneYearZyId = zy1.getId();
				// 儿童1岁以内儿童中医随访
				zy1.setId(UUIDUtil.getUUID());
				etZyygl1Dao.save(zy1);
			}
		}catch(Exception e) {
			map.put(oneYearZyId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowEtZyygl1 getEtOneZy(String id) throws Exception {
		return etZyygl1Dao.getById(id);
	}

	@Override
	public JsonResult getEtOneZyList(RequestDto request) throws Exception {
		List<EtZy1Dto> list = etZyygl1Dao.getAll(request);
		int count = etZyygl1Dao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveEtThreeYearZyInfo(List<FollowEtZyygl3> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String threeYearZyId = "";
		try {
			for(FollowEtZyygl3 zy3 : list) {
				threeYearZyId = zy3.getId();
				// 儿童1-3岁以内儿童中医随访
				zy3.setId(UUIDUtil.getUUID());
				etZyygl3Dao.save(zy3);
			}
		}catch(Exception e) {
			map.put(threeYearZyId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowEtZyygl3 getEtThreeZy(String id) throws Exception {
		return etZyygl3Dao.getById(id);
	}

	@Override
	public JsonResult getEtThreeZyList(RequestDto request) throws Exception {
		List<EtZy3Dto> list = etZyygl3Dao.getAll(request);
		int count = etZyygl3Dao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveEtSixYearZyInfo(List<FollowEtZyygl6> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String sixYearZyId = "";
		try {
			for(FollowEtZyygl6 zy6 : list) {
				sixYearZyId = zy6.getId();
				// 儿童3-6岁以内儿童中医随访
				zy6.setId(UUIDUtil.getUUID());
				etZyygl6Dao.save(zy6);
			}
		}catch(Exception e) {
			map.put(sixYearZyId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowEtZyygl6 getEtSixZy(String id) throws Exception {
		return etZyygl6Dao.getById(id);
	}

	@Override
	public JsonResult getEtSixZyList(RequestDto request) throws Exception {
		List<EtZy6Dto> list = etZyygl6Dao.getAll(request);
		int count = etZyygl6Dao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

}
