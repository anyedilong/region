package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.until.DictUtil;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: FollowYcfCq
 * @Description: 随访-孕产妇-产前随访
 * @author Administrator
 * @date 2019年8月2日
 */
@Entity
@Table(name = "blt_yf2_5csfb")
public class FollowYcfCq extends BaseDomain {

	private static final long serialVersionUID = 13334646464L;
	
	@Id
	private String id;//
	private String jmid;//居民id
	private String tjbh;// null
	@Column(name = "yfbh")
	private String yfbh;// 孕妇编号
	private String dabh;// 档案编号
	

	private String sfcs;// 随访次数
	@JSONField(format = "yyyy-MM-dd")
	private Date sfrq;// 随访日期
	private String yz;// 孕周

	@NotFound(action = NotFoundAction.IGNORE)
	private String zs;// 主诉
	private String tz;// 体重
	private String gdgd;// 宫底高度
	private String fw;// 腹围
	private String tw;// 胎位
	private String txl;// 胎心率
	private String gxy;// 高血压
	private String dxy;// 低血压
	@Column(name = "xhdb")
	private String xhdb;// 血红蛋白

	private String qtfzjc;// 其他辅助检查
	private String fl;// 分类
	private String qtycfl;// 其他异常分类
	private String zd;// 指导
	private String qtzd;// 其他指导
	private String ywzz;// 有无转诊
	private String zzyy;// 转诊原因
	private String jgjks;// 机构及科室
	@JSONField(format = "yyyy-MM-dd")
	private Date xcsfrq;// 下次随访日期
	@Column(name = "sfys")
	private String sfys;// 随访医生
	private String jbr;// 建表人
	private String kfxt;// 空腹血糖
	private Date jbrq;// 建表日期
	private String scxgr;// 上次修改人
	private Date scxgrq;// 上次修改日期
	private String ndb;// 尿蛋白
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
	@Column(name = "sfzh")
	private String sfzh;// 身份证号

	private String updateFlg;


	@Transient
	private String flName;
	@Transient
	private String zdName;
	@Transient
	private String ywzzName;

	public String getFlName() {
		return DictUtil.getDictValue("et-ywg", this.fl);
	}

	public void setFlName(String flName) {
		this.flName = flName;
	}

	public String getZdName() {
		if("2".equals(this.sfcs)) {
			return DictUtil.getDictValue("ycfcq-zd", this.zd);
		}else if("3".equals(this.sfcs)) {
			return DictUtil.getDictValue("ycfcq3-zd", this.zd);
		}else if("4".equals(this.sfcs) || "5".equals(this.sfcs)) {
			return DictUtil.getDictValue("ycfcq45-zd", this.zd);
		}
		return null;
	}

	public void setZdName(String zdName) {
		this.zdName = zdName;
	}

	public String getYwzzName() {
		return DictUtil.getDictValue("gxy-ywblfy", this.ywzz);
	}

	public void setYwzzName(String ywzzName) {
		this.ywzzName = ywzzName;
	}


	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
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

	public String getKfxt() {
		return this.kfxt;
	}

	public void setKfxt(String kfxt) {
		this.kfxt = kfxt;
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

	public String getNdb() {
		return this.ndb;
	}

	public void setNdb(String ndb) {
		this.ndb = ndb;
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

	public String getDabh() {
		return this.dabh;
	}

	public void setDabh(String dabh) {
		this.dabh = dabh;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getSfcs() {
		return this.sfcs;
	}

	public void setSfcs(String sfcs) {
		this.sfcs = sfcs;
	}

	public Date getSfrq() {
		return this.sfrq;
	}

	public void setSfrq(Date sfrq) {
		this.sfrq = sfrq;
	}

	public String getYz() {
		return this.yz;
	}

	public void setYz(String yz) {
		this.yz = yz;
	}

	public String getZs() {
		return this.zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

	public String getTz() {
		return this.tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public String getGdgd() {
		return this.gdgd;
	}

	public void setGdgd(String gdgd) {
		this.gdgd = gdgd;
	}

	public String getFw() {
		return this.fw;
	}

	public void setFw(String fw) {
		this.fw = fw;
	}

	public String getTw() {
		return this.tw;
	}

	public void setTw(String tw) {
		this.tw = tw;
	}

	public String getTxl() {
		return this.txl;
	}

	public void setTxl(String txl) {
		this.txl = txl;
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

	public String getXhdb() {
		return this.xhdb;
	}

	public void setXhdb(String xhdb) {
		this.xhdb = xhdb;
	}

	public String getQtfzjc() {
		return this.qtfzjc;
	}

	public void setQtfzjc(String qtfzjc) {
		this.qtfzjc = qtfzjc;
	}

	public String getFl() {
		return this.fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public String getQtycfl() {
		return this.qtycfl;
	}

	public void setQtycfl(String qtycfl) {
		this.qtycfl = qtycfl;
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

	public String getYwzz() {
		return this.ywzz;
	}

	public void setYwzz(String ywzz) {
		this.ywzz = ywzz;
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
