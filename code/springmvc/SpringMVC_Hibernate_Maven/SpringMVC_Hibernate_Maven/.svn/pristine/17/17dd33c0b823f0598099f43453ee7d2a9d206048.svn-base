package com.lh.util.common;

import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * 对密码进行加密和解密，不允许被继承final
 * @author 刘浩
 * @date 2014-8-21
 *
 */
public final class Encrypt {

	private static final String Algorithm = "DES"; //定义 加密算法,可用 DES,DESede,Blowfish
	private static final byte[] encodedKey = new byte[] { -50, -43, 19, 112,
			-14, -122, 103, -111 };// des密匙

	/**
	 * 对字符串采用md5计算摘要
	 * @param deirect 欲计算摘要的串
	 * @return 摘要串
	 */
	public static String getDigest(String originalInfo) throws Exception {
		java.security.MessageDigest alg;
		try {
			alg = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception("计算摘要失败", ex);
		}
		alg.update(originalInfo.getBytes());
		byte[] digest = alg.digest();
		return byte2hex(digest);
	}

	/**
	 * 对字符串采用md5计算摘要,byte数组增加了一个0
	 * @param deirect 欲计算摘要的串
	 * @return 摘要串
	 */
	public static String getDigestSelf(String originalInfo) throws Exception {
		java.security.MessageDigest alg;
		try {
			alg = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception("计算摘要失败", ex);
		}
		byte[] bytesOld = originalInfo.getBytes();
		byte[] bytesNew = new byte[bytesOld.length + 1];
		bytesNew[bytesOld.length] = 0;
		alg.update(bytesNew);
		byte[] digest = alg.digest();
		return byte2hex(digest);
	}

	/**
	 * 字节数组转十六进制字符串
	 * @param b欲转换的二行制数组
	 * @return 转换后的字符串
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			//8位字节，用0～9a~f表示为两位16进制数
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	public static byte[] hex2byte(String a) {
		int len = a.length() / 2;
		byte[] b = new byte[len];
		for (int i = 0; i < len; i++) {
			//使用 16 进制把字符串转换成 Integer 型
			b[i] = (byte) Integer.parseInt(a.substring(i * 2, i * 2 + 2), 16);
		}
		return b;
	}

	/**
	 * 对字符串加密
	 *
	 * @param source String
	 * @return 加密后的串
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
			return byte2hex(cipherByte);
		} catch (Exception ex) {
			throw new Exception("加密失败", ex);
		}
	}

	/**
	 * 对字符串解密
	 *
	 * @param source 欲解密的串
	 * @return 解密后的串
	 * @throws YjException
	 */
	public static String decrypt(String source) throws Exception {
		try {
			Security.addProvider(new com.sun.crypto.provider.SunJCE());
			javax.crypto.spec.SecretKeySpec destmp = new javax.crypto.spec.SecretKeySpec(
					encodedKey, Algorithm);
			SecretKey deskey = destmp;
			Cipher c1 = Cipher.getInstance(Algorithm);
			//解密
			c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			byte[] clearByte = c1.doFinal(hex2byte(source));
			return new String(clearByte);
		} catch (Exception ex) {
			throw new Exception("解密失败", ex);
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
}