package com.region.moudles.tripartdock.health.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;
import com.region.until.StringUntil;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "blt_jbxxjlb")
public class BaseCustomerDomain extends BaseDomain {
    @Id
    private String id;
    private String jlh;
    private String hzmc;// 患者名称
    private String xb;// 患者性别
    @Transient
    private String xbName;// 患者性别
    private String sfzh;// 身份证号
    @JSONField(format = "yyyy-MM-dd")
    private Date csrq;// 出生日期
    private String sj;// 联系方式
    private String rqlx; // 人群类型
    private String jkfl;// 健康分类Code值
    @Transient
    private String jkflName;// 健康分类名字
    @Transient
    private String rqlxName; // 人群类型 value
    
    private String xzz;// 现住址
	private String jtzz;// 家庭住址
    @Transient
    private String tsrqlxText;//特殊人群类型
    @Transient
    private String age;// 年龄

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJlh() {
        return jlh;
    }

    public void setJlh(String jlh) {
        this.jlh = jlh;
    }

    public String getHzmc() {
        return hzmc;
    }

    public void setHzmc(String hzmc) {
        this.hzmc = hzmc;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public String getRqlx() {
        return rqlx;
    }

    public void setRqlx(String rqlx) {
    	//人群类型分成人群分类和特殊人群分类
		if(!StringUntil.isNull(rqlx)) {
			String temp = rqlx.replace("101", "").replace("102", "").replace("103", "").replace("104", "")
							.replace("201", "").replace("301", "").replace("302", "").replace("303", "")
							.replace("304", "").replace("401", "").replace("10", "").replace("11", "")
							.replace("12", "").replace("13", "");
			String[] arr = temp.split(",");
			String rqType = "";
			for(int i = 0; i < arr.length; i++) {
				if("1".equals(arr[i])) {
					this.rqlxName = "一般人群";
				}else if("2".equals(arr[i])) {
					this.rqlxName = "儿童";
				}else if("3".equals(arr[i])) {
					this.rqlxName = "孕产妇";
				}else if("4".equals(arr[i])) {
					this.rqlxName = "老年人";
				}else {
					rqType += "," + arr[i];
				}
			}
			this.tsrqlxText = DictUtil.getDictValue("rqlx", rqType);
		}
        this.rqlx = rqlx;
    }

    public String getXbName() {
        return DictUtil.getDictValue("da-xb", this.xb);
    }

    public void setXbName(String xbName) {
        this.xbName = xbName;
    }

    public String getJkflName() {
        return jkflName;
    }

    public void setJkflName(String jkflName) {
        this.jkflName = jkflName;
    }

    public String getRqlxName() {
        return rqlxName;
    }

    public void setRqlxName(String rqlxName) {
        this.rqlxName = rqlxName;
    }

    public String getJkfl() {
        return jkfl;
    }

    public void setJkfl(String jkfl) {
        this.jkfl = jkfl;
    }

	public String getTsrqlxText() {
		return tsrqlxText;
	}

	public void setTsrqlxText(String tsrqlxText) {
		this.tsrqlxText = tsrqlxText;
	}

	public String getXzz() {
		return xzz;
	}

	public void setXzz(String xzz) {
		this.xzz = xzz;
	}

	public String getJtzz() {
		return jtzz;
	}

	public void setJtzz(String jtzz) {
		this.jtzz = jtzz;
	}

    public String getAge() {
        return StringUntil.getAge(sfzh);
    }

    public void setAge(String age) {
        this.age = age;
    }
}
