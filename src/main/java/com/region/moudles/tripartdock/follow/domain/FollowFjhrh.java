package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

/**
 * @ClassName: FollowFjhrh
 * @Description: 肺结核入户
 * @author Administrator
 * @date 2019年8月1日
 */
@Entity
@Table(name="blt_first_pdb")
public class FollowFjhrh extends BaseDomain{

	/**
	 * @Field @serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;//ID

	private String jmid;//居民id
	@Column(name="sfzh",updatable=false)
	private String sfzh;//身份证号
	
	private String hzbh;//患者编号
	
	private String sffs;//随访方式
	
	private String hzlx;//患者类型
	private String tjqk;//痰菌情况
	private String nyqk;//耐药情况
	private String zzjtz;//症状及体征
	private String qt;//其他
	private String hlfa;//化疗方案
	private String yf;//用法
	private String ypjx;//药品剂型
	private String ddry;//督导人员选择
	private String ddjs;//单独的居室
	private String tfqk;//通风情况
	private String xyl;//吸烟量
	private String xypl;//吸烟频率
	private String yjl;//饮酒量
	private String yjpl;//饮酒频率
	
	@JSONField(format="yyyy-MM-dd")
	private Date xcsfsj;//下次随访时间
	
	@Column(name="ys")
	private String ys;//评估医生
	@JSONField(format="yyyy-MM-dd")
	private Date sfsj;//随访时间
	
	@Column(name="create_user",updatable=false)
	private String createUser;//创建人

	@JSONField(format="yyyy-MM-dd")
	private Date createTime;//创建时间
	
	private String status="0";//状态：0正常1删除
	
	private String qydd;//取药地点
	
	@JSONField(format="yyyy-MM-dd")
	private Date qysj;//取药时间
	
	private String fyjlk;  //'服药记录卡的填写 '
	private String fyyfjcf;  //'服药方法及药品存放 '
	private String zllc;  //'肺结核治疗疗程  '
	private String fywh;  //'不规律服药危害 '
	private String blfyjcl;  //'服药后不良反应及处理  '
	private String fzct;  //'治疗期间复诊查痰  ';
	private String jcfy;  //'外出期间如何坚持服药  '
	private String sfxg;  //'生活习惯及注意事项 '
	private String jczjc;  //'密切接触者检查'
	@Column(name="update_org_id")
	private String updateOrgId;
	@Column(name="update_user_id")
	private String updateUserId;
	private  Date  updateTime;
	
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
	private String synFlg="0";// 是否同步 0 否 1 是
	@Column(updatable = false)
	private String synId;// 同步ID
	@Column(updatable = false)
	private Date synTime;// 同步时间

	private String updateFlg;// 同步是否修改

	@Transient
	private String sffsName;
	@Transient
	private String hzlxName;
	@Transient
	private String tjqkName;
	@Transient
	private String nyqkName;
	@Transient
	private String zzjtzName;
	@Transient
	private String yfName;
	@Transient
	private String ypjxName;
	@Transient
	private String ddryName;
	@Transient
	private String ddjsName;
	@Transient
	private String tfqkName;
	@Transient
	private String fyjlkName;
	@Transient
	private String fyyfjcfName;
	@Transient
	private String zllcName;
	@Transient
	private String fywhName;
	@Transient
	private String blfyjclName;
	@Transient
	private String fzctName;
	@Transient
	private String jcfyName;
	@Transient
	private String sfxgName;
	@Transient
	private String jczjcName;


	public String getSffsName() {
		return DictUtil.getDictValue("sffs", this.sffs);
	}

	public void setSffsName(String sffsName) {
		this.sffsName = sffsName;
	}

	public String getHzlxName() {
		return DictUtil.getDictValue("fjhrh-hzlx", this.hzlx);
	}

	public void setHzlxName(String hzlxName) {
		this.hzlxName = hzlxName;
	}

	public String getTjqkName() {
		return DictUtil.getDictValue("fjhrh-tjqk", this.tjqk);
	}

	public void setTjqkName(String tjqkName) {
		this.tjqkName = tjqkName;
	}

	public String getNyqkName() {
		return DictUtil.getDictValue("fjhrh-nyqk", this.nyqk);
	}

	public void setNyqkName(String nyqkName) {
		this.nyqkName = nyqkName;
	}

	public String getZzjtzName() {
		return DictUtil.getDictValue("fjhrh-zz", this.zzjtz);
	}

	public void setZzjtzName(String zzjtzName) {
		this.zzjtzName = zzjtzName;
	}

	public String getYfName() {
		return DictUtil.getDictValue("fjh-yf", this.yf);
	}

	public void setYfName(String yfName) {
		this.yfName = yfName;
	}

	public String getYpjxName() {
		return DictUtil.getDictValue("fjh-ypjx", this.ypjx);
	}

	public void setYpjxName(String ypjxName) {
		this.ypjxName = ypjxName;
	}

	public String getDdryName() {
		return DictUtil.getDictValue("fjh-ddry", this.ddry);
	}

	public void setDdryName(String ddryName) {
		this.ddryName = ddryName;
	}

	public String getDdjsName() {
		return DictUtil.getDictValue("et1-jbbk", this.ddjs);
	}

	public void setDdjsName(String ddjsName) {
		this.ddjsName = ddjsName;
	}

	public String getTfqkName() {
		return DictUtil.getDictValue("gxy-zyxw", this.tfqk);
	}

	public void setTfqkName(String tfqkName) {
		this.tfqkName = tfqkName;
	}

	public String getFyjlkName() {
		return DictUtil.getDictValue("fjhrh-jkjy", this.fyjlk);
	}

	public void setFyjlkName(String fyjlkName) {
		this.fyjlkName = fyjlkName;
	}

	public String getFyyfjcfName() {
		return DictUtil.getDictValue("fjhrh-jkjy", this.fyyfjcf);
	}

	public void setFyyfjcfName(String fyyfjcfName) {
		this.fyyfjcfName = fyyfjcfName;
	}

	public String getZllcName() {
		return DictUtil.getDictValue("fjhrh-jkjy", this.zllc);
	}

	public void setZllcName(String zllcName) {
		this.zllcName = zllcName;
	}

	public String getFywhName() {
		return DictUtil.getDictValue("fjhrh-jkjy", this.fywh);
	}

	public void setFywhName(String fywhName) {
		this.fywhName = fywhName;
	}

	public String getBlfyjclName() {
		return DictUtil.getDictValue("fjhrh-jkjy", this.blfyjcl);
	}

	public void setBlfyjclName(String blfyjclName) {
		this.blfyjclName = blfyjclName;
	}

	public String getFzctName() {
		return DictUtil.getDictValue("fjhrh-jkjy", this.fzct);
	}

	public void setFzctName(String fzctName) {
		this.fzctName = fzctName;
	}

	public String getJcfyName() {
		return DictUtil.getDictValue("fjhrh-jkjy", this.jcfy);
	}

	public void setJcfyName(String jcfyName) {
		this.jcfyName = jcfyName;
	}

	public String getSfxgName() {
		return DictUtil.getDictValue("fjhrh-jkjy", this.sfxg);
	}

	public void setSfxgName(String sfxgName) {
		this.sfxgName = sfxgName;
	}

	public String getJczjcName() {
		return DictUtil.getDictValue("fjhrh-jkjy", this.jczjc);
	}

	public void setJczjcName(String jczjcName) {
		this.jczjcName = jczjcName;
	}



	public Date getSynTime() {
		return synTime;
	}
	public String getJmid() {
		return jmid;
	}

	public void setJmid(String jmid) {
		this.jmid = jmid;
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
	public String getImportDeviceNum() {
		return importDeviceNum;
	}
	public void setImportDeviceNum(String importDeviceNum) {
		this.importDeviceNum = importDeviceNum;
	}
	public Date getImportTime() {
		return importTime;
	}
	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}
	public String getImportUser() {
		return importUser;
	}
	public void setImportUser(String importUser) {
		this.importUser = importUser;
	}
	public String getImportIp() {
		return importIp;
	}
	public void setImportIp(String importIp) {
		this.importIp = importIp;
	}
	public String getUpdateFlg() {
		return updateFlg;
	}
	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}
	public void setSynTime(Date synTime) {
		this.synTime = synTime;
	}
	public String getUpdateOrgId() {
		return updateOrgId;
	}
	public void setUpdateOrgId(String updateOrgId) {
		this.updateOrgId = updateOrgId;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getFyjlk() {
		return fyjlk;
	}
	public void setFyjlk(String fyjlk) {
		this.fyjlk = fyjlk;
	}
	public String getFyyfjcf() {
		return fyyfjcf;
	}
	public void setFyyfjcf(String fyyfjcf) {
		this.fyyfjcf = fyyfjcf;
	}
	public String getZllc() {
		return zllc;
	}
	public void setZllc(String zllc) {
		this.zllc = zllc;
	}
	public String getFywh() {
		return fywh;
	}
	public void setFywh(String fywh) {
		this.fywh = fywh;
	}
	public String getBlfyjcl() {
		return blfyjcl;
	}
	public void setBlfyjcl(String blfyjcl) {
		this.blfyjcl = blfyjcl;
	}
	public String getFzct() {
		return fzct;
	}
	public void setFzct(String fzct) {
		this.fzct = fzct;
	}
	public String getJcfy() {
		return jcfy;
	}
	public void setJcfy(String jcfy) {
		this.jcfy = jcfy;
	}
	public String getSfxg() {
		return sfxg;
	}
	public void setSfxg(String sfxg) {
		this.sfxg = sfxg;
	}
	public String getJczjc() {
		return jczjc;
	}
	public void setJczjc(String jczjc) {
		this.jczjc = jczjc;
	}
	public String getQydd() {
		return qydd;
	}
	public void setQydd(String qydd) {
		this.qydd = qydd;
	}
	public Date getQysj() {
		return qysj;
	}
	public void setQysj(Date qysj) {
		this.qysj = qysj;
	}
	public String getSynId() {
		return synId;
	}
	public void setSynId(String synId) {
		this.synId = synId;
	}
	public String getSynFlg() {
		return synFlg;
	}
	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}

	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public String getHzbh() {
		return hzbh;
	}
	public void setHzbh(String hzbh) {
		this.hzbh = hzbh;
	}
	public String getSffs() {
		return sffs;
	}
	public void setSffs(String sffs) {
		this.sffs = sffs;
	}
	public String getHzlx() {
		return hzlx;
	}
	public void setHzlx(String hzlx) {
		this.hzlx = hzlx;
	}
	public String getTjqk() {
		return tjqk;
	}
	public void setTjqk(String tjqk) {
		this.tjqk = tjqk;
	}
	public String getNyqk() {
		return nyqk;
	}
	public void setNyqk(String nyqk) {
		this.nyqk = nyqk;
	}
	public String getZzjtz() {
		return zzjtz;
	}
	public void setZzjtz(String zzjtz) {
		this.zzjtz = zzjtz;
	}
	public String getQt() {
		return qt;
	}
	public void setQt(String qt) {
		this.qt = qt;
	}
	public String getHlfa() {
		return hlfa;
	}
	public void setHlfa(String hlfa) {
		this.hlfa = hlfa;
	}
	public String getYf() {
		return yf;
	}
	public void setYf(String yf) {
		this.yf = yf;
	}
	public String getYpjx() {
		return ypjx;
	}
	public void setYpjx(String ypjx) {
		this.ypjx = ypjx;
	}
	public String getDdry() {
		return ddry;
	}
	public void setDdry(String ddry) {
		this.ddry = ddry;
	}
	public String getDdjs() {
		return ddjs;
	}
	public void setDdjs(String ddjs) {
		this.ddjs = ddjs;
	}
	public String getTfqk() {
		return tfqk;
	}
	public void setTfqk(String tfqk) {
		this.tfqk = tfqk;
	}
	public String getXyl() {
		return xyl;
	}
	public void setXyl(String xyl) {
		this.xyl = xyl;
	}
	public String getXypl() {
		return xypl;
	}
	public void setXypl(String xypl) {
		this.xypl = xypl;
	}
	public String getYjl() {
		return yjl;
	}
	public void setYjl(String yjl) {
		this.yjl = yjl;
	}
	public String getYjpl() {
		return yjpl;
	}
	public void setYjpl(String yjpl) {
		this.yjpl = yjpl;
	}
	public Date getXcsfsj() {
		return xcsfsj;
	}
	public void setXcsfsj(Date xcsfsj) {
		this.xcsfsj = xcsfsj;
	}
	public String getYs() {
		return ys;
	}
	public void setYs(String ys) {
		this.ys = ys;
	}
	public Date getSfsj() {
		return sfsj;
	}
	public void setSfsj(Date sfsj) {
		this.sfsj = sfsj;
	}
   
	
	

}
