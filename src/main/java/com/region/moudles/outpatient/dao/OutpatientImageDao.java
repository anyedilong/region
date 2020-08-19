package com.region.moudles.outpatient.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.outpatient.dao.repository.OutpatientBchaoRepository;
import com.region.moudles.outpatient.domain.OutpatientImage;


@Named
public class OutpatientImageDao extends BaseDao<OutpatientBchaoRepository, OutpatientImage> {

	
	/**
     * @Description: 根据门诊id查询病历影像大类列表（健康浏览器）
     * @param @param mzId
     * @return void
     * @throws
     */
    public List<OutpatientImage> getOutpatientImageList(String mzId) {
    	StringBuffer sql = new StringBuffer();
    	sql.append(" select a.medical_record_id, a.image_remake, a.image_jl, ");
    	sql.append(" a.image_type, a.image_time ");
    	sql.append(" from outpatient_image a ");
    	sql.append(" where a.medical_record_id = :mzId");
    	sql.append(" group by a.medical_record_id, a.image_remake, a.image_jl, a.image_type, a.image_time ");
		Map<String, Object> map = new HashMap<>();
		map.put("mzId", mzId);
        return queryList(sql.toString(), map, OutpatientImage.class);
    }
    
    /**
     * @Description: 根据条件查询病历影像信息列表（健康浏览器）
     * @param @param mzId
     * @return void
     * @throws
     */
    public List<OutpatientImage> getOutpatientImageInfoList(OutpatientImage info) {
    	StringBuffer sql = new StringBuffer();
    	sql.append(" select a.id, a.image_url, a.image_jpg_url ");
    	sql.append(" from outpatient_image a ");
    	sql.append(" where a.medical_record_id = :medicalRecordId");
    	sql.append(" and a.image_time = :imageTime and a.image_type = :imageType ");
        return queryList(sql.toString(), info, OutpatientImage.class);
    }
    
    /**
     * 更新影像的jpg路径
     * @param imageId
     * @param imageJpgPath
     */
    public void updateImageJpgPath(String imageId, String imageJpgPath) {
    	repository.updateImageJpgPath(imageId, imageJpgPath);
    }
	
}
