package com.region.moudles.system.service;

import java.util.List;

import com.region.moudles.common.utils.cache.DictCache;
import com.region.moudles.common.utils.cache.UserCache;


public interface InitService {

	/**
	 * @Description 初始化字典
	 * @author sen
	 * @Date 2016年11月23日 下午8:39:48
	 */
	public void InitData();

	/**
	 * @Description 初始化字典缓存
	 * @author sen
	 * @Date 2017年3月17日 下午4:38:44
	 */
	public List<DictCache> initDictCache();
	
	UserCache getUserInfo(String username);

	/**
	 * 
	 * @Description 初始化公卫字典列表
	 * @author sen
	 * @Date 2016年11月23日 下午8:41:46
	 */
	public void initBltDictCache();
}
