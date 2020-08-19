package com.region.moudles.system.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.region.moudles.common.domain.BaseDomain;


@Entity
@Table(name="sys_user_health")
public class SysUserHealth extends BaseDomain {

    private static final long serialVersionUID = 4564729518133694581L;
    
    @Id
    private String id;

    private  String doctorName;
    private  String doctorCode;
    private  String depCode;
    private  String depName;
    private String role;
    private String orgName;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}