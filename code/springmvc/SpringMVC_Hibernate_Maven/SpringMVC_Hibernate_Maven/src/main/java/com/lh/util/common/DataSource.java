package com.lh.util.common;

/**
 * applicationContext.xml�е�����ֵ���õ������ļ���ȥ
 * DriverManagerDataSource��ʽ�õ��������ò���
 *
 * @author ����
 * @date 2014-7-19
 */
public class DataSource extends org.springframework.jdbc.datasource.DriverManagerDataSource{
	private String driverClass;
	private String jdbcUrl;
	private String username;
	private String password;
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
