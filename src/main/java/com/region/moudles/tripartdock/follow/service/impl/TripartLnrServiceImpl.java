package com.region.moudles.tripartdock.follow.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.utils.properties.PropertiesUtil;
import com.region.moudles.system.dao.SysOrgDao;
import com.region.moudles.system.domain.SysOrg;
import com.region.moudles.tripartdock.follow.dto.JkpgDto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import com.region.moudles.tripartdock.follow.dto.ZyyglDto;
import com.region.until.http.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.archive.dao.JbxxjlbDao;
import com.region.moudles.tripartdock.archive.domain.Jbxxjlb;
import com.region.moudles.tripartdock.check.dao.CheckDao;
import com.region.moudles.tripartdock.follow.dao.FollowLnrDao;
import com.region.moudles.tripartdock.follow.dao.FollowLnrJkpgDao;
import com.region.moudles.tripartdock.follow.dao.FollowLnrZyyglJgDao;
import com.region.moudles.tripartdock.follow.domain.FollowLnrJkpg;
import com.region.moudles.tripartdock.follow.domain.FollowLnrZyygl;
import com.region.moudles.tripartdock.follow.domain.FollowLnrZyyglJg;
import com.region.moudles.tripartdock.follow.service.TripartLnrService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartLnrServiceImpl
 * @Description: 三方对接 保存老年人信息
 * @author Administrator
 * @date 2019年8月2日
 */
@Named
public class TripartLnrServiceImpl implements TripartLnrService {

	@Autowired
	private FollowLnrJkpgDao lnrJkpgDao;
	@Autowired
	private FollowLnrDao lnrZyyglDao;
	@Autowired
	private FollowLnrZyyglJgDao lnrZyygljgDao;
	@Autowired
	private JbxxjlbDao jbxxjlbDao;
	@Autowired
	private SysOrgDao orgDao;
	@Autowired
	private CheckDao checkDao;

