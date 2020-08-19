package com.region.moudles.main.controller;

import com.region.moudles.common.controller.BaseController;
import com.region.until.UUIDUtil;
import com.region.until.cache.CacheEmun;
import com.region.until.cache.CacheUtils;
import com.region.until.cache.EhCacheUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/main")
public class MainController extends BaseController {

    @RequestMapping("auth")
    public void getAuth(){
          String authId= UUIDUtil.getUUID();
          EhCacheUtils.putLiveTime("sysCache",authId,"1",60);
          response.addHeader("auth",authId);
    }
}
