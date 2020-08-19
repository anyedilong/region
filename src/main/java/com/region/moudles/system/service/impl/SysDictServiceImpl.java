package com.region.moudles.system.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.region.config.spring.InstanceFactory;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.common.utils.CacheManagerUtil;
import com.region.moudles.common.utils.cache.DictCache;
import com.region.moudles.system.dao.SysDictDao;
import com.region.moudles.system.domain.SysDict;
import com.region.moudles.system.domain.SysDictSub;
import com.region.moudles.system.dto.SysDictTreeDto;
import com.region.moudles.system.service.InitService;
import com.region.moudles.system.service.SysDictService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;
import com.region.until.cache.CacheEmun;
import com.region.until.cache.CacheUtils;

@Named
public class SysDictServiceImpl extends BaseServiceImpl<SysDictDao, SysDict> implements SysDictService {


	@Override
	public List<SysDictTreeDto> findListTree() {
		return dao.findListTree();
	}
	
	@Override
	public void getSubList(SysDictSub dictSubParam, PageModel page) {
		dao.querySubList(dictSubParam, page);
	}

	@Override
	@Transactional
	public void save(SysDict dict) {
		if (StringUntil.isNull(dict.getId())) {
			dict.setId(UUIDUtil.getUUID());
		}
		dao.save(dict);

		// 字典缓存
		List<DictCache> dictAllList = InstanceFactory.getbean(InitService.class).initDictCache();
		if (null != dictAllList) {
			List<DictCache> dictList = dictAllList.stream()
					.filter(filterDict -> dict.getId().equals(filterDict.getDictId())).collect(Collectors.toList());

			if (null != dictList) {
				for (DictCache dictCache : dictList) {
					dictCache.setCode(dict.getCode());
				}
				CacheUtils.put(CacheEmun.SYS_CACHE, CacheUtils.SYS_DICT, dictAllList);
			}
		}
	}

	@Override
	@Transactional
	public void saveSub(SysDictSub dictSub) {
		dao.saveSub(dictSub);

		String code = dao.getCodeById(dictSub.getDictId());
		dictSub.setCode(code);
		// 将数据保存到缓存
		CacheManagerUtil.saveDict(dictSub);
	}


	@Override
	public SysDictSub getSub(String id) {
		return dao.getSub(id);
	}

	@Override
	@Transactional
	public void batchSubUpdateForDel(String id) {
		dao.batchSubUpdateForDel(id);

		List<DictCache> dictAllList = InstanceFactory.getbean(InitService.class).initDictCache();
		if (null != dictAllList) {
			/*
			 * List<DictCache> dictList = dictAllList.stream() .filter(filterDict ->
			 * ids.stream().filter(id -> id.equals(filterDict.getId())).count() <= 0)
			 * .collect(Collectors.toList());
			 */
			List<DictCache> dictList = dictAllList.stream().filter(filterDict -> !id.equals(filterDict.getDictId()))
					.collect(Collectors.toList());
			
			CacheUtils.put(CacheEmun.SYS_CACHE, CacheUtils.SYS_DICT, dictList);

		}
	}

	@Override
	@Transactional
	public void updateForDel(String id) {
		dao.updateForDel(id);

		List<DictCache> dictAllList = InstanceFactory.getbean(InitService.class).initDictCache();
		if (null != dictAllList) {
			List<DictCache> dictList = dictAllList.stream().filter(filterDict -> !id.equals(filterDict.getDictId()))
					.collect(Collectors.toList());

			CacheUtils.put(CacheEmun.SYS_CACHE, CacheUtils.SYS_DICT, dictList);

		}

	}

	@Override
	public List<SysDictSub> querySubListByDictId(String dictId) {
		return dao.querySubListByDictId(dictId);
	}
	@Override
	public SysDict getDictByNameCode(SysDict dict) {
		return dao.getDictByNameCode(dict);
	}
	@Override
	public SysDictSub getDictSubByNameCode(SysDictSub dictSub) {
		return dao.getDictSubByNameCode(dictSub);
	}
}
