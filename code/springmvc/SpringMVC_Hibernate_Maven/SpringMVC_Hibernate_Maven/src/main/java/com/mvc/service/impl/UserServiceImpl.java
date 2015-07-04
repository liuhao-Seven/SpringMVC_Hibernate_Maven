package com.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.util.page.PagerThree;
import com.mvc.dao.iface.UserDao;
import com.mvc.domain.User;
import com.mvc.service.iface.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public Integer getUserCount(String username, String age) {
		return userDao.getUserCount(username, age);
	}

	@Override
	public List<User> getUserList(PagerThree<User> pager, String username,
			String age) {
		return userDao.getUserList(pager, username, age);
	}

	public void deleteUser(String userName){
		userDao.deleteUser(userName);
	}
}
