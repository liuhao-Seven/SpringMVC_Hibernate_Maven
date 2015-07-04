package com.lh.base;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lh.util.log.LHLog;
import com.lh.util.page.PagerThree;

/**
 * Controller层基础类
 * @ClassName: BaseController 
 * @Description: 
 * @author 刘浩
 * @date 2015-4-17 上午10:02:03 
 *
 */
@Controller
public class BaseController {
	
	protected void renderJsonData(HttpServletResponse response, PagerThree<Object> pager) throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(pager));
	}
	
	/**
	 * 向页面写数据
	 * @param obj
	 * @param resp
	 */
	protected void writeToPage(Object obj, HttpServletResponse resp) {
		try {
			resp.setContentType("text/xml;charset=UTF-8");
			resp.setCharacterEncoding("UTF-8");// 设置编码
			resp.setHeader("Cache-Control", "no-cache");
			PrintWriter out = resp.getWriter();
			Gson gson = new GsonBuilder() .setDateFormat("yyyy/MM/dd") .create();
			out.print(gson.toJson(obj));
		} catch (Exception e) {
			LHLog.error("向页面输出数据失败:" + obj.toString(), e);
		}
	}
	
	/**
	 * 从request对象中获取errorMsg的json字符串，包装为html内容,供controller调用
	 * @return  Html的String值
	 * @since 2014-7-9
	 */
	protected String getExcetpionMsg(HttpServletRequest req){
		@SuppressWarnings("unchecked")
		List<String> excetpionMsgs=(List<String>) req.getAttribute("exceptionMsgs");
		StringBuffer exceptionHtml=new StringBuffer("");
		StringBuffer exceptionIds=new StringBuffer("");
		StringBuffer exceptionMsgs=new StringBuffer("");
		try {
			if(excetpionMsgs!=null){
				for(int i=0;i<excetpionMsgs.size();i++ ){
					String exceptionJsonStr=excetpionMsgs.get(i);
					if(exceptionJsonStr!=null){
						JSONObject jsonObj = new JSONObject(exceptionJsonStr);
						String exViewMode=(String) jsonObj.get("exViewMode");
						String exceptId=(String)jsonObj.get("exceptionID");
						String exceptionMsg=(String)jsonObj.get("exceptionMessge");
						if(!exceptionIds.toString().equals("")){
							exceptionIds.append(",");
						}
						exceptionIds.append(exceptId == null ? "":exceptId);
						if(!exceptionMsgs.toString().equals("")){
							exceptionMsgs.append(",");
						}
						exceptionMsgs.append(exceptionMsg == null ? "":exceptionMsg);
						String exceptionTime=(String)jsonObj.get("exceptionTime");
						req.setAttribute("exceptionTime", exceptionTime);
						if(exViewMode.equals("publishedMode")){
							exceptionHtml.append("<span>");
							exceptionHtml.append("异常ID："+jsonObj.getString("exceptionID")).append("<br/>");
							exceptionHtml.append("异常信息："+jsonObj.getString("exceptionMessge")).append("<br/>");
							
							exceptionHtml.append("</span>");
						}else{
							exceptionHtml.append("<span>");
							exceptionHtml.append("出现异常：").append(jsonObj.getString("exceptionClass")).append("<br/>");
							exceptionHtml.append("异常信息：").append(jsonObj.getString("exceptionMessge")).append("<br/>");
							exceptionHtml.append("异常详细信息如下：<br/>");
							exceptionHtml.append("异常ID:").append(jsonObj.getString("exceptionID")).append("<br/>");
							exceptionHtml.append("产生异常的类：").append(jsonObj.getString("exceptionFormClass")).append("<br/>");
							exceptionHtml.append("产生异常的方法：").append(jsonObj.getString("exceptionFormMethod")).append("<br/>");
							exceptionHtml.append("传入的参数：").append(jsonObj.getString("methodArgs")).append("<br/>");
							exceptionHtml.append("异常信息：").append(jsonObj.getString("exceptionMessge")).append("<br/>");
							exceptionHtml.append("</span>");
						}
					}
				}
			}
		} catch (JSONException e) {
			LHLog.error("JOSN字符串转换错误！");
			e.printStackTrace();
		}
		req.setAttribute("exceptionHtml", exceptionHtml.toString());
		req.setAttribute("exceptionIds", exceptionIds.toString());
		req.setAttribute("exceptionMsgs", exceptionMsgs.toString());
		return exceptionHtml.toString();
	}
	
	
	
}
