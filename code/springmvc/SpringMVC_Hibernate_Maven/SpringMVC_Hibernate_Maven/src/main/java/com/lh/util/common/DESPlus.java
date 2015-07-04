package com.lh.util.common;

import java.security.*;
import javax.crypto.*;

public class DESPlus {
	private static String strDefaultKey = "national";
	private static Cipher encryptCipher = null;
	private static Cipher decryptCipher = null;
	private static Key key;
	static{
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			byte[] arrBTmp = Constants.MIYUE.getBytes();
			// ����һ���յ�8λ�ֽ����飨Ĭ��ֵΪ0��
			byte[] arrB = new byte[8];
			// ��ԭʼ�ֽ�����ת��Ϊ8λ
			for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
				arrB[i] = arrBTmp[i];
			}
			// ������Կ
			key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
			encryptCipher = Cipher.getInstance("DES");
			encryptCipher.init(Cipher.ENCRYPT_MODE, key);
			decryptCipher = Cipher.getInstance("DES");
			decryptCipher.init(Cipher.DECRYPT_MODE, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ĭ�Ϲ��췽����ʹ��Ĭ����Կ
	 * 
	 * @throws Exception
	 */
	public DESPlus() throws Exception {
		this(strDefaultKey);
	}

	/**
	 * ָ����Կ���췽��
	 * 
	 * @param strKey
	 *            ָ������Կ
	 * @throws Exception
	 */
	public DESPlus(String strKey) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			key = getKey(strKey.getBytes());
			encryptCipher = Cipher.getInstance("DES");
			encryptCipher.init(Cipher.ENCRYPT_MODE, key);
			decryptCipher = Cipher.getInstance("DES");
			decryptCipher.init(Cipher.DECRYPT_MODE, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��byte����ת��Ϊ��ʾ16����ֵ���ַ����� �磺byte[]{8,18}ת��Ϊ��0813�� ��public static byte[]
	 * hexStr2ByteArr(String strIn) ��Ϊ�����ת������
	 * 
	 * @param arrB
	 *            ��Ҫת����byte����
	 * @return ת������ַ���
	 * @throws Exception
	 *             �������������κ��쳣�������쳣ȫ���׳�
	 */
	public static String byteArr2HexStr(byte[] arrB) {
		int iLen = arrB.length;
		// ÿ��byte�������ַ����ܱ�ʾ�������ַ����ĳ��������鳤�ȵ�����
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// �Ѹ���ת��Ϊ����
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// С��0F������Ҫ��ǰ�油0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * ����ʾ16����ֵ���ַ���ת��Ϊbyte���飬 ��public static String byteArr2HexStr(byte[] arrB)
	 * ��Ϊ�����ת������
	 * 
	 * @param strIn
	 *            ��Ҫת�����ַ���
	 * @return ת�����byte����
	 */
	public static byte[] hexStr2ByteArr(String strIn) {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
		// �����ַ���ʾһ���ֽڣ������ֽ����鳤�����ַ������ȳ���2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	/**
	 * �����ֽ�����
	 */
	public static byte[] encrypt(byte[] arrB) {
		byte[] s = null;
		try {
			s = encryptCipher.doFinal(arrB);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * ���� strIn
	 */
	public static String encrypt(String strIn) {
		return byteArr2HexStr(encrypt(strIn.getBytes()));
	}

	/**
	 * �����ֽ�����
	 */
	public static byte[] decrypt(byte[] arrB) {
		byte[] s = null;
		try {
			s = decryptCipher.doFinal(arrB);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * ���� strIn
	 */
	public static String decrypt(String strIn) {
		return new String(decrypt(hexStr2ByteArr(strIn)));
	}

	/**
	 * ��ָ���ַ���������Կ����Կ������ֽ����鳤��Ϊ8λ ����8λʱ���油0������8λֻȡǰ8λ
	 * 
	 * @param arrBTmp
	 *            ���ɸ��ַ������ֽ�����
	 * @return ���ɵ���Կ
	 * @throws java.lang.Exception
	 */
	private static Key getKey(byte[] arrBTmp) {
		// ����һ���յ�8λ�ֽ����飨Ĭ��ֵΪ0��
		byte[] arrB = new byte[8];
		// ��ԭʼ�ֽ�����ת��Ϊ8λ
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}
		// ������Կ
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
		return key;
	}

	/**
	 * ÿ8λ��һ���������
	 * 
	 * @param by
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static byte[] getByteYH(byte[] by) {
		byte[] newBy = null;
		DESPlus des = new DESPlus("CCIC"); // �Զ�����Կ
		if ((by.length % 8) != 0) {
			newBy = new byte[by.length + (8 - (by.length % 8))];
			for (int k = 0; k < by.length; k++) {
				newBy[k] = by[k];
			}
			for (int k = by.length; k < newBy.length; k++) {
				newBy[k] = 0x00;// ����Ĳ�0x00
			}
		} else {
			newBy = by;
		}
		int i = newBy.length / 8;
		byte aa[] = new byte[8];
		aa[0] = newBy[0];
		aa[1] = newBy[1];
		aa[2] = newBy[2];
		aa[3] = newBy[3];
		aa[4] = newBy[4];
		aa[5] = newBy[5];
		aa[6] = newBy[6];
		aa[7] = newBy[7];

		byte bb[] = new byte[8];

		for (int k = 1; k < i; k++) {
			for (int j = 0; j < 8; j++) {
				bb[k] = newBy[k * 8 + j];
			}
			aa[0] = (byte) (aa[0] ^ bb[0]);
			aa[1] = (byte) (aa[1] ^ bb[1]);
			aa[2] = (byte) (aa[2] ^ bb[2]);
			aa[3] = (byte) (aa[3] ^ bb[3]);
			aa[4] = (byte) (aa[4] ^ bb[4]);
			aa[5] = (byte) (aa[5] ^ bb[5]);
			aa[6] = (byte) (aa[6] ^ bb[6]);
			aa[7] = (byte) (aa[7] ^ bb[7]);
			String test = new String(aa);
			aa = des.encrypt(test.trim()).getBytes();
		}
		return aa;

	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try {
			System.out.println(DESPlus.key);
			DESPlus des = new DESPlus("usernam\\"); // �Զ�����Կ
			System.out.println(DESPlus.key);
			System.out.println("���ܺ�"+des.encrypt("111111"));
			System.out.println("���ܺ�"+des.decrypt("6e5c2e52bb93388f"));
//			System.out.println("���ܺ�"+des.decrypt("d1b06421aa4d4ff6"));

			System.out.println("���ܺ�"+DESPlus.encrypt("111111"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
