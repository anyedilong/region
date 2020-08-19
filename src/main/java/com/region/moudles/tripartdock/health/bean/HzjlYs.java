package com.region.moudles.tripartdock.health.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 会诊医生
 */
@Entity
@Table(name = "HEALTH_HZJL_YS")
public class HzjlYs extends BaseDomain {
    @Id
    private String id;
    private String hzid; //会诊记录ID
    private String zrys; //责任医生
    private String zrysName;
    private String hzys; //会诊医生
    private String hzysName;
    @JSONField(format = "yyyy-MM-dd")
    private Date hzrq; //会诊日期
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;//   创建时间
    private String sfsc = "0"; //是否删除

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHzid() {
        return hzid;
    }

    public void setHzid(String hzid) {
        this.hzid = hzid;
    }

    public String getZrys() {
        return zrys;
    }

    public void setZrys(String zrys) {
        this.zrys = zrys;
    }

    public String getHzys() {
        return hzys;
    }

    public void setHzys(String hzys) {
        this.hzys = hzys;
    }

    public Date getHzrq() {
        return hzrq;
    }

    public void setHzrq(Date hzrq) {
        this.hzrq = hzrq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSfsc() {
        return sfsc;
    }

    public void setSfsc(String sfsc) {
        this.sfsc = sfsc;
    }

    public String getZrysName() {
        return zrysName;
    }

    public void setZrysName(String zrysName) {
        this.zrysName = zrysName;
    }

    public String getHzysName() {
        return hzysName;
    }

    public void setHzysName(String hzysName) {
        this.hzysName = hzysName;
    }

    public HzjlYs() {
    }
}
