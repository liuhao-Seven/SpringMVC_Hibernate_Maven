package com.lh.util.common;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	/**yyyy-MM-dd*/
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	
	/**yyyy/MM/dd*/
	public final static String DATE_Format = "yyyy/MM/dd";
	
	/**HH:mm:ss*/
	public final static String TIME_PATTERN = "HH:mm:ss";
	
	/**HH*/
	public final static String TIME_PATTERN_HOUR = "HH";
	
	/**yyyy-MM-dd HH:mm:ss*/
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	/**yyyy/MM/dd HH:mm:ss*/
	public final static String DATE_TIME_Format = "yyyy/MM/dd HH:mm:ss";
	
	/**yyyy-MM-dd HH:mm*/
	public final static String DATE_TIME_HHMM = "yyyy-MM-dd HH:mm";
	
	/**是否打印报文日志，YES-打印，NO-不打印*/
	public static String PRINT_FLAG = "YES";
	
	/**是否生成日志，YES-生成，NO-不生成*/
	public static String LOG_FLAG = "YES";
	
	/**图片保存的绝对路径*/
	public static String PICTUREREALPATH = "";
	
	/**TXT文件存放地址*/
	public static String DZFILEPATH = "";
	
	/**图片存放相对路径*/
	public static String PICTUREUSEPATH = "";
	
	/**回退代码*/
	public final static String BACK = "javascript:history.go(-1);";
	
	/**分页时每页默认记录条数*/
	public static Integer PAGESIZE = 10; 
	
	public final static String userDir = System.getProperty("user.dir");
	
	/**property配置文件路径*/
	/*system.getProperty("configFilePath") 
	 * 配置路径见resource 下的配置默认路径.bmp
	 * Eclipse中配置路径见resource 下的eclipse配置默认路径.jpg
	 */
	public final static String PROPERTY_PATH = Constants.getConfigFilePath() + "/ITfzdswz/config/lhProperty.properties";
	
	/**配置默认路径*/
	public final static String getConfigFilePath(){
		String configFilePath = System.getProperty("configFilePath");
		//  刘浩 2015-3-11 下午6:43:02
//		if (FunctionUtils.isBlank(configFilePath)) {
//			return "C:";
//		}
		return configFilePath;
	}
//	public final static String configFilePath = System.getProperty("configFilePath");
	
	/**加密解密密钥*/
	public static String MIYUE = "ITLH";

	/**SHELL版本升级文件*/
	public static List<byte[]> SHELLList = new ArrayList<byte[]>(); 
	/**单个下载包大小设置*/
	public static int LEN_BLOCK = 6900;	
	/**包数上限*/
	public static int MAX_BLOCK	= 200;		
	/**日志配置文件的存放路径*/
	public static String LOG4JPATH = Constants.getConfigFilePath() + "/ITfzdswz/config/log4j.properties";
	/**是否使用代理 ,YES-使用，NO-不使用*/
	public static String PROXY_FLAG = "YES";
	
}