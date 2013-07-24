package com.huawen.publishapp.data.webservice.bean;

public class StockFilterResultBean {
	
	public String iReturnCount ; //总共返回多少条内容
	
	public String[] stocksRlt;// 实际返回的商品数，格式为 商品市场,代码,商品名

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
