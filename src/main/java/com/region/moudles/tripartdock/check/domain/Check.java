package com.region.moudles.tripartdock.check.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @ClassName: Check
 * @Description: 体检-基本信息
 * @author Administrator
 * @date 2019年7月30日
 */
@Entity
@Table(name = "blt_khjbxxb")
public class Check extends BaseDomain {

	private static final long serialVersionUID = 7504549679034744003L;
	
	@Id
	private String id;//
	private String khbh;// 客户编号
	private String sfzh;// 身份证号
	@JSONField(format = "yyyy-MM-dd")
	private Date jcrq;// 检查日期
	@Column(name = "ys")
	private String ys;// 医生

	private String tjfl; // 体检分类(4.15-64岁城乡居民 5.65-79岁城乡居民 6.80岁及以上城乡居民 7.企业退休人员 8.公职、事业单位（退休人员）、企业职工
							// 9.流动人口)

	private String zz;// 症状

	private String qt;// 其他
	private String tjbh;// 体检编号
	@Column(name = "jbr")
	private String jbr;// 建表人
	@JSONField(format = "yyyy-MM-dd")
	private Date jbrq;// 建表日期
	@Column(name = "sycxgr")
	private String sycxgr;// 上一次修改人

	@JSONField(format = "yyyy-MM-dd")
	private Date sycxgrq;// 上一次修改日期
	private String sfsc;// 是否删除

	@Column(updatable = false)
	private String dataSource;// 数据来源 1平台 2平板 3手机
	@Column(updatable = false)
	private String dataSourceNo;// 数据来源唯一标志
	@Column(updatable = false)
	private String importDeviceNum;// 导入设备号
	@Column(updatable = false)
	@JSONField(format = "yyyy-MM-dd")
	private Date importTime;// 导入时间
	@Column(updatable = false)
	private String importUser;// 导入人
	@Column(updatable = false)
	private String importIp;// 导入IP
	@Column(updatable = false)
	private String synFlg = "0";// 是否同步 0 否 1 是
	@Column(updatable = false)
	private String synId;// 同步ID
	@Column(updatable = false)
	@JSONField(format = "yyyy-MM-dd")
	private Date synTime;// 同步时间

	private String tjdw;// 体检单位

	private String updateFlg;// 是否修改标志

	private String imgUrl;// 图片路径
	@JSONField(format = "yyyy-MM-dd")
	private Date createTime;
	@JSONField(format = "yyyy-MM-dd")
	private Date updateTime;

	// 生活方式
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private Shfs shfs;

	// 健康检查
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private Jkjc jkjc;

	// 辅助检查
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private Xzjcjlb xzjcjlb;

	// 一般症状
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private Ybzzb ybzzb;

	// 脏器功能
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private Zqgnb zqgnb;

	// 健康问题
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private Jkwtb jkwtb;

	// 评估指导
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private Pgzdjlb pgzdjlb;

	// 家族病床史
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Jzbcs> jzbcs;

	// 接种史
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Jzs> jzs;

	// 药剂记录
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Yjjlb> yjjlb;

	// 住院史
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
			@JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Zys> zys;
	
	private String fileRecordId;// 上传图像返回值

	private String healthExamNo;// 下载冠新返回值

	private String zzys;// 症状医师签名
	private String ctys;// 查体医师签名
	private String fkrqz;// 反馈人签字
	private Date fksj;// 2019-01-18
	private String fkys;// 妇科医师签名
	private String gjtpys;// 宫颈涂片医师签名
	private String gmzzys;// 肛门指诊医师签名
	private String jkpjys;// 健康评价医师签名
	private String jkzdys;// 健康指导医师签名
	private String qzjs;// 家长签字
	private String rxys;// 乳腺医师签名
	private String shfsys;// 生活方式医师签名
	private String sys;// 肝/肾/血脂医师签名
	private String xdtys;// 心电图医生
	private String xpys;// 胸部X线片医师签名
	private String xxys;// 血类医师签名
	private String ybqkys;// 一般状况医师签名
	private String ydys;// 眼底医师签名
	private String zqgnys;// 脏器功能医师签名
	private String zyqkys;// 健康问题/住院情况医师签名
	private String bchaoqtys;// B超其他医师签名
	private String bchaoys;// 腹部B超医师签名
	private String yyqkys;// 药剂接种医生
	private String qz;// 本人签字
	private String brqzimg; //手写板本人签字Base64
	
