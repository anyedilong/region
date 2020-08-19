package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: FollowGxyJb
 * @Description: 高血压基本信息
 * @author Administrator
 * @date 2019年7月31日
 */
@Entity
@Table(name = "blt_mxgxyjbxxb")
public class FollowGxyJb extends BaseDomain {

	private static final long serialVersionUID = 15494949419L;
	
	@Id
	private String id;//
	private String jmid;//居民id
	private String hzbh;// 患者编号
	private String sfsyjyy;// 是否使用降压药
	private String dah;// 档案号
	private String sfzh;// 身份证号
	private String glzb;// 管理组别
	private String blly;// 病例来源
	private String zzgldly;// 终止管理的理由
	private String jzs;// 家族史
	private String mqzk;// 目前症状
	@Column(length = 1)
	private String gxybfz;// 高血压并发症
	private String dxy;// 低血压
	private String sfzzgl;// 终止管理
	private Date zzglsj;// 终止管理时间
	@Column(name="jbjg")
	private String jbjg;// 建表机构
	private String dqjg;// 当前机构
	@Column(name="jbr")
	private String jbr;// 建表人
	private Date jbrq;// 建表日期
	private String sycxgr;// 上一次修改人
	private Date scxgsj;// 上一次修改时间
	private String sfsc;// 是否删除

	@Column(updatable = false)
	private String dataSource;// 数据来源 1平台 2平板 3手机
	@Column(updatable = false)
	private String dataSourceNo;// 数据来源唯一标志
	@Column(updatable = false)
	private String importDeviceNum;// 导入设备号
	@Column(updatable = false)
	private Date importTime;// 导入时间
	@Column(updatable = false)
	private String importUser;// 导入人
	@Column(updatable = false)
	private String importIp;// 导入IP
	private String synFlg = "0";// 是否同步 0 否 1 是
	@Column(updatable = false)
	private String synId;// 同步ID
	@Column(updatable = false)
	private Date synTime;// 同步时间

	private String updateFlg;// 同步修改标示

	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHzbh() {
		return this.hzbh;
	}

	public void setHzbh(String hzbh) {
		this.hzbh = hzbh;
	}

	public String getSfsyjyy() {
		return this.sfsyjyy;
	}

	public void setSfsyjyy(String sfsyjyy) {
		this.sfsyjyy = sfsyjyy;
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

	public String getGlzb() {
		return this.glzb;
	}

	public void setGlzb(String glzb) {
		this.glzb = glzb;
	}

	public String getBlly() {
		return this.blly;
	}

	public void setBlly(String blly) {
		this.blly = blly;
	}

	public String getZzgldly() {
		return this.zzgldly;
	}

	public void setZzgldly(String zzgldly) {
		this.zzgldly = zzgldly;
	}

	public String getJzs() {
		return this.jzs;
	}

	public void setJzs(String jzs) {
		this.jzs = jzs;
	}

	public String getMqzk() {
		return this.mqzk;
	}

	public void setMqzk(String mqzk) {
		this.mqzk = mqzk;
	}

	public String getGxybfz() {
		return this.gxybfz;
	}

	public void setGxybfz(String gxybfz) {
		this.gxybfz = gxybfz;
	}

	public String getDxy() {
		return this.dxy;
	}

	public void setDxy(String dxy) {
		this.dxy = dxy;
	}

	public String getSfzzgl() {
		return this.sfzzgl;
	}

	public void setSfzzgl(String sfzzgl) {
		this.sfzzgl = sfzzgl;
	}

	public Date getZzglsj() {
		return this.zzglsj;
	}

	public void setZzglsj(Date zzglsj) {
		this.zzglsj = zzglsj;
	}

	public String getJbjg() {
		return this.jbjg;
	}

	public void setJbjg(String jbjg) {
		this.jbjg = jbjg;
	}

	public String getDqjg() {
		return this.dqjg;
	}

	public void setDqjg(String dqjg) {
		this.dqjg = dqjg;
	}

	public String getJbr() {
		return this.jbr;
	}

	public void setJbr(String jbr) {
		this.jbr = jbr;
	}

	public Date getJbrq() {
		return this.jbrq;
	}

	public void setJbrq(Date jbrq) {
		this.jbrq = jbrq;
	}

	public String getSycxgr() {
		return this.sycxgr;
	}

	public void setSycxgr(String sycxgr) {
		this.sycxgr = sycxgr;
	}

	public Date getScxgsj() {
		return this.scxgsj;
	}

	public void setScxgsj(Date scxgsj) {
		this.scxgsj = scxgsj;
	}

	public String getSfsc() {
		return this.sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}

	public String getImportDeviceNum() {
		return this.importDeviceNum;
	}

	public void setImportDeviceNum(String importDeviceNum) {
		this.importDeviceNum = importDeviceNum;
	}

	public Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public String getImportUser() {
		return this.importUser;
	}

	public void setImportUser(String importUser) {
		this.importUser = importUser;
	}

	public String getImportIp() {
		return this.importIp;
	}

	public void setImportIp(String importIp) {
		this.importIp = importIp;
	}

	public String getSynFlg() {
		return this.synFlg;
	}

	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getDataSourceNo() {
		return dataSourceNo;
	}

	public void setDataSourceNo(String dataSourceNo) {
		this.dataSourceNo = dataSourceNo;
	}

	public String getSynId() {
		return synId;
	}

	public void setSynId(String synId) {
		this.synId = synId;
	}

	public Date getSynTime() {
		return synTime;
	}

	public void setSynTime(Date synTime) {
		this.synTime = synTime;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

}
