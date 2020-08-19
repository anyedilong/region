package com.region.moudles.tripartdock.check.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @ClassName: Shfs
 * @Description: 体检-生活方式
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_shfs")
public class Shfs extends BaseDomain {

	private static final long serialVersionUID = 34785165588552L;
	
	@Id
	private String id;//
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	@Column(precision = 5, scale=1)
	private String rxyl;// 日吸烟量
	private String ksxynl;// 开始吸烟年龄
	private String jynl;// 戒烟年龄
	@Column(length = 2)
	private String dlpl;// 锻炼频率
	private String jcdlsj;// 坚持锻炼时间
	private String ysxg;// 饮食习惯
	private String qtdlfs;// 其他锻炼方式
	private String mcdlsj;// 每次锻炼时间
	private String xyqk;// 吸烟情况
	@Column(length = 1)
	private String yjpl;// 饮酒频率
	@Column(precision = 5, scale= 1)
	private String ryjl;// 日饮酒量
	private String sfjj;// 是否戒酒
	private String jjnl;// 戒酒年龄
	private String ksyjnl;// 开始饮酒年龄
	private String jynsfzj;// 近一年是否醉酒
	private String yjzl;// 饮酒种类
	private String zybwhysjcs;// 职业病危害因素接触史
	private String fc;// 粉尘
	private String fcfhcs;// 粉尘防护措施
	private String fsxwz;// 放射性物质
	private String fsxbhcs;// 放射性防护措施
	private String wlys;// 物理因素
	private String wlysdfhcs;// 物理因素的防护措施
	private String hxwz;// 化学物质
	private String hxwzdfhcs;// 化学物质防护措施
	private String other;// 其他毒物种类
	private String qtfhcs;// 其他防护措施
	private String gzlx;// 工作类型
	private String gzsj;// 工作时间
	private String fcfhcsms;// 粉尘防护措施描述
	private String fsxwzfhcsms;// 放射性物质防护措施描述
	private String wlysfhcs;// 物理因素防护措施描述
	private String hxwzfhcsms;// 化学物质防护措施描述
	private String qtfhcsms;// 其他防护措施描述
	private String qtyjzl;// 其他饮酒种类
	private String tjid;

	@Transient
	private String dlplText;// 锻炼频率
	@Transient
	private String ysxgText;// 饮食习惯
	@Transient
	private String xyqkText;// 吸烟情况
	@Transient
	private String sfjjText;// 是否戒酒
	@Transient
	private String yjplText;// 饮酒频率
	@Transient
	private String jynsfzjText;// 近一年是否醉酒
	@Transient
	private String yjzlText;// 饮酒种类
	@Transient
	private String zybwhysjcsText;// 职业病危害因素接触史
	@Transient
	private String fcfhcsText;// 粉尘防护措施
	@Transient
	private String fsxbhcsText;// 放射性防护措施
	@Transient
	private String wlysdfhcsText;// 物理因素的防护措施
	@Transient
	private String hxwzdfhcsText;// 化学物质防护措施
	@Transient
	private String qtfhcsText;// 其他防护措施
	
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

	public String getRxyl() {
		return this.rxyl;
	}

	public void setRxyl(String rxyl) {
		this.rxyl = rxyl;
	}

	public String getKsxynl() {
		return this.ksxynl;
	}

	public void setKsxynl(String ksxynl) {
		this.ksxynl = ksxynl;
	}

	public String getJynl() {
		return this.jynl;
	}

	public void setJynl(String jynl) {
		this.jynl = jynl;
	}

	public String getDlpl() {
		return this.dlpl;
	}

	public void setDlpl(String dlpl) {
		this.dlplText = DictUtil.getDictValue("tj-shfs-tydl-dlpl", dlpl);
		this.dlpl = dlpl;
	}

	public String getJcdlsj() {
		return this.jcdlsj;
	}

	public void setJcdlsj(String jcdlsj) {
		this.jcdlsj = jcdlsj;
	}

	public String getYsxg() {
		return this.ysxg;
	}

	public void setYsxg(String ysxg) {
		this.ysxgText = DictUtil.getDictValue("tj-shfs-ysxg", ysxg);
		this.ysxg = ysxg;
	}

	public String getQtdlfs() {
		return this.qtdlfs;
	}

