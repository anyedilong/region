package com.region.moudles.hospital.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.hospital.dao.HospitalEmrDao;
import com.region.moudles.hospital.dao.HospitalImageDao;
import com.region.moudles.hospital.dao.HospitalInfoDao;
import com.region.moudles.hospital.dao.HospitalJcDao;
import com.region.moudles.hospital.dao.HospitalOrderDao;
import com.region.moudles.hospital.dao.HospitalOrderDepartmentDao;
import com.region.moudles.hospital.dao.HospitalOrderDoctorDao;
import com.region.moudles.hospital.dao.HospitalOrderItemDao;
import com.region.moudles.hospital.dao.HospitalOutCostDao;
import com.region.moudles.hospital.dao.HospitalOutMingXiDao;
import com.region.moudles.hospital.dao.HospitalOutZdDao;
import com.region.moudles.hospital.dao.HospitalZdDao;
import com.region.moudles.hospital.domain.HospitalEmr;
import com.region.moudles.hospital.domain.HospitalImage;
import com.region.moudles.hospital.domain.HospitalInfto;
import com.region.moudles.hospital.domain.HospitalJc;
import com.region.moudles.hospital.domain.HospitalOrder;
import com.region.moudles.hospital.domain.HospitalOrderDepartment;
import com.region.moudles.hospital.domain.HospitalOrderDoctor;
import com.region.moudles.hospital.domain.HospitalOrderItem;
import com.region.moudles.hospital.domain.HospitalOutCost;
import com.region.moudles.hospital.domain.HospitalOutMingXi;
import com.region.moudles.hospital.domain.HospitalOutZd;
import com.region.moudles.hospital.domain.HospitalZd;
import com.region.moudles.hospital.service.HospitalService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;
import org.springframework.beans.factory.annotation.Value;

@Named
public class HospitalServiceImpl implements HospitalService {

    @Inject
    private HospitalInfoDao hospitalInfoDao;
    @Inject
    private HospitalZdDao hospitalZdDao;
    @Inject
    private HospitalImageDao hospitalImageDao;
    @Inject
    private HospitalJcDao hospitalJcDao;
    @Inject
    private HospitalOutCostDao hospitalOutCostDao;
    @Inject
    private HospitalOutZdDao hospitalOutZdDao;
    @Inject
    private HospitalOutMingXiDao hospitalOutMingXiDao;
    @Inject
    private HospitalEmrDao hospitalEmrDao;
    @Inject
    private HospitalOrderDao hospitalOrderDao;
    @Inject
    private HospitalOrderItemDao hospitalOrderItemDao;
    @Inject
    private HospitalOrderDoctorDao hospitalOrderDoctorDao;
    @Inject
    private HospitalOrderDepartmentDao hospitalOrderDepartmentDao;
    @Value("${PrivateHost}")
    private String PrivateHost;

    @Override
    public ArrayList<String> saveHospital(List<HospitalInfto> list, String orgCode) {
        ArrayList<String> faillist = new ArrayList<>();
        if (list != null && list.size() > 0 && StringUtils.isBlank(orgCode))
            orgCode = list.get(0).getOrgCode();

        for (int i = 0; i < list.size(); i++) {
            HospitalInfto hospitalInfto = list.get(i);
            try {
                //验证是否对应的入院登记是否存在
                String hospitalId = hospitalInfoDao.getNum(hospitalInfto.getArId(), orgCode);
                if (StringUntil.isNull(hospitalId)) {
                    hospitalInfto.setId(UUIDUtil.getUUID());
                    hospitalInfoDao.save(hospitalInfto);// 入院登记
                }
            } catch (Exception e) {
                faillist.add(hospitalInfto.getArId());
            }

        }
        return faillist;
    }

