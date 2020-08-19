package com.region.moudles.tripartdock.sign.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;


@Entity
@Table(name = "blt_sign_item")
public class SignItem extends BaseDomain {

	private static final long serialVersionUID = 8561616311L;
	
	@Id
	private String id;// null
	private String teamId;// 团队ID
	private String familyId;// 家庭ID
	private String signId;// 签约ID
	@JSONField(format = "yyyy-MM-dd")
	private Date signTime;// 签约时间
	private String signCustomerIdcard;// 签约成员人
	@Transient
	private String signCustomerName;// 签约成员姓名
	private String signUser;// 签约医生ID
	@Transient
	private String signUserName;// 签约医生姓名
	private String signRemarks;// 签约备注
	private Date createTime;// 创建时间
	private String createUser;// 创建人
	private String dataSource;// 1平台 2平板 3手机
	private String dataSourceNo;// 数据来源唯一标志
	private String uploadDeviceNum;// 设备编号
	private String uploadIp;// IP
	private Date uploadTime;// 上传时间
	private String uploadUser;// 上传人

	// 加附件
	@Transient
	private List<SignItemAnnex> signItemAnnexList;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamId() {
		return this.teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}

	public String getSignId() {
		return this.signId;
	}

	public void setSignId(String signId) {
		this.signId = signId;
	}

	public Date getSignTime() {
		return this.signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getSignCustomerIdcard() {
		return this.signCustomerIdcard;
	}

	public void setSignCustomerIdcard(String signCustomerIdcard) {
		this.signCustomerIdcard = signCustomerIdcard;
	}

	public String getSignUser() {
		return signUser;
	}

	public void setSignUser(String signUser) {
		this.signUser = signUser;
	}

	public String getSignRemarks() {
		return this.signRemarks;
	}

	public void setSignRemarks(String signRemarks) {
		this.signRemarks = signRemarks;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getDataSourceNo() {
		return this.dataSourceNo;
	}

	public void setDataSourceNo(String dataSourceNo) {
		this.dataSourceNo = dataSourceNo;
	}

	public String getUploadDeviceNum() {
		return this.uploadDeviceNum;
	}

	public void setUploadDeviceNum(String uploadDeviceNum) {
		this.uploadDeviceNum = uploadDeviceNum;
	}

	public String getUploadIp() {
		return this.uploadIp;
	}

	public void setUploadIp(String uploadIp) {
		this.uploadIp = uploadIp;
	}

	public Date getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUploadUser() {
		return this.uploadUser;
	}

	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}

	public List<SignItemAnnex> getSignItemAnnexList() {
		return signItemAnnexList;
	}

	public void setSignItemAnnexList(List<SignItemAnnex> signItemAnnexList) {
		this.signItemAnnexList = signItemAnnexList;
	}

}
