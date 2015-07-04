package com.test.excel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.google.gson.Gson;
import com.lh.util.excel.ExcelHeader;

/**
 * 获取excel生成的测试数据
 * @date 2014-11-25
 * @author 刘浩 
 */
public class GetTestJsonData {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String getJsonString() {
		ExcelHeader header =  new  ExcelHeader().addColumn("姓名","name")
				.addColumn("年龄","age").addColumn("性别","sex");
		Gson gson = new Gson();
		List data = new ArrayList();
    	Map p1= new HashMap();
    	p1.put("name", "张三生生世世生生世世生生世世事实上是");
    	p1.put("age", new BigDecimal(188823938.11));
    	p1.put("sex", "男");
    	Map p2= new HashMap();
    	p2.put("name", "李四");
    	p2.put("age", "123");
    	p2.put("sex", "男");
    	Map p3= new HashMap();
    	p3.put("name", "王五");
    	p3.put("age", 0);
    	p3.put("sex", "男");
		data.add(p1);
		data.add(p2);
		data.add(p3);
		while(data.size() < 600){
			data.add(p3);
		}
		HashMap map = new HashMap();
		map.put("data", data);
		map.put("header", header);
		String json = gson.toJson(map);
		return json;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static JSONArray getJSONArray() {
		List data = new ArrayList();
    	Map p1= new HashMap();
    	p1.put("name", "张三生生世世生生世世生生世世事实上是");
    	p1.put("age", new BigDecimal(188823938.11));
    	p1.put("sex", "男");
    	Map p2= new HashMap();
    	p2.put("name", "李四");
    	p2.put("age", "602925050200061904");
    	p2.put("sex", "男");
    	Map p3= new HashMap();
    	p3.put("name", "王五");
    	p3.put("age", 0);
    	p3.put("sex", "男");
		data.add(p1);
		data.add(p2);
		data.add(p3);
		HashMap map = new HashMap();
		map.put("data", data);
		return JSONArray.fromObject(map);
	}
	
	public static void main(String[] args) {
		System.out.println(GetTestJsonData.getJsonString());
	}
}
