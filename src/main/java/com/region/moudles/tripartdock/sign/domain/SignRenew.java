package com.region.moudles.tripartdock.sign.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;


@Entity
@Table(name = "blt_sign_renew")
public class SignRenew extends BaseDomain {

	private static final long serialVersionUID = 1966356464L;

	@Id
	private String id;// null
	@Column(name="sign_id")
	private String signId;// 签约ID
	@JSONField(format = "yyyy-MM-dd")
	private Date startTime;// 开始时间
	@JSONField(format = "yyyy-MM-dd")
	private Date entTime;// 结束时间
	private int cycleYear;// 签约周期/年
	private String signItemId;// 签约记录ID
	private String remarks;// 备注
	private String status;// 状态 1签约 2 解约
	private String renewFlg;// 是否为自动续约 0 否 1是

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

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEntTime() {
		return this.entTime;
	}

	public void setEntTime(Date entTime) {
		this.entTime = entTime;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRenewFlg() {
		return this.renewFlg;
	}

	public void setRenewFlg(String renewFlg) {
		this.renewFlg = renewFlg;
	}

	public int getCycleYear() {
		return cycleYear;
	}

	public void setCycleYear(int cycleYear) {
		this.cycleYear = cycleYear;
	}

}
