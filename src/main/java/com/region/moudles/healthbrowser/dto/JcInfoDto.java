package com.region.moudles.healthbrowser.dto;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: JcInfoDto
 * @Description: 检查信息实体类(惠民平台使用)
 * @author Administrator
 * @date 2020年3月9日
 */
public class JcInfoDto implements Serializable {
	
	private static final long serialVersionUID = 4351216161L;
	
	private String id; 		//门诊或者住院的id
	private String imageId;
    private String type;	//类型1.门诊 2.住院
    private String imageUrl;//doc文件名
    private String imageRemake;//检验说明
    private String imageJl;//检验结论
    private String imageType;//检验类型
    private String imageJpgUrl;//转换后的图片地址
    @JSONField(format="yyyy-MM-dd")
    private Date qzrq;//检验日期
    private String hospital;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getImageJpgUrl() {
		return imageJpgUrl;
	}

	public void setImageJpgUrl(String imageJpgUrl) {
		this.imageJpgUrl = imageJpgUrl;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public Date getQzrq() {
		return qzrq;
	}

	public void setQzrq(Date qzrq) {
		this.qzrq = qzrq;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}


}
