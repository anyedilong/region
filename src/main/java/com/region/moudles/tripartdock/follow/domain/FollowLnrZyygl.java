package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.until.DictUtil;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: FollowLnrZyygl
 * @Description: 随访-老年人-中医药管理
 * @author Administrator
 * @date 2019年8月2日
 */
@Entity
@Table(name = "blt_lnrzlnlpgb")
public class FollowLnrZyygl extends BaseDomain {

	private static final long serialVersionUID = 264949649996L;
	
	@Id
    private String id;//ID
    private String jmid;//居民id
    private String dah;// 档案号
    private String sfzh;// 身份证号
    private String hzbh;// 患者编号
    private String tjbh;// 体检编号
    private String jlcp;// 精力充沛
    private String rypf;// 容易疲乏
    private String hxdc;// 呼吸短促
    private String sydrwl;// 声音低弱无力
    private String qxdc;// 情绪低沉
    private String jzjl;// 紧张焦虑
    private String gdsl;// 孤独失落
    private String hphjx;// 易感到害怕或惊吓
    private String stcz;// 感觉身体沉重
    private String yjgs;// 眼睛干涩
    private String sjfl;// 手脚发凉
    private String wwbbhxbfl;// 胃脘背部或腰部膝关节怕冷
    private String nhqk;// 耐寒情况
    private String rygm;// 容易感冒
    private String lbt;// 没有感冒时鼻塞流鼻涕吗
    private String knkn;// 有口粘口腻或睡眠打鼾
    private String gm;// 过敏
    private String xmz;// 皮肤容易起荨麻疹
    private String pfqzyb;// 皮肤不知不觉出现青紫瘀斑
    private String pfzh;// 皮肤一抓就红并出现抓痕
    private String kcgz;// 皮肤或口唇干吗
    private String ztmm;// 肢体麻木或固定部位疼痛的感觉
    private String mbyn;// 面部或鼻部有油腻感或油亮发光
    private String msha;// 面色或目框灰暗
    private String pfsz;// 皮肤湿疹
    private String kgsz;// 口干舌燥总想喝水
    private String kkyyw;// 口苦或口里有意味
    private String fbfd;// 腹部肥大吗
    private String clbsf;// 吃凉的东西会感到不舒服
    private String dbnzbs;// 大便粘滞不爽解不尽的感觉
    private String dbgz;// 大便干燥
    private String sthm;// 舌苔厚密
    private String sxjmyz;// 舌下静脉淤紫
    private String jbr;// 建表人
    @JSONField(format = "yyyy-MM-dd")
    private Date jbrq;// 建表日期
    private String scxgr;// 上次修改人
    private Date scxgrq;// 上次修改日期
    private String sfys;// 随访医生
    @JSONField(format = "yyyy-MM-dd")
    private Date jlrq;// 随访日期
    private String sfsc;// 是否删除
    @JSONField(format = "yyyy-MM-dd")
    private Date xcsfrq;// 下次随访日期

    @Column(updatable = false)
    private String dataSource;// 数据来源 1平台 2平板 3手机
    @Column(updatable = false)
    private String dataSourceNo;// 数据来源唯一标志
    @Column(updatable = false)
    private String importDeviceNum;// 导入设备号
    @Column(updatable = false)
    private Date importTime;// 导入时间
    @Column(updatable = false)
    private String importUser;// 导入人
    @Column(updatable = false)
    private String importIp;// 导入IP
    private String synFlg = "0";// 是否同步 0 否 1 是
    @Column(updatable = false)
    private String synId;// 同步ID
    @Column(updatable = false)
    private Date synTime;// 同步时间

    private String updateFlg;

    // 随访-老年人-中医药管理-结果
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id", referencedColumnName = "pgid", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private FollowLnrZyyglJg followLnrZyyglJg;


