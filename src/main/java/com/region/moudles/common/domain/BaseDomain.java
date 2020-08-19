package com.region.moudles.common.domain;


import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;

@Inheritance(strategy = InheritanceType.JOINED)
public class BaseDomain implements  java.io.Serializable {

    /**
     * @Field @serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    
    private String id;

	@JSONField(serialize = false)
	@Transient // 不映射进数据库
	private boolean isNewRecord;// 添加修改标志

	public boolean isNewRecord() {
		return isNewRecord;
	}

	public void setNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
