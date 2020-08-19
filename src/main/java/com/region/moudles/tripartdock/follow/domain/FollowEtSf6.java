package com.region.moudles.tripartdock.follow.domain;

import javax.persistence.*;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;


/**
 * @ClassName: FollowEtSf6
 * @Description: 随访-儿童-3-6岁-随访
 * @author Administrator
 * @date 2019年8月13日
 */
@Entity
@Table(name = "blt_3_6setjkjcjlb")
public class FollowEtSf6 extends BaseDomain {

	private static final long serialVersionUID = 1394964641641L;
	
	@Id
	private String id;//
	private String jmid;//居民id
	private String etbh;// 儿童编号
	private String dah;// 档案号
	private String sfzh;// 身份证号
	private String etxm;// 儿童姓名
	@JSONField(format = "yyyy-MM-dd")
	private Date sfrq;// 随访日期
	private String tz;// 体重
	private String tzfx;// 体重分析
	private String sc;// 身长
	private String scfx;// 身长分析
	private String tgfypj;// 体格发育评价
	private String sl;// 视力
	private String tl;// 听力
	private String sly;//右眼视力
	private String zc;// 左齿
	private String yc;// 右齿
	private String xf;// 心肺
	private String fb;// 腹部
	private String xhdbz;// 血红蛋白值
	private String qt;// 其他
	private String lcsfjhbqk;// 两次随访间患病情况
	private String fy;// 肺炎
	private String fx;// 腹泻
	private String ws;// 外伤
	private String qt1;// 其他
	private String zzjy;// 转诊建议
	private String zzyy;// 转诊原因
	private String jgjks;// 机构及科室
	private String zd;// 指导
	private String qtzdjy;// 其他指导建议
	@JSONField(format = "yyyy-MM-dd")
	private Date xcsfrq;// 下次随访日期
	private String sfysqm;// 随访医生签名
	private String bs;// 标示
	private String jbr;// 建表人
	private Date jbrq;// 建表日期
	private String scxgr;// 上一次修改人
	private Date scxgrq;// 上一次修改日期
	private String sfsc;// 是否删除
	private String tjbh;// 体检编号
	private String chest;//胸部
	
	private String fypg;//发育评估
	
	private String ts;//体重/身高
	private String sgdj;//身高等级
	
	private String tzdj;//体重等级
	
	private String tsdj;//身高/体重等级
	
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
	private String synFlg="0";// 是否同步 0 否 1 是
	@Column(updatable = false)
	private String synId;// 同步ID
	@Column(updatable = false)
	private Date synTime;// 同步时间
	
	private String updateFlg;

	@Transient
	private String tzfxName;
	@Transient
	private String scfxName;
	@Transient
	private String tsName;
	@Transient
	private String tgfypjName;
	@Transient
	private String tlName;
	@Transient
	private String chestName;
	@Transient
	private String fbName;
	@Transient
	private String fypgName;
	@Transient
	private String lcsfjhbqkName;
	@Transient
	private String zzjyName;
	@Transient
	private String zdName;

	public String getTzfxName() {
		return DictUtil.getDictValue("et-tzfx", this.tzfx);
	}

	public void setTzfxName(String tzfxName) {
		this.tzfxName = tzfxName;
	}

	public String getScfxName() {
		return DictUtil.getDictValue("et-tzfx", this.scfx);
	}

	public void setScfxName(String scfxName) {
		this.scfxName = scfxName;
	}

	public String getTsName() {
		return DictUtil.getDictValue("et-tzfx", this.tsdj);
	}

	public void setTsName(String tsName) {
		this.tsName = tsName;
	}

	public String getTgfypjName() {
		return DictUtil.getDictValue("et6-tgfy", this.tgfypj);
	}

	public void setTgfypjName(String tgfypjName) {
		this.tgfypjName = tgfypjName;
	}

	public String getTlName() {
		return DictUtil.getDictValue("et1-tl", this.tl);
	}

	public void setTlName(String tlName) {
		this.tlName = tlName;
	}

	public String getChestName() {
		return DictUtil.getDictValue("et-ywg", this.chest);
	}

	public void setChestName(String chestName) {
		this.chestName = chestName;
	}

	public String getFbName() {
		return DictUtil.getDictValue("et-ywg", this.fb);
	}

	public void setFbName(String fbName) {
		this.fbName = fbName;
	}

	public String getFypgName() {
		return DictUtil.getDictValue("et6-fypg" + bs, this.fypg);
	}

	public void setFypgName(String fypgName) {
		this.fypgName = fypgName;
	}

