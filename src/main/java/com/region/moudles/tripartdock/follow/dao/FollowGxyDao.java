package com.region.moudles.tripartdock.follow.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.follow.dao.repository.FollowGxyJbRepository;
import com.region.moudles.tripartdock.follow.dao.repository.FollowGxyRepository;
import com.region.moudles.tripartdock.follow.dao.repository.FollowGxySzRepository;
import com.region.moudles.tripartdock.follow.dao.repository.FollowGxySzmqyyRepository;
import com.region.moudles.tripartdock.follow.dao.repository.FollowGxySzywzlbRepository;
import com.region.moudles.tripartdock.follow.domain.FollowGxy;
import com.region.moudles.tripartdock.follow.domain.FollowGxyJb;
import com.region.moudles.tripartdock.follow.domain.FollowGxySz;
import com.region.moudles.tripartdock.follow.domain.FollowGxySzmqyy;
import com.region.moudles.tripartdock.follow.domain.FollowGxySzywzlb;
import com.region.moudles.tripartdock.follow.dto.GxyDto;
import com.region.moudles.tripartdock.follow.dto.GxySzDto;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.apache.commons.lang3.StringUtils;


@Named
public class FollowGxyDao extends BaseDao<FollowGxyRepository, FollowGxy> {

    @Inject
    private FollowGxyJbRepository gxyJbRepository;
    @Inject
    private FollowGxySzRepository followGxySzRepository;
    @Inject
    private FollowGxySzmqyyRepository followGxySzmqyyRepository;
    @Inject
    private FollowGxySzywzlbRepository followGxySzywzlbRepository;

    /**
     * @param @param list
     * @return void
     * @throws
     * @Description: 保存高血压基本信息
     */
    public void saveGxyJbInfo(List<FollowGxyJb> list) {
        gxyJbRepository.save(list);
    }

    public void saveGxyJbInfo(FollowGxyJb info) {
        gxyJbRepository.save(info);
    }

    public FollowGxyJb getGxyJbById(String id) {
        return gxyJbRepository.findOne(id);
    }

    //查询高血压随访列表
    public List<GxyDto> getAll(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from (select t.*,ROWNUM rn from( ");
        sql.append(" select b.id,b.sfys,b.sfrq,b.sffs,jb.hzmc hzxm,o.id org_id,o.org_name,b.sfys as sfys_name ");
        sql.append(" from blt_mxgxysfb b ");
        sql.append(" join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg ");
        sql.append(" where 1=1 ");
        if (StringUtils.isNotBlank(request.getJmid())) {
            sql.append("  and b.jmid = :jmid ");
        }
        if (StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.sfrq, 'yyyy') = :searchTime ");
        }
        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) order by b.sfrq ");
        sql.append(") t where ROWNUM <= :pageSize * :pageNo) where rn > :pageSize * (:pageNo-1)");
        return queryList(sql.toString(), request, GxyDto.class);
    }

    //查询高血压列表数量
    public int getCount(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select b.id from blt_mxgxysfb b join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg ");
        sql.append(" where 1=1 ");
        if (StringUtils.isNotBlank(request.getJmid())) {
            sql.append("  and b.jmid = :jmid ");
        }
        if (StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.sfrq, 'yyyy') = :searchTime ");
        }
        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) ");
        Map<String, Object> map = new HashMap<>();
        getParam(sql.toString(), map, request);
        return (int) queryCount(sql.toString(), map);
    }

    /**
     * @param @param list
     * @return void
     * @throws
     * @Description: 保存高血压首诊信息
     */
    public void saveGxySzInfo(FollowGxySz entity) {
        followGxySzRepository.save(entity);
    }

    public FollowGxySz getGxySzById(String id) {
        return followGxySzRepository.findOne(id);
    }

    //查询高血压首诊列表
    public List<GxySzDto> getSzAll(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (select t.*,ROWNUM rn from( select b.*,jb.hzmc name,o.id org_id,o.org_name");
        sql.append(" from blt_mxgxyszb b");
        sql.append(" join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg where 1=1 ");

        if (StringUtils.isNotBlank(request.getZjlx()) && StringUtils.isNotBlank(request.getSfzh())) {
            sql.append("  and jb.zjlx = :zjlx and jb.sfzh = :sfzh");
        }
        if (StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.szrq, 'yyyy') = :searchTime ");
        }

        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) order by b.szrq ");
        sql.append(") t where ROWNUM <= :pageSize * :pageNo) where rn > :pageSize * (:pageNo-1)");
        List<GxySzDto> list = queryList(sql.toString(), request, GxySzDto.class);
        return list;
    }

    //查询高血压首诊数量
    public int getSzCount(RequestDto request) {
        StringBuilder sql = new StringBuilder();
        sql.append("select b.id from blt_mxgxyszb b join blt_jbxxjlb jb on b.jmid = jb.id join sys_org o on o.id = jb.jdjg where 1=1 ");

        if (StringUtils.isNotBlank(request.getZjlx()) && StringUtils.isNotBlank(request.getSfzh())) {
            sql.append("  and jb.zjlx = :zjlx and jb.sfzh = :sfzh");
        }
        if (StringUtils.isNotBlank(request.getSearchTime())) {
            sql.append("  and to_char(b.szrq, 'yyyy') = :searchTime ");
        }
        sql.append(" and (jb.sfsc != 'Y' or jb.sfsc is null) and jb.over_flg != '1' and jb.migrate_flg != '1' and (b.sfsc != '1' or b.sfsc is null) ");
        Map<String, Object> map = new HashMap<>();
        getParam(sql.toString(), map, request);
        int count = (int) queryCount(sql.toString(), map);
        return count;
    }
    
    //查询高血压数量根据jmId
    public int getSFCountByJmId(String jmId) {
        StringBuilder sql = new StringBuilder();
        sql.append("select a.id from blt_mxgxysfb a ");
        sql.append(" where a.jmid = :jmId ");
        Map<String, Object> map = new HashMap<>();
        map.put("jmId", jmId);
        return (int) queryCount(sql.toString(), map);
    }
    
    /**
     * @param @param list
     * @return void
     * @throws
     * @Description: 保存高血压首诊目前用药信息
     */
    public void saveGxySzmqyyInfo(List<FollowGxySzmqyy> list) {
        followGxySzmqyyRepository.save(list);
    }

    public void saveGxySzmqyyInfo(FollowGxySzmqyy info) {
        followGxySzmqyyRepository.save(info);
    }

    /**
     * @param @param list
     * @return void
     * @throws
     * @Description: 保存高血压首诊药物治疗信息
     */
    public void saveGxySzywlbInfo(List<FollowGxySzywzlb> list) {
        followGxySzywzlbRepository.save(list);
    }

    public void saveGxySzywlbInfo(FollowGxySzywzlb info) {
        followGxySzywzlbRepository.save(info);
    }
    
}
