package com.region.moudles.schedule;

import java.util.Date;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 	日志文件的压缩 和 删除
 * @author Administrator
 */

@Component
@Configuration      
@EnableScheduling 
public class SyncDataSchedule {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Scheduled(cron="0 0 0 * * ?")
	private void syncCustomer() {    
    	try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("/blt/region/kettle/customer.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			logger.info(new Date() + "档案同步成功");
		}catch(Exception e) {
			this.syncCustomer();
		}
	}
	
	@Scheduled(cron="0 1 0 * * ?")
	private void syncCheck() {    
    	try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("/blt/region/kettle/check.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			logger.info(new Date() + "体检同步成功");
		}catch(Exception e) {
			this.syncCheck();
		}
	}
	@Scheduled(cron="0 2 0 * * ?")
	private void syncFollow() {    
    	try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("/blt/region/kettle/follow.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			logger.info(new Date() + "随访同步成功");
		}catch(Exception e) {
			this.syncFollow();
		}
	}
	@Scheduled(cron="0 3 0 * * ?")
	private void syncSign(){    
    	try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("/blt/region/kettle/sign.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			logger.info(new Date() + "签约同步成功");
		}catch(Exception e) {
			this.syncSign();
		}
	}
	@Scheduled(cron="0 4 0 * * ?")
	private void syncPackageProject(){    
    	try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("/blt/region/kettle/packageProject.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			logger.info(new Date() + "服务包服务项同步成功");
		}catch(Exception e) {
			this.syncPackageProject();
		}
	}
	@Scheduled(cron="0 5 0 * * ?")
	private void syncTeam() {    
    	try {
			//初始化
	        KettleEnvironment.init();
	        //将filename存储的数据加载到trans对象中
	        TransMeta transMeta = new TransMeta("/blt/region/kettle/team.ktr");
	        Trans trans = new Trans(transMeta);
	        //启动
	        trans.execute(null);
	        //等待文件的运行完成
	        trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
			}
			logger.info(new Date() + "团队同步成功");
		}catch(Exception e) {
			this.syncTeam();
		}
	}
	/*
	 * @Scheduled(cron="0 6 0 * * ?") private void syncHospitalJc(){ try { //初始化
	 * KettleEnvironment.init(); //将filename存储的数据加载到trans对象中 TransMeta transMeta =
	 * new TransMeta("E:/package/kettle/定时/住院检查定时.ktr"); Trans trans = new
	 * Trans(transMeta); //启动 trans.execute(null); //等待文件的运行完成
	 * trans.waitUntilFinished(); if (trans.getErrors() != 0) {
	 * System.out.println("Error"); } logger.info(new Date() + "住院检查同步成功");
	 * }catch(Exception e) { this.syncHospitalJc(); } }
	 * 
	 * @Scheduled(cron="0 7 0 * * ?") private void syncBasy(){ try { //初始化
	 * KettleEnvironment.init(); //将filename存储的数据加载到trans对象中 TransMeta transMeta =
	 * new TransMeta("E:/package/kettle/定时/病案首页定时.ktr"); Trans trans = new
	 * Trans(transMeta); //启动 trans.execute(null); //等待文件的运行完成
	 * trans.waitUntilFinished(); if (trans.getErrors() != 0) {
	 * System.out.println("Error"); } logger.info(new Date() + "病案首页同步成功");
	 * }catch(Exception e) { this.syncBasy(); } }
	 * 
	 * @Scheduled(cron="0 8 0 * * ?") private void syncOutrf(){ try { //初始化
	 * KettleEnvironment.init(); //将filename存储的数据加载到trans对象中 TransMeta transMeta =
	 * new TransMeta("E:/package/kettle/定时/门诊处方定时.ktr"); Trans trans = new
	 * Trans(transMeta); //启动 trans.execute(null); //等待文件的运行完成
	 * trans.waitUntilFinished(); if (trans.getErrors() != 0) {
	 * System.out.println("Error"); } logger.info(new Date() + "门诊处方同步成功");
	 * }catch(Exception e) { this.syncOutrf(); } }
	 * 
	 * @Scheduled(cron="0 9 0 * * ?") private void syncOut(){ try { //初始化
	 * KettleEnvironment.init(); //将filename存储的数据加载到trans对象中 TransMeta transMeta =
	 * new TransMeta("E:/package/kettle/定时/门诊定时.ktr"); Trans trans = new
	 * Trans(transMeta); //启动 trans.execute(null); //等待文件的运行完成
	 * trans.waitUntilFinished(); if (trans.getErrors() != 0) {
	 * System.out.println("Error"); } logger.info(new Date() + "门诊同步成功");
	 * }catch(Exception e) { this.syncOut(); } }
	 * 
	 * @Scheduled(cron="0 10 0 * * ?") private void syncOutJc(){ try { //初始化
	 * KettleEnvironment.init(); //将filename存储的数据加载到trans对象中 TransMeta transMeta =
	 * new TransMeta("E:/package/kettle/定时/门诊检查定时.ktr"); Trans trans = new
	 * Trans(transMeta); //启动 trans.execute(null); //等待文件的运行完成
	 * trans.waitUntilFinished(); if (trans.getErrors() != 0) {
	 * System.out.println("Error"); } logger.info(new Date() + "门诊检查同步成功");
	 * }catch(Exception e) { this.syncOutJc(); } }
	 * 
	 * @Scheduled(cron="0 11 0 * * ?") private void syncOutCost(){ try { //初始化
	 * KettleEnvironment.init(); //将filename存储的数据加载到trans对象中 TransMeta transMeta =
	 * new TransMeta("E:/package/kettle/定时/门诊结算定时.ktr"); Trans trans = new
	 * Trans(transMeta); //启动 trans.execute(null); //等待文件的运行完成
	 * trans.waitUntilFinished(); if (trans.getErrors() != 0) {
	 * System.out.println("Error"); } logger.info(new Date() + "门诊结算同步成功");
	 * }catch(Exception e) { this.syncOutCost(); } }
	 * 
	 * @Scheduled(cron="0 12 0 * * ?") private void syncHospital(){ try { //初始化
	 * KettleEnvironment.init(); //将filename存储的数据加载到trans对象中 TransMeta transMeta =
	 * new TransMeta("E:/package/kettle/定时/住院定时.ktr"); Trans trans = new
	 * Trans(transMeta); //启动 trans.execute(null); //等待文件的运行完成
	 * trans.waitUntilFinished(); if (trans.getErrors() != 0) {
	 * System.out.println("Error"); } logger.info(new Date() + "住院同步成功");
	 * }catch(Exception e) { this.syncHospital(); } }
	 * 
	 * @Scheduled(cron="0 12 0 * * ?") private void syncHospitalOrder(){ try { //初始化
	 * KettleEnvironment.init(); //将filename存储的数据加载到trans对象中 TransMeta transMeta =
	 * new TransMeta("E:/package/kettle/hospitalOrder.ktr"); Trans trans = new
	 * Trans(transMeta); //启动 trans.execute(null); //等待文件的运行完成
	 * trans.waitUntilFinished(); if (trans.getErrors() != 0) {
	 * System.out.println("Error"); } logger.info(new Date() + "住院医嘱同步成功");
	 * }catch(Exception e) { this.syncHospital(); } }
	 * 
	 * @Scheduled(cron="0 14 0 * * ?") private void syncQualityData(){ try { //初始化
	 * KettleEnvironment.init(); //将filename存储的数据加载到trans对象中 TransMeta transMeta =
	 * new TransMeta("E:/package/kettle/定时/质控数据定时.ktr"); Trans trans = new
	 * Trans(transMeta); //启动 trans.execute(null); //等待文件的运行完成
	 * trans.waitUntilFinished(); if (trans.getErrors() != 0) {
	 * System.out.println("Error"); } logger.info(new Date() + "质控数据定时同步成功");
	 * }catch(Exception e) { this.syncHospital(); } }
	 */
}
