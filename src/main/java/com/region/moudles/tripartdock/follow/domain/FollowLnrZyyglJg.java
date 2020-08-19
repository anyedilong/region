package com.region.moudles.tripartdock.follow.domain;

import javax.persistence.*;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

import java.util.List;

/**
 * @ClassName: FollowLnrZyyglJg
 * @Description: 随访-老年人-中医药管理-结果
 * @author Administrator
 * @date 2019年8月2日
 */
@Entity
@Table(name = "blt_lnrzlnlpgjgb")
public class FollowLnrZyyglJg extends BaseDomain {

	private static final long serialVersionUID = 262616161;
	
	@Id
	private String id;//ID
	private String pgid;//老年人中医药管理id
	private String tjbh;// 体检编号
	private String ywbh;// 药物编号
	private String phz;// 平和质
	private String qxz;// 气虚质
	private String yxuz;// 阳虚质
	private String yxz;// 阴虚质
	private String tsz;// 痰湿质
	private String srz;// 湿热质
	private String xyz;// 血瘀质
	private String qyz;// 气郁质
	private String tbz;// 特秉质
	private String phzdf;// 平和质得分
	private String qxzdf;// 气虚质评分
	private String yxuzdf;// 阳虚质评分
	private String yxzdf;// 阴虚质评分
	private String tszpf;// 痰湿质评分
	private String srzpf;// 湿热质评分
	private String xyzpf;// 血瘀质评分
	private String qyzpf;// 气郁质评分
	private String tbzpf;// 特秉质评分
	private String phzjy="";// 平和质建议 指导
	private String qxzjy="";// 气虚质建议
	private String yxuzjy="";// 阳虚质建议
	private String yxzjy="";// 阴虚质建议
	private String tszjy="";// 痰湿质建议
	private String srzjy="";// 湿热质建议
	private String xyzjy="";// 血瘀质建议
	private String qyzjy="";// 气郁质建议
	private String tbzjy="";// 特秉质建议
	private String phzjyms;// 平和质建议描述
	private String qxzjyms;// 气虚质建议描述
	private String yxuzjyms;// 阳虚质建议描述
	private String yxzjyms;// 阴虚质简要描述
	private String tszjyms;// 痰湿质建议描述
	private String srzjyms;// 湿热质建议描述
	private String xyzjyms;// 血瘀质建议描述
	private String qyzjyms;// 气郁质建议描述
	private String tbzjyms;// 特秉质建议描述
	private String sfsc;// 是否删除
	@Column(name="sfzh")
	private String sfzh;// 身份证号


	@Transient
	private String phzName;// 平和质
	@Transient
	private String qxzName;// 气虚质
	@Transient
	private String yxuzName;// 阳虚质
	@Transient
	private String yxzName;// 阴虚质
	@Transient
	private String tszName;// 痰湿质
	@Transient
	private String srzName;// 湿热质
	@Transient
	private String xyzName;// 血瘀质
	@Transient
	private String qyzName;// 气郁质
	@Transient
	private String tbzName;// 特秉质
	@Transient
	private String phzjyName;// 平和质建议
	@Transient
	private String qxzjyName;// 气虚质建议
	@Transient
	private String yxuzjyName;// 阳虚质建议
	@Transient
	private String yxzjyName;// 阴虚质建议
	@Transient
	private String tszjyName;// 痰湿质建议
	@Transient
	private String srzjyName;// 湿热质建议
	@Transient
	private String xyzjyName;// 血瘀质建议
	@Transient
	private String qyzjyName;// 气郁质建议
	@Transient
	private String tbzjyName;// 特秉质建议
	@Transient
	private List list;

	public String getPhzName() {
		if ("2".equals(phz))
			return "基本是";
		return DictUtil.getDictValue("lnr-pgjg", this.phz);
	}

	public void setPhzName(String phzName) {
		this.phzName = phzName;
	}

	public String getQxzName() {
		return DictUtil.getDictValue("lnr-pgjg", this.qxz);
	}

	public void setQxzName(String qxzName) {
		this.qxzName = qxzName;
	}

	public String getYxuzName() {
		return DictUtil.getDictValue("lnr-pgjg", this.yxuz);
	}

	public void setYxuzName(String yxuzName) {
		this.yxuzName = yxuzName;
	}

	public String getYxzName() {
		return DictUtil.getDictValue("lnr-pgjg", this.yxz);
	}

	public void setYxzName(String yxzName) {
		this.yxzName = yxzName;
	}

