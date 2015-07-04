package com.lh.util.common;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/******************************************
 * <p>Title: DESede</p>
 * <p>Description:DES加解密方法</p> 
 * <p>Copyright: Copyright (c) 2011</p> 
 * <p>Company: 福州创昱达信息技术有限公司</p> 
 * @author lucas
 * @version 1.0
 * 2011 6:25:41 PM
 ******************************************/
public class DESede {
	static {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
	}
	/**
	 * DES解密返回字节数组
	 * @param byteD  解码字符的字节数组
	 * @param k   密钥的字节数组
	 * @return byteFina 解密后返回的字节数组
	 * @throws Exception
	 * @author 朱冬生 2011-09-06
	 */
	public static byte[] decrypt(byte[] byteD, byte[] k) throws Exception {
		byte[] keyBytes = k;
		SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NOPADDING");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] newBy = null;
		byte[] byteFina=null;
		if ((byteD.length % 8) != 0) {
			newBy = new byte[byteD.length + (8-(byteD.length % 8))];
			for (int i = 0;i < byteD.length;i++) {
				newBy[i] = byteD[i];
			}
			for (int i = byteD.length; i < newBy.length;i++) {
				newBy[i] = 0x00;//不足的补0x00
			}
		} else {
			newBy = byteD;
		}
		byteFina = cipher.doFinal(newBy);
		return byteFina;
	}
	/**
	 * DES解密返回字符
	 * @param byteD  解码字符的字节数组
	 * @param k   密钥的字节数组
	 * @return result 解密后返回的字符
	 * @throws Exception
	 * @author 朱冬生 2011-09-06
	 */
	public static String decryptString(byte[] byteD, byte[] k) throws Exception {
		byte[] keyBytes = k;
		SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NOPADDING");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] newBy = null;
		byte[] byteFina=null;
		if ((byteD.length % 8) != 0) {
			newBy = new byte[byteD.length + (8-(byteD.length % 8))];
			for (int i = 0;i < byteD.length;i++) {
				newBy[i] = byteD[i];
			}
			for (int i = byteD.length; i < newBy.length;i++) {
				newBy[i] = 0x00;//不足的补0x00
			}
		} else {
			newBy = byteD;
		}
		byteFina = cipher.doFinal(newBy);
		String result = new String(byteFina).trim();
		return result;
	}
	/**
	 * DES加密
	 * @param msg 加密字符的字节数组
	 * @param pass   密钥的字节数组
	 * @return byteFina DES解密后返回的字符数组
	 * @throws Exception
	 * @author 朱冬生 2011-09-06
	 */
	public static byte[] encrypt(byte[] msg, byte[] pass) throws Exception {

		byte[] keyBytes = pass;

		SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NOPADDING"); // TripleDES/ECB/NoPadding

		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] newBy = null;
		byte[] byteFina=null;
		if ((msg.length % 8) != 0) {
			newBy = new byte[msg.length + (8-(msg.length % 8))];
			for (int i = 0;i < msg.length;i++) {
				newBy[i] = msg[i];
			}
			for (int i = msg.length; i < newBy.length;i++) {
				newBy[i] = 0x00;//不足的补0x00
			}
		} else {
			newBy = msg;
		}
		byteFina = cipher.doFinal(newBy);

		return byteFina;
	}
	/**
	 * 字节码转换成16进制字符串
	 * @param b 需要转换的字节码
	 * @return hs 转换后的16进制字符串
	 * @throws Exception
	 * @author 朱冬生 2011-09-06
	 */
	public static String byte2hex(byte[] b){
		String hs = "";
		String stmp = "";
		for(int i = 0;i < b.length;i++){
			stmp = Integer.toHexString(b[i] & 0xFF);
			if(stmp.length() == 1) hs += "0" + stmp;
			else hs += stmp;
		}
		return hs.toUpperCase();
	}
	/**
	 * 将16进制字符串转换成字节码
	 * @param hex 需要转换的16进制字符
	 * @return b 转换后的字节数组
	 * @throws Exception
	 * @author 朱冬生 2011-09-06
	 */
	public static byte[] hex2byte(String hex) throws IllegalArgumentException{
		if(hex.length() % 2 != 0)
			throw new IllegalArgumentException("不是2的倍数");
		char[] arr = hex.toCharArray();
		byte[] b = new byte[hex.length()/2];
		for(int i = 0,j = 0,l = hex.length();i < l;i++,j++){
			String swap = "" + arr[i++] + arr[i];
			int byteint = Integer.parseInt(swap,16) & 0xFF;
			b[j] = new Integer(byteint).byteValue();
		}
		String a = "";
		for(int i = 0;i<b.length;i++){
			a = a+b[i];
		}
		return b;
	}     
	public static void main(String[] args) {
		try {
			byte[] printD = new byte[1200];
			String str = "朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱朱冬生朱冬生朱冬生朱";
			System.out.println(str.length());
			printD = str.getBytes();
			System.out.println(printD.length);
//			System.out.println(new String(printD).trim());
//			System.out.println("><><><><><><><><><><><><><><><><><><><><><");
			System.out.println(byte2hex(encrypt(printD,"CCIC2010ssssssss".getBytes())));
//			System.out.println(encrypt(printD,"CCIC2010".getBytes()).length);
//			
//			System.out.println("><><><><><><><><><><><><><><><><><><><><><");
//			byte[] printE = encrypt("中国".getBytes(),"CCIC2010".getBytes());
//			System.out.println(byte2hex(printE));
//			System.out.println("><><><><><><><><><><><><><><><><><><><><><");
//			System.out.println(decryptString(printE,"CCIC2010".getBytes()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

