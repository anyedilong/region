package com.region.until.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;
import com.region.until.StringUntil;
import com.region.until.json.JsonUtil;

/**
 * 
 * @ClassName RedisCacheUtils
 * @Description redisCache工具类
 * @author sen
 * @Date 2016年11月17日 下午1:23:35
 * @version 1.0.0
 */
public class RedisCacheUtils {

	/**
	 * 
	 * @Description redis存储数据
	 * @param redisCacheEmun
	 * @param key
	 * @param value
	 * @author sen
	 * @Date 2016年11月17日 下午1:39:44
	 */
	public static void put(RedisCacheEmun redisCacheEmun, Object key, Object value) {
		put(redisCacheEmun.getRedisTemplate(), key, value, redisCacheEmun.getLiveTime());
	}

	/**
	 * 
	 * @Description 获取redis缓存
	 * @param redisCacheEmun
	 * @param key
	 * @return
	 * @author sen
	 * @Date 2016年11月17日 下午1:42:00
	 */
	public static <T> T get(RedisCacheEmun redisCacheEmun, Object key, Class<T> clazz) {
		return get(redisCacheEmun.getRedisTemplate(), key, clazz, redisCacheEmun.getLiveTime());
	}

	/**
	 * @Description 获取redis缓存 集合
	 * @param redisCacheEmun
	 * @param key
	 * @param clazz
	 * @return
	 * @author sen
	 * @Date 2017年1月17日 下午1:33:30
	 */
	public static <T> List<T> getArray(RedisCacheEmun redisCacheEmun, Object key, Class<T> clazz) {
		return getArray(redisCacheEmun.getRedisTemplate(), key, clazz, redisCacheEmun.getLiveTime());
	}

	/**
	 * 
	 * @Description 删除缓存
	 * @param redisCacheEmun
	 * @param key
	 * @author sen
	 * @Date 2016年11月17日 下午1:42:29
	 */
	public static void delete(RedisCacheEmun redisCacheEmun, Object key) {
		delete(redisCacheEmun.getRedisTemplate(), key);
	}

	/**
	 * 
	 * @Description 存入值
	 * @param key
	 * @param value
	 * @author sen
	 * @Date 2016年11月17日 上午9:27:49
	 */
	public static void put(RedisTemplate<String, Object> redisTemplate, Object key, Object value) {
		put(redisTemplate, key, value, 0);
	}

	/**
	 * 加入失效时间
	 */
	public static void put(RedisTemplate<String, Object> redisTemplate, Object key, Object value, long liveTime) {

		if (null == value) {
			return;
		}
		if (value instanceof String) {
			if (StringUntil.isNull(value.toString())) {
				return;
			}
		}

		final String keyf = StringUntil.toString(key);
		if (StringUntil.isNull(keyf)) {
			return;
		}
		final Object valuef = value;
		final long liveTimef = liveTime;
		redisTemplate.execute(new RedisCallback<Long>() {
			
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					connection.multi();
					byte[] keyb = keyf.getBytes();
	
					// 将数据转为json
					String json = JSON.toJSONString(valuef, JsonUtil.getSerializeconfigcamelcase());
	
					byte[] valueb = StringUntil.getBytes(json);
					connection.set(keyb, valueb);
					if (liveTimef > 0) {
						connection.expire(keyb, liveTimef);
					}
					connection.exec();
				}catch(Exception e) {
					e.printStackTrace();
					connection.discard();
				}
				return 1L;
			}
		});
	}

	/**
	 * 
	 * @Description 获取值
	 * @param key
	 * @return
	 * @author sen
	 * @Date 2016年11月17日 上午9:28:26
	 */
	public static <T> T get(RedisTemplate<String, Object> redisTemplate, Object key, Class<T> clazz) {

		return get(redisTemplate, key, clazz, 0);
	}

	public static <T> T get(RedisTemplate<String, Object> redisTemplate, Object key, final Class<T> clazz,
			long liveTime) {
		final String keyf = StringUntil.toString(key);
		System.out.println(keyf + "剩余失效" + redisTemplate.getExpire(key.toString()));
		final long liveTimef = liveTime;
		if (StringUntil.isNull(keyf)) {
			return null;
		}
		
		Object object;
		object = redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] keyb = keyf.getBytes();
				byte[] value = connection.get(keyb);

				if (liveTimef > 0) {
					connection.expire(keyb, liveTimef);
				}
				if (value == null) {
					return null;
				}
				String json = StringUntil.toString(value);
				// 将json----》object
				Object obj = null;
				try {
					obj = JSON.parseObject(json, clazz, JsonUtil.getParserconfigcamelcase());
				} catch (Exception e) {
					e.printStackTrace();
				}
				return obj;
			}

		});

		return (T) object;
	}

	public static <T> List<T> getArray(RedisTemplate<String, Object> redisTemplate, Object key, final Class<T> clazz,
			long liveTime) {
		final String keyf = StringUntil.toString(key);
		System.out.println(keyf + "剩余失效" + redisTemplate.getExpire(key.toString()));
		final long liveTimef = liveTime;
		if (StringUntil.isNull(keyf)) {
			return null;
		}

		Object object;
		object = redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				try {	
					connection.multi();
					byte[] keyb = keyf.getBytes();
					byte[] value = connection.get(keyb);
	
					if (liveTimef > 0) {
						connection.expire(keyb, liveTimef);
					}
					if (value == null) {
						return null;
					}
					String json = StringUntil.toString(value);
					// 将json----》object
					List<T> objArray = null;
				
					objArray = JSON.parseArray(json, clazz);
					connection.exec();
					return objArray;
				} catch (Exception e) {
					//e.printStackTrace();
					connection.discard();
				}
				return null;
			}

		});

		return (List<T>) object;
	}

	public static void refreshLiveTime(RedisCacheEmun redisCacheEmun, Object key) {
		System.out.println(redisCacheEmun + "重置失效时间:" + StringUntil.toString(key) + ":剩余失效"
				+ redisCacheEmun.getRedisTemplate().getExpire(key.toString()));
		refreshLiveTime(redisCacheEmun.getRedisTemplate(), key, redisCacheEmun.getLiveTime());
	}

	private static void refreshLiveTime(RedisTemplate<String, Object> redisTemplate, Object key, long liveTime) {
		if (liveTime > 0) {
			final String keyf = StringUntil.toString(key);
			if (StringUntil.isNull(keyf)) {
				redisTemplate.expire(keyf, liveTime, TimeUnit.SECONDS);
			}
		}
	}

	/**
	 * 
	 * @Description 删除缓存
	 * @param key
	 * @author sen
	 * @Date 2016年11月17日 上午9:30:02
	 */
	public static void delete(RedisTemplate<String, Object> redisTemplate, Object key) {
		final String keyf = StringUntil.toString(key);
		if (StringUntil.isNull(keyf)) {
			return;
		}
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					connection.multi();
					byte[] keyb = keyf.getBytes();
					connection.del(keyb);
					connection.exec();
				}catch(Exception e) {
					connection.discard();
				}
				return null;
			}
		});
	}
	
}
