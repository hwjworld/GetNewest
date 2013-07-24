package com.huawen.publishapp.data.webservice.bean;

/**
 * ����Ļ�ȡ��Ʒ�ĺ��嵵�Ķ�̬����
 * @author xieyan
 *
 */
public class StkCommDetailDynDataExBean {

	private String m_btSpFlag ;//һЩ���Ʊ�ʾ , Ŀǰ 0x01λ(�Ƿ���Ч��Ʒ) �� 0x02λ��1 ��ͨ��Ʒ��0 ָ����
	private String m_strCode ;//��Ʒ����
	private String m_strName ;//��Ʒ����
	private String m_strClose ;//��Ʒ����
	private String m_strOpen ; //��Ʒ��
	private String m_strNowPrice ;//�ּ�
	private String m_strHighPrice ;//��߼�
	private String m_strLowPrice ;//��ͼ�
	private String m_strVolume ;//�ɽ�������λ ��[�۹ɵ�λΪ ��]
	private String m_strAmount ;//�ɽ�����λ Ԫ��������λС��[�۹�Ϊ Ԫ�۱�]
	private String m_strLastVolume ;//����
	private String m_strRiseFallPrice ;//�����µ��۸�
	private String m_strRiseFallRate ;//�����µ����� *100 , ��λ %
	private String m_strDataNowTime ;//���ݵ�ʱ��
	private String m_strAvgPrice=""; //����
	private String m_strQRR = "" ;//����QuantityRelativeRatio
	private String m_strShiYing = "" ;//��ӯ��
	private String m_strWeiBi = "" ;//ί��
	private String[] m_strBidPrice ;//�嵵���̼۸�
	private String[] m_strBidVolume ;//�嵵������
	private String[] m_strAskPrice ;//�嵵���̼�
	private String[] m_strAskVolume ;//�嵵������
	//===һ�������Ա�������������ӵ�����
	private String m_strOtherInfo1 ; //������Ϣһ
	private String m_strOtherInfo2 ; //������Ϣ��
	private String m_strAllBidVolume ;//����
	private String m_strAllAskVolume ;//����
	private String m_iGroup ;			//������ϵͳ���
	
	/**
	 * @return m_btSpFlag
	 */
	public String getM_btSpFlag() {
		return m_btSpFlag;
	}
	/**
	 * @param spFlag Ҫ���õ� m_btSpFlag
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
	 * @param group Ҫ���õ� m_iGroup
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
	 * @param allAskVolume Ҫ���õ� m_strAllAskVolume
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
	 * @param allBidVolume Ҫ���õ� m_strAllBidVolume
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
	 * @param amount Ҫ���õ� m_strAmount
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
	 * @param askPrice Ҫ���õ� m_strAskPrice
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
	 * @param askVolume Ҫ���õ� m_strAskVolume
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
	 * @param avgPrice Ҫ���õ� m_strAvgPrice
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
	 * @param bidPrice Ҫ���õ� m_strBidPrice
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
	 * @param bidVolume Ҫ���õ� m_strBidVolume
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
	 * @param close Ҫ���õ� m_strClose
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
	 * @param code Ҫ���õ� m_strCode
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
	 * @param dataNowTime Ҫ���õ� m_strDataNowTime
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
	 * @param highPrice Ҫ���õ� m_strHighPrice
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
	 * @param lastVolume Ҫ���õ� m_strLastVolume
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
	 * @param lowPrice Ҫ���õ� m_strLowPrice
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
	 * @param name Ҫ���õ� m_strName
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
	 * @param nowPrice Ҫ���õ� m_strNowPrice
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
	 * @param open Ҫ���õ� m_strOpen
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
	 * @param otherInfo1 Ҫ���õ� m_strOtherInfo1
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
	 * @param otherInfo2 Ҫ���õ� m_strOtherInfo2
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
	 * @param m_strqrr Ҫ���õ� m_strQRR
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
	 * @param riseFallPrice Ҫ���õ� m_strRiseFallPrice
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
	 * @param riseFallRate Ҫ���õ� m_strRiseFallRate
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
	 * @param shiYing Ҫ���õ� m_strShiYing
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
	 * @param volume Ҫ���õ� m_strVolume
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
	 * @param weiBi Ҫ���õ� m_strWeiBi
	 */
	public void setM_strWeiBi(String weiBi) {
		m_strWeiBi = weiBi;
	}

}
