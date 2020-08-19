package com.region.moudles.tripartdock.archive.dto;


import java.io.Serializable;

/**
 * 
 * @ClassName ArchiveQueryCon
 * @Description 档案-查询条件
 * @author sen
 * @Date 2019年11月21日 上午10:43:33
 * @version 1.0.0
 */
public class ArchiveQueryCon implements Serializable {

	private static final long serialVersionUID = 64641226L;
	
	private String startTime;//病历开始时间
	private String endTime; //病历结束时间
	
	private String isMedical; //门诊病历（1.是）
	private String isOutCost; //门诊结算（1.是）
	private String isOutRx; //门诊处方（1.是）
	private String isOutImage; //门诊检查（1.是）
	private String isOutJcz; //门诊检验（1.是）
	private String isOutZd; //门诊诊断（1.是）
	
	private String isHospital; //住院病历（1.是）
	private String isHosImage; //住院检查（1.是）
	private String isHosJcz; //住院检验（1.是）
	private String isHosOutCost; //出院结算（1.是）
	private String isHosZd; //住院诊断（1.是）
	private String isHosEmr; //住院病历首页（1.是）
	private String pageSize;
	private String pageNo;
	
	
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
	public String getIsMedical() {
		return isMedical;
	}
	public void setIsMedical(String isMedical) {
		this.isMedical = isMedical;
	}
	public String getIsOutCost() {
		return isOutCost;
	}
	public void setIsOutCost(String isOutCost) {
		this.isOutCost = isOutCost;
	}
	public String getIsOutRx() {
		return isOutRx;
	}
	public void setIsOutRx(String isOutRx) {
		this.isOutRx = isOutRx;
	}
	public String getIsOutImage() {
		return isOutImage;
	}
	public void setIsOutImage(String isOutImage) {
		this.isOutImage = isOutImage;
	}
	public String getIsOutJcz() {
		return isOutJcz;
	}
	public void setIsOutJcz(String isOutJcz) {
		this.isOutJcz = isOutJcz;
	}
	public String getIsOutZd() {
		return isOutZd;
	}
	public void setIsOutZd(String isOutZd) {
		this.isOutZd = isOutZd;
	}
	public String getIsHospital() {
		return isHospital;
	}
	public void setIsHospital(String isHospital) {
		this.isHospital = isHospital;
	}
	public String getIsHosImage() {
		return isHosImage;
	}
	public void setIsHosImage(String isHosImage) {
		this.isHosImage = isHosImage;
	}
	public String getIsHosJcz() {
		return isHosJcz;
	}
	public void setIsHosJcz(String isHosJcz) {
		this.isHosJcz = isHosJcz;
	}
	public String getIsHosOutCost() {
		return isHosOutCost;
	}
	public void setIsHosOutCost(String isHosOutCost) {
		this.isHosOutCost = isHosOutCost;
	}
	public String getIsHosZd() {
		return isHosZd;
	}
	public void setIsHosZd(String isHosZd) {
		this.isHosZd = isHosZd;
	}
	public String getIsHosEmr() {
		return isHosEmr;
	}
	public void setIsHosEmr(String isHosEmr) {
		this.isHosEmr = isHosEmr;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
}