	public void setQtdlfs(String qtdlfs) {
		this.qtdlfs = qtdlfs;
	}

	public String getMcdlsj() {
		return this.mcdlsj;
	}

	public void setMcdlsj(String mcdlsj) {
		this.mcdlsj = mcdlsj;
	}

	public String getXyqk() {
		return this.xyqk;
	}

	public void setXyqk(String xyqk) {
		this.xyqkText = DictUtil.getDictValue("tj-shfs-xyqk-xyzk", xyqk);
		this.xyqk = xyqk;
	}

	public String getYjpl() {
		return this.yjpl;
	}

	public void setYjpl(String yjpl) {
		this.yjplText = DictUtil.getDictValue("tj-shfs-yjqk-yjpl", yjpl);
		this.yjpl = yjpl;
	}

	public String getRyjl() {
		return this.ryjl;
	}

	public void setRyjl(String ryjl) {
		this.ryjl = ryjl;
	}

	public String getSfjj() {
		return this.sfjj;
	}

	public void setSfjj(String sfjj) {
		this.sfjjText = DictUtil.getDictValue("tj-shfs-yjqk-sfjj", sfjj);
		this.sfjj = sfjj;
	}

	public String getJjnl() {
		return this.jjnl;
	}

	public void setJjnl(String jjnl) {
		this.jjnl = jjnl;
	}

	public String getKsyjnl() {
		return this.ksyjnl;
	}

	public void setKsyjnl(String ksyjnl) {
		this.ksyjnl = ksyjnl;
	}

	public String getJynsfzj() {
		return this.jynsfzj;
	}

	public void setJynsfzj(String jynsfzj) {
		this.jynsfzjText = DictUtil.getDictValue("tj-shfs-yjqk-jynnsfczj", jynsfzj);
		this.jynsfzj = jynsfzj;
	}

	public String getYjzl() {
		return this.yjzl;
	}

	public void setYjzl(String yjzl) {
		this.yjzlText = DictUtil.getDictValue("tj-shfs-yjqk-yjzl", yjzl);
		this.yjzl = yjzl;
	}

	public String getZybwhysjcs() {
		return this.zybwhysjcs;
	}

	public void setZybwhysjcs(String zybwhysjcs) {
		this.zybwhysjcsText = DictUtil.getDictValue("tj-shfs-zybwhysjcs", zybwhysjcs);
		this.zybwhysjcs = zybwhysjcs;
	}

	public String getFc() {
		return this.fc;
	}

	public void setFc(String fc) {
		this.fc = fc;
	}

	public String getFcfhcs() {
		return this.fcfhcs;
	}

	public void setFcfhcs(String fcfhcs) {
		this.fcfhcsText = DictUtil.getDictValue("tj-shfs-zybwhysjcs-fhcs", fcfhcs);
		this.fcfhcs = fcfhcs;
	}

	public String getFsxwz() {
		return this.fsxwz;
	}

	public void setFsxwz(String fsxwz) {
		this.fsxwz = fsxwz;
	}

	public String getFsxbhcs() {
		return this.fsxbhcs;
	}

	public void setFsxbhcs(String fsxbhcs) {
		this.fsxbhcsText = DictUtil.getDictValue("tj-shfs-zybwhysjcs-fhcs", fsxbhcs);
		this.fsxbhcs = fsxbhcs;
	}

	public String getWlys() {
		return this.wlys;
	}

	public void setWlys(String wlys) {
		this.wlys = wlys;
	}

	public String getWlysdfhcs() {
		return this.wlysdfhcs;
	}

	public void setWlysdfhcs(String wlysdfhcs) {
		this.wlysdfhcsText = DictUtil.getDictValue("tj-shfs-zybwhysjcs-fhcs", wlysdfhcs);
		this.wlysdfhcs = wlysdfhcs;
	}

	public String getHxwz() {
		return this.hxwz;
	}

	public void setHxwz(String hxwz) {
		this.hxwz = hxwz;
	}

	public String getHxwzdfhcs() {
		return this.hxwzdfhcs;
	}

