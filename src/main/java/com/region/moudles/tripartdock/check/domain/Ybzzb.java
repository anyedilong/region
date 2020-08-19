package com.region.moudles.tripartdock.check.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @ClassName: Ybzzb
 * @Description: 体检-一般症状
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_ybzzb")
public class Ybzzb extends BaseDomain {

	private static final long serialVersionUID = 187494941949L;
	
	@Id
	private String id;//
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	@Column(precision = 4, scale = 1)
	private String tw;// 体温

	private String xl;// 呼吸频率
	private String hxpl;//呼吸频率
	
	@Column(precision = 5, scale = 2)
	private String yw;// 腰围
	@Column(precision = 5, scale = 2)
	private String sg;// 身高
	private String lnrzwpg;// 老年人认知功能
	private String lnrqgzt;// 老年人情感状态
	private String ml;// 脉率
	@Column(precision = 5, scale = 2)
	private String tz;// 体重
	@Column(precision = 5, scale = 2)
	private String bmi;// 体质指数
	private String jyzljcfs;// 简易智力检查，总分
	private String lnryypfjcfs;// 老年人抑郁评分检查，总分
	private String zcxy;// 左侧低压
	private String ycxy;// 右侧低压
	private String waistip;//
	private String zgd;// 左手高压
	private String ygd;// 右手高压
	private String lnrjkzk;// 老年人健康状况
	private String tem;//
	@Column(length = 1)
	private String lnrzlnlpg;// 老年人自理能力评估
	
	private String twei;//臀围
	private String ytRate;//腰臀比值
	private String tjid;

	@Transient
	private String lnrrzgnText;
	@Transient
	private String lnrqgztText;
	@Transient
	private String lnrjkzkText;
	@Transient
	private String lnrzlnlpgText;
	
	
	public String getTwei() {
		return twei;
	}

	public void setTwei(String twei) {
		this.twei = twei;
	}

	public String getYtRate() {
		return ytRate;
	}

	public void setYtRate(String ytRate) {
		this.ytRate = ytRate;
	}

	public String getWaistip() {
		return this.waistip;
	}

	public void setWaistip(String waistip) {
		this.waistip = waistip;
	}

	public String getZgd() {
		return this.zgd;
	}

	public void setZgd(String zgd) {
		this.zgd = zgd;
	}

	public String getYgd() {
		return this.ygd;
	}

	public void setYgd(String ygd) {
		this.ygd = ygd;
	}

	public String getLnrjkzk() {
		return this.lnrjkzk;
	}

	public void setLnrjkzk(String lnrjkzk) {
		this.lnrjkzkText = DictUtil.getDictValue("tj-ybzz-lnrjkztzwpg", lnrjkzk);
		this.lnrjkzk = lnrjkzk;
	}

	public String getTem() {
		return this.tem;
	}

	public void setTem(String tem) {
		this.tem = tem;
	}

	public String getLnrzlnlpg() {
		return this.lnrzlnlpg;
	}

	public void setLnrzlnlpg(String lnrzlnlpg) {
		this.lnrzlnlpgText = DictUtil.getDictValue("tj-ybzz-lnrshzlnlzwnlpg", lnrzlnlpg);
		this.lnrzlnlpg = lnrzlnlpg;
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

	public String getTw() {
		return this.tw;
	}

	public void setTw(String tw) {
		this.tw = tw;
	}

	public String getXl() {
		return xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	public String getHxpl() {
		return hxpl;
	}

	public void setHxpl(String hxpl) {
		this.hxpl = hxpl;
	}

	public String getYw() {
		return this.yw;
	}

	public void setYw(String yw) {
		this.yw = yw;
	}

	public String getSg() {
		return this.sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public String getLnrzwpg() {
		return this.lnrzwpg;
	}

	public void setLnrzwpg(String lnrzwpg) {
		this.lnrrzgnText = DictUtil.getDictValue("tj-ybzz-lnrrzgn", lnrzwpg);
		this.lnrzwpg = lnrzwpg;
	}

	public String getLnrqgzt() {
		return this.lnrqgzt;
	}

	public void setLnrqgzt(String lnrqgzt) {
		this.lnrqgztText = DictUtil.getDictValue("tj-ybzz-lnrqgzt", lnrqgzt);
		this.lnrqgzt = lnrqgzt;
	}

	public String getMl() {
		return this.ml;
	}

	public void setMl(String ml) {
		this.ml = ml;
	}

	public String getTz() {
		return this.tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public String getBmi() {
		return this.bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getJyzljcfs() {
		return this.jyzljcfs;
	}

	public void setJyzljcfs(String jyzljcfs) {
		this.jyzljcfs = jyzljcfs;
	}

	public String getLnryypfjcfs() {
		return this.lnryypfjcfs;
	}

	public void setLnryypfjcfs(String lnryypfjcfs) {
		this.lnryypfjcfs = lnryypfjcfs;
	}

	public String getZcxy() {
		return this.zcxy;
	}

	public void setZcxy(String zcxy) {
		this.zcxy = zcxy;
	}

	public String getYcxy() {
		return this.ycxy;
	}

	public void setYcxy(String ycxy) {
		this.ycxy = ycxy;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}

	public String getLnrrzgnText() {
		return lnrrzgnText;
	}

	public void setLnrrzgnText(String lnrrzgnText) {
		this.lnrrzgnText = lnrrzgnText;
	}

	public String getLnrqgztText() {
		return lnrqgztText;
	}

	public void setLnrqgztText(String lnrqgztText) {
		this.lnrqgztText = lnrqgztText;
	}

	public String getLnrjkzkText() {
		return lnrjkzkText;
	}

	public void setLnrjkzkText(String lnrjkzkText) {
		this.lnrjkzkText = lnrjkzkText;
	}

	public String getLnrzlnlpgText() {
		return lnrzlnlpgText;
	}

	public void setLnrzlnlpgText(String lnrzlnlpgText) {
		this.lnrzlnlpgText = lnrzlnlpgText;
	}
}
