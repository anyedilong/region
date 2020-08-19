package com.region.moudles.tripartdock.sign.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.region.moudles.tripartdock.servicepackage.dao.ServicePackageDao;
import com.region.moudles.tripartdock.servicepackage.dao.ServiceProjectDao;
import com.region.moudles.tripartdock.sign.dao.SignCustomerDao;
import com.region.moudles.tripartdock.sign.dao.SignCustomerPackageDao;
import com.region.moudles.tripartdock.sign.dao.SignCustomerProjectDao;
import com.region.moudles.tripartdock.sign.dao.SignDao;
import com.region.moudles.tripartdock.sign.dao.SignItemAnnexDao;
import com.region.moudles.tripartdock.sign.dao.SignItemDao;
import com.region.moudles.tripartdock.sign.dao.SignLogDao;
import com.region.moudles.tripartdock.sign.dao.SignRecordDao;
import com.region.moudles.tripartdock.sign.dao.SignRenewDao;
import com.region.moudles.tripartdock.sign.domain.Sign;
import com.region.moudles.tripartdock.sign.domain.SignCustomer;
import com.region.moudles.tripartdock.sign.domain.SignCustomerPackage;
import com.region.moudles.tripartdock.sign.domain.SignCustomerProject;
import com.region.moudles.tripartdock.sign.domain.SignItem;
import com.region.moudles.tripartdock.sign.domain.SignItemAnnex;
import com.region.moudles.tripartdock.sign.domain.SignLog;
import com.region.moudles.tripartdock.sign.domain.SignRecord;
import com.region.moudles.tripartdock.sign.domain.SignRenew;
import com.region.moudles.tripartdock.sign.dto.SignRecordDto;
import com.region.moudles.tripartdock.sign.service.TripartSignService;
import com.region.moudles.tripartdock.team.dao.TeamDao;
import com.region.moudles.tripartdock.team.dao.TeamUserDao;
import com.region.moudles.tripartdock.team.domain.SysTeam;
import com.region.moudles.tripartdock.team.domain.SysTeamUser;
import com.region.until.UUIDUtil;

/**
 * @author Administrator
 * @ClassName: TripartSignServiceImpl
 * @Description: 三方对接 保存签约的信息
 * @date 2019年7月25日
 */

@Named
public class TripartSignServiceImpl implements TripartSignService {

    @Autowired
    private SignDao signDao;
    @Autowired
    private SignCustomerPackageDao signCustomerPackageDao;
    @Autowired
    private SignCustomerProjectDao signCustomerProjectDao;
    @Autowired
    private SignCustomerDao signCustomerDao;
    @Autowired
    private SignItemAnnexDao signItemAnnexDao;
    @Autowired
    private SignItemDao signItemDao;
    @Autowired
    private SignRenewDao signRenewDao;
    @Autowired
    private SignLogDao signLogDao;
    @Autowired
    private SignRecordDao signRecordDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private TeamUserDao teamUserDao;
    @Autowired
    private ServicePackageDao servicePackageDao;
    @Autowired
    private ServiceProjectDao serviceProjectDao;

    //保存服务包相关信息
    @Override
    public Map<String, Object> saveSignInfo(List<Sign> list) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String signId = "";
        try {
            for (Sign info : list) {
                signId = info.getId();
                //签约居民关联信息
                List<SignCustomer> signCustomerList = info.getSignCustomerList();
                if (signCustomerList != null && signCustomerList.size() > 0) {
                    for (SignCustomer signCus : signCustomerList) {
                        //签约居民服务包关联表
                        List<SignCustomerPackage> signCustomerPackageList = signCus.getSignCustomerPackageList();
                        if (signCustomerPackageList != null && signCustomerPackageList.size() > 0) {
                            signCustomerPackageDao.save(signCustomerPackageList);
                        }
                        //签约居民服务项关联表
                        List<SignCustomerProject> signCustomerProjectList = signCus.getSignCustomerProjectList();
                        if (signCustomerProjectList != null && signCustomerProjectList.size() > 0) {
                            signCustomerProjectDao.save(signCustomerProjectList);
                        }
                        signCus.setId(UUIDUtil.getUUID());
                        signCustomerDao.save(signCus);
                    }
                }
                //签约附件表
                SignItem signItem = info.getSignItem();
                if (signItem != null) {
                    //签约文件和附件的关联表
                    List<SignItemAnnex> signItemAnnexList = signItem.getSignItemAnnexList();
                    if (signItemAnnexList != null && signItemAnnexList.size() > 0) {
                        signItemAnnexDao.save(signItemAnnexList);
                    }
                    signItem.setId(UUIDUtil.getUUID());
                    signItemDao.save(signItem);
                }
                //签约历史表
                SignLog signLog = info.getSignLog();
                if (signLog != null) {
                    signLog.setId(UUIDUtil.getUUID());
                    signLogDao.save(signLog);
                }
                //履约记录表
                List<SignRecord> signRecordList = info.getSignRecordList();
                if (signRecordList != null && signRecordList.size() > 0) {
                    signRecordDao.save(signRecordList);
                }
                //签约周期表
                List<SignRenew> signRenewList = info.getSignRenewList();
                if (signRenewList != null && signRenewList.size() > 0) {
                    signRenewDao.save(signRenewList);
                }
                info.setId(UUIDUtil.getUUID());
                signDao.save(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put(signId, e.getMessage());
        }
        return map;
    }

    //获取签约详情
    @Override
    public Sign getSignInfo(String jmId) throws Exception {
        Sign sign = signDao.querySignDetail(jmId);
        if(sign == null) {
        	return null;
        }else {
            //团队信息
            SysTeam team = teamDao.queryTeamInfoBySignId(sign.getTeamId());

        	if(team != null) {
        		sign.setOrgName(team.getOrgName());
                List<SysTeamUser> userList = teamUserDao.getTeamUserByTeamId(team.getId());
                team.setTeamUserList(userList);
        	}
        	sign.setSysTeam(team);
        	//服务包信息
        	sign.setServicePackageList(servicePackageDao.queryServicePackageInfo(sign.getId()));
        	//附件
        	sign.setImgList(signItemAnnexDao.queryImgList(sign.getId()));
        }
        return sign;
    }

    //获取履约列表
    @Override
    public List<SignRecordDto> getSignServiceList(String jmId) throws Exception {
        List<SignRecordDto> list = signRecordDao.getSignServiceList(jmId);
        if(list == null || list.size() == 0) {
        	list = new ArrayList<>();
        }
        return list;
    }

	@Override
	public List<SignRecordDto> getSignServiceInfo(String signId, String packeageId, String projectId) throws Exception {
        List<SignRecordDto> list = signRecordDao.getSignServiceInfo(signId, packeageId, projectId);
        if (list != null && list.size() > 0) {
            for (SignRecordDto dto : list) {
                dto.setOrgName(dto.getOrgname());
            }
        }
        return list;
	}

}

