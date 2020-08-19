package com.region.moudles.tripartdock.follow.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: FollowJsbJb
 * @Description: 随访-精神病-基本 
 * @author Administrator
 * @date 2019年8月1日
 */
@Entity
@Table(name = "blt_jsbjbxxb")
public class FollowJsbJb extends BaseDomain {

	private static final long serialVersionUID = 196161635146L;
	
	@Id
	private String id;//
	private String jmid;//居民id
	private String hzbh;// 患者编号
	private String dah;// 档案号
	private String sfzh;// 身份证
	private String jhrbh;// 监护人编号
	private String jhrxm;// 监护人姓名
	private String yhzgx;// 与患者关系
	private String jhrjtzz;// 监护人家庭住址
	private String jhrlxfs;// 监护人联系方式
	@JSONField(format = "yyyy-MM-dd")
	private Date scbfsj;// 首次病发时间
	private String zqty;// 知情同意
	private String qz;// 签字
	@JSONField(format = "yyyy-MM-dd")
	private Date qzsj;// 签字时间
	private String zz;// 症状
	private String qtzz;// 其他症状
	private String mz;// 门诊
	private String czjszkyycs;// 曾住精神专科医院次数
	private String mqzdqk;// 目前诊断情况
	private String qzyy;// 确诊医院
	@JSONField(format = "yyyy-MM-dd")
	private Date qzrq;// 确诊日期
	private String zhyczlxg;// 最后一次治疗效果
	private String jwhlxr;// 居委会联系人
	private String jwhlxdh;// 居委会联系电话
	private String gszk;// 关锁状况
	private String jjzk;// 经济状况
	private String zkysjy;// 专科医生意见
	@JSONField(format = "yyyy-MM-dd")
	private Date tbsj;// 填表时间
	private String ysqz;// 医生签字
	private String jbr;// 建表人
	@JSONField(format = "yyyy-MM-dd")
	private Date jbrq;// 建表日期
	private String scxgr;// 上一次修改人
	private Date scxgrq;// 上次修改日期
	private String jbjg;// 建表机构
	private String dqjg;// 当前机构
	private String sfsc;// 是否删除
	@JSONField(format = "yyyy-MM-dd")
	private Date dyczlsj;// 第一次治疗时间
	private String qdzs;// 轻度滋事
	private String zs;// 肇事
	private String zh;// 肇祸
	private String zshang;// 自伤
	private String zsws;// 自杀未遂
	private String wu;// 无
	private String hb;//户别
	private String jyqk;//就业情况
	private String qtwhxw;//其他危害行为
	private String wxxw; //危险行为
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
	private String  updateFlg;

	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public String getWxxw() {
		return wxxw;
	}

	public void setWxxw(String wxxw) {
		this.wxxw = wxxw;
	}

	public String getQtwhxw() {
		return qtwhxw;
	}

	public void setQtwhxw(String qtwhxw) {
		this.qtwhxw = qtwhxw;
	}

	public String getHb() {
		return hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
	}

	public String getJyqk() {
		return jyqk;
	}

	public void setJyqk(String jyqk) {
		this.jyqk = jyqk;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

	public String getJjzk() {
		return this.jjzk;
	}

	public void setJjzk(String jjzk) {
		this.jjzk = jjzk;
	}

	public String getZkysjy() {
		return this.zkysjy;
	}

	public void setZkysjy(String zkysjy) {
		this.zkysjy = zkysjy;
	}

	public Date getTbsj() {
		return this.tbsj;
	}

	public void setTbsj(Date tbsj) {
		this.tbsj = tbsj;
	}

	public String getYsqz() {
		return this.ysqz;
	}

	public void setYsqz(String ysqz) {
		this.ysqz = ysqz;
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

	public String getSfsc() {
		return this.sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}

	public Date getDyczlsj() {
		return this.dyczlsj;
	}

	public void setDyczlsj(Date dyczlsj) {
		this.dyczlsj = dyczlsj;
	}

	public String getQdzs() {
		return this.qdzs;
	}

	public void setQdzs(String qdzs) {
		this.qdzs = qdzs;
	}

	public String getZs() {
		return this.zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

	public String getZh() {
		return this.zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public String getZshang() {
		return this.zshang;
	}

	public void setZshang(String zshang) {
		this.zshang = zshang;
	}

	public String getZsws() {
		return this.zsws;
	}

	public void setZsws(String zsws) {
		this.zsws = zsws;
	}

	public String getWu() {
		return this.wu;
	}

	public void setWu(String wu) {
		this.wu = wu;
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

	public String getJhrbh() {
		return this.jhrbh;
	}

	public void setJhrbh(String jhrbh) {
		this.jhrbh = jhrbh;
	}

	public String getJhrxm() {
		return this.jhrxm;
	}

	public void setJhrxm(String jhrxm) {
		this.jhrxm = jhrxm;
	}

	public String getYhzgx() {
		return this.yhzgx;
	}

	public void setYhzgx(String yhzgx) {
		this.yhzgx = yhzgx;
	}

	public String getJhrjtzz() {
		return this.jhrjtzz;
	}

	public void setJhrjtzz(String jhrjtzz) {
		this.jhrjtzz = jhrjtzz;
	}

	public String getJhrlxfs() {
		return this.jhrlxfs;
	}

	public void setJhrlxfs(String jhrlxfs) {
		this.jhrlxfs = jhrlxfs;
	}

	public Date getScbfsj() {
		return this.scbfsj;
	}

	public void setScbfsj(Date scbfsj) {
		this.scbfsj = scbfsj;
	}

	public String getZqty() {
		return this.zqty;
	}

	public void setZqty(String zqty) {
		this.zqty = zqty;
	}

	public String getQz() {
		return this.qz;
	}

	public void setQz(String qz) {
		this.qz = qz;
	}

	public Date getQzsj() {
		return this.qzsj;
	}

	public void setQzsj(Date qzsj) {
		this.qzsj = qzsj;
	}

	public String getZz() {
		return this.zz;
	}

	public void setZz(String zz) {
		this.zz = zz;
	}

	public String getQtzz() {
		return this.qtzz;
	}

	public void setQtzz(String qtzz) {
		this.qtzz = qtzz;
	}

	public String getMz() {
		return this.mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getCzjszkyycs() {
		return this.czjszkyycs;
	}

	public void setCzjszkyycs(String czjszkyycs) {
		this.czjszkyycs = czjszkyycs;
	}

	public String getMqzdqk() {
		return this.mqzdqk;
	}

	public void setMqzdqk(String mqzdqk) {
		this.mqzdqk = mqzdqk;
	}

	public String getQzyy() {
		return this.qzyy;
	}

	public void setQzyy(String qzyy) {
		this.qzyy = qzyy;
	}

	public Date getQzrq() {
		return this.qzrq;
	}

	public void setQzrq(Date qzrq) {
		this.qzrq = qzrq;
	}

	public String getZhyczlxg() {
		return this.zhyczlxg;
	}

	public void setZhyczlxg(String zhyczlxg) {
		this.zhyczlxg = zhyczlxg;
	}

	public String getJwhlxr() {
		return this.jwhlxr;
	}

	public void setJwhlxr(String jwhlxr) {
		this.jwhlxr = jwhlxr;
	}

	public String getJwhlxdh() {
		return this.jwhlxdh;
	}

	public void setJwhlxdh(String jwhlxdh) {
		this.jwhlxdh = jwhlxdh;
	}

	public String getGszk() {
		return this.gszk;
	}

	public void setGszk(String gszk) {
		this.gszk = gszk;
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
