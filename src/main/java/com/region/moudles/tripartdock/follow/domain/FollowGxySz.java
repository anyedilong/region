package com.region.moudles.tripartdock.follow.domain;

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
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: FollowGxySz
 * @Description: 高血压首诊表
 * @author Administrator
 * @date 2019年7月31日
 */
@Entity
@Table(name = "blt_mxgxyszb")
public class FollowGxySz extends BaseDomain {

	private static final long serialVersionUID = 1695496464L;
	
	@Id
	private String id; //
	private String jmid;//居民id
	private String name; //患者姓名
	private String sfzh; //身份证号
	private String tjbh; //体检编号
	@JSONField(format="yyyy-MM-dd")
	private Date szrq; //首诊日期-随访日期
	private String dabh; //档案编号
	private String jws; //既往史
	private String gxy; //收缩压
	private String dxy; //舒张压
	private String xl; //心率
	@Column(precision = 5, scale = 2)
	private String sg; //身高
	private String tz; //体重
	@Column(precision = 5, scale = 2)
	private String yw; //腰围
	private String sfxy; //是否吸烟
	private String jsycxyxg; //几岁养成吸烟习惯
	private String jqtsfxy; //近七天是否吸烟
	private String fzjc; //辅助检查
	private String sfyy; //是否服用降压药、降脂、抗血小板等心血管疾病相关药物
	private String zd; //诊断
	private String zdqt; //诊断其他
	private String sfzz; //是否转诊
	@JSONField(format="yyyy-MM-dd")
	private Date zzrq; //转诊日期
	private String zzyy; //转诊原因
	private String zzyyjks; //转诊医院及科室
	private String sfr; //随访人
	@Column(name="lrr")
	private String lrr; //录入人
	@Column(name = "jbr")
	private String jbr; //建表人
	@JSONField(format="yyyy-MM-dd")
	private Date xcsfrq; //下次随访日期
	private String sycxgr; //上一次修改人
	private Date sycxgrq; //上一次修改日期

