package com.region.moudles.tripartdock.health.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
/**
 * 
 * <br>
 * <b>功能：计划内接种登记单
 * <b>作者：司衍芹
 * <b>版权所有：<b>版权所有(C) 2016，blt<br>
 */ 
@Entity
@Table(name = "blt_jhnjzdjd")
public class Jhnjzdjd extends BaseDomain{

	private static final long serialVersionUID = 57461641641L;
	@Id	private String id;//    
	@Column(updatable = false)
	private String sfzh;//   身份证号 
	private String jzzh;//	接种证号	Varchar
	private String jzbh;//	接种编号	varchar	32
	private String jzr;//	接种人	Varchar	100
	private String ymmc;//	疫苗名称	Varchar	100
	private String zc;//	针次	Varchar	20
	private Date yyrq;//	预约日期	Date	
	private Date jzrq;//	接种日期	Date	
	private String jzjl;//	接种剂量	Varchar	100
	private String jzbw;//	接种部位	varchar	100
	private String scqy;//	生产企业	varchar	200
	private String jzph;//	接种批号	Varchar	100
	private String jzys;//	接种医生	Varchar	100
	private String bz;//	备注	Varchar	100
	@Column(updatable = false)
	private String lrjg;	//录入机构	Varchar
	@Column(updatable = false)
	private String jbr;// 建表人
	@Column(updatable = false)
	private Date jbrq;// 建表日期
	private String scxgr;// 上次修改人
	private Date scxgrq;// 上次修改时间
	private String sfsc;// 是否删除
	@Column(updatable = false)
	private String import_device_num;//   导入设备号
	@Column(updatable = false)
	private Date import_time;//   导入时间
	@Column(updatable = false)
	private String import_user;//   导入人
	@Column(updatable = false)
	private String import_ip;//   导入IP
	private String syn_flg;// 是否同步 0 否 1 是
	private String data_source; //'数据来源 1平台  2平板  3手机'
	private String syn_id; //'同步ID'
	private Date syn_time; //'同步时间'
	private String data_source_no; //'数据来源唯一标志'
	private String update_flg; //'同步修改标示'

	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getSfzh() {	    return this.sfzh;	}	public void setSfzh(String sfzh) {	    this.sfzh=sfzh;	}
	public String getJzbh() {
		return jzbh;
	}
	public void setJzbh(String jzbh) {
		this.jzbh = jzbh;
	}
	public String getJzr() {
		return jzr;
	}
	public void setJzr(String jzr) {
		this.jzr = jzr;
	}
	public String getYmmc() {
		return ymmc;
	}
	public void setYmmc(String ymmc) {
		this.ymmc = ymmc;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	@JSONField(format="yyyy-MM-dd")  
	public Date getYyrq() {
		return yyrq;
	}
	public void setYyrq(Date yyrq) {
		this.yyrq = yyrq;
	}
	@JSONField(format="yyyy-MM-dd")  
	public Date getJzrq() {
		return jzrq;
	}
	public void setJzrq(Date jzrq) {
		this.jzrq = jzrq;
	}
	public String getJzjl() {
		return jzjl;
	}
	public void setJzjl(String jzjl) {
		this.jzjl = jzjl;
	}
	public String getJzbw() {
		return jzbw;
	}
	public void setJzbw(String jzbw) {
		this.jzbw = jzbw;
	}
	public String getScqy() {
		return scqy;
	}
	public void setScqy(String scqy) {
		this.scqy = scqy;
	}
	public String getJzph() {
		return jzph;
	}
	public void setJzph(String jzph) {
		this.jzph = jzph;
	}
	public String getJzys() {
		return jzys;
	}
	public void setJzys(String jzys) {
		this.jzys = jzys;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getLrjg() {
		return lrjg;
	}
	public void setLrjg(String lrjg) {
		this.lrjg = lrjg;
	}
	public String getJbr() {
		return jbr;
	}
	public void setJbr(String jbr) {
		this.jbr = jbr;
	}
	@JSONField(format="yyyy-MM-dd")  
	public Date getJbrq() {
		return jbrq;
	}
	public void setJbrq(Date jbrq) {
		this.jbrq = jbrq;
	}
	public String getScxgr() {
		return scxgr;
	}
	public void setScxgr(String scxgr) {
		this.scxgr = scxgr;
	}
	@JSONField(format="yyyy-MM-dd")  
	public Date getScxgrq() {
		return scxgrq;
	}
	public void setScxgrq(Date scxgrq) {
		this.scxgrq = scxgrq;
	}
	public String getSfsc() {
		return sfsc;
	}
	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}
	public String getImport_device_num() {
		return import_device_num;
	}
	public void setImport_device_num(String import_device_num) {
		this.import_device_num = import_device_num;
	}
	@JSONField(format="yyyy-MM-dd HH:mm:ss")  
	public Date getImport_time() {
		return import_time;
	}
	public void setImport_time(Date import_time) {
		this.import_time = import_time;
	}
	public String getImport_user() {
		return import_user;
	}
	public void setImport_user(String import_user) {
		this.import_user = import_user;
	}
	public String getImport_ip() {
		return import_ip;
	}
	public void setImport_ip(String import_ip) {
		this.import_ip = import_ip;
	}
	public String getSyn_flg() {
		return syn_flg;
	}
	public void setSyn_flg(String syn_flg) {
		this.syn_flg = syn_flg;
	}
	public String getData_source() {
		return data_source;
	}
	public void setData_source(String data_source) {
		this.data_source = data_source;
	}
	public String getSyn_id() {
		return syn_id;
	}
	public void setSyn_id(String syn_id) {
		this.syn_id = syn_id;
	}
	public Date getSyn_time() {
		return syn_time;
	}
	public void setSyn_time(Date syn_time) {
		this.syn_time = syn_time;
	}
	public String getData_source_no() {
		return data_source_no;
	}
	public void setData_source_no(String data_source_no) {
		this.data_source_no = data_source_no;
	}
	public String getUpdate_flg() {
		return update_flg;
	}
	public void setUpdate_flg(String update_flg) {
		this.update_flg = update_flg;
	}
	public String getJzzh() {
		return jzzh;
	}
	public void setJzzh(String jzzh) {
		this.jzzh = jzzh;
	}
}

