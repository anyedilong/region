package com.region.moudles.tripartdock.sign.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.sign.dao.repository.SignRecordRepository;
import com.region.moudles.tripartdock.sign.domain.SignRecord;
import com.region.moudles.tripartdock.sign.dto.SignRecordDto;


@Named
public class SignRecordDao extends BaseDao<SignRecordRepository, SignRecord> {

	/**
	 * @Description: 获取履约服务列表
	 * @param @param signId
	 * @param @return
	 * @return List<SignRecordDto>
	 * @throws
	 */
    public List<SignRecordDto> getSignServiceList(String jmId) {
    	Map<String, Object> paramMap = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select a.servicepackage as packageId, e.package_name as servicepackageName, a.servicetype as serviceType,");
        sql.append(" a.serviceprojectid as projectId, f.project_name as serviceprojectName, a.doctorid, a.signid, ");
        sql.append(" a.servicenumber as recordCount, f.frequency as count, max(a.servicetime) as serviceTime, c.team_name as teamName");
        sql.append(" from blt_sign_record a ");
        sql.append(" join  blt_sign b on b.id = a.signid ");
        sql.append(" join sys_team c on b.team_id = c.id ");
        sql.append(" join sys_service_package e on a.servicepackage = e.id ");
        sql.append(" join sys_service_project f on a.serviceprojectid = f.id ");
        sql.append(" where b.jmid = :jmId and b.delete_flg = '0' and (a.deleteflg = '0' or a.deleteflg is null)  ");
        sql.append(" group by a.servicepackage, e.package_name, ");
        sql.append(" a.serviceprojectid, f.project_name, a.servicetype, a.doctorid, a.signid, c.team_name, a.servicenumber, f.frequency ");
        paramMap.put("jmId", jmId);
        return queryList(sql.toString(), paramMap, SignRecordDto.class);
    }

    /**
     * @Description: 查询履约服务详情
     * @param @param signId
     * @param @param packeageId
     * @param @param projectId
     * @param @return
     * @return List<SignRecordDto>
     * @throws
     */
    public List<SignRecordDto> getSignServiceInfo(String signId, String packeageId, String projectId) {
    	Map<String, Object> paramMap = new HashMap<>();
    	StringBuilder sql = new StringBuilder();
    	sql.append(" select e.package_name as servicepackageName, to_char(f.project_desc) as projectDesc, ");
        sql.append(" f.project_name as serviceprojectName, a.doctorid, a.orgname, ");
        sql.append(" a.servicetime, c.team_name,  a.servicetype as serviceType, a.specification, ");
        sql.append(" a.servicenumber as recordCount, j.hzmc, (floor(MONTHS_BETWEEN(sysdate, j.csrq)/12)) as nl, f.frequency as count ");
        sql.append(" from blt_sign_record a  ");
        sql.append(" join  blt_sign b on b.id = a.signid  ");
        sql.append(" join sys_team c on b.team_id = c.id ");
        sql.append(" join sys_service_package e on a.servicepackage = e.id  ");
        sql.append(" join sys_service_project f on a.serviceprojectid = f.id  ");
        sql.append(" join blt_jbxxjlb j on j.id = b.jmid  ");
        sql.append(" where a.signid = :signId and a.servicepackage = :packeageId and a.serviceprojectid = :projectId ");
        sql.append(" order by a.servicetime desc ");
        paramMap.put("signId", signId);
        paramMap.put("packeageId", packeageId);
        paramMap.put("projectId", projectId);
        return queryList(sql.toString(), paramMap, SignRecordDto.class);
    }

}
