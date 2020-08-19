package com.region.moudles.hospital.domain;

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
@Table(name = "hospital_image")
public class HospitalImage extends BaseDomain {

    private static final long serialVersionUID = 36554949L;

    @Id
    private String id;//内码
    @Column(name = "ar_id")
    private String arId;//入院登记内码
    private String imageUrl;//压缩dcm路径
    private String imageJpgUrl;//图片路径
    private String imageRemake;//描述
    private String imageJl;//结论
    @JSONField(format = "yyyy-MM-dd")
    private Date imageTime;//检查时间
    @Column(name = "image_type")
    private String imageType;//病案首页内码
    private String hospitalId;
    private String hisId;


    @Transient
    private List<HospitalImage> imagelist;
    @Transient
    private String orgCode;

    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArId() {
        return arId;
    }

    public void setArId(String arId) {
        this.arId = arId;
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

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public List<HospitalImage> getImagelist() {
        return imagelist;
    }

    public void setImagelist(List<HospitalImage> imagelist) {
        this.imagelist = imagelist;
    }
}
