package com.region.moudles.tripartdock.sign.dto;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.until.DictUtil;

public class SignRecordDto {

	
	private String id;//履约id
	private String jdr;//建档人
	private String orgId;//机构id
	private String orgName;//机构名
	@JSONField(format="yyyy-MM-dd")
	private Date startTime;//开始日期
	@JSONField(format="yyyy-MM-dd")
	private Date endTime;//结束日期
	private String hzmc;//患者名字
	private String nl;//年龄
	private String sfzh;//身份证号
	private String jmid;//患者ID
	private String sj;//手机
	private String doctorId;//医生id
	private String doctorName;//医生姓名
	private String serviceType;//服务类型
	private String projectId;//服务项目id
	private String projectName;//服务项目名
	@JSONField(format="yyyy-MM-dd")
	private Date serviceTime;//服务时间

	@JSONField(format="yyyy-MM-dd")
	private Date nextServiceTime;//下次服务时间
	private String specification;//详述
	private String jtzz;//家庭住址

	private String count;//总数
	private String recordCount;//履约次数
	
	private String packageId;//服务包id
	private String packageName;//服务包名称
	private String evaluateContent;//评价内容
	private String evaluateScore;//评分
	private String patientId;//患者id
	private String signId;//签约ID

	private String orgname;//医生所在机构
	
	private String servicepackageName;//服务包名称
	private String serviceprojectName;//服务项名称
	private String servicetypeText;//服务项名称
	private String projectDesc;// 项目描述
	private String teamName;//团队名称
	
	
	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJdr() {
		return jdr;
	}

	public void setJdr(String jdr) {
		this.jdr = jdr;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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

	public String getHzmc() {
		return hzmc;
	}

	public void setHzmc(String hzmc) {
		this.hzmc = hzmc;
	}

	public String getNl() {
		return nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getSj() {
		return sj;
	}

	public void setSj(String sj) {
		this.sj = sj;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.servicetypeText = DictUtil.getDictValue("240000", serviceType);
		this.serviceType = serviceType;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	public Date getNextServiceTime() {
		return nextServiceTime;
	}

	public void setNextServiceTime(Date nextServiceTime) {
		this.nextServiceTime = nextServiceTime;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getJtzz() {
		return jtzz;
	}

	public void setJtzz(String jtzz) {
		this.jtzz = jtzz;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getEvaluateContent() {
		return evaluateContent;
	}

	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}

	public String getEvaluateScore() {
		return evaluateScore;
	}

	public void setEvaluateScore(String evaluateScore) {
		this.evaluateScore = evaluateScore;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getSignId() {
		return signId;
	}

	public void setSignId(String signId) {
		this.signId = signId;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getServicepackageName() {
		return servicepackageName;
	}

	public void setServicepackageName(String servicepackageName) {
		this.servicepackageName = servicepackageName;
	}

	public String getServiceprojectName() {
		return serviceprojectName;
	}

	public void setServiceprojectName(String serviceprojectName) {
		this.serviceprojectName = serviceprojectName;
	}

	public String getServicetypeText() {
		return servicetypeText;
	}

	public void setServicetypeText(String servicetypeText) {
		this.servicetypeText = servicetypeText;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public SignRecordDto() {
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
