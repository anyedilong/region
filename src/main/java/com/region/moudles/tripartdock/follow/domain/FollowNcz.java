package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;


/**
 * @ClassName: FollowNcz
 * @Description: 随访-脑卒中-随访
 * @author Administrator
 * @date 2019年8月2日
 */
@Entity
@Table(name = "blt_mxnczsfb")
public class FollowNcz extends BaseDomain {

	private static final long serialVersionUID = 18949494666L;
	
	@Id
	private String id;//ID
	private String jmid;//居民id
	private String tjbh;// 体检编号
	private String customerid;// 患者编号
	private String idcardno;// 身份证号
	@JSONField(format = "yyyy-MM-dd")
	private Date followupdate;// 随访日期
	private String followupdoctor;// 随访医生
	@JSONField(format = "yyyy-MM-dd")
	private Date nextfollowupdate;// 下次随访日期
	private String symptom;// 症状
	private String symptomother;// 其他症状
	private String hypertension;// 高血压
	private String hypotension;// 低血压
	private String weight;// 体重
	private String signother;// 其他体征
	private String drugcontrol;// 服用何种药物防治
	private String smokedrinkattention;// 抽烟喝酒的注意
	private String sportattention;// 运动注意
	private String eatsaltattention;// 摄盐注意事项
	private String psychicadjust;// 心理调整
	private String obeydoctorbehavio;// 遵医嘱
	private String assistantexam;// 辅助检查
	private String medicationcompliance;// 服药依从性
	private String adr;// 药物不良反应
	private String adrex;// 不良反应描述
	private String followuptype;// 随访类型
	private String referralreason;// 转诊原因
	private String referralorg;// 机构或科室
	private String followupway;// 随访方式
	private String createdby;// 创建人
	private Date createddate;// 创建日期
	private String lastupdateby;// 上次建表人
	private Date lastupdatedate;// 上次修改日期
	private String isdel;// 是否删除
	private String recordid;// 档案号
	private String eatingdrug;// 吃药注意
	private String ywmc1;// 药物名称1
	private String ywmc1ci;// 药物名称1每日几次
	private String ywmc1mg;// 药物名称1第次多少mg
	private String ywmc2;// 药物名称2
	private String ywmc2ci;// 药物名称2每日几次
	private String ywmc2mg;// 药物名称2第次多少mg
	private String ywmc3;// 药物名称3
	private String ywmc3ci;// 药物名称3每日几次
	private String ywmc3mg;// 药物名称3第次多少mg
	private String qtyw;// 其他药物
	private String qtywci;// 其他药物每日几次
	private String qtywmg;// 其他药物每次多少mg

	@Column(updatable = false)
	private String dataSource;// 数据来源 1平台 2平板 3手机
	@Column(updatable = false)
	private String dataSourceNo;// 数据来源唯一标志
	@Column(updatable = false)
	private String importDeviceNum;// 导入设备号
	@Column(updatable = false)
	private Date importTime;// 导入时间
	@Column(updatable = false)
	private String importUser;// 导入人
	@Column(updatable = false)
	private String importIp;// 导入IP
	private String synFlg="0";// 是否同步 0 否 1 是
	@Column(updatable = false)
	private String synId;// 同步ID
	@Column(updatable = false)
	private Date synTime;// 同步时间
	
	private String updateFlg;


	@Transient
	private String symptomName;
	@Transient
	private String psychicadjustName;
	@Transient
	private String obeydoctorbehavioName;
	@Transient
	private String medicationcomplianceName;
	@Transient
	private String adrName;
	@Transient
	private String followupwayName;
	@Transient
	private String followuptypeName;

