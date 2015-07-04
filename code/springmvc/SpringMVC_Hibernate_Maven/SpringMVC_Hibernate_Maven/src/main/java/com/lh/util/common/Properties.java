package com.lh.util.common;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Enumeration;

import com.lh.util.date.DateUtils;

/**
 * ����Properties�ļ���ʹ��
 *
 * @date 2014-9-25
 * @author ����
 */
public class Properties extends java.util.Properties{

	private static final long serialVersionUID = 1L;
	
	/**
	 * propertiesд���ļ��ķ���
	 * @param out	
	 * @param comments	�������ļ���˵��
	 * @param charasetName	�ַ���
	 * @throws IOException
	 * @date 2014-9-25
	 * @author ����
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
