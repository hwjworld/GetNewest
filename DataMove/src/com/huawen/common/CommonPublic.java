package com.huawen.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @author wang hongwei
 * 
 * ͨ�ó���
 */
public class CommonPublic {
	public static final boolean isDebug = true;
	
	public static final int INIT_DICTIONARY_ERROR = -4; //��ʼ���ִ��ֵ�ʧ��
	public static final int CREATE_HANDLE_ERROR = -5; //�����ִʾ��ʧ��
	public static final int INIT_USER_DICT_ERROR = -6; //��ʼ���û��ִ��ֵ�ʧ��
	public static final int SEGMENT_ERROR = -7; //�ִ�ʧ��
	
	public static final int HAVE_NO_THIS_USER = -10; // û�д��û�
	public static final int USER_NAME_INVALID = -11; // ��Ч�û���
	public static final int USER_PASSWORD_ERROR = -12; // �������
	public static final int DOUBLE_PASSWORD_ERROR = -13; // �û�������������벻һ��
	public static final int USER_LOGIN_TIMEOUT = -14; // �û���¼��ʱ
	public static final int DB_ERROR = -16; // ���ݿ����
	public static final int USER_HAVE_REGISGERED = -17; // �û���ע���
	public static final int LOGIN_TIMES_TOO_MORE = -18; // �û���¼��������
	public static final int HAVE_NO_PRIVILEGE = -19; // �û�û�д�ģ���ʹ��Ȩ��
	public static final int SYSTEM_ERROR = -100; // ϵͳ����
	public static final int PARAMETERS_ERROR = -101; // ��������

	//����������¼��
	public static final String IMPORT_CONDITION = "biz_data_center.import_condition";
	//����������Ϣ�������Դ��SRC_ARTICLEINFO
	public static final String ARTICLE_INFO = "biz_data_center.article_info";
	//����������Ϣ�����
	public static final String ARTICLE_INFO_HIS = "biz_data_center.article_info_his";
	//��Դ��׼������Ϣ��
	public static final String SOURCE_INFO = "biz_base.source_info";
	//��Դ������Ϣ��
	public static final String SOURCE_INFO_ALIAS = "biz_base.source_info_alias";
	//URL��Ϣ��
	public static final String DATA_DOWNURL = "info_source.dbo.DATA_DOWNURL";
	//����Դ��
	public static final String DATA_SOURCE = "info_source.dbo.data_source";
	
