package com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.domain.User;
import com.mvc.service.iface.LoginService;

@Controller
public class SearchController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/getUsers.do")
	public String getUsers(String username,HttpServletRequest request,
			HttpServletResponse response){
		//调用Service层查询用户列表
		List<User> users = loginService.getUsers();
		request.setAttribute("users", users);
		return "list";
	}
	
	@RequestMapping(value="/delUser.do")
	public String delUser(String username,HttpServletRequest request,
			HttpServletResponse response){
		try {
			User user = new User();
			user.setUserName(username);
			loginService.deleteUserByUserId(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
