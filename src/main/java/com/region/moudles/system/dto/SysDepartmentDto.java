package com.region.moudles.system.dto;


import java.io.Serializable;


import com.region.moudles.common.domain.PageModel;


public class SysDepartmentDto implements Serializable {

	private static final long serialVersionUID = 123564334L;
	
	private String id;//内码
    private String depCode;//科室代码
    private String depName;//科室名称

    private PageModel page; //分页

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

	public PageModel getPage() {
		return page;
	}

	public void setPage(PageModel page) {
		this.page = page;
	}
}
