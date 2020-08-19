package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @author Administrator
 * @ClassName: FollowGxy
 * @Description: 随访-高血压-随访
 * @date 2019年7月31日
 */
@Entity
@Table(name = "blt_mxgxysfb")
public class FollowGxy extends BaseDomain {

    private static final long serialVersionUID = 19626466416L;

    @Id
    private String id;//
    private String jmid;//居民id
    private String tjbh;// 体检编号
    private String dah;// 档案号
    private String hzbh;// 患者编号
    private String sfzh;// 身份证号
    private String hzxm;// 患者姓名
    @JSONField(format = "yyyy-MM-dd")
    private Date sfrq;// 随访日期
    @JSONField(format = "yyyy-MM-dd")
    private Date xcsfrq;// 下次随访日期
    private String zz;// 症状
    @Transient
    private String zzName;
    private String qtzz;// 其他症状
    private String gxy;// 高血压
    private String dxy;// 低血压
    @Column(precision = 5, scale = 2)
    private String tz;// 体重
    @Column(precision = 5, scale = 2)
    private String tzzs;// 体质指数
    private String xl;// 心率
    private String stzz;// 身体症状
    private String rxyl;// 日吸烟量
    @Column(precision = 5, scale = 2)
    private String ryjl;// 日饮酒量
    private String mzydcs;// 每周运动次数
    private String mzydsj;// 每次运动时间
    private String syqk;// 摄盐情况
    @Transient
    private String syqkName;
    private String xcsfsyl;// 下次随访摄盐量
    @Transient
    private String xcsfsylName;
    private String xltz;// 心理调整
    @Transient
    private String xltzName;
    private String zyxw;// 遵医行为
    @Transient
    private String zyxwName;
    private String fzjc;// 辅助检查
    private String fyycx;// 服药依从性
    @Transient
    private String fyycxName;
    private String ywblfy;// 药物不良反应
    @Transient
    private String ywblfyName;
    private String blfyms;// 药物不良反应描述
    private String sffl;// 此次随访分类
    @Transient
    private String sfflName;
    private String zzyy;// 转诊原因
    private String jgjks;// 机构及科室
    private String sffs;// 随访方式
    @Transient
    private String sffsName;
    @Column(precision = 5, scale = 2)
    private String xcsftz;// 下次随访体重
    @Column(precision = 5, scale = 2)
    private String xcsftzzs;// 下次随访体质指数
    private String xcsfrxyl;// 下次随访日吸烟量
    private String xcsfryjl;// 下次随访日饮酒量
    private String xcsfmzydcs;// 下次随访每周运动次数
    private String xcsfmcydsj;// 下次随访每次运动时间
    private String ywmc1;// 药物名称1
    private String ywmc1ci;// 药物名称1每日几次
    private String ywmc1mg;// 药物名称1第次多少mg
    private String ywmc1dw; // 药物名称1用法
    private String ywmc2;// 药物名称2
    private String ywmc2ci;// 药物名称2每日几次
    private String ywmc2mg;// 药物名称2第次多少mg
    private String ywmc2dw; // 药物名称2用法
    private String ywmc3;// 药物名称3
    private String ywmc3ci;// 药物名称3每日几次
    private String ywmc3mg;// 药物名称3第次多少mg
    private String ywmc3dw; // 药物名称3用法
    private Date jbrq;// 建表日期
    private String scxgr;// 上次修改人
    private Date scxgrq;// 上次修改时间
    private String sfsc;// 是否删除
    private String qtyw;// 其他药物
    private String qtywci;// 其他药物每日几次
    private String qtywmg;// 其他药物每次多少mg
    private String qtywyf; // 其他药物用法
    private String qtywdw; // 其他药物用法
    private String qtywpc; // 其他药物频次
    private String qtywsfbjgqy; // 其他药物是否本机构取药
    private String qtyw2; // 其它药物2名称
    private String qtyw2ci; // 其它药物2次
    private String qtyw2mg; // 其它药物2mg
    private String qtyw2dw; // 其它药物2用法
    private String qtyw2yf; // 其他药物2用法
    private String qtyw2pc; // 其他药物2频次
    private String qtyw2sfbjgqy; // 其他药物2是否本机构取药
    private String qtyw3; // 其它药物3名称
    private String qtyw3ci; // 其它药物3次
    private String qtyw3mg; // 其它药物3单位
    private String qtyw3dw; // 其它药物3用法
    private String qtyw3yf; // 其他药物3用法
    private String qtyw3pc; // 其他药物3频次
    private String qtyw3sfbjgqy; // 其他药物3是否本机构取药

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
    private String updateFlg;// 同步是否修改
    @Column(name = "sfys")
    private String sfys;// 随访医生
    @Transient
    private String sfysName;
    @Column(name = "jbr")
    private String jbr;// 建表人

