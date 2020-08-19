package com.region.moudles.tripartdock.follow.domain;

import javax.persistence.*;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;
import com.region.until.StringUntil;

/**
 * @ClassName: FollowEtSf3
 * @Description: 随访-儿童-1-3岁-随访
 * @author Administrator
 * @date 2019年8月13日
 */
@Entity
@Table(name = "blt_1_3setxxb")
public class FollowEtSf3 extends BaseDomain {

	private static final long serialVersionUID = 145626261885L;
	
	@Id
	private String id;//
	private String jmid;//居民id
	private String hzbh;// 患者编号
	private String dah;// 档案号
	private String sfzh;// 身份证号
	private String xm;// 姓名
	@JSONField(format = "yyyy-MM-dd")
	private Date sfrq;// 随访日期
	private String tz;// 体重
	private String tzfx;// 体重分析
	private String sc;// 身长
	private String scfx;// 身长分析
	private String ms;// 面色
	private String pf;// 皮肤
	private String xinmen;// 囟门
	private String qxm;// 前囟门
	private String hxm;// 后囟门
	private String ywg;// 眼外观
	private String ewg;// 耳外观
	private String tl;// 听力
	private String zcy;// 左出牙
	private String ycy;// 右出牙
	private String xf;// 心肺
	private String fb;// 腹部
	private String sz;// 四肢
	private String bt;// 步态
	private String kyglbtz;// 可疑佝偻病体征
	private String xhdbz;// 血红蛋白值
	private String hwhd;// 户外活动
	private String fywssd;// 服用维生素D
	private String fypg;// 发育评估
	private String lcsfjhbqk;// 两次随访间患病情况
	private String qt;// 其他
	private String zzjy;// 转诊建议
	private String zzyy;// 转诊原因
	private String jgjks;// 机构及科室
	private String zd;// 指导
	private String zdqt;//指导其他
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
	
	private String chest;//胸部
	
	private String fy;//肺炎
	
	private String fx;//腹泻
	
	private String ws;//外伤
	
	private String qt1;//其他 

	@Transient
	private String tzfxName;
	@Transient
	private String scfxName;
	@Transient
	private String msName;
	@Transient
	private String pfName;
	@Transient
	private String xmName;
	@Transient
	private String ywgName;
	@Transient
	private String ewgName;
	@Transient
	private String tlName;
	@Transient
	private String chestName;
	@Transient
	private String fbName;
	@Transient
	private String szName;
	@Transient
	private String btName;
	@Transient
	private String kyglbtzName;
	@Transient
	private String fypgName;
	@Transient
	private String lcsfjhbqkName;
	@Transient
	private String zzjyName;
	@Transient
	private String zdName;
	@Transient
	private String xinMenName;
	
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

	public String getMsName() {
		return DictUtil.getDictValue("et3-ms", this.ms);
	}

	public void setMsName(String msName) {
		this.msName = msName;
	}

	public String getPfName() {
		return DictUtil.getDictValue("et-ywg", this.pf);
	}

	public void setPfName(String pfName) {
		this.pfName = pfName;
	}

	public String getXmName() {
		return DictUtil.getDictValue("et1-xm", this.xm);
	}

	public void setXmName(String xmName) {
		this.xmName = xmName;
	}

	public String getYwgName() {
		return DictUtil.getDictValue("et-ywg", this.ywg);
	}

	public void setYwgName(String ywgName) {
		this.ywgName = ywgName;
	}

	public String getEwgName() {
		return DictUtil.getDictValue("et-ywg", this.ewg);
	}

