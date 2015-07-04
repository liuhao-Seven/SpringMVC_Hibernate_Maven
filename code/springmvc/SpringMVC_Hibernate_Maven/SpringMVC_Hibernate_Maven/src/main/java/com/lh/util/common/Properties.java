package com.lh.util.common;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Enumeration;

import com.lh.util.date.DateUtils;

/**
 * 用于Properties文件的使用
 *
 * @date 2014-9-25
 * @author 刘浩
 */
public class Properties extends java.util.Properties{

	private static final long serialVersionUID = 1L;
	
	/**
	 * properties写入文件的方法
	 * @param out	
	 * @param comments	对整个文件的说明
	 * @param charasetName	字符集
	 * @throws IOException
	 * @date 2014-9-25
	 * @author 刘浩
	 */
	public void store(OutputStream out, String comments,String charasetName) throws IOException {
		 store0(new BufferedWriter(new OutputStreamWriter(out, charasetName)),
		       comments,true);
	}
	
	@SuppressWarnings("rawtypes")
	private void store0(BufferedWriter bw, String comments, boolean escUnicode)
			throws IOException {
		if (comments != null) {
			writeComments(bw, comments);
		}
		bw.write("#" + DateUtils.getCurrentDateSTime());
		bw.newLine();
		synchronized (this) {
			for (Enumeration e = keys(); e.hasMoreElements();) {
				String key = (String) e.nextElement();
				String val = (String) get(key);
				bw.write(key + "=" + val);
				bw.newLine();
			}
		}
		bw.flush();
	}
	
	private static void writeComments(BufferedWriter bw, String comments)
			throws IOException {
		bw.write("#");
		bw.write(comments);
		bw.newLine();
	}
	
}
