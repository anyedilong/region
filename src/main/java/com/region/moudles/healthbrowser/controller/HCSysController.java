package com.region.moudles.healthbrowser.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.healthbrowser.dto.JyInfoDto;
import com.region.moudles.healthbrowser.dto.ReportInfoDto;
import com.region.moudles.healthbrowser.service.HCSysService;
import com.region.until.StringUntil;

@RestController
@RequestMapping("/his/hcplatform")
public class HCSysController extends BaseController {

	@Inject
	private HCSysService hcSysService;
	
	/**
	 * @Description: 获取检验的列表(惠民平台)
	 * @param @return
	 * @return List<JyInfoDto>
	 * @throws
	 */
	@RequestMapping("getJyList")
	public PageModel getJyList() {
		try {
			String sfzh = request.getParameter("sfzh");
			String pageNo = request.getParameter("pageNo");
			String pageSize = request.getParameter("pageSize");
			PageModel page = new PageModel(StringUntil.isNull(pageNo) ? 0 : Integer.parseInt(pageNo), 
					StringUntil.isNull(pageSize) ? 0 : Integer.parseInt(pageSize));
			hcSysService.getJyList(sfzh, page);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Description: 获取检验的详情（惠民平台）
	 * @param @return
	 * @return ReportInfoDto
	 * @throws
	 */
	@RequestMapping("getJyDetail")
	public List<JyInfoDto> getJyDetail() {
		try {
			String itemType = request.getParameter("itemType");
			String id = request.getParameter("id");
			String type = request.getParameter("type");
			return hcSysService.getJyDetail(id, type, itemType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Description: 获取检查的列表(惠民平台)
	 * @param @return
	 * @return List<JcInfoDto>
	 * @throws
	 */
	@RequestMapping("getJcList")
	public PageModel getJcList() {
		try {
			String sfzh = request.getParameter("sfzh");
			String pageNo = request.getParameter("pageNo");
			String pageSize = request.getParameter("pageSize");
			PageModel page = new PageModel(StringUntil.isNull(pageNo) ? 0 : Integer.parseInt(pageNo),
					StringUntil.isNull(pageSize) ? 0 : Integer.parseInt(pageSize));
			hcSysService.getJcList(sfzh, page);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Description: 获取检查的详情（惠民平台）
	 * @param @return
	 * @return ReportInfoDto
	 * @throws
	 */
	@RequestMapping("getJcDetail")
	public ReportInfoDto getJcDetail() {
		try {
			String id = request.getParameter("id");
			String type = request.getParameter("type");
			String imageType = request.getParameter("imageType");
			return hcSysService.getJcDetail(id, type, imageType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
