package com.lh.util.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * Excel表头
 *
 * @author 刘浩
 * @date 2014-8-18
 */
public class ExcelHeader {
	
	public static final String COLUMNS_NAME="name";//Excel 头的每列的名??
	public static final String COLUMNS_INDEX="index";// Excel 每行每列的索??,每行对应??个map或一个对象，用索引取出每个对象或Map的属性或??
	
	private Map<String,String>[] columns;
	
	/**
	 * 添加 Excel 头列
	 *
	 * @param columnName
	 * @param columnIndex
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ExcelHeader addColumn(String columnName, String columnIndex){
		if(columns==null){
			columns = new Map[1];
			Map<String,String> t=new HashMap<String,String>();
			t.put(COLUMNS_NAME, columnName);
			t.put(COLUMNS_INDEX, columnIndex);
			columns[0] = t;
		}else{
			int len=columns.length;
			Map[] temp = new Map[len+1];
			for(int i=0;i<len;i++){
				temp[i]=columns[i];
			}
			Map<String,String> t=new HashMap<String,String>();
			t.put(COLUMNS_NAME, columnName);
			t.put(COLUMNS_INDEX, columnIndex);
			temp[len]=t;
			columns=temp;
		}
		return this;
	}
	
	public Map<String, String>[] getColumns() {
		return columns;
	}
}

