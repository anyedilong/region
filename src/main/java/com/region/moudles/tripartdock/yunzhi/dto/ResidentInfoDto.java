package com.region.moudles.tripartdock.yunzhi.dto;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.until.DictUtil;

public class ResidentInfoDto implements Serializable {

	private static final long serialVersionUID = 56463131313L;
	
	private String id;
	private String hzmc;
	private String jlh;
	private String ys;
	private String xb;
	private String sfzh;
	@JSONField(format="yyyy-MM-dd")
	private Date csrq;
	private String nl;
	private String mz; //guoji
	private String sj; //手机
	private String regionId;
	private String hyqk; //婚姻状况
	private String whcd; //教育程度
	private String gz;  //职业
	private String gzdw; //工作单位
	private String jtzz;
	private String createUser;
	@JSONField(format="yyyy-MM-dd")
	private Date createTime;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHzmc() {
		return hzmc;
	}
	public void setHzmc(String hzmc) {
		this.hzmc = hzmc;
	}
	public String getJlh() {
		return jlh;
	}
	public void setJlh(String jlh) {
		this.jlh = jlh;
	}
	public String getYs() {
		return ys;
	}
	public void setYs(String ys) {
		this.ys = ys;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = "1".equals(xb) ? "男" : "女";
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public Date getCsrq() {
		return csrq;
	}
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}
	public String getNl() {
		return nl;
	}
	public void setNl(String nl) {
		this.nl = nl;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = DictUtil.getDictValue("da-mz", mz);
	}
	public String getSj() {
		return sj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getHyqk() {
		return hyqk;
	}
	public void setHyqk(String hyqk) {
		this.hyqk = DictUtil.getDictValue("da-hyzk", hyqk);
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = DictUtil.getDictValue("da-whcd", whcd);
	}
	public String getGz() {
		return gz;
	}
	public void setGz(String gz) {
		this.gz = DictUtil.getDictValue("da-zy", gz);
	}
	public String getGzdw() {
		return gzdw;
	}
	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}
	public String getJtzz() {
		return jtzz;
	}
	public void setJtzz(String jtzz) {
		this.jtzz = jtzz;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
