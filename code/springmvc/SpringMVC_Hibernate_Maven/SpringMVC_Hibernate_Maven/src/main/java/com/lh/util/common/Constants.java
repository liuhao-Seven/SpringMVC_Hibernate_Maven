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
	
	/**�Ƿ��ӡ������־��YES-��ӡ��NO-����ӡ*/
	public static String PRINT_FLAG = "YES";
	
	/**�Ƿ�������־��YES-���ɣ�NO-������*/
	public static String LOG_FLAG = "YES";
	
	/**ͼƬ����ľ���·��*/
	public static String PICTUREREALPATH = "";
	
	/**TXT�ļ���ŵ�ַ*/
	public static String DZFILEPATH = "";
	
	/**ͼƬ������·��*/
	public static String PICTUREUSEPATH = "";
	
	/**���˴���*/
	public final static String BACK = "javascript:history.go(-1);";
	
	/**��ҳʱÿҳĬ�ϼ�¼����*/
	public static Integer PAGESIZE = 10; 
	
	public final static String userDir = System.getProperty("user.dir");
	
	/**property�����ļ�·��*/
	/*system.getProperty("configFilePath") 
	 * ����·����resource �µ�����Ĭ��·��.bmp
	 * Eclipse������·����resource �µ�eclipse����Ĭ��·��.jpg
	 */
	public final static String PROPERTY_PATH = Constants.getConfigFilePath() + "/ITfzdswz/config/lhProperty.properties";
	
	/**����Ĭ��·��*/
	public final static String getConfigFilePath(){
		String configFilePath = System.getProperty("configFilePath");
		//  ���� 2015-3-11 ����6:43:02
//		if (FunctionUtils.isBlank(configFilePath)) {
//			return "C:";
//		}
		return configFilePath;
	}
//	public final static String configFilePath = System.getProperty("configFilePath");
	
	/**���ܽ�����Կ*/
	public static String MIYUE = "ITLH";

	/**SHELL�汾�����ļ�*/
	public static List<byte[]> SHELLList = new ArrayList<byte[]>(); 
	/**�������ذ���С����*/
	public static int LEN_BLOCK = 6900;	
	/**��������*/
	public static int MAX_BLOCK	= 200;		
	/**��־�����ļ��Ĵ��·��*/
	public static String LOG4JPATH = Constants.getConfigFilePath() + "/ITfzdswz/config/log4j.properties";
	/**�Ƿ�ʹ�ô��� ,YES-ʹ�ã�NO-��ʹ��*/
	public static String PROXY_FLAG = "YES";
	
}