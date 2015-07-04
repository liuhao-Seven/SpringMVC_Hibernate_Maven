package com.lh.util.log;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
 * LHLogger������
 *
 * @date 2014-11-4
 * @author ����
 */
public class LHLoggerFactory implements LoggerFactory {

	/* (non-Javadoc)
	 * @see org.apache.log4j.spi.LoggerFactory#makeNewLoggerInstance(java.lang.String)
	 */
	public Logger makeNewLoggerInstance(String name) {
		return new LHLogger(name);
	}

}
