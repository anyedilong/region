package com.region.moudles.healthbrowser.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.healthbrowser.dao.HCPlatformDao;
import com.region.moudles.healthbrowser.dto.JcInfoDto;
import com.region.moudles.healthbrowser.dto.JyInfoDto;
import com.region.moudles.healthbrowser.dto.ReportInfoDto;
import com.region.moudles.healthbrowser.service.HCSysService;
import com.region.until.StringUntil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;


@Named
public class HCSysServiceImpl implements HCSysService {
	@Value("${extranetHost}")
	private String extranetHost;
	@Inject
	private HCPlatformDao hcPlatforDao;
	
	@Override
	public void getJyList(String sfzh, PageModel page) throws Exception {
		hcPlatforDao.getJyList(sfzh, page);
	}

	@Override
	public List<JyInfoDto> getJyDetail(String id, String type, String itemType) throws Exception {
		//ReportInfoDto info = hcPlatforDao.getPatientInfo(id, type);
		//if(info != null) {
			List<JyInfoDto> jyList = hcPlatforDao.queryJyList(id, type, itemType);
			if(jyList != null && jyList.size() > 0) {
				for(JyInfoDto info : jyList) {
					String itemValue = info.getItemValue();
					if(!itemValue.matches("-?[0-9]+\\.?[0-9]*") || "0".equals(info.getMaxValue())
							|| "0".equals(info.getMinValue()) || StringUntil.isNull(info.getMaxValue())
							|| StringUntil.isNull(info.getMinValue())) {
						info.setStatus("无法判断");
					}else {
						float value = Float.parseFloat(itemValue);
						float max = Float.parseFloat(info.getMaxValue());
						float min = Float.parseFloat(info.getMinValue());
						if(value < min) {
							info.setStatus("偏低");
						}else if(value > max) {
							info.setStatus("偏高");
						}else {
							info.setStatus("正常");
						}
					}
					info.setValue(info.getItemValue()+info.getItemUnit());
				}
				return jyList;
			}else {
				return new ArrayList<>();
			}
		//}
	}

	@Override
	public void getJcList(String sfzh, PageModel page) throws Exception {
		hcPlatforDao.getJcList(sfzh, page);
	}

	@Override
	public ReportInfoDto getJcDetail(String id, String type, String imageType) throws Exception {
		ReportInfoDto info = hcPlatforDao.getPatientInfo(id, type);
		if(info != null) {
			List<JcInfoDto> jcList = hcPlatforDao.queryJcList(id, type, imageType);
			if(jcList != null && jcList.size() > 0) {
				for (JcInfoDto jc : jcList) {
					if (StringUtils.isNotBlank(jc.getImageJpgUrl())) {
						jc.setImageJpgUrl(extranetHost + jc.getImageJpgUrl());
					}
				}
				info.setJcList(jcList);
			}else {
				info.setJcList(new ArrayList<>());
			}
		}
		return info;
	}

}
