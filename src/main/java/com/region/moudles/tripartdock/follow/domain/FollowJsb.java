package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @author Administrator
 * @ClassName: FollowJsb
 * @Description: 随访-精神病-随访
 * @date 2019年8月1日
 */
@Entity
@Table(name = "blt_jsbsfb")
public class FollowJsb extends BaseDomain {

    private static final long serialVersionUID = 94964621L;

    @Id
    private String id;//ID
    private String jmid;//居民id
    private String tjbh;// 体检编号
    private String hzbh;// 患者编号
    private String dah;// 档案号
    private String sfzh;// 身份证号
    @JSONField(format = "yyyy-MM-dd")
    private Date sfrq;// 随访日期
    private String wxx;// 危险性
    private String mqzz;// 目前症状
    private String zzl;// 自知力
    private String mqqtzz;// 目前其他症状（追加）
    private String smqk;// 睡眠情况
    private String ysqk;// 饮食情况
    private String grshll;// 个人生活料理
    private String jwld;// 家务劳动
    private String scldjgz;// 生产劳动及工作
    private String xxnl;// 学习能力
    private String shrjjw;// 社会人际交往
    private String qdzs;// 轻度滋事
    private String zs;// 肇事
    private String zh;// 肇祸
    private String zshang;// 自伤
    private String zsws;// 自杀未遂
    private String wu;// 无
    private String gsqk;// 关锁情况
    private String zyqk;// 住院情况
    @JSONField(format = "yyyy-MM-dd")
    private Date mccysj;// 末次出院时间
    private String sysjc;// 实验室检查
    private String jcms;// 检测描述
    private String fyycx;// 服药依从性
    private String ywblfy;// 药物不良反应
    private String ywblfyms;// 药物不良反应的描述
    private String zlxg;// 治疗效果
    private String sfzd;// 是否转诊
    private String zzyy;// 转诊原因
    private String jgjks;// 机构及科室
    private String kfcs;// 康复措施
    private String qtkfcs;// 其他康复措施
    private String sffl;// 随访分类
    @JSONField(format = "yyyy-MM-dd")
    private Date xcsfrq;// 下次随访日期
    private String sfys;// 随访医生
    private String jbr;// 建表人
    private Date jbrq;// 建表日期
    private String sycxgr;// 上一次修改人
    private Date sycxgrq;// 上一次修改日期
    private String sfsc;// 是否删除
    private String ywmc1;// 药物名称1
    private String ywmc1ci;// 药物名称1每日几次
    private String ywmc1mg;// 药物名称1第次多少mg
    private String ywmc2;// 药物名称2
    private String ywmc2ci;// 药物名称2每日几次
    private String ywmc2mg;// 药物名称2第次多少mg
    private String ywmc3;// 药物名称3
    private String ywmc3ci;// 药物名称3每日几次
    private String ywmc3mg;// 药物名称3第次多少mg
    private String sffs;// 随访方式
    @Transient
    private String sffsName;
    private String loss;// 失访原因
    private String death;// 死亡原因
    private String disease;// 躯体疾病
    @JSONField(format = "yyyy-MM-dd")
    private Date deathrq;// 死亡日期
    private String yyzd1;// 用药指导1
    private String yyzd2;// 用药指导2
    private String yyzd3;// 用药指导3
    private String yyzdyf1;// 用药指导用法1
    private String yyzdyf2;// 用药指导用法2
    private String yyzdyf3;// 用药指导用法3
    private String yyzdyl1;// 用药指导用量1
    private String yyzdyl2;// 用药指导用量2
    private String yyzdyl3;// 用药指导用量3
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

    private String qtwhxw;// 其他危害行为

    private String fileRecordId;// 上传图像返回值
    private String imgUrl;// 平板上传图像保存路径
    private String smiFollowupNo;// 下载冠新返回值

