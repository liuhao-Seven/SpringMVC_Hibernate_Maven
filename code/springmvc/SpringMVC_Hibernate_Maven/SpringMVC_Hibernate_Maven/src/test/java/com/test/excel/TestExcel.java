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
 * Excel表格生成测试
 * @date 2014-11-25
 * @author 刘浩 
 */
public class TestExcel {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		int choose = 2;
		switch (choose) {
		case 1:
			ExcelHeader header = new ExcelHeader().addColumn("姓名", "name")
					.addColumn("年龄", "age").addColumn("性别", "sex");
			List data = new ArrayList();
			Map p1 = new HashMap();
			p1.put("name", "张三生生世世生生世世生生世世事实上是");
			p1.put("age", new BigDecimal(188823938.11));
			p1.put("sex", "男");
			Map p2 = new HashMap();
			p2.put("name", "李四");
			p2.put("age", "602925050200061904");
			p2.put("sex", "男");
			Map p3 = new HashMap();
			p3.put("name", "王五");
			p3.put("age", 0);
			p3.put("sex", "男");
			data.add(p1);
			data.add(p2);
			data.add(p3);
			try {
				Workbook wb = ExcelUtils
						.getWorkbook(header, "EXCEL创建测试1", data);
				OutputStream os = new FileOutputStream("E:\\model1.xls");
				ExcelUtils.export(os, wb);
				// 测试删除文件使用
				File file = new File("E:\\model1.xls");
				if (file.isFile() && file.exists()) {
					System.out.println("Excel已被删除");
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
				// 测试删除文件使用
//				File file = new File("E:\\model1.xls");
//				if (file.isFile() && file.exists()) {
//					System.out.println("Excel已被删除");
//					file.delete();
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}
}
