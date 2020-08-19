package com.region.until.cache;

public enum EhCacheEmun {
	
	SYS_CACHE("sysCache"),
	USER_CACHE("userCache");
	
	private String value;

	private EhCacheEmun(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}


}