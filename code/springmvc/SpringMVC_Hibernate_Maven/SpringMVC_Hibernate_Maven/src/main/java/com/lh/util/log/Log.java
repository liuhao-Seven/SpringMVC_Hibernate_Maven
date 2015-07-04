package com.lh.util.log;

import java.lang.reflect.Method;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.lh.util.common.Constants;

public class Log {
	static Logger logger = (Logger) Logger.getLogger("log");

	public static void info(String msg, Object obj) {
		logger.info("---------" + msg + "---------");

		if (obj == null) {
			return;
		}
		if (String.class == obj.getClass()) {
			logger.info("\t" + obj);
		} else {
			logger.info(ToStringBuilder.reflectionToString(obj));
		}
	}

	public static void info(Object msg) {
		logger.info(msg);
	}
	
	public static void error(Object message, Throwable t) {
		if ("YES".equalsIgnoreCase(Constants.LOG_FLAG)) {
			logger.error(message, t);
		}
	}

	public static void infoGetter(String msg, Object obj) {
		Class<?> c = obj.getClass();
		Method methodes[] = c.getDeclaredMethods();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		try {
			for (Method m : methodes) {
				if (m.getName().matches("get.*")) {
					sb.append(
							m.getName().substring(2) + ":"
									+ m.invoke(obj, new Object[] {})).append(
							",");
				}
			}
			sb.append("]");
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info(sb.toString().replaceAll(",]$", "]"));

	}
}