    // 数据库中有，但实体中后来添加的字段
    private String zzlxr; // 转诊联系人
    private String zzlxdh; // 转诊联系电话
    private String sflxzkys; // 是否联系专科医生
    private String jszkysxm; // 精神专科医生姓名
    private String ysdh; // 精神专科医生电话
    private String czjg; // 处置结果
    private String hzhjsqz; // 患者或家属签字
    // 云南版本新增字段
    private String bcsfdx; // 本次随访对象 1患者 2患者家属 3其他知情人
    private String sfyzz; // 是否已转诊
    private String sfjyzz; // 是否建议转诊
    private String ywmc1ry; // 药物名称1 日/月
    private String ywmc2ry; // 药物名称2 日/月
    private String ywmc3ry; // 药物名称3 日/月
    private String yyzd1zaomg; // 用药指导1早多少mg
    private String yyzd1zhongmg; // 用药指导1中多少mg
    private String yyzd1wanmg; // 用药指导1晚多少mg
    private String yyzd1mzci; // 用药指导1每周几次
    private String yyzd1mcmg; // 用药指导1每次多少mg
    private String yyzd2zaomg; // 用药指导2早多少mg
    private String yyzd2zhongmg; // 用药指导2中多少mg
    private String yyzd2wanmg; // 用药指导2晚多少mg
    private String yyzd2mzci; // 用药指导2每周几次
    private String yyzd2mcmg; // 用药指导2每次多少mg
    private String yyzd3zaomg; // 用药指导3早多少mg
    private String yyzd3zhongmg; // 用药指导3中多少mg
    private String yyzd3wanmg; // 用药指导3晚多少mg
    private String yyzd3mzci; // 用药指导3每周几次
    private String yyzd3mcmg; // 用药指导3每次多少mg

    // 万达平台上传缺失字段
    private String sftzlxbm;// 是否通知联席部门
    private String slrxm1;// 公安部门受理人姓名
    private String slrdh1;// 公安部门电话
    private String slrxm2;// 社区受理人姓名
    private String slrdh2;// 社区受理人电话
    private String zzks;// 转诊科室


    @Transient
    private String lossName;
    @Transient
    private String deathName;
    @Transient
    private String diseaseName;
    @Transient
    private String mqzzName;
    @Transient
    private String zzlName;
    @Transient
    private String smqkName;
    @Transient
    private String ysqkName;
    @Transient
    private String grshllName;
    @Transient
    private String jwldName;
    @Transient
    private String scldjgzName;
    @Transient
    private String xxnlName;
    @Transient
    private String shrjjwName;
    @Transient
    private String gsqkName;
    @Transient
    private String zyqkName;
    @Transient
    private String sysjcName;
    @Transient
    private String fyycxName;
    @Transient
    private String ywblfyName;
    @Transient
    private String zlxgName;
    @Transient
    private String sfzdName;
    @Transient
    private String kfcsName;
    @Transient
    private String sfflName;

    public String getLossName() {
        return DictUtil.getDictValue("jsb-sfyy", this.loss);
    }

    public void setLossName(String lossName) {
        this.lossName = lossName;
    }

    public String getDeathName() {
        return DictUtil.getDictValue("jsb-swyy", this.death);
    }

    public void setDeathName(String deathName) {
        this.deathName = deathName;
    }

