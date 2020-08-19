package com.region.moudles.system.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.domain.SysDict;
import com.region.moudles.system.domain.SysDictSub;
import com.region.moudles.system.dto.SysDictTreeDto;
import com.region.moudles.system.service.SysDictService;
import com.region.until.StringUntil;


@RestController
@RequestMapping("${familypath}/dict")
public class SysDictController extends BaseController {

    @Inject
    private SysDictService sysDicService;

    
    /**
	 * @Description 获取字典树
	 * @return
	 * @author sen
	 * @Date 2017年3月17日 上午9:13:13
	 */
	@RequestMapping("getDictTree")
	public JsonResult getDictTree() {
		List<SysDictTreeDto> list = sysDicService.findListTree();

		return jsonResult(list);
	}
	
	/**
	 * @Description 字典子表列表数据
	 * @return
	 * @author sen
	 * @Date 2017年3月2日 上午10:14:59
	 */
	@RequestMapping("getSubList")
	public JsonResult getSubList() {
		String param = getParam(request);
		SysDictSub dictSubParam = JSON.parseObject(param, SysDictSub.class);
		if (dictSubParam == null) {
			dictSubParam = new SysDictSub();
		}
		JSONObject obj = JSON.parseObject(param).getJSONObject("page");
		PageModel page = new PageModel(obj.getInteger("pageNum"), obj.getInteger("pageSize"));
		sysDicService.getSubList(dictSubParam, page);
		return jsonResult(page);
	}
	/**
	 * @Description 保存数据
	 * @return
	 * @author sen
	 * @Date 2017年3月2日 上午10:34:23
	 */
	@RequestMapping("save")
	public JsonResult save() {
		String param = getParam(request);
		SysDict dict = JSON.parseObject(param, SysDict.class);
		if (dict != null) {
			Date nowDate = new Date();
			dict.setCreateTime(nowDate);
			dict.setUpdateTime(nowDate);
			//查询字典名称和字典code是否被占用
			SysDict tempDict = sysDicService.getDictByNameCode(dict);
			if(tempDict != null && StringUntil.isNull(dict.getId())) {
				return jsonResult(null, 10001, "字典名称或者字典编码已被占用");
			}else {
				sysDicService.save(dict);
				return jsonResult(dict.getId());
			}
		} else {
			return jsonResult(null, 10001, "参数错误");
		}
	}

	@RequestMapping("saveSub")
	public JsonResult saveSub() {
		String param = getParam(request);
		SysDictSub dictSub = JSON.parseObject(param, SysDictSub.class);
		if (dictSub != null) {
			//查询字典名称和字典code是否被占用
			SysDictSub tempDictSub = sysDicService.getDictSubByNameCode(dictSub);
			if(tempDictSub != null && StringUntil.isNull(dictSub.getId())) {
				return jsonResult(null, 10001, "字典名称或者字典编码已被占用");
			}else {
				sysDicService.saveSub(dictSub);
				return jsonResult();
			}
			

		} else {
			return jsonResult(null, 10001, "参数错误");
		}
	}

	/**
	 * @Description 查看字典信息
	 * @return
	 * @author sen
	 * @Date 2017年3月17日 上午9:46:11
	 */
	@RequestMapping("show")
	public JsonResult show() {
		String param = getParam(request);
		JSONObject paramObj = JSON.parseObject(param);
		if (paramObj != null) {
			String id = paramObj.getString("id");//
			if (StringUntil.isNull(id)) {
				return jsonResult(null, 10002, "字典ID必填");
			}
			SysDict dict = sysDicService.get(id);
			return jsonResult(dict);
		} else {
			return jsonResult(null, 10001, "参数错误");
		}

	}

	/**
	 * @Description 查看字典子项信息
	 * @return
	 * @author sen
	 * @Date 2017年3月17日 上午9:46:20
	 */
	@RequestMapping("showSub")
	public JsonResult showSub() {
		String param = getParam(request);
		JSONObject paramObj = JSON.parseObject(param);
		if (paramObj != null) {
			String id = paramObj.getString("id");
			if (StringUntil.isNull(id)) {
				return jsonResult(null, 10002, "字典明细ID必填");
			}
			SysDictSub dictSub = sysDicService.getSub(id);
			return jsonResult(dictSub);
		} else {
			return jsonResult(null, 10001, "参数错误");
		}

	}

	/**
	 * @Description 删除字典明细
	 * @return
	 * @author sen
	 * @Date 2017年3月17日 上午9:46:20
	 */
	@RequestMapping("delete")
	public JsonResult delete() {
		String param = getParam(request);
		JSONObject paramObj = JSON.parseObject(param);
		if (paramObj != null) {
			String id = paramObj.getString("id");
			if (StringUntil.isNull(id)) {
				return jsonResult(null, 10002, "字典ID必填");
			}
			sysDicService.updateForDel(id);
		} else {
			return jsonResult(null, 10001, "参数错误");
		}
		return jsonResult();

	}

	/**
	 * @Description 删除子表字典明细
	 * @return
	 * @author sen
	 * @Date 2017年3月17日 上午9:46:20
	 */
	@RequestMapping("deleteSub")
	public JsonResult deleteSub() {
		String param = getParam(request);
		JSONObject paramObj = JSON.parseObject(param);
		if (paramObj != null) {
			String id = paramObj.getString("id");
			sysDicService.batchSubUpdateForDel(id);
		} else {
			return jsonResult(null, 10001, "参数错误");
		}
		return jsonResult();

	}
	
	/**
	 * @Description 根据字典大类获取小类
	 * @return
	 * @author sen
	 */
	@RequestMapping("querySubListByDictId")
	public JsonResult querySubListByDictId() {
		String param = getParam(request);
		JSONObject paramObj = JSON.parseObject(param);
		if (paramObj != null) {
			String dictId = paramObj.getString("dictId");
			return jsonResult(sysDicService.querySubListByDictId(dictId));
		} else {
			return jsonResult(null, 10001, "参数错误");
		}
	}
	
}
