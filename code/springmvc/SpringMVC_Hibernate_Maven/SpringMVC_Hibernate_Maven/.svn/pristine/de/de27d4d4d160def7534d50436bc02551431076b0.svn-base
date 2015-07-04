package com.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.iface.UserDao;
import com.mvc.domain.User;
import com.mvc.service.iface.LoginService;

/**
 * 
 * @ClassName: LoginServiceImpl 
 * @Description: 
 * @author ¡ı∫∆
 * @date 2015-4-17 …œŒÁ9:35:22 
 *
 */
@Service(value="loginService")
//@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserDao userDao;
	
	public boolean login(User user){
		User getUser = userDao.getUserByUserName(user.getUserName());
		if(getUser != null 
				&& getUser.getPassword().equals(user.getPassword())){
			System.out.println("======"+getUser.getPassword());
			return true;
		}
		return false;
	}

	@Override
	public void deleteUserByUserId(User user) throws Exception {
		userDao.deleteUserByUserId(user);
		throw new RuntimeException();
	}
	
	public List<User> getUsers(){
		return userDao.getUsers();
	}

}
