package com.region.moudles.system.service;

import java.util.List;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.BaseService;
import com.region.moudles.system.domain.SysDict;
import com.region.moudles.system.domain.SysDictSub;
import com.region.moudles.system.dto.SysDictTreeDto;

public interface SysDictService extends BaseService<SysDict>{

	//获取字典树
	List<SysDictTreeDto> findListTree();
	//字典子表列表数据
	void getSubList(SysDictSub dictSubParam, PageModel page);
	
	//保存子表字典数据
	void saveSub(SysDictSub dictSub);
	//获取子表字典数据
	SysDictSub getSub(String id);
	//删除字典明细
	void updateForDel(String id);
	//删除子表字典明细
	void batchSubUpdateForDel(String id);
	
	//根据字典大类获取小类
	List<SysDictSub> querySubListByDictId(String dictId);
	
	//根据字典名称和编码查询(大类)
	SysDict getDictByNameCode(SysDict dict);
	
	//根据字典名称和编码查询（小类）
	SysDictSub getDictSubByNameCode(SysDictSub dictSub);
}
