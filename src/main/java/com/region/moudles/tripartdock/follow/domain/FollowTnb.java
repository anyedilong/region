package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.until.DictUtil;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: FollowTnb
 * @Description: 随访-糖尿病-随访
 * @author Administrator
 * @date 2019年7月31日
 */
@Entity
@Table(name = "blt_mxtnbsfb")
public class FollowTnb extends BaseDomain {

	private static final long serialVersionUID = 16499616166L;
	
	@Id
	private String id;//
	private String jmid;//居民id
	private String tjbh;// 体检编号
	private String hzbh;// 患者编号
	private String dah;// 档案号
	private String sfzh;// 身份证号
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, optional = false)
	@JoinColumns(value = {
			@JoinColumn(name = "sfzh", referencedColumnName = "sfzh", insertable = false, updatable = false),
			@JoinColumn(name = "hzbh", referencedColumnName = "hzbh", insertable = false, updatable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private FollowTnbJb followTnbJb;
	private String hzxm;// 患者姓名
	@JSONField(format = "yyyy-MM-dd")
	private Date sfrq;// 随访日期
	private String sfys;// 随访医生
	@Transient
	private String sfysName;
	@JSONField(format = "yyyy-MM-dd")
	private Date xcsfrq;// 下次随访日期
	private String zz;// 症状
	@Transient
	private String zzName;
	private String qtzz;// 其他症状
	private String gxy;// 高血压
	private String dxy;// 低血压
	private String tz;// 体重
	private String tzzs;// 体质指数
	private String zbdmbd;// 足背动脉搏动
	@Transient
	private String zbdmbdName;
	private String zbdmbdbs;// 足背动脉搏动消失，减弱标志
	private String qtzz1;// 其他症状
	private String rxyl;// 日吸烟量
	private String ryjl;// 日饮酒量
	private String mzydcs;// 每周运动次数
	private String mcydsj;// 每次运动时间
	@Transient
	private String mcydsjName;
	private String zsmtdsk;// 主食每天多少克
	private String xltz;// 心理调整
	@Transient
	private String xltzName;
	private String zyxw;// 遵医行为
	@Transient
	private String zyxwName;
	private String kfxtz;// 空腹血糖值
	private String thxhdb;// 糖化血红蛋白
	@JSONField(format = "yyyy-MM-dd")
	private Date jcrq;// 检查日期
	private String fzjc;// 辅助检查
	private String fyycx;// 服药依从性
	@Transient
	private String fyycxName;
	private String ywblfy;// 药物不良反应
	@Transient
	private String ywblfyName;
	private String blfyms;// 不良反应描述
	private String dxtfy;// 低血糖反应
	@Transient
	private String dxtfyName;
	private String sffl;// 随访分类
	@Transient
	private String sfflName;
	private String ydszl;// 胰岛素种类
	private String ydsyfhyl;// 胰岛素用法和用量
	private String sffs;// 随访方式
	@Transient
	private String sffsName;
	private String zzyy;// 转诊原因
	private String jgjks;// 机构及科室
	private String xcsftzmb;// 下次随访目标体重
	private String xcsftzzsmb;// 下次随访体质指数目标
	private String xcsfrxylmb;// 下次随访日吸烟量目标
	private String xcsfryjlmb;// 下次随访日饮酒量目标
	private String xcsfmzydcsmb;// 下次随访每周运动次数目标
	private String xcsfmcydsjmb;// 下次随访每次运动时间目标
	@Transient
	private String xcsfmcydsjmbName;
	private String jbr;// 建表人
	private Date jbrq;// 建表日期
	private String scxgr;// 上一次修改人
	private Date scxgrq;// 上一次修改日期
	private String sfsc;// 是否删除
	private String xcsfzsmb;// 下次随访主食目标
	private String ywmc1;// 药物名称1
	private String ywmc1ci;// 药物名称1每日几次
	private String ywmc1mg;// 药物名称1第次多少mg
	private String ywmc2;// 药物名称2
	private String ywmc2ci;// 药物名称2每日几次
	private String ywmc2mg;// 药物名称2第次多少mg
	private String ywmc3;// 药物名称3
	private String ywmc3ci;// 药物名称3每日几次
	private String ywmc3mg;// 药物名称3第次多少mg
	private String ywdwkhp1;// 药物1单位片或颗粒
	private String ywdwkhp2;// 药物2单位片或颗粒
	private String ywdwkhp3;// 药物3单位片或颗粒
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

	private String sg;// 身高
	private String sfsf;// 是否失访
	private String sfyy;// 失访原因
	private String fileRecordId;// 上传图像返回值
	private String diabetesFollowupNo;// 下载冠新返回值
	private String imgUrl;// 平板上传图像保存路径
	private String xybglcs;

	private String zdyymc1;// 指导用药名称1
	private String zdyyyf1;// 指导用药用量1
	private String zdyyyl1;// 指导用药用法1
	private String zdyydw1;// 指导用药单位1
	private String zdyymc2;// 指导用药名称2
	private String zdyyyf2;// 指导用药用法2
	private String zdyyyl2;// 指导用药用量2
	private String zdyydw2;// 指导用药单位2
	private String zdyymc3;// 指导用药名称3
	private String zdyyyf3;// 指导用药用法3
	private String zdyyyl3;// 指导用药用量3
	private String zdyydw3;// 指导用药单位3
	private String zzlxdh;// 联系人及其电话
	private String bz;// 备注
	private String jg;
	
	
	// 补充字段
    private String ywtzyjmc1; // 指导用药1名称
    private String ywtzyjc1ci; // 指导用药1用法
    private String ywtzyjc1mg; // 指导用药1用量
    private String ywtzyjdw1; // 指导用药1单位
    private String ywtzyjmc2; // 指导用药2名称
    private String ywtzyjc2ci; // 指导用药2用法
    private String ywtzyjc2mg; // 指导用药2用量
    private String ywtzyjdw2; // 指导用药2单位
    private String ywtzyjmc3; // 指导用药3名称
    private String ywtzyjc3ci; // 指导用药3用法
    private String ywtzyjc3mg; // 指导用药3用量
    private String ywtzyjdw3; // 指导用药3单位

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

	public String getYwtzyjmc1() {
		return ywtzyjmc1;
	}

	public void setYwtzyjmc1(String ywtzyjmc1) {
		this.ywtzyjmc1 = ywtzyjmc1;
	}

	public String getYwtzyjc1ci() {
		return ywtzyjc1ci;
	}

	public void setYwtzyjc1ci(String ywtzyjc1ci) {
		this.ywtzyjc1ci = ywtzyjc1ci;
	}

	public String getYwtzyjc1mg() {
		return ywtzyjc1mg;
	}

	public void setYwtzyjc1mg(String ywtzyjc1mg) {
		this.ywtzyjc1mg = ywtzyjc1mg;
	}

	public String getYwtzyjdw1() {
		return ywtzyjdw1;
	}

	public void setYwtzyjdw1(String ywtzyjdw1) {
		this.ywtzyjdw1 = ywtzyjdw1;
	}

	public String getYwtzyjmc2() {
		return ywtzyjmc2;
	}

	public void setYwtzyjmc2(String ywtzyjmc2) {
		this.ywtzyjmc2 = ywtzyjmc2;
	}

	public String getYwtzyjc2ci() {
		return ywtzyjc2ci;
	}

	public void setYwtzyjc2ci(String ywtzyjc2ci) {
		this.ywtzyjc2ci = ywtzyjc2ci;
	}

	public String getYwtzyjc2mg() {
		return ywtzyjc2mg;
	}

	public void setYwtzyjc2mg(String ywtzyjc2mg) {
		this.ywtzyjc2mg = ywtzyjc2mg;
	}

	public String getYwtzyjdw2() {
		return ywtzyjdw2;
	}

	public void setYwtzyjdw2(String ywtzyjdw2) {
		this.ywtzyjdw2 = ywtzyjdw2;
	}

	public String getYwtzyjmc3() {
		return ywtzyjmc3;
	}

	public void setYwtzyjmc3(String ywtzyjmc3) {
		this.ywtzyjmc3 = ywtzyjmc3;
	}

	public String getYwtzyjc3ci() {
		return ywtzyjc3ci;
	}

	public void setYwtzyjc3ci(String ywtzyjc3ci) {
		this.ywtzyjc3ci = ywtzyjc3ci;
	}

	public String getYwtzyjc3mg() {
		return ywtzyjc3mg;
	}

	public void setYwtzyjc3mg(String ywtzyjc3mg) {
		this.ywtzyjc3mg = ywtzyjc3mg;
	}

	public String getYwtzyjdw3() {
		return ywtzyjdw3;
	}

	public void setYwtzyjdw3(String ywtzyjdw3) {
		this.ywtzyjdw3 = ywtzyjdw3;
	}

	public String getJg() {
		return jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getZzlxdh() {
		return zzlxdh;
	}

	public void setZzlxdh(String zzlxdh) {
		this.zzlxdh = zzlxdh;
	}

	public String getZdyymc1() {
		return zdyymc1;
	}

	public void setZdyymc1(String zdyymc1) {
		this.zdyymc1 = zdyymc1;
	}

	public String getZdyyyf1() {
		return zdyyyf1;
	}

	public void setZdyyyf1(String zdyyyf1) {
		this.zdyyyf1 = zdyyyf1;
	}

	public String getZdyyyl1() {
		return zdyyyl1;
	}

	public void setZdyyyl1(String zdyyyl1) {
		this.zdyyyl1 = zdyyyl1;
	}

	public String getZdyydw1() {
		return zdyydw1;
	}

	public void setZdyydw1(String zdyydw1) {
		this.zdyydw1 = zdyydw1;
	}

	public String getZdyymc2() {
		return zdyymc2;
	}

	public void setZdyymc2(String zdyymc2) {
		this.zdyymc2 = zdyymc2;
	}

	public String getZdyyyf2() {
		return zdyyyf2;
	}

	public void setZdyyyf2(String zdyyyf2) {
		this.zdyyyf2 = zdyyyf2;
	}

	public String getZdyyyl2() {
		return zdyyyl2;
	}

	public void setZdyyyl2(String zdyyyl2) {
		this.zdyyyl2 = zdyyyl2;
	}

	public String getZdyydw2() {
		return zdyydw2;
	}

	public void setZdyydw2(String zdyydw2) {
		this.zdyydw2 = zdyydw2;
	}

	public String getZdyymc3() {
		return zdyymc3;
	}

	public void setZdyymc3(String zdyymc3) {
		this.zdyymc3 = zdyymc3;
	}

	public String getZdyyyf3() {
		return zdyyyf3;
	}

	public void setZdyyyf3(String zdyyyf3) {
		this.zdyyyf3 = zdyyyf3;
	}

	public String getZdyyyl3() {
		return zdyyyl3;
	}

	public void setZdyyyl3(String zdyyyl3) {
		this.zdyyyl3 = zdyyyl3;
	}

	public String getZdyydw3() {
		return zdyydw3;
	}

	public void setZdyydw3(String zdyydw3) {
		this.zdyydw3 = zdyydw3;
	}

	public String getXybglcs() {
		return xybglcs;
	}

	public void setXybglcs(String xybglcs) {
		this.xybglcs = xybglcs;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDiabetesFollowupNo() {
		return diabetesFollowupNo;
	}

	public void setDiabetesFollowupNo(String diabetesFollowupNo) {
		this.diabetesFollowupNo = diabetesFollowupNo;
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

	public String getYwdwkhp1() {
		return ywdwkhp1;
	}

	public void setYwdwkhp1(String ywdwkhp1) {
		this.ywdwkhp1 = ywdwkhp1;
	}

	public String getYwdwkhp2() {
		return ywdwkhp2;
	}

	public void setYwdwkhp2(String ywdwkhp2) {
		this.ywdwkhp2 = ywdwkhp2;
	}

	public String getYwdwkhp3() {
		return ywdwkhp3;
	}

	public void setYwdwkhp3(String ywdwkhp3) {
		this.ywdwkhp3 = ywdwkhp3;
	}

	public String getZbdmbdbs() {
		return zbdmbdbs;
	}

	public void setZbdmbdbs(String zbdmbdbs) {
		this.zbdmbdbs = zbdmbdbs;
	}

	private String updateFlg;

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

	public void setZz(String zz) {
		this.zz = zz;
	}

	public String getZzName() {
		return DictUtil.getDictValue("tnb-zz", this.zz);
	}

	public void setZzName(String zzName) {
		this.zzName = zzName;
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

	public String getZbdmbd() {
		return this.zbdmbd;
	}

	public void setZbdmbd(String zbdmbd) {
		this.zbdmbd = zbdmbd;
	}

	public String getZbdmbdName() {
		return DictUtil.getDictValue("tnb-zbdmbd", this.zbdmbd);
	}

	public void setZbdmbdName(String zbdmbdName) {
		this.zbdmbdName = zbdmbdName;
	}

	public String getQtzz1() {
		return this.qtzz1;
	}

	public void setQtzz1(String qtzz1) {
		this.qtzz1 = qtzz1;
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

	public String getMcydsj() {
		return this.mcydsj;
	}

	public void setMcydsj(String mcydsj) {
		this.mcydsj = mcydsj;
	}

	public String getZsmtdsk() {
		return this.zsmtdsk;
	}

	public void setZsmtdsk(String zsmtdsk) {
		this.zsmtdsk = zsmtdsk;
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

	public String getKfxtz() {
		return this.kfxtz;
	}

	public void setKfxtz(String kfxtz) {
		this.kfxtz = kfxtz;
	}

	public String getThxhdb() {
		return this.thxhdb;
	}

	public void setThxhdb(String thxhdb) {
		this.thxhdb = thxhdb;
	}

	public Date getJcrq() {
		return this.jcrq;
	}

	public void setJcrq(Date jcrq) {
		this.jcrq = jcrq;
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

	public String getDxtfy() {
		return this.dxtfy;
	}

	public void setDxtfy(String dxtfy) {
		this.dxtfy = dxtfy;
	}

	public String getDxtfyName() {
		return DictUtil.getDictValue("tnb-dxtfy", this.dxtfy);
	}

	public void setDxtfyName(String dxtfyName) {
		this.dxtfyName = dxtfyName;
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

	public String getYdszl() {
		return this.ydszl;
	}

	public void setYdszl(String ydszl) {
		this.ydszl = ydszl;
	}

	public String getYdsyfhyl() {
		return this.ydsyfhyl;
	}

	public void setYdsyfhyl(String ydsyfhyl) {
		this.ydsyfhyl = ydsyfhyl;
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

	public String getXcsftzmb() {
		return this.xcsftzmb;
	}

	public void setXcsftzmb(String xcsftzmb) {
		this.xcsftzmb = xcsftzmb;
	}

	public String getXcsftzzsmb() {
		return this.xcsftzzsmb;
	}

	public void setXcsftzzsmb(String xcsftzzsmb) {
		this.xcsftzzsmb = xcsftzzsmb;
	}

	public String getXcsfrxylmb() {
		return this.xcsfrxylmb;
	}

	public void setXcsfrxylmb(String xcsfrxylmb) {
		this.xcsfrxylmb = xcsfrxylmb;
	}

	public String getXcsfryjlmb() {
		return this.xcsfryjlmb;
	}

	public void setXcsfryjlmb(String xcsfryjlmb) {
		this.xcsfryjlmb = xcsfryjlmb;
	}

	public String getXcsfmzydcsmb() {
		return this.xcsfmzydcsmb;
	}

	public void setXcsfmzydcsmb(String xcsfmzydcsmb) {
		this.xcsfmzydcsmb = xcsfmzydcsmb;
	}

	public String getXcsfmcydsjmb() {
		return this.xcsfmcydsjmb;
	}

	public void setXcsfmcydsjmb(String xcsfmcydsjmb) {
		this.xcsfmcydsjmb = xcsfmcydsjmb;
	}

	public String getMcydsjName() {
		return DictUtil.getDictValue("tnb-ydsj", this.mcydsj);
	}

	public void setMcydsjName(String mcydsjName) {
		this.mcydsjName = mcydsjName;
	}

	public String getXcsfmcydsjmbName() {
		return DictUtil.getDictValue("tnb-ydsj", this.xcsfmcydsjmb);
	}

	public void setXcsfmcydsjmbName(String xcsfmcydsjmbName) {
		this.xcsfmcydsjmbName = xcsfmcydsjmbName;
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

	public String getXcsfzsmb() {
		return this.xcsfzsmb;
	}

	public void setXcsfzsmb(String xcsfzsmb) {
		this.xcsfzsmb = xcsfzsmb;
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

	public FollowTnbJb getFollowTnbJb() {
		return followTnbJb;
	}

	public void setFollowTnbJb(FollowTnbJb followTnbJb) {
		this.followTnbJb = followTnbJb;
	}


}
