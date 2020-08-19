package com.region.moudles.healthbrowser.dto;


import java.io.Serializable;
import java.util.List;


/**
 * @ClassName: Medicalrecord
 * @Description: 检查信息实体类(惠民平台使用)
 * @author Administrator
 * @date 2020年3月9日
 */
public class ReportInfoDto implements Serializable {

	private static final long serialVersionUID = 1238834835345L;
	
	private String orgName;// 医院名称
	private String depCode;// 科室代码
	private String depName;// 科室名称
	private String sfzh;// 身份证号
	private String name;// 姓名
	private String sex;// 性别
	private String age;// 年龄
	
    private List<JcInfoDto> jcList;//检查集合
    private List<JyInfoDto> jyList;//检验集合
    
    
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public List<JcInfoDto> getJcList() {
		return jcList;
	}
	public void setJcList(List<JcInfoDto> jcList) {
		this.jcList = jcList;
	}
	public List<JyInfoDto> getJyList() {
		return jyList;
	}
	public void setJyList(List<JyInfoDto> jyList) {
		this.jyList = jyList;
	}
    
}
