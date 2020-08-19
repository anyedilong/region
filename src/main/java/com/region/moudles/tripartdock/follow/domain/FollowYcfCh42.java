package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;
import com.region.until.validate.Validate;

/**
 * @ClassName: FollowYcfCh42
 * @Description: 随访-孕产妇-产后访视42天
 * @author Administrator
 * @date 2019年8月2日
 */
@Entity
@Table(name = "blt_ycfch42txxb")
public class FollowYcfCh42 extends BaseDomain {

	private static final long serialVersionUID = 7562623131L;
	
	@Id
	private String id;//ID
	private String jmid;//居民id
	@Validate(name = { "save" }, required = true)
	@Column(name = "tjbh", updatable = false)
	private String tjbh;// 体检编号
	private String khbh;// 客户编号
	private String dah;// 档案号
	private String sfzh;// 身份证号
	@JSONField(format = "yyyy-MM-dd")
	private Date sfrq;// 随访日期
	private String ybjkzk;// 一般健康状况
	private String ybxlzk;// 一般心理状况
	private String gxy;// 高血压
	private String dxy;// 低血压
	private String rf;// 乳房
	private String rfycms;// 乳房异常描述
	private String el;// 恶露
	private String elycms;// 恶露异常描述
	private String zg;// 子宫
	private String zgycms;// 子宫异常描述
	private String sk;// 伤口
	private String skycms;// 伤口异常描述
	private String qt;// 其他
	private String fl;// 分类
	private String flms;// 分类描述
	private String zd;// 指导
	private String qtzd;// 其他指导
	private String cl;// 处理
	private String zzyy;// 转诊原因
	private String jgjks;// 机构及科室
	@JSONField(format = "yyyy-MM-dd")
	private Date xcsfrq;// 下次随访日期
	
	@JSONField(format="yyyy-MM-dd")
	private Date fmrq;//分娩日期
	@JSONField(format="yyyy-MM-dd")
	private Date cyrq;//出院日期
	
	private String sfys;// 随访医生
	private String jbr;// 建表人
	private Date jbrq;// 建表日期
	private String scxgr;// 上次修改人
	private Date scxgrq;// 上次修改日期
	private String sfsc;// 是否删除
	@Validate(name = { "save" }, required = true)
	@Column(name = "yfbh", updatable = false)
	private String yfbh;// 孕妇编号
	private String tw;// 体温

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

	private String updateFlg;


	@Transient
	private String rfName;
	@Transient
	private String elName;
	@Transient
	private String zgName;
	@Transient
	private String skName;
	@Transient
	private String flName;
	@Transient
	private String zdName;
	@Transient
	private String clName;

	public String getRfName() {
		return DictUtil.getDictValue("et-ywg", this.rf);
	}

	public void setRfName(String rfName) {
		this.rfName = rfName;
	}

	public String getElName() {
		return DictUtil.getDictValue("et-ywg", this.el);
	}

	public void setElName(String elName) {
		this.elName = elName;
	}

	public String getZgName() {
		return DictUtil.getDictValue("et-ywg", this.zg);
	}

	public void setZgName(String zgName) {
		this.zgName = zgName;
	}

	public String getSkName() {
		return DictUtil.getDictValue("et-ywg", this.sk);
	}

	public void setSkName(String skName) {
		this.skName = skName;
	}

	public String getFlName() {
		return DictUtil.getDictValue("ycfch42-fl", this.fl);
	}

	public void setFlName(String flName) {
		this.flName = flName;
	}

	public String getZdName() {
		return DictUtil.getDictValue("ycfch42-zd", this.zd);
	}

	public void setZdName(String zdName) {
		this.zdName = zdName;
	}

	public String getClName() {
		return DictUtil.getDictValue("ycfch42-zz", this.cl);
	}

	public void setClName(String clName) {
		this.clName = clName;
	}


	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public Date getFmrq() {
		return fmrq;
	}

