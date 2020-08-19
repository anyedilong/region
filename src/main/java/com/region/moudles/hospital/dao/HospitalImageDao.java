package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalImageRepository;
import com.region.moudles.hospital.domain.HospitalImage;

@Named
public class HospitalImageDao extends BaseDao<HospitalImageRepository, HospitalImage> {
	
	/**
     * @Description: 查询住院影像的详情(健康浏览器)
     * @param @param arId
     * @return void
     * @throws
     */
    public List<HospitalImage> getHospitalImageList(String zyId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.hospital_id, a.image_remake, a.image_jl, ")
			.append(" a.image_type, a.image_time  ")
			.append(" from hospital_image a  ")
			.append(" where a.hospital_id = :zyId ")
			.append(" group by a.hospital_id, a.image_remake, a.image_jl, a.image_type, a.image_time ");
		Map<String, Object> map = new HashMap<>();
		map.put("zyId", zyId);
        return queryList(sql.toString(), map, HospitalImage.class);
    }
    
    /**
     * @Description: 查询住院影像的详情(健康浏览器)
     * @param @param arId
     * @return void
     * @throws
     */
    public List<HospitalImage> getHospitalImageInfoList(HospitalImage info){
        StringBuffer sql = new StringBuffer();
        sql.append(" select a.id, a.image_url, a.image_jpg_url ");
    	sql.append(" from hospital_image a ");
    	sql.append(" where a.hospital_id = :hospitalId");
    	sql.append(" and a.image_time = :imageTime and a.image_type = :imageType ");
        return queryList(sql.toString(), info, HospitalImage.class);
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
