package com.region.moudles.tripartdock.check.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @ClassName: Pgzdjlb
 * @Description: 体检-评估指导
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_pgzdjlb")
public class Pgzdjlb extends BaseDomain {

	private static final long serialVersionUID = 3646489461616L;
	
	@Id
	private String id;//
	@Column(length = 20)
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	@Column(length = 1)
	private String sfzc;// 是否正常
	private String jkzdms;//健康指导描述
	private String jkzd;// 健康指导
	private String wxkz;// 危险控制
	private String yc1;// 异常1
	private String yc2;// 异常2
	private String yc3;// 异常3
	private String gb;// 目标体重
	private String jfw;// 减腹围cm
	private String zdjy;// 建议接种疫苗
	private String qt;// 其他
	private String yc4;// 异常4
	
	// 青岛中联佳裕字段
	private String cfrs; //吃饭人数
	private String etrs; //儿童人数
	private String pjsyl; //平均食盐量
	private String sjyl; //食酱油量
	private String tjid;

	@Transient
	private String sfzcText;// 是否正常
	@Transient
	private String jkzdText;
	@Transient
	private String wxkzText;
	
	public String getJfw() {
		return jfw;
	}

	public void setJfw(String jfw) {
		this.jfw = jfw;
	}

	public String getCfrs() {
		return cfrs;
	}

	public void setCfrs(String cfrs) {
		this.cfrs = cfrs;
	}

	public String getEtrs() {
		return etrs;
	}

	public void setEtrs(String etrs) {
		this.etrs = etrs;
	}

	public String getPjsyl() {
		return pjsyl;
	}

	public void setPjsyl(String pjsyl) {
		this.pjsyl = pjsyl;
	}

	public String getSjyl() {
		return sjyl;
	}

	public void setSjyl(String sjyl) {
		this.sjyl = sjyl;
	}

	public String getJkzdms() {
		return jkzdms;
	}

	public void setJkzdms(String jkzdms) {
		this.jkzdms = jkzdms;
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

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getSfzc() {
		return this.sfzc;
	}

	public void setSfzc(String sfzc) {
		this.sfzcText = DictUtil.getDictValue("tj-jkpj", sfzc);
		this.sfzc = sfzc;
	}

	public String getJkzd() {
		return this.jkzd;
	}

	public void setJkzd(String jkzd) {
		this.jkzdText = DictUtil.getDictValue("tj-jkzd", jkzd);
		this.jkzd = jkzd;
	}

	public String getWxkz() {
		return this.wxkz;
	}

	public void setWxkz(String wxkz) {
		this.wxkzText = DictUtil.getDictValue("tj-jkzd-wxys", wxkz);
		this.wxkz = wxkz;
	}

	public String getYc1() {
		return this.yc1;
	}

	public void setYc1(String yc1) {
		this.yc1 = yc1;
	}

	public String getYc2() {
		return this.yc2;
	}

	public void setYc2(String yc2) {
		this.yc2 = yc2;
	}

	public String getYc3() {
		return this.yc3;
	}

	public void setYc3(String yc3) {
		this.yc3 = yc3;
	}

	public String getGb() {
		return this.gb;
	}

	public void setGb(String gb) {
		this.gb = gb;
	}

	public String getZdjy() {
		return this.zdjy;
	}

	public void setZdjy(String zdjy) {
		this.zdjy = zdjy;
	}

	public String getQt() {
		return this.qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getYc4() {
		return this.yc4;
	}

	public void setYc4(String yc4) {
		this.yc4 = yc4;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}

	public String getSfzcText() {
		return sfzcText;
	}

	public void setSfzcText(String sfzcText) {
		this.sfzcText = sfzcText;
	}

	public String getJkzdText() {
		return jkzdText;
	}

	public void setJkzdText(String jkzdText) {
		this.jkzdText = jkzdText;
	}

	public String getWxkzText() {
		return wxkzText;
	}

	public void setWxkzText(String wxkzText) {
		this.wxkzText = wxkzText;
	}
}