	public String getTszName() {
		return DictUtil.getDictValue("lnr-pgjg", this.tsz);
	}

	public void setTszName(String tszName) {
		this.tszName = tszName;
	}

	public String getSrzName() {
		return DictUtil.getDictValue("lnr-pgjg", this.srz);
	}

	public void setSrzName(String srzName) {
		this.srzName = srzName;
	}

	public String getXyzName() {
		return DictUtil.getDictValue("lnr-pgjg", this.xyz);
	}

	public void setXyzName(String xyzName) {
		this.xyzName = xyzName;
	}

	public String getQyzName() {
		return DictUtil.getDictValue("lnr-pgjg", this.qyz);
	}

	public void setQyzName(String qyzName) {
		this.qyzName = qyzName;
	}

	public String getTbzName() {
		return DictUtil.getDictValue("lnr-pgjg", this.tbz);
	}

	public void setTbzName(String tbzName) {
		this.tbzName = tbzName;
	}

	public String getPhzjyName() {
		return DictUtil.getDictValue("lnr-bjzd", this.phzjy);
	}

	public void setPhzjyName(String phzjyName) {
		this.phzjyName = phzjyName;
	}

	public String getQxzjyName() {
		return DictUtil.getDictValue("lnr-bjzd", this.qxzjy);
	}

	public void setQxzjyName(String qxzjyName) {
		this.qxzjyName = qxzjyName;
	}

	public String getYxuzjyName() {
		return DictUtil.getDictValue("lnr-bjzd", this.yxuzjy);
	}

	public void setYxuzjyName(String yxuzjyName) {
		this.yxuzjyName = yxuzjyName;
	}

	public String getYxzjyName() {
		return DictUtil.getDictValue("lnr-bjzd", this.yxzjy);
	}

	public void setYxzjyName(String yxzjyName) {
		this.yxzjyName = yxzjyName;
	}

	public String getTszjyName() {
		return DictUtil.getDictValue("lnr-bjzd", this.tszjy);
	}

	public void setTszjyName(String tszjyName) {
		this.tszjyName = tszjyName;
	}

	public String getSrzjyName() {
		return DictUtil.getDictValue("lnr-bjzd", this.srzjy);
	}

	public void setSrzjyName(String srzjyName) {
		this.srzjyName = srzjyName;
	}

	public String getXyzjyName() {
		return DictUtil.getDictValue("lnr-bjzd", this.xyzjy);
	}

	public void setXyzjyName(String xyzjyName) {
		this.xyzjyName = xyzjyName;
	}

	public String getQyzjyName() {
		return DictUtil.getDictValue("lnr-bjzd", this.qyzjy);
	}

	public void setQyzjyName(String qyzjyName) {
		this.qyzjyName = qyzjyName;
	}

	public String getTbzjyName() {
		return DictUtil.getDictValue("lnr-bjzd", this.tbzjy);
	}

	public void setTbzjyName(String tbzjyName) {
		this.tbzjyName = tbzjyName;
	}



	public String getPgid() {
		return pgid;
	}

