package com.region.moudles.tripartdock.check.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @ClassName: Jkjc
 * @Description: 体检-健康检查
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_jkjc")
public class Jkjc extends BaseDomain {

	private static final long serialVersionUID = 64686464665252L;
	
	@Id
	private String id;//
	@Column(length = 20)
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	private String pf;// 皮肤
	private String gm;// 巩膜
	private String lbj;// 淋巴结
	private String tzx;// 桶状胸
	private String hxy;// 呼吸音
	private String ly;// 罗音
	
	private String xl;// 心率
	private String xlv;// 心律
	private String zy;// 杂音
	private String bk;// 包块
	private String xzsz;// 下肢水肿
	private String zbdmbd;// 足背动脉搏动
	private String gmzz;// 肛门指诊
	private String rx;// 乳腺
	private String wy;// 外阴
	private String yd;// 阴道
	private String gj;// 宫颈
	private String gt;// 宫体
	private String fj;// 附件
	private String qt;// 其他
	private String yt;// 压痛
	private String gd;// 肝大
	private String pd;// 脾大
	private String ydxzy;// 移动性浊音
	private String qtpfycms;// 其他皮肤异常描述
	private String qtgmycms;// 其他巩膜异常描述
	private String qtlbjycms;// 其他淋巴结异常描述
	private String rxycms;// 乳腺异常描述
	private String gmycms;// 肛门异常描述
	private String hxyms;// 呼吸音描述
	private String lyns;// 罗音描述
	private String zyms;// 杂音描述
	private String zgjycms;// 子宫颈异常描述
	private String gtycms;// 宫体异常描述
	private String fjycms;// 附件异常描述
	private String wyycms;// 外阴异常描述
	private String ydycms;// 阴道异常描述
	private String ytycms;// 压痛异常描述
	private String gdycms;// 肝大异常描述
	private String pdms;// 脾大描述
	private String ydxzyms;// 移动性浊音描述
	private String bkycms;// 包块异常描述
	private String yandi;// 眼底
	private String yandycms;// 眼底异常描述
	private String tjid;

	@Transient
	private String pfText;// 皮肤
	@Transient
	private String gmText;// 巩膜
	@Transient
	private String lbjText;// 淋巴结
	@Transient
	private String tzxText;// 桶状胸
	@Transient
	private String hxyText;// 呼吸音
	@Transient
	private String lyText;// 罗音
	@Transient
	private String xlvText;// 心律
	@Transient
	private String zyText;// 杂音
	@Transient
	private String bkText;// 包块
	@Transient
	private String xzszText;// 下肢水肿
	@Transient
	private String zbdmbdText;// 足背动脉搏动
	@Transient
	private String gmzzText;// 肛门指诊
	@Transient
	private String rxText;// 乳腺
	@Transient
	private String wyText;// 外阴
	@Transient
	private String ydText;// 阴道
	@Transient
	private String gjText;// 宫颈
	@Transient
	private String gtText;// 宫体
	@Transient
	private String fjText;// 附件
	@Transient
	private String ytText;// 压痛
	@Transient
	private String gdText;// 肝大
	@Transient
	private String pdText;// 脾大
	@Transient
	private String ydxzyText;// 移动性浊音 
	@Transient
	private String yandiText;// 眼底
	
	
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

	public String getPf() {
		return this.pf;
	}

	public void setPf(String pf) {
		this.pfText = DictUtil.getDictValue("tj-ct-pf", pf);
		this.pf = pf;
	}

	public String getGm() {
		return this.gm;
	}

	public void setGm(String gm) {
		this.gmText = DictUtil.getDictValue("tj-ct-gm", gm);
		this.gm = gm;
	}

	public String getLbj() {
		return this.lbj;
	}

	public void setLbj(String lbj) {
		this.lbjText = DictUtil.getDictValue("tj-ct-lbj", lbj);
		this.lbj = lbj;
	}

	public String getTzx() {
		return this.tzx;
	}

	public void setTzx(String tzx) {
		this.tzxText = DictUtil.getDictValue("tj-ct-f-tzx", tzx);
		this.tzx = tzx;
	}

	public String getHxy() {
		return this.hxy;
	}

	public void setHxy(String hxy) {
		this.hxyText = DictUtil.getDictValue("tj-ct-f-hxy", hxy);
		this.hxy = hxy;
	}

	public String getLy() {
		return this.ly;
	}

