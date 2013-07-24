package com.huawen.publishapp.data.webservice.bean;

/**
 * 扩充的获取商品的含五档的动态数据
 * @author xieyan
 *
 */
public class StkCommDetailDynDataExBean {

	private String m_btSpFlag ;//一些控制标示 , 目前 0x01位(是否有效商品) ， 0x02位（1 普通商品，0 指数）
	private String m_strCode ;//商品代码
	private String m_strName ;//商品名称
	private String m_strClose ;//商品昨收
	private String m_strOpen ; //商品今开
	private String m_strNowPrice ;//现价
	private String m_strHighPrice ;//最高价
	private String m_strLowPrice ;//最低价
	private String m_strVolume ;//成交量，单位 手[港股单位为 股]
	private String m_strAmount ;//成交金额，单位 元，保留两位小数[港股为 元港币]
	private String m_strLastVolume ;//现量
	private String m_strRiseFallPrice ;//上涨下跌价格
	private String m_strRiseFallRate ;//上涨下跌比率 *100 , 单位 %
	private String m_strDataNowTime ;//数据的时间
	private String m_strAvgPrice=""; //均价
	private String m_strQRR = "" ;//量比QuantityRelativeRatio
	private String m_strShiYing = "" ;//市盈率
	private String m_strWeiBi = "" ;//委比
	private String[] m_strBidPrice ;//五档买盘价格
	private String[] m_strBidVolume ;//五档买盘量
	private String[] m_strAskPrice ;//五档卖盘价
	private String[] m_strAskVolume ;//五档卖盘量
	//===一下五个成员变量属于新增加的内容
	private String m_strOtherInfo1 ; //附加信息一
	private String m_strOtherInfo2 ; //附加信息二
	private String m_strAllBidVolume ;//内盘
	private String m_strAllAskVolume ;//外盘
	private String m_iGroup ;			//所属的系统板块
	
