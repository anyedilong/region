package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.check.dao.repository.CheckRepository;
import com.region.moudles.tripartdock.check.domain.Check;
import com.region.moudles.tripartdock.check.dto.HcCheckDto;
import com.region.until.StringUntil;


@Named
public class CheckDao extends BaseDao<CheckRepository, Check> {
   

	
	/**
	 * @Description: 查询体检的前两条数据
	 * @param @param sfzh
	 * @param @param jcrq
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public void getCheckListBySFZH(String sfzh, String jcrq,PageModel page){
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select k.id, k.tjbh, k.jcrq, k.ys, k.zz, k.qt ");
        sql.append(" from blt_khjbxxb k ");
        sql.append(" where (k.SFSC = 'N' or k.SFSC is null) ");
        sql.append(" and k.sfzh = :sfzh ");
        
        if(!StringUntil.isNull(jcrq)) {
        	sql.append(" and k.jcrq <= to_date(:jcrq, 'yyyy-MM-dd') ");
        	paramMap.put("jcrq", jcrq);
        }
        sql.append(" order by k.jcrq desc ");
        paramMap.put("sfzh", sfzh);
        queryPage(sql.toString(), paramMap, page, Check.class);
   }
	
	/**
	 * @Description: 根据体检id查询要比对的数据
	 * @param @param id
	 * @param @return
	 * @return HcCheckDto
	 * @throws
	 */
	public HcCheckDto queryCompareDetails(String id) {
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select distinct khjb.id, jb.hzmc, to_char(khjb.jcrq, 'yyyy-mm-dd') jcrq, ");
        sql.append(" o.org_name tjdw, khjb.ys, khjb.sfzh, khjb.tjbh, yb.bmi, (yb.zcxy || '/' ||yb.zgd) zcxy,  ");
        sql.append(" (yb.ycxy || '/' ||yb.ygd) ycxy,  ");
        sql.append(" c.xl, d.kfxtz as xtz, f.jkzd, f.wxkz, f.gb, f.zdjy, f.qt, ");
        sql.append(" case when f.sfzc = '1' then '无异常' else '异常' end as jkpj ");
        sql.append(" from blt_khjbxxb khjb ");
        sql.append(" join blt_jbxxjlb jb on khjb.jmid = jb.id ");
        sql.append(" left join sys_org o on o.id = khjb.tjdw ");
        sql.append(" left join blt_ybzzb yb on yb.tjbh = khjb.tjbh and yb.tjid = khjb.id ");
        sql.append(" left join blt_xzjcjlb b on b.tjbh = khjb.tjbh and b.tjid = khjb.id ");
        sql.append(" left join blt_jkjc c on c.tjbh = khjb.tjbh and c.tjid = khjb.id ");
        sql.append(" left join blt_xzjcjlb d on d.tjbh = khjb.tjbh and d.tjid = khjb.id ");
        sql.append(" left join blt_pgzdjlb f on f.tjbh = khjb.tjbh and f.tjid = khjb.id ");
        sql.append(" where khjb.id = :id ");
        paramMap.put("id", id);
        return queryOne(sql.toString(), paramMap, HcCheckDto.class);
	}
	
	/**
	 * @Description: 体检列表(健康浏览器)
	 * @param @param jmId
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public void getCheckPage(String jmId, PageModel page){
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.id, a.khbh, a.jcrq, d.hzmc as name, a.sfzh, a.ys, a.tjdw ,a.tjbh");
        sql.append(" from blt_khjbxxb a ");
        sql.append(" join blt_jbxxjlb d on a.jmid = d.id ");
        sql.append(" where (a.sfsc is null or a.sfsc = 'N') ");
        sql.append(" and a.jmid = :jmId ");
        sql.append(" order by a.jcrq desc ");
        paramMap.put("jmId", jmId);
        queryPage(sql.toString(), paramMap, page, Check.class);
   }
	
	/**
	 * @Description: 查询体检详情
	 * @param @param archiveId
	 * @return void
	 * @throws
	 */
	public Check queryCheckDetail(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select d.hzmc as name, a.* ");
        sql.append(" from blt_khjbxxb a ");
        sql.append(" join blt_jbxxjlb d on a.jmid = d.id ");
        sql.append(" where (a.sfsc is null or a.sfsc = 'N') ");
        sql.append(" and a.id = :tjId ");
        paramMap.put("tjId", tjId);
        return queryOne(sql.toString(), paramMap, Check.class);
   }
	
	public String getTjdwByCon(String sfzh, String tjbh) {
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select r.tjdw ");
        sql.append(" from blt_khjbxxb r ");
        sql.append(" where r.tjbh = :tjbh and r.sfzh = :sfzh ");
        paramMap.put("sfzh", sfzh);
        paramMap.put("tjbh", tjbh);
        return queryOne(sql.toString(), paramMap, String.class);
	}
   
}
