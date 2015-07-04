package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lh.base.BaseController;
import com.mvc.progress.FileUploadListener;
/**
 * �ļ��ϴ���������ѯ
 * @description:
 * @author ����
 * @date 2015-6-12 ����1:36:52 
 * @version V1.0  
 *
 */
@Controller
public class FileUploadController extends BaseController{

	/**
	 * process ��ȡ����
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/process.do", method = RequestMethod.POST)
	@ResponseBody
	public void process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FileUploadListener uploadListener = (FileUploadListener)request.getSession().getAttribute("uploadProgressListener");
		if (uploadListener == null) {
			ProcessInfo processInfo = new ProcessInfo();
			processInfo.isfalse = true;
			super.writeToPage(processInfo, response);
		}else{
			super.writeToPage(uploadListener.getProcessInfo(), response);
		}
		
	}

}
