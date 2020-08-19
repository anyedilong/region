package com.region.moudles.outpatient.service.impl;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;

import com.region.moudles.outpatient.dao.*;
import com.region.moudles.outpatient.domain.*;

import com.region.moudles.outpatient.dto.JcDto;
import com.region.moudles.outpatient.service.OutpatientService;
import com.region.moudles.system.dao.SysOrgDao;
import com.region.moudles.system.domain.SysOrg;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class OutpatientServiceImpl implements OutpatientService {

    @Inject
    private MedicalrecordDao medicalrecordDao;
    @Inject
    private OutpatientZdDao outpatientZdDao;
    @Inject
    private OutpatientJcDao outpatientJcDao;
    @Inject
    private OutpatientRecipeDao outpatientRecipeDao;
    @Inject
    private OutpatientRxMingxiDao outpatientRxMingxiDao;
    @Inject
    private OutpatientRxZdDao outpatientRxZdDao;
    @Inject
    private OutpatientCostDao outpatientCostDao;
    @Inject
    private OutpatientImageDao outpatientImageDao;
    @Inject
    private SysOrgDao sysOrgDao;
    @Value("${PrivateHost}")
    private String PrivateHost;

    @Override
    public ArrayList<String> saveOutpatient(List<Medicalrecord> list, String orgCode) {
        ArrayList<String> faillist = new ArrayList<>();
        if (list != null && list.size() > 0 && StringUtils.isBlank(orgCode))
            orgCode = list.get(0).getOrgCode();
        for (Medicalrecord medicalrecord : list) {
            try {
                //验证是否对应的门诊病历是否存在
                String num = medicalrecordDao.getNum(medicalrecord.getOutpatientNum(), orgCode);
                if (StringUntil.isNull(num)) {
                    medicalrecord.setId(UUIDUtil.getUUID());
                    medicalrecordDao.save(medicalrecord);// 门诊病历
                }
            } catch (Exception e) {
                faillist.add(medicalrecord.getOutpatientNum());
            }
        }

        return faillist;
    }

    @Override
    public ArrayList<String> saveOutpatientZd(List<OutpatientZd> list, String orgCode) {
        ArrayList<String> faillist = new ArrayList<>();
        if (list != null && list.size() > 0 && StringUtils.isBlank(orgCode))
            orgCode = list.get(0).getOrgCode();
        for (OutpatientZd outpatientZd : list) {
            try {
                //验证是否对应的门诊病历是否存在
                String medicalRecordId = medicalrecordDao.getNum(outpatientZd.getOutpatientNum(), orgCode);
                if (!StringUntil.isNull(medicalRecordId)) {
                    outpatientZd.setHisId(outpatientZd.getId());
                    outpatientZd.setId(orgCode + Integer.parseInt(outpatientZd.getId()));
                    outpatientZd.setMedicalRecordId(medicalRecordId);
                    outpatientZdDao.save(outpatientZd);
                }
            } catch (Exception e) {
                faillist.add(outpatientZd.getHisId());
            }
        }
        return faillist;
    }

    @Override
    public ArrayList<String> saveinspect(List<OutpatientJc> list, String orgCode) {
        ArrayList<String> faillist = new ArrayList<>();
        if (list != null && list.size() > 0 && StringUtils.isBlank(orgCode))
            orgCode = list.get(0).getOrgCode();
        for (OutpatientJc outpatientJc : list) {
            try {
                //验证是否对应的门诊病历是否存在
                String medicalRecordId = medicalrecordDao.getNum(outpatientJc.getOutpatientNum(), orgCode);
                if (!StringUntil.isNull(medicalRecordId)) {
                    outpatientJc.setHisId(outpatientJc.getId());
                    outpatientJc.setId(orgCode + Integer.parseInt(outpatientJc.getId()));
                    outpatientJc.setMedicalRecordId(medicalRecordId);
                    outpatientJcDao.save(outpatientJc);
                }
            } catch (Exception e) {
                faillist.add(outpatientJc.getHisId());
            }
        }
        return faillist;
    }

    @Override
    public ArrayList<String> saverecipe(List<OutpatientRecipe> list, String orgCode) {
        ArrayList<String> faillist = new ArrayList<>();
        if (list != null && list.size() > 0 && StringUtils.isBlank(orgCode))
            orgCode = list.get(0).getOrgCode();
        for (OutpatientRecipe outpatientRecipe : list) {
            String medId = medicalrecordDao.getNum(outpatientRecipe.getOutpatientNum(), orgCode);
            if (!StringUntil.isNull(medId)) {
                // String uuid = UUIDUtil.getUUID();
                try {
                    if (outpatientRecipe.getDiagnosislist() != null && outpatientRecipe.getDiagnosislist().size() > 0) {
                        for (OutpatientRxZd outpatientRxZd : outpatientRecipe.getDiagnosislist()) {
                            outpatientRxZd.setId(orgCode + Integer.parseInt(outpatientRxZd.getHisId()));
                            outpatientRxZdDao.save(outpatientRxZd);
                        }
                    }
                    if (outpatientRecipe.getRecipelist() != null && outpatientRecipe.getRecipelist().size() > 0) {
                        for (OutpatientRxMingxi outpatientRxMingxi : outpatientRecipe.getRecipelist()) {
                            outpatientRxMingxi.setId(orgCode + Integer.parseInt(outpatientRxMingxi.getHisId()));
                            outpatientRxMingxi.setOrgCode(orgCode);
                            if (outpatientRxMingxi.getItemType() != null)
                                outpatientRxMingxi.setItemType(outpatientRxMingxi.getItemType().trim());
                            outpatientRxMingxiDao.save(outpatientRxMingxi);
                        }
                    }

                    outpatientRecipe.setId(orgCode + outpatientRecipe.getHisId());
                    outpatientRecipe.setMedicalRecordId(medId);
                    outpatientRecipeDao.save(outpatientRecipe);
                } catch (Exception e) {
                    faillist.add(outpatientRecipe.getHisId());
                }
            }

        }
        return faillist;
    }

    @Override
    public ArrayList<String> savecost(List<OutpatientCost> outpatientCostList, String orgCode) {
        ArrayList<String> faillist = new ArrayList<>();
        if (outpatientCostList != null && outpatientCostList.size() > 0 && StringUtils.isBlank(orgCode))
            orgCode = outpatientCostList.get(0).getOrgCode();
        for (OutpatientCost outpatientCost : outpatientCostList) {
            try {
                //验证是否对应的门诊病历是否存在
                String medicalRecordId = medicalrecordDao.getNum(outpatientCost.getOutpatientNum(), orgCode);
                if (!StringUntil.isNull(medicalRecordId)) {
                    outpatientCost.setId(orgCode + Integer.parseInt(outpatientCost.getHisId()));
                    outpatientCost.setMedicalRecordId(medicalRecordId);
                    outpatientCostDao.save(outpatientCost);
                }
            } catch (Exception e) {
                faillist.add(outpatientCost.getHisId());
            }
        }
        return faillist;
    }

    @Override
    public ArrayList<String> saveimage(List<OutpatientImage> list, String orgCode) {
        ArrayList<String> faillist = new ArrayList<>();
        if (list != null && list.size() > 0 && StringUtils.isBlank(orgCode))
            orgCode = list.get(0).getOrgCode();
        for (OutpatientImage outpatientImage : list) {
            try {
                //验证是否对应的门诊病历是否存在
                String medicalRecordId = medicalrecordDao.getNum(outpatientImage.getOutpatientNum(), orgCode);
                if (!StringUntil.isNull(medicalRecordId)) {
                    outpatientImage.setId(orgCode + Integer.parseInt(outpatientImage.getHisId()));
                    outpatientImage.setMedicalRecordId(medicalRecordId);
                    outpatientImageDao.save(outpatientImage);
                }
            } catch (Exception e) {

                faillist.add(outpatientImage.getOutpatientNum());
            }
        }
        return faillist;
    }

    @Override
    public void getOutpatientZDInfo(String sfzh, PageModel page) {
        outpatientZdDao.getOutpatientZDInfo(sfzh, page);
    }

    // 查询单个居民门诊病历列表（公卫）
    @Override
    public void getOutpatientBLList(String sfzh, PageModel page) {
        medicalrecordDao.getOutpatientBLList(sfzh, page);
    }

    // 查询门诊病例详情（公卫）
    public Medicalrecord getOutpatientBLDetail(String medicalRecordId) {
        Medicalrecord info = medicalrecordDao.getMedicalRecordById(medicalRecordId);
        if (!StringUntil.isNull(info.getVisitingType())) {
            if ("1".equals(info.getVisitingType())) {
                info.setVisitingTypeText("普通门诊");
            } else if ("2".equals(info.getVisitingType())) {
                info.setVisitingTypeText("专家门诊");
            } else if ("3".equals(info.getVisitingType())) {
                info.setVisitingTypeText("急诊");
            } else if ("9".equals(info.getVisitingType())) {
                info.setVisitingTypeText("其他");
            }
        }
        return info;
    }

    // 查询单个居民门诊病历列表（健康浏览器）
    @Override
    public void getOutpatientPage(String sfzh, PageModel page) throws Exception {
        medicalrecordDao.getOutpatientPage(sfzh, page);
    }

    // 查询单个居民门诊病历-处方列表（健康浏览器）
    @Override
    public List<OutpatientRecipe> getOutpatientCfList(String mzId) throws Exception {
        List<OutpatientRecipe> cfList = outpatientRecipeDao.getOutpatientCfList(mzId);
        if (cfList == null) {
            return new ArrayList<>();
        } else {
            for (int i = 0; i < cfList.size(); i++) {
                String recipeNum = cfList.get(i).getRecipeNum();
                String orgCode = cfList.get(i).getOrgCode();
                List<OutpatientRxMingxi> cfMingxiList = outpatientRxMingxiDao.getCfMingxiDetail(recipeNum, orgCode);
                if (cfMingxiList == null) {
                    cfMingxiList = new ArrayList<>();
                }
                List<OutpatientRxZd> cfZdList = outpatientRxZdDao.getCfZdDetail(recipeNum, orgCode);
                if (cfZdList == null) {
                    cfZdList = new ArrayList<>();
                }
                cfList.get(i).setRecipelist(cfMingxiList);
                cfList.get(i).setDiagnosislist(cfZdList);
            }
        }
        return cfList;
    }

    @Override
    public List<OutpatientZd> getOutpatientZDList(String mzId) throws Exception {
        List<OutpatientZd> cfList = outpatientZdDao.getOutpatientZDList(mzId);
        if (cfList == null) {
            cfList = new ArrayList<>();
        }
        return cfList;
    }

    @Override
    public List<OutpatientImage> getOutpatientImageList(String mzId) throws Exception {
        List<OutpatientImage> yxList = outpatientImageDao.getOutpatientImageList(mzId);
        if (yxList == null) {
            yxList = new ArrayList<>();
        } else {
            for (OutpatientImage info : yxList) {
                List<OutpatientImage> list = outpatientImageDao.getOutpatientImageInfoList(info);
                if (list == null) {
                    info.setImagelist(new ArrayList<>());
                } else {
                    for (OutpatientImage image : yxList) {
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
        outpatientImageDao.updateImageJpgPath(imageId, imageJpgPath);
    }

    @Override
    public List<OutpatientJc> getOutpatientJcList(String mzId, String itemType) throws Exception {
        List<OutpatientJc> jcList = null;
        if (StringUtils.isBlank(itemType))
            jcList = outpatientJcDao.getOutpatientJcList(mzId);
        else
            jcList = outpatientJcDao.getJcListByType(mzId, itemType);
        if (jcList == null) {
            jcList = new ArrayList<>();
        }
        return jcList;
    }

    //查询门诊和住院检查分页
    @Override
    public PageModel getJcPage(JcDto dto) throws Exception {
        //登陆账号所在机构
        SysOrg org = sysOrgDao.get(dto.getOrgId());
        if (org == null)
            return null;
        if (StringUtils.isBlank(dto.getOrgCode())) {
            dto.setOrgCode(org.getOrgCode());
        } /*else if (!dto.getOrgCode().startsWith(org.getOrgCode())) {
            return null;
        }*/

        outpatientJcDao.getJcListPage(dto);
        if (dto.getPage().getList() == null) {
            dto.getPage().setList(new ArrayList<>());
        }
        return dto.getPage();
    }

    //查询门诊或住院检查详情
    @Override
    public JcDto getJcInfo(JcDto req) {
        JcDto resp = outpatientJcDao.getJcInfo(req);
        if (resp != null)
            resp.setPatientType(req.getPatientType());
        else
            return new JcDto();
        resp.setReportList(outpatientJcDao.getJcList(resp));
        return resp;
    }

}