	//������Դ����URL��
	public static final String NEWS_CHILDSITE = "fin_info_source.news_childsite";
	//����ϢԴվ���
	public static final String NEWS_WEBSITE = "fin_info_source.news_website";
	//ץȡ�����޷�ƥ�����վ��URL�� news_error_listurl
	public static final String ERROR_LISTURL = "fin_info_source.news_error_listurl";
	
	
	//SQL Server����ץȡ��Ϣ��(360)
	public static final String SRC_ARTICLEINFO = "ComDataCenter.dbo.articleInfo";
	public static final String SRC_ARTICLEINFO_HIS = "ComDataCenter.dbo.articleInfoHis";
	//SQL Server����ץȡ��Ϣ��(GOV)
	public static final String SRC_ARTICLEINFO_NEWSPAPER =
		"ComDataCenter.dbo.articleInfoNewspaper";
	public static final String SRC_ARTICLEINFO_NEWSPAPER_HIS =
		"ComDataCenter.dbo.articleInfoNewspaperHis";
	//��˾��Ϣ��
	public static final String COMPANY_TABLE_NEW = "biz_base.company_info";  //��
	public static final String COMPANY_TABLE = "news.d_companyNew";
	//������Ϣ��
	public static final String PEOPLE_INFO = "biz_base.people_info"; //��������Ϣ��
	//����ְ���
	public static final String PEOPLE_DUTY = "biz_base.people_duty"; 
	public static final String PEOPLE_TABLE = "news.d_peopleNew";
	//��ҵ��Ϣ��
	public static final String TRADE_INFO_NEW = "biz_base.hy_info"; //��(�ֶ�����ͬ)
	public static final String TRADE_INFO = "news.D_HY";            //��
	//������Ϣ��
	public static final String ORGAN_INFO_NEW = "biz_base.org_info"; //�£��ֶ�����ͬ��
	public static final String ORGAN_INFO = "news.D_Organ";
	//����ģ����Ϣ��
	public static final String MODULE_INFO_NEW = "biz_base.hy_info_model"; //��
	public static final String MODULE_INFO = "news.data_hymodel";
	//������Ϣ��
	public static final String AREA_INFO = "news.D_Area";
	public static final String AREA_INFO_NEW = "biz_base.area_info"; //�µ�����Ϣ��
	// �ʲ��������Ա�
	public static final String ASSETTRANSACT_INFO = "biz_base.assetTransact_info";
	// �������Ա�
	public static final String PROF_INFO = "biz_base.prof_info";
	//��ʽ������Ϣ��
	public static final String NEWS_INFO = "news.news_info";
	// ���ŷ�ҳ������
	public static final String PAGINATION_RELATION = "news.pagination_relation";
	//������ʽ������Ϣ��
	public static final String NEWS_INFO_CURRENT = "news.news_info_current";
	//��ʽ������Ϣ��
	public static final String NEWS_INFO_OTHER = "biz_news.news_info_other";
	//NEWS_OPERATION
	public static final String NEWS_OP = "news.news_operation";
	//����ͳ�ƽ����Ϣ��
	public static final String PER_STATISTIC = "business.statistic_personality";
	//ͳ�Ʊ����Ϣ��
	public static final String STATISTIC_FLAG = "biz_base.statistic_flag";
	//���ž�̬����¼��
	public static final String NEWS_STATIC_RECORD = "news.news_static_record";
	//���ž�̬������
	public static final String NEWS_STATIC_TYPE = "news.news_static_type";
	//����lucene������¼��
	public static final String NEWS_IDX_RECORD = "news.idx_record";
	//��ɾ���ļ���¼��
	public static final String ARTFILE_DELETE_RECORD = "news.artfile_delete_record";

	//��������ݱ�---MySQL
	public static final String MYSQL_NSRELEASELIB = "fin_web_paper.NSRELEASELIB";
	
	public static final String MYSQL_PAGEINFO = "fin_web_paper.PAGEINFO";
	public static final String MYSQL_PAGE_ARTICLE = "fin_web_paper.PAGE_ARTICLE";
	//��������ݱ�---Oracle
	public static final String ORACLE_NSRELEASELIB = "NSRELEASELIB";
	//��������ݱ�---Oracle
	public static final String ORACLE_PAGEINFO = "PAGEINFO";
	
	public static final String ORACLE_PAGE_ARTICLE = "PAGE_ARTICLE";
	
	// ���������
	public static final String IDX_RECORD = "news.idx_record";
	// �������ݱ�
	public static final String IDX_TABLE_CONF = "news.idx_table_conf";
	// SQL Server blog_data_center ��������������ץȡ����������Ϣ��
	public static final String SQLSERVER_BLOG_ARTICLE = "blog_data_center.dbo.blog_article";
	// ������Ϣ��
	public static final String BLOG_ARTICLE = "blog_data_center.blog_article";
	// ��Ϣ��ʷ��
	public static final String BLOG_ARTICLE_HIS = "blog_data_center.blog_article_his";
	// ����վ���
	public static final String BLOG_WEBSITE = "fin_info_source.blog_website";
	// ���Ͷ��������
	public static final String BLOG_CATEGORYTOW = "fin_info_source.blog_categorytwo";
	// ���Ϳռ��
	public static final String BLOG_CHILDSITE = "fin_info_source.blog_childsite";
	// ���͹ؼ���
	public static final String BLOG_KEYWORDS = "fin_info_source.keywords";
	// ����δƥ��url��
	public static final String BLOG_ERROR_LISTURL = "fin_info_source.blog_error_listurl";
	