	public void setPgid(String pgid) {
		this.pgid = pgid;
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

	public String getYwbh() {
		return this.ywbh;
	}

	public void setYwbh(String ywbh) {
		this.ywbh = ywbh;
	}

	public String getPhz() {
		return this.phz;
	}

	public void setPhz(String phz) {
		this.phz = phz;
	}

	public String getQxz() {
		return this.qxz;
	}

	public void setQxz(String qxz) {
		this.qxz = qxz;
	}

	public String getYxuz() {
		return this.yxuz;
	}

	public void setYxuz(String yxuz) {
		this.yxuz = yxuz;
	}

	public String getYxz() {
		return this.yxz;
	}

	public void setYxz(String yxz) {
		this.yxz = yxz;
	}

	public String getTsz() {
		return this.tsz;
	}

	public void setTsz(String tsz) {
		this.tsz = tsz;
	}

	public String getSrz() {
		return this.srz;
	}

	public void setSrz(String srz) {
		this.srz = srz;
	}

	public String getXyz() {
		return this.xyz;
	}

	public void setXyz(String xyz) {
		this.xyz = xyz;
	}

	public String getQyz() {
		return this.qyz;
	}

	public void setQyz(String qyz) {
		this.qyz = qyz;
	}

	public String getTbz() {
		return this.tbz;
	}

	public void setTbz(String tbz) {
		this.tbz = tbz;
	}

	public String getPhzdf() {
		return this.phzdf;
	}

	public void setPhzdf(String phzdf) {
		this.phzdf = phzdf;
	}

	public String getQxzdf() {
		return this.qxzdf;
	}

	public void setQxzdf(String qxzdf) {
		this.qxzdf = qxzdf;
	}

	public String getYxuzdf() {
		return this.yxuzdf;
	}

	public void setYxuzdf(String yxuzdf) {
		this.yxuzdf = yxuzdf;
	}

	public String getYxzdf() {
		return this.yxzdf;
	}

	public void setYxzdf(String yxzdf) {
		this.yxzdf = yxzdf;
	}

	public String getTszpf() {
		return tszpf;
	}

	public void setTszpf(String tszpf) {
		this.tszpf = tszpf;
	}

	public String getSrzpf() {
		return srzpf;
	}

	public void setSrzpf(String srzpf) {
		this.srzpf = srzpf;
	}

	public String getXyzpf() {
		return xyzpf;
	}

	public void setXyzpf(String xyzpf) {
		this.xyzpf = xyzpf;
	}

	public String getQyzpf() {
		return qyzpf;
	}

	public void setQyzpf(String qyzpf) {
		this.qyzpf = qyzpf;
	}

	public String getTbzpf() {
		return tbzpf;
	}

	public void setTbzpf(String tbzpf) {
		this.tbzpf = tbzpf;
	}

	public String getPhzjy() {
		return this.phzjy;
	}

	public void setPhzjy(String phzjy) {
		this.phzjy = phzjy;
	}

	public String getQxzjy() {
		return this.qxzjy;
	}

	public void setQxzjy(String qxzjy) {
		this.qxzjy = qxzjy;
	}

	public String getYxuzjy() {
		return this.yxuzjy;
	}

	public void setYxuzjy(String yxuzjy) {
		this.yxuzjy = yxuzjy;
	}

	public String getYxzjy() {
		return this.yxzjy;
	}

	public void setYxzjy(String yxzjy) {
		this.yxzjy = yxzjy;
	}

	public String getTszjy() {
		return this.tszjy;
	}

	public void setTszjy(String tszjy) {
		this.tszjy = tszjy;
	}

	public String getSrzjy() {
		return this.srzjy;
	}

	public void setSrzjy(String srzjy) {
		this.srzjy = srzjy;
	}

	public String getXyzjy() {
		return this.xyzjy;
	}

	public void setXyzjy(String xyzjy) {
		this.xyzjy = xyzjy;
	}

	public String getQyzjy() {
		return this.qyzjy;
	}

	public void setQyzjy(String qyzjy) {
		this.qyzjy = qyzjy;
	}

	public String getTbzjy() {
		return this.tbzjy;
	}

	public void setTbzjy(String tbzjy) {
		this.tbzjy = tbzjy;
	}

	public String getPhzjyms() {
		return this.phzjyms;
	}

	public void setPhzjyms(String phzjyms) {
		this.phzjyms = phzjyms;
	}

	public String getQxzjyms() {
		return this.qxzjyms;
	}

	public void setQxzjyms(String qxzjyms) {
		this.qxzjyms = qxzjyms;
	}

	public String getYxuzjyms() {
		return this.yxuzjyms;
	}

	public void setYxuzjyms(String yxuzjyms) {
		this.yxuzjyms = yxuzjyms;
	}

	public String getYxzjyms() {
		return this.yxzjyms;
	}

	public void setYxzjyms(String yxzjyms) {
		this.yxzjyms = yxzjyms;
	}

	public String getTszjyms() {
		return this.tszjyms;
	}

	public void setTszjyms(String tszjyms) {
		this.tszjyms = tszjyms;
	}

	public String getSrzjyms() {
		return this.srzjyms;
	}

	public void setSrzjyms(String srzjyms) {
		this.srzjyms = srzjyms;
	}

	public String getXyzjyms() {
		return this.xyzjyms;
	}

	public void setXyzjyms(String xyzjyms) {
		this.xyzjyms = xyzjyms;
	}

	public String getQyzjyms() {
		return this.qyzjyms;
	}

	public void setQyzjyms(String qyzjyms) {
		this.qyzjyms = qyzjyms;
	}

	public String getTbzjyms() {
		return this.tbzjyms;
	}

	public void setTbzjyms(String tbzjyms) {
		this.tbzjyms = tbzjyms;
	}

	public String getSfsc() {
		return this.sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
