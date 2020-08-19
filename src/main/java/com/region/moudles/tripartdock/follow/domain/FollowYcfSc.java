package com.region.moudles.tripartdock.follow.domain;

import javax.persistence.*;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.until.DictUtil;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: FollowYcfSc
 * @Description: 随访-孕产妇-首次随访
 * @author Administrator
 * @date 2019年8月2日
 */
@Entity
@Table(name = "blt_ycfscsfb")
public class FollowYcfSc extends BaseDomain {

	private static final long serialVersionUID = 2646464648666L;
	
	@Id
	private String id;//ID
	private String jmid;//居民id
	private String tjbh;// null
	private String yfbh;// 孕妇编号
	private String dah;// 档案号
	private String sfzh;// 身份证号
	@JSONField(format = "yyyy-MM-dd")
	private Date jlrq;// 记录日期
	private String yz;// 孕周
	private String yfnl;// 孕妇年龄
	private String zfxm;// 丈夫姓名
	private String zfnl;// 丈夫年龄
	private String zfdh;// 丈夫电话
	private String yc;// 孕次
	private String cc;// 产次
	private String pgcc;// 剖宫产次
	private String mcyj;// 末次月经
	@JSONField(format = "yyyy-MM-dd")
	private Date mcyjsj;// 末次月经时间
	@JSONField(format = "yyyy-MM-dd")
	private Date ycq;// 预产期
	private String jws;// 既往史
	private String qtjws;// 其他既往史
	private String jzs;// 家族史
	private String jzsms;// 家族史描述
	private String grs;// 个人史
	private String grsms;// 个人史描述
	private String fksss;// 妇科手术史
	private String lc;// 流产
	private String st;// 死胎
	private String sc;// 死产
	private String xsesw;// 新生儿死亡
	private String xsrqx;// 新生儿缺陷
	private String rgabortion;//人工流产
	private String zrabortion;//自然流产
	private String sg;// 身高
	private String tz;// 体重
	private String tzzs;// 体质指数
	private String gxy;// 高血压
	private String dxy;// 低血压
	private String xz;// 心脏
	private String xzycms;// 心脏异常描述
	private String fb;// 肺部
	private String fbycms;// 肺部异常描述
	private String wy;// 外阴
	private String wyycms;// 外阴异常描述
	private String yd;// 阴道
	private String ydycms;// 阴道异常描述
	private String gj;// 宫颈
	private String gjycms;// 宫颈异常描述
	private String zg;// 子宫
	private String zgycms;// 子宫异常描述
	private String fj;// 附件
	private String fjycms;// 附件异常描述
	private String ztpg;// 总体评估
	private String jkzd;// 健康指导
	private String qtjkzd;// 其他健康指导
	private String zz;// 转诊
	private String zzyy;// 转诊原因
	private String jgjks;// 机构及科室
	@JSONField(format = "yyyy-MM-dd")
	private Date xcsfrq;// 下次随访日期
	private String sfys;// 随访医生
	private String jbr;// 建表人
	private Date jbrq;// 建表日期
	private String scxgr;// 上次修改人
	private Date scxgrq;// 上次修改日期
	private String sfsc;// 是否删除
	private String fkbsms;// 妇科手术史描述
	private String ztpgms;// 总体评估描述

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

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, optional = false)
	@JoinColumns(value = {
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable=false),
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable=false)
			})
	@NotFound(action = NotFoundAction.IGNORE)
	private FollowYcfScFzjc followYcfScFzjc;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, optional = false)
	@JoinColumns(value = {
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false),
			@JoinColumn(name = "yfbh", referencedColumnName = "yfbh", insertable = false, updatable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private FollowYcfJb followYcfJb;

	private String updateFlg;


	@Transient
	private String mcyjName;
	@Transient
	private String jwsName;
	@Transient
	private String jzsName;
	@Transient
	private String grsName;
	@Transient
	private String fksssName;
	@Transient
	private String xzName;
	@Transient
	private String fbName;
	@Transient
	private String wyName;
	@Transient
	private String ydName;
	@Transient
	private String gjName;
	@Transient
	private String zgName;
	@Transient
	private String fjName;
	@Transient
	private String ztpgName;
	@Transient
	private String jkzdName;
	@Transient
	private String zzName;

	public String getMcyjName() {
		return DictUtil.getDictValue("ycf-bx-sj", this.mcyj);
	}

	public void setMcyjName(String mcyjName) {
		this.mcyjName = mcyjName;
	}

	public String getJwsName() {
		return DictUtil.getDictValue("ycf-jws", this.jws);
	}

	public void setJwsName(String jwsName) {
		this.jwsName = jwsName;
	}

	public String getJzsName() {
		return DictUtil.getDictValue("ycf-jzs", this.jzs);
	}

	public void setJzsName(String jzsName) {
		this.jzsName = jzsName;
	}

	public String getGrsName() {
		return DictUtil.getDictValue("ycf-grs", this.grs);
	}

	public void setGrsName(String grsName) {
		this.grsName = grsName;
	}

	public String getFksssName() {
		return DictUtil.getDictValue("gxy-ywblfy", this.fksss);
	}

	public void setFksssName(String fksssName) {
		this.fksssName = fksssName;
	}

	public String getXzName() {
		return DictUtil.getDictValue("et-ywg", this.xz);
	}

	public void setXzName(String xzName) {
		this.xzName = xzName;
	}

	public String getFbName() {
		return DictUtil.getDictValue("et-ywg", this.fb);
	}

	public void setFbName(String fbName) {
		this.fbName = fbName;
	}

	public String getWyName() {
		return DictUtil.getDictValue("et-ywg", this.wy);
	}

	public void setWyName(String wyName) {
		this.wyName = wyName;
	}

	public String getYdName() {
		return DictUtil.getDictValue("et-ywg", this.yd);
	}

	public void setYdName(String ydName) {
		this.ydName = ydName;
	}

	public String getGjName() {
		return DictUtil.getDictValue("et-ywg", this.gj);
	}

	public void setGjName(String gjName) {
		this.gjName = gjName;
	}

	public String getZgName() {
		return DictUtil.getDictValue("et-ywg", this.zg);
	}

	public void setZgName(String zgName) {
		this.zgName = zgName;
	}

	public String getFjName() {
		return DictUtil.getDictValue("et-ywg", this.fj);
	}

	public void setFjName(String fjName) {
		this.fjName = fjName;
	}

	public String getZtpgName() {
		return DictUtil.getDictValue("et-ywg", this.ztpg);
	}

	public void setZtpgName(String ztpgName) {
		this.ztpgName = ztpgName;
	}

	public String getJkzdName() {
		return DictUtil.getDictValue("ycf-jkzd", this.jkzd);
	}

	public void setJkzdName(String jkzdName) {
		this.jkzdName = jkzdName;
	}

	public String getZzName() {
		return DictUtil.getDictValue("gxy-ywblfy", this.zz);
	}

	public void setZzName(String zzName) {
		this.zzName = zzName;
	}


	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public String getRgabortion() {
		return rgabortion;
	}

	public void setRgabortion(String rgabortion) {
		this.rgabortion = rgabortion;
	}

	public String getZrabortion() {
		return zrabortion;
	}

	public void setZrabortion(String zrabortion) {
		this.zrabortion = zrabortion;
	}

	public FollowYcfScFzjc getFollowYcfScFzjc() {
		return followYcfScFzjc;
	}

	public void setFollowYcfScFzjc(FollowYcfScFzjc followYcfScFzjc) {
		this.followYcfScFzjc = followYcfScFzjc;
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

	public String getYfbh() {
		return this.yfbh;
	}

	public void setYfbh(String yfbh) {
		this.yfbh = yfbh;
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

	public Date getJlrq() {
		return this.jlrq;
	}

	public void setJlrq(Date jlrq) {
		this.jlrq = jlrq;
	}

	public String getYz() {
		return this.yz;
	}

	public void setYz(String yz) {
		this.yz = yz;
	}

	public String getYfnl() {
		return this.yfnl;
	}

	public void setYfnl(String yfnl) {
		this.yfnl = yfnl;
	}

	public String getZfxm() {
		return this.zfxm;
	}

	public void setZfxm(String zfxm) {
		this.zfxm = zfxm;
	}

	public String getZfnl() {
		return this.zfnl;
	}

	public void setZfnl(String zfnl) {
		this.zfnl = zfnl;
	}

	public String getZfdh() {
		return this.zfdh;
	}

	public void setZfdh(String zfdh) {
		this.zfdh = zfdh;
	}

	public String getYc() {
		return this.yc;
	}

	public void setYc(String yc) {
		this.yc = yc;
	}

	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getPgcc() {
		return this.pgcc;
	}

	public void setPgcc(String pgcc) {
		this.pgcc = pgcc;
	}

	public String getMcyj() {
		return this.mcyj;
	}

	public void setMcyj(String mcyj) {
		this.mcyj = mcyj;
	}

	public Date getMcyjsj() {
		return this.mcyjsj;
	}

	public void setMcyjsj(Date mcyjsj) {
		this.mcyjsj = mcyjsj;
	}

	public Date getYcq() {
		return this.ycq;
	}

	public void setYcq(Date ycq) {
		this.ycq = ycq;
	}

	public String getJws() {
		return this.jws;
	}

	public void setJws(String jws) {
		this.jws = jws;
	}

	public String getQtjws() {
		return this.qtjws;
	}

	public void setQtjws(String qtjws) {
		this.qtjws = qtjws;
	}

	public String getJzs() {
		return this.jzs;
	}

	public void setJzs(String jzs) {
		this.jzs = jzs;
	}

	public String getJzsms() {
		return this.jzsms;
	}

	public void setJzsms(String jzsms) {
		this.jzsms = jzsms;
	}

	public String getGrs() {
		return this.grs;
	}

	public void setGrs(String grs) {
		this.grs = grs;
	}

	public String getGrsms() {
		return this.grsms;
	}

	public void setGrsms(String grsms) {
		this.grsms = grsms;
	}

	public String getFksss() {
		return this.fksss;
	}

	public void setFksss(String fksss) {
		this.fksss = fksss;
	}

	public String getLc() {
		return this.lc;
	}

	public void setLc(String lc) {
		this.lc = lc;
	}

	public String getSt() {
		return this.st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getSc() {
		return this.sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getXsesw() {
		return this.xsesw;
	}

	public void setXsesw(String xsesw) {
		this.xsesw = xsesw;
	}

	public String getXsrqx() {
		return this.xsrqx;
	}

	public void setXsrqx(String xsrqx) {
		this.xsrqx = xsrqx;
	}

	public String getSg() {
		return this.sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public String getTz() {
		return this.tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public String getTzzs() {
		return this.tzzs;
	}

	public void setTzzs(String tzzs) {
		this.tzzs = tzzs;
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

	public String getXz() {
		return this.xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

	public String getXzycms() {
		return this.xzycms;
	}

	public void setXzycms(String xzycms) {
		this.xzycms = xzycms;
	}

	public String getFb() {
		return this.fb;
	}

	public void setFb(String fb) {
		this.fb = fb;
	}

	public String getFbycms() {
		return this.fbycms;
	}

	public void setFbycms(String fbycms) {
		this.fbycms = fbycms;
	}

	public String getWy() {
		return this.wy;
	}

	public void setWy(String wy) {
		this.wy = wy;
	}

	public String getWyycms() {
		return this.wyycms;
	}

	public void setWyycms(String wyycms) {
		this.wyycms = wyycms;
	}

	public String getYd() {
		return this.yd;
	}

	public void setYd(String yd) {
		this.yd = yd;
	}

	public String getYdycms() {
		return this.ydycms;
	}

	public void setYdycms(String ydycms) {
		this.ydycms = ydycms;
	}

	public String getGj() {
		return this.gj;
	}

	public void setGj(String gj) {
		this.gj = gj;
	}

	public String getGjycms() {
		return this.gjycms;
	}

	public void setGjycms(String gjycms) {
		this.gjycms = gjycms;
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

	public String getFj() {
		return this.fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}

	public String getFjycms() {
		return this.fjycms;
	}

	public void setFjycms(String fjycms) {
		this.fjycms = fjycms;
	}

	public String getZtpg() {
		return this.ztpg;
	}

	public void setZtpg(String ztpg) {
		this.ztpg = ztpg;
	}

	public String getJkzd() {
		return this.jkzd;
	}

	public void setJkzd(String jkzd) {
		this.jkzd = jkzd;
	}

	public String getQtjkzd() {
		return this.qtjkzd;
	}

	public void setQtjkzd(String qtjkzd) {
		this.qtjkzd = qtjkzd;
	}

	public String getZz() {
		return this.zz;
	}

	public void setZz(String zz) {
		this.zz = zz;
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

	public String getFkbsms() {
		return this.fkbsms;
	}

	public void setFkbsms(String fkbsms) {
		this.fkbsms = fkbsms;
	}

	public String getZtpgms() {
		return this.ztpgms;
	}

	public void setZtpgms(String ztpgms) {
		this.ztpgms = ztpgms;
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

	public FollowYcfJb getFollowYcfJb() {
		return followYcfJb;
	}

	public void setFollowYcfJb(FollowYcfJb followYcfJb) {
		this.followYcfJb = followYcfJb;
	}

}