	// SQL Server forum_data_center ��̳����������ץȡ��̳������Ϣ��
	public static final String SQLSERVER_FORUM_ARTICLE = "forum_data_center.dbo.forum_article";
	// ��̳��Ϣ��
	public static final String FORUM_ARTICLE = "forum_data_center.forum_article";
	// ��Ϣ��ʷ��
	public static final String FORUM_ARTICLE_HIS = "forum_data_center.forum_article_his";
	// ��̳վ���
	public static final String FORUM_WEBSITE = "fin_info_source.forum_website";
	// ��̳���������
	public static final String FORUM_CATEGORYTOW = "fin_info_source.forum_categorytwo";
	// ��̳��վ���
	public static final String FORUM_CHILDSITE = "fin_info_source.forum_childsite";
	// ��̳δƥ��url��
	public static final String FORUM_ERROR_LISTURL = "fin_info_source.forum_error_listurl";
	
	// ��������ģ���
	public static final String MODULE_HOTARTICLE = "fin_web_site.module_hotarticle";
	
	/**
	 * ���ݴ����Ż�ȡ����������Ϣ
	 * @param errorCode
	 * @return 
	 */
	public static String getErrorInfo(int errorCode) {
		String errorInfo = "";
		switch (errorCode) {
			case INIT_DICTIONARY_ERROR:
				errorInfo = "��ʼ���ִ��ֵ�ʧ��";
				break;
			case CREATE_HANDLE_ERROR:
				errorInfo = "�����ִʾ��ʧ��";
				break;
			case SEGMENT_ERROR:
				errorInfo = "�ִ�ʧ��";
				break;
			case HAVE_NO_THIS_USER:
				errorInfo = "��������û�����Ч��";
				break;
			case USER_NAME_INVALID:
				errorInfo = "��������û�����Ч��";
				break;
			case USER_PASSWORD_ERROR:
				errorInfo = "�������������Ч��";
				break;
			case DOUBLE_PASSWORD_ERROR:
				errorInfo = "������������벻һֱ��";
				break;
			case USER_LOGIN_TIMEOUT:
				errorInfo = "����û�е�¼���¼�ѳ�ʱ��";
				break;
			case DB_ERROR:
				errorInfo = "���ݿ����";
				break;
			case USER_HAVE_REGISGERED:
				errorInfo = "�û���ע�����";
				break;
			case LOGIN_TIMES_TOO_MORE:
				errorInfo = "�ۼ�ʧ�ܴ������࣬���Ժ����µ�¼��";
				break;
			case HAVE_NO_PRIVILEGE:
				errorInfo = "�Բ�����û��ʹ�ô�ģ��ҳ���Ȩ�ޣ�";
				break;
			case SYSTEM_ERROR:
				errorInfo = "ϵͳ����";
				break;
			case PARAMETERS_ERROR:
				errorInfo = "������Ĳ�������ȷ��";
				break;
			default:
				;
		}
		return errorInfo;
	}
	
