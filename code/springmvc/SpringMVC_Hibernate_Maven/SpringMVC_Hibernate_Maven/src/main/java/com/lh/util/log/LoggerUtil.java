package com.lh.util.log;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Logger;
/**
 * Logger工具类
 * @description 用于将日志输出到指定的日志文件中
 * @date 2014-11-13
 * @author 刘浩 
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
		// 生成新的Logger
		// 如果已經有了一個Logger實例返回現有的
		Logger logger = Logger.getLogger(name);
		// 清空Appender。特別是不想使用現存實例時一定要初期化
		logger.removeAllAppenders();
		// 設定Logger級別。
		logger.setLevel(Level.INFO);
		// 設定是否繼承父Logger。
		// 默認為true。繼承root輸出。
		// 設定false後將不輸出root。
		logger.setAdditivity(true);
		// 生成新的Appender
		FileAppender appender = new FileAppender();
		PatternLayout layout = new PatternLayout();
		// log的输出形式
		String conversionPattern = "[%d{HH:mm:ss}] [%p] %m%n";
		conversionPattern = "%d{yyyy-MM-dd HH:mm}[%p] [%l]  %m%n";
		layout.setConversionPattern(conversionPattern);
		appender.setLayout(layout);
		// log输出路径
		// 这里使用了环境变量[catalina.home]，只有在tomcat环境下才可以取到
		appender.setFile(path);
		// log的文字码
		appender.setEncoding("UTF-8");
		// true:在已存在log文件后面追加 false:新log覆盖以前的log
		appender.setAppend(true);
		// 适用当前配置
		appender.activateOptions();
		// 将新的Appender加到Logger中
		logger.addAppender(appender);
		return logger;
	}
	
	public static Logger getLogger(String path,String name) {
		// 生成新的Logger
		// 如果已經有了一個Logger實例返回現有的
		Logger logger = Logger.getLogger(name);
		// 清空Appender。特別是不想使用現存實例時一定要初期化
		logger.removeAllAppenders();
		// 設定Logger級別。
		logger.setLevel(Level.INFO);
		// 設定是否繼承父Logger。
		// 默認為true。繼承root輸出。
		// 設定false後將不輸出root。
		logger.setAdditivity(true);
		// 生成新的Appender
		FileAppender appender = new FileAppender();
		PatternLayout layout = new PatternLayout();
		// log的输出形式
		String conversionPattern = "[%d{HH:mm:ss}] [%p] %m%n";
		layout.setConversionPattern(conversionPattern);
		appender.setLayout(layout);
		// log输出路径
		// 这里使用了环境变量[catalina.home]，只有在tomcat环境下才可以取到
		appender.setFile(path);
		// log的文字码
		appender.setEncoding("UTF-8");
		// true:在已存在log文件后面追加 false:新log覆盖以前的log
		appender.setAppend(true);
		// 适用当前配置
		appender.activateOptions();
		// 将新的Appender加到Logger中
		logger.addAppender(appender);
		return logger;
	}
}
