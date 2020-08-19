package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.utils.cache.MenuCache;
import com.region.moudles.system.dao.repository.SysMenuRepository;
import com.region.moudles.system.domain.SysMenu;
import com.region.until.StringUntil;

import javax.inject.Named;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class SysMenuDao extends BaseDao<SysMenuRepository,SysMenu> {

   public List<SysMenu> getMenuTree(){
      StringBuffer sql=new StringBuffer();
      sql.append(" select a.id, a.type, a.url, a.icon, a.parent_id, a.name");
      sql.append(" from sys_menu a");
      sql.append(" where a.status = '1' and type = '1' ");
      sql.append(" start with a.parent_id = '0'");
      sql.append(" connect by a.parent_id = prior a.id");
      sql.append(" order by to_number(a.order_num) ");

      return queryList(sql.toString(),null,SysMenu.class);

   }

   public void queryMenuPage(SysMenu sysmenu, PageModel page){
       StringBuffer sql=new StringBuffer();
       sql.append("select a.id, a.type, a.url, a.icon, a.parent_id, a.name, a.handle_type");
       sql.append(" from sys_menu a");
       sql.append(" where a.status = '1'");
       if(!StringUntil.isNull(sysmenu.getParentId())) {
    	   sql.append(" and a.parent_id = :parentId ");
       }
       if(!StringUntil.isNull(sysmenu.getName())) {
    	   sql.append(" and a.name like concat('%', concat(:name, '%')) "); 
       }
       sql.append(" order by to_number(a.order_num) ");
       queryPage(sql.toString(), sysmenu, page, SysMenu.class);
   }
   
   public void updateMenu(String id,String status){
       repository.updateMenu(id,status);
   }
   
   	//查询用户操作权限菜单 
	public List<String> getMenuByUser(String userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		StringBuffer sql = new StringBuffer();
		sql.append(" select m.id  ")
		.append("   from sys_role_user ur ")
		.append("   join sys_role r on ur.role_id=r.id and r.status='1' ")
		.append("  join sys_menu_role rm on rm.role_id=r.id ")
		.append("   join sys_menu m on m.status='1' and m.id = rm.menu_id ")
		.append("  where ur.user_id=:userId ")
		.append("  order BY to_number(m.order_num) ");
		return queryList(sql.toString(), paramMap, String.class);
	}
	
   public List<MenuCache> getAllMenuAndHandleList() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select m.id id, ")
			.append("  m.type  type, ")
			.append("  m.url   url, ")
			.append("  m.name  name, ")
			.append("  m.parent_id  parentId, ")
			.append("  m.handle_type  handleType, ")
			.append("  m.icon  icon, ")
			.append("  m.menu_level menuLevel, ")
			.append("  m.order_num orderNum, ")
			.append("  m.status status, ")
			.append("  m.title  title ")
			.append("  from sys_menu m ")
			.append("  where m.status='1' ")
			.append("  start with m.parent_id = '0' and m.status='1' ")
			.append(" connect by prior m.id = m.parent_id ")
			.append("  order BY to_number(m.order_num) ");
		return queryList(sql.toString(), null, MenuCache.class);
	}
   
   public SysMenu getMenuInfoById(String menuId){
		StringBuffer sql=new StringBuffer();
	    sql.append(" select a.id id, a.parent_id  parentId ");
	    sql.append(" from sys_menu a");
	    sql.append(" where a.id = :menuId ");
	    Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("menuId", menuId);
	    return queryOne(sql.toString(), paramMap, SysMenu.class);
	
	}
   
	public SysMenu getFarMenuInfoByChildId(String menuId){
		StringBuffer sql=new StringBuffer();
	    sql.append(" select a.id id, a.parent_id  parentId ");
	    sql.append(" from sys_menu a");
	    sql.append(" where a.status = '1' and type = '1' ");
	    sql.append(" and a.id = (select parent_id from sys_menu where id = :menuId) ");
	    Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("menuId", menuId);
	    return queryOne(sql.toString(), paramMap, SysMenu.class);
	
	}
}
