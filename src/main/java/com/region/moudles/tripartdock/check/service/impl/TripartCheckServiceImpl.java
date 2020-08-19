package com.region.moudles.tripartdock.check.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.archive.dao.JbxxjlbDao;
import com.region.moudles.tripartdock.archive.domain.Jbxxjlb;
import com.region.moudles.tripartdock.check.dao.CheckDao;
import com.region.moudles.tripartdock.check.dao.JkjcDao;
import com.region.moudles.tripartdock.check.dao.JkwtbDao;
import com.region.moudles.tripartdock.check.dao.JzbcsDao;
import com.region.moudles.tripartdock.check.dao.JzsDao;
import com.region.moudles.tripartdock.check.dao.PgzdjlbDao;
import com.region.moudles.tripartdock.check.dao.ShfsDao;
import com.region.moudles.tripartdock.check.dao.XzjcjlbDao;
import com.region.moudles.tripartdock.check.dao.YbzzbDao;
import com.region.moudles.tripartdock.check.dao.YjjlbDao;
import com.region.moudles.tripartdock.check.dao.ZqgnbDao;
import com.region.moudles.tripartdock.check.dao.ZysDao;
import com.region.moudles.tripartdock.check.domain.Check;
import com.region.moudles.tripartdock.check.domain.Jkjc;
import com.region.moudles.tripartdock.check.domain.Jkwtb;
import com.region.moudles.tripartdock.check.domain.Jzbcs;
import com.region.moudles.tripartdock.check.domain.Jzs;
import com.region.moudles.tripartdock.check.domain.Pgzdjlb;
import com.region.moudles.tripartdock.check.domain.Shfs;
import com.region.moudles.tripartdock.check.domain.Xzjcjlb;
import com.region.moudles.tripartdock.check.domain.Ybzzb;
import com.region.moudles.tripartdock.check.domain.Yjjlb;
import com.region.moudles.tripartdock.check.domain.Zqgnb;
import com.region.moudles.tripartdock.check.domain.Zys;
import com.region.moudles.tripartdock.check.dto.HcCheckDto;
import com.region.moudles.tripartdock.check.service.TripartCheckService;
import com.region.until.UUIDUtil;

/**
 * @ClassName: TripartCheckServiceImpl
 * @Description: 三方对接 保存体检信息
 * @author Administrator
 * @date 2019年7月29日
 */
@Named
public class TripartCheckServiceImpl implements TripartCheckService {

	@Autowired
	private CheckDao checkDao;
	@Autowired
	private JkjcDao jkjcDao;
	@Autowired
	private JkwtbDao jkwtbDao;
	@Autowired
	private JzbcsDao jzbcsDao;
	@Autowired
	private JzsDao jzsDao;
	@Autowired
	private PgzdjlbDao pgzdjlbDao;
	@Autowired
	private ShfsDao shfsDao;
	@Autowired
	private XzjcjlbDao xzjcjlbDao;
	@Autowired
	private YbzzbDao ybzzbDao;
	@Autowired
	private YjjlbDao yjjlbDao;
	@Autowired
	private ZqgnbDao zqgnbDao;
	@Autowired
	private ZysDao zysDao;
	@Autowired
	private JbxxjlbDao jbxxjlbDao;
	
	
	@Override
	public Map<String, Object> saveCheckInfo(List<Check> list) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		String checkId = "";
		try {
			for (Check info : list) {
				checkId = info.getId();
    			//健康检查
    			Jkjc jkjc = info.getJkjc();
    			if(jkjc != null) {
    				jkjc.setId(UUIDUtil.getUUID());
    				jkjcDao.save(jkjc);
    			}
    			//健康问题
    			Jkwtb jkwtb = info.getJkwtb();
    			if(jkwtb != null) {
    				jkwtb.setId(UUIDUtil.getUUID());
    				jkwtbDao.save(jkwtb);
    			}
    			//评估指导
    			Pgzdjlb pgzdjlb = info.getPgzdjlb();
    			if(pgzdjlb != null) {
    				pgzdjlb.setId(UUIDUtil.getUUID());
    				pgzdjlbDao.save(pgzdjlb);
    			}
    			//生活方式
    			Shfs shfs = info.getShfs();
    			if(shfs != null) {
    				shfs.setId(UUIDUtil.getUUID());
    				shfsDao.save(shfs);
    			}
    			//辅助检查
    			Xzjcjlb xzjcjlb = info.getXzjcjlb();
    			if(xzjcjlb != null) {
    				xzjcjlb.setId(UUIDUtil.getUUID());
    				xzjcjlbDao.save(xzjcjlb);
    			}
    			//一般症状
    			Ybzzb ybzzb = info.getYbzzb();
    			if(ybzzb != null) {
    				ybzzb.setId(UUIDUtil.getUUID());
    				ybzzbDao.save(ybzzb);
    			}
    			//脏器功能
    			Zqgnb zqgnb = info.getZqgnb();
    			if(zqgnb != null) {
    				zqgnb.setId(UUIDUtil.getUUID());
    				zqgnbDao.save(zqgnb);
    			}
    			//家族病床史
    			List<Jzbcs> jzbcss = info.getJzbcs();
    			if(jzbcss != null && jzbcss.size() > 0) {
    				jzbcsDao.save(jzbcss);
    			}
    			//接种史
    			List<Jzs> jzss = info.getJzs();
    			if(jzss != null && jzss.size() > 0) {
    				jzsDao.save(jzss);
    			}
    			//药剂记录
    			List<Yjjlb> yjjlbs = info.getYjjlb();
    			if(yjjlbs != null && yjjlbs.size() > 0) {
    				yjjlbDao.save(yjjlbs);
    			}
    			//住院史
    			List<Zys> zyss = info.getZys();
    			if(zyss != null && zyss.size() > 0) {
    				zysDao.save(zyss);
    			}
    			info.setId(UUIDUtil.getUUID());
    			checkDao.save(info);
    		}
			
		}catch(Exception e) {
			e.printStackTrace();
			map.put(checkId, e.getMessage());
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getCompareCheckInfo(String sfzh, String jcrq, PageModel page) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		checkDao.getCheckListBySFZH(sfzh, jcrq, page);
		List<Check> list = page.getList();
		if(list != null && list.size() > 0) {
			Jbxxjlb jbxx = jbxxjlbDao.queryArchiveDetail("", sfzh);
    		resultMap.put("rqlx", jbxx.getRqlx());
    		if(list.size() > 0) {
    			HcCheckDto newly = checkDao.queryCompareDetails(list.get(0).getId());
    			if ("/".equals(newly.getZcxy())) {
					newly.setZcxy("");
				}
				if ("/".equals(newly.getYcxy())) {
					newly.setYcxy("");
				}
    			resultMap.put("newly", newly);
    		}
    		if(list.size() > 1) {
    			HcCheckDto old = checkDao.queryCompareDetails(list.get(1).getId());
    			if ("/".equals(old.getZcxy())) {
    				old.setZcxy("");
				}
				if ("/".equals(old.getYcxy())) {
					old.setYcxy("");
				}
    			resultMap.put("old", old);
    		}
    	}
		return resultMap;
	}
	
