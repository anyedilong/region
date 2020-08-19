package com.region.moudles.stats.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: StatsResultModel
 * @Description: 用于存储charts展示的数据model
 * @author Administrator
 * @date 2019年6月24日
 */
public class StatsResultModel implements Serializable{

	private static final long serialVersionUID = 646946163L;
	
	//建档人数
	private String archiveNum;
	//签约人数
	private String signNum;
	//体检人数
	private String tjNum;
	//贫困人数
	private String pkNum;
	//脱贫人数
	private String tpNum;
	//新冠检验人数
	private String nucleinNum;
	//x轴
	private List<String> xList = new ArrayList<>();
	//y轴
	private List<Object> y1List = new ArrayList<>();
	private List<Object> y2List = new ArrayList<>();
	private List<Object> y3List = new ArrayList<>();
	private List<Object> y4List = new ArrayList<>();
	private List<Object> y5List = new ArrayList<>();
	
	public String getArchiveNum() {
		return archiveNum;
	}
	public void setArchiveNum(String archiveNum) {
		this.archiveNum = archiveNum;
	}
	public String getSignNum() {
		return signNum;
	}
	public void setSignNum(String signNum) {
		this.signNum = signNum;
	}
	public String getTjNum() {
		return tjNum;
	}
	public void setTjNum(String tjNum) {
		this.tjNum = tjNum;
	}
	public String getPkNum() {
		return pkNum;
	}
	public void setPkNum(String pkNum) {
		this.pkNum = pkNum;
	}
	public String getTpNum() {
		return tpNum;
	}
	public void setTpNum(String tpNum) {
		this.tpNum = tpNum;
	}
	public String getNucleinNum() {
		return nucleinNum;
	}
	public void setNucleinNum(String nucleinNum) {
		this.nucleinNum = nucleinNum;
	}
	public List<String> getxList() {
		return xList;
	}
	public void setxList(List<String> xList) {
		this.xList = xList;
	}
	public List<Object> getY1List() {
		return y1List;
	}
	public void setY1List(List<Object> y1List) {
		this.y1List = y1List;
	}
	public List<Object> getY2List() {
		return y2List;
	}
	public void setY2List(List<Object> y2List) {
		this.y2List = y2List;
	}
	public List<Object> getY3List() {
		return y3List;
	}
	public void setY3List(List<Object> y3List) {
		this.y3List = y3List;
	}
	public List<Object> getY4List() {
		return y4List;
	}
	public void setY4List(List<Object> y4List) {
		this.y4List = y4List;
	}
	public List<Object> getY5List() {
		return y5List;
	}
	public void setY5List(List<Object> y5List) {
		this.y5List = y5List;
	}
	
}
