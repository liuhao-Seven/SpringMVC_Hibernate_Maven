package com.lh.util.common;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import com.lh.util.log.LHLog;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * 工具类
 *
 * @date 2014-4-19
 * @author 刘浩
 */
public class FunctionUtils{
	
	private static long pkId; // 唯一Long型主码

	/**
	 * 得到字符串的字节长度
	 * @return int型
	 */
	public static int strLength(final String str){
		return str.trim().getBytes().length;
	}   
	
	/**     
	 *得到Exception所在代码的行数     
	 *如果没有行信息,返回-1     
	 */       
	public static int  getLineNumber(Exception e){       
	    StackTraceElement[] trace =e.getStackTrace();       
	    if (trace== null ||trace.length== 0 ){  
	    	return  - 1 ;    
	    }
	    return trace[0].getLineNumber();       
	} 
	
	/**
	 * 打印类的路径,打印测试用的代码所在行号,要显示的测试内容
	 * @param e
	 * @param clazz
	 * @param name
	 * @param str
	 */
	public static void printCLAndStr(Exception e,Class<?> clazz,String str){
		if ("YES".equals(Constants.PRINT_FLAG)) {
			System.out.println("测试1:"+clazz.getName()+"_"+getLineNumber(e)+":"+str);
		}
	}
	
	/**
	 * 打印类的路径,打印测试用的代码所在行号,测试内容名称，要显示的测试内容
	 * @param e
	 * @param clazz
	 * @param name
	 * @param str
	 */
	public static void printCLAndStr(Exception e,Class<?> clazz,String name,String str){
		if ("YES".equals(Constants.PRINT_FLAG)) {
			System.out.println("测试1:"+clazz.getName()+"_"+getLineNumber(e)+"_"+name+":"+str);
		}
	}
	
	/**
	 * 打印
	 * @param str
	 * @date 2014-4-18
	 * @author lh
	 */
	public static void syso(String str){
		if ("YES".equals(Constants.PRINT_FLAG)) {
			System.out.println(str);
		}
	}
	
	/**
	 * 打印类的路径,打印测试用的代码所在行号,测试内容名称，要显示的测试内容
	 * @param e
	 * @param clazz
	 * @param names
	 * @param strs
	 */
	public static void printCLAndStrs(Exception e,Class<?> clazz,String[] names,String[] strs){
		if ("YES".equals(Constants.PRINT_FLAG)) {
			StringBuffer sb = new StringBuffer();
			if(names.length == strs.length){
				for(int i = 0; i < names.length;i++ ){
					sb.append(names[i] + ":" + strs[i] + ";");
				}
			}else{
				sb.append("俩数组数量不等");
			}
			System.out.println("测试2:"+clazz.getName()+"_"+getLineNumber(e)+"_"+sb.toString());
		}
	}
	
