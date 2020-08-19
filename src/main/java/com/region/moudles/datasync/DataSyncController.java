package com.region.moudles.datasync;


import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.region.moudles.common.controller.BaseController;

/**
 * @ClassName: DataSyncController
 * @Description: 老版公卫库数据同步到区域化库
 * @author Administrator
 * @date 2020年5月20日
 */
@RestController
@RequestMapping("/data/sync")
public class DataSyncController extends BaseController {

	/**
	 * @Description: 档案
	 * @param @return
	 * @throws
	 */
	@RequestMapping("customer")
	public String syncCustomer() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\customer.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	
	/**
	 * @Description: 体检
	 * @param @return
	 * @throws
	 */
	@RequestMapping("check")
	public String syncCheck() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\check.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	
	/**
	 * @Description: 随访
	 * @param @return
	 * @throws
	 */
	@RequestMapping("follow")
	public String syncFollow() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\follow.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	
	/**
	 * @Description: 签约
	 * @param @return
	 * @throws
	 */
	@RequestMapping("sign")
	public String syncSign() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\sign.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	
	/**
	 * @Description: 服务包与服务项
	 * @param @return
	 * @throws
	 */
	@RequestMapping("packageProject")
	public String syncPackageProject() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\packageProject.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	
	/**
	 * @Description: 病案首页
	 * @param @return
	 * @throws
	 */
	@RequestMapping("basyHospital")
	public String basyHospital() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\病案首页.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	
	/**
	 * @Description: 门诊结算
	 * @param @return
	 * @throws
	 */
	@RequestMapping("outptionJS")
	public String outptionJS() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\结算.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	
	/**
	 * @Description: 门诊
	 * @param @return
	 * @throws
	 */
	@RequestMapping("outptionInfo")
	public String outptionInfo() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\门诊.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	
	/**
	 * @Description: 门诊处方
	 * @param @return
	 * @throws
	 */
	@RequestMapping("outptionRf")
	public String outptionRf() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\门诊处方.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	
	/**
	 * @Description: 门诊检查
	 * @param @return
	 * @throws
	 */
	@RequestMapping("outptionJc")
	public String outptionJc() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\门诊检查.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	/**
	 * @Description:住院信息
	 * @param @return
	 * @throws
	 */
	@RequestMapping("hospitalInfo")
	public String hospitalInfo() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\住院.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	/**
	 * @Description:住院检查
	 * @param @return
	 * @throws
	 */
	@RequestMapping("hospitalJc")
	public String hospitalJc() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\住院检查.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	/**
	 * @Description:住院医嘱
	 * @param @return
	 * @throws
	 */
	@RequestMapping("hospitalOrder")
	public String hospitalOrder() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\hospitalOrder.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
	/**
	 * @Description:同步医生信息
	 * @param @return
	 * @throws
	 */
	@RequestMapping("syncDoctor")
	public String syncDoctor() {
		try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("E:\\package\\kettle\\syncdoctor.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			return "同步成功";
		}catch(Exception e) {
			e.printStackTrace();
			return "同步失败！！！";
		}
	}
}
