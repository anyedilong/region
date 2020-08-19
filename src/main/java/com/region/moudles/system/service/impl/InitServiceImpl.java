package com.region.moudles.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.region.moudles.common.utils.cache.AreaCache;
import com.region.moudles.common.utils.cache.DictCache;
import com.region.moudles.common.utils.cache.MenuCache;
import com.region.moudles.common.utils.cache.OrgCache;
import com.region.moudles.common.utils.cache.UserCache;
import com.region.moudles.system.dao.InitDao;
import com.region.moudles.system.dao.SysDictDao;
import com.region.moudles.system.dao.SysDiseaseDao;
import com.region.moudles.system.dao.SysMenuDao;
import com.region.moudles.system.dao.SysOrgDao;
import com.region.moudles.system.dao.SysUserDao;
import com.region.moudles.system.dto.InitDictDto;
import com.region.moudles.system.dto.MedicantTypeDto;
import com.region.moudles.system.dto.SysDiseaseDto;
import com.region.moudles.system.service.InitService;
import com.region.until.StringUntil;
import com.region.until.cache.CacheEmun;
import com.region.until.cache.CacheUtils;
import com.region.until.http.HttpRequest;

@Named
@Transactional(readOnly = true)
public class InitServiceImpl implements InitService {
	
	@Value("${hisblturl}")
    private String hisblturl;
	
	//曲靖市的区划code
	//private static final String QUJING_AREACODE = "5303";
	@Value("${areaCode}")
	private String areaCode;

	@Inject
	private InitDao dao;
	@Inject
	private SysUserDao userDao;
	@Inject
	private SysMenuDao menuDao;
	@Inject
	private SysOrgDao orgDao;
	@Inject
	private SysDiseaseDao diseaseDao;
	@Inject
	private SysDictDao dictDao;
	
	public UserCache getUserInfo(String username) {

		UserCache user = userDao.getUserInfoByName(username);

		if (null != user) {
			// 获取 用户 所有菜单和操作
			List<MenuCache> userMenuAndHandleList = null;
			// 如果为admin 则为所有
			String superAdmin = "admin";
			if (superAdmin.equals(username)) {
				userMenuAndHandleList = menuDao.getAllMenuAndHandleList();
			} else {
				List<MenuCache> menuAndHandleList = menuDao.getAllMenuAndHandleList();
				// 获取用户授权信息
				List<String> userMenuIdArray = menuDao.getMenuByUser(user.getUserId());

				List<MenuCache> userMenuList = menuAndHandleList
						.stream().filter(
								menu -> userMenuIdArray.indexOf(menu.getId()) >=0)
						.collect(Collectors.toList());
				
				userMenuAndHandleList = menuAndHandleList.stream().filter(menu -> userMenuList.stream()
						.filter(menu1 -> menu.getId().equals(menu1.getParentId()) || menu.getId().equals(menu1.getId()))
						.count() > 0).collect(Collectors.toList());
			}
			List<MenuCache> menuNav = new ArrayList<>();// 菜单导航
			Map<String, MenuCache> menuMap = new HashMap<>();// 菜单map
			Map<String, List<MenuCache>> handleMap = new HashMap<>();

			if (null != userMenuAndHandleList && userMenuAndHandleList.size() > 0) {
				for (MenuCache menuCache : userMenuAndHandleList) {
					if (null != menuCache) {
						if ("2".equals(menuCache.getType())) {
							// 如果为操作
							List<MenuCache> handleList = handleMap.get(menuCache.getParentId());
							if (null == handleList) {
								handleList = new ArrayList<>();
								handleMap.put(menuCache.getParentId(), handleList);
							}
							handleList.add(menuCache);
						} else if("1".equals(menuCache.getType())) {
							menuNav.add(menuCache);
							menuMap.put(menuCache.getId(), menuCache);
						}
					}
				}
			}
			//用户管辖机构
			List<OrgCache> orgTree = orgDao.getMrgOrgInfos(user.getUserId());
			
			if(null != orgTree){
				List<String> mrgOrgList = orgTree.stream().map(OrgCache::getId).collect(Collectors.toList());
				user.setMrgOrgList(mrgOrgList);
			}
			OrgCache orgInfo = orgDao.getOrgInfoByUserId(user.getUserId());
			user.setOrg(orgInfo);
			user.setOrgId(orgInfo.getId());
			user.setOrgCode(orgInfo.getOrgCode());
			user.setOrgTree(orgTree);
			user.setMenuNav(menuNav);
			user.setMenuMap(menuMap);
			user.setHandleMap(handleMap);
		}
		return user;
	}
	