	public String getSymptomName() {
		return DictUtil.getDictValue("ncz-zz", this.symptom);
	}

	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}

	public String getPsychicadjustName() {
		return DictUtil.getDictValue("gxy-zyxw", this.psychicadjust);
	}

	public void setPsychicadjustName(String psychicadjustName) {
		this.psychicadjustName = psychicadjustName;
	}

	public String getObeydoctorbehavioName() {
		return DictUtil.getDictValue("gxy-zyxw", this.obeydoctorbehavio);
	}

	public void setObeydoctorbehavioName(String obeydoctorbehavioName) {
		this.obeydoctorbehavioName = obeydoctorbehavioName;
	}

	public String getMedicationcomplianceName() {
		return DictUtil.getDictValue("tj-zyyyqk-fyycx", this.medicationcompliance);
	}

	public void setMedicationcomplianceName(String medicationcomplianceName) {
		this.medicationcomplianceName = medicationcomplianceName;
	}

	public String getAdrName() {
		return DictUtil.getDictValue("gxy-ywblfy", this.adr);
	}

	public void setAdrName(String adrName) {
		this.adrName = adrName;
	}

	public String getFollowupwayName() {
		return DictUtil.getDictValue("sffs", followupway);

	}

	public void setFollowupwayName(String followupwayName) {
		this.followupwayName = followupwayName;
	}

	public String getFollowuptypeName() {
		return DictUtil.getDictValue("gxy-sffl", this.followuptype);
	}

	public void setFollowuptypeName(String followuptypeName) {
		this.followuptypeName = followuptypeName;
	}


	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTjbh() {
		return this.tjbh;
	}

	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
	}

	public String getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getIdcardno() {
		return this.idcardno;
	}

	public void setIdcardno(String idcardno) {
		this.idcardno = idcardno;
	}

	public Date getFollowupdate() {
		return this.followupdate;
	}

	public void setFollowupdate(Date followupdate) {
		this.followupdate = followupdate;
	}

	public String getFollowupdoctor() {
		return this.followupdoctor;
	}

	public void setFollowupdoctor(String followupdoctor) {
		this.followupdoctor = followupdoctor;
	}

	public Date getNextfollowupdate() {
		return this.nextfollowupdate;
	}

	public void setNextfollowupdate(Date nextfollowupdate) {
		this.nextfollowupdate = nextfollowupdate;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getSymptomother() {
		return this.symptomother;
	}

	public void setSymptomother(String symptomother) {
		this.symptomother = symptomother;
	}

	public String getHypertension() {
		return this.hypertension;
	}

	public void setHypertension(String hypertension) {
		this.hypertension = hypertension;
	}

	public String getHypotension() {
		return this.hypotension;
	}

	public void setHypotension(String hypotension) {
		this.hypotension = hypotension;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSignother() {
		return this.signother;
	}

	public void setSignother(String signother) {
		this.signother = signother;
	}

	public String getDrugcontrol() {
		return this.drugcontrol;
	}

	public void setDrugcontrol(String drugcontrol) {
		this.drugcontrol = drugcontrol;
	}

	public String getSmokedrinkattention() {
		return this.smokedrinkattention;
	}

	public void setSmokedrinkattention(String smokedrinkattention) {
		this.smokedrinkattention = smokedrinkattention;
	}

	public String getSportattention() {
		return this.sportattention;
	}

	public void setSportattention(String sportattention) {
		this.sportattention = sportattention;
	}

	public String getEatsaltattention() {
		return this.eatsaltattention;
	}

	public void setEatsaltattention(String eatsaltattention) {
		this.eatsaltattention = eatsaltattention;
	}

	public String getPsychicadjust() {
		return this.psychicadjust;
	}

	public void setPsychicadjust(String psychicadjust) {
		this.psychicadjust = psychicadjust;
	}

	public String getObeydoctorbehavio() {
		return this.obeydoctorbehavio;
	}

	public void setObeydoctorbehavio(String obeydoctorbehavio) {
		this.obeydoctorbehavio = obeydoctorbehavio;
	}

	public String getAssistantexam() {
		return this.assistantexam;
	}

	public void setAssistantexam(String assistantexam) {
		this.assistantexam = assistantexam;
	}

	public String getMedicationcompliance() {
		return this.medicationcompliance;
	}

	public void setMedicationcompliance(String medicationcompliance) {
		this.medicationcompliance = medicationcompliance;
	}

	public String getAdr() {
		return this.adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getAdrex() {
		return this.adrex;
	}

	public void setAdrex(String adrex) {
		this.adrex = adrex;
	}

	public String getFollowuptype() {
		return this.followuptype;
	}

	public void setFollowuptype(String followuptype) {
		this.followuptype = followuptype;
	}

	public String getReferralreason() {
		return this.referralreason;
	}

	public void setReferralreason(String referralreason) {
		this.referralreason = referralreason;
	}

	public String getReferralorg() {
		return this.referralorg;
	}

	public void setReferralorg(String referralorg) {
		this.referralorg = referralorg;
	}

	public String getFollowupway() {
		return this.followupway;
	}

	public void setFollowupway(String followupway) {
		this.followupway = followupway;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getLastupdateby() {
		return this.lastupdateby;
	}

	public void setLastupdateby(String lastupdateby) {
		this.lastupdateby = lastupdateby;
	}

	public Date getLastupdatedate() {
		return this.lastupdatedate;
	}

	public void setLastupdatedate(Date lastupdatedate) {
		this.lastupdatedate = lastupdatedate;
	}

	public String getIsdel() {
		return this.isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public String getRecordid() {
		return this.recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

	public String getEatingdrug() {
		return this.eatingdrug;
	}

	public void setEatingdrug(String eatingdrug) {
		this.eatingdrug = eatingdrug;
	}

	public String getYwmc1() {
		return this.ywmc1;
	}

	public void setYwmc1(String ywmc1) {
		this.ywmc1 = ywmc1;
	}

	public String getYwmc1ci() {
		return this.ywmc1ci;
	}

	public void setYwmc1ci(String ywmc1ci) {
		this.ywmc1ci = ywmc1ci;
	}

	public String getYwmc1mg() {
		return this.ywmc1mg;
	}

	public void setYwmc1mg(String ywmc1mg) {
		this.ywmc1mg = ywmc1mg;
	}

	public String getYwmc2() {
		return this.ywmc2;
	}

	public void setYwmc2(String ywmc2) {
		this.ywmc2 = ywmc2;
	}

	public String getYwmc2ci() {
		return this.ywmc2ci;
	}

	public void setYwmc2ci(String ywmc2ci) {
		this.ywmc2ci = ywmc2ci;
	}

	public String getYwmc2mg() {
		return this.ywmc2mg;
	}

	public void setYwmc2mg(String ywmc2mg) {
		this.ywmc2mg = ywmc2mg;
	}

	public String getYwmc3() {
		return this.ywmc3;
	}

	public void setYwmc3(String ywmc3) {
		this.ywmc3 = ywmc3;
	}

	public String getYwmc3ci() {
		return this.ywmc3ci;
	}

	public void setYwmc3ci(String ywmc3ci) {
		this.ywmc3ci = ywmc3ci;
	}

	public String getYwmc3mg() {
		return this.ywmc3mg;
	}

	public void setYwmc3mg(String ywmc3mg) {
		this.ywmc3mg = ywmc3mg;
	}

	public String getQtyw() {
		return this.qtyw;
	}

	public void setQtyw(String qtyw) {
		this.qtyw = qtyw;
	}

	public String getQtywci() {
		return this.qtywci;
	}

	public void setQtywci(String qtywci) {
		this.qtywci = qtywci;
	}

	public String getQtywmg() {
		return this.qtywmg;
	}

	public void setQtywmg(String qtywmg) {
		this.qtywmg = qtywmg;
	}

	public String getImportDeviceNum() {
		return this.importDeviceNum;
	}

	public void setImportDeviceNum(String importDeviceNum) {
		this.importDeviceNum = importDeviceNum;
	}

	public Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public String getImportUser() {
		return this.importUser;
	}

	public void setImportUser(String importUser) {
		this.importUser = importUser;
	}

	public String getImportIp() {
		return this.importIp;
	}

	public void setImportIp(String importIp) {
		this.importIp = importIp;
	}

	public String getSynFlg() {
		return this.synFlg;
	}

	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getDataSourceNo() {
		return dataSourceNo;
	}

	public void setDataSourceNo(String dataSourceNo) {
		this.dataSourceNo = dataSourceNo;
	}

	public String getSynId() {
		return synId;
	}

	public void setSynId(String synId) {
		this.synId = synId;
	}

	public Date getSynTime() {
		return synTime;
	}

	public void setSynTime(Date synTime) {
		this.synTime = synTime;
	}

}
