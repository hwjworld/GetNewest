package com.huawen.common;

public class CommonDataForWS {

	//public static final String QL_WIN_URL = "http://202.108.218.70/MarketService/qlStockServiceAll.asmx";
	public static final String QL_WIN_URL = "http://58.68.134.67/MarketService/qlStockServiceAll.asmx";
	public static final String QL_LIN_URL = "http://10.39.10.162/MarketService/qlStockServiceAll.asmx";
	public static final String SH_STOCK_INDEX = "000001";		//��ָ֤������
	public static final String SZ_STOCK_INDEX = "399001";		//��ָ֤������
	public static final String TH_STOCK_INDEX = "000300";		//����300����
	public static final String HS_STOCK_INDEX = "999999";		//����ָ������
	public static final String GQ_STOCK_INDEX = "999998";		//����ָ������
	public static final String SH_B_STOCK_INDEX = "000003";     //��֤B�ɴ���
	public static final String ZXB_STOCK_INDEX  = "399101";		//��С�����
	public static final String SB_STOCK_INDEX  = "399003";		//��B����
	public static final String GZ_STOCK_INDEX  = "000012";		//��ծ����
	public static final String QZ_STOCK_INDEX  = "000013";		//��ծ����
	public static final String HSCCI_STOCK_INDEX = "999986";	//���ָ��
	public static final String GEM_STOCK_INDEX = "999987";		//��ҵ�����
	
	//clj ������֤����ָ��|����ָ��
	public static final String SZ_FUND_INDEX = "000011";	//��֤����ָ��
	
	public static final String FUND_INDEX = "399305";		//����ָ��
	
	
	public static final String SOAPACTION_STOCKTECHPIC = "getStockDynPic";	//��Ʒ��ʱ����ͼ��soapaction
	public static final String NODENAME_STOCKTECHPIC = "getStockDynPicResult";//��Ʒ��ʱ����ͼ�Ľڵ�����
	
	public static final String SOAPACTION_STOCKDYNPICEX = "getStockDynPicEx";	//��Ʒ��ʱ����ͼ��soapaction
	public static final String NODENAME_STOCKDYNPICEX = "getStockDynPicExResult";//��Ʒ��ʱ����ͼ�Ľڵ�����
	
	public static final String SOAPACTION_STOCKTECHPICEX = "getStockTechPicEx";	//��ȡ��Ʒ��K��ͼ����ǿ�ͺ�������soapaction
	public static final String NODENAME_STOCKTECHPICEX = "getStockTechPicExResult";//��ȡ��Ʒ��K��ͼ����ǿ�ͺ������Ľڵ�����
	
	public static final String SOAPACTION_IDXTRENDPIC = "getHomePageIdxTrendPic";	//ָ������ͼƬ��soapaction
	public static final String NODENAME_IDXTRENDPIC = "getHomePageIdxTrendPicResult";//ָ������ͼƬ�Ľڵ�����
	
	public static final String SOAPACTION_CUSTOMRPT = "getCustomRpt";  //ָ����Ʊ���ƶ���Ϣ��soapaction
	public static final String NODENAME_CUSTOMRPT = "getCustomRptResult";//ָ����Ʊ���ƶ���Ϣ�ķ�������
	
	public static final String SOAPACTION_STOCKDETAILDYNDATAEX = "getStockDetailDynDataEx";	//��̬���ݵ�soapaction
	public static final String NODENAME_STOCKDETAILDYNDATAEX = "getStockDetailDynDataExResult";//��̬���ݵĽڵ�����
	
	public static final String SOAPACTION_SELSTOCKLIST = "getSelStockList";//��̬���ݵ�soapaction
	public static final String NODENAME_SELSTOCKLIST = "getSelStockListResult";//��̬���ݵĽڵ�����
	
	public static final String SOAPACTION_GROUPNAME = "getOneGroup";//����ѯ��soapaction
	public static final String NODENAME_GROUPNAME = "getOneGroupResult";//����ѯ�Ľڵ�����
	
	public static final String SOAPACTION_BLOCKSTOCKCOUNT = "getSysBlockStockCount";//�������Ʒ�ĸ�����soapaction
	public static final String NODENAME_BLOCKSTOCKCOUNT = "getSysBlockStockCountResult";//�������Ʒ�ĸ����Ľڵ�����
	
	public static final String SOAPACTION_SYSBLOCKRPTONEPAGE = "getSysBlockRptOnePage";//�����Ϣ��soapaction
	public static final String NODENAME_SYSBLOCKRPTONEPAGE = "getSysBlockRptOnePageResult";//�����Ϣ�Ľڵ�����
	
	public static final String SOAPACTION_MULTIGROUPRPTONEPAGE = "getMultiGroupRptOnePage";//�������ݵ�soapaction
	public static final String NODENAME_MULTIGROUPRPTONEPAGE = "getMultiGroupRptOnePageResult";//�������ݵĽڵ�����
	
	public static final String SOAPACTION_MULTIGROUPRPTEXONEPAGE = "getMultiGroupRptExOnePage";//���������ݵ�soapaction
	public static final String NODENAME_MULTIGROUPRPTEXONEPAGE = "getMultiGroupRptExOnePageResult";//���������ݵĽڵ�����
	
	public static final String SOAPACTION_MULTIGROUPSTOCKSEXCOUNT = "getMultiGroupStocksExCount";//���������ݵ�soapaction
	public static final String NODENAME_MULTIGROUPSTOCKSEXCOUNT = "getMultiGroupStocksExCountResult";//���������ݵĽڵ�����
	
	public static final int CYCLETYPE_FIVE = 5;    //k��ͼ-5����
	public static final int CYCLETYPE_DAY = 4;    //k��ͼ-����
	public static final int CYCLETYPE_MONTH = 2;    //k��ͼ-����
	public static final int CYCLETYPE_WEEK = 3;    //k��ͼ-����
	
	public static String getQLPath() {
		String opsysType = System.getProperty("os.name");
		if (opsysType != null && opsysType.contains("Windows")) {
			return QL_WIN_URL;
		}
		return QL_LIN_URL;
	}
}
