package com.huawen.common;

public class CommonDataForWS {

	//public static final String QL_WIN_URL = "http://202.108.218.70/MarketService/qlStockServiceAll.asmx";
	public static final String QL_WIN_URL = "http://58.68.134.67/MarketService/qlStockServiceAll.asmx";
	public static final String QL_LIN_URL = "http://10.39.10.162/MarketService/qlStockServiceAll.asmx";
	public static final String SH_STOCK_INDEX = "000001";		//上证指数代码
	public static final String SZ_STOCK_INDEX = "399001";		//深证指数代码
	public static final String TH_STOCK_INDEX = "000300";		//沪深300代码
	public static final String HS_STOCK_INDEX = "999999";		//恒生指数代码
	public static final String GQ_STOCK_INDEX = "999998";		//国企指数代码
	public static final String SH_B_STOCK_INDEX = "000003";     //上证B股代码
	public static final String ZXB_STOCK_INDEX  = "399101";		//中小板代码
	public static final String SB_STOCK_INDEX  = "399003";		//深B代码
	public static final String GZ_STOCK_INDEX  = "000012";		//国债代码
	public static final String QZ_STOCK_INDEX  = "000013";		//企债代码
	public static final String HSCCI_STOCK_INDEX = "999986";	//红筹指数
	public static final String GEM_STOCK_INDEX = "999987";		//创业板代码
	
	//clj 新增上证基金指数|基金指数
	public static final String SZ_FUND_INDEX = "000011";	//上证基金指数
	
	public static final String FUND_INDEX = "399305";		//基金指数
	
	
	public static final String SOAPACTION_STOCKTECHPIC = "getStockDynPic";	//商品即时走势图的soapaction
	public static final String NODENAME_STOCKTECHPIC = "getStockDynPicResult";//商品即时走势图的节点名称
	
	public static final String SOAPACTION_STOCKDYNPICEX = "getStockDynPicEx";	//商品即时走势图的soapaction
	public static final String NODENAME_STOCKDYNPICEX = "getStockDynPicExResult";//商品即时走势图的节点名称
	
	public static final String SOAPACTION_STOCKTECHPICEX = "getStockTechPicEx";	//获取商品的K线图（增强型函数）的soapaction
	public static final String NODENAME_STOCKTECHPICEX = "getStockTechPicExResult";//获取商品的K线图（增强型函数）的节点名称
	
	public static final String SOAPACTION_IDXTRENDPIC = "getHomePageIdxTrendPic";	//指数走势图片的soapaction
	public static final String NODENAME_IDXTRENDPIC = "getHomePageIdxTrendPicResult";//指数走势图片的节点名称
	
	public static final String SOAPACTION_CUSTOMRPT = "getCustomRpt";  //指定股票的制定信息的soapaction
	public static final String NODENAME_CUSTOMRPT = "getCustomRptResult";//指定股票的制定信息的返回数据
	
	public static final String SOAPACTION_STOCKDETAILDYNDATAEX = "getStockDetailDynDataEx";	//动态数据的soapaction
	public static final String NODENAME_STOCKDETAILDYNDATAEX = "getStockDetailDynDataExResult";//动态数据的节点名称
	
	public static final String SOAPACTION_SELSTOCKLIST = "getSelStockList";//动态数据的soapaction
	public static final String NODENAME_SELSTOCKLIST = "getSelStockListResult";//动态数据的节点名称
	
	public static final String SOAPACTION_GROUPNAME = "getOneGroup";//板块查询的soapaction
	public static final String NODENAME_GROUPNAME = "getOneGroupResult";//板块查询的节点名称
	
	public static final String SOAPACTION_BLOCKSTOCKCOUNT = "getSysBlockStockCount";//板块中商品的个数的soapaction
	public static final String NODENAME_BLOCKSTOCKCOUNT = "getSysBlockStockCountResult";//板块中商品的个数的节点名称
	
	public static final String SOAPACTION_SYSBLOCKRPTONEPAGE = "getSysBlockRptOnePage";//板块信息的soapaction
	public static final String NODENAME_SYSBLOCKRPTONEPAGE = "getSysBlockRptOnePageResult";//板块信息的节点名称
	
	public static final String SOAPACTION_MULTIGROUPRPTONEPAGE = "getMultiGroupRptOnePage";//报表内容的soapaction
	public static final String NODENAME_MULTIGROUPRPTONEPAGE = "getMultiGroupRptOnePageResult";//报表内容的节点名称
	
	public static final String SOAPACTION_MULTIGROUPRPTEXONEPAGE = "getMultiGroupRptExOnePage";//板块组合内容的soapaction
	public static final String NODENAME_MULTIGROUPRPTEXONEPAGE = "getMultiGroupRptExOnePageResult";//板块组合内容的节点名称
	
	public static final String SOAPACTION_MULTIGROUPSTOCKSEXCOUNT = "getMultiGroupStocksExCount";//板块组合内容的soapaction
	public static final String NODENAME_MULTIGROUPSTOCKSEXCOUNT = "getMultiGroupStocksExCountResult";//板块组合内容的节点名称
	
	public static final int CYCLETYPE_FIVE = 5;    //k线图-5分钟
	public static final int CYCLETYPE_DAY = 4;    //k线图-日线
	public static final int CYCLETYPE_MONTH = 2;    //k线图-周线
	public static final int CYCLETYPE_WEEK = 3;    //k线图-周线
	
	public static String getQLPath() {
		String opsysType = System.getProperty("os.name");
		if (opsysType != null && opsysType.contains("Windows")) {
			return QL_WIN_URL;
		}
		return QL_LIN_URL;
	}
}
