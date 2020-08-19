package com.region.until.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.RedisTemplate;

import com.region.config.spring.InstanceFactory;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;

/**
 * 
 * @ClassName EhRedisCacheUtils
 * @Description ehCache与redis联合二级缓存工具类
 * @author sen
 * @Date 2016年11月17日 下午1:50:08
 * @version 1.0.0
 */
public class CacheUtils {

	//药品缓存
	public static final String MEDICANT_TYPE = "blt_medicant_type";
	//字典缓存
	public static final String SYS_DICT = "sys_dict";
	//公卫字典
	public static final String DICT_ITEM = "dict_bltsys_code_item";
	//区划缓存
	public static final String SYS_AREA = "sys_area";
	// 用户缓存
	public static final String SYS_USER = "sys_user_cache";
	//疾病缓存
	public static  final  String SYS_DISEASE="sys_disease";
	// 验证数据是否同步缓存
	private static RedisTemplate dsRedisTemplate = InstanceFactory.getbean(RedisTemplate.class, "dsRedisTemplate");
	
	/**
	 * 
	 * @Description 获取缓存数据
	 * @param ehRedisCacheEmun
	 * @param key
	 * @return
	 * @author sen
	 * @Date 2016年11月17日 下午8:56:16
	 */
	public static <T> List<T> getArray(CacheEmun ehRedisCacheEmun, Object key, Class<T> clazz) {
		// delete(ehRedisCacheEmun, key);

		final String _key = StringUntil.toString(key);

		if (StringUntil.isNull(_key)) {
			return null;
		}

		// 1、验证 dsRedisTemplate缓存中，该数据是否存在，是否已经更新
		String dsFlag = StringUntil
				.toString(RedisCacheUtils.get(dsRedisTemplate, ehRedisCacheEmun.getRedisCacheEmun() + _key,
						String.class, ehRedisCacheEmun.getRedisCacheEmun().getLiveTime()));
		if (StringUntil.isNull(dsFlag)) {
			// 如果不存在，需要删除二级缓存数据
			EhCacheUtils.remove(ehRedisCacheEmun.getEhCacheEmun(), _key);
			return null;
		} else {
			// 获取 二级缓存数据
			Object ehObject = EhCacheUtils.get(ehRedisCacheEmun.getEhCacheEmun(), _key);

			// 验证 数据类型，如果不为map，则数据错误，需要重新在redis中获取
			if (null != ehObject && ehObject instanceof Map) {
				Map<Object, Object> map = (Map<Object, Object>) ehObject;

				if (map.containsKey(dsFlag)) {
					// 刷新redis 缓存 时效
					RedisCacheUtils.refreshLiveTime(ehRedisCacheEmun.getRedisCacheEmun(), dsFlag);
					List<T> value = (List<T>) map.get(dsFlag);
					if (null != value) {
						return value;
					}
				}

			}
		}

		// 获取一级缓存数据
		List<T> redisObject = RedisCacheUtils.getArray(ehRedisCacheEmun.getRedisCacheEmun(), _key, clazz);
		if (null != redisObject) {
			// 将数据放入ehcache缓存中
			Map<String, Object> ehMap = new HashMap<String, Object>();
			ehMap.put(dsFlag, redisObject);

			// 存入redis 中
			EhCacheUtils.put(ehRedisCacheEmun.getEhCacheEmun(), _key, ehMap);

			return redisObject;
		}

		return null;

	}
	
	/**
	 * 
	 * @Description 存储缓存数据
	 * @param ehRedisCacheEmun
	 * @param key
	 * @param value
	 * @author sen
	 * @Date 2016年11月17日 下午8:56:09
	 */
	public static void put(CacheEmun ehRedisCacheEmun, Object key, Object value) {

		final String _key = StringUntil.toString(key);

		if (StringUntil.isNull(_key) || value == null) {
			return;
		}

		String uuidKey = UUIDUtil.getUUID();
		// 放入验证同步缓存中
		RedisCacheUtils.put(dsRedisTemplate, ehRedisCacheEmun.getRedisCacheEmun() + _key, uuidKey,
				ehRedisCacheEmun.getRedisCacheEmun().getLiveTime());
		// 放入redis 缓存中
		RedisCacheUtils.put(ehRedisCacheEmun.getRedisCacheEmun(), _key, value);
		//RedisCacheUtils.get(ehRedisCacheEmun.getRedisCacheEmun(), key, Object.class);
		// 将数据放入ehcache缓存中
		Map<String, Object> ehMap = new HashMap<String, Object>();
		ehMap.put(uuidKey, value);
		// 放入eh 缓存中
		EhCacheUtils.put(ehRedisCacheEmun.getEhCacheEmun(), _key, ehMap);
		//EhCacheUtils.get(ehRedisCacheEmun.getEhCacheEmun(), _key);

	}

