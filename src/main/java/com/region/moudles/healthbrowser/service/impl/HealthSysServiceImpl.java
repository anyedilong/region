package com.region.moudles.healthbrowser.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.healthbrowser.dto.FollowMenuDto;
import com.region.moudles.healthbrowser.service.HealthSysService;
import com.region.moudles.his.authcode.dao.repository.SysAuthRepository;
import com.region.moudles.system.dao.repository.SysUserHealthRepository;
import com.region.moudles.tripartdock.archive.dao.repository.JbxxjlbRepository;
import com.region.moudles.tripartdock.follow.dao.FollowEtXseDao;
import com.region.moudles.tripartdock.follow.dao.FollowEtZyygl1Dao;
import com.region.moudles.tripartdock.follow.dao.FollowEtZyygl3Dao;
import com.region.moudles.tripartdock.follow.dao.FollowEtZyygl6Dao;
import com.region.moudles.tripartdock.follow.dao.FollowEtsf1Dao;
import com.region.moudles.tripartdock.follow.dao.FollowEtsf3Dao;
import com.region.moudles.tripartdock.follow.dao.FollowEtsf6Dao;
import com.region.moudles.tripartdock.follow.dao.FollowFjhDao;
import com.region.moudles.tripartdock.follow.dao.FollowFjhrhDao;
import com.region.moudles.tripartdock.follow.dao.FollowGxbDao;
import com.region.moudles.tripartdock.follow.dao.FollowGxyDao;
import com.region.moudles.tripartdock.follow.dao.FollowJsbDao;
import com.region.moudles.tripartdock.follow.dao.FollowLnrDao;
import com.region.moudles.tripartdock.follow.dao.FollowLnrJkpgDao;
import com.region.moudles.tripartdock.follow.dao.FollowNczDao;
import com.region.moudles.tripartdock.follow.dao.FollowTnbDao;
import com.region.moudles.tripartdock.follow.dao.FollowYcfCh42Dao;
import com.region.moudles.tripartdock.follow.dao.FollowYcfChDao;
import com.region.moudles.tripartdock.follow.dao.FollowYcfCqDao;
import com.region.moudles.tripartdock.follow.dao.FollowYcfScDao;
import com.region.until.StringUntil;


@Named
public class HealthSysServiceImpl implements HealthSysService{

	@Autowired
	private SysAuthRepository sysAuthRepository;
	@Autowired
	private SysUserHealthRepository sysUserHealthRepository;
	
	@Override
	public String checkUserLegal(String orgId, String authCode, String doctorCode, String doctorName) throws Exception {
		
		//检查机构和授权码的合法性
		String id = sysAuthRepository.queryAuthByCond(authCode, orgId);
		//检查用户的合法性
		String role = sysUserHealthRepository.queryUserRoleByCond(doctorCode, doctorName);
		//验证成功后，返回登录者的角色；验证不成功，返回fail
		if(!StringUntil.isNull(id) && !StringUntil.isNull(role)) {
			return role;
		}else {
			return "fail";
		}
	}

	@Autowired
	private JbxxjlbRepository jbxxjlbRepository;
	@Autowired
	private FollowGxyDao gxyDao;
	@Autowired
	private FollowTnbDao tnbDao;
	@Autowired
	private FollowJsbDao jsbDao;
	@Autowired
	private FollowFjhrhDao fjhrhDao;
	@Autowired
	private FollowFjhDao fjhDao;
	@Autowired
	private FollowYcfScDao ycfScDao;
	@Autowired
	private FollowYcfCqDao ycfCqDao;
	@Autowired
	private FollowYcfChDao ycfChDao;
	@Autowired
	private FollowYcfCh42Dao ycfCh42Dao;
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
	@Autowired
	private FollowLnrJkpgDao lnrJkpgDao;
	@Autowired
	private FollowLnrDao lnrZyyglDao;
	@Autowired
	private FollowGxbDao gxbDao;
	@Autowired
	private FollowNczDao nczDao;
	
