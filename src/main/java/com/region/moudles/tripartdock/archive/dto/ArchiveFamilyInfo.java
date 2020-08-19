package com.region.moudles.tripartdock.archive.dto;


import java.io.Serializable;

/**
 * 
 * @ClassName ArchiveQueryCon
 * @Description 档案-家庭信息
 * @author sen
 * @Date 2019年11月21日 上午10:43:33
 * @version 1.0.0
 */
public class ArchiveFamilyInfo implements Serializable {

	private static final long serialVersionUID = 646541688746226L;
	
	private String hzxm;
	private String hzsfzh;
	private String familyCount;
	private String liveCondite;
	
	
	public String getHzxm() {
		return hzxm;
	}
	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}
	public String getHzsfzh() {
		return hzsfzh;
	}
	public void setHzsfzh(String hzsfzh) {
		this.hzsfzh = hzsfzh;
	}
	public String getFamilyCount() {
		return familyCount;
	}
	public void setFamilyCount(String familyCount) {
		this.familyCount = familyCount;
	}
	public String getLiveCondite() {
		return liveCondite;
	}
	public void setLiveCondite(String liveCondite) {
		if("1".equals(liveCondite)) {
			liveCondite = "本地户籍常住";
		}else if("2".equals(liveCondite)) {
			liveCondite = "本地户籍不常住";
		}else if("3".equals(liveCondite)) {
			liveCondite = "外地户籍常住";
		}else if("4".equals(liveCondite)) {
			liveCondite = "不详";
		}
		this.liveCondite = liveCondite;
	}
	
	
}
