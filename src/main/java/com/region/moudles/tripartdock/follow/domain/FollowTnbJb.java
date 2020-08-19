package com.region.moudles.tripartdock.follow.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

/**
 * @ClassName: FollowMxTnbJb
 * @Description: 随访-糖尿病-基本信息
 * @author Administrator
 * @date 2019年7月31日
 */
@Entity
@Table(name = "blt_mxtnbjbxxb")
public class FollowTnbJb extends BaseDomain{
	
	private static final long serialVersionUID = 1664164314L;
	
	@Id
	private String id;//
	private String hzbh;//患者编号
	private String dah;//档案号
	private String sfzh;//身份证号
	private String  glzb;//管理组别  
	private String  blly;//病例来源
	private String  jzs;//家族史
	private String  tnblx;//糖尿病类型 
	private Date  qzsj;//确诊时间
	private String  qzdw;//确诊单位
	private String   sfsyyds;//是否使用胰岛素
	private String   ydsyl;//胰岛素用量
	private String   ynpl;//依那普利
	private String   sfzzgl;//是否终止管理
	private String   zzglyy;//终止管理原因
	private Date   zzglrq;//终止管理日期
	private Date   bfsj;//病发时间
	private String   jbjg;//建表机构
	private String   dqjg;//当前机构
	private String   jbr;//建表人
	private Date   jbrq;//建表日期
	private String   scxgr;//上一次修改人
	@JSONField(format="yyyy-MM-dd")
	private Date   scxgrq;//上一次修改日期
	private String   sfsc ;//是否删除
	private String   tnbbfqk;//糖尿病病发情况
	private String   szbbsj;//肾脏病变时间
	private String   sjbbsj;//神经病变时间
	private String   xzbbsj;//心脏病变时间
	private String   swmbbsj;//视网膜病变时间
	private String   zbbbsj;//足部病变时间
	private String   nxgbbsj;//脑血管病变时间
	private String   qtbb;//其他病变
	private String   qtbbsj;//其他病变时间
	private String   sfbb;//是否病变
	private String   mqzz;//目前症状
	private String   importDeviceNum;//导入设备号
	private Date   importTime;//导入时间 
	private String   importUser;//导入人
	private String   importIp;//导入IP
	private String   synFlg;//是否同步 0 否 1 是
	private String synId;
	private String  dataSource;
	private String  dataSourceNo;
	private String   updateFlg;
	private String  qzfs;
	private String jwkfxt;
	private Date synTime;
	