	@Override
	public Map<String, Object> saveLnrJkpgInfo(List<FollowLnrJkpg> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String jkpgId = "";
		try {
			for (FollowLnrJkpg info : list) {
				jkpgId = info.getId();
				// 老年人健康评估
				info.setId(UUIDUtil.getUUID());
				lnrJkpgDao.save(info);
			}
		} catch (Exception e) {
			map.put(jkpgId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowLnrJkpg getJkpgInfo(String id) throws Exception {
		FollowLnrJkpg info = lnrJkpgDao.getById(id);
		if(info != null) {
			Jbxxjlb jbxxjlb = jbxxjlbDao.get(info.getJmid());
			if(jbxxjlb != null) {
				SysOrg sysOrg = orgDao.get(jbxxjlb.getJdjg());
				if(sysOrg != null) {
					info.setOrgName(sysOrg.getOrgName());
				}
			}
		}
		return info;
	}

	@Override
	public JsonResult getJkpgList(RequestDto request) throws Exception {
		List<JkpgDto> list = lnrJkpgDao.getAll(request);
		int count = lnrJkpgDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

	@Override
	public Map<String, Object> saveLnrZyyglInfo(List<FollowLnrZyygl> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String zyyglId = "";
		try {
			for (FollowLnrZyygl info : list) {
				zyyglId = info.getId();
				// 老年人中医药管理结果
				FollowLnrZyyglJg zyyglJg = info.getFollowLnrZyyglJg();
				String infoId = UUIDUtil.getUUID();
				String pgId = UUIDUtil.getUUID();
				if (zyyglJg != null) {
					zyyglJg.setId(pgId);
					zyyglJg.setPgid(infoId);
					lnrZyygljgDao.save(zyyglJg);
				}
				// 老年人中医药管理
				info.setId(infoId);
				lnrZyyglDao.save(info);
			}
		} catch (Exception e) {
			map.put(zyyglId, e.getMessage());
		}
		return map;
	}

	@Override
	public FollowLnrZyygl getZyyglInfo(String id) throws Exception {
		FollowLnrZyygl info = lnrZyyglDao.getById(id);
		if(info != null) {
			FollowLnrZyyglJg zyygljg = lnrZyygljgDao.getZyyglJgInfo(info.getId());
			info.setFollowLnrZyyglJg(zyygljg);
			String tjdw = checkDao.getTjdwByCon(info.getSfzh(), info.getTjbh());
			info.setOrgName(tjdw);
			List<JSONObject> list = new ArrayList<>();
			if (zyygljg != null) {
				if("1".equals(zyygljg.getPhz())) {
					JSONObject json = new JSONObject();
					json.put("type", "1");//平和质
					json.put("typeText", "平和质");
					json.put("proposal", zyygljg.getPhzjy());
					list.add(json);
				}
				if("1".equals(zyygljg.getQxz())) {
					JSONObject json = new JSONObject();
					json.put("type", "2");//气虚质
					json.put("typeText", "气虚质");
					json.put("proposal", zyygljg.getQxzjy());
					list.add(json);
				}
				if("1".equals(zyygljg.getYxuz())) {
					JSONObject json = new JSONObject();
					json.put("type", "3");//阳虚质
					json.put("typeText", "阳虚质");
					json.put("proposal", zyygljg.getYxuzjy());
					list.add(json);
				}
				if("1".equals(zyygljg.getYxzdf())) {
					JSONObject json = new JSONObject();
					json.put("type", "4");//阴虚质
					json.put("typeText", "阴虚质");
					json.put("proposal", zyygljg.getYxzjy());
					list.add(json);
				}
				if("1".equals(zyygljg.getTsz())) {
					JSONObject json = new JSONObject();
					json.put("type", "5");//痰湿质
					json.put("typeText", "痰湿质");
					json.put("proposal", zyygljg.getTszjy());
					list.add(json);
				}
				if("1".equals(zyygljg.getSrz())) {
					JSONObject json = new JSONObject();
					json.put("type", "6");//湿热质
					json.put("typeText", "湿热质");
					json.put("proposal", zyygljg.getSrzjy());
					list.add(json);
				}
				if("1".equals(zyygljg.getQyz())) {
					JSONObject json = new JSONObject();
					json.put("type", "7");//气郁质
					json.put("typeText", "气郁质");
					json.put("proposal", zyygljg.getQyzjy());
					list.add(json);
				}else if("1".equals(zyygljg.getXyz())) {
					JSONObject json = new JSONObject();
					json.put("type", "8");//血瘀质
					json.put("typeText", "血瘀质");
					json.put("proposal", zyygljg.getXyzjy());
					list.add(json);
				}
				if("1".equals(zyygljg.getTbz())) {
					JSONObject json = new JSONObject();
					json.put("type", "9");//特秉质
					json.put("typeText", "特秉质");
					json.put("proposal", zyygljg.getTbzjy());
					list.add(json);
				}
				if (list.size() > 0) {
					JSONObject req = new JSONObject();
					req.put("list", list);
					String url = PropertiesUtil.getDict("hcplatformHost");
					String respStr = HttpUtil.doPost(url + "/guidance/getPhysicalByType", req.toJSONString());
					if (StringUtils.isNotBlank(respStr)) {
						List array = JSONArray.parseArray(respStr);
						zyygljg.setList(array);
					}
				}
			}
		}
		return info;
	}

	@Override
	public JsonResult getZyyglList(RequestDto request) throws Exception {
		List<ZyyglDto> list = lnrZyyglDao.getAll(request);
		if(list != null && list.size() > 0) {
			for(int i = 0; i < list.size(); i++) {
				ZyyglDto info = list.get(i);
				FollowLnrZyyglJg zyygljg = lnrZyygljgDao.getZyyglJgInfo(info.getId());
				if("1".equals(zyygljg.getPhz())) {
					info.setSfysName("平和质");
					info.setSfdf(zyygljg.getPhzdf());
				}else if("1".equals(zyygljg.getQxz())) {
					info.setSfysName("气虚质");
					info.setSfdf(zyygljg.getQxzdf());
				}else if("1".equals(zyygljg.getYxuz())) {
					info.setSfysName("阳虚质");
					info.setSfdf(zyygljg.getYxuzdf());
				}else if("1".equals(zyygljg.getYxzdf())) {
					info.setSfysName("阴虚质");
					info.setSfdf(zyygljg.getYxzdf());
				}else if("1".equals(zyygljg.getTsz())) {
					info.setSfysName("痰湿质");
					info.setSfdf(zyygljg.getTszpf());
				}else if("1".equals(zyygljg.getSrz())) {
					info.setSfysName("湿热质");
					info.setSfdf(zyygljg.getSrzpf());
				}else if("1".equals(zyygljg.getXyz())) {
					info.setSfysName("血瘀质");
					info.setSfdf(zyygljg.getXyzpf());
				}else if("1".equals(zyygljg.getQyz())) {
					info.setSfysName("气郁质");
					info.setSfdf(zyygljg.getQyzpf());
				}else if("1".equals(zyygljg.getTbz())) {
					info.setSfysName("特秉质");
					info.setSfdf(zyygljg.getTbzpf());
				}
			}
		}else {
			list = new ArrayList<>();
		}
		int count = lnrZyyglDao.getCount(request);
		PageModel res = new PageModel();
		res .setList(list);
		res.setCount(count);
		return new JsonResult(res);
	}

}
