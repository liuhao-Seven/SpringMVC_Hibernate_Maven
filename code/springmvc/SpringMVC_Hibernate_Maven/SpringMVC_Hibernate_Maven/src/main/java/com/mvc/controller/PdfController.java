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
 * ����PDF��΢�Ŷ�ҳ����ʾ
 * @description:
 * @author ����
 * @date 2015-6-17 ����10:30:18 
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
			//�ĵ�����
			document.addTitle("PDF����");
			document.addAuthor("����");
			document.addSubject("PDF����");
			document.addKeywords("PDF����");
			document.addCreator("PDF����");
			
			// ���Ĵ���
			BaseFont bfChinese = BaseFont.createFont("STSongStd-Light",
					"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); 
			// ģ��̧ͷ������
			Font titleChinese = new Font(bfChinese, 45, Font.BOLD,new BaseColor(
					0, 128, 0)); 
			// ����������������
			Font FontChinese = new Font(bfChinese, 14, Font.NORMAL); 
			
//			Font FontLink = new Font(bfChinese,14,Font.UNDERLINE,BaseColor.BLUE);
			//����
			Paragraph title = new Paragraph("PDF����", titleChinese);// ̧ͷ  
	        title.setAlignment(Element.ALIGN_CENTER); // ��������  
	        title.setLeading(100f);//�����м��//��������հ׿��  
	        document.add(title);

	        Paragraph subtitle = new Paragraph("PDF����", FontChinese);// ̧ͷ  
	        subtitle.setAlignment(Element.ALIGN_RIGHT); // ��������  
	        subtitle.setLeading(100f);//�����м��//��������հ׿��  
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
			// ��������ʽ�����ļ���
			System.out.println("======��ʼ");
			InputStream fis = new BufferedInputStream(new FileInputStream("E:\\test\\ccc.pdf"));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// ���response
			response.reset();
//			FunctionUtils.downloadSet(response, "test.pdf", null);
			response.setHeader("Content-Disposition", "attachment;filename=ccc.pdf");
//			response.setContentType("text/plain;charset=utf-8");
			response.setContentType("application/pdf");
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
			System.out.println("======����");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
