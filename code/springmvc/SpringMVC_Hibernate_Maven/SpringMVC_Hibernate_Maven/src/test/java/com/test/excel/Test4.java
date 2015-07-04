package com.test.excel;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.lh.util.excel.ExcelHeader;

/**
 *
 * @date 2014-11-25
 * @author ¡ı∫∆ 
 */
public class Test4 {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		String jsonString = GetTestJsonData.getJsonString();
		Gson gson = new Gson();
    	HashMap map = gson.fromJson(jsonString, new TypeToken<HashMap>(){}.getType());
    	LinkedTreeMap headerMap = (LinkedTreeMap) map.get("header");
    	ArrayList list = (ArrayList) headerMap.get("columns");
    	ExcelHeader header =  new  ExcelHeader();
    	for (int i = 0; i < list.size(); i++) {
    		LinkedTreeMap<String,String> m = (LinkedTreeMap) list.get(i);
			header.addColumn(m.get("name"), m.get("index"));
		}
	}
}
