package com.region.moudles.tripartdock.sign.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.sign.dao.repository.SignItemAnnexRepository;
import com.region.moudles.tripartdock.sign.domain.SignItemAnnex;


@Named
public class SignItemAnnexDao extends BaseDao<SignItemAnnexRepository, SignItemAnnex> {
	
	/**
	 * @Description: 根据签约id查询签约的图片
	 * @param @param signId
	 * @return void
	 * @throws
	 */
	public List<String> queryImgList(String signId){
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select c.file_path ");
        sql.append(" from blt_sign_item a ");
        sql.append(" join blt_sign_item_annex b on a.id = b.sign_item_id ");
        sql.append(" join blt_file_upload c on b.annex_md5 = c.id ");
        sql.append(" where a.sign_id = :signId ");
        paramMap.put("signId", signId);
        List<String> list = queryList(sql.toString(), paramMap, String.class);
        if(list == null) {
        	list = new ArrayList<>();
        }
        return list;
   }

}
