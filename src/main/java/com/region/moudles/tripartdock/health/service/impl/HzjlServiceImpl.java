package com.region.moudles.tripartdock.health.service.impl;

import com.region.moudles.tripartdock.health.bean.Hzjl;
import com.region.moudles.tripartdock.health.dao.HzjlDao;
import com.region.moudles.tripartdock.health.service.HzjlService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class HzjlServiceImpl implements HzjlService {
    @Autowired
    private HzjlDao hzjlDao;


    @Override
    public Hzjl getInfo(String id) {
        return hzjlDao.getById(id);
    }
}
