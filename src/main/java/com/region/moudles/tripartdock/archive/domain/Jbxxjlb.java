package com.region.moudles.tripartdock.archive.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.moudles.tripartdock.follow.domain.FollowEtXse;
import com.region.until.DictUtil;
import com.region.until.StringUntil;
import com.region.until.validate.Validate;

/**
 * @author sen
 * @version 1.0.0
 * @ClassName Jbxxjlb
 * @Description 档案-基本信息
 * @Date 2017年2月7日 上午10:42:41
 */
@Entity
@Table(name = "blt_jbxxjlb")
public class Jbxxjlb extends BaseDomain {

	private static final long serialVersionUID = 1231231234324L;
	
	@Id
	private String id;//
	private String jlh;// 记录号

	@Validate(name = { "save" }, required = true)
	@Column(name = "sfzh")
	private String sfzh;// 身份证号
	private String sheng;// 省
	private String sbh;// 市
	private String dqbh;// 地区编号
	private String xzbh;// 乡镇
	private String cz;// 村庄
	private String ssshengbh;// 省
	private String sssbh;// 市
	private String ssxbh;// 县
	private String ssxzbh;// 乡镇
	private String sscbh;// 村庄
	private String gzdw;// 工作单位
	private String orgId;// 机构ID
	private String areaId;// 行政区划ID
	private String jzlx;// 居住类型
	private String guoji;// 国籍
	private String rh;// rh血型
	private String whcd;// 文化程度
	private String gz;// 工作
	private String hyqk;// 婚姻情况
	private String zffs;// 支付方式
	private String ywgms;// 药物过敏史
	private Integer cjqk;// 遗传病史
	private String cjqkms;// 残疾情况
	@Validate(name = { "save" }, required = true)
	private String hzmc;// 患者名称
	@Validate(name = { "save" }, required = true)
	private String ys;// 医生
	@Validate(name = { "save" }, required = true)
	private String xb;// 性别
	@JSONField(format = "yyyy-MM-dd")
	private Date csrq;// 出生日期
	private String lxr;// 联系人
	private String lxdh;// 联系电话
	private String xuexing;// 血型
	private String sj;// 手机
	private String qtfkfs;// 其他付款方式
	private String qtgmfy;// 其他过敏反应
	private String qtjbms;// 遗传病史描述
	private String diseasenditionex;// 残疾情况描述
	private String khbh;// 客户ID
	private String xzz;// 现住址
	private String jtzz;// 家庭住址
	@Validate(name = { "save" }, required = true)
	@Column(name = "jdjg")
	private String jdjg;// 建档机构
	private String mz;// 民族
	private String bls;// 暴露史
	@Column(name = "jdr")
	private String jdr;// 建档人
	@Validate(name = { "save" }, required = true)
	@JSONField(format = "yyyy-MM-dd")
	private Date jdrq;// 建档日期
	private String sycxgr;// 上一次修改人员
	@JSONField(format = "yyyy-MM-dd")
	private Date zhxgrq;// 最后修改日期
	private String rqlx;// 人群类型
	private String jtkbh;// 家庭卡编号
	private String hzgx;// 户主关系
	private String qthzgx;// 其他户主关系
	private String dzyx;// 电子邮箱
	private String sfsc = "N";// 是否删除
	private String sfxg;// 是否更新
	private String xzmc;// 乡镇名称
	private String czmc;// 村庄名称
	private String jdjgmc;// 建档机构名称
	private String jkfl;// 健康分类
	private String jtid;// 家庭ID
	private String jdrxm;// 建档人姓名
	private String fwmc;// 房屋名称
	private String jgmc;// 机构名称
	@Column(name = "img_url")
	private String imgUrl;// 用户头像
	private String overFlg = "0";// 死亡标识
	@JSONField(format = "yyyy-MM-dd")
	private Date overTime;// 死亡时间
	private String overRemarks;// 死亡备注
	private String migrateFlg = "0";// 移民标识
	private String ehrId;// 健康档案ID
	private String dataSource;// 数据来源 1平台 2平板 3手机
	private String dataSourceNo;// 数据来源唯一标志
	private String importDeviceNum;// 导入设备号
	@JSONField(format = "yyyy-MM-dd")
	private Date importTime;// 导入时间
	private String importUser;// 导入人
	private String importIp;// 导入IP
	@Column(updatable = false)
	private String synFlg = "0";// 是否同步 0 否 1 是
	@Column(updatable = false)
	private String synId;// 同步ID
	@Column(updatable = false)
	@JSONField(format = "yyyy-MM-dd")
	private Date synTime;// 同步时间
	private String synNo;
	private String updateFlg;// 同步是否修改
	@JSONField(format = "yyyy-MM-dd")
	private Date updateTime;
	