    public String getDiseaseName() {
        return DictUtil.getDictValue("jsb-qtjb", this.disease);
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getMqzzName() {
        return DictUtil.getDictValue("jsb-zz", this.mqzz);
    }

    public void setMqzzName(String mqzzName) {
        this.mqzzName = mqzzName;
    }

    public String getZzlName() {
        return DictUtil.getDictValue("jsb-zzl", this.zzl);
    }

    public void setZzlName(String zzlName) {
        this.zzlName = zzlName;
    }

    public String getSmqkName() {
        return DictUtil.getDictValue("jsb-smqk", this.smqk);
    }

    public void setSmqkName(String smqkName) {
        this.smqkName = smqkName;
    }

    public String getYsqkName() {
        return DictUtil.getDictValue("jsb-smqk", this.ysqk);
    }

    public void setYsqkName(String ysqkName) {
        this.ysqkName = ysqkName;
    }

    public String getGrshllName() {
        return DictUtil.getDictValue("jsb-smqk", this.grshll);
    }

    public void setGrshllName(String grshllName) {
        this.grshllName = grshllName;
    }

    public String getJwldName() {
        return DictUtil.getDictValue("jsb-smqk", this.jwld);
    }

    public void setJwldName(String jwldName) {
        this.jwldName = jwldName;
    }

    public String getScldjgzName() {
        return DictUtil.getDictValue("jsb-smqk", this.scldjgz);
    }

    public void setScldjgzName(String scldjgzName) {
        this.scldjgzName = scldjgzName;
    }

    public String getXxnlName() {
        return DictUtil.getDictValue("jsb-smqk", this.xxnl);
    }

    public void setXxnlName(String xxnlName) {
        this.xxnlName = xxnlName;
    }

    public String getShrjjwName() {
        return DictUtil.getDictValue("jsb-smqk", this.shrjjw);
    }

    public void setShrjjwName(String shrjjwName) {
        this.shrjjwName = shrjjwName;
    }

    public String getGsqkName() {
        return DictUtil.getDictValue("jsb-gsqk", this.gsqk);
    }

    public void setGsqkName(String gsqkName) {
        this.gsqkName = gsqkName;
    }

    public String getZyqkName() {
        return DictUtil.getDictValue("jsb-zyqk", this.zyqk);
    }

    public void setZyqkName(String zyqkName) {
        this.zyqkName = zyqkName;
    }

    public String getSysjcName() {
        return DictUtil.getDictValue("gxy-ywblfy", this.sysjc);
    }

    public void setSysjcName(String sysjcName) {
        this.sysjcName = sysjcName;
    }

    public String getFyycxName() {
        return DictUtil.getDictValue("jsb-yyycx", this.fyycx);
    }

    public void setFyycxName(String fyycxName) {
        this.fyycxName = fyycxName;
    }

    public String getYwblfyName() {
        return DictUtil.getDictValue("jsb-ywblfy", this.ywblfy);
    }

    public void setYwblfyName(String ywblfyName) {
        this.ywblfyName = ywblfyName;
    }

    public String getZlxgName() {
        return DictUtil.getDictValue("jsb-zlxg", this.zlxg);
    }

    public void setZlxgName(String zlxgName) {
        this.zlxgName = zlxgName;
    }

    public String getSfzdName() {
        return DictUtil.getDictValue("jsb-sfzz", this.sfzd);
    }

    public void setSfzdName(String sfzdName) {
        this.sfzdName = sfzdName;
    }

    public String getKfcsName() {
        return DictUtil.getDictValue("jsb-kfcs", this.kfcs);
    }

    public void setKfcsName(String kfcsName) {
        this.kfcsName = kfcsName;
    }

    public String getSfflName() {
        return DictUtil.getDictValue("jsb-sffl", this.sffl);
    }

    public void setSfflName(String sfflName) {
        this.sfflName = sfflName;
    }

    public String getJmid() {
        return jmid;
    }

    public void setJmid(String jmid) {
        this.jmid = jmid;
    }

    public String getSftzlxbm() {
        return sftzlxbm;
    }

    public void setSftzlxbm(String sftzlxbm) {
        this.sftzlxbm = sftzlxbm;
    }

    public String getSlrxm1() {
        return slrxm1;
    }

    public void setSlrxm1(String slrxm1) {
        this.slrxm1 = slrxm1;
    }

    public String getSlrdh1() {
        return slrdh1;
    }

    public void setSlrdh1(String slrdh1) {
        this.slrdh1 = slrdh1;
    }

    public String getSlrxm2() {
        return slrxm2;
    }

    public void setSlrxm2(String slrxm2) {
        this.slrxm2 = slrxm2;
    }

    public String getSlrdh2() {
        return slrdh2;
    }

    public void setSlrdh2(String slrdh2) {
        this.slrdh2 = slrdh2;
    }

    public String getZzks() {
        return zzks;
    }

    public void setZzks(String zzks) {
        this.zzks = zzks;
    }

    public String getZzlxr() {
        return zzlxr;
    }

    public void setZzlxr(String zzlxr) {
        this.zzlxr = zzlxr;
    }

    public String getZzlxdh() {
        return zzlxdh;
    }

    public void setZzlxdh(String zzlxdh) {
        this.zzlxdh = zzlxdh;
    }

    public String getSflxzkys() {
        return sflxzkys;
    }

    public void setSflxzkys(String sflxzkys) {
        this.sflxzkys = sflxzkys;
    }

    public String getJszkysxm() {
        return jszkysxm;
    }

    public void setJszkysxm(String jszkysxm) {
        this.jszkysxm = jszkysxm;
    }

    public String getYsdh() {
        return ysdh;
    }

    public void setYsdh(String ysdh) {
        this.ysdh = ysdh;
    }

    public String getCzjg() {
        return czjg;
    }

    public void setCzjg(String czjg) {
        this.czjg = czjg;
    }

    public String getHzhjsqz() {
        return hzhjsqz;
    }

    public void setHzhjsqz(String hzhjsqz) {
        this.hzhjsqz = hzhjsqz;
    }

    public String getSfyzz() {
        return sfyzz;
    }

    public void setSfyzz(String sfyzz) {
        this.sfyzz = sfyzz;
    }

    public String getBcsfdx() {
        return bcsfdx;
    }

    public void setBcsfdx(String bcsfdx) {
        this.bcsfdx = bcsfdx;
    }

    public String getSfjyzz() {
        return sfjyzz;
    }

    public void setSfjyzz(String sfjyzz) {
        this.sfjyzz = sfjyzz;
    }

    public String getYwmc1ry() {
        return ywmc1ry;
    }

    public void setYwmc1ry(String ywmc1ry) {
        this.ywmc1ry = ywmc1ry;
    }

    public String getYwmc2ry() {
        return ywmc2ry;
    }

    public void setYwmc2ry(String ywmc2ry) {
        this.ywmc2ry = ywmc2ry;
    }

    public String getYwmc3ry() {
        return ywmc3ry;
    }

    public void setYwmc3ry(String ywmc3ry) {
        this.ywmc3ry = ywmc3ry;
    }

    public String getYyzd1zaomg() {
        return yyzd1zaomg;
    }

    public void setYyzd1zaomg(String yyzd1zaomg) {
        this.yyzd1zaomg = yyzd1zaomg;
    }

    public String getYyzd1zhongmg() {
        return yyzd1zhongmg;
    }

    public void setYyzd1zhongmg(String yyzd1zhongmg) {
        this.yyzd1zhongmg = yyzd1zhongmg;
    }

    public String getYyzd1wanmg() {
        return yyzd1wanmg;
    }

    public void setYyzd1wanmg(String yyzd1wanmg) {
        this.yyzd1wanmg = yyzd1wanmg;
    }

    public String getYyzd1mzci() {
        return yyzd1mzci;
    }

    public void setYyzd1mzci(String yyzd1mzci) {
        this.yyzd1mzci = yyzd1mzci;
    }

    public String getYyzd1mcmg() {
        return yyzd1mcmg;
    }

    public void setYyzd1mcmg(String yyzd1mcmg) {
        this.yyzd1mcmg = yyzd1mcmg;
    }

    public String getYyzd2zaomg() {
        return yyzd2zaomg;
    }

    public void setYyzd2zaomg(String yyzd2zaomg) {
        this.yyzd2zaomg = yyzd2zaomg;
    }

    public String getYyzd2zhongmg() {
        return yyzd2zhongmg;
    }

    public void setYyzd2zhongmg(String yyzd2zhongmg) {
        this.yyzd2zhongmg = yyzd2zhongmg;
    }

    public String getYyzd2wanmg() {
        return yyzd2wanmg;
    }

    public void setYyzd2wanmg(String yyzd2wanmg) {
        this.yyzd2wanmg = yyzd2wanmg;
    }

    public String getYyzd2mzci() {
        return yyzd2mzci;
    }

    public void setYyzd2mzci(String yyzd2mzci) {
        this.yyzd2mzci = yyzd2mzci;
    }

    public String getYyzd2mcmg() {
        return yyzd2mcmg;
    }

    public void setYyzd2mcmg(String yyzd2mcmg) {
        this.yyzd2mcmg = yyzd2mcmg;
    }

    public String getYyzd3zaomg() {
        return yyzd3zaomg;
    }

    public void setYyzd3zaomg(String yyzd3zaomg) {
        this.yyzd3zaomg = yyzd3zaomg;
    }

    public String getYyzd3zhongmg() {
        return yyzd3zhongmg;
    }

    public void setYyzd3zhongmg(String yyzd3zhongmg) {
        this.yyzd3zhongmg = yyzd3zhongmg;
    }

    public String getYyzd3wanmg() {
        return yyzd3wanmg;
    }

    public void setYyzd3wanmg(String yyzd3wanmg) {
        this.yyzd3wanmg = yyzd3wanmg;
    }

    public String getYyzd3mzci() {
        return yyzd3mzci;
    }

    public void setYyzd3mzci(String yyzd3mzci) {
        this.yyzd3mzci = yyzd3mzci;
    }

    public String getYyzd3mcmg() {
        return yyzd3mcmg;
    }

    public void setYyzd3mcmg(String yyzd3mcmg) {
        this.yyzd3mcmg = yyzd3mcmg;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSmiFollowupNo() {
        return smiFollowupNo;
    }

    public void setSmiFollowupNo(String smiFollowupNo) {
        this.smiFollowupNo = smiFollowupNo;
    }

    public String getFileRecordId() {
        return fileRecordId;
    }

    public void setFileRecordId(String fileRecordId) {
        this.fileRecordId = fileRecordId;
    }

    public String getQtwhxw() {
        return qtwhxw;
    }

    public void setQtwhxw(String qtwhxw) {
        this.qtwhxw = qtwhxw;
    }

    public String getSffs() {
        return this.sffs;
    }

    public void setSffs(String sffs) {
        this.sffs = sffs;
    }

    public String getSffsName() {
        return DictUtil.getDictValue("sffs", this.sffs);
    }

    public void setSffsName(String sffsName) {
        this.sffsName = sffsName;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Date getDeathrq() {
        return deathrq;
    }

    public void setDeathrq(Date deathrq) {
        this.deathrq = deathrq;
    }

    public String getYyzd1() {
        return yyzd1;
    }

    public void setYyzd1(String yyzd1) {
        this.yyzd1 = yyzd1;
    }

    public String getYyzd2() {
        return yyzd2;
    }

    public void setYyzd2(String yyzd2) {
        this.yyzd2 = yyzd2;
    }

    public String getYyzd3() {
        return yyzd3;
    }

    public void setYyzd3(String yyzd3) {
        this.yyzd3 = yyzd3;
    }

    public String getYyzdyf1() {
        return yyzdyf1;
    }

    public void setYyzdyf1(String yyzdyf1) {
        this.yyzdyf1 = yyzdyf1;
    }

    public String getYyzdyf2() {
        return yyzdyf2;
    }

    public void setYyzdyf2(String yyzdyf2) {
        this.yyzdyf2 = yyzdyf2;
    }

    public String getYyzdyf3() {
        return yyzdyf3;
    }

    public void setYyzdyf3(String yyzdyf3) {
        this.yyzdyf3 = yyzdyf3;
    }

    public String getYyzdyl1() {
        return yyzdyl1;
    }

    public void setYyzdyl1(String yyzdyl1) {
        this.yyzdyl1 = yyzdyl1;
    }

    public String getYyzdyl2() {
        return yyzdyl2;
    }

    public void setYyzdyl2(String yyzdyl2) {
        this.yyzdyl2 = yyzdyl2;
    }

    public String getYyzdyl3() {
        return yyzdyl3;
    }

    public void setYyzdyl3(String yyzdyl3) {
        this.yyzdyl3 = yyzdyl3;
    }

    public String getUpdateFlg() {
        return updateFlg;
    }

    public void setUpdateFlg(String updateFlg) {
        this.updateFlg = updateFlg;
    }

    private String updateFlg;// 同步是否修改

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTjbh() {
        return this.tjbh;
    }

    public void setTjbh(String tjbh) {
        this.tjbh = tjbh;
    }

    public String getHzbh() {
        return this.hzbh;
    }

    public void setHzbh(String hzbh) {
        this.hzbh = hzbh;
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

    public Date getSfrq() {
        return this.sfrq;
    }

    public void setSfrq(Date sfrq) {
        this.sfrq = sfrq;
    }

    public String getWxx() {
        return this.wxx;
    }

    public void setWxx(String wxx) {
        this.wxx = wxx;
    }

    public String getMqzz() {
        return this.mqzz;
    }

    public void setMqzz(String mqzz) {
        this.mqzz = mqzz;
    }

    public String getZzl() {
        return this.zzl;
    }

    public void setZzl(String zzl) {
        this.zzl = zzl;
    }

    public String getMqqtzz() {
        return this.mqqtzz;
    }

    public void setMqqtzz(String mqqtzz) {
        this.mqqtzz = mqqtzz;
    }

    public String getSmqk() {
        return this.smqk;
    }

    public void setSmqk(String smqk) {
        this.smqk = smqk;
    }

    public String getYsqk() {
        return this.ysqk;
    }

    public void setYsqk(String ysqk) {
        this.ysqk = ysqk;
    }

    public String getGrshll() {
        return this.grshll;
    }

    public void setGrshll(String grshll) {
        this.grshll = grshll;
    }

    public String getJwld() {
        return this.jwld;
    }

    public void setJwld(String jwld) {
        this.jwld = jwld;
    }

    public String getScldjgz() {
        return this.scldjgz;
    }

    public void setScldjgz(String scldjgz) {
        this.scldjgz = scldjgz;
    }

    public String getXxnl() {
        return this.xxnl;
    }

    public void setXxnl(String xxnl) {
        this.xxnl = xxnl;
    }

    public String getShrjjw() {
        return this.shrjjw;
    }

    public void setShrjjw(String shrjjw) {
        this.shrjjw = shrjjw;
    }

    public String getQdzs() {
        return this.qdzs;
    }

    public void setQdzs(String qdzs) {
        this.qdzs = qdzs;
    }

    public String getZs() {
        return this.zs;
    }

    public void setZs(String zs) {
        this.zs = zs;
    }

    public String getZh() {
        return this.zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public String getZshang() {
        return this.zshang;
    }

    public void setZshang(String zshang) {
        this.zshang = zshang;
    }

    public String getZsws() {
        return this.zsws;
    }

    public void setZsws(String zsws) {
        this.zsws = zsws;
    }

    public String getWu() {
        return this.wu;
    }

    public void setWu(String wu) {
        this.wu = wu;
    }

    public String getGsqk() {
        return this.gsqk;
    }

    public void setGsqk(String gsqk) {
        this.gsqk = gsqk;
    }

    public String getZyqk() {
        return this.zyqk;
    }

    public void setZyqk(String zyqk) {
        this.zyqk = zyqk;
    }

    public Date getMccysj() {
        return this.mccysj;
    }

    public void setMccysj(Date mccysj) {
        this.mccysj = mccysj;
    }

    public String getSysjc() {
        return this.sysjc;
    }

    public void setSysjc(String sysjc) {
        this.sysjc = sysjc;
    }

    public String getJcms() {
        return this.jcms;
    }

    public void setJcms(String jcms) {
        this.jcms = jcms;
    }

    public String getFyycx() {
        return this.fyycx;
    }

    public void setFyycx(String fyycx) {
        this.fyycx = fyycx;
    }

    public String getYwblfy() {
        return this.ywblfy;
    }

    public void setYwblfy(String ywblfy) {
    	this.ywblfyName = DictUtil.getDictValue("jsb-ywblfy", this.ywblfy);
        this.ywblfy = ywblfy;
    }

    public String getYwblfyms() {
        return this.ywblfyms;
    }

    public void setYwblfyms(String ywblfyms) {
        this.ywblfyms = ywblfyms;
    }

    public String getZlxg() {
        return this.zlxg;
    }

    public void setZlxg(String zlxg) {
        this.zlxg = zlxg;
    }

    public String getSfzd() {
        return this.sfzd;
    }

    public void setSfzd(String sfzd) {
        this.sfzd = sfzd;
    }

    public String getZzyy() {
        return this.zzyy;
    }

    public void setZzyy(String zzyy) {
        this.zzyy = zzyy;
    }

    public String getJgjks() {
        return this.jgjks;
    }

    public void setJgjks(String jgjks) {
        this.jgjks = jgjks;
    }

    public String getKfcs() {
        return this.kfcs;
    }

    public void setKfcs(String kfcs) {
        this.kfcs = kfcs;
    }

    public String getQtkfcs() {
        return this.qtkfcs;
    }

    public void setQtkfcs(String qtkfcs) {
        this.qtkfcs = qtkfcs;
    }

    public String getSffl() {
        return this.sffl;
    }

    public void setSffl(String sffl) {
        this.sffl = sffl;
    }

    public Date getXcsfrq() {
        return this.xcsfrq;
    }

    public void setXcsfrq(Date xcsfrq) {
        this.xcsfrq = xcsfrq;
    }

    public String getSfys() {
        return this.sfys;
    }

    public void setSfys(String sfys) {
        this.sfys = sfys;
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

    public String getSycxgr() {
        return this.sycxgr;
    }

    public void setSycxgr(String sycxgr) {
        this.sycxgr = sycxgr;
    }

    public Date getSycxgrq() {
        return this.sycxgrq;
    }

    public void setSycxgrq(Date sycxgrq) {
        this.sycxgrq = sycxgrq;
    }

    public String getSfsc() {
        return this.sfsc;
    }

    public void setSfsc(String sfsc) {
        this.sfsc = sfsc;
    }

    public String getYwmc1() {
        return this.ywmc1;
    }

    public void setYwmc1(String ywmc1) {
        this.ywmc1 = ywmc1;
    }

    public String getYwmc1ci() {
        return this.ywmc1ci;
    }

    public void setYwmc1ci(String ywmc1ci) {
        this.ywmc1ci = ywmc1ci;
    }

    public String getYwmc1mg() {
        return this.ywmc1mg;
    }

    public void setYwmc1mg(String ywmc1mg) {
        this.ywmc1mg = ywmc1mg;
    }

    public String getYwmc2() {
        return this.ywmc2;
    }

    public void setYwmc2(String ywmc2) {
        this.ywmc2 = ywmc2;
    }

    public String getYwmc2ci() {
        return this.ywmc2ci;
    }

    public void setYwmc2ci(String ywmc2ci) {
        this.ywmc2ci = ywmc2ci;
    }

    public String getYwmc2mg() {
        return this.ywmc2mg;
    }

    public void setYwmc2mg(String ywmc2mg) {
        this.ywmc2mg = ywmc2mg;
    }

    public String getYwmc3() {
        return this.ywmc3;
    }

    public void setYwmc3(String ywmc3) {
        this.ywmc3 = ywmc3;
    }

    public String getYwmc3ci() {
        return this.ywmc3ci;
    }

    public void setYwmc3ci(String ywmc3ci) {
        this.ywmc3ci = ywmc3ci;
    }

    public String getYwmc3mg() {
        return this.ywmc3mg;
    }

    public void setYwmc3mg(String ywmc3mg) {
        this.ywmc3mg = ywmc3mg;
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
}
