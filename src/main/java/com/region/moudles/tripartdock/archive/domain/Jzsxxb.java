package com.region.moudles.tripartdock.archive.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;
import com.region.until.validate.Validate;

/**
 * 
 * @ClassName Jzsxxb
 * @Description 档案-家族史信息
 * @author sen
 * @Date 2017年2月7日 上午10:43:18
 * @version 1.0.0
 */
@Entity
@Table(name = "blt_jzsxxb")
public class Jzsxxb extends BaseDomain {

	private static final long serialVersionUID = 55941964169416L;
	
	@Id
	private String id;//
	private String dah;// 档案号
	@Validate(name = { "save" }, required = true)
	@Column(name="sfzh")
	private String sfzh;// 身份证证号
	private String jzs;// 家族史
	private String fqbs;// 父亲病史
	private String fqdqtbs;// 父亲的其他病史
	private String mqbs;// 母亲病史
	private String mqdqtbs;// 母亲的其他病史
	private String xdjmdbs;// 兄弟姐妹的病史
	private String xdjmdqtbs;// 兄弟姐妹的其他病史
	private String znbs;// 子女病史
	private String znqtbs;// 子女其他病史
	private String importDeviceNum;//导入设备编号
	@JSONField(format="yyyy-MM-dd")
	private Date importTime;//导入时间
	private String importUser;//导入人
	private String importIp;//导入IP
	private String jmid; //居民id
	
	@Transient
	private String fqbsText;
	@Transient
	private String mqbsText;
	@Transient
	private String xdjmdbsText;
	@Transient
	private String znbsText;
	
	public String getImportDeviceNum() {
		return importDeviceNum;
	}

	public void setImportDeviceNum(String importDeviceNum) {
		this.importDeviceNum = importDeviceNum;
	}

	public Date getImportTime() {
		return importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public String getImportUser() {
		return importUser;
	}

	public void setImportUser(String importUser) {
		this.importUser = importUser;
	}

	public String getImportIp() {
		return importIp;
	}

	public void setImportIp(String importIp) {
		this.importIp = importIp;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDah() {
		return this.dah;
	}

	public void setDah(String dah) {
		this.dah = dah;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getJzs() {
		return this.jzs;
	}

	public void setJzs(String jzs) {
		this.jzs = jzs;
	}

	public String getFqbs() {
		return this.fqbs;
	}

	public void setFqbs(String fqbs) {
		this.fqbsText = DictUtil.getDictValue("da-jzs-fq", fqbs);
		this.fqbs = fqbs;
	}

	public String getFqdqtbs() {
		return this.fqdqtbs;
	}

	public void setFqdqtbs(String fqdqtbs) {
		this.fqdqtbs = fqdqtbs;
	}

	public String getMqbs() {
		return this.mqbs;
	}

	public void setMqbs(String mqbs) {
		this.mqbsText = DictUtil.getDictValue("da-jzs-mq", mqbs);
		this.mqbs = mqbs;
	}

	public String getMqdqtbs() {
		return this.mqdqtbs;
	}

	public void setMqdqtbs(String mqdqtbs) {
		this.mqdqtbs = mqdqtbs;
	}

	public String getXdjmdbs() {
		return this.xdjmdbs;
	}

	public void setXdjmdbs(String xdjmdbs) {
		this.xdjmdbsText = DictUtil.getDictValue("da-jzs-xdjm", xdjmdbs);
		this.xdjmdbs = xdjmdbs;
	}

	public String getXdjmdqtbs() {
		return this.xdjmdqtbs;
	}

	public void setXdjmdqtbs(String xdjmdqtbs) {
		this.xdjmdqtbs = xdjmdqtbs;
	}

	public String getZnbs() {
		return this.znbs;
	}

	public void setZnbs(String znbs) {
		this.znbsText = DictUtil.getDictValue("da-jzs-zn", znbs);
		this.znbs = znbs;
	}

	public String getZnqtbs() {
		return this.znqtbs;
	}

	public void setZnqtbs(String znqtbs) {
		this.znqtbs = znqtbs;
	}

	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public String getFqbsText() {
		return fqbsText;
	}

	public void setFqbsText(String fqbsText) {
		this.fqbsText = DictUtil.getDictValue("da-jzs-fq", fqbs);
	}

	public String getMqbsText() {
		return mqbsText;
	}

	public void setMqbsText(String mqbsText) {
		this.mqbsText = DictUtil.getDictValue("da-jzs-mq", mqbs);
	}

	public String getXdjmdbsText() {
		return xdjmdbsText;
	}

	public void setXdjmdbsText(String xdjmdbsText) {
		this.xdjmdbsText = DictUtil.getDictValue("da-jzs-xdjm", xdjmdbs);
	}

	public String getZnbsText() {
		return znbsText;
	}

	public void setZnbsText(String znbsText) {
		this.znbsText = DictUtil.getDictValue("da-jzs-zn", znbs);
	}
}
