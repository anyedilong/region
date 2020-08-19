package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @ClassName: FollowGxb
 * @Description: 随访-冠心病-随访
 * @author Administrator
 * @date 2019年8月2日
 */
@Entity
@Table(name = "blt_mxgxbsfb")
public class FollowGxb extends BaseDomain {

	private static final long serialVersionUID = 163656466464L;
	
	@Id
	private String id;//ID
	private String jmid;//居民id
	private String tjbh;// 体检编号
	private String dah;// 档案号
	private String sfzh;// 身份证号
	private String hzbh;// 患者编号
	private String zz;// 症状
	private String gxblx;// 冠心病类型
	private String zzms;// 症状描述
	private String ssy;// 收缩压
	private String szy;// 舒张压
	private String tz;// 体重
	private String xy;// 心音
	private String xl;// 心率
	private String xj;// 心尖
	private String xyzysx;// 吸烟注意事项
	private String ydzysx;// 运动注意事项
	private String syzysx;// 摄盐注意事项
	private String sg; //身高
	private String xcsftz;//下次随访体重
	@Column(precision = 5, scale = 2)
	private String tzzs;//体质指数
	@Column(precision = 5, scale = 2)
	private String xcsftzzs;//下次随访体质指数
	@Column(precision = 5, scale = 2)
	private String kfxt;//空腹血糖
	private String gysz;//甘油三酯
	private String xls;//心率每分钟多少次
	private String dgc;//胆固醇
	private String hdlc;//HDLC
	private String ldlc;//LDLC
	private String xdtjc;//心电图检查
	private String xdtydfhsy;//心电图运动负荷试验
	private String xzccjc;//心脏彩超检查
	private String ggdmzy;//冠状动脉造影
	private String xjmxjc;//心肌酶学检查
	private String rxyl;// 日吸烟量
	@Column(precision = 5, scale = 2)
	private String ryjl;// 日饮酒量
	private String mzydcs;// 每周运动次数
	private String mzydsj;// 每次运动时间
	private String xcsfrxyl;// 下次随访日吸烟量
	@Column(precision = 5, scale = 2)
	private String xcsfryjl;// 下次随访日饮酒量
	private String xcsfmzydcs;// 下次随访每周运动次数
	private String xcsfmcydsj;// 下次随访每次运动时间
	private String shfsgbjc;//生活方式改变检测
	private String shfsgbqt;//生活方式其他
	private String yyfs;//用药方式；0单药治疗  1联合用药  2药物治疗有效  3效果不佳 4其他
	private String yyfsqt;//其他描述
	private String tszl; //特殊治疗  单选 无，外科手术治疗，介入治疗 ，起搏器
	private String xltz;// 心理调整
	private String zyxw;// 遵医行为
	private String fzjc;// 辅助检查
	private String fyxsgysfhj;// 症状出现后服用硝酸甘油是否缓解
	private String fyycx;// 服药依从性
	private String ywblfy;// 药物不良反应
	private String ywblfyms;// 药物不良反应描述
	private String sffl;// 随访分类
	private String zzyy;// 转诊原因
	private String jgjks;// 机构及科室
	@JSONField(format="yyyy-MM-dd")
	private Date xcsfrq;// 下次随访日期
	private String sfys;// 随访医生
	private String jbr;// 建表人
	private Date jbrq;// 建表日期
	private String scxgr;// 上一次修改人
	private Date scxgrq;// 上一次修改日期
	private String sfsc;// 是否删除
	@JSONField(format="yyyy-MM-dd")
	private Date sfrq;// 随访日期
	private String sflx;// 随访类型
	private String ywmc1;// 药物名称1
	private String ywmc1ci;// 药物名称1每日几次
	private String ywmc1mg;// 药物名称1第次多少mg
	private String ywmc1yl;//药物名称1用量
	private String ywmc1dw;//药物名称1单位
	private String ywmc2;// 药物名称2
	private String ywmc2ci;// 药物名称2每日几次
	private String ywmc2mg;// 药物名称2第次多少mg
	private String ywmc2yl;//药物名称2用量
	private String ywmc2dw;//药物名称2单位
	private String ywmc3;// 药物名称3
	private String ywmc3ci;// 药物名称3每日几次
	private String ywmc3mg;// 药物名称3第次多少mg
	private String ywmc3yl;//药物名称3用量
	private String ywmc3dw;//药物名称3单位
	private String qtyw;// 其他药物
	private String qtywci;// 其他药物每日几次
	private String qtywmg;// 其他药物每次多少mg
	private String qtywyl;
	private String tzqt; //体质其他

	
	private String dataSource;// 数据来源 1平台 2平板 3手机

