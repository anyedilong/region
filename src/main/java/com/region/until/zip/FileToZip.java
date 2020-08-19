package com.region.until.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 *	 将文件夹下面的文件
 * 	打包成zip压缩文件
 * @author tz
 */
public final class FileToZip {
 
	/**
	 * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
	 * @param sourceFilePath :待压缩的文件路径
	 * @param zipFilePath :压缩后存放路径
	 * @param fileName :压缩后文件的名称
	 * @return
	 */
	public static boolean fileToZip(String sourceFilePath,String zipFilePath,String fileName){
		boolean flag = false;
		File sourceFile = new File(sourceFilePath);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		
		if(sourceFile.exists() == false){
			System.out.println("待压缩的文件目录："+sourceFilePath+"不存在.");
		}else{
			try {
				File zipFile = new File(zipFilePath + "/" + fileName +".zip");
				if(zipFile.exists()){
					zipFile.delete();
				}
				File[] sourceFiles = sourceFile.listFiles();
				if(null == sourceFiles || sourceFiles.length<1){
					System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
				}else{
					fos = new FileOutputStream(zipFile);
					zos = new ZipOutputStream(new BufferedOutputStream(fos));
					byte[] bufs = new byte[1024*10];
					for(int i=0;i<sourceFiles.length;i++){
						//创建ZIP实体，并添加进压缩包
						ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
						zos.putNextEntry(zipEntry);
						//读取待压缩的文件并写进压缩包里
						fis = new FileInputStream(sourceFiles[i]);
						bis = new BufferedInputStream(fis, 1024*10);
						int read = 0;
						while((read=bis.read(bufs, 0, 1024*10)) != -1){
							zos.write(bufs,0,read);
						}
						//每次循环都会产生一个新的bis;如果这里不关闭bis,则bis不会被GC回收，占用了文件，删除时删不掉
						if(null != bis) bis.close();
					}
					flag = true;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally{
				//关闭流
				try {
					if(null != bis) bis.close();
					if(null != zos) zos.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
				//删除源文件
				deleteDir(sourceFilePath);
			}
		}
		return flag;
	}
	
	/**
	 * 	迭代删除文件夹
	 * @param dirPath 文件夹路径
	 */
	public static void deleteDir(String dirPath){
		 try {
            File file = new File(dirPath);
            // 当且仅当此抽象路径名表示的文件存在且 是一个目录时，返回 true
            if (!file.isDirectory()) {
                file.delete();
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(dirPath + "\\" + filelist[i]);
                    if (!delfile.isDirectory()) {
                        delfile.delete();
                    } else if (delfile.isDirectory()) {
                    	deleteDir(dirPath + "\\" + filelist[i]);
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
	}
	
	public static void main(String[] args){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar time = Calendar.getInstance();
		time.add(Calendar.DAY_OF_MONTH, -1);
		String fileName = sdf.format(time.getTime());
		
		String sourceFilePath = "F:/region/log" + "//" + fileName;
		String zipFilePath = "F:/region/log";
		
		boolean flag = FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName);
		if(flag){
			System.out.println("文件打包成功!");
		}else{
			System.out.println("文件打包失败!");
		}
	}
}
