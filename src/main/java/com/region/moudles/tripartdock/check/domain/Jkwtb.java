package com.region.moudles.tripartdock.check.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @ClassName: Jkwtb
 * @Description: 体检-健康问题表
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_jkwtb")
public class Jkwtb extends BaseDomain {

	private static final long serialVersionUID = 655685522525L;
	
	@Id
	private String id;//
	@Column(length = 20)
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	private String nxgjb;// 脑血管疾病
	private String szjb;// 肾脏疾病
	private String xzjb;// 心脏疾病
	private String xgjb;// 血管疾病
	private String ybjb;// 眼部疾病
	@Column(length = 1)
	private String sjxtjb;// 神经系统疾病
	@Column(length = 1)
	private String qtxtjb;// 其他系统疾病
	private String qtnxgjb;// 其他脑血管疾病
	private String qtszjb;// 其他肾脏疾病
	private String qtxzjb;// 其他心脏疾病
	private String qtxgjb;// 其他血管疾病
	private String qtybjb;// 其他眼部疾病
	private String qtsjxtjb;// 其他神经系统疾病
	private String qt;// 其他
	private String tjid;
	
	@Transient
	private String nxgjbText;
	@Transient
	private String szjbText;// 肾脏疾病
	@Transient
	private String xzjbText;// 心脏疾病
	@Transient
	private String xgjbText;// 血管疾病
	@Transient
	private String ybjbText;// 眼部疾病
	@Transient
	private String sjxtjbText;// 神经系统疾病
	@Transient
	private String qtxtjbText;// 其他系统疾病
	
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

	public String getNxgjb() {
		return this.nxgjb;
	}

	public void setNxgjb(String nxgjb) {
		this.nxgjbText = DictUtil.getDictValue("tj-xczyjkwt-nxgjb", nxgjb);
		this.nxgjb = nxgjb;
	}

	public String getSzjb() {
		return this.szjb;
	}

	public void setSzjb(String szjb) {
		this.szjbText = DictUtil.getDictValue("tj-xczyjkwt-szjb", szjb);
		this.szjb = szjb;
	}

	public String getXzjb() {
		return this.xzjb;
	}

	public void setXzjb(String xzjb) {
		this.xzjbText = DictUtil.getDictValue("tj-xczyjkwt-xzjb", xzjb);
		this.xzjb = xzjb;
	}

	public String getXgjb() {
		return this.xgjb;
	}

	public void setXgjb(String xgjb) {
		this.xgjbText = DictUtil.getDictValue("tj-xczyjkwt-xgjb", xgjb);
		this.xgjb = xgjb;
	}

	public String getYbjb() {
		return this.ybjb;
	}

	public void setYbjb(String ybjb) {
		this.ybjbText = DictUtil.getDictValue("tj-xczyjkwt-ybjb", ybjb);
		this.ybjb = ybjb;
	}

	public String getSjxtjb() {
		return this.sjxtjb;
	}

	public void setSjxtjb(String sjxtjb) {
		this.sjxtjbText = DictUtil.getDictValue("tj-xczyjkwt-sjxtjb", sjxtjb);
		this.sjxtjb = sjxtjb;
	}

	public String getQtxtjb() {
		return this.qtxtjb;
	}

	public void setQtxtjb(String qtxtjb) {
		this.qtxtjbText = DictUtil.getDictValue("tj-xczyjkwt-qtxtjb", qtxtjb);
		this.qtxtjb = qtxtjb;
	}

	public String getQtnxgjb() {
		return this.qtnxgjb;
	}

	public void setQtnxgjb(String qtnxgjb) {
		this.qtnxgjb = qtnxgjb;
	}

	public String getQtszjb() {
		return this.qtszjb;
	}

	public void setQtszjb(String qtszjb) {
		this.qtszjb = qtszjb;
	}

	public String getQtxzjb() {
		return this.qtxzjb;
	}

	public void setQtxzjb(String qtxzjb) {
		this.qtxzjb = qtxzjb;
	}

	public String getQtxgjb() {
		return this.qtxgjb;
	}

	public void setQtxgjb(String qtxgjb) {
		this.qtxgjb = qtxgjb;
	}

	public String getQtybjb() {
		return this.qtybjb;
	}

	public void setQtybjb(String qtybjb) {
		this.qtybjb = qtybjb;
	}

	public String getQtsjxtjb() {
		return this.qtsjxtjb;
	}

	public void setQtsjxtjb(String qtsjxtjb) {
		this.qtsjxtjb = qtsjxtjb;
	}

	public String getQt() {
		return this.qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}

	public String getNxgjbText() {
		return nxgjbText;
	}

	public void setNxgjbText(String nxgjbText) {
		this.nxgjbText = nxgjbText;
	}

	public String getSzjbText() {
		return szjbText;
	}

	public void setSzjbText(String szjbText) {
		this.szjbText = szjbText;
	}

	public String getXzjbText() {
		return xzjbText;
	}

	public void setXzjbText(String xzjbText) {
		this.xzjbText = xzjbText;
	}

	public String getXgjbText() {
		return xgjbText;
	}

	public void setXgjbText(String xgjbText) {
		this.xgjbText = xgjbText;
	}

	public String getYbjbText() {
		return ybjbText;
	}

	public void setYbjbText(String ybjbText) {
		this.ybjbText = ybjbText;
	}

	public String getSjxtjbText() {
		return sjxtjbText;
	}

	public void setSjxtjbText(String sjxtjbText) {
		this.sjxtjbText = sjxtjbText;
	}public String getQtxtjbText() {
		return qtxtjbText;
	}

	public void setQtxtjbText(String qtxtjbText) {
		this.qtxtjbText = qtxtjbText;
	}

}
