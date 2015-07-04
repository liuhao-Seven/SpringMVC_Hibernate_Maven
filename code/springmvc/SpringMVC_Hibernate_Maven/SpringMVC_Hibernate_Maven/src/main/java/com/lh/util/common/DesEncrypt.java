package com.lh.util.common;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * ʹ��DES���������,�ɶ�byte[],String���ͽ��м�������� ���Ŀ�ʹ��String,byte[]�洢.
 * 
 * ����: void getKey(String strKey)��strKey����������һ��Key
 * 
 * String getEncString(String strMing)��strMing���м���,����String���� String
 * getDesString(String strMi)��strMin���н���,����String����
 * 
 * byte[] getEncCode(byte[] byteS)byte[]�͵ļ��� byte[] getDesCode(byte[]
 * byteD)byte[]�͵Ľ���
 */
public class DesEncrypt {
	Key key;

	/**
	 * ���ݲ�������KEY
	 * 
	 * @param strKey
	 */
	public void getKey(String strKey) {
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey.getBytes()));
			this.key = _generator.generateKey();
			_generator = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����String��������,String�������
	 * 
	 * @param strMing
	 * @return
	 */
	public String getEncString(String strMing) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byteMing = strMing.getBytes("UTF8");
			byteMi = this.getEncCode(byteMing);
			strMi = base64en.encode(byteMi);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			base64en = null;
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * ���� ��String��������,String�������
	 * 
	 * @param strMi
	 * @return
	 */
	public String getDesString(String strMi) {
		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = base64De.decodeBuffer(strMi);
			byteMing = this.getDesCode(byteMi);
			strMing = new String(byteMing, "UTF8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			base64De = null;
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * ������byte[]��������,byte[]�������
	 * 
	 * @param byteS
	 * @return
	 */
	public byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * ������byte[]��������,��byte[]�������
	 * 
	 * @param byteD
	 * @return
	 */
	public byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		byte[] newBy = null;
		try {
			if ((byteD.length % 8) != 0) {
				newBy = new byte[byteD.length + (8 - (byteD.length % 8))];
				for (int k = 0; k < byteD.length; k++) {
					newBy[k] = byteD[k];
				}
				for (int k = byteD.length; k < newBy.length; k++) {
					newBy[k] = 0x00;// ����Ĳ�0x00
				}
			} else {
				newBy = byteD;
			}
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(newBy);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	public static void main(String[] args) {
		System.out.println("<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
		DesEncrypt des = new DesEncrypt();// ʵ����һ������
		des.getKey("02166770");// �����ܳ�
		System.out.println("key=02166770");
		String strEnc = des
				.getEncString("230100360001E10ADC3949BA59ABBE56E057F20F883E");// �����ַ���,����String������
		System.out.println("����=" + strEnc);
		// String strDes = des.getDesString("�r?=,�F��#>e?");//��String ���͵����Ľ���
		String strDes = des
				.getDesString("8lT2H3lPT9LjWAC0DUoAaJaxOeuiwDFPFwYJES8cfSjhLfsI2u6HqyJP1mnwKH5x");// ��String
																									// ���͵����Ľ���
		System.out.println("����=" + strDes);
	}
}