	// 病史信息
	@Transient
	private List<Bsxx> bsxx;
	// 家族史信息
	@Transient
	private Jzsxxb jzsxx;
	// 生活环境
	@Transient
	private Shhjb shhjb;
	// 新生儿随访
	@Transient
	private FollowEtXse xse;

	private String synUrl;//上传头像路径
	private String isPoor = "0";// 是否贫困 1是 0否
	@JSONField(format = "yyyy-MM-dd")
	private Date createTime;
	// 迁出
	private Date migrateTime;// 迁出时间
	private String migrateRemarks;// 迁出原因
	private String migrateCreateUser;// 迁出创建人
	private String czybkh;// 医保卡号
	private String jbybkh;// 医保卡号
	private String zfkh;// 医保卡号
	private String jsqz;// 家属签字
	private Date qzsj;
	private String zjlx; //证件类型
	private String jzqk;//居住情况
	private String jtrks;//家庭人口数
	private String jtjg;//家庭结构
	private String hzxm;//户主名称
	private String hzsfzh;//户主身份证号
	
	@Transient
	private String signId; //判断是否签约
	@Transient
	private String nl;
	@Transient
	private String startTime;
	@Transient
	private String endTime;
	
	@Transient
	private String mzText;
	@Transient
	private String rqlxText;
	@Transient
	private String tsrqlxText;
	@Transient
	private String jzlxText;
	@Transient
	private String xuexingText;
	@Transient
	private String whcdText;
	@Transient
	private String hyqkText;
	@Transient
	private String zffsText;
	@Transient
	private String ywgmsText;
	@Transient
	private String blsText;
	@Transient
	private String cjqkmsText;
	@Transient
	private String cjqkText;
	@Transient
	private String zjlxText;
	@Transient
	private String gzText;
	@Transient
	private String rhText;
	
	
	public Date getQzsj() {
		return qzsj;
	}

	public void setQzsj(Date qzsj) {
		this.qzsj = qzsj;
	}
	
	public String getJzqk() {
		return jzqk;
	}

	public void setJzqk(String jzqk) {
		this.jzqk = jzqk;
	}

	public String getJtrks() {
		return jtrks;
	}

	public void setJtrks(String jtrks) {
		this.jtrks = jtrks;
	}

	public String getJtjg() {
		return jtjg;
	}

	public void setJtjg(String jtjg) {
		this.jtjg = jtjg;
	}

	public String getZjlx() {
		return zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlxText = DictUtil.getDictValue("da-zjlx", zjlx);
		this.zjlx = zjlx;
	}


	public String getJsqz() {
		return jsqz;
	}

	public void setJsqz(String jsqz) {
		this.jsqz = jsqz;
	}

	public String getCzybkh() {
		return czybkh;
	}

	public void setCzybkh(String czybkh) {
		this.czybkh = czybkh;
	}

	public String getJbybkh() {
		return jbybkh;
	}

	public void setJbybkh(String jbybkh) {
		this.jbybkh = jbybkh;
	}

	public String getZfkh() {
		return zfkh;
	}

