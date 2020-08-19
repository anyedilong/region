package com.region.moudles.system.domain;

import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 菜单权限表
 */
@Entity
@Table(name = "sys_black_bill")
public class SysBlackBill extends BaseDomain {

	private static final long serialVersionUID = 164646416341L;
	
	@Id
	private  String id;//内码
	@Column(name = "user_ip")
    private String userIp;//用户PCid
    private Integer times;//错误次数
    private String status;//状态 0.正常 1.锁定


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
