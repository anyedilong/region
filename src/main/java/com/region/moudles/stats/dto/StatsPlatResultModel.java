package com.region.moudles.stats.dto;

import java.io.Serializable;

/**
 * @ClassName: StatsPlatResultModel
 * @Description: 存储平列表展示的model
 * @author Administrator
 * @date 2019年6月28日
 */
public class StatsPlatResultModel  implements Serializable{

	private static final long serialVersionUID = 645641646L;

	//组织机构名称
	private String orgId;
	private String orgName;
	private String orgCode;
	private Integer count;
	
	private String areaId;
	private String areaCode;
	//区划名称
	private String areaName;
	//处方项类型(收费明细表)
	private String itemType;
	//各类别 
	private String incomeType;
	
    private String startTime;
    private String endTime;
    private String year;
    private String month;
    private String itemGroupName;
    
    //收费类别（挂号和入院）1.挂号 2.入院 没有全查
    private String sflb;
    
    //queryDao解析不了；有问题
    private Integer pageSize;
    private Integer pageNo;

    public StatsPlatResultModel() {
    	
    }
    public StatsPlatResultModel(String startTime, String endTime, String orgId) {
    	this.startTime = startTime;
    	this.endTime = endTime;
    	this.orgId = orgId;
    }
    public StatsPlatResultModel(String startTime, String endTime, String orgId, String itemGroupName) {
    	this.startTime = startTime;
    	this.endTime = endTime;
    	this.orgId = orgId;
    	this.itemGroupName = itemGroupName;
    }
    
    
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getSflb() {
		return sflb;
	}

	public void setSflb(String sflb) {
		this.sflb = sflb;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public String getItemGroupName() {
		return itemGroupName;
	}
	public void setItemGroupName(String itemGroupName) {
		this.itemGroupName = itemGroupName;
	}

	
}
