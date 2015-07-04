package com.mvc.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.lh.base.BaseController;


/**
 * 测试PDF在微信段页面显示
 * @description:
 * @author 刘浩
 * @date 2015-6-17 上午10:30:18 
 * @version V1.0  
 *
 */
@Controller
public class PdfController extends BaseController{

	@RequestMapping(value="/exportPdf.do")
	public void pdf(HttpServletRequest request,HttpServletResponse response){
		try {
			Document document = new Document();
//			FunctionUtils.downloadSet(response, "test.pdf", null);
			response.setHeader("Content-Disposition", "attachment;filename=ttt.pdf");
//			response.setContentType("text/plain;charset=utf-8");
			response.setContentType("application/pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			//文档属性
			document.addTitle("PDF测试");
			document.addAuthor("刘浩");
			document.addSubject("PDF测试");
			document.addKeywords("PDF测试");
			document.addCreator("PDF测试");
			
			// 中文处理
			BaseFont bfChinese = BaseFont.createFont("STSongStd-Light",
					"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); 
			// 模板抬头的字体
			Font titleChinese = new Font(bfChinese, 45, Font.BOLD,new BaseColor(
					0, 128, 0)); 
			// 其他所有文字字体
			Font FontChinese = new Font(bfChinese, 14, Font.NORMAL); 
			
//			Font FontLink = new Font(bfChinese,14,Font.UNDERLINE,BaseColor.BLUE);
			//标题
			Paragraph title = new Paragraph("PDF测试", titleChinese);// 抬头  
	        title.setAlignment(Element.ALIGN_CENTER); // 居中设置  
	        title.setLeading(100f);//设置行间距//设置上面空白宽度  
	        document.add(title);

	        Paragraph subtitle = new Paragraph("PDF测试", FontChinese);// 抬头  
	        subtitle.setAlignment(Element.ALIGN_RIGHT); // 居中设置  
	        subtitle.setLeading(100f);//设置行间距//设置上面空白宽度  
	        document.add(subtitle);
			document.close();
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/exportPdf2.do")
	public void pdf2(HttpServletRequest request,HttpServletResponse response){
		try {
			// 以流的形式下载文件。
			System.out.println("======开始");
			InputStream fis = new BufferedInputStream(new FileInputStream("E:\\test\\ccc.pdf"));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
//			FunctionUtils.downloadSet(response, "test.pdf", null);
			response.setHeader("Content-Disposition", "attachment;filename=ccc.pdf");
//			response.setContentType("text/plain;charset=utf-8");
			response.setContentType("application/pdf");
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
			System.out.println("======结束");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
