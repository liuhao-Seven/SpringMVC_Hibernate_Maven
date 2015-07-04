package com.mvc.service.iface;

import java.util.List;

import com.mvc.domain.User;

/**
 *
 * @date 2014-11-14
 * @author ¡ı∫∆ 
 */
public interface LoginService {
	boolean login(User user);
	public void deleteUserByUserId(User user) throws Exception;
	public List<User> getUsers();
}
