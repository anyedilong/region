package com.region.moudles.tripartdock.health.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.health.bean.Referral;
import com.region.moudles.tripartdock.health.service.ReferralService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

//转诊
@RestController
@RequestMapping("${hispath}/referral")
public class ReferralController extends BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private ReferralService referralService;

    
    /**
     * @Description: 转诊列表
     * @param @return
     * @return PageModel
     * @throws
     */
  	@RequestMapping("getReferralPage")
  	public PageModel getReferralPage() {
  		try {
  			String jmId = request.getParameter("jmId");
  			String pageSize = request.getParameter("pageSize");
  			String pageNo = request.getParameter("pageNo");
  			PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
  			referralService.getReferralPage(jmId, page);
            return page;
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		return null;
  	}
    
    /**
     * 获取转诊详情
     */
    @RequestMapping("getInfo")
    public JsonResult getInfo() {
        String param = getParam(request);
        logger.info("查询转诊详情请求参数：" + param);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        Referral referral = referralService.getInfo(id);
        logger.info("查询转诊详情返回：" + JSON.toJSONString(referral));
        return jsonResult(referral);
    }
}
