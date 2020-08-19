package com.region.moudles.common.utils.cache;

import java.io.Serializable;

/**
 * @ClassName: AreaCache
 * @Description: 区划缓存实体类
 * @author Administrator
 * @date 2019年7月11日
 */
public class AreaCache implements Serializable{

	private static final long serialVersionUID = 965246466L;
	
	private String id;
	private String areaName;
	private String areaCode;
	private String parentId;
	private String areaLevel;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
	
}
