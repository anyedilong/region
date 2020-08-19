package com.region.moudles.tripartdock.sign.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;


@Entity
@Table(name = "blt_sign_customer_package")
public class SignCustomerPackage extends BaseDomain {

	private static final long serialVersionUID = 664168486469L;
	
	@Id
	private String id;// null
	private String signId;// 签约ID
	@Column(name = "sign_customer_id")
	private String signCustomerId;// 签约成员ID
	@Column(name = "package_id")
	private String packageId;// 服务包ID

	private String customFlg;// 自定义标识 0 否 1 是
	private double money;// 金额 默认为0
	@JSONField(format = "yyyy-MM-dd")
	private Date startTime;// 开始时间
	@JSONField(format = "yyyy-MM-dd")
	private Date endTime;// 结束时间
	private String status;// 状态 1 正常 2 删除

	@Column(name = "package_name")
	private String packageName;//服务包名称
	
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

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

	public String getSignCustomerId() {
		return this.signCustomerId;
	}

	public void setSignCustomerId(String signCustomerId) {
		this.signCustomerId = signCustomerId;
	}

	public String getPackageId() {
		return this.packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getCustomFlg() {
		return this.customFlg;
	}

	public void setCustomFlg(String customFlg) {
		this.customFlg = customFlg;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
