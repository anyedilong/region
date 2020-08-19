package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: FollowFjhJb
 * @Description: 肺结核基本表
 * @author Administrator
 * @date 2019年8月1日
 */

@Entity
@Table(name="blt_pdb")
public class FollowFjhJb extends BaseDomain {

	/**
	 * @Field @serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 肺结核档案ID
	 */
	@Id
    private String id;

    private String orgId;    //创建机构

    private String sfzh;//身份证号

    private String familyname;//患者家属姓名

    private String familyrelation;//与患者关系

    private String famliyphone;//患者家属联系电话

    private Date qzsj;//确诊时间

    private Date stopzlsj;//出现停止治疗时间

    private String stopzlyy;//停止治疗原因

    private String shouldFollowupTimes;//应访视患者次数

    private String actualFollowupTimes;//实际访视患者次数

    private String shouldDrugTimes;//应服药次数

    private String actualDrugTimes;//实际服药次数

    private String drugRatio;//服药率%

    private String ys;//评估医生ID

    private Date beginManageDate;//开始管理时间

    private String caseStatus;//专项档案状态

    private Date lastVisitDate;//最近随访日期

    private Date nextVisitDate;//下次预约日期

    private String status;//是否删除:0正常1删除

    private String createUser;//录入人ID

    private Date createTime;//录入时间

    private String updateOrg;//最后更新机构ID
    
    private String updateUser;//最后更新人ID

    private Date updateTime;//最后更新时间
    
    private String synFlg;//同步标志
    
    private String synId;//同步ID
    
    private Date SynTime;//同步时间
    
	public String getSynFlg() {
		return synFlg;
	}

	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}

	public String getSynId() {
		return synId;
	}

	public void setSynId(String synId) {
		this.synId = synId;
	}

	public Date getSynTime() {
		return SynTime;
	}

	public void setSynTime(Date synTime) {
		SynTime = synTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public String getFamilyrelation() {
		return familyrelation;
	}

	public void setFamilyrelation(String familyrelation) {
		this.familyrelation = familyrelation;
	}

	public String getFamliyphone() {
		return famliyphone;
	}

	public void setFamliyphone(String famliyphone) {
		this.famliyphone = famliyphone;
	}

	public Date getQzsj() {
		return qzsj;
	}

	public void setQzsj(Date qzsj) {
		this.qzsj = qzsj;
	}

	public Date getStopzlsj() {
		return stopzlsj;
	}

	public void setStopzlsj(Date stopzlsj) {
		this.stopzlsj = stopzlsj;
	}

	public String getStopzlyy() {
		return stopzlyy;
	}

	public void setStopzlyy(String stopzlyy) {
		this.stopzlyy = stopzlyy;
	}

	public String getShouldFollowupTimes() {
		return shouldFollowupTimes;
	}

	public void setShouldFollowupTimes(String shouldFollowupTimes) {
		this.shouldFollowupTimes = shouldFollowupTimes;
	}

	public String getActualFollowupTimes() {
		return actualFollowupTimes;
	}

	public void setActualFollowupTimes(String actualFollowupTimes) {
		this.actualFollowupTimes = actualFollowupTimes;
	}

	public String getShouldDrugTimes() {
		return shouldDrugTimes;
	}

	public void setShouldDrugTimes(String shouldDrugTimes) {
		this.shouldDrugTimes = shouldDrugTimes;
	}

	public String getActualDrugTimes() {
		return actualDrugTimes;
	}

	public void setActualDrugTimes(String actualDrugTimes) {
		this.actualDrugTimes = actualDrugTimes;
	}

	public String getDrugRatio() {
		return drugRatio;
	}

	public void setDrugRatio(String drugRatio) {
		this.drugRatio = drugRatio;
	}

	public String getYs() {
		return ys;
	}

	public void setYs(String ys) {
		this.ys = ys;
	}

	public Date getBeginManageDate() {
		return beginManageDate;
	}

	public void setBeginManageDate(Date beginManageDate) {
		this.beginManageDate = beginManageDate;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public Date getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public Date getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateOrg() {
		return updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}