	@Transient
	private String name;
	@Transient
	private String zzText;
	
	
	public String getBrqzimg() {
		return brqzimg;
	}

	public void setBrqzimg(String brqzimg) {
		this.brqzimg = brqzimg;
	}

	public String getYyqkys() {
		return yyqkys;
	}

	public void setYyqkys(String yyqkys) {
		this.yyqkys = yyqkys;
	}

	public String getBchaoqtys() {
		return bchaoqtys;
	}

	public void setBchaoqtys(String bchaoqtys) {
		this.bchaoqtys = bchaoqtys;
	}

	public String getBchaoys() {
		return bchaoys;
	}

	public void setBchaoys(String bchaoys) {
		this.bchaoys = bchaoys;
	}

	public String getCtys() {
		return ctys;
	}

	public void setCtys(String ctys) {
		this.ctys = ctys;
	}

	public String getFkrqz() {
		return fkrqz;
	}

	public void setFkrqz(String fkrqz) {
		this.fkrqz = fkrqz;
	}

	public Date getFksj() {
		return fksj;
	}

	public void setFksj(Date fksj) {
		this.fksj = fksj;
	}

	public String getFkys() {
		return fkys;
	}

	public void setFkys(String fkys) {
		this.fkys = fkys;
	}

	public String getGjtpys() {
		return gjtpys;
	}

	public void setGjtpys(String gjtpys) {
		this.gjtpys = gjtpys;
	}

	public String getGmzzys() {
		return gmzzys;
	}

	public void setGmzzys(String gmzzys) {
		this.gmzzys = gmzzys;
	}

	public String getJkpjys() {
		return jkpjys;
	}

	public void setJkpjys(String jkpjys) {
		this.jkpjys = jkpjys;
	}

	public String getJkzdys() {
		return jkzdys;
	}

	public void setJkzdys(String jkzdys) {
		this.jkzdys = jkzdys;
	}

	public String getQz() {
		return qz;
	}

	public void setQz(String qz) {
		this.qz = qz;
	}

	public String getQzjs() {
		return qzjs;
	}

	public void setQzjs(String qzjs) {
		this.qzjs = qzjs;
	}

	public String getRxys() {
		return rxys;
	}

	public void setRxys(String rxys) {
		this.rxys = rxys;
	}

	public String getShfsys() {
		return shfsys;
	}

	public void setShfsys(String shfsys) {
		this.shfsys = shfsys;
	}

	public String getSys() {
		return sys;
	}

	public void setSys(String sys) {
		this.sys = sys;
	}

	public String getXdtys() {
		return xdtys;
	}

	public void setXdtys(String xdtys) {
		this.xdtys = xdtys;
	}

	public String getXpys() {
		return xpys;
	}

	public void setXpys(String xpys) {
		this.xpys = xpys;
	}

	public String getXxys() {
		return xxys;
	}

	public void setXxys(String xxys) {
		this.xxys = xxys;
	}

	public String getYbqkys() {
		return ybqkys;
	}

	public void setYbqkys(String ybqkys) {
		this.ybqkys = ybqkys;
	}

	public String getYdys() {
		return ydys;
	}

	public void setYdys(String ydys) {
		this.ydys = ydys;
	}

	public String getZqgnys() {
		return zqgnys;
	}

	public void setZqgnys(String zqgnys) {
		this.zqgnys = zqgnys;
	}

	public String getZyqkys() {
		return zyqkys;
	}

