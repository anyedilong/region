package com.region.moudles.tripartdock.check.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;
import com.region.until.StringUntil;


/**
 * @ClassName: Yjjlb
 * @Description: 体检-药剂记录
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_yjjlb")
public class Yjjlb extends BaseDomain {

	private static final long serialVersionUID = 8556446131313L;
	
	@Id
	private String id;//
	@Column(length = 20)
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	private String synl;// 用法
	private String yl;// 使用量
	private String kssj;// 开始时间(用药时间)
	private String jssj;// 结束时间
	private String ywycx;// 药物依从性
	private String ywmc;// 药物名称
	private String ywlx;// 药物类型
	private String scs;// 生产商
	private String gmfs;// 购买方式
	private String yyqkys;// 用药情况及接种史医生签名
	private String tjid;
	
	@Transient
	private String ywycxText;// 药物依从性
	
	public String getGmfs() {
		return gmfs;
	}

	public void setGmfs(String gmfs) {
		this.gmfs = gmfs;
	}

	public String getYyqkys() {
		return yyqkys;
	}

	public void setYyqkys(String yyqkys) {
		this.yyqkys = yyqkys;
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

	public String getSynl() {
		return this.synl;
	}

	public void setSynl(String synl) {
		this.synl = synl;
	}

	public String getYl() {
		return this.yl;
	}

	public void setYl(String yl) {
		if(!StringUntil.isNull(yl)) {
			if(yl.length()==1&&",".equals(yl)){
				this.yl ="";
			}else {
				this.yl=yl;
			}
		}else {
			this.yl=yl;
		}
		this.yl = yl;
	}

	public String getKssj() {
		return this.kssj;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
	}

	public String getJssj() {
		return this.jssj;
	}

	public void setJssj(String jssj) {
		this.jssj = jssj;
	}

	public String getYwycx() {
		return this.ywycx;
	}

	public void setYwycx(String ywycx) {
		this.ywycxText = DictUtil.getDictValue("tj-zyyyqk-fyycx", ywycx);
		this.ywycx = ywycx;
	}

	public String getYwmc() {
		return this.ywmc;
	}

	public void setYwmc(String ywmc) {
		this.ywmc = ywmc;
	}

	public String getYwlx() {
		return this.ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

	public String getScs() {
		return this.scs;
	}

	public void setScs(String scs) {
		this.scs = scs;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}public String getYwycxText() {
		return ywycxText;
	}

	public void setYwycxText(String ywycxText) {
		this.ywycxText = ywycxText;
	}

}