    @Transient
    private String jlcpName;// 精力充沛
    @Transient
    private String rypfName;// 容易疲乏
    @Transient
    private String hxdcName;// 呼吸短促
    @Transient
    private String sydrwlName;// 声音低弱无力
    @Transient
    private String qxdcName;// 情绪低沉
    @Transient
    private String jzjlName;// 紧张焦虑
    @Transient
    private String gdslName;// 孤独失落
    @Transient
    private String hphjxName;// 易感到害怕或惊吓
    @Transient
    private String stczName;// 感觉身体沉重
    @Transient
    private String yjgsName;// 眼睛干涩
    @Transient
    private String sjflName;// 手脚发凉
    @Transient
    private String wwbbhxbflName;// 胃脘背部或腰部膝关节怕冷
    @Transient
    private String nhqkName;// 耐寒情况
    @Transient
    private String rygmName;// 容易感冒
    @Transient
    private String lbtName;// 没有感冒时鼻塞流鼻涕吗
    @Transient
    private String knknName;// 有口粘口腻或睡眠打鼾
    @Transient
    private String gmName;// 过敏
    @Transient
    private String xmzName;// 皮肤容易起荨麻疹
    @Transient
    private String pfqzybName;// 皮肤不知不觉出现青紫瘀斑
    @Transient
    private String pfzhName;// 皮肤一抓就红并出现抓痕
    @Transient
    private String kcgzName;// 皮肤或口唇干吗
    @Transient
    private String ztmmName;// 肢体麻木或固定部位疼痛的感觉
    @Transient
    private String mbynName;// 面部或鼻部有油腻感或油亮发光
    @Transient
    private String mshaName;// 面色或目框灰暗
    @Transient
    private String pfszName;// 皮肤湿疹
    @Transient
    private String kgszName;// 口干舌燥总想喝水
    @Transient
    private String kkyywName;// 口苦或口里有意味
    @Transient
    private String fbfdName;// 腹部肥大吗
    @Transient
    private String clbsfName;// 吃凉的东西会感到不舒服
    @Transient
    private String dbnzbsName;// 大便粘滞不爽解不尽的感觉
    @Transient
    private String dbgzName;// 大便干燥
    @Transient
    private String sthmName;// 舌苔厚密
    @Transient
    private String sxjmyzName;// 舌下静脉淤紫
    @Transient
    private String orgName;// 精力充沛