	/**
	 * @return m_btSpFlag
	 */
	public String getM_btSpFlag() {
		return m_btSpFlag;
	}
	/**
	 * @param spFlag 要设置的 m_btSpFlag
	 */
	public void setM_btSpFlag(String spFlag) {
		m_btSpFlag = spFlag;
	}
	/**
	 * @return m_iGroup
	 */
	public String getM_iGroup() {
		return m_iGroup;
	}
	/**
	 * @param group 要设置的 m_iGroup
	 */
	public void setM_iGroup(String group) {
		m_iGroup = group;
	}
	/**
	 * @return m_strAllAskVolume
	 */
	public String getM_strAllAskVolume() {
		return m_strAllAskVolume;
	}
	/**
	 * @param allAskVolume 要设置的 m_strAllAskVolume
	 */
	public void setM_strAllAskVolume(String allAskVolume) {
		m_strAllAskVolume = allAskVolume;
	}
	/**
	 * @return m_strAllBidVolume
	 */
	public String getM_strAllBidVolume() {
		return m_strAllBidVolume;
	}
	/**
	 * @param allBidVolume 要设置的 m_strAllBidVolume
	 */
	public void setM_strAllBidVolume(String allBidVolume) {
		m_strAllBidVolume = allBidVolume;
	}
	/**
	 * @return m_strAmount
	 */
	public String getM_strAmount() {
		return m_strAmount;
	}
	/**
	 * @param amount 要设置的 m_strAmount
	 */
	public void setM_strAmount(String amount) {
		m_strAmount = amount;
	}
	/**
	 * @return m_strAskPrice
	 */
	public String[] getM_strAskPrice() {
		return m_strAskPrice;
	}
	/**
	 * @param askPrice 要设置的 m_strAskPrice
	 */
	public void setM_strAskPrice(String[] askPrice) {
		m_strAskPrice = askPrice;
	}
	/**
	 * @return m_strAskVolume
	 */
	public String[] getM_strAskVolume() {
		return m_strAskVolume;
	}
	/**
	 * @param askVolume 要设置的 m_strAskVolume
	 */
	public void setM_strAskVolume(String[] askVolume) {
		m_strAskVolume = askVolume;
	}
	/**
	 * @return m_strAvgPrice
	 */
	public String getM_strAvgPrice() {
		return m_strAvgPrice;
	}
	/**
	 * @param avgPrice 要设置的 m_strAvgPrice
	 */
	public void setM_strAvgPrice(String avgPrice) {
		m_strAvgPrice = avgPrice;
	}
	/**
	 * @return m_strBidPrice
	 */
	public String[] getM_strBidPrice() {
		return m_strBidPrice;
	}
	/**
	 * @param bidPrice 要设置的 m_strBidPrice
	 */
	public void setM_strBidPrice(String[] bidPrice) {
		m_strBidPrice = bidPrice;
	}
	/**
	 * @return m_strBidVolume
	 */
	public String[] getM_strBidVolume() {
		return m_strBidVolume;
	}
	/**
	 * @param bidVolume 要设置的 m_strBidVolume
	 */
	public void setM_strBidVolume(String[] bidVolume) {
		m_strBidVolume = bidVolume;
	}
	/**
	 * @return m_strClose
	 */
	public String getM_strClose() {
		return m_strClose;
	}
	/**
	 * @param close 要设置的 m_strClose
	 */
	public void setM_strClose(String close) {
		m_strClose = close;
	}
	/**
	 * @return m_strCode
	 */
	public String getM_strCode() {
		return m_strCode;
	}
	/**
	 * @param code 要设置的 m_strCode
	 */
	public void setM_strCode(String code) {
		m_strCode = code;
	}
	/**
	 * @return m_strDataNowTime
	 */
	public String getM_strDataNowTime() {
		return m_strDataNowTime;
	}
	/**
	 * @param dataNowTime 要设置的 m_strDataNowTime
	 */
	public void setM_strDataNowTime(String dataNowTime) {
		m_strDataNowTime = dataNowTime;
	}
	/**
	 * @return m_strHighPrice
	 */
	public String getM_strHighPrice() {
		return m_strHighPrice;
	}
	/**
	 * @param highPrice 要设置的 m_strHighPrice
	 */
	public void setM_strHighPrice(String highPrice) {
		m_strHighPrice = highPrice;
	}
	/**
	 * @return m_strLastVolume
	 */
	public String getM_strLastVolume() {
		return m_strLastVolume;
	}
	/**
	 * @param lastVolume 要设置的 m_strLastVolume
	 */
	public void setM_strLastVolume(String lastVolume) {
		m_strLastVolume = lastVolume;
	}
	/**
	 * @return m_strLowPrice
	 */
	public String getM_strLowPrice() {
		return m_strLowPrice;
	}
	/**
	 * @param lowPrice 要设置的 m_strLowPrice
	 */
	public void setM_strLowPrice(String lowPrice) {
		m_strLowPrice = lowPrice;
	}
	/**
	 * @return m_strName
	 */
	public String getM_strName() {
		return m_strName;
	}
	/**
	 * @param name 要设置的 m_strName
	 */
	public void setM_strName(String name) {
		m_strName = name;
	}
	/**
	 * @return m_strNowPrice
	 */
	public String getM_strNowPrice() {
		return m_strNowPrice;
	}
	/**
	 * @param nowPrice 要设置的 m_strNowPrice
	 */
	public void setM_strNowPrice(String nowPrice) {
		m_strNowPrice = nowPrice;
	}
	/**
	 * @return m_strOpen
	 */
	public String getM_strOpen() {
		return m_strOpen;
	}
	/**
	 * @param open 要设置的 m_strOpen
	 */
	public void setM_strOpen(String open) {
		m_strOpen = open;
	}
	/**
	 * @return m_strOtherInfo1
	 */
	public String getM_strOtherInfo1() {
		return m_strOtherInfo1;
	}
	/**
	 * @param otherInfo1 要设置的 m_strOtherInfo1
	 */
	public void setM_strOtherInfo1(String otherInfo1) {
		m_strOtherInfo1 = otherInfo1;
	}
	/**
	 * @return m_strOtherInfo2
	 */
	public String getM_strOtherInfo2() {
		return m_strOtherInfo2;
	}
	/**
	 * @param otherInfo2 要设置的 m_strOtherInfo2
	 */
	public void setM_strOtherInfo2(String otherInfo2) {
		m_strOtherInfo2 = otherInfo2;
	}
	/**
	 * @return m_strQRR
	 */
	public String getM_strQRR() {
		return m_strQRR;
	}
	/**
	 * @param m_strqrr 要设置的 m_strQRR
	 */
	public void setM_strQRR(String m_strqrr) {
		m_strQRR = m_strqrr;
	}
	/**
	 * @return m_strRiseFallPrice
	 */
	public String getM_strRiseFallPrice() {
		return m_strRiseFallPrice;
	}
	/**
	 * @param riseFallPrice 要设置的 m_strRiseFallPrice
	 */
	public void setM_strRiseFallPrice(String riseFallPrice) {
		m_strRiseFallPrice = riseFallPrice;
	}
	/**
	 * @return m_strRiseFallRate
	 */
	public String getM_strRiseFallRate() {
		return m_strRiseFallRate;
	}
	/**
	 * @param riseFallRate 要设置的 m_strRiseFallRate
	 */
	public void setM_strRiseFallRate(String riseFallRate) {
		m_strRiseFallRate = riseFallRate;
	}
	/**
	 * @return m_strShiYing
	 */
	public String getM_strShiYing() {
		return m_strShiYing;
	}
	/**
	 * @param shiYing 要设置的 m_strShiYing
	 */
	public void setM_strShiYing(String shiYing) {
		m_strShiYing = shiYing;
	}
	/**
	 * @return m_strVolume
	 */
	public String getM_strVolume() {
		return m_strVolume;
	}
	/**
	 * @param volume 要设置的 m_strVolume
	 */
	public void setM_strVolume(String volume) {
		m_strVolume = volume;
	}
	/**
	 * @return m_strWeiBi
	 */
	public String getM_strWeiBi() {
		return m_strWeiBi;
	}
	/**
	 * @param weiBi 要设置的 m_strWeiBi
	 */
	public void setM_strWeiBi(String weiBi) {
		m_strWeiBi = weiBi;
	}

}
