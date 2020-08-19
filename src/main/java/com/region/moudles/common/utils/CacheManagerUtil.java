package com.region.moudles.common.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.region.config.spring.InstanceFactory;
import com.region.moudles.common.utils.cache.DictCache;
import com.region.moudles.common.utils.properties.PropertiesUtil;
import com.region.moudles.system.domain.SysDictSub;
import com.region.moudles.system.service.InitService;
import com.region.until.StringUntil;
import com.region.until.cache.CacheEmun;
import com.region.until.cache.CacheUtils;


public class CacheManagerUtil {

	/**
	 * @Description 根据 字典值和字典code 获取字典明细
	 * @param propDict
	 *            配置文件字典code
	 * @return
	 * @author sen
	 * @Date 2017年3月17日 下午5:05:55
	 */
	public static List<DictCache> getDictListByCode(String propDict) {
		
		if(StringUntil.isNull(propDict)){
			return null;
		}

		String dictCode = PropertiesUtil.getDict(propDict);

		List<DictCache> dictAllList = InstanceFactory.getbean(InitService.class).initDictCache();

		if (null == dictAllList) {
			return null;
		}

		// 字典 过滤 排序

		List<DictCache> dictList = dictAllList.stream().filter(dict -> dictCode.equals(dict.getCode()))
				.sorted(Comparator.comparing(DictCache::getOrderNum)).collect(Collectors.toList());

		return dictList;

	}

	/**
	 * @Description 根据字典ID 获取字典明细列表
	 * @param id
	 * @return
	 * @author sen
	 * @Date 2017年3月17日 下午5:17:06
	 */
	public static DictCache getDictById(String id) {

		if(StringUntil.isNull(id)){
			return null;
		}
		
		List<DictCache> dictAllList = InstanceFactory.getbean(InitService.class).initDictCache();

		if (null == dictAllList) {
			return null;
		}

		// 字典 过滤 排序
		DictCache dictQuery = new DictCache(id);
		int index = dictAllList.indexOf(dictQuery);
		if (index >= 0) {
			return dictAllList.get(index);
		}

		return null;
	}

	/**
	 * 
	 * @Description
	 * @param id
	 * @return
	 * @author sen
	 * @Date 2017年3月17日 下午5:55:08
	 */
	public static void saveDict(SysDictSub dictSub) {
		
		if(null == dictSub){
			return ;
		}

		List<DictCache> dictAllList = InstanceFactory.getbean(InitService.class).initDictCache();

		if (null == dictAllList) {
			dictAllList = new ArrayList<>();
		}

		String id = dictSub.getId();

		// 字典 过滤 排序
		DictCache dict = null;
		// 字典 过滤 排序
		DictCache dictQuery = new DictCache(id);
		int index = dictAllList.indexOf(dictQuery);
		if (index >= 0) {
			dict = dictAllList.get(index);
		}

		if (null == dict) {
			dict = new DictCache();
			dict.setId(dictSub.getId());
			dict.setCode(dictSub.getCode());
			dict.setDictId(dictSub.getDictId());
			dict.setText(dictSub.getText());
			dict.setValue(dictSub.getValue());
			dict.setOrderNum(dictSub.getOrderNum());
			dict.setStatus(dictSub.getStatus());
			dictAllList.add(dict);
		} else {
			dict.setText(dictSub.getText());
			dict.setValue(dictSub.getValue());
			dict.setOrderNum(dictSub.getOrderNum());
			dict.setStatus(dictSub.getStatus());
		}

		CacheUtils.put(CacheEmun.SYS_CACHE, CacheUtils.SYS_DICT, dictAllList);

	}

	/**
	 * @Description 根据value 获取文本 多个value
	 * @param propDict
	 * @param values
	 * @return
	 * @author sen
	 * @Date 2017年3月17日 下午5:24:33
	 */
	public static String getTextByValues(String propDict, String values) {
		
		if(StringUntil.isNull(propDict) || StringUntil.isNull(values)){
			return "";
		}
		
		String dictCode = PropertiesUtil.getDict(propDict);
		// Stream<String> valueStream = Stream.of(values.split(","));
		String[] valueArray = values.split(",");

		List<DictCache> dictAllList = InstanceFactory.getbean(InitService.class).initDictCache();

		if (null == dictAllList) {
			return null;
		}

		// 字典 过滤 排序
		String rs = "";
		List<DictCache> dictList = dictAllList.stream().filter(dict -> dictCode.equals(dict.getCode()))
				.collect(Collectors.toList());

		if (null != dictList && dictList.size() > 0) {
			for (String value : valueArray) {
				// 字典 过滤 排序
				DictCache dict = null;
				// 字典 过滤 排序
				DictCache dictQuery = new DictCache();
				dictQuery.setCode(dictCode);
				dictQuery.setValue(value);

				int index = dictAllList.indexOf(dictQuery);
				if (index >= 0) {
					dict = dictAllList.get(index);
					if (null != dict && !StringUntil.isNull(dict.getText())) {
						rs += dict.getText() + ",";
					}
				}
			}
		}

		if (rs.length() > 0) {
			rs = rs.substring(0, rs.length() - 1);
		}

		// List<String> textList = dictAllList.stream()
		// .filter(dict -> dictCode.equals(dict.getCode())
		// && (valueStream.filter(value ->
		// value.equals(dict.getValue())).count() > 0))
		// .sorted(Comparator.comparing(DictCache::getOrderNum)).map(DictCache::getText)
		// .collect(Collectors.toList());

		return rs;
	}

	/**
	 * @Description 根据value 获取文本
	 * @param propDict
	 * @param value
	 * @return
	 * @author sen
	 * @Date 2017年3月17日 下午5:24:33
	 */
	public static String getTextByValue(String propDict, String value) {
		
		if(StringUntil.isNull(propDict) || StringUntil.isNull(value)){
			return "";
		}

		String dictCode = PropertiesUtil.getDict(propDict);

		List<DictCache> dictAllList = InstanceFactory.getbean(InitService.class).initDictCache();

		if (null == dictAllList) {
			return null;
		}

		// 字典 过滤 排序
		DictCache dictQuery = new DictCache();
		dictQuery.setCode(dictCode);
		dictQuery.setValue(value);

		int index = dictAllList.indexOf(dictQuery);
		if (index >= 0) {
			return dictAllList.get(index).getText();
		}

		return "";
	}


}
