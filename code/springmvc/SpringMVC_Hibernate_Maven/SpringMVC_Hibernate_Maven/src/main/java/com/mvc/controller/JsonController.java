package com.mvc.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mvc.dto.MessageDto;

/**
 * 
 * @description:测试json数据的传输
 * @author 刘浩
 * @date 2015-6-10 上午10:51:10 
 * @version V1.0  
 *
 */
@Controller
public class JsonController {
	
	@RequestMapping(value = "/getJson.do", method = RequestMethod.POST)
	public void getJson(String name,String password,HttpServletResponse resp){
		try {
			System.out.println("name:"+name+"\npassword:"+password);
			MessageDto msg = new MessageDto();
			msg.setCode("1");
	        msg.setMessage("操作成功");
	        msg.setObj(null);
			resp.setContentType("text/xml;charset=UTF-8");
			resp.setCharacterEncoding("UTF-8");// 设置编码
			resp.setHeader("Cache-Control", "no-cache");
			PrintWriter out = resp.getWriter();
			Gson gson = new GsonBuilder() .setDateFormat("yyyy/MM/dd") .create();
			out.print(gson.toJson(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