	@Column(updatable = false)
	private String dataSource; //数据来源(1平台 2平板 3App)
	@Column(updatable = false)
	private String dataSourceNo; //数据来源唯一标志
	@Column(updatable = false)
	private String importDeviceNum;// 导入设备号
	@Column(updatable = false)
	private Date importTime;// 导入时间
	@Column(updatable = false)
	private String importUser;// 导入人
	@Column(updatable = false)
	private String importIp;// 导入IP
	private String synFlg = "0";// 是否同步 0 否 1 是
	@Column(updatable = false)
	private String synId; //同步ID
	@Column(updatable = false)
	private Date synTime; //同步时间
	private String updateFlg; //同步唯一标识
	private String fileRecordId;//上传图像返回值
	private String imgUrl;//平板上传图像保存路径
	private String sfsc = "N"; //是否删除
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
	            @JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
	            @JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false)})
	@NotFound(action = NotFoundAction.IGNORE)
	private List<FollowGxySzmqyy> gxySzmqyy;//高血压首诊目前用药表
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumns(value = {
	            @JoinColumn(name = "tjbh", referencedColumnName = "tjbh", insertable = false, updatable = false, nullable = false),
	            @JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false, nullable = false)})
	@NotFound(action = NotFoundAction.IGNORE)
	private List<FollowGxySzywzlb> gxySzywzlbs;//高血压首诊药物治疗表

	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public List<FollowGxySzmqyy> getGxySzmqyy() {
		return gxySzmqyy;
	}
	public void setGxySzmqyy(List<FollowGxySzmqyy> gxySzmqyy) {
		this.gxySzmqyy = gxySzmqyy;
	}
	public List<FollowGxySzywzlb> getGxySzywzlbs() {
		return gxySzywzlbs;
	}
	public void setGxySzywzlbs(List<FollowGxySzywzlb> gxySzywzlbs) {
		this.gxySzywzlbs = gxySzywzlbs;
	}
	public String getJbr() {
		return jbr;
	}
	public void setJbr(String jbr) {
		this.jbr = jbr;
	}
	public String getUpdateFlg() {
		return updateFlg;
	}
	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getTjbh() {
		return tjbh;
	}
	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
	}
	public Date getSzrq() {
		return szrq;
	}
	public void setSzrq(Date szrq) {
		this.szrq = szrq;
	}
	public String getDabh() {
		return dabh;
	}
	public void setDabh(String dabh) {
		this.dabh = dabh;
	}
	public String getJws() {
		return jws;
	}
	public void setJws(String jws) {
		this.jws = jws;
	}
	public String getGxy() {
		return gxy;
	}
	public void setGxy(String gxy) {
		this.gxy = gxy;
	}
	public String getDxy() {
		return dxy;
	}
	public void setDxy(String dxy) {
		this.dxy = dxy;
	}
	public String getXl() {
		return xl;
	}
	public void setXl(String xl) {
		this.xl = xl;
	}
	public String getSg() {
		return sg;
	}
	public void setSg(String sg) {
		this.sg = sg;
	}
	public String getTz() {
		return tz;
	}
	public void setTz(String tz) {
		this.tz = tz;
	}
	public String getYw() {
		return yw;
	}
	public void setYw(String yw) {
		this.yw = yw;
	}
	public String getSfxy() {
		return sfxy;
	}
	public void setSfxy(String sfxy) {
		this.sfxy = sfxy;
	}
	public String getJsycxyxg() {
		return jsycxyxg;
	}
	public void setJsycxyxg(String jsycxyxg) {
		this.jsycxyxg = jsycxyxg;
	}
	public String getJqtsfxy() {
		return jqtsfxy;
	}
	public void setJqtsfxy(String jqtsfxy) {
		this.jqtsfxy = jqtsfxy;
	}
	public String getFzjc() {
		return fzjc;
	}
	public void setFzjc(String fzjc) {
		this.fzjc = fzjc;
	}
	public String getSfyy() {
		return sfyy;
	}
	public void setSfyy(String sfyy) {
		this.sfyy = sfyy;
	}
	public String getZd() {
		return zd;
	}
	public void setZd(String zd) {
		this.zd = zd;
	}
	public String getZdqt() {
		return zdqt;
	}
	public void setZdqt(String zdqt) {
		this.zdqt = zdqt;
	}
	public String getSfzz() {
		return sfzz;
	}
	public void setSfzz(String sfzz) {
		this.sfzz = sfzz;
	}
	public Date getZzrq() {
		return zzrq;
	}
	public void setZzrq(Date zzrq) {
		this.zzrq = zzrq;
	}
	public String getZzyy() {
		return zzyy;
	}
	public void setZzyy(String zzyy) {
		this.zzyy = zzyy;
	}
	public String getZzyyjks() {
		return zzyyjks;
	}
	public void setZzyyjks(String zzyyjks) {
		this.zzyyjks = zzyyjks;
	}
	public String getSfr() {
		return sfr;
	}
	public void setSfr(String sfr) {
		this.sfr = sfr;
	}
	public String getLrr() {
		return lrr;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public Date getXcsfrq() {
		return xcsfrq;
	}
	public void setXcsfrq(Date xcsfrq) {
		this.xcsfrq = xcsfrq;
	}
	public String getSycxgr() {
		return sycxgr;
	}
	public void setSycxgr(String sycxgr) {
		this.sycxgr = sycxgr;
	}
	public Date getSycxgrq() {
		return sycxgrq;
	}
	public void setSycxgrq(Date sycxgrq) {
		this.sycxgrq = sycxgrq;
	}
	public String getImportDeviceNum() {
		return importDeviceNum;
	}
	public void setImportDeviceNum(String importDeviceNum) {
		this.importDeviceNum = importDeviceNum;
	}
	public Date getImportTime() {
		return importTime;
	}
	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}
	public String getImportUser() {
		return importUser;
	}
	public void setImportUser(String importUser) {
		this.importUser = importUser;
	}
	public String getImportIp() {
		return importIp;
	}
	public void setImportIp(String importIp) {
		this.importIp = importIp;
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
	public String getSfsc() {
		return sfsc;
	}
	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}
}
