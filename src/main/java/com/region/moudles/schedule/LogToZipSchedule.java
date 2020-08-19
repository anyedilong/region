package com.region.moudles.schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.region.until.zip.FileToZip;

/**
 * 	日志文件的压缩 和 删除
 * @author Administrator
 */

@Component
@Configuration      
@EnableScheduling 
public class LogToZipSchedule {

	@Value("${log.path}")
    private String logPath;
	
	//日志 按天进行压缩存储
	@Scheduled(cron="0 0 1 * * ?")
	private void logToZip() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar time = Calendar.getInstance();
		time.add(Calendar.DAY_OF_MONTH, -1);
		String fileName = sdf.format(time.getTime());
		
		String sourceFilePath = logPath + "//" + fileName;
		String zipFilePath = logPath;
		boolean flag = FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName);
		if(flag){ 
			System.out.println("文件打包成功!"); 
		}else{
			System.out.println("文件打包失败!"); 
		}
	}
}
