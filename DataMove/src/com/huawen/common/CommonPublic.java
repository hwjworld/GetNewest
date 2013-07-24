package com.huawen.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @author wang hongwei
 * 
 * 通用常量
 */
public class CommonPublic {
	public static final boolean isDebug = true;
	
	public static final int INIT_DICTIONARY_ERROR = -4; //初始化分词字典失败
	public static final int CREATE_HANDLE_ERROR = -5; //创建分词句柄失败
	public static final int INIT_USER_DICT_ERROR = -6; //初始化用户分词字典失败
	public static final int SEGMENT_ERROR = -7; //分词失败
	
	public static final int HAVE_NO_THIS_USER = -10; // 没有此用户
	public static final int USER_NAME_INVALID = -11; // 无效用户名
	public static final int USER_PASSWORD_ERROR = -12; // 密码错误
	public static final int DOUBLE_PASSWORD_ERROR = -13; // 用户输入的两次密码不一致
	public static final int USER_LOGIN_TIMEOUT = -14; // 用户登录超时
	public static final int DB_ERROR = -16; // 数据库错误
	public static final int USER_HAVE_REGISGERED = -17; // 用户已注册过
	public static final int LOGIN_TIMES_TOO_MORE = -18; // 用户登录次数过多
	public static final int HAVE_NO_PRIVILEGE = -19; // 用户没有此模块的使用权限
	public static final int SYSTEM_ERROR = -100; // 系统错误
	public static final int PARAMETERS_ERROR = -101; // 参数错误

	//导入条件记录表
	public static final String IMPORT_CONDITION = "biz_data_center.import_condition";
	//数据中心信息处理表，来源于SRC_ARTICLEINFO
	public static final String ARTICLE_INFO = "biz_data_center.article_info";
	//数据中心信息处理表
	public static final String ARTICLE_INFO_HIS = "biz_data_center.article_info_his";
	//来源标准别名信息表
	public static final String SOURCE_INFO = "biz_base.source_info";
	//来源别名信息表
	public static final String SOURCE_INFO_ALIAS = "biz_base.source_info_alias";
	//URL信息表
	public static final String DATA_DOWNURL = "info_source.dbo.DATA_DOWNURL";
	//数据源表
	public static final String DATA_SOURCE = "info_source.dbo.data_source";
	
	//新数据源下载URL表
	public static final String NEWS_CHILDSITE = "fin_info_source.news_childsite";
	//新信息源站点表
	public static final String NEWS_WEBSITE = "fin_info_source.news_website";
	//抓取新闻无法匹配的子站点URL表 news_error_listurl
	public static final String ERROR_LISTURL = "fin_info_source.news_error_listurl";
	
	
	//SQL Server中已抓取信息表(360)
	public static final String SRC_ARTICLEINFO = "ComDataCenter.dbo.articleInfo";
	public static final String SRC_ARTICLEINFO_HIS = "ComDataCenter.dbo.articleInfoHis";
	//SQL Server中已抓取信息表(GOV)
	public static final String SRC_ARTICLEINFO_NEWSPAPER =
		"ComDataCenter.dbo.articleInfoNewspaper";
	public static final String SRC_ARTICLEINFO_NEWSPAPER_HIS =
		"ComDataCenter.dbo.articleInfoNewspaperHis";
	//公司信息表
	public static final String COMPANY_TABLE_NEW = "biz_base.company_info";  //新
	public static final String COMPANY_TABLE = "news.d_companyNew";
	//人物信息表
	public static final String PEOPLE_INFO = "biz_base.people_info"; //新人物信息表
	//人物职务表
	public static final String PEOPLE_DUTY = "biz_base.people_duty"; 
	public static final String PEOPLE_TABLE = "news.d_peopleNew";
	//行业信息表
	public static final String TRADE_INFO_NEW = "biz_base.hy_info"; //新(字段名不同)
	public static final String TRADE_INFO = "news.D_HY";            //旧
	//机构信息表
	public static final String ORGAN_INFO_NEW = "biz_base.org_info"; //新（字段名不同）
	public static final String ORGAN_INFO = "news.D_Organ";
	//内容模块信息表
	public static final String MODULE_INFO_NEW = "biz_base.hy_info_model"; //新
	public static final String MODULE_INFO = "news.data_hymodel";
	//地域信息表
	public static final String AREA_INFO = "news.D_Area";
	public static final String AREA_INFO_NEW = "biz_base.area_info"; //新地域信息表
	// 资产交易属性表
	public static final String ASSETTRANSACT_INFO = "biz_base.assetTransact_info";
	// 文章属性表
	public static final String PROF_INFO = "biz_base.prof_info";
	//正式文章信息表
	public static final String NEWS_INFO = "news.news_info";
	// 新闻分页关联表
	public static final String PAGINATION_RELATION = "news.pagination_relation";
	//当日正式文章信息表
	public static final String NEWS_INFO_CURRENT = "news.news_info_current";
	//正式文章信息表
	public static final String NEWS_INFO_OTHER = "biz_news.news_info_other";
	//NEWS_OPERATION
	public static final String NEWS_OP = "news.news_operation";
	//人物统计结果信息表
	public static final String PER_STATISTIC = "business.statistic_personality";
	//统计标记信息表
	public static final String STATISTIC_FLAG = "biz_base.statistic_flag";
	//新闻静态化记录表
	public static final String NEWS_STATIC_RECORD = "news.news_static_record";
	//新闻静态化类型
	public static final String NEWS_STATIC_TYPE = "news.news_static_type";
	//新闻lucene索引记录表
	public static final String NEWS_IDX_RECORD = "news.idx_record";
	//待删除文件记录表
	public static final String ARTFILE_DELETE_RECORD = "news.artfile_delete_record";

