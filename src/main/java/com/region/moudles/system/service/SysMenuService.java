package com.region.moudles.system.service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.BaseService;
import com.region.moudles.system.domain.SysMenu;

import java.util.List;


public interface SysMenuService  extends BaseService<SysMenu>{


    /**
     * 菜单管理
     * @return
     */
    List<SysMenu> getMenuTree();

    /**
     * 分页查询
     * @param page
     */
    void queryMenuPage(SysMenu sysmenu, PageModel page);

    void updateMenu(String id,String status);
}
