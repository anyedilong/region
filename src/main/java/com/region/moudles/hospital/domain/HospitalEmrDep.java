package com.region.moudles.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="hospital_emr_dep")
public class HospitalEmrDep extends BaseDomain {

      @Id
      private  String id;//内码
    @Column(name="ich_id")
      private  String ichId;//病案首页内码
      private  String depType;//科别类型
      private  String depCode;//科别代码
      private  String depName;//科别名称
      private  String ward;//病房
      @JSONField(format="yyyy-MM-dd")
      private  Date createTime;//创建时间

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    public String getIchId() {
		return ichId;
	}

	public void setIchId(String ichId) {
		this.ichId = ichId;
	}

	public String getDepType() {
        return depType;
    }

    public void setDepType(String depType) {
        this.depType = depType;
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

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
