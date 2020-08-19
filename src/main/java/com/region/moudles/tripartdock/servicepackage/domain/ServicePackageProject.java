package com.region.moudles.tripartdock.servicepackage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;

@Entity
@Table(name = "sys_package_project")
public class ServicePackageProject extends BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	
	private String id;// null

	@Column(name="package_id")
    private String packageId;// 服务包ID

	@Column(name = "project_id")
	private String projectId;// 服务项目ID

	private double score;// 分值
	private String cycle;// 周期 1日 2月 3季度 4年
	private int frequency;// 次数
	private double money;// 金额

	private String requiredFlg;// 是否必选 0 否 1 是
	private int orderNum;//
	
	@Transient
	private String operationType;// 操作类型 1 add 2 update 3 delete
	
	private String status;//是否删除
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getRequiredFlg() {
		return requiredFlg;
	}

	public void setRequiredFlg(String requiredFlg) {
		this.requiredFlg = requiredFlg;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
