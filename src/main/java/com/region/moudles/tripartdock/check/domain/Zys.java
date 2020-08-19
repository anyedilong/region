package com.region.moudles.tripartdock.check.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: Zys
 * @Description: 体检-住院史 
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_zys")
public class Zys extends BaseDomain {

	private static final long serialVersionUID = 14763255466L;
	
	@Id
	private String id;//
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	@JSONField(format="yyyy-MM-dd")
	private Date zysj;// 住院时间
	private String zyyy;// 住院原因
	private String fbcs;// 病案号
	private String yymc;// 医院名称
	@JSONField(format="yyyy-MM-dd")
	private Date cyrq;// 出院日期
	private String importDeviceNum; //导入设备编号
	private Date ImportTime; //导入时间
	private String ImportUser; //导入人
	private String ImportIp; //导入Ip
	private String tjid;

	public String getImportDeviceNum() {
		return importDeviceNum;
	}

	public void setImportDeviceNum(String importDeviceNum) {
		this.importDeviceNum = importDeviceNum;
	}

	public Date getImportTime() {
		return ImportTime;
	}

	public void setImportTime(Date importTime) {
		ImportTime = importTime;
	}

	public String getImportUser() {
		return ImportUser;
	}

	public void setImportUser(String importUser) {
		ImportUser = importUser;
	}

	public String getImportIp() {
		return ImportIp;
	}

	public void setImportIp(String importIp) {
		ImportIp = importIp;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTjbh() {
		return this.tjbh;
	}

	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public Date getZysj() {
		return this.zysj;
	}

	public void setZysj(Date zysj) {
		this.zysj = zysj;
	}

	public String getZyyy() {
		return this.zyyy;
	}

	public void setZyyy(String zyyy) {
		this.zyyy = zyyy;
	}

	public String getFbcs() {
		return this.fbcs;
	}

	public void setFbcs(String fbcs) {
		this.fbcs = fbcs;
	}

	public String getYymc() {
		return this.yymc;
	}

	public void setYymc(String yymc) {
		this.yymc = yymc;
	}

	public Date getCyrq() {
		return this.cyrq;
	}

	public void setCyrq(Date cyrq) {
		this.cyrq = cyrq;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}

}