    private String fileRecordId;// 上传图像返回值
    private String imgUrl;// 平板上传图像保存路径
    private String sg;// 身高
    private String sfsf;// 是否失访
    private String sfyy;// 失访原因

    private String hyperFollowupNo;// 下载冠新返回值

    // 云南版本字段
    private String ywmc1yf; // 药物名称1用法
    private String ywmc1pc; // 药物名称1频次
    private String ywmc1ycx; // 药物名称1依从性
    private String ywmc1bycyy; // 药物名称1不依从原因
    private String ywmc2yf; // 药物名称2用法
    private String ywmc2pc; // 药物名称2频次
    private String ywmc2ycx; // 药物名称2依从性
    private String ywmc2bycyy; // 药物名称2不依从原因
    private String ywmc3yf; // 药物名称3用法
    private String ywmc3pc; // 药物名称3频次
    private String ywmc3ycx; // 药物名称3依从性
    private String ywmc3bycyy; // 药物名称3不依从原因
    private String xfhbz; // 新发合并症
    private Date xjtfsrq; // 住院治疗心绞痛发生日期
    private Date sjgsfsrq; // 心肌梗死发生日期
    private Date xlsjfdrq; // 住院治疗心力衰竭发生日期
    private Date qxxnczfdrq; // 缺血性脑卒中发生日期
    private Date cxxnczfdrq; // 出血性脑卒中发生日期
    private Date nczwflfdrq; // 脑卒中未分类发生日期
    private Date tnbfsrq; // 糖尿病发生日期
    private Date mxszjbfsrq; // 慢性肾脏疾病发生日期
    private Date wzxgbfsrq; // 外周血管病发生日期
    private String yw; // 腰围
    private String sfxy; // 是否吸烟
    private String jsycxyxg; // 几岁养成吸烟习惯
    private String jqtsfxy; // 近七天是否吸烟
    private String zd; // 诊断
    private String zdqt; // 诊断其他
    private String sfzz; // 是否转诊
    private Date zzrq; // 转诊日期
    private String sfr; // 随访人
    private String shzdfs; // 生活指导方式
    private String fzjcqt; // 辅助检查其他
    private String ywmc4; // 药物名称4
    private String ywmc4ci; // 药物名称4次
    private String ywmc4mg; // 药物名称4mg
    private String ywmc4dw; // 药物名称4单位
    private String ywmc4yf; // 药物名称4用法
    private String ywmc4pc; // 药物名称4频次
    private String ywmc4ycx; // 药物名称4依从性
    private String ywmc4bycyy; // 药物名称4不依从原因
    private String ywmc5; // 药物名称5
    private String ywmc5ci; // 药物名称5次
    private String ywmc5mg; // 药物名称5mg
    private String ywmc5dw; // 药物名称5单位
    private String ywmc5yf; // 药物名称5用法
    private String ywmc5pc; // 药物名称5频次
    private String ywmc5ycx; // 药物名称5依从性
    private String ywmc5bycyy; // 药物名称5不依从原因
    private String qtyw4; // 其他药物5
    private String qtyw4ci; // 其他药物5次
    private String qtyw4mg; // 其他药物5mg
    private String qtyw4dw; // 其他药物5单位
    private String qtyw4yf; // 其他药物5用法
    private String qtyw4pc; // 其他药物5频次
    private String qtyw4sfbjgqy; // 其他药物5是否本机构取药
    private String qtyw5; // 其他药物5
    private String qtyw5ci; // 其他药物5次
    private String qtyw5mg; // 其他药物5mg
    private String qtyw5dw; // 其他药物5单位
    private String qtyw5yf; // 其他药物5用法
    private String qtyw5pc; // 其他药物5频次
    private String qtyw5sfbjgqy; // 其他药物5是否本机构取药

