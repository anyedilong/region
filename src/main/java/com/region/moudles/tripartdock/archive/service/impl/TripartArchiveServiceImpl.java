package com.region.moudles.tripartdock.archive.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.tripartdock.health.bean.BaseCustomerDomain;
import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.archive.dao.BsxxDao;
import com.region.moudles.tripartdock.archive.dao.JbxxjlbDao;
import com.region.moudles.tripartdock.archive.dao.JzsxxbDao;
import com.region.moudles.tripartdock.archive.dao.ShhjbDao;
import com.region.moudles.tripartdock.archive.domain.Bsxx;
import com.region.moudles.tripartdock.archive.domain.Jbxxjlb;
import com.region.moudles.tripartdock.archive.domain.Jzsxxb;
import com.region.moudles.tripartdock.archive.domain.Shhjb;
import com.region.moudles.tripartdock.archive.dto.ArchiveFamilyInfo;
import com.region.moudles.tripartdock.archive.dto.ArchiveQueryCon;
import com.region.moudles.tripartdock.archive.service.TripartArchiveService;
import com.region.moudles.tripartdock.follow.dao.FollowEtXseDao;
import com.region.moudles.tripartdock.follow.domain.FollowEtXse;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartArchiveServiceImpl
 * @Description: 三方对接 保存档案信息
 * @author Administrator
 * @date 2019年7月25日
 */
@Named
public class TripartArchiveServiceImpl implements TripartArchiveService {

	@Autowired
	private JbxxjlbDao jbxxjlbDao;
	@Autowired
	private BsxxDao bsxxDao;
	@Autowired
	private JzsxxbDao jzsxxbDao;
	@Autowired
	private ShhjbDao shhjbDao;
	@Autowired
	private FollowEtXseDao xseDao;
	
	
	@Override
	public Map<String, Object> saveArchiveInfo(List<Jbxxjlb> list) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String archiveId = "";
		try {
			for (Jbxxjlb info : list) {
				//暂存档案id
				archiveId = info.getId();
				//档案-病史信息
				List<Bsxx> bsxxList = info.getBsxx();
				if(bsxxList != null && bsxxList.size() > 0) {
					bsxxDao.save(bsxxList);
				}
				//档案-家族史信息
				Jzsxxb jzsxx = info.getJzsxx();
				if(jzsxx != null) {
					jzsxx.setId(UUIDUtil.getUUID());
					jzsxxbDao.save(jzsxx);
				}
				//档案-生活环境
				Shhjb shhjb = info.getShhjb();
				if(shhjb != null) {
					shhjb.setId(UUIDUtil.getUUID());
					shhjbDao.save(shhjb);
				}
				info.setId(UUIDUtil.getUUID());
				jbxxjlbDao.save(info);
			}
		}catch(Exception e) {
			e.printStackTrace();
			map.put(archiveId, e.getMessage());
		}
		return map;
	}


	@Override
	public void getArchivePage(Jbxxjlb jbxxjlb, PageModel page) {
		jbxxjlbDao.getArchivePage(jbxxjlb, page);
	}

	@Override
	public void getArchivePageByCon(ArchiveQueryCon info, PageModel page) {
		jbxxjlbDao.getArchivePageByCon(info, page);
	}

	@Override
	public Jbxxjlb queryArchiveDetail(String archiveId, String sfzh) throws Exception {
		Jbxxjlb jbxxjlb = jbxxjlbDao.queryArchiveDetail(archiveId, sfzh);
		if(jbxxjlb == null) return null;
		ArchiveFamilyInfo family = jbxxjlbDao.queryFamilyInfo(jbxxjlb.getSfzh());
		if(family != null) {
			jbxxjlb.setHzxm(family.getHzxm());
			jbxxjlb.setHzsfzh(family.getHzsfzh());
			jbxxjlb.setJtrks(family.getFamilyCount());
			jbxxjlb.setJzqk(family.getLiveCondite());
		}
		List<FollowEtXse> xse = xseDao.getInfoByJmid(jbxxjlb.getId());
		if(xse != null && xse.size() > 0) {
			jbxxjlb.setXse(xse.get(0));
		}
		return jbxxjlb;
	}
	
	@Override
	public Jbxxjlb queryArchiveDetailByCon(String hzmc, String zjlx, String sfzh) throws Exception {
		Jbxxjlb jbxxjlb = jbxxjlbDao.queryArchiveDetailByCon(hzmc, zjlx, sfzh);
		if(jbxxjlb == null) return null;
		ArchiveFamilyInfo family = jbxxjlbDao.queryFamilyInfo(jbxxjlb.getSfzh());
		if(family != null) {
			jbxxjlb.setHzxm(family.getHzxm());
			jbxxjlb.setHzsfzh(family.getHzsfzh());
			jbxxjlb.setJtrks(family.getFamilyCount());
			jbxxjlb.setJzqk(family.getLiveCondite());
		}
		List<FollowEtXse> xse = xseDao.getInfoByJmid(jbxxjlb.getId());
		if(xse != null && xse.size() > 0) {
			jbxxjlb.setXse(xse.get(0));
		}
		return jbxxjlb;
	}


	@Override
	public List<Bsxx> queryBSxxDetail(String jmId) throws Exception {
		List<Bsxx> list = bsxxDao.queryBSxxDetail(jmId);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}


	@Override
	public Jzsxxb queryJZSxxDetail(String jmId) throws Exception {
		return jzsxxbDao.queryJZSxxDetail(jmId);
	}


	@Override
	public Shhjb querySHhjDetail(String jmId) throws Exception {
		return shhjbDao.querySHhjDetail(jmId);
	}

	//查询档案基本信息
	@Override
	public BaseCustomerDomain getInfoBySfzh(String sfzh) {
		return jbxxjlbDao.getInfoBySfzh(sfzh);
	}

}

