package com.region.moudles.tripartdock.health.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 会诊记录
 */
@Entity
@Table(name = "HEALTH_HZJL")
public class Hzjl extends BaseDomain {

    @Id
    private String id;
    private String sfzh; //身份证号
    private String jmid; //居民ID
    private String hzbh; //患者编号
    private String zrys; //责任医生
    private String zrysName;
    private String hzyy; //会诊原因
    private String hzjy; //会诊建议
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;//   创建时间
    private String sfsc = "0"; //是否删除

    //会诊医生
    @OneToMany(cascade = { CascadeType.DETACH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "hzid", referencedColumnName = "id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HzjlYs> hzysList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getJmid() {
        return jmid;
    }

    public void setJmid(String jmid) {
        this.jmid = jmid;
    }

    public String getHzbh() {
        return hzbh;
    }

    public void setHzbh(String hzbh) {
        this.hzbh = hzbh;
    }

    public String getHzyy() {
        return hzyy;
    }

    public void setHzyy(String hzyy) {
        this.hzyy = hzyy;
    }

    public String getHzjy() {
        return hzjy;
    }

    public void setHzjy(String hzjy) {
        this.hzjy = hzjy;
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

    public List<HzjlYs> getHzysList() {
        return hzysList;
    }

    public void setHzysList(List<HzjlYs> hzysList) {
        this.hzysList = hzysList;
    }

    public String getZrys() {
        return zrys;
    }

    public void setZrys(String zrys) {
        this.zrys = zrys;
    }

    public String getZrysName() {
        return zrysName;
    }

    public void setZrysName(String zrysName) {
        this.zrysName = zrysName;
    }

    public Hzjl() {
    }
}
