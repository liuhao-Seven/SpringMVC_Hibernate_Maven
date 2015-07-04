/**   
 * @Title: UserDaoImpl.java 
 * @Package com.mvc.dao.impl 
 * @Description:
 * @author ÁõºÆ
 * @date 2015-4-16 ÏÂÎç5:16:01 
 * @version V1.0   
 */
package com.mvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lh.base.BaseDao;
import com.lh.util.common.FunctionUtils;
import com.lh.util.page.PagerThree;
import com.mvc.dao.iface.UserDao;
import com.mvc.domain.User;

/** 
 * @ClassName: UserDaoImpl 
 * @Description: 
 * @author ÁõºÆ
 * @date 2015-4-16 ÏÂÎç5:16:01 
 *  
 */
@Repository(value="userDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao{
	/* (non-Javadoc)
	 * @see com.mvc.dao.iface.UserDao#getUserByUserName(java.lang.String)
	 */
	@Override
	public User getUserByUserName(String userName) {
		return this.findObject("from User u where u.userName = '"+userName+"'");
	}
	
	public void deleteUserByUserId(User user) throws Exception{
		this.delete(user);
		throw new RuntimeException();
	}
	
	public List<User> getUsers(){
		return this.find("from User");
	}

	@Override
	public Integer getUserCount(String username, String age) {
		String sql = "select count(1) from user where 1=1 ";
		if (!FunctionUtils.isBlank(username)) {
			sql += " and username like '%"+username+"%'";
		}
		if (!FunctionUtils.isBlank(age)) {
			sql += " and age='"+age+"'";
		}
		return this.queryForInt(sql);
	}

	@Override
	public List<User> getUserList(PagerThree<User> pager, String username,
			String age) {
		String hql = "from User where 1=1 ";
		if (!FunctionUtils.isBlank(username)) {
			hql += " and username like '%"+username+"%'";
		}
		if (!FunctionUtils.isBlank(age)) {
			hql += " and age='"+age+"'";
		}
		return this.findByHqlForPage(hql, pager.getFirstEntityIndex(), pager.getPageSize());
	}

	@Override
	public void deleteUser(String userName) {
		this.execute("delete from User where userName ='"+userName+"'");
	}

}
