package com.region.until.cache;

import org.springframework.data.redis.core.RedisTemplate;

import com.region.config.spring.InstanceFactory;

public enum RedisCacheEmun {
	
	/* 系统缓存 */
	SYS_CACHE(InstanceFactory.getbean(RedisTemplate.class, "sysRedisTemplate")),
	/* 用户缓存 */
	USER_CACHE(InstanceFactory.getbean(RedisTemplate.class, "userRedisTemplate"), 60 * 60);

	private RedisTemplate<String, Object> redisTemplate;
	private long liveTime = 0;// 过期时间

	private RedisCacheEmun(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	private RedisCacheEmun(RedisTemplate<String, Object> redisTemplate, long liveTime) {
		this.redisTemplate = redisTemplate;
		this.liveTime = liveTime;
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public long getLiveTime() {
		return liveTime;
	}
}