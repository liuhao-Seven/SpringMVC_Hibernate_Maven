package com.lh.util.log;

import com.lh.util.common.Constants;

/**
 * 日志对象，增加了是否打印的控制
 * @author 刘浩
 * @date 2014-8-15
 *
 */
public class Logger extends org.apache.log4j.Logger{

	protected Logger(String name) {
		super(name);
	}

	@Override
	public void debug(Object message, Throwable t) {
		if ("YES".equalsIgnoreCase(Constants.LOG_FLAG)) {
			super.debug(message, t);
		}
	}

	@Override
	public void debug(Object message) {
		if ("YES".equalsIgnoreCase(Constants.LOG_FLAG)) {
			super.debug(message);
		}
	}

	@Override
	public void error(Object message, Throwable t) {
		if ("YES".equalsIgnoreCase(Constants.LOG_FLAG)) {
			super.error(message, t);
		}
	}

	@Override
	public void error(Object message) {
		if ("YES".equalsIgnoreCase(Constants.LOG_FLAG)) {
			super.error(message);
		}
	}

	@Override
	public void info(Object message, Throwable t) {
		if ("YES".equalsIgnoreCase(Constants.LOG_FLAG)) {
			super.info(message, t);
		}
	}

	@Override
	public void info(Object message) {
		if ("YES".equalsIgnoreCase(Constants.LOG_FLAG)) {
			super.info(message);
		}
	}

	@Override
	public void warn(Object message, Throwable t) {
		if ("YES".equalsIgnoreCase(Constants.LOG_FLAG)) {
			super.warn(message, t);
		}
	}

	@Override
	public void warn(Object message) {
		if ("YES".equalsIgnoreCase(Constants.LOG_FLAG)) {
			super.warn(message);
		}
	}
}
