package com.region.moudles.system.service.impl;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.system.dao.SysMenuDao;
import com.region.moudles.system.domain.SysMenu;
import com.region.moudles.system.service.SysMenuService;

import javax.inject.Named;
import java.util.List;

@Named
public class SysMenuServiceImpl  extends BaseServiceImpl<SysMenuDao,SysMenu> implements SysMenuService{


    @Override
    public List<SysMenu> getMenuTree() {
        return dao.getMenuTree();
    }

    @Override
    public void queryMenuPage(SysMenu sysmenu, PageModel page) {
       dao.queryMenuPage(sysmenu, page);
    }

    @Override
    public void updateMenu(String id, String status) {
            dao.updateMenu(id,status);
    }
}
