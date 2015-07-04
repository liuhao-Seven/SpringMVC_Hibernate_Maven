package com.lh.configuration;

import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * ��������м��ܺͽ��ܣ��������̳�final
 * 
 * @author
 * */

public final class Encrypt {

	private static final String Algorithm = "DES"; // ���� �����㷨,����
													// DES,DESede,Blowfish
	private static final byte[] encodedKey = new byte[] { -50, -43, 19, 112,
			-14, -122, 103, -111 };// des�ܳ�

	/**
	 * ���ַ�������md5����ժҪ
	 * 
	 * @param deirect
	 *            ������ժҪ�Ĵ�
	 * @return ժҪ��
	 */
	public static String getDigest(String originalInfo) throws Exception {
		java.security.MessageDigest alg;
		try {
			alg = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception("����ժҪʧ��", ex);
		}
		alg.update(originalInfo.getBytes());
		byte[] digest = alg.digest();
		return byte2hex(digest);
	}

	/**
	 * ���ַ�������md5����ժҪ,byte����������һ��0
	 * 
	 * @param deirect
	 *            ������ժҪ�Ĵ�
	 * @return ժҪ��
	 */
	public static String getDigestSelf(String originalInfo) throws Exception {
		java.security.MessageDigest alg;
		try {
			alg = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception("����ժҪʧ��", ex);
		}
		byte[] bytesOld = originalInfo.getBytes();
		byte[] bytesNew = new byte[bytesOld.length + 1];
		bytesNew[bytesOld.length] = 0;
		alg.update(bytesNew);
		byte[] digest = alg.digest();
		return byte2hex(digest);
	}

	/**
	 * �ֽ�����תʮ�������ַ���
	 * 
	 * @param b��ת���Ķ���������
	 * @return ת������ַ���
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			// 8λ�ֽڣ���0��9a~f��ʾΪ��λ16������
			// System.out.println("b["+n+"]===="+b[n]);
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			// System.out.println("temp:---"+stmp);
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
				// if (n < b.length - 1)
				// hs = hs + ":";
			}
		}
		return hs.toUpperCase();
	}

	public static byte[] hex2byte(String a) {
		int len = a.length() / 2;
		byte[] b = new byte[len];
		for (int i = 0; i < len; i++) {
			// ʹ�� 16 ���ư��ַ���ת���� Integer ��
			b[i] = (byte) Integer.parseInt(a.substring(i * 2, i * 2 + 2), 16);
		}
		return b;
	}

	/**
	 * ���ַ�������
	 * 
	 * @param source
	 *            String
	 * @return ���ܺ�Ĵ�
	 * @throws YjException
	 */
	public static String encrypt(String source) throws Exception {
		try {
			Security.addProvider(new com.sun.crypto.provider.SunJCE());
			javax.crypto.spec.SecretKeySpec destmp = new javax.crypto.spec.SecretKeySpec(
					encodedKey, Algorithm);
			SecretKey deskey = destmp;
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			byte[] cipherByte = c1.doFinal(source.getBytes());
			// System.out.println("���ܺ�Ķ�����:" + byte2hex(cipherByte));
			return byte2hex(cipherByte);
		} catch (Exception ex) {
			throw new Exception("����ʧ��", ex);
		}
	}

	/**
	 * ���ַ�������
	 * 
	 * @param source
	 *            �����ܵĴ�
	 * @return ���ܺ�Ĵ�
	 * @throws YjException
	 */
	public static String decrypt(String source) throws Exception {
		try {
			Security.addProvider(new com.sun.crypto.provider.SunJCE());
			javax.crypto.spec.SecretKeySpec destmp = new javax.crypto.spec.SecretKeySpec(
					encodedKey, Algorithm);
			SecretKey deskey = destmp;
			Cipher c1 = Cipher.getInstance(Algorithm);
			// ����
			c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			byte[] clearByte = c1.doFinal(hex2byte(source));
			return new String(clearByte);
		} catch (Exception ex) {
			throw new Exception("����ʧ��", ex);
		}
	}

	public static String getKey() throws NoSuchAlgorithmException {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		KeyGenerator keygen = KeyGenerator.getInstance(Algorithm);
		SecretKey deskey = keygen.generateKey();
		byte[] byteKey = deskey.getEncoded();
		String key = byte2hex(byteKey);

		return key;
	}

	/********************************* �����ǹ�˾����Ŀʹ�õļӽ��ܷ��� **********************************/
	/**
	 * ���ܹ�Կ�ִ�
	 */
	public static String pwdstrs = ":3!@XSK#$GyTuVB%2^&C*t(dfD)_+?rFHJs6/>4iop9A5LZ 8a.<,{zUIxc}[]'|ERY\\10qwPeg7hjklNMv=-bnm~`QWO";

	/**
	 * ����
	 * 
	 * @param data
	 */
	public static String encrypt_data(String data) {
		if (StringUtils.isBlank((data))) {
			System.out.println("�մ����ܼ���");
			return "";
		}
		char pwds[] = data.toCharArray();
		String posi[] = new String[pwds.length];
		for (int x = 0; x < pwds.length; x++) {
			int n = pwdstrs.indexOf(pwds[x]);
			if (n < 0) {
				System.out.println(pwds[x]);
				System.out.println("�в�����ʾ�ַ����ڣ�����ʧ��");
				return "";
			}

			if (n < 10) {
				posi[x] = "0" + n;
			} else {
				posi[x] = "" + n;
			}

		}

		data = "";
		for (int x = 0; x < posi.length; x++) {
			data = data + posi[x];
		}
		return data;
	}

	public static String dencrypt_data(String data) {
		if (StringUtils.isBlank((data))) {
			System.out.println("�մ�������ʧ��");
			return data;
		}
		int len = data.length();
		if ((len % 2) != 0) {
			System.out.println("ԭ���д��󣬽���ʧ��");
			return "";
		}
		int m = 0;

		char unpwd[] = new char[data.length() / 2];
		for (int x = 0; x < unpwd.length; x++) {
			String tmps = data.substring(x * 2, x * 2 + 2);
			try {
				m = Integer.parseInt(tmps);
			} catch (Exception e) {
				System.out.println("ԭ���д��󣬽���ʧ��");
				return "";
			}
			unpwd[x] = pwdstrs.charAt(m);
		}

		data = "";
		for (int x = 0; x < unpwd.length; x++) {
			data = data + unpwd[x];
		}
		return data;
	}

	public static void main(String[] args) {
		try {
			System.out.println(Encrypt.encrypt_data("lastydcd"));
			System.out.println(Encrypt.dencrypt_data("87867410493958"));
			System.out.println(Encrypt.encrypt_data("root"));
			System.out.println(Encrypt.encrypt_data("mysql"));
			System.out.println(Encrypt.encrypt_data("dyx"));
			System.out.println(Encrypt.encrypt_data("dyxdbtest"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}