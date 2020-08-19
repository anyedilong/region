package com.region.moudles.outpatient.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

@Entity
@Table(name="outpatient_image")
public class OutpatientImage extends BaseDomain {

	private static final long serialVersionUID = 524234345345L;
	
    @Id
    private  String  id;//内码
    @Column(name = "outpatient_num")
    private  String  outpatientNum;//本次门诊标识号
    private  String  imageUrl;//压缩dcm文件路径
    private  String  imageJpgUrl;//图片路径
    private  String  imageRemake;//描述
    private  String  imageJl;//结论
    @JSONField(format = "yyyy-MM-dd")
    private  Date imageTime;//检查时间
	private String imageType;// 影像类型
    @Column(name = "medical_record_id")
	private String medicalRecordId;// 门诊病历id

    @Transient
    private List<OutpatientImage> imagelist;
    @Transient
    private String orgCode;
    @Transient
    private String hisId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }

    public String getOutpatientNum() {
        return outpatientNum;
    }

    public void setOutpatientNum(String outpatientNum) {
        this.outpatientNum = outpatientNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageRemake() {
        return imageRemake;
    }

    public void setImageRemake(String imageRemake) {
        this.imageRemake = imageRemake;
    }

    public String getImageJl() {
        return imageJl;
    }

    public void setImageJl(String imageJl) {
        this.imageJl = imageJl;
    }

    public Date getImageTime() {
        return imageTime;
    }

    public void setImageTime(Date imageTime) {
        this.imageTime = imageTime;
    }

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public String getImageJpgUrl() {
		return imageJpgUrl;
	}

	public void setImageJpgUrl(String imageJpgUrl) {
		this.imageJpgUrl = imageJpgUrl;
	}

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

	public List<OutpatientImage> getImagelist() {
		return imagelist;
	}

	public void setImagelist(List<OutpatientImage> imagelist) {
		this.imagelist = imagelist;
	}
}
