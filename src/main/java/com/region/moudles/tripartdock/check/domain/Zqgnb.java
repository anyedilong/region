package com.region.moudles.tripartdock.check.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @ClassName: Zqgnb
 * @Description: 体检-脏器功能
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_zqgnb")
public class Zqgnb extends BaseDomain {

	private static final long serialVersionUID = 1654464863166L;
	
	@Id
	private String id;//
	@Column(length = 20)
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	private String kc;// 口唇
	private String cl;// 齿列
	private String qtcl;// 其他齿列
	private String yb;// 咽部
	@Column(precision = 3, scale = 1)
	private String zysl;// 左眼视力
	private String tl;// 听力
	@Column(precision = 3, scale = 1)
	private String yysl;// 右眼视力
	@Column(length = 1)
	private String ydgn;// 运动功能
	@Column(precision = 3, scale = 1)
	private String zyjzsl;// 左眼矫正视力
	@Column(precision = 3, scale = 1)
	private String yyjzsl;// 右眼矫正视力

	@Column(name="qc_shang")
	private String qcShang  ;//缺齿左上
	@Column(name="qc_xia")
	private String qcXia ;//缺齿右上
	@Column(name="qc_zuo")
	private String qcZuo  ;//缺齿左下
	@Column(name="qc_you")
	private String qcYou  ;//缺齿右下
	@Column(name="quc_zs")
	private String qucZs ;//龋齿左上
	@Column(name="quc_zx")
	private String qucZx ;//龋齿右下
	@Column(name="quc_yx")
	private String qucYx  ;//龋齿左下
	@Column(name="quc_ys")
	private String qucYs  ;//龋齿右上
	@Column(name="yc_zs")
	private String ycZs ;//义齿左上
	@Column(name="yc_zx")
	private String ycZx  ;//义齿左下
	@Column(name="yc_ys")
	private String ycYs  ;//义齿右上
	@Column(name="yc_yx")
	private String ycYx ;//义齿右下
	
	private String qcqk="0";//缺齿全口
	private String ycqk="0";//义齿全口
	private String tjid;

	@Transient
	private String kcText;// 口唇
	@Transient
	private String clText;// 齿列
	@Transient
	private String ybText;// 咽部
	@Transient
	private String tlText;// 听力
	@Transient
	private String ydgnText;// 运动功能
	
	public String getQcqk() {
		return qcqk;
	}

	public void setQcqk(String qcqk) {
		this.qcqk = qcqk;
	}

	public String getYcqk() {
		return ycqk;
	}

	public void setYcqk(String ycqk) {
		this.ycqk = ycqk;
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

	public String getKc() {
		return this.kc;
	}

	public void setKc(String kc) {
		this.kcText = DictUtil.getDictValue("tj-qggn-kq-kc", kc);
		this.kc = kc;
	}

	public String getCl() {
		return this.cl;
	}

	public void setCl(String cl) {
		this.clText = DictUtil.getDictValue("tj-zqgn-kq-cl", cl);
		this.cl = cl;
	}

	public String getQtcl() {
		return this.qtcl;
	}

	public void setQtcl(String qtcl) {
		this.qtcl = qtcl;
	}

	public String getYb() {
		return this.yb;
	}

	public void setYb(String yb) {
		this.ybText = DictUtil.getDictValue("tj-zqgn-kq-yb", yb);
		this.yb = yb;
	}

	public String getZysl() {
		return this.zysl;
	}

	public void setZysl(String zysl) {
		this.zysl = zysl;
	}

	public String getTl() {
		return this.tl;
	}

	public void setTl(String tl) {
		this.tlText = DictUtil.getDictValue("tj-zqgn-tl", tl);
		this.tl = tl;
	}

	public String getYysl() {
		return this.yysl;
	}

	public void setYysl(String yysl) {
		this.yysl = yysl;
	}

	public String getYdgn() {
		return this.ydgn;
	}

	public void setYdgn(String ydgn) {
		this.ydgnText = DictUtil.getDictValue("tj-zqgn-ydgn", ydgn);
		this.ydgn = ydgn;
	}

	public String getZyjzsl() {
		return this.zyjzsl;
	}

	public void setZyjzsl(String zyjzsl) {
		this.zyjzsl = zyjzsl;
	}

	public String getYyjzsl() {
		return this.yyjzsl;
	}

	public void setYyjzsl(String yyjzsl) {
		this.yyjzsl = yyjzsl;
	}

	public String getQcShang() {
		return qcShang;
	}

	public void setQcShang(String qcShang) {
		this.qcShang = qcShang;
	}

	public String getQcXia() {
		return qcXia;
	}

	public void setQcXia(String qcXia) {
		this.qcXia = qcXia;
	}

	public String getQcZuo() {
		return qcZuo;
	}

	public void setQcZuo(String qcZuo) {
		this.qcZuo = qcZuo;
	}

	public String getQcYou() {
		return qcYou;
	}

	public void setQcYou(String qcYou) {
		this.qcYou = qcYou;
	}

	public String getQucZs() {
		return qucZs;
	}

	public void setQucZs(String qucZs) {
		this.qucZs = qucZs;
	}

	public String getQucZx() {
		return qucZx;
	}

	public void setQucZx(String qucZx) {
		this.qucZx = qucZx;
	}

	public String getQucYx() {
		return qucYx;
	}

	public void setQucYx(String qucYx) {
		this.qucYx = qucYx;
	}

	public String getQucYs() {
		return qucYs;
	}

	public void setQucYs(String qucYs) {
		this.qucYs = qucYs;
	}

	public String getYcZs() {
		return ycZs;
	}

	public void setYcZs(String ycZs) {
		this.ycZs = ycZs;
	}

	public String getYcZx() {
		return ycZx;
	}

	public void setYcZx(String ycZx) {
		this.ycZx = ycZx;
	}

	public String getYcYs() {
		return ycYs;
	}

	public void setYcYs(String ycYs) {
		this.ycYs = ycYs;
	}

	public String getYcYx() {
		return ycYx;
	}

	public void setYcYx(String ycYx) {
		this.ycYx = ycYx;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}

	public String getKcText() {
		return kcText;
	}

	public void setKcText(String kcText) {
		this.kcText = kcText;
	}

	public String getClText() {
		return clText;
	}

	public void setClText(String clText) {
		this.clText = clText;
	}

	public String getYbText() {
		return ybText;
	}

	public void setYbText(String ybText) {
		this.ybText = ybText;
	}

	public String getTlText() {
		return tlText;
	}

	public void setTlText(String tlText) {
		this.tlText = tlText;
	}

	public String getYdgnText() {
		return ydgnText;
	}

	public void setYdgnText(String ydgnText) {
		this.ydgnText = ydgnText;
	}

}
