package com.region.moudles.tripartdock.sign.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;


@Entity
@Table(name = "blt_sign_customer_project")
public class SignCustomerProject extends BaseDomain {

	private static final long serialVersionUID = 56656464694961L;

	@Id
	private String id;// null
	private String signId;// 签约ID
	@Column(name = "sign_customer_id")
	private String signCustomerId;// 签约成员ID
	private String signPackageId;// 签约服务包ID
	@Column(name = "project_id")
	private String projectId;// 服务项目ID

	@JSONField(format = "yyyy-MM-dd")
	private Date startTime;// 开始时间
	@JSONField(format = "yyyy-MM-dd")
	private Date endTime;// 结束时间
	private double score;// 分值
	private String cycle;// 周期 1日 2月 3季度 4年
	private int frequency;// 次数
	private double money;// 金额 默认为0
	private String status;// 状态 1 正常 2 删除

	@Column(name = "project_name")
	private String projectName;
	@Transient
	private String projectDetailName;
	
	public String getProjectDetailName() {
		return projectDetailName;
	}

	public void setProjectDetailName(String projectDetailName) {
		this.projectDetailName = projectDetailName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSignId() {
		return signId;
	}

	public void setSignId(String signId) {
		this.signId = signId;
	}

	public String getSignCustomerId() {
		return signCustomerId;
	}

	public void setSignCustomerId(String signCustomerId) {
		this.signCustomerId = signCustomerId;
	}

	public String getSignPackageId() {
		return signPackageId;
	}

	public void setSignPackageId(String signPackageId) {
		this.signPackageId = signPackageId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
