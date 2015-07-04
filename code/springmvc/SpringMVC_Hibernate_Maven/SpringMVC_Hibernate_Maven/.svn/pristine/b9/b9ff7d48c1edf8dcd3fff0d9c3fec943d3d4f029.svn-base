package com.lh.configuration;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 对配置的数据库密码进行解密
 * @ClassName: Placeholder 
 * @Description: 
 * @author 刘浩
 * @date 2015-4-16 下午5:34:05 
 *
 */
public class Placeholder extends PropertyPlaceholderConfigurer{

	@Override
	protected void processProperties(ConfigurableListableBeanFactory arg0,
			Properties arg1) throws BeansException {
		
//		try {
//			arg1.setProperty("jdbc.username", Encrypt.dencrypt_data(arg1.getProperty("jdbc.username")));
//			arg1.setProperty("jdbc.password", Encrypt.dencrypt_data(arg1.getProperty("jdbc.password")));
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new FatalBeanException("数据库密码解密失败");
//		}
		
		super.processProperties(arg0, arg1);
	}

}