	/**
	 * 打印类的路径,打印测试用的代码所在行号,要显示的测试内容集合
	 * @param e
	 * @param clazz
	 * @param strs
	 */
	public static void printCLAndStrs(Exception e,Class<?> clazz,String[] strs){
		if ("YES".equals(Constants.PRINT_FLAG)) {
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < strs.length;i++ ){
				sb.append(strs[i]);
				if(i%2==0 && i < strs.length - 1){
					sb.append(":");
				}else{
					sb.append(";");
				}
			}
			System.out.println("测试2:"+clazz.getName()+"_"+getLineNumber(e)+"_"+sb.toString());
		}
	}
	
	/**
	 * 去掉字符串首尾空格
	 * @param str
	 * @return
	 */
	public static String cutSpace(String str) {
		if (str == null || str.equals("null") || str.equals("")
				|| str.length() <= 0) {
			return "";
		}
		return str.trim();
	}
	
	/**
	 * 去掉为空的double数字
	 * @param str
	 * @return
	 */
	public static Double cutSpace(Double str) {
		if (str == null || str.equals(null)) {
			return new Double(0.0);
		}
		return str;
	}
	
	/**
	 * 将Double型数据的null值判掉，并转换为String类型
	 * @param obj
	 * @return
	 */
	public static String cutNull(Double obj){
		if(obj==null || obj.equals(null))
			return "";
		return ""+obj;
	}
	
	/**
	 * 进行gbk到iso-8850-1格式的转化
	 * @param str
	 * @return
	 */
	public static String GBKToISO(String str) {
		if (str == null || str.equals("")) {
			return "";
		}
		String s = "";
		try {
			String tempStr = str;
			byte[] tempByte = tempStr.getBytes("GBK");
			String temp = new String(tempByte, "ISO8859-1");
			s = temp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * 将字符串转码为ios-8859-1
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String convertStringToISO(String str) throws Exception{
		return new String(str.getBytes("ISO-8859-1"));
	}
	
	/**
	 * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名.
	 * @param s 原文件名
	 * @return 重新编码后的文件名
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = String.valueOf(c).getBytes("utf-8");
				} catch (Exception ex) {
					LHLog.error(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
	
	/**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isBlank(final String str) {
		return (str == null) || (str.trim().length() <= 0);
	}

    /**
     * 判断数组是否为空
     * @param objs
     * @return
     */
	public static boolean isBlank(final Object[] objs) {
		return (objs == null) || (objs.length <= 0);
	}
	
	/**
	 * 判断Collection集合是否为空
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isBlank(final Collection obj) {
		return (obj == null) || (obj.size() <= 0);
	}
	
	/**
	 * 判断Set集合时候为空
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isBlank(final Set obj) {
		return (obj == null) || (obj.size() <= 0);
	}
	
	/**
	 * 判断Serializable对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isBlank(final Serializable obj) {
		return obj == null;
	}
   
	/**
	 * 判断Map集合是否为空
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isBlank(final Map obj) {
		return (obj == null) || (obj.size() <= 0);
	}

	/**
	 * 判断是不是合法字符
	 */
	public static boolean isLetter(String str) {
		if (str == null || str.length() < 0) {
			return false;
		}
		Pattern pattern = Pattern.compile("[\\w\\.-_]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断输入的字符串是否为纯汉字
	 * 
	 * @param str 传入的字符串
	 * @return 如果是纯汉字返回true,否则返回false
	 */
	public static boolean isChinese(String str) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(str).matches();
	}
	
	/**
	 * 手机号验证
	 * 
	 * @param  str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) { 
		Pattern p = null;
		Matcher m = null;
		boolean b = false; 
		p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches(); 
		return b;
	}
	
	/**
	 * 电话号码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean b = false;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
		if (str.length() > 9) {
			m = p1.matcher(str);
			b = m.matches();
		} else {
			m = p2.matcher(str);
			b = m.matches();
		}
		return b;
	}

	/**
	 * 功 能：判断中文个数 输入参数：str 输出参数：count
	 * @param str
	 * @return
	 */
	public static int checkByteLen(String str) {
		int count = 0;
		byte[] bstr = new byte[8];
		String checkStr = str;
		String subStr;
		for (int i = 0; i < str.length(); i++) {
			subStr = checkStr.substring(i, i + 1);
			bstr = subStr.getBytes();
			count = count + (bstr.length - 1);
		}
		return count;
	}
	
	/**
	 * Long型数值单位转换
	 * 如果数值大于一万，则以万为单位
	 * 如果数值大于一亿，则以亿为单位
	 * @param str
	 * @return
	 * @throws Exception
	 * @date 2014-3-31
	 */
	public static String changeUnLong(Long d) throws Exception {
		try {
			/*如果数目大于一亿，则以亿为单位*/
			if (d/100000000 >= 1) {
				DecimalFormat df = new DecimalFormat("0.0000000000");
				return df.format(divide(d,100000000)) + "亿";
			}
			/*如果数目大于一万，则以万为单位*/
			if (d/10000 >= 1) {
				DecimalFormat df = new DecimalFormat("0.000000");
				return df.format(divide(d,10000)) + "万";
			} 
			DecimalFormat df = new DecimalFormat("0.00");
			return df.format(d);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * double型数值单位转换
	 * 如果数值大于一万，则以万为单位
	 * 如果数值大于一亿，则以亿为单位
	 * @param str
	 * @return
	 * @throws Exception
	 * @date 2014-3-31
	 */
	public static String changeUnDou(Double d) throws Exception {
		try {
			/*如果数目大于一亿，则以亿为单位*/
			if (d/100000000 >= 1) {
				DecimalFormat df = new DecimalFormat("0.0000000000");
				return df.format(divide(d,100000000)) + "亿";
			}
			/*如果数目大于一万，则以万为单位*/
			if (d/10000 >= 1) {
				DecimalFormat df = new DecimalFormat("0.000000");
				return df.format(divide(d,10000)) + "万";
			} 
			DecimalFormat df = new DecimalFormat("0.00");
			return df.format(d);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * Int型数值单位转换
	 * 如果数值大于一万，则以万为单位
	 * 如果数值大于一亿，则以亿为单位
	 * @param str
	 * @return
	 * @throws Exception
	 * @date 2014-3-31
	 */
	public static String changeUnInt(Integer d) throws Exception {
		try {
			/*如果数目大于一亿，则以亿为单位*/
			if (d/100000000 >= 1) {
				DecimalFormat df = new DecimalFormat("0.0000000000");
				return df.format(divide(d, 100000000)) + "亿";
			}
			/*如果数目大于一万，则以万为单位*/
			if (d/10000 >= 1) {
				DecimalFormat df = new DecimalFormat("0.000000");
				return df.format(divide(d,10000)) + "万";
			} 
			DecimalFormat df = new DecimalFormat("0");
			return df.format(d);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * 数值单位转换使用
	 * 除法
	 * @param o1
	 * @param o2
	 * @return
	 * @date 2014-3-31
	 * @author 刘浩
	 */
	private static Number divide(Number o1,Number o2){
		try {
			BigDecimal a = new BigDecimal(o1.toString());
			BigDecimal b = new BigDecimal(o2.toString());
			return a.divide(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	  * 睡眠
	  * @author 刘浩
	  * @date 2014-6-25
	  * @param str 打印日志内容
	  * @param second 睡眠时间（单位/S）
	  */
	 @SuppressWarnings("static-access")
	public static void sleep(String str, int second) {
		LHLog.info("测试：" + str + "进入睡眠状态,共睡眠" + second + "秒");
		Thread thread = new Thread();
		for (int i = 1; i <= second; i++) {
			try {
				thread.sleep(1000);
				if (i % 10 == 0) {
					LHLog.info(str + "睡眠了" + i + "s");
				}
			} catch (Exception e) {
			}
		}
		LHLog.info("测试：" + str + "结束睡眠状态");
	}

	/**
	 * 描述：把集合转换成字符串，使用指定符号分隔
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param src：要转换的数组
	 * @param arg：拼接数组元素的分隔符
	 * @return
	 */
	public static String arrayToString(List<String> src,String arg){
		if(src==null || src.size()<=0)
			return null;
		StringBuilder builder = new StringBuilder();
		for(String str : src){
			if(isBlank(str))
				continue;
			builder.append("'"+str+"'").append(arg);
		}
		if(builder!=null && builder.length()>0)
			builder = builder.deleteCharAt(builder.length()-1);
		return builder.toString();
	}
	
	/**
	 * 拆分以给定分隔符分隔的字符串,并存入字符串数组中
	 */
	public static String[] strToArray(String sSource, String sChar) {
		String aReturn[] = null;
		StringTokenizer st = null;
		st = new StringTokenizer(sSource, sChar);
		int i = 0;
		aReturn = new String[st.countTokens()];
		while (st.hasMoreTokens()) {
			aReturn[i] = st.nextToken();
			i++;
		}
		return aReturn;
	}
	
	/**
	 * 替换字符串
	 * @param from 原始字符串
	 * @param to 目标字符串
	 * @param source 母字符串
	 * @return String 替换后的字符串
	 */
	public static String replace(String from, String to, String source) {
		if (source == null || from == null || to == null)
			return null;
		StringBuffer str = new StringBuffer("");
		int index = -1;
		while ((index = source.indexOf(from)) != -1) {
			str.append(source.substring(0, index) + to);
			source = source.substring(index + from.length());
			index = source.indexOf(from);
		}
		str.append(source);
		return str.toString();
	}
	
	/**
	 * 返回指定字节长度的字符串
	 * 
	 * @param str 字符串
	 * @param length int 指定长度
	 * @return String 返回的字符串
	 */
	public static String toLength(String str, int length) {
		if (str == null) {
			return null;
		}
		if (length <= 0) {
			return "";
		}
		try {
			if (str.getBytes("GBK").length <= length) {
				return str;
			}
		} catch (Exception e) {
		}
		StringBuffer buff = new StringBuffer();

		int index = 0;
		char c;
		length -= 3;
		while (length > 0) {
			c = str.charAt(index);
			if (c < 128) {
				length--;
			} else {
				length--;
				length--;
			}
			buff.append(c);
			index++;
		}
		buff.append("...");
		return buff.toString();
	}

	/**
	 * 去掉字符串中重复的子字符串
	 * 
	 * @param str 原字符串，如果有子字符串则用空格隔开以表示子字符串
	 * @return String 返回去掉重复子字符串后的字符串
	 */
	@SuppressWarnings("unused")
	private static String removeSameString(String str) {
		Set<String> mLinkedSet = new LinkedHashSet<String>();
		String[] strArray = str.split(" ");// 根据空格(正则表达式)分割字符串
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < strArray.length; i++) {
			if (!mLinkedSet.contains(strArray[i])) {
				mLinkedSet.add(strArray[i]);
				sb.append(strArray[i] + " ");
			}
		}
		return sb.toString();
	}

	/**
	 * 过滤特殊字节符和数字
	 * @author 刘浩
	 * @date 2014-8-20
	 * @param strss
	 * @return
	 */
	public String regexReplace(String strss) {
		try {
			// 清除掉所有特殊字符
			String regEx = "[1234567890`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(strss);
			return m.replaceAll("").trim();
		} catch (Exception ex) {
			LHLog.error("过滤特殊字符和数字失败", ex);
			// 修正防止返回值不进行字符串判断只进行非空判断 刘浩 2014-4-3
			return null;
		}
	}
	
	/**
	 * 过滤特殊字节符
	 * @author 刘浩
	 * @date 2014-8-20
	 * @param strss
	 * @return
	 */
	public String regexReplace2(String strss) {
		try {
			// 清除掉所有特殊字符
			String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(strss);
			return m.replaceAll("").trim();
		} catch (Exception ex) {
			LHLog.error("过滤特殊字符失败", ex);
			// 修正防止返回值不进行字符串判断只进行非空判断 刘浩 2014-4-3
			return null;
		}
	}
	
	/**
	 * 解析对象的所有属性值及get方法
	 * @author 刘浩
	 * @date 2014-8-21
	 * @param obj
	 * @return
	 */
	public static void toString(Object obj){
		try {
			Class<?> clazz = (Class<?>) obj.getClass();
			LHLog.info("【类"+clazz+"】toString 开始======================");
			// 得到类中的所有属性集合
			Field[] fs = clazz.getDeclaredFields ();
			for ( int i = 0 ; i < fs. length ; i++){
				Field f = fs[i];
				f.setAccessible( true ); // 设置些属性是可以访问的
				Object val = f.get(obj); // 得到此属性的值
				String type = f.getType().toString(); // 得到此属性的类型
				LHLog.info("\tname:"+f.getName()+
						"\t value= " +val+
						"\t type:" + type);
			}
			LHLog.info("");
			//得到类中的方法
		    Method[] methods = clazz.getMethods();
		    for(int i = 0;i < methods.length;i++){
		    	Method method = methods[i];
		    	if (method.getName().startsWith("get")){
		    		LHLog.info("\tmethodName:" +method.getName()+ 
		    				"\t value:"+method.invoke(obj));// 得到 get 方法的值
		    	}
		    }
		    LHLog.info("【类"+clazz+"】toString 结束======================");
		} catch (Exception e) {
			e.printStackTrace();
			LHLog.error("toString出错：",e);
		}
	}
	
	/*********************************** 身份证验证开始 ****************************************/
    /**
     * 身份证号码验证 1、号码的结构 公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成。排列顺序从左至右依次为：六位数字地址码，
     * 八位数字出生日期码，三位数字顺序码和一位数字校验码。 2、地址码(前六位数）
     * 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。 3、出生日期码（第七位至十四位）
     * 表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。 4、顺序码（第十五位至十七位）
     * 表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号， 顺序码的奇数分配给男性，偶数分配给女性。 5、校验码（第十八位数）
     * （1）十七位数字本体码加权求和公式 S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前17位数字的权求和
     * Ai:表示第i位置上的身份证号码数字值 Wi:表示第i位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 
     * （2）计算模 Y = mod(S, 11) （3）通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6 5 4 3 2
     */

    /**
     * 功能：身份证的有效验证
     * 
     * @param IDStr
     *            身份证号
     * @return 有效：返回"" 无效：返回String信息
     * @throws ParseException
     */
    @SuppressWarnings("rawtypes")
    public static String IDCardValidate(String IDStr) throws ParseException {
        String errorInfo = "";// 记录错误信息
        String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2" };
        String Ai = "";
        // ================ 号码的长度 15位或18位 ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            errorInfo = "身份证号码长度应该为15位或18位。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 数字 除最后以为都为数字 ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 出生年月是否有效 ================
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 月份
        if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
            errorInfo = "身份证生日无效。";
            return errorInfo;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(
                            strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                errorInfo = "身份证生日不在有效范围。";
                return errorInfo;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            errorInfo = "身份证月份无效";
            return errorInfo;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            errorInfo = "身份证日期无效";
            return errorInfo;
        }
        // =====================(end)=====================

        // ================ 地区码时候有效 ================
        Hashtable h = GetAreaCode();
        if (h.get(Ai.substring(0, 2)) == null) {
            errorInfo = "身份证地区编码错误。";
            return errorInfo;
        }
        // ==============================================

        // ================ 判断最后一位的值 ================
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;

        if (IDStr.length() == 18) {
            if (Ai.equals(IDStr) == false) {
                errorInfo = "身份证无效，不是合法的身份证号码";
                return errorInfo;
            }
        } else {
            return "";
        }
        // =====================(end)=====================
        return "";
    }

    /**
     * 身份证验证
     * 功能：设置地区编码
     * 
     * @return Hashtable 对象
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static Hashtable GetAreaCode() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    /**
     * 身份证验证
     * 功能：判断字符串是否为日期格式
     * 
     * @param str
     * @return
     */
    private static boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 身份证验证
     * 功能：判断字符串是否为数字
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }
//    /**
//     * @param args
//     * @throws ParseException
//     */
//    public static void main(String[] args) throws ParseException {
//        // String IDCardNum="210102820826411";
//        // String IDCardNum="210102198208264114";
//    	// String IDCardNum = "210181198807193116";
//    	String IDCardNum = "320621199205188319";
//        System.out.println(FunctionUtils.IDCardValidate(IDCardNum));
//        // System.out.println(cc.isDate("1996-02-29"));
//    }
    /*********************************** 身份证验证结束 ****************************************/
    
	/**
	 * 获取唯一long型主码
	 * @return
	 * @date 2014-11-7
	 * @author 刘浩
	 */
	public static synchronized long getPkId() {
		long lTmp = System.currentTimeMillis();
		if (pkId < lTmp) {
			pkId = lTmp;
		} else {
			pkId++;
		}
		return pkId;
	}
	
	/**
	 * 设置http代理 
	 * @date 2014-12-2
	 * @author 刘浩
	 */
	public static void setHttpProxy(){
		if ("YES".equals(Constants.PROXY_FLAG)) {
			//设置代理
			//大地保险使用
			System.setProperty("http.proxySet", "true");
			System.setProperty("http.proxyHost", "10.1.27.102");
			System.setProperty("http.proxyPort", "8080");
		}
	}

	/**
	 * String数组转换为list
	 * @param arr
	 * @return
	 * @date 2014-12-23
	 * @author 刘浩
	 */
	public static List<String> arrayToList(String[] arr){
		return Arrays.asList(arr);
	}
	
	/**
	 * list集合转换为String数组
	 * @param list
	 * @return
	 * @date 2014-12-23
	 * @author 刘浩
	 */
	public static String[] listToArray(List<String> list){
		return (String[])list.toArray(new String[list.size()]);
	}
	
	/**
	 * 文件下载设置文件名和编码类型
	 * @param response 
	 * @param filename 下载文件默认名+文件格式
	 * @param charset 下载文件编码（默认值：gbk）
	 * @return 1:设置成功，0：设置失败
	 * @date 2014-12-23
	 * @author 刘浩
	 */
	public static int downloadSet(HttpServletResponse response,String filename,String charset){
		if (response != null && !isBlank(filename)) {
			response.setHeader("Content-Disposition", "attachment; filename="+toUtf8String(filename));
			if (!isBlank(charset)) {
				response.setContentType("text/plain;charset="+charset);
			}else{
				response.setContentType("text/plain;charset=gbk");
			}
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		sleep("ni", 100);
	}
}