	@Override
	public void InitData() {
		
		//初始化医药数据
		InitMedicantType();
		//初始化字典缓存
		initDictCache();
		//初始化区划缓存
		initAreaCache();
		//初始化疾病
		initJb();
		//初始化公卫系统中字典信息
		initBltDictCache();
		 
	}
	/**
	 * @Description: 初始化医药数据
	 * @param 
	 * @return void
	 * @throws
	 */
	public void InitMedicantType() {
		Object cacheObj = CacheUtils.get(CacheEmun.SYS_CACHE, CacheUtils.MEDICANT_TYPE, Object.class);
		if (null != cacheObj) {
			return;
		}
		// 查询所有医药数据
		List<MedicantTypeDto> medicantList = dao.getAllMedicantList();

		CacheUtils.put(CacheEmun.SYS_CACHE, CacheUtils.MEDICANT_TYPE, medicantList);
	}
	public void initJb(){
              Object cacheObj=CacheUtils.get(CacheEmun.SYS_CACHE,CacheUtils.SYS_DISEASE,Object.class);
              if(cacheObj!=null){
                     return;
			  }
			  List<SysDiseaseDto> list=dao.getAllDisease();
              CacheUtils.put(CacheEmun.SYS_CACHE,CacheUtils.SYS_DISEASE,list);
	}

	/**
	 * @Description 初始化字典缓存
	 * @author sen
	 * @Date 2017年3月17日 下午4:38:44
	 */
	public List<DictCache> initDictCache() {
		List<DictCache> dictList = CacheUtils.getArray(CacheEmun.SYS_CACHE, CacheUtils.SYS_DICT, DictCache.class);
		//如果数据库为空，数据库查询
		if(null == dictList){
			dictList = dao.getDictCache();
			CacheUtils.put(CacheEmun.SYS_CACHE, CacheUtils.SYS_DICT, dictList);
		}
		
		return dictList;
	}
	
	/**
	 * @Description 初始化区划缓存
	 * @author sen
	 * @Date 2017年3月17日 下午4:38:44
	 */
	public List<AreaCache> initAreaCache() {
		List<AreaCache> areaList = CacheUtils.getArray(CacheEmun.SYS_CACHE, CacheUtils.SYS_AREA, AreaCache.class);
		//如果数据库为空，数据库查询
		if(null == areaList){
			//
			areaList = dao.getAreaCache(areaCode);
			CacheUtils.put(CacheEmun.SYS_CACHE, CacheUtils.SYS_AREA, areaList);
		}
		return areaList;
	}
	
	/**
	 * 
	 * @Description 初始化公卫字典列表
	 * @author sen
	 * @Date 2016年11月23日 下午8:41:46
	 */
	public void initBltDictCache() {
		try {
			Object cacheObj = CacheUtils.get(CacheEmun.SYS_CACHE, CacheUtils.DICT_ITEM, Map.class);
			if (null != cacheObj) {
				return;
			}

			//查询所有公卫字典信息
			Map<String, String> paramMap = new HashMap<>();
			String sendPost = HttpRequest.sendPost(hisblturl + "/region/hisRegion/queryBltDictList", paramMap);
			List<InitDictDto> dictList = JSON.parseArray(sendPost, InitDictDto.class);
			//查询疾病类型字典
			List<InitDictDto> diseaseList = diseaseDao.queryDiseaseList();
			if(diseaseList != null) {
				dictList.addAll(diseaseList);
			}
			//查询区域化字典信息
			List<InitDictDto> dictSubList = dictDao.queryDictList();
			if(dictSubList != null) {
				dictList.addAll(dictSubList);
			}
			
			Map<String, List<InitDictDto>> dictMapping = new HashMap<String, List<InitDictDto>>();
			for (InitDictDto dict : dictList) {
				String parentCode = StringUntil.toString(dict.getParentCode());

				List<InitDictDto> itemList;
				if (!dictMapping.containsKey(parentCode)) {
					itemList = new ArrayList<InitDictDto>();
					dictMapping.put(parentCode, itemList);
				} else {
					itemList = dictMapping.get(parentCode);
				}
				itemList.add(dict);
			}

			CacheUtils.put(CacheEmun.SYS_CACHE, CacheUtils.DICT_ITEM, dictMapping);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
