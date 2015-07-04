/**   
 * @Title: UserDao.java 
 * @Package com.mvc.dao.iface 
 * @Description:
 * @author 刘浩
 * @date 2015-4-16 下午5:16:19 
 * @version V1.0   
 */
package com.mvc.dao.iface;

import java.util.List;

import com.lh.util.page.PagerThree;
import com.mvc.domain.User;

/** 
 * @ClassName: UserDao 
 * @Description: 
 * @author 刘浩
 * @date 2015-4-16 下午5:16:19 
 *  
 */
public interface UserDao {
	
	/**
	 * 根据用户名获取对象
	 * 
	 * @author 刘浩
	 * @date 2015-4-16 下午5:16:59 
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);
	
	public void deleteUserByUserId(User user) throws Exception;
	
	public List<User> getUsers();
	
	public Integer getUserCount(String username,String age);
	
	public List<User> getUserList(PagerThree<User> pager,String username,String age);
	
	public void deleteUser(String userName);
}
