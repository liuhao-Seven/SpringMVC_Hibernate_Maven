/**   
 * @Title: User.java 
 * @Package com.mvc.domain 
 * @Description:
 * @author 刘浩
 * @date 2015-4-16 下午5:13:21 
 * @version V1.0   
 */
package com.mvc.domain;

/** 
 * @ClassName: User 
 * @Description: 用户对象
 * @author 刘浩
 * @date 2015-4-16 下午5:13:21 
 *  
 */
public class User {
	private String userName;
	private String password;
	private int age;
	public User(){}
	
	public User(String userName,String password,int age){
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
}
