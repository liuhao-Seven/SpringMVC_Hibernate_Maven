package com.lh.util.log;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

/**
 * 
 *
 * @date 2014-11-4
 * @author ¡ı∫∆
 */
public class LHLogger extends Logger{
	
	private static final String FQCN = LHLog.class.getName();

	protected LHLogger(String name) {
	    super(name);
	}
	
	protected void forcedLog(String fqcn, Priority level, Object message, Throwable t) {
	   callAppenders(new LoggingEvent(FQCN, this, level, message, t));
	}
}