	public static void put(CacheEmun cacheEmun, Object key, Object value, long liveTime) {

		String _key = StringUntil.toString(key);
		if (StringUntil.isNull(_key) || value == null) {
			return;
		}
		// 放入eh 缓存中
		EhCacheUtils.putLiveTime(cacheEmun.getEhCacheEmun().getValue(), _key, value, liveTime);

	}
	
	/**
	 * 
	 * @Description 获取缓存数据
	 * @param ehRedisCacheEmun
	 * @param key
	 * @return
	 * @author sen
	 * @Date 2016年11月17日 下午8:56:16
	 */
	public static <T> T get(CacheEmun ehRedisCacheEmun, Object key, Class<T> clazz) {

		final String _key = StringUntil.toString(key);
		if (StringUntil.isNull(_key)) {
			return null;
		}
		// 1、验证 dsRedisTemplate缓存中，该数据是否存在，是否已经更新
		String dsFlag = StringUntil
				.toString(RedisCacheUtils.get(dsRedisTemplate, ehRedisCacheEmun.getRedisCacheEmun() + _key,
						String.class, ehRedisCacheEmun.getRedisCacheEmun().getLiveTime()));
		if (StringUntil.isNull(dsFlag)) {
			// 如果不存在，需要删除一级缓存数据
			EhCacheUtils.remove(ehRedisCacheEmun.getEhCacheEmun(), _key);
			return null;
		} else {
			// 获取 一级缓存数据
			Object ehObject = EhCacheUtils.get(ehRedisCacheEmun.getEhCacheEmun(), _key);
			// 验证 数据类型，如果不为map，则数据错误，需要重新在redis中获取
			if (null != ehObject && ehObject instanceof Map) {
				Map<Object, Object> map = (Map<Object, Object>) ehObject;
				if (map.containsKey(dsFlag)) {
					// 刷新redis 缓存 时效
					RedisCacheUtils.refreshLiveTime(ehRedisCacheEmun.getRedisCacheEmun(), dsFlag);
					Object value = map.get(dsFlag);
					if (null != value) {
						return (T) value;
					}
				}

			}
		}
		// 获取二级缓存数据
		Object redisObject = RedisCacheUtils.get(ehRedisCacheEmun.getRedisCacheEmun(), _key, clazz);
		if (null != redisObject) {
			// 将数据放入ehcache缓存中
			Map<String, Object> ehMap = new HashMap<String, Object>();
			ehMap.put(dsFlag, redisObject);
			// 存入一级缓存 中
			EhCacheUtils.put(ehRedisCacheEmun.getEhCacheEmun(), _key, ehMap);
			return (T) redisObject;
		}
		return null;

	}

	/**
	 * 
	 * @Description 删除缓存数据
	 * @param ehRedisCacheEmun
	 * @param key
	 * @author sen
	 * @Date 2016年11月17日 下午9:07:45
	 */
	public static void delete(CacheEmun ehRedisCacheEmun, Object key) {
		final String _key = StringUntil.toString(key);

		if (StringUntil.isNull(_key)) {
			return;
		}
		// 删除验证同步缓存
		RedisCacheUtils.delete(dsRedisTemplate, ehRedisCacheEmun.getRedisCacheEmun() + _key);
		// 删除redis 缓存
		RedisCacheUtils.delete(ehRedisCacheEmun.getRedisCacheEmun(), _key);
		// 删除eh 缓存
		EhCacheUtils.remove(ehRedisCacheEmun.getEhCacheEmun(), _key);

	}

	
}
