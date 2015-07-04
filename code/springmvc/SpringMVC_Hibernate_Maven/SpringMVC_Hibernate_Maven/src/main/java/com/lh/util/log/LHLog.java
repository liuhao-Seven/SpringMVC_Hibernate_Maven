package com.lh.util.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * 日志工具类
 *
 * @date 2014-11-4
 * @author 刘浩
 */
public class LHLog {
	
	private final static Logger log = LHLogger.getLogger(LHLog.class.getName(),new LHLoggerFactory());
	
	public static void trace(String msg){
		log.trace(msg);
	}
	public static void trace(String msg,Throwable t){
		log.trace(msg,t);
	}
	public static void trace(Throwable t){
		log.trace(t);
	}
	
	public static void debug(String msg){
		log.debug(msg);
	}
	public static void debug(String msg,Throwable t){
		log.debug(msg,t);
	}
	public static void debug(Throwable t){
		log.debug(t);
	}
	
	public static void info(String msg){
		log.info(msg);
	}
	public static void info(String msg,Throwable t){
		log.info(msg,t);
	}
	public static void info(Throwable t){
		log.info(t);
	}
	
	public static void warn(String msg){
		log.warn(msg);
	}
	public static void warn(String msg,Throwable t){
		log.warn(msg,t);
	}
	public static void warn(Throwable t){
		log.warn(t);
	}
	
	public static void error(String msg){
		log.error(msg);
	}
	public static void error(String msg,Throwable t){
		log.error(msg,t);
	}
	public static void error(Throwable t){
		log.error(t);
	}
	
	/**
	 * 从当前Category开始查找非null的Level，若全为空则返回Root Category中的Level
	 * @return  org.apache.log4j.Level
	 * @since 2013-9-2
	 */
	public static Level getLevel(){
		return log.getEffectiveLevel();
	}
}