	public void setZyqkys(String zyqkys) {
		this.zyqkys = zyqkys;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTjfl() {
		return tjfl;
	}

	public void setTjfl(String tjfl) {
		this.tjfl = tjfl;
	}

	public String getHealthExamNo() {
		return healthExamNo;
	}

	public void setHealthExamNo(String healthExamNo) {
		this.healthExamNo = healthExamNo;
	}

	public String getFileRecordId() {
		return fileRecordId;
	}

	public void setFileRecordId(String fileRecordId) {
		this.fileRecordId = fileRecordId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

	public List<Yjjlb> getYjjlb() {
		return yjjlb;
	}

	public void setYjjlb(List<Yjjlb> yjjlb) {
		this.yjjlb = yjjlb;
	}

	public List<Zys> getZys() {
		return zys;
	}

	public void setZys(List<Zys> zys) {
		this.zys = zys;
	}

	public Shfs getShfs() {
		return shfs;
	}

	public void setShfs(Shfs shfs) {
		this.shfs = shfs;
	}

	public Jkjc getJkjc() {
		return jkjc;
	}

	public void setJkjc(Jkjc jkjc) {
		this.jkjc = jkjc;
	}

	public Xzjcjlb getXzjcjlb() {
		return xzjcjlb;
	}

	public void setXzjcjlb(Xzjcjlb xzjcjlb) {
		this.xzjcjlb = xzjcjlb;
	}

	public Ybzzb getYbzzb() {
		return ybzzb;
	}

	public void setYbzzb(Ybzzb ybzzb) {
		this.ybzzb = ybzzb;
	}

	public Zqgnb getZqgnb() {
		return zqgnb;
	}

	public void setZqgnb(Zqgnb zqgnb) {
		this.zqgnb = zqgnb;
	}

	public Jkwtb getJkwtb() {
		return jkwtb;
	}

	public void setJkwtb(Jkwtb jkwtb) {
		this.jkwtb = jkwtb;
	}

	public Pgzdjlb getPgzdjlb() {
		return pgzdjlb;
	}

	public void setPgzdjlb(Pgzdjlb pgzdjlb) {
		this.pgzdjlb = pgzdjlb;
	}

	public List<Jzbcs> getJzbcs() {
		return jzbcs;
	}

	public void setJzbcs(List<Jzbcs> jzbcs) {
		this.jzbcs = jzbcs;
	}

	public List<Jzs> getJzs() {
		return jzs;
	}

	public void setJzs(List<Jzs> jzs) {
		this.jzs = jzs;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKhbh() {
		return this.khbh;
	}

	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public Date getJcrq() {
		return this.jcrq;
	}

	public void setJcrq(Date jcrq) {
		this.jcrq = jcrq;
	}

	public String getYs() {
		return this.ys;
	}

	public void setYs(String ys) {
		this.ys = ys;
	}

	public String getZz() {
		return this.zz;
	}

	public void setZz(String zz) {
		this.zzText = DictUtil.getDictValue("tj-zz", zz);
		this.zz = zz;
	}

	public String getQt() {
		return this.qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getTjbh() {
		return this.tjbh;
	}

	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
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

	public String getSycxgr() {
		return this.sycxgr;
	}

	public void setSycxgr(String sycxgr) {
		this.sycxgr = sycxgr;
	}

	public Date getSycxgrq() {
		return this.sycxgrq;
	}

	public void setSycxgrq(Date sycxgrq) {
		this.sycxgrq = sycxgrq;
	}

	public String getSfsc() {
		return this.sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
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

	public String getSynFlg() {
		return this.synFlg;
	}

	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}

	public String getTjdw() {
		return this.tjdw;
	}

	public void setTjdw(String tjdw) {
		this.tjdw = tjdw;
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

	public String getZzys() {
		return zzys;
	}

	public void setZzys(String zzys) {
		this.zzys = zzys;
	}

	public String getZzText() {
		return zzText;
	}

	public void setZzText(String zzText) {
		this.zzText = zzText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