	public void setFmrq(Date fmrq) {
		this.fmrq = fmrq;
	}

	public Date getCyrq() {
		return cyrq;
	}

	public void setCyrq(Date cyrq) {
		this.cyrq = cyrq;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
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

	public String getKhbh() {
		return this.khbh;
	}

	public void setKhbh(String khbh) {
		this.khbh = khbh;
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

	public Date getSfrq() {
		return this.sfrq;
	}

	public void setSfrq(Date sfrq) {
		this.sfrq = sfrq;
	}

	public String getYbjkzk() {
		return this.ybjkzk;
	}

	public void setYbjkzk(String ybjkzk) {
		this.ybjkzk = ybjkzk;
	}

	public String getYbxlzk() {
		return this.ybxlzk;
	}

	public void setYbxlzk(String ybxlzk) {
		this.ybxlzk = ybxlzk;
	}

	public String getGxy() {
		return this.gxy;
	}

	public void setGxy(String gxy) {
		this.gxy = gxy;
	}

	public String getDxy() {
		return this.dxy;
	}

	public void setDxy(String dxy) {
		this.dxy = dxy;
	}

	public String getRf() {
		return this.rf;
	}

	public void setRf(String rf) {
		this.rf = rf;
	}

	public String getRfycms() {
		return this.rfycms;
	}

	public void setRfycms(String rfycms) {
		this.rfycms = rfycms;
	}

	public String getEl() {
		return this.el;
	}

	public void setEl(String el) {
		this.el = el;
	}

	public String getElycms() {
		return this.elycms;
	}

	public void setElycms(String elycms) {
		this.elycms = elycms;
	}

	public String getZg() {
		return this.zg;
	}

	public void setZg(String zg) {
		this.zg = zg;
	}

	public String getZgycms() {
		return this.zgycms;
	}

	public void setZgycms(String zgycms) {
		this.zgycms = zgycms;
	}

	public String getSk() {
		return this.sk;
	}

	public void setSk(String sk) {
		this.sk = sk;
	}

	public String getSkycms() {
		return this.skycms;
	}

	public void setSkycms(String skycms) {
		this.skycms = skycms;
	}

	public String getQt() {
		return this.qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getFl() {
		return this.fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public String getFlms() {
		return this.flms;
	}

	public void setFlms(String flms) {
		this.flms = flms;
	}

	public String getZd() {
		return this.zd;
	}

	public void setZd(String zd) {
		this.zd = zd;
	}

	public String getQtzd() {
		return this.qtzd;
	}

	public void setQtzd(String qtzd) {
		this.qtzd = qtzd;
	}

	public String getCl() {
		return this.cl;
	}

	public void setCl(String cl) {
		this.cl = cl;
	}

	public String getZzyy() {
		return this.zzyy;
	}

	public void setZzyy(String zzyy) {
		this.zzyy = zzyy;
	}

	public String getJgjks() {
		return this.jgjks;
	}

	public void setJgjks(String jgjks) {
		this.jgjks = jgjks;
	}

	public Date getXcsfrq() {
		return this.xcsfrq;
	}

	public void setXcsfrq(Date xcsfrq) {
		this.xcsfrq = xcsfrq;
	}

	public String getSfys() {
		return this.sfys;
	}

	public void setSfys(String sfys) {
		this.sfys = sfys;
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

	public String getScxgr() {
		return this.scxgr;
	}

	public void setScxgr(String scxgr) {
		this.scxgr = scxgr;
	}

	public Date getScxgrq() {
		return this.scxgrq;
	}

	public void setScxgrq(Date scxgrq) {
		this.scxgrq = scxgrq;
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

	public String getYfbh() {
		return this.yfbh;
	}

	public void setYfbh(String yfbh) {
		this.yfbh = yfbh;
	}

	public String getTw() {
		return this.tw;
	}

	public void setTw(String tw) {
		this.tw = tw;
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

}