	public void setLy(String ly) {
		this.lyText = DictUtil.getDictValue("tj-ct-f-ly", ly);
		this.ly = ly;
	}
	public String getXl() {
		return xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	public String getXlv() {
		return this.xlv;
	}

	public void setXlv(String xlv) {
		this.xlvText = DictUtil.getDictValue("tj-ct-xz-xl", xlv);
		this.xlv = xlv;
	}

	public String getZy() {
		return this.zy;
	}

	public void setZy(String zy) {
		this.zyText = DictUtil.getDictValue("tj-ct-xz-zy", zy);
		this.zy = zy;
	}

	public String getBk() {
		return this.bk;
	}

	public void setBk(String bk) {
		this.bkText = DictUtil.getDictValue("tj-ct-fb-bk", bk);
		this.bk = bk;
	}

	public String getXzsz() {
		return this.xzsz;
	}

	public void setXzsz(String xzsz) {
		this.xzszText = DictUtil.getDictValue("tj-ct-xzsz", xzsz);
		this.xzsz = xzsz;
	}

	public String getZbdmbd() {
		return this.zbdmbd;
	}

	public void setZbdmbd(String zbdmbd) {
		this.zbdmbdText = DictUtil.getDictValue("tj-ct-zbdmbd", zbdmbd);
		this.zbdmbd = zbdmbd;
	}

	public String getGmzz() {
		return this.gmzz;
	}

	public void setGmzz(String gmzz) {
		this.gmzzText = DictUtil.getDictValue("tj-ct-gmzz", gmzz);
		this.gmzz = gmzz;
	}

	public String getRx() {
		return this.rx;
	}

	public void setRx(String rx) {
		this.rxText = DictUtil.getDictValue("tj-ct-rx", rx);
		this.rx = rx;
	}

	public String getWy() {
		return this.wy;
	}

	public void setWy(String wy) {
		this.wyText = DictUtil.getDictValue("tj-ct-fk-wy", wy);
		this.wy = wy;
	}

	public String getYd() {
		return this.yd;
	}

	public void setYd(String yd) {
		this.ydText = DictUtil.getDictValue("tj-ct-fk-yd", yd);
		this.yd = yd;
	}

	public String getGj() {
		return this.gj;
	}

	public void setGj(String gj) {
		this.gjText = DictUtil.getDictValue("tj-ct-fk-gj", gj);
		this.gj = gj;
	}

	public String getGt() {
		return this.gt;
	}

	public void setGt(String gt) {
		this.gtText = DictUtil.getDictValue("tj-ct-fk-gt", gt);
		this.gt = gt;
	}

	public String getFj() {
		return this.fj;
	}

	public void setFj(String fj) {
		this.fjText = DictUtil.getDictValue("tj-ct-fk-fj", fj);
		this.fj = fj;
	}

	public String getQt() {
		return this.qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getYt() {
		return this.yt;
	}

	public void setYt(String yt) {
		this.ytText = DictUtil.getDictValue("tj-ct-fb-yt", yt);
		this.yt = yt;
	}

	public String getGd() {
		return this.gd;
	}

	public void setGd(String gd) {
		this.gdText = DictUtil.getDictValue("tj-ct-fb-gd", gd);
		this.gd = gd;
	}

	public String getPd() {
		return this.pd;
	}

	public void setPd(String pd) {
		this.pdText = DictUtil.getDictValue("tj-ct-fb-pd", pd);
		this.pd = pd;
	}

	public String getYdxzy() {
		return this.ydxzy;
	}

	public void setYdxzy(String ydxzy) {
		this.ydxzyText = DictUtil.getDictValue("tj-ct-fb-ydxzy", ydxzy);
		this.ydxzy = ydxzy;
	}

	public String getQtpfycms() {
		return this.qtpfycms;
	}

	public void setQtpfycms(String qtpfycms) {
		this.qtpfycms = qtpfycms;
	}

	public String getQtgmycms() {
		return this.qtgmycms;
	}

	public void setQtgmycms(String qtgmycms) {
		this.qtgmycms = qtgmycms;
	}

	public String getQtlbjycms() {
		return this.qtlbjycms;
	}

	public void setQtlbjycms(String qtlbjycms) {
		this.qtlbjycms = qtlbjycms;
	}

	public String getRxycms() {
		return this.rxycms;
	}

	public void setRxycms(String rxycms) {
		this.rxycms = rxycms;
	}

	public String getGmycms() {
		return this.gmycms;
	}

	public void setGmycms(String gmycms) {
		this.gmycms = gmycms;
	}

	public String getHxyms() {
		return this.hxyms;
	}

	public void setHxyms(String hxyms) {
		this.hxyms = hxyms;
	}

	public String getLyns() {
		return this.lyns;
	}

	public void setLyns(String lyns) {
		this.lyns = lyns;
	}

	public String getZyms() {
		return this.zyms;
	}

	public void setZyms(String zyms) {
		this.zyms = zyms;
	}

	public String getZgjycms() {
		return this.zgjycms;
	}

	public void setZgjycms(String zgjycms) {
		this.zgjycms = zgjycms;
	}

	public String getGtycms() {
		return this.gtycms;
	}

	public void setGtycms(String gtycms) {
		this.gtycms = gtycms;
	}

	public String getFjycms() {
		return this.fjycms;
	}

	public void setFjycms(String fjycms) {
		this.fjycms = fjycms;
	}

	public String getWyycms() {
		return this.wyycms;
	}

	public void setWyycms(String wyycms) {
		this.wyycms = wyycms;
	}

	public String getYdycms() {
		return this.ydycms;
	}

	public void setYdycms(String ydycms) {
		this.ydycms = ydycms;
	}

	public String getYtycms() {
		return this.ytycms;
	}

	public void setYtycms(String ytycms) {
		this.ytycms = ytycms;
	}

	public String getGdycms() {
		return this.gdycms;
	}

	public void setGdycms(String gdycms) {
		this.gdycms = gdycms;
	}

	public String getPdms() {
		return this.pdms;
	}

	public void setPdms(String pdms) {
		this.pdms = pdms;
	}

	public String getYdxzyms() {
		return this.ydxzyms;
	}

	public void setYdxzyms(String ydxzyms) {
		this.ydxzyms = ydxzyms;
	}

	public String getBkycms() {
		return this.bkycms;
	}

	public void setBkycms(String bkycms) {
		this.bkycms = bkycms;
	}

	public String getYandi() {
		return this.yandi;
	}

	public void setYandi(String yandi) {
		this.yandiText = DictUtil.getDictValue("tj-ct-yd", yandi);
		this.yandi = yandi;
	}

	public String getYandycms() {
		return this.yandycms;
	}

	public void setYandycms(String yandycms) {
		this.yandycms = yandycms;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}

	public String getPfText() {
		return pfText;
	}

	public void setPfText(String pfText) {
		this.pfText = pfText;
	}

	public String getGmText() {
		return gmText;
	}

	public void setGmText(String gmText) {
		this.gmText = gmText;
	}

	public String getLbjText() {
		return lbjText;
	}

	public void setLbjText(String lbjText) {
		this.lbjText = lbjText;
	}

	public String getTzxText() {
		return tzxText;
	}

	public void setTzxText(String tzxText) {
		this.tzxText = tzxText;
	}

	public String getHxyText() {
		return hxyText;
	}

	public void setHxyText(String hxyText) {
		this.hxyText = hxyText;
	}

	public String getLyText() {
		return lyText;
	}

	public void setLyText(String lyText) {
		this.lyText = lyText;
	}

	public String getXlvText() {
		return xlvText;
	}

	public void setXlvText(String xlvText) {
		this.xlvText = xlvText;
	}

	public String getZyText() {
		return zyText;
	}

	public void setZyText(String zyText) {
		this.zyText = zyText;
	}

	public String getBkText() {
		return bkText;
	}

	public void setBkText(String bkText) {
		this.bkText = bkText;
	}

	public String getXzszText() {
		return xzszText;
	}

	public void setXzszText(String xzszText) {
		this.xzszText = xzszText;
	}

	public String getZbdmbdText() {
		return zbdmbdText;
	}

	public void setZbdmbdText(String zbdmbdText) {
		this.zbdmbdText = zbdmbdText;
	}

	public String getGmzzText() {
		return gmzzText;
	}

	public void setGmzzText(String gmzzText) {
		this.gmzzText = gmzzText;
	}

	public String getRxText() {
		return rxText;
	}

	public void setRxText(String rxText) {
		this.rxText = rxText;
	}

	public String getWyText() {
		return wyText;
	}

	public void setWyText(String wyText) {
		this.wyText = wyText;
	}

	public String getYdText() {
		return ydText;
	}

	public void setYdText(String ydText) {
		this.ydText = ydText;
	}

	public String getGjText() {
		return gjText;
	}

	public void setGjText(String gjText) {
		this.gjText = gjText;
	}

	public String getGtText() {
		return gtText;
	}

	public void setGtText(String gtText) {
		this.gtText = gtText;
	}

	public String getFjText() {
		return fjText;
	}

	public void setFjText(String fjText) {
		this.fjText = fjText;
	}

	public String getYtText() {
		return ytText;
	}

	public void setYtText(String ytText) {
		this.ytText = ytText;
	}

	public String getGdText() {
		return gdText;
	}

	public void setGdText(String gdText) {
		this.gdText = gdText;
	}

	public String getPdText() {
		return pdText;
	}

	public void setPdText(String pdText) {
		this.pdText = pdText;
	}

	public String getYdxzyText() {
		return ydxzyText;
	}

	public void setYdxzyText(String ydxzyText) {
		this.ydxzyText = ydxzyText;
	}

	public String getYandiText() {
		return yandiText;
	}

	public void setYandiText(String yandiText) {
		this.yandiText = yandiText;
	}
}
