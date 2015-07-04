package com.lh.util.log;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Logger;
/**
 * Logger������
 * @description ���ڽ���־�����ָ������־�ļ���
 * @date 2014-11-13
 * @author ���� 
 */
public class LoggerUtil {
	public static void main(String[] args) {
		Logger log1 = LoggerUtil.getLogger("F:/log/ThreadLog/ceshi1.log", "ceshi1");
		log1.info("ceshi1");
		Logger log2 = LoggerUtil.getLogger2("F:/log/ThreadLog/ceshi2.log", "ceshi2");
		log2.info("ceshi2");
		for (int i = 0; i < 10; i++) {
			Logger log = LoggerUtil.getLogger("F:/log/ThreadLog/"+i+".log", i+"");
			log.info(i);
		}
	}
	
	public static Logger getLogger2(String path,String name) {
		// �����µ�Logger
		// ����ѽ�����һ��Logger�������جF�е�
		Logger logger = Logger.getLogger(name);
		// ���Appender���؄e�ǲ���ʹ�ìF�挍���rһ��Ҫ���ڻ�
		logger.removeAllAppenders();
		// �O��Logger���e��
		logger.setLevel(Level.INFO);
		// �O���Ƿ��^�и�Logger��
		// Ĭ�J��true���^��rootݔ����
		// �O��false�ጢ��ݔ��root��
		logger.setAdditivity(true);
		// �����µ�Appender
		FileAppender appender = new FileAppender();
		PatternLayout layout = new PatternLayout();
		// log�������ʽ
		String conversionPattern = "[%d{HH:mm:ss}] [%p] %m%n";
		conversionPattern = "%d{yyyy-MM-dd HH:mm}[%p] [%l]  %m%n";
		layout.setConversionPattern(conversionPattern);
		appender.setLayout(layout);
		// log���·��
		// ����ʹ���˻�������[catalina.home]��ֻ����tomcat�����²ſ���ȡ��
		appender.setFile(path);
		// log��������
		appender.setEncoding("UTF-8");
		// true:���Ѵ���log�ļ�����׷�� false:��log������ǰ��log
		appender.setAppend(true);
		// ���õ�ǰ����
		appender.activateOptions();
		// ���µ�Appender�ӵ�Logger��
		logger.addAppender(appender);
		return logger;
	}
	
	public static Logger getLogger(String path,String name) {
		// �����µ�Logger
		// ����ѽ�����һ��Logger�������جF�е�
		Logger logger = Logger.getLogger(name);
		// ���Appender���؄e�ǲ���ʹ�ìF�挍���rһ��Ҫ���ڻ�
		logger.removeAllAppenders();
		// �O��Logger���e��
		logger.setLevel(Level.INFO);
		// �O���Ƿ��^�и�Logger��
		// Ĭ�J��true���^��rootݔ����
		// �O��false�ጢ��ݔ��root��
		logger.setAdditivity(true);
		// �����µ�Appender
		FileAppender appender = new FileAppender();
		PatternLayout layout = new PatternLayout();
		// log�������ʽ
		String conversionPattern = "[%d{HH:mm:ss}] [%p] %m%n";
		layout.setConversionPattern(conversionPattern);
		appender.setLayout(layout);
		// log���·��
		// ����ʹ���˻�������[catalina.home]��ֻ����tomcat�����²ſ���ȡ��
		appender.setFile(path);
		// log��������
		appender.setEncoding("UTF-8");
		// true:���Ѵ���log�ļ�����׷�� false:��log������ǰ��log
		appender.setAppend(true);
		// ���õ�ǰ����
		appender.activateOptions();
		// ���µ�Appender�ӵ�Logger��
		logger.addAppender(appender);
		return logger;
	}
}
