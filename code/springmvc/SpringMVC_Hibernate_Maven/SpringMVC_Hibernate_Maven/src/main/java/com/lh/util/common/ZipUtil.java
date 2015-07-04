package com.lh.util.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ZipUtil {

	/**
	 *  压缩
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static String compress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();
		return out.toString("ISO-8859-1");
	}

	/**
	 * 解压缩
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static String unCompress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(str
				.getBytes("ISO-8859-1"));
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[256];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		// toString()使用平台默认编码，也可以显式的指定如toString("GBK")
		return out.toString("GBK");
	}

	public static String zipString(String str) {
		try {
			ByteArrayOutputStream bos = null;
			GZIPOutputStream os = null;
			byte[] bs = null;
			try {
				bos = new ByteArrayOutputStream();
				os = new GZIPOutputStream(bos);
				os.write(str.getBytes());
				os.close();
				bos.close();
				bs = bos.toByteArray();
				return new String(bs, "iso-8859-1");
			} finally {
				bs = null;
				bos = null;
				os = null;
			}

		} catch (Exception e) {
			return str;
		}
	}

	public static String unzipString(String str) {
		ByteArrayInputStream bis = null;
		ByteArrayOutputStream bos = null;
		GZIPInputStream is = null;
		byte[] buf = null;
		try {
			bis = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
			bos = new ByteArrayOutputStream();
			is = new GZIPInputStream(bis);
			buf = new byte[1024];
			int len;
			while ((len = is.read(buf)) != -1) {
				bos.write(buf, 0, len);
			}
			is.close();
			bis.close();
			bos.close();
			return new String(bos.toByteArray());
		} catch (Exception ex) {
			return str;
		} finally {
			bis = null;
			bos = null;
			is = null;
			buf = null;
		}
	}

}
