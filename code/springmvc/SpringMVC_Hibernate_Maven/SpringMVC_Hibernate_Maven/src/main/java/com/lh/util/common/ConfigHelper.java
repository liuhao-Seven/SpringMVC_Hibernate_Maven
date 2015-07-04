package com.lh.util.common;

import java.io.InputStream;

import com.lh.util.common.SysContants;
/**
 * ¼ÓÔØpropertiesÎÄ¼þ
 *
 * @date 2014-11-1
 * @author ÁõºÆ
 */
public class ConfigHelper {
	
	public static InputStream getResourceAsStream(String resource) throws Exception{
		String stripped = resource.startsWith("/") ?
				resource.substring(1) : resource;

		InputStream stream = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader!=null) {
			stream = classLoader.getResourceAsStream( stripped );
		}
		if ( stream == null ) {
			stream = SysContants.class.getResourceAsStream( resource );
		}
		if ( stream == null ) {
			stream = SysContants.class.getClassLoader().getResourceAsStream( stripped );
		}
		if ( stream == null ) {
			throw new Exception( resource + " not found" );
		}
		return stream;
	}
}