package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @date 2014-11-14
 * @author ¡ı∫∆ 
 */
@Controller
public class MyController {
	
	@RequestMapping("/hello.do")
	public String hello(){
		//127.0.0.1:7070/SpringMVC_Hibernate/hello.do
		System.out.println("hello world");
		return "success";
	}
}