	public void setZfkh(String zfkh) {
		this.zfkh = zfkh;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

//    public BaseUserDomain getOverCreateUserCode() {

	private String cjjg;// 创建机构

	public String getCjjg() {
		return cjjg;
	}

	public void setCjjg(String cjjg) {
		this.cjjg = cjjg;
	}

	public String getIsPoor() {
		return isPoor;
	}

	public void setIsPoor(String isPoor) {
		this.isPoor = isPoor;
	}

	public String getSynUrl() {
		return synUrl;
	}

	public void setSynUrl(String synUrl) {
		this.synUrl = synUrl;
	}

	public String getSynNo() {
		return synNo;
	}

	public void setSynNo(String synNo) {
		this.synNo = synNo;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

	public String getJkfl() {
		return this.jkfl;
	}

	public void setJkfl(String jkfl) {
		this.jkfl = jkfl;
	}

	public String getJtid() {
		return this.jtid;
	}

	public void setJtid(String jtid) {
		this.jtid = jtid;
	}

	public String getJdrxm() {
		return this.jdrxm;
	}

	public void setJdrxm(String jdrxm) {
		this.jdrxm = jdrxm;
	}

	public String getFwmc() {
		return this.fwmc;
	}

	public void setFwmc(String fwmc) {
		this.fwmc = fwmc;
	}

	public String getJgmc() {
		return this.jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getImportDeviceNum() {
		return this.importDeviceNum;
	}

	public void setImportDeviceNum(String importDeviceNum) {
		this.importDeviceNum = importDeviceNum;
	}

	public Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public String getImportUser() {
		return this.importUser;
	}

	public void setImportUser(String importUser) {
		this.importUser = importUser;
	}

	public String getImportIp() {
		return this.importIp;
	}

	public void setImportIp(String importIp) {
		this.importIp = importIp;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getOverFlg() {
		return this.overFlg;
	}

	public void setOverFlg(String overFlg) {
		this.overFlg = overFlg;
	}

	public Date getOverTime() {
		return this.overTime;
	}

	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}

	public String getOverRemarks() {
		return this.overRemarks;
	}

	public void setOverRemarks(String overRemarks) {
		this.overRemarks = overRemarks;
	}

	public String getMigrateFlg() {
		return this.migrateFlg;
	}

	public void setMigrateFlg(String migrateFlg) {
		this.migrateFlg = migrateFlg;
	}

	public String getEhrId() {
		return this.ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJlh() {
		return this.jlh;
	}

	public void setJlh(String jlh) {
		this.jlh = jlh;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getSheng() {
		return this.sheng;
	}

	public void setSheng(String sheng) {
		this.sheng = sheng;
	}

	public String getSbh() {
		return this.sbh;
	}

	public void setSbh(String sbh) {
		this.sbh = sbh;
	}

	public String getDqbh() {
		return this.dqbh;
	}

	public void setDqbh(String dqbh) {
		this.dqbh = dqbh;
	}

	public String getXzbh() {
		return this.xzbh;
	}

	public void setXzbh(String xzbh) {
		this.xzbh = xzbh;
	}

	public String getCz() {
		return this.cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
	}

	public String getSsshengbh() {
		return this.ssshengbh;
	}

	public void setSsshengbh(String ssshengbh) {
		this.ssshengbh = ssshengbh;
	}

	public String getSssbh() {
		return this.sssbh;
	}

	public void setSssbh(String sssbh) {
		this.sssbh = sssbh;
	}

	public String getSsxbh() {
		return this.ssxbh;
	}

	public void setSsxbh(String ssxbh) {
		this.ssxbh = ssxbh;
	}

	public String getSsxzbh() {
		return this.ssxzbh;
	}

	public void setSsxzbh(String ssxzbh) {
		this.ssxzbh = ssxzbh;
	}

	public String getSscbh() {
		return this.sscbh;
	}

	public void setSscbh(String sscbh) {
		this.sscbh = sscbh;
	}

	public String getGzdw() {
		return this.gzdw;
	}

	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getAreaId() {
		return this.areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getJzlx() {
		return this.jzlx;
	}

	public void setJzlx(String jzlx) {
		this.jzlxText = "1".equals(jzlx) ? "户籍" : "非户籍";
		this.jzlx = jzlx;
	}

	public String getGuoji() {
		return this.guoji;
	}

	public void setGuoji(String guoji) {
		this.guoji = guoji;
	}

	public String getRh() {
		return this.rh;
	}

	public void setRh(String rh) {
		this.rhText = DictUtil.getDictValue("da-RHyx", rh);
		this.rh = rh;
	}

	public String getWhcd() {
		return this.whcd;
	}

	public void setWhcd(String whcd) {
		this.whcdText = DictUtil.getDictValue("da-whcd", whcd);
		this.whcd = whcd;
	}

	public String getGz() {
		return this.gz;
	}

	public void setGz(String gz) {
		this.gzText = DictUtil.getDictValue("da-zy", gz);
		this.gz = gz;
	}

	public String getHyqk() {
		return this.hyqk;
	}

	public void setHyqk(String hyqk) {
		this.hyqkText = DictUtil.getDictValue("da-hyzk", hyqk);
		this.hyqk = hyqk;
	}

	public String getZffs() {
		return this.zffs;
	}

	public void setZffs(String zffs) {
		this.zffsText = DictUtil.getDictValue("da-ylfyzffs", zffs);
		this.zffs = zffs;
	}

	public String getYwgms() {
		return this.ywgms;
	}

	public void setYwgms(String ywgms) {
		this.ywgmsText = DictUtil.getDictValue("da-ywgms", ywgms);
		this.ywgms = ywgms;
	}

	public Integer getCjqk() {
		return this.cjqk;
	}

	public void setCjqk(Integer cjqk) {
		this.cjqkText = (cjqk == 1 ? "无" : "有");
		this.cjqk = cjqk;
	}

	public String getCjqkms() {
		return this.cjqkms;
	}

	public void setCjqkms(String cjqkms) {
		this.cjqkmsText = DictUtil.getDictValue("da-cjqk", cjqkms);
		this.cjqkms = cjqkms;
	}

	public String getHzmc() {
		return this.hzmc;
	}

	public void setHzmc(String hzmc) {
		this.hzmc = hzmc;
	}

	public String getYs() {
		return this.ys;
	}

	public void setYs(String ys) {
		this.ys = ys;
	}

	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public Date getCsrq() {
		return this.csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getLxr() {
		return this.lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getXuexing() {
		return this.xuexing;
	}

	public void setXuexing(String xuexing) {
		this.xuexingText = DictUtil.getDictValue("da-xx", xuexing);
		this.xuexing = xuexing;
	}

	public String getSj() {
		return this.sj;
	}

	public void setSj(String sj) {
		this.sj = sj;
	}

	public String getQtfkfs() {
		return this.qtfkfs;
	}

	public void setQtfkfs(String qtfkfs) {
		this.qtfkfs = qtfkfs;
	}

	public String getQtgmfy() {
		return this.qtgmfy;
	}

	public void setQtgmfy(String qtgmfy) {
		this.qtgmfy = qtgmfy;
	}

	public String getQtjbms() {
		return this.qtjbms;
	}

	public void setQtjbms(String qtjbms) {
		this.qtjbms = qtjbms;
	}

	public String getDiseasenditionex() {
		return this.diseasenditionex;
	}

	public void setDiseasenditionex(String diseasenditionex) {
		//this.diseasenditionex = diseasenditionex;
		this.diseasenditionex = DictUtil.getDictValue("da-cjqk", diseasenditionex);
	}

	public String getKhbh() {
		return this.khbh;
	}

	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}

	public String getXzz() {
		return this.xzz;
	}

	public void setXzz(String xzz) {
		this.xzz = xzz;
	}

	public String getJtzz() {
		return this.jtzz;
	}

	public void setJtzz(String jtzz) {
		this.jtzz = jtzz;
	}

	public String getJdjg() {
		return this.jdjg;
	}

	public void setJdjg(String jdjg) {
		this.jdjg = jdjg;
	}

	public String getMz() {
		return this.mz;
	}

	public void setMz(String mz) {
		this.mzText = DictUtil.getDictValue("da-mz", mz);
		this.mz = mz;
	}

	public String getBls() {
		return this.bls;
	}

	public void setBls(String bls) {
		this.blsText = DictUtil.getDictValue("da-bls", bls);
		this.bls = bls;
	}

	public String getJdr() {
		return this.jdr;
	}

	public void setJdr(String jdr) {
		this.jdr = jdr;
	}

	public Date getJdrq() {
		return this.jdrq;
	}

	public void setJdrq(Date jdrq) {
		this.jdrq = jdrq;
	}

	public String getSycxgr() {
		return this.sycxgr;
	}

	public void setSycxgr(String sycxgr) {
		this.sycxgr = sycxgr;
	}

	public Date getZhxgrq() {
		return this.zhxgrq;
	}

	public void setZhxgrq(Date zhxgrq) {
		this.zhxgrq = zhxgrq;
	}

	public String getRqlx() {
		return this.rqlx;
	}

	public void setRqlx(String rqlx) {
		//人群类型分成人群分类和特殊人群分类
		if(!StringUntil.isNull(rqlx)) {
			String temp = rqlx.replace("101", "").replace("102", "").replace("103", "").replace("104", "")
							.replace("201", "").replace("301", "").replace("302", "").replace("303", "")
							.replace("304", "").replace("401", "").replace("10", "").replace("11", "")
							.replace("12", "").replace("13", "");
			this.rqlxText = DictUtil.getDictValue("rqlx", temp);
		}
		this.rqlx = rqlx;
	}

	public String getJtkbh() {
		return this.jtkbh;
	}

	public void setJtkbh(String jtkbh) {
		this.jtkbh = jtkbh;
	}

	public String getHzgx() {
		return this.hzgx;
	}

	public void setHzgx(String hzgx) {
		this.hzgx = hzgx;
	}

	public String getQthzgx() {
		return this.qthzgx;
	}

	public void setQthzgx(String qthzgx) {
		this.qthzgx = qthzgx;
	}

	public String getDzyx() {
		return this.dzyx;
	}

	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}

	public String getSfsc() {
		return this.sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}

	public String getSfxg() {
		return this.sfxg;
	}

	public void setSfxg(String sfxg) {
		this.sfxg = sfxg;
	}

	public String getXzmc() {
		return this.xzmc;
	}

	public void setXzmc(String xzmc) {
		this.xzmc = xzmc;
	}

	public String getCzmc() {
		return this.czmc;
	}

	public void setCzmc(String czmc) {
		this.czmc = czmc;
	}

	public String getJdjgmc() {
		return this.jdjgmc;
	}

	public void setJdjgmc(String jdjgmc) {
		this.jdjgmc = jdjgmc;
	}

	public List<Bsxx> getBsxx() {
		return bsxx;
	}

	public void setBsxx(List<Bsxx> bsxxList) {
		this.bsxx = bsxxList;
	}

	public Jzsxxb getJzsxx() {
		return jzsxx;
	}

	public void setJzsxx(Jzsxxb jzsxx) {
		this.jzsxx = jzsxx;
	}

	public Shhjb getShhjb() {
		return shhjb;
	}

	public void setShhjb(Shhjb shhjb) {
		this.shhjb = shhjb;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getDataSourceNo() {
		return dataSourceNo;
	}

	public void setDataSourceNo(String dataSourceNo) {
		this.dataSourceNo = dataSourceNo;
	}

	public String getSynFlg() {
		return synFlg;
	}

	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}

	public String getSynId() {
		return synId;
	}

	public void setSynId(String synId) {
		this.synId = synId;
	}

	public Date getSynTime() {
		return synTime;
	}

	public void setSynTime(Date synTime) {
		this.synTime = synTime;
	}
	public Date getMigrateTime() {
		return migrateTime;
	}

	public void setMigrateTime(Date migrateTime) {
		this.migrateTime = migrateTime;
	}

	public String getMigrateRemarks() {
		return migrateRemarks;
	}

	public void setMigrateRemarks(String migrateRemarks) {
		this.migrateRemarks = migrateRemarks;
	}

	public String getMigrateCreateUser() {
		return migrateCreateUser;
	}

	public void setMigrateCreateUser(String migrateCreateUser) {
		this.migrateCreateUser = migrateCreateUser;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSignId() {
		return signId;
	}

	public void setSignId(String signId) {
		this.signId = signId;
	}

	public String getNl() {
		return nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	public FollowEtXse getXse() {
		return xse;
	}

	public void setXse(FollowEtXse xse) {
		this.xse = xse;
	}
	
	public String getMzText() {
		return mzText;
	}
	
	public void setMzText(String mzText) {
		this.mzText = mzText;
	}

	public String getRqlxText() {
		return rqlxText;
	}

	public void setRqlxText(String rqlxText) {
		this.rqlxText = rqlxText;
	}

	public String getTsrqlxText() {
		return tsrqlxText;
	}

	public void setTsrqlxText(String tsrqlxText) {
		this.tsrqlxText = tsrqlxText;
	}

	public String getJzlxText() {
		return jzlxText;
	}

	public void setJzlxText(String jzlxText) {
		this.jzlxText = jzlxText;
	}

	public String getXuexingText() {
		return xuexingText;
	}

	public void setXuexingText(String xuexingText) {
		this.xuexingText = xuexingText;
	}

	public String getWhcdText() {
		return whcdText;
	}

	public void setWhcdText(String whcdText) {
		this.whcdText = whcdText;
	}

	public String getHyqkText() {
		return hyqkText;
	}

	public void setHyqkText(String hyqkText) {
		this.hyqkText = hyqkText;
	}

	public String getZffsText() {
		return zffsText;
	}

	public void setZffsText(String zffsText) {
		this.zffsText = zffsText;
	}

	public String getYwgmsText() {
		return ywgmsText;
	}

	public void setYwgmsText(String ywgmsText) {
		this.ywgmsText = ywgmsText;
	}

	public String getBlsText() {
		return blsText;
	}

	public void setBlsText(String blsText) {
		this.blsText = blsText;
	}

	public String getCjqkmsText() {
		return cjqkmsText;
	}

	public void setCjqkmsText(String cjqkmsText) {
		this.cjqkmsText = cjqkmsText;
	}

	public String getCjqkText() {
		return cjqkText;
	}

	public void setCjqkText(String cjqkText) {
		this.cjqkText = cjqkText;
	}

	public String getZjlxText() {
		return zjlxText;
	}

	public void setZjlxText(String zjlxText) {
		this.zjlxText = zjlxText;
	}

	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}

	public String getHzsfzh() {
		return hzsfzh;
	}

	public void setHzsfzh(String hzsfzh) {
		this.hzsfzh = hzsfzh;
	}

	public String getGzText() {
		return gzText;
	}

	public void setGzText(String gzText) {
		this.gzText = gzText;
	}

	public String getRhText() {
		return rhText;
	}

	public void setRhText(String rhText) {
		this.rhText = rhText;
	}

}
