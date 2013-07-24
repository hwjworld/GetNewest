package com.huawen.common;

import java.util.*;
import java.io.*;
import java.text.*;

/**
 * 应用程序写日志文件类
 * @author wang hongwei
 *
 */
public class AppLogger {
    private FileOutputStream fos;
    private String logFilePath;

    //logfilePath为日志文件存放路径，prefix为日志文件前缀
    public AppLogger() {
		this.fos = null;
		this.logFilePath = "logs/AppLogger.log";
        return;
    }

	public AppLogger(String fileName) {
		this.fos = null;
		this.logFilePath = "logs/" + fileName + ".log";
        return;
    }

	/**
	 * 将传入的字符串写入日志文件
	 * @param logStr, String 源字符串
	 * @return true, 写入成功；fase, 写入失败
	 */
    public boolean write(String logStr) {
        String buffer;
        SimpleDateFormat dateFormat;
        Date curDate = new Date ();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        buffer = "[" + dateFormat.format(curDate) + "] " + logStr + "\r\n";

        try {
			this.fos = new FileOutputStream(logFilePath, true);//以追加方式打开文件
            this.fos.write(buffer.getBytes());
            this.fos.close();
            this.fos = null;
        } catch (IOException ex) {
            System.out.println("写日志文件异常，出错信息：" + ex.getMessage());
            try {
            	if (this.fos != null) {
            		this.fos.close();
            		this.fos = null;
            	}
            } catch (IOException e) {
                System.out.println("关闭文件异常，出错信息：" + e.getMessage());
            }
            return false;
        }
        return true;
    }
}