    @Override
    public ArrayList<String> saveDiagnosis(List<HospitalZd> list, String orgCode) {
        ArrayList<String> faillist = new ArrayList<>();
        if (list != null && list.size() > 0 && StringUtils.isBlank(orgCode))
            orgCode = list.get(0).getOrgCode();
        for (int i = 0; i < list.size(); i++) {
            HospitalZd hospitalZd = list.get(i);
            try {
                //验证是否对应的入院登记是否存在
                String hospitalId = hospitalInfoDao.getNum(hospitalZd.getArId(), orgCode);
                if (!StringUntil.isNull(hospitalId)) {
                    hospitalZd.setId(orgCode + Integer.parseInt(hospitalZd.getId()));
                    hospitalZd.setHospitalId(hospitalId);
                    hospitalZdDao.save(hospitalZd);// 入院登记
                }
            } catch (Exception e) {
                faillist.add(hospitalZd.getHisId());

            }
        }
        return faillist;
    }

    @Override
    public ArrayList<String> saveInspect(List<HospitalJc> list, String orgCode) {
        ArrayList<String> faillist = new ArrayList<>();
        if (list != null && list.size() > 0 && StringUtils.isBlank(orgCode))
            orgCode = list.get(0).getOrgCode();

        for (int i = 0; i < list.size(); i++) {
            HospitalJc hospitalJc = list.get(i);
            try {
                //验证是否对应的入院登记是否存在
                String hospitalId = hospitalInfoDao.getNum(hospitalJc.getArId(), orgCode);
                if (!StringUntil.isNull(hospitalId)) {
                    hospitalJc.setId(orgCode + Integer.parseInt(hospitalJc.getHisId()));
                    hospitalJc.setHospitalId(hospitalId);
                    hospitalJcDao.save(hospitalJc);// 入院登记
                }
            } catch (Exception e) {
                faillist.add(hospitalJc.getHisId());
            }

        }
        return faillist;
    }

    @Override
    public ArrayList<String> saveoutcost(List<HospitalOutCost> list, String orgCode) {
        ArrayList<String> faillist = new ArrayList<>();
        if (list != null && list.size() > 0 && StringUtils.isBlank(orgCode))
            orgCode = list.get(0).getOrgCode();

        for (int i = 0; i < list.size(); i++) {
            HospitalOutCost hospitalOutCost = list.get(i);
            try {
                //验证是否对应的入院登记是否存在
                String hospitalId = hospitalInfoDao.getNum(hospitalOutCost.getArId(), orgCode);
                if (!StringUntil.isNull(hospitalId)) {
                    for (HospitalOutZd hospitalOutZd : hospitalOutCost.getDiagnosisList()) {
                        hospitalOutZd.setId(orgCode + Integer.parseInt(hospitalOutZd.getHisId()));
                        hospitalOutZdDao.save(hospitalOutZd);
                    }
                    hospitalOutCost.setId(orgCode + Integer.parseInt(hospitalOutCost.getHisId()));
                    hospitalOutCost.setHospitalId(hospitalId);
                    hospitalOutCostDao.save(hospitalOutCost);// 入院登记
                }
            } catch (Exception e) {
                faillist.add(hospitalOutCost.getHisId());
            }

        }
        return faillist;
    }

