package com.region.until.cache;

/**
 * 
 * @ClassName EhRedisCacheEmun
 * @Description eh与redis 枚举
 * @author sen
 * @Date 2016年11月17日 下午6:52:37
 * @version 1.0.0
 */
public enum CacheEmun {
	/* 系统缓存 */
	SYS_CACHE(EhCacheEmun.SYS_CACHE, RedisCacheEmun.SYS_CACHE),
	/* 用户缓存 */
	USER_CACHE(EhCacheEmun.USER_CACHE, RedisCacheEmun.USER_CACHE);
	
	private EhCacheEmun ehCacheEmun;
	private RedisCacheEmun redisCacheEmun;

	private CacheEmun(EhCacheEmun ehCacheEmun, RedisCacheEmun redisCacheEmun) {
		this.ehCacheEmun = ehCacheEmun;
		this.redisCacheEmun = redisCacheEmun;
	}

	public EhCacheEmun getEhCacheEmun() {
		return ehCacheEmun;
	}

	public RedisCacheEmun getRedisCacheEmun() {
		return redisCacheEmun;
	}

}