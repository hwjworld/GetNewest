package com.huawen.publishapp.data.webservice.bean;

public class StockFilterResultBean {
	
	public String iReturnCount ; //�ܹ����ض���������
	
	public String[] stocksRlt;// ʵ�ʷ��ص���Ʒ������ʽΪ ��Ʒ�г�,����,��Ʒ��

	public String getIReturnCount() {
		return iReturnCount;
	}

	public void setIReturnCount(String string) {
		iReturnCount = string;
	}

	public String[] getStocksRlt() {
		return stocksRlt;
	}

	public void setStocksRlt(String[] stocksRlt) {
		this.stocksRlt = stocksRlt;
	}




}