	public Date getSynTime() {
		return synTime;
	}
	public void setSynTime(Date synTime) {
		this.synTime = synTime;
	}
	public String getQzfs() {
		return qzfs;
	}
	public void setQzfs(String qzfs) {
		this.qzfs = qzfs;
	}
	public String getJwkfxt() {
		return jwkfxt;
	}
	public void setJwkfxt(String jwkfxt) {
		this.jwkfxt = jwkfxt;
	}
	public String getDataSourceNo() {
		return dataSourceNo;
	}
	public void setDataSourceNo(String dataSourceNo) {
		this.dataSourceNo = dataSourceNo;
	}
	public String getUpdateFlg() {
		return updateFlg;
	}
	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public Date getImportTime() {
		return importTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHzbh() {
		return hzbh;
	}
	public void setHzbh(String hzbh) {
		this.hzbh = hzbh;
	}
	public String getDah() {
		return dah;
	}
	public void setDah(String dah) {
		this.dah = dah;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getGlzb() {
		return glzb;
	}
	public void setGlzb(String glzb) {
		this.glzb = glzb;
	}
	public String getBlly() {
		return blly;
	}
	public void setBlly(String blly) {
		this.blly = blly;
	}
	public String getJzs() {
		return jzs;
	}
	public void setJzs(String jzs) {
		this.jzs = jzs;
	}
	public String getTnblx() {
		return tnblx;
	}
	public void setTnblx(String tnblx) {
		this.tnblx = tnblx;
	}
	
	public Date getQzsj() {
		return qzsj;
	}
	public void setQzsj(Date qzsj) {
		this.qzsj = qzsj;
	}
	public String getQzdw() {
		return qzdw;
	}
	public void setQzdw(String qzdw) {
		this.qzdw = qzdw;
	}
	public String getSfsyyds() {
		return sfsyyds;
	}
	public void setSfsyyds(String sfsyyds) {
		this.sfsyyds = sfsyyds;
	}
	public String getYdsyl() {
		return ydsyl;
	}
	public void setYdsyl(String ydsyl) {
		this.ydsyl = ydsyl;
	}
	public String getYnpl() {
		return ynpl;
	}
	public void setYnpl(String ynpl) {
		this.ynpl = ynpl;
	}
	public String getSfzzgl() {
		return sfzzgl;
	}
	public void setSfzzgl(String sfzzgl) {
		this.sfzzgl = sfzzgl;
	}
	public String getZzglyy() {
		return zzglyy;
	}
	public void setZzglyy(String zzglyy) {
		this.zzglyy = zzglyy;
	}
	
	public Date getBfsj() {
		return bfsj;
	}
	public void setBfsj(Date bfsj) {
		this.bfsj = bfsj;
	}
	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}
	public String getJbjg() {
		return jbjg;
	}
	public void setJbjg(String jbjg) {
		this.jbjg = jbjg;
	}
	public String getDqjg() {
		return dqjg;
	}
	public void setDqjg(String dqjg) {
		this.dqjg = dqjg;
	}
	public String getJbr() {
		return jbr;
	}
	public void setJbr(String jbr) {
		this.jbr = jbr;
	}
	public String getScxgr() {
		return scxgr;
	}
	public void setScxgr(String scxgr) {
		this.scxgr = scxgr;
	}
	public String getSfsc() {
		return sfsc;
	}
	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}
	public String getTnbbfqk() {
		return tnbbfqk;
	}
	public void setTnbbfqk(String tnbbfqk) {
		this.tnbbfqk = tnbbfqk;
	}
	public String getQtbb() {
		return qtbb;
	}
	public void setQtbb(String qtbb) {
		this.qtbb = qtbb;
	}
	public String getSfbb() {
		return sfbb;
	}
	public void setSfbb(String sfbb) {
		this.sfbb = sfbb;
	}
	public String getMqzz() {
		return mqzz;
	}
	public void setMqzz(String mqzz) {
		this.mqzz = mqzz;
	}
	public String getImportDeviceNum() {
		return importDeviceNum;
	}
	public void setImportDeviceNum(String importDeviceNum) {
		this.importDeviceNum = importDeviceNum;
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
	public String getSynFlg() {
		return synFlg;
	}
	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}
	public Date getZzglrq() {
		return zzglrq;
	}
	public void setZzglrq(Date zzglrq) {
		this.zzglrq = zzglrq;
	}
	public Date getJbrq() {
		return jbrq;
	}
	public void setJbrq(Date jbrq) {
		this.jbrq = jbrq;
	}
	public Date getScxgrq() {
		return scxgrq;
	}
	public void setScxgrq(Date scxgrq) {
		this.scxgrq = scxgrq;
	}
	public String getSzbbsj() {
		return szbbsj;
	}
	public void setSzbbsj(String szbbsj) {
		this.szbbsj = szbbsj;
	}
	public String getSjbbsj() {
		return sjbbsj;
	}
	public void setSjbbsj(String sjbbsj) {
		this.sjbbsj = sjbbsj;
	}
	public String getXzbbsj() {
		return xzbbsj;
	}
	public void setXzbbsj(String xzbbsj) {
		this.xzbbsj = xzbbsj;
	}
	public String getSwmbbsj() {
		return swmbbsj;
	}
	public void setSwmbbsj(String swmbbsj) {
		this.swmbbsj = swmbbsj;
	}
	public String getZbbbsj() {
		return zbbbsj;
	}
	public void setZbbbsj(String zbbbsj) {
		this.zbbbsj = zbbbsj;
	}
	public String getNxgbbsj() {
		return nxgbbsj;
	}
	public void setNxgbbsj(String nxgbbsj) {
		this.nxgbbsj = nxgbbsj;
	}
	public String getQtbbsj() {
		return qtbbsj;
	}
	public void setQtbbsj(String qtbbsj) {
		this.qtbbsj = qtbbsj;
	}
	public String getSynId() {
		return synId;
	}
	public void setSynId(String synId) {
		this.synId = synId;
	}
}
