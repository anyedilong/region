package com.region.moudles.tripartdock.health.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import com.region.moudles.tripartdock.health.dao.YfjzDao;
import com.region.moudles.tripartdock.health.dto.YfjzDto;
import com.region.moudles.tripartdock.health.service.YfjzService;

@Named
public class YfjzServiceImpl implements YfjzService {

    @Autowired
    private YfjzDao yfjzDao;

    @Override
    public YfjzDto getInfo(RequestDto request) {
        List<YfjzDto> list = yfjzDao.getAll(request);
        YfjzDto yfjzDto = null;
        if (list != null && list.size() > 0) {
            yfjzDto = list.get(0);
        }
        return yfjzDto;
    }

    @Override
    public JsonResult getList(RequestDto request) throws Exception {
        List<YfjzDto> list = yfjzDao.getAll(request);
        int count = yfjzDao.getCount(request);
        PageModel res = new PageModel();
        res.setList(list);
        res.setCount(count);
        return new JsonResult(res);
    }
}
