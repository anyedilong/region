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
 * @ClassName Bsxx
 * @Description 档案-病史信息
 * @author sen
 * @Date 2017年2月7日 上午10:42:57
 * @version 1.0.0
 */
@Entity
@Table(name = "blt_bsxx")
public class Bsxx extends BaseDomain {

	private static final long serialVersionUID = 46646848694L;
	
	@Id
	private String id;//
	private String dah;// 档案号
	@Validate(name = { "save" }, required = true)
	@Column(name="sfzh")
	private String sfzh;// 身份证号
	private String jblx;// 疾病类型1疾病,2手术,3外伤,4输血
	private String jbmc;// 疾病名称
	private String exzl;// 恶性肿瘤
	private String qtjbs;// 其他疾病史
	private String zybs;// 职业病史
	private String qtjbmc;// 其他疾病名称
	@JSONField(format="yyyy-MM-dd")
	private Date qzsj;// 确诊时间
	private String importDeviceNum;//导入设备编号
	@JSONField(format="yyyy-MM-dd")
	private Date importTime;//导入时间
	private String importUser;//导入人
	private String importIp;//导入IP
	private String jmid; //居民id

	@Transient
	private String jblxText;
	
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

	public String getJblx() {
		return this.jblx;
	}

	public void setJblx(String jblx) {
		this.jblx = jblx;
	}

	public String getJbmc() {
		return this.jbmc;
	}

	public void setJbmc(String jbmc) {
		if("1".equals(jblx)) {
			this.jblxText = DictUtil.getDictValue("da-jws-jb", jbmc);
		}else {
			this.jblxText = jbmc;
		}
		this.jbmc = jbmc;
	}

	public String getExzl() {
		return this.exzl;
	}

	public void setExzl(String exzl) {
		this.exzl = exzl;
	}

	public String getQtjbs() {
		return this.qtjbs;
	}

	public void setQtjbs(String qtjbs) {
		this.qtjbs = qtjbs;
	}

	public String getZybs() {
		return this.zybs;
	}

	public void setZybs(String zybs) {
		this.zybs = zybs;
	}

	public String getQtjbmc() {
		return this.qtjbmc;
	}

	public void setQtjbmc(String qtjbmc) {
		this.qtjbmc = qtjbmc;
	}

	public Date getQzsj() {
		return this.qzsj;
	}

	public void setQzsj(Date qzsj) {
		this.qzsj = qzsj;
	}

	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public String getJblxText() {
		return jblxText;
	}

	public void setJblxText(String jblxText) {
		this.jblxText = DictUtil.getDictValue("da-jws-jb", jblx);
	}

}