	public void setHxwzdfhcs(String hxwzdfhcs) {
		this.hxwzdfhcsText = DictUtil.getDictValue("tj-shfs-zybwhysjcs-fhcs", hxwzdfhcs);
		this.hxwzdfhcs = hxwzdfhcs;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getQtfhcs() {
		return this.qtfhcs;
	}

	public void setQtfhcs(String qtfhcs) {
		this.qtfhcsText = DictUtil.getDictValue("tj-shfs-zybwhysjcs-fhcs", qtfhcs);
		this.qtfhcs = qtfhcs;
	}

	public String getGzlx() {
		return this.gzlx;
	}

	public void setGzlx(String gzlx) {
		this.gzlx = gzlx;
	}

	public String getGzsj() {
		return this.gzsj;
	}

	public void setGzsj(String gzsj) {
		this.gzsj = gzsj;
	}

	public String getFcfhcsms() {
		return this.fcfhcsms;
	}

	public void setFcfhcsms(String fcfhcsms) {
		this.fcfhcsms = fcfhcsms;
	}

	public String getFsxwzfhcsms() {
		return this.fsxwzfhcsms;
	}

	public void setFsxwzfhcsms(String fsxwzfhcsms) {
		this.fsxwzfhcsms = fsxwzfhcsms;
	}

	public String getWlysfhcs() {
		return this.wlysfhcs;
	}

	public void setWlysfhcs(String wlysfhcs) {
		this.wlysfhcs = wlysfhcs;
	}

	public String getHxwzfhcsms() {
		return this.hxwzfhcsms;
	}

	public void setHxwzfhcsms(String hxwzfhcsms) {
		this.hxwzfhcsms = hxwzfhcsms;
	}

	public String getQtfhcsms() {
		return this.qtfhcsms;
	}

	public void setQtfhcsms(String qtfhcsms) {
		this.qtfhcsms = qtfhcsms;
	}

	public String getQtyjzl() {
		return this.qtyjzl;
	}

	public void setQtyjzl(String qtyjzl) {
		this.qtyjzl = qtyjzl;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}

	public String getDlplText() {
		return dlplText;
	}

	public void setDlplText(String dlplText) {
		this.dlplText = dlplText;
	}

	public String getYsxgText() {
		return ysxgText;
	}

	public void setYsxgText(String ysxgText) {
		this.ysxgText = ysxgText;
	}

	public String getXyqkText() {
		return xyqkText;
	}

	public void setXyqkText(String xyqkText) {
		this.xyqkText = xyqkText;
	}

	public String getSfjjText() {
		return sfjjText;
	}

	public void setSfjjText(String sfjjText) {
		this.sfjjText = sfjjText;
	}

	public String getYjplText() {
		return yjplText;
	}

	public void setYjplText(String yjplText) {
		this.yjplText = yjplText;
	}

	public String getJynsfzjText() {
		return jynsfzjText;
	}

	public void setJynsfzjText(String jynsfzjText) {
		this.jynsfzjText = jynsfzjText;
	}

	public String getYjzlText() {
		return yjzlText;
	}

	public void setYjzlText(String yjzlText) {
		this.yjzlText = yjzlText;
	}

	public String getZybwhysjcsText() {
		return zybwhysjcsText;
	}

	public void setZybwhysjcsText(String zybwhysjcsText) {
		this.zybwhysjcsText = zybwhysjcsText;
	}

	public String getFcfhcsText() {
		return fcfhcsText;
	}

	public void setFcfhcsText(String fcfhcsText) {
		this.fcfhcsText = fcfhcsText;
	}

	public String getFsxbhcsText() {
		return fsxbhcsText;
	}

	public void setFsxbhcsText(String fsxbhcsText) {
		this.fsxbhcsText = fsxbhcsText;
	}

	public String getWlysdfhcsText() {
		return wlysdfhcsText;
	}

	public void setWlysdfhcsText(String wlysdfhcsText) {
		this.wlysdfhcsText = wlysdfhcsText;
	}

	public String getHxwzdfhcsText() {
		return hxwzdfhcsText;
	}

	public void setHxwzdfhcsText(String hxwzdfhcsText) {
		this.hxwzdfhcsText = hxwzdfhcsText;
	}

	public String getQtfhcsText() {
		return qtfhcsText;
	}

	public void setQtfhcsText(String qtfhcsText) {
		this.qtfhcsText = qtfhcsText;
	}

}