    public String getJlcpName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.jlcp);
    }

    public void setJlcpName(String jlcpName) {
        this.jlcpName = jlcpName;
    }

    public String getRypfName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.rypf);
    }

    public void setRypfName(String rypfName) {
        this.rypfName = rypfName;
    }

    public String getHxdcName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.hxdc);
    }

    public void setHxdcName(String hxdcName) {
        this.hxdcName = hxdcName;
    }

    public String getSydrwlName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.sydrwl);
    }

    public void setSydrwlName(String sydrwlName) {
        this.sydrwlName = sydrwlName;
    }

    public String getQxdcName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.qxdc);
    }

    public void setQxdcName(String qxdcName) {
        this.qxdcName = qxdcName;
    }

    public String getJzjlName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.jzjl);
    }

    public void setJzjlName(String jzjlName) {
        this.jzjlName = jzjlName;
    }

    public String getGdslName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.gdsl);
    }

    public void setGdslName(String gdslName) {
        this.gdslName = gdslName;
    }

    public String getHphjxName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.hphjx);
    }

    public void setHphjxName(String hphjxName) {
        this.hphjxName = hphjxName;
    }

    public String getStczName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.stcz);
    }

    public void setStczName(String stczName) {
        this.stczName = stczName;
    }

    public String getYjgsName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.yjgs);
    }

    public void setYjgsName(String yjgsName) {
        this.yjgsName = yjgsName;
    }

    public String getSjflName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.sjfl);
    }

    public void setSjflName(String sjflName) {
        this.sjflName = sjflName;
    }

    public String getWwbbhxbflName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.wwbbhxbfl);
    }

    public void setWwbbhxbflName(String wwbbhxbflName) {
        this.wwbbhxbflName = wwbbhxbflName;
    }

    public String getNhqkName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.nhqk);
    }

    public void setNhqkName(String nhqkName) {
        this.nhqkName = nhqkName;
    }

    public String getRygmName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.rygm);
    }

    public void setRygmName(String rygmName) {
        this.rygmName = rygmName;
    }

    public String getLbtName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.lbt);
    }

    public void setLbtName(String lbtName) {
        this.lbtName = lbtName;
    }

    public String getKnknName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.knkn);
    }

    public void setKnknName(String knknName) {
        this.knknName = knknName;
    }

    public String getGmName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.gm);
    }

    public void setGmName(String gmName) {
        this.gmName = gmName;
    }

    public String getXmzName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.xmz);
    }

    public void setXmzName(String xmzName) {
        this.xmzName = xmzName;
    }

    public String getPfqzybName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.pfqzyb);
    }

    public void setPfqzybName(String pfqzybName) {
        this.pfqzybName = pfqzybName;
    }

    public String getPfzhName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.pfzh);
    }

    public void setPfzhName(String pfzhName) {
        this.pfzhName = pfzhName;
    }

    public String getKcgzName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.kcgz);
    }

    public void setKcgzName(String kcgzName) {
        this.kcgzName = kcgzName;
    }

    public String getZtmmName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.ztmm);
    }

    public void setZtmmName(String ztmmName) {
        this.ztmmName = ztmmName;
    }

    public String getMbynName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.mbyn);
    }

    public void setMbynName(String mbynName) {
        this.mbynName = mbynName;
    }

    public String getMshaName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.msha);
    }

    public void setMshaName(String mshaName) {
        this.mshaName = mshaName;
    }

    public String getPfszName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.pfsz);
    }

    public void setPfszName(String pfszName) {
        this.pfszName = pfszName;
    }

    public String getKgszName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.kgsz);
    }

    public void setKgszName(String kgszName) {
        this.kgszName = kgszName;
    }

    public String getKkyywName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.kkyyw);
    }

    public void setKkyywName(String kkyywName) {
        this.kkyywName = kkyywName;
    }

    public String getFbfdName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.fbfd);
    }

    public void setFbfdName(String fbfdName) {
        this.fbfdName = fbfdName;
    }

    public String getClbsfName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.clbsf);
    }

    public void setClbsfName(String clbsfName) {
        this.clbsfName = clbsfName;
    }

    public String getDbnzbsName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.dbnzbs);
    }

    public void setDbnzbsName(String dbnzbsName) {
        this.dbnzbsName = dbnzbsName;
    }

    public String getDbgzName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.dbgz);
    }

    public void setDbgzName(String dbgzName) {
        this.dbgzName = dbgzName;
    }

    public String getSthmName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.sthm);
    }

    public void setSthmName(String sthmName) {
        this.sthmName = sthmName;
    }

    public String getSxjmyzName() {
        return DictUtil.getDictValue("lnr-zlnlpg", this.sxjmyz);
    }

    public void setSxjmyzName(String sxjmyzName) {
        this.sxjmyzName = sxjmyzName;
    }



    public FollowLnrZyyglJg getFollowLnrZyyglJg() {
        return followLnrZyyglJg;
    }

    public void setFollowLnrZyyglJg(FollowLnrZyyglJg followLnrZyyglJg) {
        this.followLnrZyyglJg = followLnrZyyglJg;
    }

    public String getJmid() {
        return jmid;
    }

    public void setJmid(String jmid) {
        this.jmid = jmid;
    }

    public String getUpdateFlg() {
        return updateFlg;
    }

    public void setUpdateFlg(String updateFlg) {
        this.updateFlg = updateFlg;
    }

    public String getFbfd() {
        return this.fbfd;
    }

    public void setFbfd(String fbfd) {
        this.fbfd = fbfd;
    }

    public String getClbsf() {
        return this.clbsf;
    }

    public void setClbsf(String clbsf) {
        this.clbsf = clbsf;
    }

    public String getDbnzbs() {
        return this.dbnzbs;
    }

    public void setDbnzbs(String dbnzbs) {
        this.dbnzbs = dbnzbs;
    }

    public String getDbgz() {
        return this.dbgz;
    }

    public void setDbgz(String dbgz) {
        this.dbgz = dbgz;
    }

    public String getSthm() {
        return this.sthm;
    }

    public void setSthm(String sthm) {
        this.sthm = sthm;
    }

    public String getSxjmyz() {
        return this.sxjmyz;
    }

    public void setSxjmyz(String sxjmyz) {
        this.sxjmyz = sxjmyz;
    }

    public String getJbr() {
        return this.jbr;
    }

    public void setJbr(String jbr) {
        this.jbr = jbr;
    }

    public Date getJbrq() {
        return this.jbrq;
    }

    public void setJbrq(Date jbrq) {
        this.jbrq = jbrq;
    }

    public String getScxgr() {
        return this.scxgr;
    }

    public void setScxgr(String scxgr) {
        this.scxgr = scxgr;
    }

    public Date getScxgrq() {
        return this.scxgrq;
    }

    public void setScxgrq(Date scxgrq) {
        this.scxgrq = scxgrq;
    }

    public String getSfys() {
        return this.sfys;
    }

    public void setSfys(String sfys) {
        this.sfys = sfys;
    }

    public Date getJlrq() {
        return this.jlrq;
    }

    public void setJlrq(Date jlrq) {
        this.jlrq = jlrq;
    }

    public String getSfsc() {
        return this.sfsc;
    }

    public void setSfsc(String sfsc) {
        this.sfsc = sfsc;
    }

    public String getImportDeviceNum() {
        return this.importDeviceNum;
    }

    public void setImportDeviceNum(String importDeviceNum) {
        this.importDeviceNum = importDeviceNum;
    }

    public Date getImportTime() {
        return this.importTime;
    }

    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    public String getImportUser() {
        return this.importUser;
    }

    public void setImportUser(String importUser) {
        this.importUser = importUser;
    }

    public String getImportIp() {
        return this.importIp;
    }

    public void setImportIp(String importIp) {
        this.importIp = importIp;
    }

    public String getSynFlg() {
        return this.synFlg;
    }

    public void setSynFlg(String synFlg) {
        this.synFlg = synFlg;
    }

    public Date getXcsfrq() {
        return this.xcsfrq;
    }

    public void setXcsfrq(Date xcsfrq) {
        this.xcsfrq = xcsfrq;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDah() {
        return this.dah;
    }

    public void setDah(String dah) {
        this.dah = dah;
    }

    public String getSfzh() {
        return this.sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getHzbh() {
        return this.hzbh;
    }

    public void setHzbh(String hzbh) {
        this.hzbh = hzbh;
    }

    public String getTjbh() {
        return this.tjbh;
    }

    public void setTjbh(String tjbh) {
        this.tjbh = tjbh;
    }

    public String getJlcp() {
        return this.jlcp;
    }

    public void setJlcp(String jlcp) {
        this.jlcp = jlcp;
    }

    public String getRypf() {
        return this.rypf;
    }

    public void setRypf(String rypf) {
        this.rypf = rypf;
    }

    public String getHxdc() {
        return this.hxdc;
    }

    public void setHxdc(String hxdc) {
        this.hxdc = hxdc;
    }

    public String getSydrwl() {
        return this.sydrwl;
    }

    public void setSydrwl(String sydrwl) {
        this.sydrwl = sydrwl;
    }

    public String getQxdc() {
        return this.qxdc;
    }

    public void setQxdc(String qxdc) {
        this.qxdc = qxdc;
    }

    public String getJzjl() {
        return this.jzjl;
    }

    public void setJzjl(String jzjl) {
        this.jzjl = jzjl;
    }

    public String getGdsl() {
        return this.gdsl;
    }

    public void setGdsl(String gdsl) {
        this.gdsl = gdsl;
    }

    public String getHphjx() {
        return this.hphjx;
    }

    public void setHphjx(String hphjx) {
        this.hphjx = hphjx;
    }

    public String getStcz() {
        return this.stcz;
    }

    public void setStcz(String stcz) {
        this.stcz = stcz;
    }

    public String getYjgs() {
        return this.yjgs;
    }

    public void setYjgs(String yjgs) {
        this.yjgs = yjgs;
    }

    public String getSjfl() {
        return this.sjfl;
    }

    public void setSjfl(String sjfl) {
        this.sjfl = sjfl;
    }

    public String getWwbbhxbfl() {
        return this.wwbbhxbfl;
    }

    public void setWwbbhxbfl(String wwbbhxbfl) {
        this.wwbbhxbfl = wwbbhxbfl;
    }

    public String getNhqk() {
        return this.nhqk;
    }

    public void setNhqk(String nhqk) {
        this.nhqk = nhqk;
    }

    public String getRygm() {
        return this.rygm;
    }

    public void setRygm(String rygm) {
        this.rygm = rygm;
    }

    public String getLbt() {
        return this.lbt;
    }

    public void setLbt(String lbt) {
        this.lbt = lbt;
    }

    public String getKnkn() {
        return this.knkn;
    }

    public void setKnkn(String knkn) {
        this.knkn = knkn;
    }

    public String getGm() {
        return this.gm;
    }

    public void setGm(String gm) {
        this.gm = gm;
    }

    public String getXmz() {
        return this.xmz;
    }

    public void setXmz(String xmz) {
        this.xmz = xmz;
    }

    public String getPfqzyb() {
        return this.pfqzyb;
    }

    public void setPfqzyb(String pfqzyb) {
        this.pfqzyb = pfqzyb;
    }

    public String getPfzh() {
        return this.pfzh;
    }

    public void setPfzh(String pfzh) {
        this.pfzh = pfzh;
    }

    public String getKcgz() {
        return this.kcgz;
    }

    public void setKcgz(String kcgz) {
        this.kcgz = kcgz;
    }

    public String getZtmm() {
        return this.ztmm;
    }

    public void setZtmm(String ztmm) {
        this.ztmm = ztmm;
    }

    public String getMbyn() {
        return this.mbyn;
    }

    public void setMbyn(String mbyn) {
        this.mbyn = mbyn;
    }

    public String getMsha() {
        return this.msha;
    }

    public void setMsha(String msha) {
        this.msha = msha;
    }

    public String getPfsz() {
        return this.pfsz;
    }

    public void setPfsz(String pfsz) {
        this.pfsz = pfsz;
    }

    public String getKgsz() {
        return this.kgsz;
    }

    public void setKgsz(String kgsz) {
        this.kgsz = kgsz;
    }

    public String getKkyyw() {
        return this.kkyyw;
    }

    public void setKkyyw(String kkyyw) {
        this.kkyyw = kkyyw;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDataSourceNo() {
        return dataSourceNo;
    }

    public void setDataSourceNo(String dataSourceNo) {
        this.dataSourceNo = dataSourceNo;
    }

    public String getSynId() {
        return synId;
    }

    public void setSynId(String synId) {
        this.synId = synId;
    }

    public Date getSynTime() {
        return synTime;
    }

    public void setSynTime(Date synTime) {
        this.synTime = synTime;
    }

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

   
}