	private String dataSourceNo;// 数据来源唯一标志
	
	private String importDeviceNum;// 导入设备号
	
	private Date importTime;// 导入时间

	private String importUser;// 导入人
	
	private String importIp;// 导入IP
	private String synFlg="0";// 是否同步 0 否 1 是
	@Column(updatable = false)
	private String synId;// 同步ID
	@Column(updatable = false)
	private Date synTime;// 同步时间
	
	private String updateFlg;//同步是否修改
	
	private String syqk;//摄盐情况
	private String xcsfsyqk;//下次随访摄盐情况


	@Transient
	private String sffsName;
	@Transient
	private String zzName;
	@Transient
	private String gxblxName;
	@Transient
	private String xltzName;
	@Transient
	private String zyxwName;
	@Transient
	private String shfsgbjcName;
	@Transient
	private String yyfsName;
	@Transient
	private String fyycxName;
	@Transient
	private String ywblfyName;
	@Transient
	private String tszlName;
	@Transient
	private String sfflName;

	public String getSffsName() {
		return DictUtil.getDictValue("sffs", this.sflx);
	}

	public void setSffsName(String sffsName) {
		this.sffsName = sffsName;
	}

	public String getZzName() {
		return DictUtil.getDictValue("gxb-zz", this.zz);
	}

	public void setZzName(String zzName) {
		this.zzName = zzName;
	}

	public String getGxblxName() {
		return DictUtil.getDictValue("gxb-lx", this.gxblx);
	}

	public void setGxblxName(String gxblxName) {
		this.gxblxName = gxblxName;
	}

	public String getXltzName() {
		return DictUtil.getDictValue("gxy-zyxw", this.xltz);
	}

	public void setXltzName(String xltzName) {
		this.xltzName = xltzName;
	}

	public String getZyxwName() {
		return DictUtil.getDictValue("gxy-zyxw", this.zyxw);
	}

	public void setZyxwName(String zyxwName) {
		this.zyxwName = zyxwName;
	}

	public String getShfsgbjcName() {
		return DictUtil.getDictValue("gxb-shfs", this.shfsgbjc);
	}

	public void setShfsgbjcName(String shfsgbjcName) {
		this.shfsgbjcName = shfsgbjcName;
	}

	public String getYyfsName() {
		return DictUtil.getDictValue("gxb-yyfs", this.yyfs);
	}

	public void setYyfsName(String yyfsName) {
		this.yyfsName = yyfsName;
	}

	public String getFyycxName() {
		return DictUtil.getDictValue("tj-zyyyqk-fyycx", this.fyycx);
	}

	public void setFyycxName(String fyycxName) {
		this.fyycxName = fyycxName;
	}

	public String getYwblfyName() {
		return DictUtil.getDictValue("gxy-ywblfy", this.ywblfy);
	}

	public void setYwblfyName(String ywblfyName) {
		this.ywblfyName = ywblfyName;
	}

	public String getTszlName() {
		return DictUtil.getDictValue("gxb-tszl", this.tszl);
	}

	public void setTszlName(String tszlName) {
		this.tszlName = tszlName;
	}

	public String getSfflName() {
		return DictUtil.getDictValue("gxy-sffl", this.sffl);
	}

	public void setSfflName(String sfflName) {
		this.sfflName = sfflName;
	}


	public String getXltz() {
		return xltz;
	}

