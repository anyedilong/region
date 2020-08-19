package com.region.moudles.tripartdock.follow.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowEtJb;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf1;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf3;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf6;
import com.region.moudles.tripartdock.follow.domain.FollowEtXse;
import com.region.moudles.tripartdock.follow.domain.FollowEtZyygl1;
import com.region.moudles.tripartdock.follow.domain.FollowEtZyygl3;
import com.region.moudles.tripartdock.follow.domain.FollowEtZyygl6;
import com.region.moudles.tripartdock.follow.service.TripartEtService;

/**
 * @author Administrator
 * @ClassName: TripartFjhController
 * @Description: 三方对接 保存儿童信息
 * @date 2019年8月14日
 */
@RestController
@RequestMapping("${hispath}/follow")
public class TripartEtController extends BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private TripartEtService etService;

    //查询儿童基本信息列表
    @RequestMapping("getEtList")
    public JsonResult getEtList() throws Exception {
        String param = getParam(request);
        RequestDto request = JSONObject.parseObject(param, RequestDto.class);
        return etService.getEtList(request);
    }

    // 保存儿童基本信息
    @RequestMapping("etJbSave")
    public JsonResult etJbSave() {
        String param = "";
        try {
            param = request.getParameter("param");
            List<FollowEtJb> list = JSONObject.parseArray(param, FollowEtJb.class);
            if (list != null && list.size() > 0) {
                Map<String, Object> map = etService.saveEtJbInfo(list);
                if (map != null && map.size() > 0) {
                    logger.error("儿童基本信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
                    return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
                }
            }
            return jsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("儿童基本信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
            return jsonResult(param, 10001, "系统错误" + e.getMessage());
        }
    }

    //查询儿童基本信息详情
    @RequestMapping("getEtJbInfo")
    public JsonResult getEtJbInfo() throws Exception {
        String param = getParam(request);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        FollowEtJb follow = etService.getEtJbInfo(id);
        return jsonResult(follow);
    }

    //查询儿童基本信息列表
    @RequestMapping("getEtJbList")
    public JsonResult getEtJbList() throws Exception {
        String param = getParam(request);
        RequestDto request = JSONObject.parseObject(param, RequestDto.class);
        return etService.getEtJbList(request);
    }

    // 保存新生儿家庭访视
    @RequestMapping("etXsebSave")
    public JsonResult etXsebSave() {
        String param = "";
        try {
            param = request.getParameter("param");
            List<FollowEtXse> list = JSONObject.parseArray(param, FollowEtXse.class);
            if (list != null && list.size() > 0) {
                Map<String, Object> map = etService.savetXsebInfo(list);
                if (map != null && map.size() > 0) {
                    logger.error("新生儿家庭信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
                    return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
                }
            }
            return jsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新生儿家庭信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
            return jsonResult(param, 10001, "系统错误" + e.getMessage());
        }
    }

    //查询新生儿详情
    @RequestMapping("getXseInfo")
    public JsonResult getXseInfo() throws Exception {
        String param = getParam(request);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        FollowEtXse followEtXse = etService.getXseInfo(id);
        return jsonResult(followEtXse);
    }

    //查询新生儿列表
    @RequestMapping("getXseList")
    public JsonResult getXseList() throws Exception {
        String param = getParam(request);
        RequestDto request = JSONObject.parseObject(param, RequestDto.class);
        return etService.getXseList(request);
    }

    // 保存一岁以内的儿童随访
    @RequestMapping("etOneYearSfSave")
    public JsonResult etOneYearSfSave() {
        String param = "";
        try {
            param = request.getParameter("param");
            List<FollowEtSf1> list = JSONObject.parseArray(param, FollowEtSf1.class);
            if (list != null && list.size() > 0) {
                Map<String, Object> map = etService.saveEtOneYearSfInfo(list);
                if (map != null && map.size() > 0) {
                    logger.error("1岁以内儿童随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
                    return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
                }
            }
            return jsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("1岁以内儿童随访信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
            return jsonResult(param, 10001, "系统错误" + e.getMessage());
        }
    }

    //查询一岁以内儿童详情
    @RequestMapping("getEtOneInfo")
    public JsonResult getEtOneInfo() throws Exception {
        String param = getParam(request);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        FollowEtSf1 followEtSf1 = etService.getEtOneInfo(id);
        return jsonResult(followEtSf1);
    }

    //查询一岁以内儿童列表
    @RequestMapping("getEtOneList")
    public JsonResult getEtOneList() throws Exception {
        String param = getParam(request);
        RequestDto request = JSONObject.parseObject(param, RequestDto.class);
        return etService.getEtOneList(request);
    }

    // 保存1-3岁以内儿童随访
    @RequestMapping("etThreeYearSfSave")
    public JsonResult etThreeYearSfSave() {
        String param = "";
        try {
            param = request.getParameter("param");
            List<FollowEtSf3> list = JSONObject.parseArray(param, FollowEtSf3.class);
            if (list != null && list.size() > 0) {
                Map<String, Object> map = etService.saveEtThreeYearInfo(list);
                if (map != null && map.size() > 0) {
                    logger.error("1-3岁以内儿童随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
                    return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
                }
            }
            return jsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("1-3岁以内儿童随访信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
            return jsonResult(param, 10001, "系统错误" + e.getMessage());
        }
    }

    //查询1-3岁儿童详情
    @RequestMapping("getEtThreeInfo")
    public JsonResult getEtThreeInfo() throws Exception {
        String param = getParam(request);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        FollowEtSf3 follow = etService.getEtThreeInfo(id);
        return jsonResult(follow);
    }

    //查询1-3岁儿童列表
    @RequestMapping("getEtThreeList")
    public JsonResult getEtThreeList() throws Exception {
        String param = getParam(request);
        RequestDto request = JSONObject.parseObject(param, RequestDto.class);
        return etService.getEtThreeList(request);
    }

    // 保存3-6岁以内儿童随访
    @RequestMapping("etSixYearSfSave")
    public JsonResult etSixYearSfSave() {
        String param = "";
        try {
            param = request.getParameter("param");
            List<FollowEtSf6> list = JSONObject.parseArray(param, FollowEtSf6.class);
            if (list != null && list.size() > 0) {
                Map<String, Object> map = etService.saveEtSixYearInfo(list);
                if (map != null && map.size() > 0) {
                    logger.error("3-6岁以内儿童随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
                    return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
                }
            }
            return jsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("3-6岁以内儿童随访保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
            return jsonResult(param, 10001, "系统错误" + e.getMessage());
        }
    }

    //查询3-6岁儿童详情
    @RequestMapping("getEtSixInfo")
    public JsonResult getEtSixInfo() throws Exception {
        String param = getParam(request);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        FollowEtSf6 follow = etService.getEtSixInfo(id);
        return jsonResult(follow);
    }

    //查询3-6岁儿童列表
    @RequestMapping("getEtSixList")
    public JsonResult getEtSixList() throws Exception {
        String param = getParam(request);
        RequestDto request = JSONObject.parseObject(param, RequestDto.class);
        return etService.getEtSixList(request);
    }

    // 保存1岁儿童中医随访
    @RequestMapping("etOneYearZySave")
    public JsonResult etOneYearZySave() {
        String param = "";
        try {
            param = request.getParameter("param");
            List<FollowEtZyygl1> list = JSONObject.parseArray(param, FollowEtZyygl1.class);
            if (list != null && list.size() > 0) {
                Map<String, Object> map = etService.saveEtOneYearZyInfo(list);
                if (map != null && map.size() > 0) {
                    logger.error("1岁以内儿童中医随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
                    return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
                }
            }
            return jsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("1岁以内儿童中医随访信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
            return jsonResult(param, 10001, "系统错误" + e.getMessage());
        }
    }

    //查询1岁儿童中医详情
    @RequestMapping("getEtOneZy")
    public JsonResult getEtOneZy() throws Exception {
        String param = getParam(request);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        FollowEtZyygl1 follow = etService.getEtOneZy(id);
        return jsonResult(follow);
    }

    //查询1岁儿童中医列表
    @RequestMapping("getEtOneZyList")
    public JsonResult getEtOneZyList() throws Exception {
        String param = getParam(request);
        RequestDto request = JSONObject.parseObject(param, RequestDto.class);
        return etService.getEtOneZyList(request);
    }

    // 保存1-3岁儿童中医随访
    @RequestMapping("etThreeYearZySave")
    public JsonResult etThreeYearZySave() {
        String param = "";
        try {
            param = request.getParameter("param");
            List<FollowEtZyygl3> list = JSONObject.parseArray(param, FollowEtZyygl3.class);
            if (list != null && list.size() > 0) {
                Map<String, Object> map = etService.saveEtThreeYearZyInfo(list);
                if (map != null && map.size() > 0) {
                    logger.error("1-3岁以内儿童中医随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
                    return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
                }
            }
            return jsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("1-3岁以内儿童中医随访信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
            return jsonResult(param, 10001, "系统错误" + e.getMessage());
        }
    }

    //查询1-3岁儿童中医详情
    @RequestMapping("getEtThreeZy")
    public JsonResult getEtThreeZy() throws Exception {
        String param = getParam(request);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        FollowEtZyygl3 follow = etService.getEtThreeZy(id);
        return jsonResult(follow);
    }

    //查询1-3岁儿童中医列表
    @RequestMapping("getEtThreeZyList")
    public JsonResult getEtThreeZyList() throws Exception {
        String param = getParam(request);
        RequestDto request = JSONObject.parseObject(param, RequestDto.class);
        return etService.getEtThreeZyList(request);
    }

    // 保存3-6岁儿童中医随访
    @RequestMapping("etSixYearZySave")
    public JsonResult etSixYearZySave() {
        String param = "";
        try {
            param = request.getParameter("param");
            List<FollowEtZyygl6> list = JSONObject.parseArray(param, FollowEtZyygl6.class);
            if (list != null && list.size() > 0) {
                Map<String, Object> map = etService.saveEtSixYearZyInfo(list);
                if (map != null && map.size() > 0) {
                    logger.error("3-6岁以内儿童中医随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
                    return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
                }
            }
            return jsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("3-6岁以内儿童中医随访信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
            return jsonResult(param, 10001, "系统错误" + e.getMessage());
        }
    }

    //查询3-6岁儿童中医详情
    @RequestMapping("getEtSixZy")
    public JsonResult getEtSixZy() throws Exception {
        String param = getParam(request);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        FollowEtZyygl6 follow = etService.getEtSixZy(id);
        return jsonResult(follow);
    }

    //查询3-6岁儿童中医列表
    @RequestMapping("getEtSixZyList")
    public JsonResult getEtSixZyList() throws Exception {
        String param = getParam(request);
        RequestDto request = JSONObject.parseObject(param, RequestDto.class);
        return etService.getEtSixZyList(request);
    }
}