	//稿件库数据表---MySQL
	public static final String MYSQL_NSRELEASELIB = "fin_web_paper.NSRELEASELIB";
	
	public static final String MYSQL_PAGEINFO = "fin_web_paper.PAGEINFO";
	public static final String MYSQL_PAGE_ARTICLE = "fin_web_paper.PAGE_ARTICLE";
	//稿件库数据表---Oracle
	public static final String ORACLE_NSRELEASELIB = "NSRELEASELIB";
	//稿件库数据表---Oracle
	public static final String ORACLE_PAGEINFO = "PAGEINFO";
	
	public static final String ORACLE_PAGE_ARTICLE = "PAGE_ARTICLE";
	
	// 索引任务表
	public static final String IDX_RECORD = "news.idx_record";
	// 索引数据表
	public static final String IDX_TABLE_CONF = "news.idx_table_conf";
	// SQL Server blog_data_center 博客文章数据已抓取博客文章信息表
	public static final String SQLSERVER_BLOG_ARTICLE = "blog_data_center.dbo.blog_article";
	// 博客信息表
	public static final String BLOG_ARTICLE = "blog_data_center.blog_article";
	// 信息历史表
	public static final String BLOG_ARTICLE_HIS = "blog_data_center.blog_article_his";
	// 博客站点表
	public static final String BLOG_WEBSITE = "fin_info_source.blog_website";
	// 博客二级分类表
	public static final String BLOG_CATEGORYTOW = "fin_info_source.blog_categorytwo";
	// 博客空间表
	public static final String BLOG_CHILDSITE = "fin_info_source.blog_childsite";
	// 博客关键词
	public static final String BLOG_KEYWORDS = "fin_info_source.keywords";
	// 博客未匹配url表
	public static final String BLOG_ERROR_LISTURL = "fin_info_source.blog_error_listurl";
	
	// SQL Server forum_data_center 论坛文章数据已抓取论坛文章信息表
	public static final String SQLSERVER_FORUM_ARTICLE = "forum_data_center.dbo.forum_article";
	// 论坛信息表
	public static final String FORUM_ARTICLE = "forum_data_center.forum_article";
	// 信息历史表
	public static final String FORUM_ARTICLE_HIS = "forum_data_center.forum_article_his";
	// 论坛站点表
	public static final String FORUM_WEBSITE = "fin_info_source.forum_website";
	// 论坛二级分类表
	public static final String FORUM_CATEGORYTOW = "fin_info_source.forum_categorytwo";
	// 论坛子站点表
	public static final String FORUM_CHILDSITE = "fin_info_source.forum_childsite";
	// 论坛未匹配url表
	public static final String FORUM_ERROR_LISTURL = "fin_info_source.forum_error_listurl";
	
	// 热门文章模块表
	public static final String MODULE_HOTARTICLE = "fin_web_site.module_hotarticle";
	
	/**
	 * 根据错误编号获取错误描述信息
	 * @param errorCode
	 * @return 
	 */
	public static String getErrorInfo(int errorCode) {
		String errorInfo = "";
		switch (errorCode) {
			case INIT_DICTIONARY_ERROR:
				errorInfo = "初始化分词字典失败";
				break;
			case CREATE_HANDLE_ERROR:
				errorInfo = "创建分词句柄失败";
				break;
			case SEGMENT_ERROR:
				errorInfo = "分词失败";
				break;
			case HAVE_NO_THIS_USER:
				errorInfo = "您输入的用户名无效！";
				break;
			case USER_NAME_INVALID:
				errorInfo = "您输入的用户名无效！";
				break;
			case USER_PASSWORD_ERROR:
				errorInfo = "您输入的密码无效！";
				break;
			case DOUBLE_PASSWORD_ERROR:
				errorInfo = "两次输入的密码不一直！";
				break;
			case USER_LOGIN_TIMEOUT:
				errorInfo = "您还没有登录或登录已超时！";
				break;
			case DB_ERROR:
				errorInfo = "数据库错误！";
				break;
			case USER_HAVE_REGISGERED:
				errorInfo = "用户已注册过！";
				break;
			case LOGIN_TIMES_TOO_MORE:
				errorInfo = "累计失败次数过多，请稍后重新登录！";
				break;
			case HAVE_NO_PRIVILEGE:
				errorInfo = "对不起，您没有使用此模块页面的权限！";
				break;
			case SYSTEM_ERROR:
				errorInfo = "系统错误！";
				break;
			case PARAMETERS_ERROR:
				errorInfo = "您输入的参数不正确！";
				break;
			default:
				;
		}
		return errorInfo;
	}
	
	/**
	 * 判断字符串是否是数字
	 * @author wang hongwei
	 * @param  srcStr String, 要判断的源字符串
	 * @return true, 是数字；false, 不是数字
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
	 * 计算两个时间点之间相差的天数（只计算天）
	 * @param beginCalendar
	 * @param endCalendar
	 * @return long, 相差的天数
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
	 * 记录对正式表信息记录的操作，以便同步给搜索引擎
	 * @param  recordId, 要记录的ID
	 * @param  opType, 操作类别，1-删除；2-修改；3-增加
	 * @param  editer, 提交操作的编辑名称
	 * @param  conn, 数据库连接对象
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
			//插入同步记录表
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
				//插入静态化记录表
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
			
			//插入开源搜索引擎记录表
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

