package com.region.moudles.outpatient.service;


import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.outpatient.domain.*;
import com.region.moudles.outpatient.dto.JcDto;

import java.util.ArrayList;
import java.util.List;

public interface OutpatientService{


    //保存门诊
    ArrayList<String> saveOutpatient(List<Medicalrecord> list, String orgCode);
    //保存门诊诊断
    ArrayList<String> saveOutpatientZd(List<OutpatientZd> list, String orgCode);
    //保存门诊检验信息
    ArrayList<String> saveinspect(List<OutpatientJc> list, String orgCode);
    //保存门诊处方
    ArrayList<String> saverecipe(List<OutpatientRecipe> list, String orgCode);
    //保存门诊结算
    ArrayList<String> savecost(List<OutpatientCost> outpatientCostList, String orgCode);
    ArrayList<String> saveimage(List<OutpatientImage> outpatientImage, String orgCode);
    
    //查询门诊结果
    void getOutpatientZDInfo(String sfzh, PageModel page);
    // 查询单个居民门诊病历列表（公卫）
    void getOutpatientBLList(String sfzh, PageModel page);
    // 查询门诊病例详情（公卫）
    public Medicalrecord getOutpatientBLDetail(String medicalRecordId);
    // 查询单个居民门诊病历列表（健康浏览器）
    void getOutpatientPage(String sfzh, PageModel page) throws Exception;
    //查询门诊处方详情（健康浏览器）
    List<OutpatientRecipe> getOutpatientCfList(String mzId) throws Exception;
    //查询门诊诊断详情（健康浏览器）
    List<OutpatientZd> getOutpatientZDList(String mzId) throws Exception;
    //查询门诊影像详情（健康浏览器）
    List<OutpatientImage> getOutpatientImageList(String mzId) throws Exception;
    //更新影像的jpg路径
    void updateImageJpgPath(String imageId, String imageJpgPath);
    //查询门诊检查详情（健康浏览器）
    List<OutpatientJc> getOutpatientJcList(String mzId, String itemType) throws Exception;

    //查询门诊和住院检查分页
    PageModel getJcPage(JcDto dto) throws Exception;

    //查询门诊或住院检查详情
    JcDto getJcInfo(JcDto req);
}