    private String xybglcs;// 下一步管理措施
    private String zzlxdh;// 联系人及电话
    private String jg;// 结果
    private String jmqz;// 居民签名
    private String bz;// 备注

    public String getJmid() {
        return jmid;
    }

    public void setJmid(String jmid) {
        this.jmid = jmid;
    }

    public String getSfysName() {
        return sfysName;
    }

    public void setSfysName(String sfysName) {
        this.sfysName = sfysName;
    }

    public String getXybglcs() {
        return xybglcs;
    }

    public void setXybglcs(String xybglcs) {
        this.xybglcs = xybglcs;
    }

    public String getZzlxdh() {
        return zzlxdh;
    }

    public void setZzlxdh(String zzlxdh) {
        this.zzlxdh = zzlxdh;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getJmqz() {
        return jmqz;
    }

    public void setJmqz(String jmqz) {
        this.jmqz = jmqz;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getQtywyf() {
        return qtywyf;
    }

    public void setQtywyf(String qtywyf) {
        this.qtywyf = qtywyf;
    }

    public String getQtyw2yf() {
        return qtyw2yf;
    }

    public void setQtyw2yf(String qtyw2yf) {
        this.qtyw2yf = qtyw2yf;
    }

    public String getQtyw3yf() {
        return qtyw3yf;
    }

    public void setQtyw3yf(String qtyw3yf) {
        this.qtyw3yf = qtyw3yf;
    }

    public String getYwmc1yf() {
        return ywmc1yf;
    }

    public void setYwmc1yf(String ywmc1yf) {
        this.ywmc1yf = ywmc1yf;
    }

    public String getYwmc2yf() {
        return ywmc2yf;
    }

    public void setYwmc2yf(String ywmc2yf) {
        this.ywmc2yf = ywmc2yf;
    }

    public String getYwmc3yf() {
        return ywmc3yf;
    }

    public void setYwmc3yf(String ywmc3yf) {
        this.ywmc3yf = ywmc3yf;
    }

    public String getFzjcqt() {
        return fzjcqt;
    }

    public void setFzjcqt(String fzjcqt) {
        this.fzjcqt = fzjcqt;
    }

    public String getYwmc4() {
        return ywmc4;
    }

    public void setYwmc4(String ywmc4) {
        this.ywmc4 = ywmc4;
    }

    public String getYwmc4ci() {
        return ywmc4ci;
    }

    public void setYwmc4ci(String ywmc4ci) {
        this.ywmc4ci = ywmc4ci;
    }

    public String getYwmc4mg() {
        return ywmc4mg;
    }

    public void setYwmc4mg(String ywmc4mg) {
        this.ywmc4mg = ywmc4mg;
    }

    public String getYwmc4dw() {
        return ywmc4dw;
    }

    public void setYwmc4dw(String ywmc4dw) {
        this.ywmc4dw = ywmc4dw;
    }

    public String getYwmc4yf() {
        return ywmc4yf;
    }

    public void setYwmc4yf(String ywmc4yf) {
        this.ywmc4yf = ywmc4yf;
    }

    public String getYwmc4pc() {
        return ywmc4pc;
    }

    public void setYwmc4pc(String ywmc4pc) {
        this.ywmc4pc = ywmc4pc;
    }

    public String getYwmc4ycx() {
        return ywmc4ycx;
    }

    public void setYwmc4ycx(String ywmc4ycx) {
        this.ywmc4ycx = ywmc4ycx;
    }

    public String getYwmc4bycyy() {
        return ywmc4bycyy;
    }

    public void setYwmc4bycyy(String ywmc4bycyy) {
        this.ywmc4bycyy = ywmc4bycyy;
    }

    public String getYwmc5() {
        return ywmc5;
    }

    public void setYwmc5(String ywmc5) {
        this.ywmc5 = ywmc5;
    }

    public String getYwmc5ci() {
        return ywmc5ci;
    }

    public void setYwmc5ci(String ywmc5ci) {
        this.ywmc5ci = ywmc5ci;
    }

    public String getYwmc5mg() {
        return ywmc5mg;
    }

    public void setYwmc5mg(String ywmc5mg) {
        this.ywmc5mg = ywmc5mg;
    }

    public String getYwmc5dw() {
        return ywmc5dw;
    }

    public void setYwmc5dw(String ywmc5dw) {
        this.ywmc5dw = ywmc5dw;
    }

    public String getYwmc5yf() {
        return ywmc5yf;
    }

    public void setYwmc5yf(String ywmc5yf) {
        this.ywmc5yf = ywmc5yf;
    }

    public String getYwmc5pc() {
        return ywmc5pc;
    }

    public void setYwmc5pc(String ywmc5pc) {
        this.ywmc5pc = ywmc5pc;
    }

    public String getYwmc5ycx() {
        return ywmc5ycx;
    }

    public void setYwmc5ycx(String ywmc5ycx) {
        this.ywmc5ycx = ywmc5ycx;
    }

    public String getYwmc5bycyy() {
        return ywmc5bycyy;
    }

    public void setYwmc5bycyy(String ywmc5bycyy) {
        this.ywmc5bycyy = ywmc5bycyy;
    }

    public String getQtyw4() {
        return qtyw4;
    }

    public void setQtyw4(String qtyw4) {
        this.qtyw4 = qtyw4;
    }

    public String getQtyw4ci() {
        return qtyw4ci;
    }

    public void setQtyw4ci(String qtyw4ci) {
        this.qtyw4ci = qtyw4ci;
    }

    public String getQtyw4mg() {
        return qtyw4mg;
    }

    public void setQtyw4mg(String qtyw4mg) {
        this.qtyw4mg = qtyw4mg;
    }

    public String getQtyw4dw() {
        return qtyw4dw;
    }

    public void setQtyw4dw(String qtyw4dw) {
        this.qtyw4dw = qtyw4dw;
    }

    public String getQtyw4yf() {
        return qtyw4yf;
    }

    public void setQtyw4yf(String qtyw4yf) {
        this.qtyw4yf = qtyw4yf;
    }

    public String getQtyw4pc() {
        return qtyw4pc;
    }

    public void setQtyw4pc(String qtyw4pc) {
        this.qtyw4pc = qtyw4pc;
    }

    public String getQtyw4sfbjgqy() {
        return qtyw4sfbjgqy;
    }

    public void setQtyw4sfbjgqy(String qtyw4sfbjgqy) {
        this.qtyw4sfbjgqy = qtyw4sfbjgqy;
    }

    public String getQtyw5() {
        return qtyw5;
    }

    public void setQtyw5(String qtyw5) {
        this.qtyw5 = qtyw5;
    }

    public String getQtyw5ci() {
        return qtyw5ci;
    }

    public void setQtyw5ci(String qtyw5ci) {
        this.qtyw5ci = qtyw5ci;
    }

    public String getQtyw5mg() {
        return qtyw5mg;
    }

    public void setQtyw5mg(String qtyw5mg) {
        this.qtyw5mg = qtyw5mg;
    }

    public String getQtyw5dw() {
        return qtyw5dw;
    }

    public void setQtyw5dw(String qtyw5dw) {
        this.qtyw5dw = qtyw5dw;
    }

    public String getQtyw5yf() {
        return qtyw5yf;
    }

    public void setQtyw5yf(String qtyw5yf) {
        this.qtyw5yf = qtyw5yf;
    }

    public String getQtyw5pc() {
        return qtyw5pc;
    }

    public void setQtyw5pc(String qtyw5pc) {
        this.qtyw5pc = qtyw5pc;
    }

    public String getQtyw5sfbjgqy() {
        return qtyw5sfbjgqy;
    }

    public void setQtyw5sfbjgqy(String qtyw5sfbjgqy) {
        this.qtyw5sfbjgqy = qtyw5sfbjgqy;
    }

    public String getQtywdw() {
        return qtywdw;
    }

    public void setQtywdw(String qtywdw) {
        this.qtywdw = qtywdw;
    }

    public String getQtywpc() {
        return qtywpc;
    }

    public void setQtywpc(String qtywpc) {
        this.qtywpc = qtywpc;
    }

    public String getQtywsfbjgqy() {
        return qtywsfbjgqy;
    }

    public void setQtywsfbjgqy(String qtywsfbjgqy) {
        this.qtywsfbjgqy = qtywsfbjgqy;
    }

    public String getQtyw2() {
        return qtyw2;
    }

    public void setQtyw2(String qtyw2) {
        this.qtyw2 = qtyw2;
    }

    public String getQtyw2ci() {
        return qtyw2ci;
    }

    public void setQtyw2ci(String qtyw2ci) {
        this.qtyw2ci = qtyw2ci;
    }

    public String getQtyw2mg() {
        return qtyw2mg;
    }

    public void setQtyw2mg(String qtyw2mg) {
        this.qtyw2mg = qtyw2mg;
    }

    public String getQtyw2dw() {
        return qtyw2dw;
    }

    public void setQtyw2dw(String qtyw2dw) {
        this.qtyw2dw = qtyw2dw;
    }

    public String getQtyw2pc() {
        return qtyw2pc;
    }

    public void setQtyw2pc(String qtyw2pc) {
        this.qtyw2pc = qtyw2pc;
    }

    public String getQtyw2sfbjgqy() {
        return qtyw2sfbjgqy;
    }

    public void setQtyw2sfbjgqy(String qtyw2sfbjgqy) {
        this.qtyw2sfbjgqy = qtyw2sfbjgqy;
    }

    public String getQtyw3() {
        return qtyw3;
    }

    public void setQtyw3(String qtyw3) {
        this.qtyw3 = qtyw3;
    }

    public String getQtyw3ci() {
        return qtyw3ci;
    }

    public void setQtyw3ci(String qtyw3ci) {
        this.qtyw3ci = qtyw3ci;
    }

    public String getQtyw3mg() {
        return qtyw3mg;
    }

    public void setQtyw3mg(String qtyw3mg) {
        this.qtyw3mg = qtyw3mg;
    }

    public String getQtyw3dw() {
        return qtyw3dw;
    }

    public void setQtyw3dw(String qtyw3dw) {
        this.qtyw3dw = qtyw3dw;
    }

    public String getQtyw3pc() {
        return qtyw3pc;
    }

    public void setQtyw3pc(String qtyw3pc) {
        this.qtyw3pc = qtyw3pc;
    }

    public String getQtyw3sfbjgqy() {
        return qtyw3sfbjgqy;
    }

    public void setQtyw3sfbjgqy(String qtyw3sfbjgqy) {
        this.qtyw3sfbjgqy = qtyw3sfbjgqy;
    }

    public String getYwmc1dw() {
        return ywmc1dw;
    }

    public void setYwmc1dw(String ywmc1dw) {
        this.ywmc1dw = ywmc1dw;
    }

    public String getYwmc2dw() {
        return ywmc2dw;
    }

    public void setYwmc2dw(String ywmc2dw) {
        this.ywmc2dw = ywmc2dw;
    }

    public String getYwmc3dw() {
        return ywmc3dw;
    }

    public void setYwmc3dw(String ywmc3dw) {
        this.ywmc3dw = ywmc3dw;
    }

    public String getYwmc1pc() {
        return ywmc1pc;
    }

    public void setYwmc1pc(String ywmc1pc) {
        this.ywmc1pc = ywmc1pc;
    }

    public String getYwmc1ycx() {
        return ywmc1ycx;
    }

    public void setYwmc1ycx(String ywmc1ycx) {
        this.ywmc1ycx = ywmc1ycx;
    }

    public String getYwmc1bycyy() {
        return ywmc1bycyy;
    }

    public void setYwmc1bycyy(String ywmc1bycyy) {
        this.ywmc1bycyy = ywmc1bycyy;
    }

    public String getYwmc2pc() {
        return ywmc2pc;
    }

    public void setYwmc2pc(String ywmc2pc) {
        this.ywmc2pc = ywmc2pc;
    }

    public String getYwmc2ycx() {
        return ywmc2ycx;
    }

    public void setYwmc2ycx(String ywmc2ycx) {
        this.ywmc2ycx = ywmc2ycx;
    }

    public String getYwmc2bycyy() {
        return ywmc2bycyy;
    }

    public void setYwmc2bycyy(String ywmc2bycyy) {
        this.ywmc2bycyy = ywmc2bycyy;
    }

    public String getYwmc3pc() {
        return ywmc3pc;
    }

    public void setYwmc3pc(String ywmc3pc) {
        this.ywmc3pc = ywmc3pc;
    }

    public String getYwmc3ycx() {
        return ywmc3ycx;
    }

    public void setYwmc3ycx(String ywmc3ycx) {
        this.ywmc3ycx = ywmc3ycx;
    }

    public String getYwmc3bycyy() {
        return ywmc3bycyy;
    }

    public void setYwmc3bycyy(String ywmc3bycyy) {
        this.ywmc3bycyy = ywmc3bycyy;
    }

    public String getShzdfs() {
        return shzdfs;
    }

    public void setShzdfs(String shzdfs) {
        this.shzdfs = shzdfs;
    }

    public String getXfhbz() {
        return xfhbz;
    }

    public void setXfhbz(String xfhbz) {
        this.xfhbz = xfhbz;
    }

    public Date getXjtfsrq() {
        return xjtfsrq;
    }

    public void setXjtfsrq(Date xjtfsrq) {
        this.xjtfsrq = xjtfsrq;
    }

    public Date getSjgsfsrq() {
        return sjgsfsrq;
    }

    public void setSjgsfsrq(Date sjgsfsrq) {
        this.sjgsfsrq = sjgsfsrq;
    }

    public Date getXlsjfdrq() {
        return xlsjfdrq;
    }

    public void setXlsjfdrq(Date xlsjfdrq) {
        this.xlsjfdrq = xlsjfdrq;
    }

    public Date getQxxnczfdrq() {
        return qxxnczfdrq;
    }

    public void setQxxnczfdrq(Date qxxnczfdrq) {
        this.qxxnczfdrq = qxxnczfdrq;
    }

    public Date getCxxnczfdrq() {
        return cxxnczfdrq;
    }

    public void setCxxnczfdrq(Date cxxnczfdrq) {
        this.cxxnczfdrq = cxxnczfdrq;
    }

    public Date getNczwflfdrq() {
        return nczwflfdrq;
    }

    public void setNczwflfdrq(Date nczwflfdrq) {
        this.nczwflfdrq = nczwflfdrq;
    }

    public Date getTnbfsrq() {
        return tnbfsrq;
    }

    public void setTnbfsrq(Date tnbfsrq) {
        this.tnbfsrq = tnbfsrq;
    }

    public Date getMxszjbfsrq() {
        return mxszjbfsrq;
    }

    public void setMxszjbfsrq(Date mxszjbfsrq) {
        this.mxszjbfsrq = mxszjbfsrq;
    }

    public Date getWzxgbfsrq() {
        return wzxgbfsrq;
    }

    public void setWzxgbfsrq(Date wzxgbfsrq) {
        this.wzxgbfsrq = wzxgbfsrq;
    }

    public String getYw() {
        return yw;
    }

    public void setYw(String yw) {
        this.yw = yw;
    }

    public String getSfxy() {
        return sfxy;
    }

    public void setSfxy(String sfxy) {
        this.sfxy = sfxy;
    }

    public String getJsycxyxg() {
        return jsycxyxg;
    }

    public void setJsycxyxg(String jsycxyxg) {
        this.jsycxyxg = jsycxyxg;
    }

    public String getJqtsfxy() {
        return jqtsfxy;
    }

    public void setJqtsfxy(String jqtsfxy) {
        this.jqtsfxy = jqtsfxy;
    }

    public String getZd() {
        return zd;
    }

    public void setZd(String zd) {
        this.zd = zd;
    }

    public String getZdqt() {
        return zdqt;
    }

    public void setZdqt(String zdqt) {
        this.zdqt = zdqt;
    }

    public String getSfzz() {
        return sfzz;
    }

    public void setSfzz(String sfzz) {
        this.sfzz = sfzz;
    }

    public Date getZzrq() {
        return zzrq;
    }

    public void setZzrq(Date zzrq) {
        this.zzrq = zzrq;
    }

    public String getSfr() {
        return sfr;
    }

    public void setSfr(String sfr) {
        this.sfr = sfr;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getHyperFollowupNo() {
        return hyperFollowupNo;
    }

    public void setHyperFollowupNo(String hyperFollowupNo) {
        this.hyperFollowupNo = hyperFollowupNo;
    }

    public String getFileRecordId() {
        return fileRecordId;
    }

    public void setFileRecordId(String fileRecordId) {
        this.fileRecordId = fileRecordId;
    }

    public String getSg() {
        return sg;
    }

    public void setSg(String sg) {
        this.sg = sg;
    }

    public String getSfsf() {
        return sfsf;
    }

    public void setSfsf(String sfsf) {
        this.sfsf = sfsf;
    }

    public String getSfyy() {
        return sfyy;
    }

    public void setSfyy(String sfyy) {
        this.sfyy = sfyy;
    }

    public String getUpdateFlg() {
        return updateFlg;
    }

    public void setUpdateFlg(String updateFlg) {
        this.updateFlg = updateFlg;
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

    public String getSfsc() {
        return this.sfsc;
    }

    public void setSfsc(String sfsc) {
        this.sfsc = sfsc;
    }

    public String getQtyw() {
        return this.qtyw;
    }

    public void setQtyw(String qtyw) {
        this.qtyw = qtyw;
    }

    public String getQtywci() {
        return this.qtywci;
    }

    public void setQtywci(String qtywci) {
        this.qtywci = qtywci;
    }

    public String getQtywmg() {
        return this.qtywmg;
    }

    public void setQtywmg(String qtywmg) {
        this.qtywmg = qtywmg;
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

    public String getDah() {
        return this.dah;
    }

    public void setDah(String dah) {
        this.dah = dah;
    }

    public String getHzbh() {
        return this.hzbh;
    }

    public void setHzbh(String hzbh) {
        this.hzbh = hzbh;
    }

    public String getSfzh() {
        return this.sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getHzxm() {
        return this.hzxm;
    }

    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
    }

    public Date getSfrq() {
        return this.sfrq;
    }

    public void setSfrq(Date sfrq) {
        this.sfrq = sfrq;
    }

    public String getSfys() {
        return this.sfys;
    }

    public void setSfys(String sfys) {
        this.sfys = sfys;
    }

    public Date getXcsfrq() {
        return this.xcsfrq;
    }

    public void setXcsfrq(Date xcsfrq) {
        this.xcsfrq = xcsfrq;
    }

    public String getZz() {
        return this.zz;
    }

    public String getZzName() {
        return DictUtil.getDictValue("gxy-zz", this.zz);
    }

    public void setZzName(String zzName) {
        this.zzName = zzName;
    }

    public void setZz(String zz) {
        this.zz = zz;
    }

    public String getQtzz() {
        return this.qtzz;
    }

    public void setQtzz(String qtzz) {
        this.qtzz = qtzz;
    }

    public String getGxy() {
        return this.gxy;
    }

    public void setGxy(String gxy) {
        this.gxy = gxy;
    }

    public String getDxy() {
        return this.dxy;
    }

    public void setDxy(String dxy) {
        this.dxy = dxy;
    }

    public String getTz() {
        return this.tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getTzzs() {
        return this.tzzs;
    }

    public void setTzzs(String tzzs) {
        this.tzzs = tzzs;
    }

    public String getXl() {
        return this.xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getStzz() {
        return this.stzz;
    }

    public void setStzz(String stzz) {
        this.stzz = stzz;
    }

    public String getRxyl() {
        return this.rxyl;
    }

    public void setRxyl(String rxyl) {
        this.rxyl = rxyl;
    }

    public String getRyjl() {
        return this.ryjl;
    }

    public void setRyjl(String ryjl) {
        this.ryjl = ryjl;
    }

    public String getMzydcs() {
        return this.mzydcs;
    }

    public void setMzydcs(String mzydcs) {
        this.mzydcs = mzydcs;
    }

    public String getMzydsj() {
        return this.mzydsj;
    }

    public void setMzydsj(String mzydsj) {
        this.mzydsj = mzydsj;
    }

    public String getSyqk() {
        return this.syqk;
    }

    public void setSyqk(String syqk) {
        this.syqk = syqk;
    }

    public String getSyqkName() {
        return DictUtil.getDictValue("gxy-syqk", this.syqk);
    }

    public void setSyqkName(String syqkName) {
        this.syqkName = syqkName;
    }

    public String getXcsfsyl() {
        return this.xcsfsyl;
    }

    public void setXcsfsyl(String xcsfsyl) {
        this.xcsfsyl = xcsfsyl;
    }

    public String getXcsfsylName() {
        return DictUtil.getDictValue("gxy-syqk", this.syqk);
    }

    public void setXcsfsylName(String xcsfsylName) {
        this.xcsfsylName = xcsfsylName;
    }

    public String getXltz() {
        return this.xltz;
    }

    public void setXltz(String xltz) {
        this.xltz = xltz;
    }

    public String getXltzName() {
        return DictUtil.getDictValue("gxy-zyxw", this.xltz);
    }

    public void setXltzName(String xltzName) {
        this.xltzName = xltzName;
    }

    public String getZyxw() {
        return this.zyxw;
    }

    public void setZyxw(String zyxw) {
        this.zyxw = zyxw;
    }

    public String getZyxwName() {
        return DictUtil.getDictValue("gxy-zyxw", this.zyxw);
    }

    public void setZyxwName(String zyxwName) {
        this.zyxwName = zyxwName;
    }


    public String getFzjc() {
        return this.fzjc;
    }

    public void setFzjc(String fzjc) {
        this.fzjc = fzjc;
    }

    public String getFyycx() {
        return this.fyycx;
    }

    public void setFyycx(String fyycx) {
        this.fyycx = fyycx;
    }

    public String getFyycxName() {
        return DictUtil.getDictValue("tj-zyyyqk-fyycx", this.fyycx);
    }

    public void setFyycxName(String fyycxName) {
        this.fyycxName = fyycxName;
    }

    public String getYwblfy() {
        return this.ywblfy;
    }

    public void setYwblfy(String ywblfy) {
        this.ywblfy = ywblfy;
    }

    public String getYwblfyName() {
        return DictUtil.getDictValue("gxy-ywblfy", this.ywblfy);
    }

    public void setYwblfyName(String ywblfyName) {
        this.ywblfyName = ywblfyName;
    }

    public String getBlfyms() {
        return this.blfyms;
    }

    public void setBlfyms(String blfyms) {
        this.blfyms = blfyms;
    }

    public String getSffl() {
        return this.sffl;
    }

    public void setSffl(String sffl) {
        this.sffl = sffl;
    }

    public String getSfflName() {
        return DictUtil.getDictValue("gxy-sffl", this.sffl);
    }

    public void setSfflName(String sfflName) {
        this.sfflName = sfflName;
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

    public String getXcsftz() {
        return this.xcsftz;
    }

    public void setXcsftz(String xcsftz) {
        this.xcsftz = xcsftz;
    }

    public String getXcsftzzs() {
        return this.xcsftzzs;
    }

    public void setXcsftzzs(String xcsftzzs) {
        this.xcsftzzs = xcsftzzs;
    }

    public String getXcsfrxyl() {
        return this.xcsfrxyl;
    }

    public void setXcsfrxyl(String xcsfrxyl) {
        this.xcsfrxyl = xcsfrxyl;
    }

    public String getXcsfryjl() {
        return this.xcsfryjl;
    }

    public void setXcsfryjl(String xcsfryjl) {
        this.xcsfryjl = xcsfryjl;
    }

    public String getXcsfmzydcs() {
        return this.xcsfmzydcs;
    }

    public void setXcsfmzydcs(String xcsfmzydcs) {
        this.xcsfmzydcs = xcsfmzydcs;
    }

    public String getXcsfmcydsj() {
        return this.xcsfmcydsj;
    }

    public void setXcsfmcydsj(String xcsfmcydsj) {
        this.xcsfmcydsj = xcsfmcydsj;
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
