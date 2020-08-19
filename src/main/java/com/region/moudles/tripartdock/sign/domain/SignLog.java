package com.region.moudles.tripartdock.sign.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;


@Entity
@Table(name = "blt_sign_log")
public class SignLog extends BaseDomain {

	private static final long serialVersionUID = 294964964694L;
	
	@Id
	private String id;// null
	private String signId;// 签约ID
	private String content;// 日志内容
	private String familyId;// 家庭ID
	private String customerIdcard;// 客户身份证号
	private String projectId;// 服务项目ID

	@Column(name = "sign_item_id")
	private String signItemId;// 签约记录ID

	private String remarks;// 备注
	private String operateType;// 操作类型（字典）
	@JSONField(format = "yyyy-MM-dd")
	private Date operateTime;// 操作时间
	private String operateUser;// 操作人
	private String operateCustomerIdcard;// 操作客户

	private Date createTime;
	private String createUser;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSignId() {
		return this.signId;
	}

	public void setSignId(String signId) {
		this.signId = signId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}

	public String getCustomerIdcard() {
		return this.customerIdcard;
	}

	public void setCustomerIdcard(String customerIdcard) {
		this.customerIdcard = customerIdcard;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getSignItemId() {
		return this.signItemId;
	}

	public void setSignItemId(String signItemId) {
		this.signItemId = signItemId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOperateType() {
		return this.operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public Date getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateUser() {
		return this.operateUser;
	}

	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getOperateCustomerIdcard() {
		return operateCustomerIdcard;
	}

	public void setOperateCustomerIdcard(String operateCustomerIdcard) {
		this.operateCustomerIdcard = operateCustomerIdcard;
	}

}
