package com.lh.util.common;

import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * Title: DES加密算法类
 * Copyright: Copyright (c) 2002 yipsilon.com
 * @author yipsilon
 * @version 0.1
 */

public class DES {
	public static int _DES = 1;
	public static int _DESede = 2;
	public static int _Blowfish = 3;

	private Cipher p_Cipher;
	private SecretKey p_Key;
	private String p_Algorithm;

	private void selectAlgorithm(int al) {
		switch (al) {
		default:
		case 1:
			this.p_Algorithm = "DES";
			break;
		case 2:
			this.p_Algorithm = "DESede";
			break;
		case 3:
			this.p_Algorithm = "Blowfish";
			break;
		}
	}

	public DES(int algorithm) throws Exception {
		this.selectAlgorithm(algorithm);
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		this.p_Cipher = Cipher.getInstance(this.p_Algorithm);
	}

	public byte[] getKey() {
		return this.checkKey().getEncoded();
	}

	private SecretKey checkKey() {
		try {
			if (this.p_Key == null) {
				KeyGenerator keygen = KeyGenerator
						.getInstance(this.p_Algorithm);
				this.p_Key = keygen.generateKey();
			}
		} catch (NoSuchAlgorithmException nsae) {
		}
		return this.p_Key;
	}

	public void setKey(byte[] enckey) {
		this.p_Key = new SecretKeySpec(enckey, this.p_Algorithm);
	}

	public byte[] encode(byte[] data) throws Exception {
		this.p_Cipher.init(Cipher.ENCRYPT_MODE, this.checkKey());
		return this.p_Cipher.doFinal(data);
	}

	public byte[] decode(byte[] encdata, byte[] enckey) throws Exception {
		this.setKey(enckey);
		this.p_Cipher.init(Cipher.DECRYPT_MODE, this.p_Key);
		return this.p_Cipher.doFinal(encdata);
	}

