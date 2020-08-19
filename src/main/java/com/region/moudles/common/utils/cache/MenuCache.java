package com.region.moudles.common.utils.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName Menu
 * @Description 菜单
 * @author sen
 * @Date 2017年2月20日 上午11:06:00
 * @version 1.0.0
 */
public class MenuCache implements Serializable {

	/**
	 * @Field @serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 165423423423L;

	private String id;// ID
	private String type;// 类型 1菜单 2 操作
	private String url;// URL
	private String name;// 名称
	private String parentId;// 上级ID
	private String icon;// 图标
	private int menuLevel;// 等级
	private String orderNum;// 排序号
	private String status;// 状态 1 正常 2冻结 3 删除

	private String title;// 标题
	private String handleType;//操作类型

	private List<MenuCache> children = new ArrayList<MenuCache>();// 下级数据

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<MenuCache> getChildren() {
		return children;
	}

	public void setChildren(List<MenuCache> children) {
		this.children = children;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

}