	public void setEwgName(String ewgName) {
		this.ewgName = ewgName;
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

	public String getSzName() {
		return DictUtil.getDictValue("et-ywg", this.sz);
	}

	public void setSzName(String szName) {
		this.szName = szName;
	}

	public String getBtName() {
		return DictUtil.getDictValue("et-ywg", this.bt);
	}

	public void setBtName(String btName) {
		this.btName = btName;
	}

	public String getKyglbtzName() {
		return DictUtil.getDictValue("et3-tz", this.kyglbtz);
	}

	public void setKyglbtzName(String kyglbtzName) {
		this.kyglbtzName = kyglbtzName;
	}

	public String getFypgName() {
		return DictUtil.getDictValue("et3-fypg" + bs, this.fypg);
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

	public String getChest() {
		return chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}

	public String getFy() {
		return fy;
	}

	public void setFy(String fy) {
		this.fy = fy;
	}

	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public String getWs() {
		return ws;
	}

	public void setWs(String ws) {
		this.ws = ws;
	}

	public String getQt1() {
		return qt1;
	}

	public void setQt1(String qt1) {
		this.qt1 = qt1;
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

	public String getHzbh() {
		return this.hzbh;
	}

	public void setHzbh(String hzbh) {
		this.hzbh = hzbh;
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

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
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

	public String getScfx() {
		return this.scfx;
	}

	public void setScfx(String scfx) {
		this.scfx = scfx;
	}

	public String getMs() {
		return this.ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getPf() {
		return this.pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public String getXinmen() {
		return this.xinmen;
	}

	public void setXinmen(String xinmen) {
		if(StringUntil.isNull(xinmen)) {
			this.xinMenName = "";
		}else if("1".equals(xinmen)) {
			this.xinMenName = "闭合";
		}else {
			this.xinMenName = "未闭";
		}
		this.xinmen = xinmen;
	}

	public String getQxm() {
		return this.qxm;
	}

	public void setQxm(String qxm) {
		this.qxm = qxm;
	}

	public String getHxm() {
		return this.hxm;
	}

	public void setHxm(String hxm) {
		this.hxm = hxm;
	}

	public String getYwg() {
		return this.ywg;
	}

	public void setYwg(String ywg) {
		this.ywg = ywg;
	}

	public String getEwg() {
		return this.ewg;
	}

	public void setEwg(String ewg) {
		this.ewg = ewg;
	}

	public String getTl() {
		return this.tl;
	}

	public void setTl(String tl) {
		this.tl = tl;
	}

	public String getZcy() {
		return this.zcy;
	}

	public void setZcy(String zcy) {
		this.zcy = zcy;
	}

	public String getYcy() {
		return this.ycy;
	}

	public void setYcy(String ycy) {
		this.ycy = ycy;
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

	public String getSz() {
		return this.sz;
	}

	public void setSz(String sz) {
		this.sz = sz;
	}

	public String getBt() {
		return this.bt;
	}

	public void setBt(String bt) {
		this.bt = bt;
	}

	public String getKyglbtz() {
		return this.kyglbtz;
	}

	public void setKyglbtz(String kyglbtz) {
		this.kyglbtz = kyglbtz;
	}

	public String getXhdbz() {
		return this.xhdbz;
	}

	public void setXhdbz(String xhdbz) {
		this.xhdbz = xhdbz;
	}

	public String getHwhd() {
		return this.hwhd;
	}

	public void setHwhd(String hwhd) {
		this.hwhd = hwhd;
	}

	public String getFywssd() {
		return this.fywssd;
	}

	public void setFywssd(String fywssd) {
		this.fywssd = fywssd;
	}

	public String getFypg() {
		return this.fypg;
	}

	public void setFypg(String fypg) {
		this.fypg = fypg;
	}

	public String getLcsfjhbqk() {
		return this.lcsfjhbqk;
	}

	public void setLcsfjhbqk(String lcsfjhbqk) {
		this.lcsfjhbqk = lcsfjhbqk;
	}

	public String getQt() {
		return this.qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
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

	public String getZdqt() {
		return this.zdqt;
	}

	public void setZdqt(String zdqt) {
		this.zdqt = zdqt;
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

	public String getXinMenName() {
		return xinMenName;
	}

	public void setXinMenName(String xinMenName) {
		this.xinMenName = xinMenName;
	}

}
