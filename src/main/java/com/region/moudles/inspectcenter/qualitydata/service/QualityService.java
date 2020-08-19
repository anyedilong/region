package com.region.moudles.inspectcenter.qualitydata.service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.inspectcenter.qualitydata.domain.QualityData;
import com.region.moudles.outpatient.dto.JcDto;

import java.util.List;

public interface QualityService {

    void getQualityPage(JcDto req);

    List<QualityData> getResultList(JcDto req);

}