	public String getLcsfjhbqkName() {
		return DictUtil.getDictValue("et1-hbqk", this.lcsfjhbqk);
	}

	public void setLcsfjhbqkName(String lcsfjhbqkName) {
		this.lcsfjhbqkName = lcsfjhbqkName;
	}

	public String getZzjyName() {
		return DictUtil.getDictValue("gxy-ywblfy", this.zzjy);
	}

	public void setZzjyName(String zzjyName) {
		this.zzjyName = zzjyName;
	}

	public String getZdName() {
		return DictUtil.getDictValue("et1-zd", this.zd);
	}

	public void setZdName(String zdName) {
		this.zdName = zdName;
	}

	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public String getSly() {
		return sly;
	}

	public void setSly(String sly) {
		this.sly = sly;
	}

	public String getFypg() {
		return fypg;
	}

	public void setFypg(String fypg) {
		this.fypg = fypg;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getSgdj() {
		return sgdj;
	}

	public void setSgdj(String sgdj) {
		this.sgdj = sgdj;
	}

	public String getTzdj() {
		return tzdj;
	}

	public void setTzdj(String tzdj) {
		this.tzdj = tzdj;
	}

	public String getTsdj() {
		return tsdj;
	}

	public void setTsdj(String tsdj) {
		this.tsdj = tsdj;
	}

	public String getChest() {
		return chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

	public String getScfx() {
		return this.scfx;
	}

	public void setScfx(String scfx) {
		this.scfx = scfx;
	}

	public String getTgfypj() {
		return this.tgfypj;
	}

	public void setTgfypj(String tgfypj) {
		this.tgfypj = tgfypj;
	}

	public String getSl() {
		return this.sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public String getTl() {
		return this.tl;
	}

	public void setTl(String tl) {
		this.tl = tl;
	}

	public String getZc() {
		return this.zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	public String getYc() {
		return this.yc;
	}

	public void setYc(String yc) {
		this.yc = yc;
	}

	public String getXf() {
		return this.xf;
	}

	public void setXf(String xf) {
		this.xf = xf;
	}

	public String getFb() {
		return this.fb;
	}

	public void setFb(String fb) {
		this.fb = fb;
	}

	public String getXhdbz() {
		return this.xhdbz;
	}

	public void setXhdbz(String xhdbz) {
		this.xhdbz = xhdbz;
	}

	public String getQt() {
		return this.qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getLcsfjhbqk() {
		return this.lcsfjhbqk;
	}

	public void setLcsfjhbqk(String lcsfjhbqk) {
		this.lcsfjhbqk = lcsfjhbqk;
	}

	public String getFy() {
		return this.fy;
	}

	public void setFy(String fy) {
		this.fy = fy;
	}

	public String getFx() {
		return this.fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public String getWs() {
		return this.ws;
	}

	public void setWs(String ws) {
		this.ws = ws;
	}

	public String getQt1() {
		return this.qt1;
	}

	public void setQt1(String qt1) {
		this.qt1 = qt1;
	}

	public String getZzjy() {
		return this.zzjy;
	}

	public void setZzjy(String zzjy) {
		this.zzjy = zzjy;
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

	public String getZd() {
		return this.zd;
	}

	public void setZd(String zd) {
		this.zd = zd;
	}

	public String getQtzdjy() {
		return this.qtzdjy;
	}

	public void setQtzdjy(String qtzdjy) {
		this.qtzdjy = qtzdjy;
	}

	public Date getXcsfrq() {
		return this.xcsfrq;
	}

	public void setXcsfrq(Date xcsfrq) {
		this.xcsfrq = xcsfrq;
	}

	public String getSfysqm() {
		return this.sfysqm;
	}

	public void setSfysqm(String sfysqm) {
		this.sfysqm = sfysqm;
	}

	public String getBs() {
		return this.bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
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

	public String getTjbh() {
		return this.tjbh;
	}

	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEtbh() {
		return this.etbh;
	}

	public void setEtbh(String etbh) {
		this.etbh = etbh;
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

	public String getEtxm() {
		return this.etxm;
	}

	public void setEtxm(String etxm) {
		this.etxm = etxm;
	}

	public Date getSfrq() {
		return this.sfrq;
	}

	public void setSfrq(Date sfrq) {
		this.sfrq = sfrq;
	}

	public String getTz() {
		return this.tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public String getTzfx() {
		return this.tzfx;
	}

	public void setTzfx(String tzfx) {
		this.tzfx = tzfx;
	}

	public String getSc() {
		return this.sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
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
