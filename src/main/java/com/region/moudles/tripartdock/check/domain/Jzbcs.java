package com.region.moudles.tripartdock.check.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: Jzbcs
 * @Description: 体检-家族病床史
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_jzbcs")
public class Jzbcs extends BaseDomain {

	private static final long serialVersionUID = 366666661455L;
	
	@Id
	private String id;//
	@Column(length = 20)
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	private String szyymc;// 所住医院名称
	@JSONField(format="yyyy-MM-dd")
	private Date zyrq;// 住院日期
	private String bfcs;// 病案号
	private String fbyy;// 发病原因
	@JSONField(format="yyyy-MM-dd")
	private Date cyrq;// 出院日期
	private String tjid;

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

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getSzyymc() {
		return this.szyymc;
	}

	public void setSzyymc(String szyymc) {
		this.szyymc = szyymc;
	}

	public Date getZyrq() {
		return this.zyrq;
	}

	public void setZyrq(Date zyrq) {
		this.zyrq = zyrq;
	}

	public String getBfcs() {
		return this.bfcs;
	}

	public void setBfcs(String bfcs) {
		this.bfcs = bfcs;
	}

	public String getFbyy() {
		return this.fbyy;
	}

	public void setFbyy(String fbyy) {
		this.fbyy = fbyy;
	}

	public Date getCyrq() {
		return this.cyrq;
	}

	public void setCyrq(Date cyrq) {
		this.cyrq = cyrq;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}
	

}
