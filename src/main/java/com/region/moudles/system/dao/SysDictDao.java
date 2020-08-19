package com.region.moudles.system.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dao.repository.SysDictRepository;
import com.region.moudles.system.dao.repository.SysDictSubRepository;
import com.region.moudles.system.domain.SysDict;
import com.region.moudles.system.domain.SysDictSub;
import com.region.moudles.system.dto.InitDictDto;
import com.region.moudles.system.dto.SysDictTreeDto;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;


@Named
public class SysDictDao extends BaseDao<SysDictRepository, SysDict> {

	@Inject
	private SysDictSubRepository dictSubRepository;
	
	public void querySubList(SysDictSub dictSubParam, PageModel page) {

		StringBuffer sql = new StringBuffer();
		sql.append(" select ds.id,ds.text,ds.value,ds.status,ds.order_num orderNum,ds.remarks from sys_dict_sub ds where 1=1 ");
		sql.append(" and ds.dict_id=:dictId and ds.status!=3 ");
		if (!StringUntil.isNull(dictSubParam.getText())) {
			sql.append(" and ds.text  like CONCAT('%',CONCAT(:text,'%')) ");
		}
		if (!StringUntil.isNull(dictSubParam.getValue())) {
			sql.append(" and ds.value  like CONCAT('%',CONCAT(:value,'%')) ");
		}
		sql.append(" order by ds.order_num ");
		queryPage(sql.toString(), dictSubParam, page, SysDictSub.class);
	}

	public void saveSub(SysDictSub dictSub) {
		if (StringUntil.isNull(dictSub.getId())) {
			dictSub.setId(UUIDUtil.getUUID());
		}
		dictSubRepository.save(dictSub);
	}

	public List<SysDictTreeDto> findListTree() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select d.id, d.name, d.code, d.remarks, d.status,d.parent_id parentId from sys_dict d where 1=1 and d.status!=3 ");
		sql.append(" order by d.code ");
		return queryList(sql.toString(), null, SysDictTreeDto.class);
	}

	public SysDictSub getSub(String id) {
		return dictSubRepository.findOne(id);
	}

	public void batchSubUpdateForDel(String id) {
		dictSubRepository.batchUpdateForDel(id);
	}

	public void updateForDel(String id) {
		repository.updateForDel(id);
	}

	public String getCodeById(String dictId) {
		return repository.findCodeById(dictId);
	}
	
	public List<SysDictSub> querySubListByDictId(String dictId) {

		StringBuffer sql = new StringBuffer();
		sql.append(" select ds.id,ds.text,ds.value,ds.status,ds.order_num orderNum,ds.remarks from sys_dict_sub ds where 1=1 ");
		sql.append(" and ds.dict_id=:dictId and ds.status!=3 ");
		sql.append(" order by ds.order_num ");
		Map<String, Object> map = new HashMap<>();
		map.put("dictId", dictId);
		return queryList(sql.toString(), map, SysDictSub.class);
	}
	
	public SysDict getDictByNameCode(SysDict dict) {

		StringBuffer sql = new StringBuffer();
		sql.append(" select * from sys_dict where 1=1 ");
		sql.append(" and (name = :name or code = :code ) and status != 3 ");
		return queryOne(sql.toString(), dict, SysDict.class);
	}
	
	public SysDictSub getDictSubByNameCode(SysDictSub dictSub) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.* from sys_dict_sub a  ");
		sql.append(" join sys_dict b on a.dict_id = b.id and b.status != 3   ");
		sql.append(" where 1=1 and b.id = :dictId ");
		sql.append(" and (a.text = :text or a.value = :value ) and a.status != 3 ");
		return queryOne(sql.toString(), dictSub, SysDictSub.class);
	}
	
	public List<InitDictDto> queryDictList(){
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.value as code, a.text as name, b.code as parentCode from sys_dict_sub a  ");
		sql.append(" join sys_dict b on a.dict_id = b.id ");
		sql.append(" where a.status != 3 and b.status != 3 ");
		return queryList(sql.toString(), null, InitDictDto.class);
	}
}
