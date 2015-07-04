package com.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lh.base.BaseController;
import com.lh.util.page.PagerThree;
import com.mvc.domain.User;
import com.mvc.service.iface.UserService;

/**
 * 测试分页对象
 * @description:
 * @author 刘浩
 * @date 2015-6-21 下午11:02:34 
 * @version V1.0  
 *
 */
@Controller
public class TestPagerController extends BaseController{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/searchForList.do",method=RequestMethod.POST)
	public void searchForList(String action,String toPage,PagerThree<User> pager,HttpServletRequest request,HttpServletResponse response){
//		System.out.println("=======================================");
//		System.out.println("action="+action+"&toPage="+toPage);
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//		System.out.println("queryData:"+gson.toJson(pager.getQueryData()));
//		System.out.println(gson.toJson(pager));
//		QueryData queryData = gson.fromJson(pager.getQueryData().toString(),
//				QueryData.class );
//		System.out.println(queryData.toString());
//		System.out.println("=======================================");
		
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//		System.out.println("=======================================");
//		System.out.println(gson.toJson(pager));
		QueryData queryData = gson.fromJson(pager.getQueryData().toString(),
				QueryData.class );
//		System.out.println("queryData:"+queryData);
		//先根据条件查询记录总数
		Integer totalRows = userService.getUserCount(queryData.getUsername(), queryData.getAge());
		//设置总页数
		pager.setTotalRows(totalRows);
		//设置请求路径
//		pager.setPath("searchForList.do");
		//判断将要跳转的是那个页面
		pager.doAction(action, toPage);
		//进行相应页面的数据查询
		List<User> userList = userService.getUserList(pager, queryData.getUsername(), queryData.getAge());
		pager.setData(userList);
		System.out.println("pager:"+gson.toJson(pager));
		writeToPage(pager, response);
	}
	
	@RequestMapping(value="/deleteUser.do",method=RequestMethod.POST)
	public void deleteUser(String userName,PagerThree<User> pager,HttpServletRequest request,HttpServletResponse response){
		try {
			userName = java.net.URLDecoder.decode(userName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//根据用户名删除用户
		System.out.println("删除用户"+userName);
		userService.deleteUser(userName);
		writeToPage(null, response);
	}
	
}

/**
 * 查询数据条件对象
 * @description:
 * @author 刘浩
 * @date 2015-6-22 下午5:24:35 
 * @version V1.0  
 *
 */
class QueryData{
	private String username;
	private String age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "username:"+username+";age:"+age;
	}
	
}
