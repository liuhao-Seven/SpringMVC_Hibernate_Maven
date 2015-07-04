package com.test.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import com.lh.util.excel.ExcelHeader;
import com.lh.util.excel.ExcelUtils;

/**
 * Excel������ɲ���
 * @date 2014-11-25
 * @author ���� 
 */
public class TestExcel {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		int choose = 2;
		switch (choose) {
		case 1:
			ExcelHeader header = new ExcelHeader().addColumn("����", "name")
					.addColumn("����", "age").addColumn("�Ա�", "sex");
			List data = new ArrayList();
			Map p1 = new HashMap();
			p1.put("name", "������������������������������ʵ����");
			p1.put("age", new BigDecimal(188823938.11));
			p1.put("sex", "��");
			Map p2 = new HashMap();
			p2.put("name", "����");
			p2.put("age", "602925050200061904");
			p2.put("sex", "��");
			Map p3 = new HashMap();
			p3.put("name", "����");
			p3.put("age", 0);
			p3.put("sex", "��");
			data.add(p1);
			data.add(p2);
			data.add(p3);
			try {
				Workbook wb = ExcelUtils
						.getWorkbook(header, "EXCEL��������1", data);
				OutputStream os = new FileOutputStream("E:\\model1.xls");
				ExcelUtils.export(os, wb);
				// ����ɾ���ļ�ʹ��
				File file = new File("E:\\model1.xls");
				if (file.isFile() && file.exists()) {
					System.out.println("Excel�ѱ�ɾ��");
					file.delete();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			String jsonString = GetTestJsonData.getJsonString();
			try {
				Workbook wb = ExcelUtils.JsonToWork(jsonString, "ceshi");
				OutputStream os = new FileOutputStream("E:\\model1.xls");
				ExcelUtils.export(os, wb);
				System.out.println("over");
				// ����ɾ���ļ�ʹ��
//				File file = new File("E:\\model1.xls");
//				if (file.isFile() && file.exists()) {
//					System.out.println("Excel�ѱ�ɾ��");
//					file.delete();
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}
}
