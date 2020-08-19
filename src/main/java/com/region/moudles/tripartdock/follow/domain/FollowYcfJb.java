package com.region.moudles.tripartdock.follow.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: FollowYcfJb
 * @Description: 随访-孕产妇-基本信息 
 * @author Administrator
 * @date 2019年8月2日
 */
@Entity
@Table(name = "blt_ycfjbxxb")
public class FollowYcfJb extends BaseDomain {

	private static final long serialVersionUID = 16364451313L;
	
	@Id
	private String id;//
	private String tjbh;// null
	private String hzbh;// 患者编号
	private String dabh;// 档案编号
	@Column(name="sfzh")
	private String sfzh;// 身份证号
	private String yfxm;// 孕妇名称
	private String nl;// 年龄
	private String whcd;// 文化程度
	private String zy;// 职业
	private String hkszd;// 户口所在地
	private String mz;// 民族
	@JSONField(format = "yyyy-MM-dd")
	private Date csrq;// 出生日期
	private String xzz;// 现住址
	private String dh;// 电话
	private String chxyd;// 产后休养地
	private String xzmc;// 乡镇名称
	private String ch;// 村号
	private String gzdwdh;// 工作单位电话
	private String zfxm;// 丈夫姓名
	private String zfdh;// 丈夫电话
	private String xzddw;// 现在的单位
	private String jbdw;// 建表单位
	private String jbr;// 建表人
	@JSONField(format = "yyyy-MM-dd")
	private Date jbrq;// 建表日期
	private String scxgr;// 上次修改人
	@JSONField(format = "yyyy-MM-dd")
	private Date scxgrq;// 上次修改日期
	private String sfsc;// 是否删除
	private String hkszdxz;// 户口所在地乡镇
	private String hkszdch;// 户口所在地村号
	private String xzzxz;// 现住址乡镇
	private String xzzch;// 现住址村号
	private String xzzdh;// 现住址电话
	private String gzdw;// 工作单位
	private String dwdh;// 单位电话
	private String zfnl;// 丈夫年龄
	private String zfwhzd;// 丈夫文化程度
	private String zfmz;// 丈夫民族
	private String zfdw;// 丈夫单位
	private String zfdwdh;// 丈夫单位电话
	private String zfzy;// 丈夫职业
	private String kh;// 卡号
	private String jbdwdh;// 建表单位电话
	private Date jbrq2;// 建表日期
	private String yfbh;// 孕妇编号
	private String chxydcz;// ???????
	private String chxydphone;// ???????

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

	public String getHkszdxz() {
		return this.hkszdxz;
	}

	public void setHkszdxz(String hkszdxz) {
		this.hkszdxz = hkszdxz;
	}

	public String getHkszdch() {
		return this.hkszdch;
	}

	public void setHkszdch(String hkszdch) {
		this.hkszdch = hkszdch;
	}

	public String getXzzxz() {
		return this.xzzxz;
	}

	public void setXzzxz(String xzzxz) {
		this.xzzxz = xzzxz;
	}

	public String getXzzch() {
		return this.xzzch;
	}

	public void setXzzch(String xzzch) {
		this.xzzch = xzzch;
	}

	public String getXzzdh() {
		return this.xzzdh;
	}

	public void setXzzdh(String xzzdh) {
		this.xzzdh = xzzdh;
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

	public String getZfnl() {
		return this.zfnl;
	}

	public void setZfnl(String zfnl) {
		this.zfnl = zfnl;
	}

	public String getZfwhzd() {
		return this.zfwhzd;
	}

	public void setZfwhzd(String zfwhzd) {
		this.zfwhzd = zfwhzd;
	}

	public String getZfmz() {
		return this.zfmz;
	}

	public void setZfmz(String zfmz) {
		this.zfmz = zfmz;
	}

	public String getZfdw() {
		return this.zfdw;
	}

	public void setZfdw(String zfdw) {
		this.zfdw = zfdw;
	}

	public String getZfdwdh() {
		return this.zfdwdh;
	}

	public void setZfdwdh(String zfdwdh) {
		this.zfdwdh = zfdwdh;
	}

	public String getZfzy() {
		return this.zfzy;
	}

	public void setZfzy(String zfzy) {
		this.zfzy = zfzy;
	}

	public String getKh() {
		return this.kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getJbdwdh() {
		return this.jbdwdh;
	}

	public void setJbdwdh(String jbdwdh) {
		this.jbdwdh = jbdwdh;
	}

	public Date getJbrq2() {
		return this.jbrq2;
	}

	public void setJbrq2(Date jbrq2) {
		this.jbrq2 = jbrq2;
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

	public String getChxydcz() {
		return this.chxydcz;
	}

	public void setChxydcz(String chxydcz) {
		this.chxydcz = chxydcz;
	}

	public String getChxydphone() {
		return this.chxydphone;
	}

	public void setChxydphone(String chxydphone) {
		this.chxydphone = chxydphone;
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

	public String getHzbh() {
		return this.hzbh;
	}

	public void setHzbh(String hzbh) {
		this.hzbh = hzbh;
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

	public String getYfxm() {
		return this.yfxm;
	}

	public void setYfxm(String yfxm) {
		this.yfxm = yfxm;
	}

	public String getNl() {
		return this.nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	public String getWhcd() {
		return this.whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getZy() {
		return this.zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getHkszd() {
		return this.hkszd;
	}

	public void setHkszd(String hkszd) {
		this.hkszd = hkszd;
	}

	public String getMz() {
		return this.mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public Date getCsrq() {
		return this.csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getXzz() {
		return this.xzz;
	}

	public void setXzz(String xzz) {
		this.xzz = xzz;
	}

	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public String getChxyd() {
		return this.chxyd;
	}

	public void setChxyd(String chxyd) {
		this.chxyd = chxyd;
	}

	public String getXzmc() {
		return this.xzmc;
	}

	public void setXzmc(String xzmc) {
		this.xzmc = xzmc;
	}

	public String getCh() {
		return this.ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public String getGzdwdh() {
		return this.gzdwdh;
	}

	public void setGzdwdh(String gzdwdh) {
		this.gzdwdh = gzdwdh;
	}

	public String getZfxm() {
		return this.zfxm;
	}

	public void setZfxm(String zfxm) {
		this.zfxm = zfxm;
	}

	public String getZfdh() {
		return this.zfdh;
	}

	public void setZfdh(String zfdh) {
		this.zfdh = zfdh;
	}

	public String getXzddw() {
		return this.xzddw;
	}

	public void setXzddw(String xzddw) {
		this.xzddw = xzddw;
	}

	public String getJbdw() {
		return this.jbdw;
	}

	public void setJbdw(String jbdw) {
		this.jbdw = jbdw;
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
