package com.region.moudles.inspectcenter.poct.service.impl;

import com.region.moudles.inspectcenter.poct.dao.PoctDao;
import com.region.moudles.inspectcenter.poct.domain.Poct;
import com.region.moudles.inspectcenter.poct.service.PoctService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PoctServiceImpl implements PoctService {

    @Inject
    private PoctDao poctDao;

    //查询检验列表
    @Override
    public List<Poct> getPoctList(Poct poct) {
        return poctDao.getPoctList(poct);
    }

    //查询检验详情
    @Override
    public Poct getPoct(String id) {
        return poctDao.get(id);
    }
}