	/**
	 * �ж��ַ����Ƿ�������
	 * @author wang hongwei
	 * @param  srcStr String, Ҫ�жϵ�Դ�ַ���
	 * @return true, �����֣�false, ��������
	 */
	public static boolean isDigit(String srcStr) {
		if (srcStr == null) {
			return false;
		}
		int srcStrLenght = srcStr.length();
		if (srcStrLenght <= 0) {
			return false;
		}
		for (int i = 0; i < srcStrLenght; i++) {
			if (i == 0 && srcStr.charAt(i) == '-') {
				continue;
			}
			if (!Character.isDigit(srcStr.charAt(i))) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * ��������ʱ���֮������������ֻ�����죩
	 * @param beginCalendar
	 * @param endCalendar
	 * @return long, ��������
	 */
	public static long calculateDays(Calendar beginCalendar, Calendar endCalendar) {
		endCalendar.clear(Calendar.HOUR);
		endCalendar.clear(Calendar.MINUTE);
		endCalendar.clear(Calendar.SECOND);
		endCalendar.clear(Calendar.MILLISECOND);
		
		beginCalendar.clear(Calendar.HOUR);
		beginCalendar.clear(Calendar.MINUTE);
		beginCalendar.clear(Calendar.SECOND);
		beginCalendar.clear(Calendar.MILLISECOND);
		
		long timeLen = endCalendar.getTimeInMillis() - beginCalendar.getTimeInMillis();
		long days = timeLen / (24 * 60 * 60 * 1000);
		return days;
	}
	
	public static void debug(String str) {
		if (isDebug) {
			System.out.println(str);
		}
	}
	
	public static void debug(int intValue) {
		if (isDebug) {
			System.out.println(intValue);
		}
	}
	
	public static void debug(long longValue) {
		if (isDebug) {
			System.out.println(longValue);
		}
	}

	/**
	 * @author wang hongwei
	 * 
	 * ��¼����ʽ����Ϣ��¼�Ĳ������Ա�ͬ������������
	 * @param  recordId, Ҫ��¼��ID
	 * @param  opType, �������1-ɾ����2-�޸ģ�3-����
	 * @param  editer, �ύ�����ı༭����
	 * @param  conn, ���ݿ����Ӷ���
	 */
	public static void trackRecord(String[] recordId, int opType,
		String editer, Connection conn) {
		Statement stmt = null;
		try {
			if (recordId == null || recordId.length <= 0
				|| opType < 0
				|| editer == null || editer.length() <= 0
				|| conn == null) {
				return;
			}
			//����ͬ����¼��
			StringBuffer insertSql = new StringBuffer("INSERT INTO ");
			insertSql.append(CommonPublic.NEWS_OP);
			insertSql.append("(newsId,opType,editer,submitTime) VALUES ");

			int recordCount = recordId.length;
			StringBuffer valuesStr = new StringBuffer("");
			
			for (int i = 0; i < recordCount; i++) {
				valuesStr.append("(");
				valuesStr.append(recordId[i]);
				valuesStr.append(",");
				valuesStr.append(opType);
				valuesStr.append(",'");
				valuesStr.append(editer);
				valuesStr.append("',NOW())");
				
				if (i < recordCount - 1) {
					valuesStr.append(",");
				}
			}
			insertSql.append(valuesStr);
			stmt = conn.createStatement();
			stmt.execute(insertSql.toString());
			if (opType == 2 || opType == 3) {
				//���뾲̬����¼��
				StringBuffer staticInsertSql = new StringBuffer("INSERT INTO ");
				staticInsertSql.append(CommonPublic.NEWS_STATIC_RECORD);
				staticInsertSql.append("(newsId,newsType,submitTime) VALUES ");
				StringBuffer staticValuesStr = new StringBuffer("");
				
				for (int i = 0; i < recordCount; i++) {
					staticValuesStr.append("(");
					staticValuesStr.append(recordId[i]);
					staticValuesStr.append(",1,NOW())");

					if (i < recordCount - 1) {
						staticValuesStr.append(",");
					}
				}
				staticInsertSql.append(staticValuesStr);
				stmt.execute(staticInsertSql.toString());
			}
			
			//���뿪Դ���������¼��
			insertSql = new StringBuffer("INSERT INTO ");
			insertSql.append(CommonPublic.NEWS_IDX_RECORD);
			insertSql.append("(dstTableIdName,dstTableIdValue,optType,infoId,pubTime) VALUES ");
			
			recordCount = recordId.length;
			valuesStr = new StringBuffer("");
			for (int i = 0; i < recordCount; i++) {
				valuesStr.append("('Pchk_id',");
				valuesStr.append(recordId[i]);
				valuesStr.append(",");
				valuesStr.append(opType);
				valuesStr.append(",");
				valuesStr.append(1);
				valuesStr.append(",NOW())");

				if (i < recordCount - 1) {
					valuesStr.append(",");
				}
			}
			insertSql.append(valuesStr);
			stmt = conn.createStatement();
			stmt.execute(insertSql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

