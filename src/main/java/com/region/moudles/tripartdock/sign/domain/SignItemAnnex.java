package com.region.moudles.tripartdock.sign.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.region.moudles.common.domain.BaseDomain;


@Entity
@Table(name = "blt_sign_item_annex")
public class SignItemAnnex extends BaseDomain {

	private static final long serialVersionUID = 358589844964L;
	
	@Id
	private String id;// ID
	@Column(name = "sign_item_id")
	private String signItemId;// 签约文件ID
	@Column(name = "annex_md5")
	private String annexMd5;// 附件

	@Transient
	private String fileUrl;//文件地址
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSignItemId() {
		return this.signItemId;
	}

	public void setSignItemId(String signItemId) {
		this.signItemId = signItemId;
	}

	public String getAnnexMd5() {
		return this.annexMd5;
	}

	public void setAnnexMd5(String annexMd5) {
		this.annexMd5 = annexMd5;
	}

}
