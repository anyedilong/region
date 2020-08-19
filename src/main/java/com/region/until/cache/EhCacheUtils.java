package com.region.until.cache;



import com.region.config.spring.InstanceFactory;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 
 * @ClassName EhCacheUtils
 * @Description ehCache缓存工具
 * @author sen
 * @Date 2016年11月17日 下午1:49:46
 * @version 1.0.0
 */
public class EhCacheUtils {

	private static CacheManager cacheManager = ((CacheManager)InstanceFactory.getbean(CacheManager.class));
	
	/**
	 * 获取  缓存
	 * @param CacheType
	 * @param key
	 * @return
	 */
	public static Object get(EhCacheEmun CacheType,String key) {
		return get(CacheType.getValue(), key);
	}
	
	/**
	 * 写入缓存
	 * @param CacheType
	 * @param key
	 * @param value
	 */
	public synchronized static void put(EhCacheEmun CacheType,String key, Object value) {
		put(CacheType.getValue(), key, value);
	}
	
	/**
	 * 从缓存中移除
	 * @param CacheType
	 * @param key
	 */
	public static void remove(EhCacheEmun CacheType,String key) {
		remove(CacheType.getValue(), key);
	}
	
	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Object get(String cacheName, String key) {
		Element element = getCache(cacheName).get(key);
		return element==null?null:element.getObjectValue();
	}

	/**
	 * 写入缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public synchronized static void put(String cacheName, String key, Object value) {
		Element element = new Element(key, value);
		
		getCache(cacheName).put(element);
	}

	/**
	 * 从缓存中移除
	 * @param cacheName
	 * @param key
	 */
	public synchronized static void remove(String cacheName, String key) {
		getCache(cacheName).remove(key);
	}
	
	/**
	 * 获得一个Cache，没有则创建一个。
	 * @param cacheName
	 * @return
	 */
	private static Cache getCache(String cacheName){
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null){
			cacheManager.addCache(cacheName);
			cache = cacheManager.getCache(cacheName);
			cache.getCacheConfiguration().setEternal(true);
		}
		return cache;
	}
	public synchronized static void putLiveTime(String cacheName, String key, Object value,long liveTime) {
		Element element = new Element(key, value);
		
		element.setTimeToLive((int)liveTime);
		
		getCache(cacheName).put(element);
	}

	public static CacheManager getCacheManager() {
		return cacheManager;
	}
	
}