    @Override
    public ArrayList<String> savehospitalcost(String outId, List<HospitalOutMingXi> list) {
        ArrayList<String> faillist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HospitalOutMingXi hospitalOutMingXi = list.get(i);
            try {
                if (StringUtils.isNotBlank(hospitalOutMingXi.getItemType()) && hospitalOutMingXi.getItemType().length() == 1)
                    hospitalOutMingXi.setItemType("0" + hospitalOutMingXi.getItemType());
                hospitalOutMingXi.setOutId(outId);
                hospitalOutMingXi.setId(hospitalOutMingXi.getOrgCode() + Integer.parseInt(hospitalOutMingXi.getIsId()));
                hospitalOutMingXi.setHisId(hospitalOutMingXi.getIsId());
                hospitalOutMingXiDao.save(hospitalOutMingXi);// 入院登记
            } catch (Exception e) {
                faillist.add(hospitalOutMingXi.getHisId());
            }

        }
        return faillist;
    }

    @Override
    public ArrayList<String> saveImage(List<HospitalImage> list) {
        ArrayList<String> faillist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HospitalImage image = list.get(i);
            String hospitalId = hospitalInfoDao.getNum(image.getArId(), image.getOrgCode());
            if (!StringUntil.isNull(hospitalId)) {
                try {
                    image.setId(image.getOrgCode() + Integer.parseInt(image.getHisId()));
                    image.setHospitalId(hospitalId);
                    hospitalImageDao.save(image);
                } catch (Exception e) {
                    faillist.add(image.getHisId());
                }
            }
        }
        return faillist;
    }

    @Override
    public void getHospitalZYInfoPage(String sfzh, PageModel page) {
        hospitalInfoDao.getHospitalZYInfoPage(sfzh, page);
    }

    @Override
    public HospitalInfto getZYDJDetail(String zyId) {
        return hospitalInfoDao.get(zyId);
    }

    @Override
    public void getCYJSInfoPage(String sfzh, PageModel page) {
        hospitalOutCostDao.getCYJSInfoPage(sfzh, page);
    }

    @Override
    public HospitalOutCost getCYJSDetail(String cyId) {
        return hospitalOutCostDao.get(cyId);
    }

    @Override
    public void getZYBAList(String sfzh, PageModel page) {
        hospitalEmrDao.getZYBAList(sfzh, page);
    }

    @Override
    public HospitalEmr getZYBADetail(String emrId, String admissionId, String orgCode) {
        return hospitalEmrDao.getZYBADetail(emrId, admissionId, orgCode);
    }

    @Override
    public void getHospitalPage(String sfzh, PageModel page) {
        hospitalInfoDao.getHospitalZYInfoPage(sfzh, page);
    }

    @Override
    public HospitalInfto getHospitalDetail(String id) {
        return hospitalInfoDao.getHospitalDetail(id);
    }

    @Override
    public List<HospitalOutCost> getHospitalCostList(String zyId, String startTime, String endTime, String name) {
        List<HospitalOutCost> hospitalCostList = hospitalOutCostDao.getHospitalCostList(zyId);
        if (hospitalCostList == null) {
            hospitalCostList = new ArrayList<>();
        } else {
            for (int i = 0; i < hospitalCostList.size(); i++) {
                String hisId = hospitalCostList.get(i).getHisId();
                List<HospitalOutMingXi> mxList = hospitalOutMingXiDao.getHospitalCostMingXiList(hisId, name, startTime,
                        endTime);
                if (mxList == null) {
                    mxList = new ArrayList<>();
                }
                List<HospitalOutZd> zdList = hospitalOutZdDao.getHospitalCostZdList(hisId);
                if (zdList == null) {
                    zdList = new ArrayList<>();
                }
                hospitalCostList.get(i).setHospitalOutMingXiList(mxList);
                hospitalCostList.get(i).setDiagnosisList(zdList);
            }
        }
        return hospitalCostList;
    }

    @Override
    public List<HospitalZd> getHospitalZDList(String zyId) throws Exception {
        List<HospitalZd> list = hospitalZdDao.getHospitalZDList(zyId);
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public List<HospitalImage> getHospitalImageList(String zyId) throws Exception {
        List<HospitalImage> yxList = hospitalImageDao.getHospitalImageList(zyId);
        if (yxList == null) {
            yxList = new ArrayList<>();
        } else {
            for (HospitalImage info : yxList) {
                List<HospitalImage> list = hospitalImageDao.getHospitalImageInfoList(info);
                if (list == null) {
                    info.setImagelist(new ArrayList<>());
                } else {
                    for (HospitalImage image : yxList) {
                        if (StringUtils.isNotBlank(image.getImageJpgUrl()))
                            image.setImageJpgUrl(PrivateHost + image.getImageJpgUrl());
                    }
                    info.setImagelist(list);
                }
            }
        }
        return yxList;
    }

    @Override
    public void updateImageJpgPath(String imageId, String imageJpgPath) {
        hospitalImageDao.updateImageJpgPath(imageId, imageJpgPath);
    }

    @Override
    public List<HospitalJc> getHospitalJcList(String zyId, String itemType) throws Exception {
        List<HospitalJc> list = null;
        if (StringUtils.isBlank(itemType))
            list = hospitalJcDao.getHospitalJcList(zyId);
        else
            list = hospitalJcDao.getJcListByType(zyId, itemType);
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public HospitalInfto getAppHospitalDetail(String id) {
        //查询住院的基本信息
        HospitalInfto info = hospitalInfoDao.getAppHospitalDetail(id);
        //查询住院的诊断
        List<HospitalZd> zdList = hospitalZdDao.getHospitalZDList(info.getId());
        if (zdList == null) {
            zdList = new ArrayList<>();
        }
        info.setHospitalZdList(zdList);
        //查询住院的明细
        List<HospitalOutCost> hospitalCostList = hospitalOutCostDao.getHospitalCostList(info.getId());
        if (hospitalCostList == null) {
            hospitalCostList = new ArrayList<>();
        } else {
            for (int i = 0; i < hospitalCostList.size(); i++) {
                String hisId = hospitalCostList.get(i).getHisId();
                List<HospitalOutMingXi> mxList = hospitalOutMingXiDao.getHospitalCostMingXiList(hisId, "", "", "");
                if (mxList == null) {
                    mxList = new ArrayList<>();
                }
                List<HospitalOutZd> outZdList = hospitalOutZdDao.getHospitalCostZdList(hisId);
                if (zdList == null) {
                    zdList = new ArrayList<>();
                }
                hospitalCostList.get(i).setHospitalOutMingXiList(mxList);
                hospitalCostList.get(i).setDiagnosisList(outZdList);
            }
        }
        info.setHospitalOutCostList(hospitalCostList);
        //查询住院的检查
        List<HospitalImage> jclist = hospitalImageDao.getHospitalImageList(info.getId());
        if (jclist == null) {
            jclist = new ArrayList<>();
        }
        info.setHospitalImageList(jclist);
        //查询住院的检验
        List<HospitalJc> jylist = hospitalJcDao.getHospitalJcList(info.getId());
        if (jylist == null) {
            jylist = new ArrayList<>();
        }
        info.setHospitalJcList(jylist);
        return info;
    }

    @Override
    public List<HospitalOrder> getHospitalOrderList(String zyId) throws Exception {
        List<HospitalOrder> list = hospitalOrderDao.getHospitalOrderList(zyId);
        if (list == null || list.size() == 0) {
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public HospitalOrder getHospitalOrderDetail(String id) throws Exception {
        //查询医嘱详情
        HospitalOrder info = hospitalOrderDao.getHospitalOrderDetail(id);
        if (info != null) {
            //查询医嘱明细集合
            List<HospitalOrderItem> oiList = hospitalOrderItemDao.getOrderItemList(info.getId());
            if (oiList != null && oiList.size() > 0) {
                info.setOiList(oiList);
            } else {
                info.setOiList(new ArrayList<>());
            }
            List<HospitalOrderDoctor> oiDoctorList = hospitalOrderDoctorDao.getOiDoctorList(info.getId());
            if (oiDoctorList != null && oiDoctorList.size() > 0) {
                info.setOiDoctorList(oiDoctorList);
            } else {
                info.setOiDoctorList(new ArrayList<>());
            }
            List<HospitalOrderDepartment> oiDepList = hospitalOrderDepartmentDao.getOiDepList(info.getId());
            if (oiDepList != null && oiDepList.size() > 0) {
                info.setOiDepList(oiDepList);
            } else {
                info.setOiDepList(new ArrayList<>());
            }
        }
        return info;
    }

    @Override
    public List<HospitalOrderItem> getHospitalOrderItemList(String zyId) throws Exception {
        List<HospitalOrderItem> list = hospitalOrderItemDao.getHospitalOrderItemList(zyId);
        if (list == null || list.size() == 0) {
            list = new ArrayList<>();
        }
        return list;
    }
}