	@Override
	public List<FollowMenuDto> getfollowMenu(String sfzh) throws Exception {
		
		//暂存随访菜单的菜单的list
		List<FollowMenuDto> list = new ArrayList<>();
		//查询档案id
		String archiveId = jbxxjlbRepository.queryArchiveIdBySfzh(sfzh);
		
		//高血压
		int gxyNum = gxyDao.getSFCountByJmId(archiveId);
		if(gxyNum > 0) {
			list.add(new FollowMenuDto("/hypertension", "hypertension", "高血压"));
		}
		//糖尿病
		int tnbNum = tnbDao.getSFCountByJmId(archiveId);
		if(tnbNum > 0) {
			list.add(new FollowMenuDto("/diabetes", "diabetes", "糖尿病"));
		}
		//精神障碍
		int jsbNum = jsbDao.getSFCountByJmId(archiveId);
		if(jsbNum > 0) {
			list.add(new FollowMenuDto("/mentalDisease", "mentalDisease", "精神障碍"));
		}
		//肺结核首次
		int fjhrhNum = fjhrhDao.getSFCountByJmId(archiveId);
		if(fjhrhNum > 0) {
			list.add(new FollowMenuDto("/phthisisFirst", "phthisisFirst", "肺结核首次"));
		}
		//肺结核
		int fjhNum = fjhDao.getSFCountByJmId(archiveId);
		if(fjhNum > 0) {
			list.add(new FollowMenuDto("/phthisis", "phthisis", "肺结核"));
		}
		//孕产妇
		int ycfscNum = ycfScDao.getSFCountByJmId(archiveId);
		if(ycfscNum >0) {
			list.add(new FollowMenuDto("/maternal", "maternal", "孕产妇"));
		}else {
			int ycfcqNum = ycfCqDao.getSFCountByJmId(archiveId);
			if(ycfcqNum >0) {
				list.add(new FollowMenuDto("/maternal", "maternal", "孕产妇"));
			}else {
				int ycfchNum = ycfChDao.getSFCountByJmId(archiveId);
				if(ycfchNum > 0) {
					list.add(new FollowMenuDto("/maternal", "maternal", "孕产妇"));
				}else {
					int ycfch42 = ycfCh42Dao.getSFCountByJmId(archiveId);
					if(ycfch42 > 0) {
						list.add(new FollowMenuDto("/maternal", "maternal", "孕产妇"));
					}
				}
			}
		}
		//儿童
		int etxseNum = etXseDao.getSFCountByJmId(archiveId);
		if(etxseNum > 0) {
			list.add(new FollowMenuDto("/child", "child", "儿童"));
		}else {
			int etsf1Num = etsf1Dao.getSFCountByJmId(archiveId);
			if(etsf1Num > 0) {
				list.add(new FollowMenuDto("/child", "child", "儿童"));
			}else {
				int etsf3Num = etsf3Dao.getSFCountByJmId(archiveId);
				if(etsf3Num > 0) {
					list.add(new FollowMenuDto("/child", "child", "儿童"));
				}else {
					int etsf6Num = etsf6Dao.getSFCountByJmId(archiveId);
					if(etsf6Num > 0) {
						list.add(new FollowMenuDto("/child", "child", "儿童"));
					}else {
						int etzyygl1Num = etZyygl1Dao.getSFCountByJmId(archiveId);
						if(etzyygl1Num > 0) {
							list.add(new FollowMenuDto("/child", "child", "儿童"));
						}else {
							int etzyygl3Num = etZyygl3Dao.getSFCountByJmId(archiveId);
							if(etzyygl3Num > 0) {
								list.add(new FollowMenuDto("/child", "child", "儿童"));
							}else {
								int etzyygl6Num = etZyygl6Dao.getSFCountByJmId(archiveId);
								if(etzyygl6Num > 0) {
									list.add(new FollowMenuDto("/child", "child", "儿童"));
								}
							}
						}
					}
				}
			}
		}
		//老年人
		int lnrjkpgNum = lnrJkpgDao.getSFCountByJmId(archiveId);
		if(lnrjkpgNum > 0) {
			list.add(new FollowMenuDto("/oldPeople", "oldPeople", "老年人"));
		}else {
			int lnrzyygNum = lnrZyyglDao.getSFCountByJmId(archiveId);
			if(lnrzyygNum > 0) {
				list.add(new FollowMenuDto("/oldPeople", "oldPeople", "老年人"));
			}
		}
		//冠心病
		int gxbNum = gxbDao.getSFCountByJmId(archiveId);
		if(gxbNum > 0) {
			list.add(new FollowMenuDto("/coronaryHeartDisease", "coronaryHeartDisease", "冠心病"));
		}
		//脑卒中
		int nczNum = nczDao.getSFCountByJmId(archiveId);
		if(nczNum > 0) {
			list.add(new FollowMenuDto("/stroke", "stroke", "脑卒中"));
		}
		return list;
	}

    
}
