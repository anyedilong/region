package com.region.moudles.hospital.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.region.moudles.common.domain.BaseDomain;

/**
 * 住院医嘱明细-医生信息表(hospital_oi_doctor)
 * 
 * @author tz
 * @version 1.0.0 2020-06-03
 */
@Entity
@Table(name = "hospital_order_doctor")
public class HospitalOrderDoctor extends BaseDomain {
    /** 版本号 */
    private static final long serialVersionUID = -1803627095045322107L;

    /* This code was generated by TableGo tools, mark 1 begin. */

    /** id */
    @Id
    private String id;

    /** 医嘱明细标识 */
    private String oiId;

    /** 医生角色 */
    private String doctorRole;

    /** 医生编码 */
    private String doctorCode;

    /** 医生名称 */
    private String doctorName;
    
    /** 医生角色 */
    private String doctorExecRole;

    /** 医生编码 */
    private String doctorExecCode;

    /** 医生名称 */
    private String doctorExecName;

    /** his医生内码 */
    private String hisOiId;

    /* This code was generated by TableGo tools, mark 1 end. */

    /* This code was generated by TableGo tools, mark 2 begin. */

    /**
     * 获取id
     * 
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置id
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取医嘱明细标识
     * 
     * @return 医嘱明细标识
     */
    public String getOiId() {
        return this.oiId;
    }

    /**
     * 设置医嘱明细标识
     * 
     * @param oiId
     *          医嘱明细标识
     */
    public void setOiId(String oiId) {
        this.oiId = oiId;
    }

    /**
     * 获取医生角色
     * 
     * @return 医生角色
     */
    public String getDoctorRole() {
        return this.doctorRole;
    }

    /**
     * 设置医生角色
     * 
     * @param doctorRole
     *          医生角色
     */
    public void setDoctorRole(String doctorRole) {
        this.doctorRole = doctorRole;
    }

    /**
     * 获取医生编码
     * 
     * @return 医生编码
     */
    public String getDoctorCode() {
        return this.doctorCode;
    }

    /**
     * 设置医生编码
     * 
     * @param doctorCode
     *          医生编码
     */
    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    /**
     * 获取医生名称
     * 
     * @return 医生名称
     */
    public String getDoctorName() {
        return this.doctorName;
    }

    /**
     * 设置医生名称
     * 
     * @param doctorName
     *          医生名称
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorExecRole() {
		return doctorExecRole;
	}

	public void setDoctorExecRole(String doctorExecRole) {
		this.doctorExecRole = doctorExecRole;
	}

	public String getDoctorExecCode() {
		return doctorExecCode;
	}

	public void setDoctorExecCode(String doctorExecCode) {
		this.doctorExecCode = doctorExecCode;
	}

	public String getDoctorExecName() {
		return doctorExecName;
	}

	public void setDoctorExecName(String doctorExecName) {
		this.doctorExecName = doctorExecName;
	}

	/**
     * 获取his医生内码
     * 
     * @return his医生内码
     */
    public String getHisOiId() {
        return this.hisOiId;
    }

    /**
     * 设置his医生内码
     * 
     * @param hisOiId
     *          his医生内码
     */
    public void setHisOiId(String hisOiId) {
        this.hisOiId = hisOiId;
    }

    /* This code was generated by TableGo tools, mark 2 end. */
}