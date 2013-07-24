package com.huawen.common;

import java.util.*;
import java.io.*;
import java.text.*;

/**
 * Ӧ�ó���д��־�ļ���
 * @author wang hongwei
 *
 */
public class AppLogger {
    private FileOutputStream fos;
    private String logFilePath;

    //logfilePathΪ��־�ļ����·����prefixΪ��־�ļ�ǰ׺
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
	 * ��������ַ���д����־�ļ�
	 * @param logStr, String Դ�ַ���
	 * @return true, д��ɹ���fase, д��ʧ��
	 */
    public boolean write(String logStr) {
        String buffer;
        SimpleDateFormat dateFormat;
        Date curDate = new Date ();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        buffer = "[" + dateFormat.format(curDate) + "] " + logStr + "\r\n";

        try {
			this.fos = new FileOutputStream(logFilePath, true);//��׷�ӷ�ʽ���ļ�
            this.fos.write(buffer.getBytes());
            this.fos.close();
            this.fos = null;
        } catch (IOException ex) {
            System.out.println("д��־�ļ��쳣��������Ϣ��" + ex.getMessage());
            try {
            	if (this.fos != null) {
            		this.fos.close();
            		this.fos = null;
            	}
            } catch (IOException e) {
                System.out.println("�ر��ļ��쳣��������Ϣ��" + e.getMessage());
            }
            return false;
        }
        return true;
    }
}

