package com.region.moudles.tripartdock.follow.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;


/**
 * @ClassName: FollowYcfScFzjc
 * @Description: 随访-孕产妇-首次随访-辅助检查
 * @author Administrator
 * @date 2019年8月2日
 */
@Entity
@Table(name = "blt_fzjcxxb")
public class FollowYcfScFzjc extends BaseDomain {

	private static final long serialVersionUID = 13346494966L;
	
	@Id
	private String id;//ID
	private String tjbh;// null
	private String yfbh;// 孕妇编号
	private String dah;// 档案号
	private String sfzh;// 身份证号
	private String xhdb;// 血红蛋白
	private String bxb;// 白细胞
	private String xxb;// 血小板
	private String xcgqt;// 血常规其他
	private String kfxt;// 尿蛋白定量检测值
	private String ptt;// 葡萄糖
	private String tt;// 酮体
	private String qx;// 潜血
	private String ncgqt;// 尿常规其他
	private String xx;// 血型
	private String rh;// rh类型
	private String fpgl;//血糖检测值
	private String xqgbzam;// 血清谷丙转氨酶
	private String xqgczam;// 血清谷草转氨酶
	private String bdb;// 白蛋白
	private String zdhs;// 总胆红素
	private String jhdhs;// 结合胆红素
	private String xqjg;// 血清肌酐
	private String xnsd;// 血尿素氮
	private String ydfmw;// 阴道分泌物
	private String qtydfmw;// 其他阴道分泌物
	private String ydqjd;// 阴道清洁度
	private String yxgybmky;// 乙型肝炎表面抗原
	private String yxgybmkt;// 乙型肝炎表面抗体
	private String yxgyyky;// 乙型肝炎e抗原
	private String yxgyekt;// 乙型肝炎e抗体
	private String yxgyhxkt;// 乙型肝炎核心抗体
	private String mdxqxsy;// 梅毒血清学实验
	private String hiv;// hiv抗体检测
	private String bchao;// B超
	private String jbr;// 建表人
	private Date jbrq;// 建表日期
	private String scxgr;// 上次修改人
	private Date scxgrq;// 上次修改日期
	private String sfsc;// 是否删除
	private String synFlg; //上传标识
	
	private String qt;//其他


	@Transient
	private String xxName;
	@Transient
	private String rhName;
	@Transient
	private String ydfmwName;
	@Transient
	private String ydqjdName;
	@Transient
	private String mdxqxsyName;
	@Transient
	private String hivName;

	public String getXxName() {
		return DictUtil.getDictValue("ycf-xx", this.xx);
	}

	public void setXxName(String xxName) {
		this.xxName = xxName;
	}

	public String getRhName() {
		return DictUtil.getDictValue("da-RHyx", this.rh);
	}

	public void setRhName(String rhName) {
		this.rhName = rhName;
	}

	public String getYdfmwName() {
		return DictUtil.getDictValue("ycf-ydfmw", this.ydfmw);
	}

	public void setYdfmwName(String ydfmwName) {
		this.ydfmwName = ydfmwName;
	}

	public String getYdqjdName() {
		return DictUtil.getDictValue("ycf-ydqjd", this.ydqjd);
	}

	public void setYdqjdName(String ydqjdName) {
		this.ydqjdName = ydqjdName;
	}

	public String getMdxqxsyName() {
		return DictUtil.getDictValue("tj-fzjc-yxgybmky", this.mdxqxsy);
	}

	public void setMdxqxsyName(String mdxqxsyName) {
		this.mdxqxsyName = mdxqxsyName;
	}

	public String getHivName() {
		return DictUtil.getDictValue("tj-fzjc-yxgybmky", this.hiv);
	}

	public void setHivName(String hivName) {
		this.hivName = hivName;
	}



	public String getSynFlg() {
		return synFlg;
	}

	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}

	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
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

	public String getXhdb() {
		return this.xhdb;
	}

	public void setXhdb(String xhdb) {
		this.xhdb = xhdb;
	}

	public String getBxb() {
		return this.bxb;
	}

	public void setBxb(String bxb) {
		this.bxb = bxb;
	}

	public String getXxb() {
		return this.xxb;
	}

	public void setXxb(String xxb) {
		this.xxb = xxb;
	}

	public String getXcgqt() {
		return this.xcgqt;
	}

	public void setXcgqt(String xcgqt) {
		this.xcgqt = xcgqt;
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

	public String getTt() {
		return this.tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	public String getQx() {
		return this.qx;
	}

	public void setQx(String qx) {
		this.qx = qx;
	}

	public String getNcgqt() {
		return this.ncgqt;
	}

	public void setNcgqt(String ncgqt) {
		this.ncgqt = ncgqt;
	}

	public String getXx() {
		return this.xx;
	}

	public void setXx(String xx) {
		this.xx = xx;
	}

	public String getRh() {
		return this.rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public String getFpgl() {
		return this.fpgl;
	}

	public void setFpgl(String fpgl) {
		this.fpgl = fpgl;
	}

	public String getXqgbzam() {
		return this.xqgbzam;
	}

	public void setXqgbzam(String xqgbzam) {
		this.xqgbzam = xqgbzam;
	}

	public String getXqgczam() {
		return this.xqgczam;
	}

	public void setXqgczam(String xqgczam) {
		this.xqgczam = xqgczam;
	}

	public String getBdb() {
		return this.bdb;
	}

	public void setBdb(String bdb) {
		this.bdb = bdb;
	}

	public String getZdhs() {
		return this.zdhs;
	}

	public void setZdhs(String zdhs) {
		this.zdhs = zdhs;
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

	public String getYdfmw() {
		return this.ydfmw;
	}

	public void setYdfmw(String ydfmw) {
		this.ydfmw = ydfmw;
	}

	public String getQtydfmw() {
		return this.qtydfmw;
	}

	public void setQtydfmw(String qtydfmw) {
		this.qtydfmw = qtydfmw;
	}

	public String getYdqjd() {
		return this.ydqjd;
	}

	public void setYdqjd(String ydqjd) {
		this.ydqjd = ydqjd;
	}

	public String getYxgybmky() {
		return this.yxgybmky;
	}

	public void setYxgybmky(String yxgybmky) {
		this.yxgybmky = yxgybmky;
	}

	public String getYxgybmkt() {
		return this.yxgybmkt;
	}

	public void setYxgybmkt(String yxgybmkt) {
		this.yxgybmkt = yxgybmkt;
	}

	public String getYxgyyky() {
		return this.yxgyyky;
	}

	public void setYxgyyky(String yxgyyky) {
		this.yxgyyky = yxgyyky;
	}

	public String getYxgyekt() {
		return this.yxgyekt;
	}

	public void setYxgyekt(String yxgyekt) {
		this.yxgyekt = yxgyekt;
	}

	public String getYxgyhxkt() {
		return this.yxgyhxkt;
	}

	public void setYxgyhxkt(String yxgyhxkt) {
		this.yxgyhxkt = yxgyhxkt;
	}

	public String getMdxqxsy() {
		return this.mdxqxsy;
	}

	public void setMdxqxsy(String mdxqxsy) {
		this.mdxqxsy = mdxqxsy;
	}

	public String getHiv() {
		return this.hiv;
	}

	public void setHiv(String hiv) {
		this.hiv = hiv;
	}

	public String getBchao() {
		return this.bchao;
	}

	public void setBchao(String bchao) {
		this.bchao = bchao;
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

	public String getSfsc() {
		return this.sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}

}
