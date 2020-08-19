package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @ClassName: FollowEtJb
 * @Description: 儿童基本信息表
 * @author Administrator
 * @date 2019年8月13日
 */
@Entity
@Table(name = "blt_etjbxxb")
public class FollowEtJb extends BaseDomain {

	private static final long serialVersionUID = 165464893336L;
	
	@Id
	private String id;//
	private String jmid;//居民id
	private String sfzh;// 身份证号
	private String etbh;// 儿童编号
	private String dah;// 档案号
	private String fqbh;// 父亲编号
	private String mqbh;// 母亲编号

	private String yzbm;// 邮政编码
	private String mqsfzh;// 母亲身份证号
	private String gzdw;// 工作单位
	private String dwdh;// 单位电话
	private String tyjk;// 托幼机构
	private String tyjgdh;// 托幼机构电话
	@JSONField(format = "yyyy-MM-dd")
	private Date tysj;// 托幼时间

	private Date jbrq;// 建表日期
	private String scxgr;// 上一次修改人
	private Date scxgrq;// 上一次修改日期
	private String xb;// 性别
	@Transient
	private String xbName;// 性别
	@JSONField(format = "yyyy-MM-dd")
	private Date csrq;// 出生日期
	private String jhzt;// 监护状态
	private String fqnl;// 父亲年龄
	private String fqgzdw;// 父亲工作单位
	private String fqlxdh;// 父亲联系电话
	private String mqnl;// 母亲年龄
	private String mqgzdw;// 母亲工作单位
	private String mqdh;// 母亲电话
	private String jhrxm;// 监护人姓名
	private String jhrnl;// 监护人年龄
	private String jhrdw;// 监护人单位
	private String jhrdh;// 监护人电话
	private String zz;// 住址
	private String kh;// 卡号
	private String sfsc;// 是否删除
	private String fqm;// 父亲名
	private String mqm;// 母亲名
	@Transient
	private String tjbh;//体检编号
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
	@Column(updatable = false)
	private String synFlg = "0";// 是否同步 0 否 1 是
	@Column(updatable = false)
	private String synId;// 同步ID
	@Column(updatable = false)
	private Date synTime;// 同步时间

	private String updateFlg;// 同步修改标示
	
	@Column(name="jbr")
	private String jbr;// 建表人
	@Column(name="jbjg")
	private String jbjg;// 建表机构

	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public String getTjbh() {
		return tjbh;
	}

	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getSynId() {
		return this.synId;
	}

	public void setSynId(String synId) {
		this.synId = synId;
	}

	public Date getSynTime() {
		return this.synTime;
	}

	public void setSynTime(Date synTime) {
		this.synTime = synTime;
	}

	public String getDataSourceNo() {
		return this.dataSourceNo;
	}

	public void setDataSourceNo(String dataSourceNo) {
		this.dataSourceNo = dataSourceNo;
	}

	public String getUpdateFlg() {
		return this.updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getMqsfzh() {
		return this.mqsfzh;
	}

	public void setMqsfzh(String mqsfzh) {
		this.mqsfzh = mqsfzh;
	}

	public String getGzdw() {
		return this.gzdw;
	}

	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}

	public String getDwdh() {
		return this.dwdh;
	}

	public void setDwdh(String dwdh) {
		this.dwdh = dwdh;
	}

	public String getTyjk() {
		return this.tyjk;
	}

	public void setTyjk(String tyjk) {
		this.tyjk = tyjk;
	}

	public String getTyjgdh() {
		return this.tyjgdh;
	}

	public void setTyjgdh(String tyjgdh) {
		this.tyjgdh = tyjgdh;
	}

	public Date getTysj() {
		return this.tysj;
	}

	public void setTysj(Date tysj) {
		this.tysj = tysj;
	}

	public String getJbjg() {
		return this.jbjg;
	}

	public void setJbjg(String jbjg) {
		this.jbjg = jbjg;
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

	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getXbName() {
		return DictUtil.getDictValue("da-xb", this.xb);
	}

	public void setXbName(String xbName) {
		this.xbName = xbName;
	}

	public Date getCsrq() {
		return this.csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getJhzt() {
		return this.jhzt;
	}

	public void setJhzt(String jhzt) {
		this.jhzt = jhzt;
	}

	public String getFqnl() {
		return this.fqnl;
	}

	public void setFqnl(String fqnl) {
		this.fqnl = fqnl;
	}

	public String getFqgzdw() {
		return this.fqgzdw;
	}

	public void setFqgzdw(String fqgzdw) {
		this.fqgzdw = fqgzdw;
	}

	public String getFqlxdh() {
		return this.fqlxdh;
	}

	public void setFqlxdh(String fqlxdh) {
		this.fqlxdh = fqlxdh;
	}

	public String getMqnl() {
		return this.mqnl;
	}

	public void setMqnl(String mqnl) {
		this.mqnl = mqnl;
	}

	public String getMqgzdw() {
		return this.mqgzdw;
	}

	public void setMqgzdw(String mqgzdw) {
		this.mqgzdw = mqgzdw;
	}

	public String getMqdh() {
		return this.mqdh;
	}

	public void setMqdh(String mqdh) {
		this.mqdh = mqdh;
	}

	public String getJhrxm() {
		return this.jhrxm;
	}

	public void setJhrxm(String jhrxm) {
		this.jhrxm = jhrxm;
	}

	public String getJhrnl() {
		return this.jhrnl;
	}

	public void setJhrnl(String jhrnl) {
		this.jhrnl = jhrnl;
	}

	public String getJhrdw() {
		return this.jhrdw;
	}

	public void setJhrdw(String jhrdw) {
		this.jhrdw = jhrdw;
	}

	public String getJhrdh() {
		return this.jhrdh;
	}

	public void setJhrdh(String jhrdh) {
		this.jhrdh = jhrdh;
	}

	public String getZz() {
		return this.zz;
	}

	public void setZz(String zz) {
		this.zz = zz;
	}

	public String getKh() {
		return this.kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getSfsc() {
		return this.sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}

	public String getFqm() {
		return this.fqm;
	}

	public void setFqm(String fqm) {
		this.fqm = fqm;
	}

	public String getMqm() {
		return this.mqm;
	}

	public void setMqm(String mqm) {
		this.mqm = mqm;
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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
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

	public String getFqbh() {
		return this.fqbh;
	}

	public void setFqbh(String fqbh) {
		this.fqbh = fqbh;
	}

	public String getMqbh() {
		return this.mqbh;
	}

	public void setMqbh(String mqbh) {
		this.mqbh = mqbh;
	}
}