	@Override
	public void getCheckPage(String jmId, PageModel page) {
		checkDao.getCheckPage(jmId, page);
	}
	
	@Override
	public Check queryCheckDetail(String tjId) throws Exception {
		Check check = checkDao.queryCheckDetail(tjId);
		if(check != null) {
			Ybzzb ybzzb = ybzzbDao.queryYbzzbDetail(check.getId());
			check.setYbzzb(ybzzb);
		}
		return check;
	}
	
	@Override
	public Jkjc queryJkjcDetail(String tjId) throws Exception {
		Jkjc jkjc = jkjcDao.queryJkjcDetail(tjId);
		return jkjc;
	}

	@Override
	public Jkwtb queryJkwtbDetail(String tjId) throws Exception {
		Jkwtb jkwtb = jkwtbDao.queryJkwtbDetail(tjId);
		return jkwtb;
	}

	@Override
	public Pgzdjlb queryPgzdjlbDetail(String tjId) throws Exception {
		Pgzdjlb pgzdjlb = pgzdjlbDao.queryPgzdjlbDetail(tjId);
		return pgzdjlb;
	}

	@Override
	public Shfs queryShfsDetail(String tjId) throws Exception {
		Shfs shfs = shfsDao.queryShfsDetail(tjId);
		return shfs;
	}

	@Override
	public Xzjcjlb queryXzjcjlbDetail(String tjId) throws Exception {
		Xzjcjlb xzjcjlb = xzjcjlbDao.queryXzjcjlbDetail(tjId);
		return xzjcjlb;
	}
	
	@Override
	public Ybzzb queryYbzzbDetail(String tjId) throws Exception {
		Ybzzb ybzzb = ybzzbDao.queryYbzzbDetail(tjId);
		return ybzzb;
	}

	@Override
	public Zqgnb queryZqgnbDetail(String tjId) throws Exception {
		Zqgnb zqgnb = zqgnbDao.queryZqgnbDetail(tjId);
		return zqgnb;
	}

	@Override
	public List<Jzbcs> queryJzbcsDetail(String tjId) throws Exception {
		List<Jzbcs> list = jzbcsDao.queryJzbcsList(tjId);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<Jzs> queryJzsDetail(String tjId) throws Exception {
		List<Jzs> list = jzsDao.queryJzsList(tjId);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<Yjjlb> queryYjjlbDetail(String tjId) throws Exception {
		List<Yjjlb> list = yjjlbDao.queryYjjlbList(tjId);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<Zys> queryZysDetail(String tjId) throws Exception {
		List<Zys> list = zysDao.queryZysList(tjId);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

}

