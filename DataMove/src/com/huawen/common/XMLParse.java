/**
 * @version 1.01 2007-09-19
 * @author Wang Hongwei
 */
package com.huawen.common;

import java.io.*;


/**
 *   Parse xml File.
 */
public class XMLParse {

	private String confFileContent;

	/**
	 * Constructs the ConfParse with the specified conf file name string.
	 * @param confFileName the xml conf File name to parse
	 * @exception Exception if open file error or read error
	 */
	public XMLParse(String confFileName) throws Exception {
		try {
			FileInputStream confInputStream = new FileInputStream(confFileName);
			int readLength = confInputStream.available();
			byte[] readByte = new byte[readLength];
			confInputStream.read(readByte);
			this.confFileContent = new String(readByte);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Constructs the ConfParse with the specified conf file content FileInputStream.
	 * @param confInputStream the xml conf FileInputStream to parse
	 * @exception Exception if read error
	 */
	public XMLParse(FileInputStream confInputStream) throws Exception {
		try {
			int readLength = confInputStream.available();
			byte[] readByte = new byte[readLength];
			confInputStream.read(readByte);
			this.confFileContent = new String(readByte);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Constructs the ConfParse with the specified conf file content byte[].
	 * @param confByte the xml conf content byte[] to parse
	 * 
	 */
	public XMLParse(byte[] confByte) {
		this.confFileContent = new String(confByte);
	}

	/**
	 * Constructs the ConfParse with the specified conf file content string.
	 * @param contentStr the xml conf content string to parse
	 * @param sFlag no use, is only distinguish with ConfParse(String)
	 */
	public XMLParse(String contentStr, int sFlag) {
		this.confFileContent = contentStr;
	}

	/**
	 * Get the named mark value as a string.
	 * @param markName the mark name in xml conf file
	 * @return the value of the mark as a string, or null if not found
	 */
	public String getParseValue(String markName) {
		if (markName == null || markName.length() <= 0) {
			return null;
		}
		String beginMark = "<" + markName + ">";
		String endMark = "</" + markName + ">";
		int bIndex = confFileContent.indexOf(beginMark) + beginMark.length();
		int eIndex = confFileContent.indexOf(endMark);
		if (bIndex < 0 || eIndex < 0) {
			return null;
		}
		return confFileContent.substring(bIndex, eIndex);
	}
	
	/**
	 * Get the named mark value as a string.
	 * @param markName the mark name in xml conf file
	 * @return the value of the mark as a string, or null if not found
	 */
	public String getComplexValue(String markName) {
		if (markName == null || markName.length() <= 0) {
			return null;
		}
		// <string xmlns="http://tempuri.org/">0</string>
		String beginMark = "<" + markName;
		String endMark = "</" + markName + ">";
		int tmpBIndex = confFileContent.indexOf(beginMark) + beginMark.length();
		int bIndex = confFileContent.indexOf('>', tmpBIndex) + 1;
		int eIndex = confFileContent.indexOf(endMark);
		if (bIndex < 0 || eIndex < 0) {
			return null;
		}
		return confFileContent.substring(bIndex, eIndex);
	}
}

