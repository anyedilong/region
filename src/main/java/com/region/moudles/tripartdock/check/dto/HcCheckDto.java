package com.region.moudles.tripartdock.check.dto;

import java.io.Serializable;

import com.region.until.DictUtil;

/**
 * @author sen
 * @version 1.0.0
 * @ClassName Check
 * @Date 2017年6月12日 上午9:43:41
 */
public class HcCheckDto implements Serializable {

	private static final long serialVersionUID = 654613313213L;

	private String id;
	private String hzmc;
	private String jcrq;
	private String tjdw;
	private String ys;
	private String sfzh;
	private String tjbh;
	private String bmi;
	private String zcxy;
	private String ycxy;
	private String xl;
	private String xtz;
	private String jkzd;
	private String wxkz;
	private String jkpj;
	private String gb;
	private String zdjy;
	private String qt;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHzmc() {
		return hzmc;
	}

	public void setHzmc(String hzmc) {
		this.hzmc = hzmc;
	}

	public String getJcrq() {
		return jcrq;
	}

	public void setJcrq(String jcrq) {
		this.jcrq = jcrq;
	}

	public String getTjdw() {
		return tjdw;
	}

	public void setTjdw(String tjdw) {
		this.tjdw = tjdw;
	}

	public String getYs() {
		return ys;
	}

	public void setYs(String ys) {
		this.ys = ys;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getTjbh() {
		return tjbh;
	}

	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getZcxy() {
		return zcxy;
	}

	public void setZcxy(String zcxy) {
		this.zcxy = zcxy;
	}

	public String getYcxy() {
		return ycxy;
	}

	public void setYcxy(String ycxy) {
		this.ycxy = ycxy;
	}

	public String getXl() {
		return xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	public String getXtz() {
		return xtz;
	}

	public void setXtz(String xtz) {
		this.xtz = xtz;
	}

	public String getJkzd() {
        return jkzd;
    }

    public void setJkzd(String jkzd) {
    	this.jkzd = DictUtil.getDictValue("tj-jkzd", jkzd);
    }

    public String getWxkz() {
        return wxkz;
    }

    public void setWxkz(String wxkz) {
    	this.wxkz = DictUtil.getDictValue("tj-jkzd-wxys", wxkz);
    }

    public String getJkpj() {
		return jkpj;
	}

	public void setJkpj(String jkpj) {
		this.jkpj = jkpj;
	}

	public String getGb() {
		return gb;
	}

	public void setGb(String gb) {
		this.gb = gb;
	}

	public String getZdjy() {
		return zdjy;
	}

	public void setZdjy(String zdjy) {
		this.zdjy = zdjy;
	}

	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}
}
