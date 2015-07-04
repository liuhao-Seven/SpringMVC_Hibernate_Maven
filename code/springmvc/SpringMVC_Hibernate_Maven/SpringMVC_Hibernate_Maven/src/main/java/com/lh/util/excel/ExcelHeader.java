package com.lh.util.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * Excel��ͷ
 *
 * @author ����
 * @date 2014-8-18
 */
public class ExcelHeader {
	
	public static final String COLUMNS_NAME="name";//Excel ͷ��ÿ�е���??
	public static final String COLUMNS_INDEX="index";// Excel ÿ��ÿ�е���??,ÿ�ж�Ӧ??��map��һ������������ȡ��ÿ�������Map�����Ի�??
	
	private Map<String,String>[] columns;
	
	/**
	 * ��� Excel ͷ��
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