	public void setXltz(String xltz) {
		this.xltz = xltz;
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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGxblx() {
		return gxblx;
	}

	public void setGxblx(String gxblx) {
		this.gxblx = gxblx;
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

	public String getZz() {
		return this.zz;
	}

	public void setZz(String zz) {
		this.zz = zz;
	}

	public String getZzms() {
		return this.zzms;
	}

	public void setZzms(String zzms) {
		this.zzms = zzms;
	}

	public String getSsy() {
		return this.ssy;
	}

	public void setSsy(String ssy) {
		this.ssy = ssy;
	}

	public String getSzy() {
		return this.szy;
	}

	public void setSzy(String szy) {
		this.szy = szy;
	}

	public String getTz() {
		return this.tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public String getXy() {
		return this.xy;
	}

	public void setXy(String xy) {
		this.xy = xy;
	}

	public String getXl() {
		return this.xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	public String getXj() {
		return this.xj;
	}

	public void setXj(String xj) {
		this.xj = xj;
	}

	public String getXyzysx() {
		return this.xyzysx;
	}

	public void setXyzysx(String xyzysx) {
		this.xyzysx = xyzysx;
	}

	public String getYdzysx() {
		return this.ydzysx;
	}

	public void setYdzysx(String ydzysx) {
		this.ydzysx = ydzysx;
	}

	public String getSyzysx() {
		return this.syzysx;
	}

	public void setSyzysx(String syzysx) {
		this.syzysx = syzysx;
	}

	public String getZyxw() {
		return this.zyxw;
	}

	public void setZyxw(String zyxw) {
		this.zyxw = zyxw;
	}

	public String getFzjc() {
		return this.fzjc;
	}

	public void setFzjc(String fzjc) {
		this.fzjc = fzjc;
	}

	public String getFyxsgysfhj() {
		return this.fyxsgysfhj;
	}

	public void setFyxsgysfhj(String fyxsgysfhj) {
		this.fyxsgysfhj = fyxsgysfhj;
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
		this.ywblfy = ywblfy;
	}

	public String getYwblfyms() {
		return this.ywblfyms;
	}

	public void setYwblfyms(String ywblfyms) {
		this.ywblfyms = ywblfyms;
	}

	public String getSffl() {
		return this.sffl;
	}

	public void setSffl(String sffl) {
		this.sffl = sffl;
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

	public Date getSfrq() {
		return this.sfrq;
	}

	public void setSfrq(Date sfrq) {
		this.sfrq = sfrq;
	}

	public String getSflx() {
		return this.sflx;
	}

	public void setSflx(String sflx) {
		this.sflx = sflx;
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

	public String getSg() {
		return sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public String getXcsftz() {
		return xcsftz;
	}

	public void setXcsftz(String xcsftz) {
		this.xcsftz = xcsftz;
	}

	public String getTzzs() {
		return tzzs;
	}

	public void setTzzs(String tzzs) {
		this.tzzs = tzzs;
	}

	public String getXcsftzzs() {
		return xcsftzzs;
	}

	public void setXcsftzzs(String xcsftzzs) {
		this.xcsftzzs = xcsftzzs;
	}

	public String getKfxt() {
		return kfxt;
	}

	public void setKfxt(String kfxt) {
		this.kfxt = kfxt;
	}

	public String getGysz() {
		return gysz;
	}

	public void setGysz(String gysz) {
		this.gysz = gysz;
	}

	public String getXls() {
		return xls;
	}

	public void setXls(String xls) {
		this.xls = xls;
	}

	public String getDgc() {
		return dgc;
	}

	public void setDgc(String dgc) {
		this.dgc = dgc;
	}

	public String getHdlc() {
		return hdlc;
	}

	public void setHdlc(String hdlc) {
		this.hdlc = hdlc;
	}

	public String getLdlc() {
		return ldlc;
	}

	public void setLdlc(String ldlc) {
		this.ldlc = ldlc;
	}

	public String getXdtjc() {
		return xdtjc;
	}

	public void setXdtjc(String xdtjc) {
		this.xdtjc = xdtjc;
	}

	public String getXdtydfhsy() {
		return xdtydfhsy;
	}

	public void setXdtydfhsy(String xdtydfhsy) {
		this.xdtydfhsy = xdtydfhsy;
	}

	public String getXzccjc() {
		return xzccjc;
	}

	public void setXzccjc(String xzccjc) {
		this.xzccjc = xzccjc;
	}

	public String getGgdmzy() {
		return ggdmzy;
	}

	public void setGgdmzy(String ggdmzy) {
		this.ggdmzy = ggdmzy;
	}

	public String getXjmxjc() {
		return xjmxjc;
	}

	public void setXjmxjc(String xjmxjc) {
		this.xjmxjc = xjmxjc;
	}

	public String getRxyl() {
		return rxyl;
	}

	public void setRxyl(String rxyl) {
		this.rxyl = rxyl;
	}

	public String getRyjl() {
		return ryjl;
	}

	public void setRyjl(String ryjl) {
		this.ryjl = ryjl;
	}

	public String getMzydcs() {
		return mzydcs;
	}

	public void setMzydcs(String mzydcs) {
		this.mzydcs = mzydcs;
	}

	public String getMzydsj() {
		return mzydsj;
	}

	public void setMzydsj(String mzydsj) {
		this.mzydsj = mzydsj;
	}

	public String getXcsfrxyl() {
		return xcsfrxyl;
	}

	public void setXcsfrxyl(String xcsfrxyl) {
		this.xcsfrxyl = xcsfrxyl;
	}

	public String getXcsfryjl() {
		return xcsfryjl;
	}

	public void setXcsfryjl(String xcsfryjl) {
		this.xcsfryjl = xcsfryjl;
	}

	public String getXcsfmzydcs() {
		return xcsfmzydcs;
	}

	public void setXcsfmzydcs(String xcsfmzydcs) {
		this.xcsfmzydcs = xcsfmzydcs;
	}

	public String getXcsfmcydsj() {
		return xcsfmcydsj;
	}

	public void setXcsfmcydsj(String xcsfmcydsj) {
		this.xcsfmcydsj = xcsfmcydsj;
	}

	public String getShfsgbjc() {
		return shfsgbjc;
	}

	public void setShfsgbjc(String shfsgbjc) {
		this.shfsgbjc = shfsgbjc;
	}

	public String getYyfs() {
		return yyfs;
	}

	public void setYyfs(String yyfs) {
		this.yyfs = yyfs;
	}

	public String getTszl() {
		return tszl;
	}

	public void setTszl(String tszl) {
		this.tszl = tszl;
	}

	public String getShfsgbqt() {
		return shfsgbqt;
	}

	public void setShfsgbqt(String shfsgbqt) {
		this.shfsgbqt = shfsgbqt;
	}

	public String getYyfsqt() {
		return yyfsqt;
	}

	public void setYyfsqt(String yyfsqt) {
		this.yyfsqt = yyfsqt;
	}

	public String getSyqk() {
		return syqk;
	}

	public void setSyqk(String syqk) {
		this.syqk = syqk;
	}

	public String getXcsfsyqk() {
		return xcsfsyqk;
	}

	public void setXcsfsyqk(String xcsfsyqk) {
		this.xcsfsyqk = xcsfsyqk;
	}

	public String getYwmc1yl() {
		return ywmc1yl;
	}

	public void setYwmc1yl(String ywmc1yl) {
		this.ywmc1yl = ywmc1yl;
	}

	public String getYwmc1dw() {
		return ywmc1dw;
	}

	public void setYwmc1dw(String ywmc1dw) {
		this.ywmc1dw = ywmc1dw;
	}

	public String getYwmc2yl() {
		return ywmc2yl;
	}

	public void setYwmc2yl(String ywmc2yl) {
		this.ywmc2yl = ywmc2yl;
	}

	public String getYwmc2dw() {
		return ywmc2dw;
	}

	public void setYwmc2dw(String ywmc2dw) {
		this.ywmc2dw = ywmc2dw;
	}

	public String getYwmc3yl() {
		return ywmc3yl;
	}

	public void setYwmc3yl(String ywmc3yl) {
		this.ywmc3yl = ywmc3yl;
	}

	public String getYwmc3dw() {
		return ywmc3dw;
	}

	public void setYwmc3dw(String ywmc3dw) {
		this.ywmc3dw = ywmc3dw;
	}

	public String getQtywyl() {
		return qtywyl;
	}

	public void setQtywyl(String qtywyl) {
		this.qtywyl = qtywyl;
	}

	public String getTzqt() {
		return tzqt;
	}

	public void setTzqt(String tzqt) {
		this.tzqt = tzqt;
	}
	
}
