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
 * Controller�������
 * @ClassName: BaseController 
 * @Description: 
 * @author ����
 * @date 2015-4-17 ����10:02:03 
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
	 * ��ҳ��д����
	 * @param obj
	 * @param resp
	 */
	protected void writeToPage(Object obj, HttpServletResponse resp) {
		try {
			resp.setContentType("text/xml;charset=UTF-8");
			resp.setCharacterEncoding("UTF-8");// ���ñ���
			resp.setHeader("Cache-Control", "no-cache");
			PrintWriter out = resp.getWriter();
			Gson gson = new GsonBuilder() .setDateFormat("yyyy/MM/dd") .create();
			out.print(gson.toJson(obj));
		} catch (Exception e) {
			LHLog.error("��ҳ���������ʧ��:" + obj.toString(), e);
		}
	}
	
	/**
	 * ��request�����л�ȡerrorMsg��json�ַ�������װΪhtml����,��controller����
	 * @return  Html��Stringֵ
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
							exceptionHtml.append("�쳣ID��"+jsonObj.getString("exceptionID")).append("<br/>");
							exceptionHtml.append("�쳣��Ϣ��"+jsonObj.getString("exceptionMessge")).append("<br/>");
							
							exceptionHtml.append("</span>");
						}else{
							exceptionHtml.append("<span>");
							exceptionHtml.append("�����쳣��").append(jsonObj.getString("exceptionClass")).append("<br/>");
							exceptionHtml.append("�쳣��Ϣ��").append(jsonObj.getString("exceptionMessge")).append("<br/>");
							exceptionHtml.append("�쳣��ϸ��Ϣ���£�<br/>");
							exceptionHtml.append("�쳣ID:").append(jsonObj.getString("exceptionID")).append("<br/>");
							exceptionHtml.append("�����쳣���ࣺ").append(jsonObj.getString("exceptionFormClass")).append("<br/>");
							exceptionHtml.append("�����쳣�ķ�����").append(jsonObj.getString("exceptionFormMethod")).append("<br/>");
							exceptionHtml.append("����Ĳ�����").append(jsonObj.getString("methodArgs")).append("<br/>");
							exceptionHtml.append("�쳣��Ϣ��").append(jsonObj.getString("exceptionMessge")).append("<br/>");
							exceptionHtml.append("</span>");
						}
					}
				}
			}
		} catch (JSONException e) {
			LHLog.error("JOSN�ַ���ת������");
			e.printStackTrace();
		}
		req.setAttribute("exceptionHtml", exceptionHtml.toString());
		req.setAttribute("exceptionIds", exceptionIds.toString());
		req.setAttribute("exceptionMsgs", exceptionMsgs.toString());
		return exceptionHtml.toString();
	}
	
	
	
}
