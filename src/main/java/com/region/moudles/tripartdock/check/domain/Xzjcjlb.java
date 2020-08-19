package com.region.moudles.tripartdock.check.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;
import com.region.until.validate.Validate;


/**
 * @ClassName: Xzjcjlb
 * @Description: 体检-辅助检查
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_xzjcjlb")
public class Xzjcjlb extends BaseDomain {

	private static final long serialVersionUID = 3565469464L;
	
	@Id
	private String id;//
	@Validate(name = { "save" }, required = true)
	@Column(name = "tjbh", updatable = false)
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	@Column(precision = 5, scale = 2)
	private String xhdb;// 血红蛋白
	@Column(precision = 5, scale = 2)
	private String xbxb;// 白细胞
	@Column(precision = 6, scale = 2)
	private String xxb;// 血小板
	@Column(precision = 5, scale = 2)
	private String kfxt;// 尿蛋白
	@Column(precision = 5, scale = 2)
	private String ptt;// 尿糖
	@Column(precision = 5, scale = 2)
	private String ntt;// 尿酮体
	@Column(precision = 5, scale = 2)
	private String nhxb;// 尿潜血
	@Column(precision = 5, scale = 2)
	private String fpgl;// 空腹血糖值（mg/dL)
	private String xdt;// 心电图

	@Column(precision = 5, scale = 2)
	private String bdb;// 尿微量白蛋白
	@Column(length = 1)
	private String tyhxj;// 大便潜血
	@Column(precision = 5, scale = 2)
	private String txhdb;// 糖血红蛋白
	@Column(length = 1)
	private String yxgybmky;// 乙型肝炎表面抗原
	@Column(precision = 7, scale = 2)
	private String xqgasbtszam;// 血清谷氨酸丙酮酸转氨酶
	@Column(precision = 7, scale = 2)
	private String ggnjc;// 血清谷草转氨酶
	@Column(precision = 6, scale = 2)
	private String xy;// 白蛋白
	@Column(precision = 5, scale = 2)
	private String xqzdhs;// 总胆红素
	@Column(precision = 5, scale = 2)
	private String jhdhs;// 结合胆红素
	@Column(precision = 5, scale = 2)
	private String xqjg;// 血清肌酐
	@Column(precision = 5, scale = 2)
	private String xnsd;// 血尿素氮
	@Column(precision = 5, scale = 2)
	private String qmsgms;// 血钾浓度
	@Column(precision = 5, scale = 2)
	private String hype;// 血钠浓度
	@Column(precision = 5, scale = 2)
	private String tc;// 总胆固醇
	@Column(precision = 5, scale = 2)
	private String jzxqdb;// 甘油三脂
	@Column(precision = 5, scale = 2)
	private String ddgc;// 血清低密度脂蛋白胆固醇
	@Column(precision = 5, scale = 2)
	private String gdgc;// 血清高密度脂蛋白胆固醇
	@Column(length = 1)
	private String xbxg;// 胸部X光
	private String bchao;// B超
	private String qtxx;// 血常规其他
	private String qtny;// 尿常规其他
	private String qt;// 其他
	private String zgj;// 宫颈涂片
	private String xxbwlz;// 血小板无力症
	private String xdtms;// 心电图描述
	private String xbxgms;// 胸部X光描述
	private String bchaoms;// B超描述
	private String zgjycms;// 宫颈涂片描述
	@Column(precision = 5, scale = 2)
	private String kfxtz;// 空腹血糖值（mmol/L)
	private String ncg;// 尿常规
	private String qtbc;// 其他B超
	private String qtbcms;// 其他B超描述
	private String xuexing; //ABO血型
	private String rh; //FR阴性

	private String txbgas;// 同型半胱氨酸
	private String fzjcqtys;
	// 中联佳裕字段
	private String afpjtdb; //AFP甲胎蛋白
	private String ceaapky; //CEA癌胚抗原
	private String jzxt3; //甲状腺T3
	private String jzxt4; //甲状腺T4
	private String tjid;
	
	@Transient
	private String xdtText;// 心电图
	@Transient
	private String tyhxjText;// 大便潜血
	@Transient
	private String yxgybmkyText;// 乙型肝炎表面抗原
	@Transient
	private String xbxgText;// 胸部X光
	@Transient
	private String bchaoText;// B超
	@Transient
	private String qtbcText;// 其他B超
	@Transient
	private String zgjText;// 宫颈涂片
	
	
	public String getFzjcqtys() {
		return fzjcqtys;
	}

	public void setFzjcqtys(String fzjcqtys) {
		this.fzjcqtys = fzjcqtys;
	}

	public String getXuexing() {
		return xuexing;
	}

	public void setXuexing(String xuexing) {
		this.xuexing = xuexing;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public String getAfpjtdb() {
		return afpjtdb;
	}

	public void setAfpjtdb(String afpjtdb) {
		this.afpjtdb = afpjtdb;
	}

	public String getJzxt4() {
		return jzxt4;
	}

	public void setJzxt4(String jzxt4) {
		this.jzxt4 = jzxt4;
	}

	public String getCeaapky() {
		return ceaapky;
	}

	public void setCeaapky(String ceaapky) {
		this.ceaapky = ceaapky;
	}

	public String getJzxt3() {
		return jzxt3;
	}

	public void setJzxt3(String jzxt3) {
		this.jzxt3 = jzxt3;
	}

	public String getTxbgas() {
		return txbgas;
	}

	public void setTxbgas(String txbgas) {
		this.txbgas = txbgas;
	}

	public String getQtbc() {
		return qtbc;
	}

	public void setQtbc(String qtbc) {
		this.qtbcText = DictUtil.getDictValue("tj-fzjc-Bc", qtbc);
		this.qtbc = qtbc;
	}

	public String getQtbcms() {
		return qtbcms;
	}

	public void setQtbcms(String qtbcms) {
		this.qtbcms = qtbcms;
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

	public String getXhdb() {
		return this.xhdb;
	}

	public void setXhdb(String xhdb) {
		this.xhdb = xhdb;
	}

	public String getXbxb() {
		return this.xbxb;
	}

	public void setXbxb(String xbxb) {
		this.xbxb = xbxb;
	}

	public String getXxb() {
		return this.xxb;
	}

	public void setXxb(String xxb) {
		this.xxb = xxb;
	}

	public String getKfxt() {
		return this.kfxt;
	}

	public void setKfxt(String kfxt) {
		this.kfxt = kfxt;
	}

	public String getPtt() {
		return this.ptt;
	}

	public void setPtt(String ptt) {
		this.ptt = ptt;
	}

	public String getNtt() {
		return this.ntt;
	}

	public void setNtt(String ntt) {
		this.ntt = ntt;
	}

	public String getNhxb() {
		return this.nhxb;
	}

	public void setNhxb(String nhxb) {
		this.nhxb = nhxb;
	}

	public String getFpgl() {
		return this.fpgl;
	}

	public void setFpgl(String fpgl) {
		this.fpgl = fpgl;
	}

	public String getXdt() {
		return this.xdt;
	}

	public void setXdt(String xdt) {
		this.xdtText = DictUtil.getDictValue("tj-fzjc-xdt", xdt);
		this.xdt = xdt;
	}

	public String getBdb() {
		return this.bdb;
	}

	public void setBdb(String bdb) {
		this.bdb = bdb;
	}

	public String getTyhxj() {
		return this.tyhxj;
	}

	public void setTyhxj(String tyhxj) {
		this.tyhxjText = DictUtil.getDictValue("tj-fzjc-dbqx", tyhxj);
		this.tyhxj = tyhxj;
	}

	public String getTxhdb() {
		return this.txhdb;
	}

	public void setTxhdb(String txhdb) {
		this.txhdb = txhdb;
	}

	public String getYxgybmky() {
		return this.yxgybmky;
	}

	public void setYxgybmky(String yxgybmky) {
		this.yxgybmkyText = DictUtil.getDictValue("tj-fzjc-yxgybmky", yxgybmky);
		this.yxgybmky = yxgybmky;
	}

	public String getXqgasbtszam() {
		return this.xqgasbtszam;
	}

	public void setXqgasbtszam(String xqgasbtszam) {
		this.xqgasbtszam = xqgasbtszam;
	}

	public String getGgnjc() {
		return this.ggnjc;
	}

	public void setGgnjc(String ggnjc) {
		this.ggnjc = ggnjc;
	}

	public String getXy() {
		return this.xy;
	}

	public void setXy(String xy) {
		this.xy = xy;
	}

	public String getXqzdhs() {
		return this.xqzdhs;
	}

	public void setXqzdhs(String xqzdhs) {
		this.xqzdhs = xqzdhs;
	}

	public String getJhdhs() {
		return this.jhdhs;
	}

	public void setJhdhs(String jhdhs) {
		this.jhdhs = jhdhs;
	}

	public String getXqjg() {
		return this.xqjg;
	}

	public void setXqjg(String xqjg) {
		this.xqjg = xqjg;
	}

	public String getXnsd() {
		return this.xnsd;
	}

	public void setXnsd(String xnsd) {
		this.xnsd = xnsd;
	}

	public String getQmsgms() {
		return this.qmsgms;
	}

	public void setQmsgms(String qmsgms) {
		this.qmsgms = qmsgms;
	}

	public String getHype() {
		return this.hype;
	}

	public void setHype(String hype) {
		this.hype = hype;
	}

	public String getTc() {
		return this.tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getJzxqdb() {
		return this.jzxqdb;
	}

	public void setJzxqdb(String jzxqdb) {
		this.jzxqdb = jzxqdb;
	}

	public String getDdgc() {
		return this.ddgc;
	}

	public void setDdgc(String ddgc) {
		this.ddgc = ddgc;
	}

	public String getGdgc() {
		return this.gdgc;
	}

	public void setGdgc(String gdgc) {
		this.gdgc = gdgc;
	}

	public String getXbxg() {
		return this.xbxg;
	}

	public void setXbxg(String xbxg) {
		this.xbxgText = DictUtil.getDictValue("tj-fzjc-xbXxp", xbxg);
		this.xbxg = xbxg;
	}

	public String getBchao() {
		return this.bchao;
	}

	public void setBchao(String bchao) {
		this.bchaoText = DictUtil.getDictValue("tj-fzjc-Bc", bchao);
		this.bchao = bchao;
	}

	public String getQtxx() {
		return this.qtxx;
	}

	public void setQtxx(String qtxx) {
		this.qtxx = qtxx;
	}

	public String getQtny() {
		return this.qtny;
	}

	public void setQtny(String qtny) {
		this.qtny = qtny;
	}

	public String getQt() {
		return this.qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getZgj() {
		return this.zgj;
	}

	public void setZgj(String zgj) {
		this.zgjText = DictUtil.getDictValue("tj-fzjc-gjtp", zgj);
		this.zgj = zgj;
	}

	public String getXxbwlz() {
		return this.xxbwlz;
	}

	public void setXxbwlz(String xxbwlz) {
		this.xxbwlz = xxbwlz;
	}

	public String getXdtms() {
		return this.xdtms;
	}

	public void setXdtms(String xdtms) {
		this.xdtms = xdtms;
	}

	public String getXbxgms() {
		return this.xbxgms;
	}

	public void setXbxgms(String xbxgms) {
		this.xbxgms = xbxgms;
	}

	public String getBchaoms() {
		return this.bchaoms;
	}

	public void setBchaoms(String bchaoms) {
		this.bchaoms = bchaoms;
	}

	public String getZgjycms() {
		return this.zgjycms;
	}

	public void setZgjycms(String zgjycms) {
		this.zgjycms = zgjycms;
	}

	public String getKfxtz() {
		return this.kfxtz;
	}

	public void setKfxtz(String kfxtz) {
		this.kfxtz = kfxtz;
	}

	public String getNcg() {
		return this.ncg;
	}

	public void setNcg(String ncg) {
		this.ncg = ncg;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}

	public String getXdtText() {
		return xdtText;
	}

	public void setXdtText(String xdtText) {
		this.xdtText = xdtText;
	}

	public String getTyhxjText() {
		return tyhxjText;
	}

	public void setTyhxjText(String tyhxjText) {
		this.tyhxjText = tyhxjText;
	}

	public String getYxgybmkyText() {
		return yxgybmkyText;
	}

	public void setYxgybmkyText(String yxgybmkyText) {
		this.yxgybmkyText = yxgybmkyText;
	}

	public String getXbxgText() {
		return xbxgText;
	}

	public void setXbxgText(String xbxgText) {
		this.xbxgText = xbxgText;
	}

	public String getBchaoText() {
		return bchaoText;
	}

	public void setBchaoText(String bchaoText) {
		this.bchaoText = bchaoText;
	}

	public String getQtbcText() {
		return qtbcText;
	}

	public void setQtbcText(String qtbcText) {
		this.qtbcText = qtbcText;
	}

	public String getZgjText() {
		return zgjText;
	}

	public void setZgjText(String zgjText) {
		this.zgjText = zgjText;
	}

}