	public String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int i = 0; i < b.length; i++) {
			stmp = Integer.toHexString(b[i] & 0xFF);
			if (stmp.length() == 1)
				hs += "0" + stmp;
			else
				hs += stmp;
		}
		return hs.toUpperCase();
	}

	public byte[] hex2byte(String hex) throws IllegalArgumentException {
		if (hex.length() % 2 != 0)
			throw new IllegalArgumentException();
		char[] arr = hex.toCharArray();
		byte[] b = new byte[hex.length() / 2];
		for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
			String swap = "" + arr[i++] + arr[i];
			int byteint = Integer.parseInt(swap, 16) & 0xFF;
			b[j] = new Integer(byteint).byteValue();
		}
		return b;
	}

	public static byte[] getMacStr(byte[] macKey, byte[] macValue)
			throws Exception {

//		byte[] key; //密钥文件(byte)
		byte[] reKey = new byte[8];
		byte[] mykey = macKey;//{31,31,31,31,31,31,31,31}; //初始化密钥文件(byte)

		DES des = new DES(DES._DES); // 声明DES
		des.setKey(mykey); //设置密钥文件
//		key = des.getKey(); //获取随机生成的密钥--这里获取的实际上是固定的密钥，呵呵
//		String hexkey = des.byte2hex(key); //生成十六进制密钥
		byte[] enc = des.encode(macValue); //生成加密文件(byte)

//		String hexenc = des.byte2hex(enc); //生成十六进制加密文件
		System.arraycopy(enc, 0, reKey, 0, 8);

		return reKey;//hexenc.substring(0,16);//enc;//hexenc
	}

	public static String getPwdStr(String value) {
		String returnStr = "";
		try {
			byte[] key; //密钥文件(byte)
			byte[] mykey = { 49, 49, 49, 49, 49, 49, 49, 49 }; //初始化密钥文件(byte)

			DES des = new DES(DES._DES); // 声明DES

			des.setKey(mykey); //设置密钥文件
			key = des.getKey(); //获取随机生成的密钥--这里获取的实际上是固定的密钥，呵呵

			String hexkey = des.byte2hex(key); //生成十六进制密钥
			// byte[] enc = des.encode(info.getBytes()); //生成加密文件(byte)
			String hexenc = value + "AD6A88B4FA37833D";//密文

			byte[] b = des.hex2byte(hexenc);//655EA628CF62585FAD6A88B4FA37833D
			byte[] dec1 = des.decode(b, des.hex2byte(hexkey)); //解密文件,其中转换十六进制密钥为byte
			//        System.out.println("decrypted string:" + new String(dec1)); //生成解密文件字符串, 与info相同
			returnStr = new String(dec1);
			return returnStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	public static String getKDCCode(String value, byte[] Km) {
//		String returnStr = "";
//		String tmpValue = "11111111";
//		try {
//			byte[] key; //密钥文件(byte)
//			byte[] mykey = Km; //{49,49,49,49,49,49,49,49}; //初始化密钥文件(byte)
//
//			DES des = new DES(DES._DES); // 声明DES
//
//			des.setKey(mykey); //设置密钥文件
//			key = des.getKey(); //获取随机生成的密钥--这里获取的实际上是固定的密钥，呵呵
//
//			String hexkey = des.byte2hex(key); //生成十六进制密钥
//			//进行临时加密，得到密文后１６位
//			byte[] enc = des.encode(tmpValue.getBytes());
//			String tmphexenc = des.byte2hex(enc);
//
//			// byte[] enc = des.encode(info.getBytes()); //生成加密文件(byte)
//			String hexenc = value
//					+ tmphexenc.substring(tmphexenc.length() - 16, tmphexenc
//							.length()); //密文
//
//			byte[] b = des.hex2byte(hexenc); //655EA628CF62585FAD6A88B4FA37833D
////			byte[] dec1 = des.decode(b, des.hex2byte(hexkey)); //解密文件,其中转换十六进制密钥为byte
//			//      System.out.println("生成解密文件字符串:" + new String(dec1)); //生成解密文件字符串, 与info相同
//			//      returnStr = PackageTool.BcdToAsc(dec1,dec1.length*2);
//			return returnStr;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	public static byte[] strToHex(String arg0) throws Exception {
		byte[] bit = new byte[8];
		for (int k = 0, kk = 0; k < arg0.length(); k += 2, kk++) {
			char tmp1 = arg0.charAt(k);
			char tmp2 = arg0.charAt(k + 1);
			bit[kk] = (byte) (((tmp1 & 0x0f) << 4) | (tmp2 & 0x0f));
		}
		return bit;

	}

	/**
	 * 对明文进行加密
	 * @param macKey
	 * @param macValue
	 * @return
	 * @throws Exception
	 * @author bianzk
	 */
	public static byte[] encrypt(byte[] myKey, byte[] value) throws Exception {

//		byte[] key; //密钥文件(byte)
		byte[] reKey = new byte[8];
		byte[] mykey = myKey;//{31,31,31,31,31,31,31,31}; //初始化密钥文件(byte)

		DES des = new DES(DES._DES); // 声明DES
		des.setKey(mykey); //设置密钥文件
//		key = des.getKey(); //获取随机生成的密钥--这里获取的实际上是固定的密钥，呵呵
//		String hexkey = des.byte2hex(key); //生成十六进制密钥
		byte[] enc = des.encode(value); //生成加密文件(byte)

//		String hexenc = des.byte2hex(enc); //生成十六进制加密文件
		System.arraycopy(enc, 0, reKey, 0, 8);

		return reKey;//hexenc.substring(0,16);//enc;//hexenc
	}

	/**
	 * 对明文进行加密
	 * @param macKey 密钥
	 * @param macValue 密文
	 * @return
	 * @throws Exception
	 * @author bianzk
	 */
	public static String getEncrypt(byte[] myKey, byte[] value)
			throws Exception {

//		byte[] key; //密钥文件(byte)
		byte[] reKey = new byte[8];
		byte[] mykey = myKey;//{31,31,31,31,31,31,31,31}; //初始化密钥文件(byte)

		DES des = new DES(DES._DES); // 声明DES
		des.setKey(mykey); //设置密钥文件
//		key = des.getKey(); //获取随机生成的密钥--这里获取的实际上是固定的密钥，呵呵
//		String hexkey = des.byte2hex(key); //生成十六进制密钥
		byte[] enc = des.encode(value); //生成加密文件(byte)

		String hexenc = des.byte2hex(enc); //生成十六进制加密文件
		System.arraycopy(enc, 0, reKey, 0, 8);

		return hexenc;//hexenc.substring(0,16);//enc;//hexenc
	}

	/**
	 * 解密生成明文
	 * @param value
	 * @param Km
	 * @return
	 */
	public static byte[] uncoil(String value, byte[] Km) {
		String tmpValue = "11111111";
		try {
			byte[] key; //密钥文件(byte)
			byte[] mykey = Km; //{49,49,49,49,49,49,49,49}; //初始化密钥文件(byte)

			DES des = new DES(DES._DES); // 声明DES

			des.setKey(mykey); //设置密钥文件
			key = des.getKey(); //获取随机生成的密钥--这里获取的实际上是固定的密钥，呵呵

			String hexkey = des.byte2hex(key); //生成十六进制密钥
			//进行临时加密，得到密文后１６位
			byte[] enc = des.encode(tmpValue.getBytes());
			String tmphexenc = des.byte2hex(enc);

			// byte[] enc = des.encode(info.getBytes()); //生成加密文件(byte)
			String hexenc = value
					+ tmphexenc.substring(tmphexenc.length() - 16, tmphexenc
							.length()); //密文

			byte[] b = des.hex2byte(hexenc); //655EA628CF62585FAD6A88B4FA37833D
			byte[] dec1 = des.decode(b, des.hex2byte(hexkey)); //解密文件,其中转换十六进制密钥为byte
			//	      System.out.println("生成解密文件字符串:" + new String(dec1)); //生成解密文件字符串, 与info相同
			//	      returnStr = StringUtil.BcdToAsc(dec1,dec1.length*2);
			return dec1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 解密生成明文
	 * @param value 密文
	 * @param Km 密钥
	 * @return
	 */
	public static String getUncoil(String value, byte[] Km) {
		String returnStr = "";
		//	    String tmpValue="11111111";
		try {
			byte[] key; //密钥文件(byte)
			byte[] mykey = Km; //{49,49,49,49,49,49,49,49}; //初始化密钥文件(byte)

			DES des = new DES(DES._DES); // 声明DES

			des.setKey(mykey); //设置密钥文件
			key = des.getKey(); //获取随机生成的密钥--这里获取的实际上是固定的密钥，呵呵

			String hexkey = des.byte2hex(key); //生成十六进制密钥
			//进行临时加密，得到密文后１６位
			//	      byte[] enc = des.encode(tmpValue.getBytes());
			//	      String tmphexenc = des.byte2hex(enc);

			// byte[] enc = des.encode(info.getBytes()); //生成加密文件(byte)
			//	      String hexenc = value + tmphexenc.substring(tmphexenc.length()-16,tmphexenc.length()); //密文

			byte[] b = des.hex2byte(value); //655EA628CF62585FAD6A88B4FA37833D
			byte[] dec1 = des.decode(b, des.hex2byte(hexkey)); //解密文件,其中转换十六进制密钥为byte
			//	      System.out.println("生成解密文件字符串:" + new String(dec1)); //生成解密文件字符串, 与info相同
			returnStr = new String(dec1);
			//	      returnStr = PackageTool.BcdToAsc(dec1,dec1.length*2);
			return returnStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws Exception {

		String key = "CCIC1004";
		String key2 = "CCIC2015";

		//  String by = DES.getEncrypt(key.getBytes(),"8000000000013242011-05-0500:00:00\n<?xml version='1.0' encoding='GB18030'?><ROOT><TRANSDATA><COMCODE>44010000</COMCODE><VOUCHERNO>3000007400000186</VOUCHERNO><CDOPERCODE>4401000001</CDOPERCODE><RATIONCODE>0000000269</RATIONCODE><RISKCODE>EDA</RISKCODE><STARTDATE>2011-04-07</STARTDATE><ENDDATE>2011-05-07</ENDDATE><STARTHOUR>18</STARTHOUR><ENDSTARTHOUR>18</ENDSTARTHOUR><SUMPREMIUM>1.000000</SUMPREMIUM><INSURED><PNAME>王林1</PNAME><GENDER></GENDER><BIRTHDAY></BIRTHDAY><IDTYPE>01</IDTYPE><PID>610102198004107118</PID><PHONE></PHONE><SYTYPE></SYTYPE><SYNAME></SYNAME></INSURED><TICKETINFO><TRAINNO>0011808</TRAINNO><TICKETNO>80000020</TICKETNO><SEATNO>无</SEATNO><TICKETPRICE> 12.2000</TICKETPRICE><STARTTIME>2011-04-07 18:00:00</STARTTIME><ENDTIME></ENDTIME><STARTTATION>三原</STARTTATION><ENDTATION>西安</ENDTATION></TICKETINFO><ITEMKIND><KINDCODE>018</KINDCODE><KINDNAME>大地行乘客意外伤害保险</KINDNAME><ITEMCODE>0005</ITEMCODE><ITEMNAME>意外身故、残疾、烧伤保险责任</ITEMNAME><CURRENCY>CNY</CURRENCY><AMOUNT>30000</AMOUNT><RATE>0.03</RATE><PREMIUM>0.900000</PREMIUM></ITEMKIND><ITEMKIND><KINDCODE>018</KINDCODE><KINDNAME>大地行乘客意外伤害保险</KINDNAME><ITEMCODE>0006</ITEMCODE><ITEMNAME>意外伤害医疗责任</ITEMNAME><CURRENCY>CNY</CURRENCY><AMOUNT>1000</AMOUNT><RATE>0.1</RATE><PREMIUM>0.1</PREMIUM></ITEMKIND></TRANSDATA></ROOT>".getBytes());
		//  String by = DES.getEncrypt(key.getBytes(),"朱冬生".getBytes());
		//System.out.println("加密后的密文:"+by);

		//String mi = "2BC0A039329D8FF607D2CF93A14D44D4257EA0E84712CB327E9BD743552A5CFA9FC3E4EBEA09CCEB07B51B50777E1793821E6DBF2F6E8E60214E5EAD0BD7FBF6DE8876BC86C2F20C8E63CE1B2CA88ACF103797AB6CDD6D4278EC5794FD4A1FD29CA67F28CFE661AFEDA0892E0D957E6CCEEF2642ED9E5BF6968B0685E7D47A1DFEF7C953AA0217944B14F4EE19C8451C975259508A53334116210EC90D6F6EB15CB31F7EDA20ED8128E07C8ECCBF2907747999E4194E62B52BF5A347C5D112D85D28B70D67573DE1FE7BC748E0405AE532D465173D500B74E9B78EE36C873DF4A495F5B282A50E7B79A54D7143A49A9C378629C74B26BD3B536CDAA049D3841B44A7C6F07D847EDBC85832F511CE6754AE3DEEB99DBC8DDABCEE67D4A5252F3D7711A51C49B029732A21771A92635CAD9FFE021A2A408BC7084914F4B2329A6BB8A7F5BC8AD5A64CF58BC0D5C9ED56D189FCE26B64996E783BC015E2CEFC1D9B6B8BC79B85868C47586632DDEA08ED9E5CC1F3128CA37C88E1B9599BB5698816C64753A1DCE2F6BDF75786E62CD9099B1968B92758C5B5BC85562D1FE326D9698616CBE4F928E29DF1E413FD7AD394904066CCE2E4C01D51AC3AB402FDBC9723796013855290EDA09B73043494A7BC8F0BB33D14C75516EFAF95D3F8DC683D6CD7645B08BE6519FCC50522394D39556640D7FD63B8CEADCFB774580EAE912E24754994D219045E902DFB863CA768E648603BF2FB2E0AEC3542F12E5DAA8ECD64AF0AE99600BE02BB80906EDA0AE08C78ACAFE7C4D59C4C478761679A77F7C4A66CD888B6AAD1D432D7FD5A9A1758E6D159EC7F7764CE76DB152068E86955FF83ACFC005E4C36168F0EE4A166F046E6CC8AC0D2815D8D2038CBD07AD2064103B6DD9FB5958876714F7E42D349CA8D29AE74720B65CD052F9C23313393C53C431E2676835C65E725301651E07A075A7C2C1C15878B01F379200EC89216AA90EF5D242EBFD42D82DD598F25EB3BBB1D8CFBF92D5E09A5DB08DBD9B94F02D8F00B4AED356401FF6FFC1F801D9DCB1BB4DF765CEE972DD0F480837711A51C49B02973F1A5F689E806F0F900A09A8F4CDB64B5801D9DCB1BB4DF765CEE972DD0F480837711A51C49B02973BC42B7DF5A5CA18D327745D998799E0871B58C2C35DF97E0E368834EE99489679C23866B4196CCEDDE7AADAF2E004C4CE9823465757AA1BEDE7AADAF2E004C4CCAE93AB37524BADCCAF41A3DC7C430EF125CA8F8918826A48F960CEE66E01AB5DCD00B841A5EC223D90200EAA1A25139147A9FDFF1ECB529A39E45BE6260E469B616A095842CE76D8616CBE4F928E29D9AEB997EBBCCA5EE4A8C67917DDD6CDAB90BAFF5AF9238DD93A96865EB2B8FF014F3338AEA0AF72A6C0CE1ED11BF00F0DB2F069F3BC044ADD68EF78D62847259033EBCFDC0CC95F0C61771EA672C4BE4B4F9E4C2F90B5414A604EB2DB9E75AD580F69BABE5B34ED75B697F5761D86170242E3BE9C2361D70397B017334FE3FFA031BD6F67F219C2FCF095A065780FA54C1C0CBB94523835574FCB1E5B5E1782FE0B5DAF19BE030F63F6104C13698929D2FCE5B2220BF9DCD125CA8F8918826A48F960CEE66E01AB5DCD00B841A5EC223D90200EAA1A25139147A9FDFF1ECB529A39E45BE6260E469B616A095842CE76D8616CBE4F928E29D9AEB997EBBCCA5EE4A8C67917DDD6CDAB90BAFF5AF9238DD5876D996A53E4C8914F3338AEA0AF72A6C0CE1ED11BF00F044231EA7D93334C9B2661D686BB79B65ACEE8D5533A08771172324FEE046BB8A3679D3A843E498C6BCF7F86F57E9C0856740C4C08AE4783E8AD0219B8B9CC8F28FCF7E91B00DF1B10E9A76CCE37F6CC319F853AEE7D7765029C7116BB9113EEFFDDB753DC9C102224F78FF8473271D72650302AB0A44D4AD2C4EDF9FEE0A31A5B8DA1CE45D6B003D9F7079FE0C75BE70";
		//	   mi = "C21B97E0470444DCCEB42D062537B3F7624CF8FE504AF5213C5A75311EB23B6568F5049CE06E9CAFCE5866D1B3873924B292DD579C9B1EB840E19F1D4C40343B0FAEB566FBBE61372FE068FEE6A700FDD47CB36F8329B0745DCEA1D6A491C992EDE2508D7B64909E7D5A04F0F58F3DCFF669F8535C2EBD7540A57DF820109A13922C327326903BD48153F890B01BDC06A91BF3DBE0A6CCD9912EDD1CBD8DCCD468D51E422AD015C9EA534250D54C7C29CC78EC566C3BAF4A5CB31F7EDA20ED81110979877695CBD1ADAD89DD67C47AEEE0179FBCCCA401655D28B70D67573DE1F7E9E7BB7A55F741676E3336F8BBE1C81CB00EB99776005ECD80AA40E217088E88F07F48331AEA5A40E5E5293826CAA075291C1C1E1D24538FD647849970688CAA6725C5F3AD72F6710F5FFB737CA13196FC1ED5D44ACBDFF403FE38C4BD55666776D3169CA467F9DEC82F1F83DF2566C4444662AC649C996B8BC79B85868C47BF045B8681E7A162B8A7F5BC8AD5A64CA04F8A6B77D04F5F63A8086C49C0E0BA8A0A22EFE4565AA3468F96E62A28FEE0768EDF15437AE3392D9EC96559644A4E402FBD2D40DE04E4BBDBA71049E2652BC426B40B812C33783374271BB1BEA3485D984D39C120BC1C8D52D4EE50B962AE6534358644F7D36FB28915E6E368ABEC2487F87110E630AF2095DBF3C720F48195483597D363385B9DC0875D52531321D3B359E0F13CDC4505C270AD14086DB13DD19B91364A7FDD4D0FD3AF5B0DBC112D6A44412BF6479FA4C7D78116125D7159C4866D73CBD8882E69A29F225E739EA00A627AE5D335CFC693389446CC8BE0B1C1E045B66E20AE188832C508494A6273DBF2D73DA541E01ACCE82DF64518CA418DD23345555E2656E6B87BABCF1A5B01698D459FD01CFB2DCC7174BFDE170A3A28F9EDC87F4E96B4E03745F7370867AA3D4F311AA82FC565B5EA8021EEFF677DF5852F07A49CF9F0032EFB83E4456D3C6996E8F12C9826A47E600870735BDF3725F0B958C78D7557950A4FF9D2450C9CC11ADFADD1AE7690261C1D891C763B1BFDA5EE993E63F50B990DB34B3FBDA1E7329D60BE0F6268A684D8A7434C013E9C23866B4196CCED23A87EED607C9F346AE3CA06F7CE282523A87EED607C9F3456E6B87BABCF1A5BCA0CDEE1B99B266C67219683C9348FBBD90200EAA1A2513956B607F93A99EE23B68DB0AEF3DEEDBEDCCDC31093331DAE2868794B1EB0EA5CF172B84888C59EB4C5DA4A48B0BF6D2BB2998E4DF2E6A7A1353EAD9D97F233209C17B5355FCC8B4CD58B86A8C33C099A56DAE8F79C41701B62E735D3E7EF2AD75923179F7CF7C18BBD5078ECE7F07C3E837301CD1F66DA148419D382DE69CF9F47049FDCEF67F130CB45116850AF3A7A8BC15677B9006B068B48F6EF34497119B3697311C6CBEC94A9CD32706744FE19D0AA6053382122863C0469C6B9EEB61533895B18BA3195E69F8C428770420D6BF5966CC7DED194014F78FF8473271D72650302AB0A44D4AD74B1743399A9649DFE1A0684174201F3901318308232198D06D4E002E717B1958F7A08BA5B6138E842997E41F2A5516DA84002067BE8E4A609BA4476A05A25D3DDB630875738574A0A03C9D0A27641DC0AEAAAB45A533E894C24DA1250F96EFBAD9D4CB852132B4EEABEFA6C83C28BC2F753D47152572A3A99A407016001D5198419D382DE69CF9F47049FDCEF67F130CB45116850AF3A7A8BC15677B9006B068B48F6EF34497119E0C4775A7C9E1C72FA0034C192D5B089A92083F93C5E8A8E29F69A0CE8C987C596488FCDC62AA8D374EC03E15CDD52DDFCA372933D58DC1CE2C9AA981CBAE16DC1C037C8BD2C1C1CB1FA905FF379FF46D7427FF6731573C4";
		//      String   mi = "C21B97E0470444DCDEE938E515526843C282956247A33E56E6C8AB70DF6D2F889FC3E4EBEA09CCEBA4D618E30C0A1A9046FF3301A368AD36A7ADC78761E6C4C758D2611F3F3E3C448E63CE1B2CA88ACFC88CF917E3C4B155B6C06AD2ED9D6371C8BC82B17390C695175914DFEFD01D8C720449F6082815D1010024C431B51AB90FC496308F3A0B690F4642CB458A5F31554CE88E4C08BD689D67F00BA8D2A55AA61D988EC183213615F20C24F11594D3968B0685E7D47A1D10DB1A125D69C32C957E8C4D68A6F6CB47575110AAF0224F4C18984CAA35102BC37279508D1C157543A5C57872610CB3CDDF730DB7F76A7A2E21226C7CDEA83505FE51758A58FDC16A2C7B99D9ABCE42DC834E7FC7D479DDAE939C85E2CC3F08A300BF905F41F2CF98C90725D516DDCE739680AEE9F32D1A534206C272BDF9FA800DFC6BBB1F4704";
//		String mi = "913E446E96795040AD92B15F4FA3920F6B39C6DCEDC7669C5C587258AFDBD6A460BD62F7AC3C1DF109D16C9F8EE056E0A5624C7FA7E200286E4075BFD5B8D5BEE507FA6DD30DC13BB9D49C3ECB2A5D3926DD4EC40AC9D89B7E9568E93717F39620FBA642983893C91BF3AAFB73E3F8F2910555C14FE4B2EDE50B0714077D8D2192044133E1836AABFA8AF32B2C0E9C794006641E270A21A8924FBD71A36DD8972899C84AE897AD0673FD4D5ED70A1473EE204BFF0D1977E01DFE689DF8BD83D89594D934BEF375BF8D8DE6E752D4E197195B50D31799E8A2EEE786BC8078365304AFD6176CD311CD03C0FBEB3C8C91B7AB979EA799C8734DBD04C89F8A60E6038274168E53A560AE";
//		System.out.println(mi.length());
//		String mm = DES.getUncoil(mi, key.getBytes());
//		System.out.println("解密后的明文：" + mm);
		String mi = DES.getEncrypt(key.getBytes(), "你好，world!".getBytes());
		mi = DES.getEncrypt(key2.getBytes(), mi.getBytes());
		System.out.println(mi);
		String mm = DES.getUncoil(mi, key2.getBytes());
		mm = DES.getUncoil(mm, key.getBytes());
		System.out.println(mm);
		
	}

}
