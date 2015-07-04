package com.lh.util.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.lh.util.common.Constants;

/**
 * 关于时间的工具类
 * @author 刘浩
 * @date 2014-7-4
 *
 */
public class DateUtils {
	
	public static final int FIRST_DAY_OF_WEEK = Calendar.MONDAY; // 中国周一是一周的第一天
	
	/**
	 * format date
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		String strDate = null;
		try {
			if (date == null) {
				return null;
			}
			if (pattern == null) {
				pattern = "YYYYMMDD";
			}
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			strDate = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return strDate;
	}
	
	/**
	 * 获取下一年的同一时间
	 * @return
	 */
	public static String getNextCurrentTime() {
		Calendar calendar = Calendar.getInstance();
	    int year =calendar.get(Calendar.YEAR);
	    calendar.set(Calendar.YEAR, year+1);
        return getDateFormat(calendar.getTime(),Constants.DATE_PATTERN);
	}
	
	/**
	 * 根据指定格式获取下一年的同一时间
	 * @param type
	 * @return
	 */
	public static String getNextCurrentTime(String type) {
		Calendar calendar = Calendar.getInstance();
	    int year =calendar.get(Calendar.YEAR);
	    calendar.set(Calendar.YEAR, year+1);
        return getDateFormat(calendar.getTime(),type);
	}

	/**
	 * 比较两个给定日期的先后
	 * 返回结果 0:日期相同;大于0:dts在tde之后;小于0:dts在tde之前
	 */
	public static int dateCompareTo(Date dts, Date dte) {
		return dts.compareTo(dte);
	}
	
	/**
	 * 根据传入的字符串日期进行格式转换再进行日期的比较
	 * 返回结果 0:日期相同;大于0:dts在tde之后;小于0:dts在tde之前
	 */
	public static int compareDate(String date1, String date2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(date1);
			Date dt2 = df.parse(date2);
			// dt1 在dt2前
			if (dt1.getTime() > dt2.getTime())
				return 1;
			// dt1在dt2后
			else if (dt1.getTime() < dt2.getTime())
				return -1;
			// dt1=dt2
			else
				return 0;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 将日期对象dt生成制定格式style的字符串
	 * @param dt
	 * @param pattern
	 * @return
	 */
	public static String getDateFormat(Date dt, String pattern) {
		SimpleDateFormat formater = new SimpleDateFormat(pattern, Locale.getDefault());
		return formater.format(dt);
	}
	
	/**
	 * 将指定的日期字符串转化为日期对象
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @return java.util.Date
	 */
	public static Date getDate(String dateStr, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			Date date = df.parse(dateStr);
			return date;
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * 将当前时间生成制定相应格式的日期
	 * @param pattern 当前日期格式字符串
	 * @return
	 */
	public static Date getDate(String pattern) {
		return getDate(getCurrentDate(pattern), pattern);
	}
	
	/**
	 * 将当前时间生成制定格式style的字符串
	 * @param pattern 当前日期格式字符串
	 * @return
	 */
	public static String getCurrentDate(String pattern) {
		return getDateFormat(new Date(), pattern);
	}
	
	/**
	 * 得到当前日期yyyy-MM-dd格式字符串，根据constants中指定好的格式进行转换
	 * @return
	 */
	public static String getCurrentDate() {
		return getDateFormat(new Date(), Constants.DATE_PATTERN);
	}
	
	/**
	 * 得到当前日期yyyy/MM/dd格式字符串，根据constants中指定好的格式进行转换
	 * @return
	 */
	public static String getCurrentFDate(){
		return getDateFormat(new Date(),Constants.DATE_Format);
	}
	/**
	 * 得到当前日期yyyy-MM-dd格式字符串，根据constants中指定好的格式进行转换
	 * @return
	 */
	public static String getCurrentTime() {
		return getDateFormat(new Date(), Constants.TIME_PATTERN);
	}
	
	/**
	 * 得到当前日期yyyy-MM-dd HH:mm格式字符串，根据constants中指定好的格式进行转换
	 * @return
	 */
	public static String getCurrentDateTime() {
		return getDateFormat(new Date(), Constants.DATE_TIME_HHMM);
	}
	
	/**
	 * 得到当前日期yyyy-MM-dd HH:mm:ss格式字符串，根据constants中指定好的格式进行转换
	 * @return
	 */
	public static String getCurrentDateSTime() {
		return getDateFormat(new Date(), Constants.DATE_TIME_PATTERN);
	}
	
	/**
	 * 得到当前日期yyyy/MM/dd HH:mm:ss格式字符串，根据constants中指定好的格式进行转换
	 * @return
	 */
	public static String getCurrentDateFTime() {
		return getDateFormat(new Date(), Constants.DATE_TIME_Format);
	}
	
	/**
	 * 得到当前时间小时
	 * @return
	 */
	public static String getCurrentDateHour() {
		return getDateFormat(new Date(), Constants.TIME_PATTERN_HOUR);
	}
	
	/**
	 * 得到年
	 * @param 
	 * @return
	 */
	public static int getYear(Calendar c){
		if(c != null){
			return c.get(Calendar.YEAR);
		}else{
			return Calendar.getInstance().get(Calendar.YEAR);
		}
	}
	
	/**
	 * 得到月份
	 * 注意，月份是从0开始的
	 * @param 
	 * @return
	 */
	public static int getMonth(Calendar c){
		if(c != null){
			return c.get(Calendar.MONTH);
		}else{
			return Calendar.getInstance().get(Calendar.MONTH);
		}
	}
	
	/**
	 * 得到星期
	 * @param 
	 * @return
	 */
	public static int getDay(Calendar c){
		if(c != null){
			return c.get(Calendar.DAY_OF_WEEK);
		}else{
			return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		}
	}
	
	/**
	 * 得到小时
	 * @param 
	 * @return
	 */
	public static int getHour(Calendar c){
		if(c != null){
			return c.get(Calendar.HOUR);
		}else{
			return Calendar.getInstance().get(Calendar.HOUR);
		}
	}
	
	/**
	 * 得到分钟
	 * @param 
	 * @return
	 */
	public static int getMinute(Calendar c){
		if(c != null){
			return c.get(Calendar.MINUTE);
		}else{
			return Calendar.getInstance().get(Calendar.MINUTE);
		}
	}
	
	/**
	 * 得到秒
	 * @param 
	 * @return
	 */
	public static int getSecond(Calendar c){
		if(c != null){
			return c.get(Calendar.SECOND);
		}else{
			return Calendar.getInstance().get(Calendar.SECOND);
		}
	}
	
	/**
	 * 根据指定日期得到addDay的日期
	 */
	public static String addDay(String date,int addday){
		 int year = Integer.parseInt(date.substring(0,4));
		 int month = Integer.parseInt(date.substring(5,7))-1;
		 int day = Integer.parseInt(date.substring(8));
		 Calendar cal = Calendar.getInstance(); 
		 cal.set(Calendar.YEAR, year);
		 cal.set(Calendar.MONDAY, month);
		 cal.set(Calendar.DAY_OF_MONTH, day);
		 cal.add(Calendar.DATE, addday);
		 return  new  SimpleDateFormat(Constants.DATE_PATTERN).format(cal.getTime());
	}
	
	/**
	 * 将yyyy-MM-dd格式的日期转换为Date格式
	 * @param strDate
	 * @return
	 * @throws Exception
	 */
	public static Date convertStringToDate(String strDate) throws Exception{
		DateFormat f = new SimpleDateFormat(Constants.DATE_PATTERN);
		return f.parse(strDate);
	}
	
	/**
	 * 将yyyy/MM/dd格式的日期转换为Date格式
	 * @param strDate
	 * @return
	 * @throws Exception
	 */
	public static Date convertFStringToDate(String strDate) throws Exception{
		DateFormat f = new SimpleDateFormat(Constants.DATE_Format);
		return f.parse(strDate);
	}
	
	/**
	 * 将yyyy-MM-dd HH:mm:ss格式的日期转换为Date格式
	 * @param strDate
	 * @return
	 * @throws Exception
	 */
	public static Date convertStringToDateTime(String strDate) throws Exception{
		DateFormat f = new SimpleDateFormat(Constants.DATE_TIME_PATTERN);
		return f.parse(strDate);
	}
	
	/**
	 * 将Date转换为yyyy-MM-dd HH:mm:ss格式的String
	 * @param strDate
	 * @return
	 * @throws Exception
	 */
	public static String convertDateToString(Date strDate) throws Exception{
		return getDateFormat(strDate, Constants.DATE_PATTERN);
	}

	/**
	 * Date类型转换到Calendar类型
	 * @param 
	 * @return
	 */
	public static Calendar Date2Calendar(Date d){
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}
	
	/**
	 * Calendar类型转换到Date类型
	 * @param c
	 * @return
	 */
	public static Date Calendar2Date(Calendar c){
		return c.getTime();
	}
	
	/**
	 * Date类型转换到Timestamp类型
	 * @param d
	 * @return
	 */
	public static Timestamp Date2Timestamp(Date d){
		return new Timestamp(d.getTime());
	}
	
	/**
	 * Calendar类型转换到Timestamp类型
	 * @param 
	 * @return
	 */
	public static Timestamp Calendar2Timestamp(Calendar c){
		return new Timestamp(c.getTimeInMillis());
	}
	
	/**
	 * Timestamp类型转换到Calendar类型
	 * @param 
	 * @return
	 */
	public static Calendar Timestamp2Calendar(Timestamp ts){
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		return c;
	}
	
	/**
     * 计算输入时间(String)与当前系统时间的时间差(单位：天)过去时间为负
     * @param date
     * @return
     * @throws Exception
     */
	public static long diffDay(String date) throws Exception{
		String current = getCurrentDate(); 
		long time = convertStringToDate(current).getTime() - convertStringToDate(date).getTime(); 
 		long intrval = (time/60/60/1000/24); 
 		return intrval;
	}
	
	/**
	 * 两个日期之间间隔天数
	 * @param begDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public static int getBetweenDays(String begDate, String endDate)
			throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return new Long((format.parse(endDate).getTime() - format
				.parse(begDate).getTime())
				/ (1000 * 60 * 60 * 24)).intValue();
	}
	
	/**
	 * 得到指定或者当前时间前n天的Calendar
	 * @param c
	 * @param n
	 * @return
	 */
	public static Calendar beforeNDays(Calendar c, int n){
		//偏移量，给定n天的毫秒数
		long offset = n*24*60*60*1000;
		Calendar calendar = null;
		if(c != null){
			calendar = c;
		}else{
			calendar = Calendar.getInstance();
		}
		
		calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
		return calendar;
	}
	
	/**
	 * 得到指定或者当前时间后n天的Calendar
	 * @param 
	 * @param 
	 * @return
	 */
	public static Calendar afterNDays(Calendar c, int n){
		//偏移量，给定n天的毫秒数
		long offset = n*24*60*60*1000;
		Calendar calendar = null;
		if(c != null){
			calendar = c;
		}else{
			calendar = Calendar.getInstance();
		}
		
		calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
		return calendar;
	}
	
	/**
	 * 验证月份，天数，时，分，秒是否合法
	 * @author 刘浩
	 * @date 2014-8-20
	 * @param k
	 * 		0：yyyy-MM-dd HH:mm:ss
	 * 		1：yyyy-MM-ddHH:mm:ss
	 * 		2：yyyy-MM-dd
	 * @param str
	 * @return
	 * 		 0：验证通过
	 * 		-1：月份不能超过12月份
	 * 		-2：天数不能超过31天
	 * 		-3：时间（时，分，秒）出错
	 * 		-4：日期验证出错
	 * 		-5：日期格式不正确
	 * 		-6：无格式验证
	 * @throws Exception
	 */
	public static int checkDate(int k, String str) throws Exception{
		try {
			String strtime = "";
			if (k == 0) {
				if (checkDateFormate0(str).equals("日期格式不正确")) {
					return -5;
				}
				strtime = checkDateFormate0(str);
				int mon = Integer.parseInt(strtime.substring(5, 7));
				int day = Integer.parseInt(strtime.substring(8, 10));
				int hour = Integer.parseInt(strtime.substring(11, 13));
				int min = Integer.parseInt(strtime.substring(14, 16));
				int sec = Integer.parseInt(strtime.substring(17, 19));
				if (mon > 12) {
					return -1;
				}
				if (day > 31) {
					return -2;
				}
				if (hour > 24 || min > 60 || sec > 60) {
					return -3;
				}
			}else if (k == 1) {
				if (checkDateFormate1(str).equals("日期格式不正确")) {
					return -5;
				}
				strtime = checkDateFormate1(str);
				int mon = Integer.parseInt(strtime.substring(5, 7));
				int day = Integer.parseInt(strtime.substring(8, 10));
				int hour = Integer.parseInt(strtime.substring(10, 12));
				int min = Integer.parseInt(strtime.substring(13, 15));
				int sec = Integer.parseInt(strtime.substring(16, 18));
				if (mon > 12) {
					return -1;
				}
				if (day > 31) {
					return -2;
				}
				if (hour > 24 || min > 60 || sec > 60) {
					return -3;
				}
			}else if (k == 2) {
				if (checkDateFormate2(str).equals("日期格式不正确")) {
					return -5;
				}
				strtime = checkDateFormate2(str);
				int mon = Integer.parseInt(strtime.substring(5, 7));
				int day = Integer.parseInt(strtime.substring(8, 10));
				if (mon > 12) {
					return -1;
				}
				if (day > 31) {
					return -2;
				}
			}else{
				return -6;
			}
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return -4;
		}
	}
	
	/**
	 * 验证日期时间格式 yyyy-MM-dd HH:mm:ss
	 * @author 刘浩
	 * @date 2014-8-20
	 * @param date
	 * @return
	 */
	public static String checkDateFormate0(String date) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = df.format(df.parse(date));
			return str;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "日期格式不正确";
		}
	}
	
	/**
	 * 验证日期时间格式 yyyy-MM-ddHH:mm:ss
	 * @author 刘浩
	 * @date 2014-8-20
	 * @param date
	 * @return
	 */
	public static String checkDateFormate1(String date) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
			String str = df.format(df.parse(date));
			return str;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "日期格式不正确";
		}
	}
	
	/**
	 * 验证日期格式 yyyy-MM-dd
	 * @author 刘浩
	 * @date 2014-8-20
	 * @param date
	 * @return
	 */
	public static String checkDateFormate2(String date) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String str = df.format(df.parse(date));
			return str;
		} catch (Exception ex) {
			return "日期格式不正确";
		}
	}
	
	/**
	 * 取得一年的第几周
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week_of_year = c.get(Calendar.WEEK_OF_YEAR);
		return week_of_year - 1;
	}
	
	/**
	 * 得到一周的开始和结束
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getWeekBeginAndEndDate(Date date, String pattern) {
		Date monday = getMondayOfWeek(date);
		Date sunday = getSundayOfWeek(date);
		return  formatDate(monday, pattern) + " - "
				+ formatDate(sunday, pattern);
	}
	
	/**
	 * 取得某天相加(减)後的那一天
	 * 
	 * @param date
	 * @param num
	 *            (可正可负)
	 * @return
	 */
	public static Date getAnotherDate(Date date, int num) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, num);
		return c.getTime();
	}
	
	/**
	 * 从指定Timestamp中得到相应的日期
	 * 
	 * @param datetime
	 *            指定的Timestamp
	 * @return 日期 "2003-09-08"
	 */
	public static String getDateFromDateTime(Timestamp datetime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(datetime).toString();
	}
	
	/**
	 * 日期比较函数
	 * 
	 * @param second
	 *            Date 比较日期
	 * @return 返回当前日期与比较日期相差天数
	 * @throws ParseException
	 */
	public static long getDayCompare(Date second) throws ParseException {
		Date dt = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
		dt = ft.parse(ft.format(dt));
		second = ft.parse(ft.format(second));
		return dt.getTime() / 1000 / 60 / 60 / 24 - second.getTime() / 1000
				/ 60 / 60 / 24;
	}

	/**
	 * 日期比较函数
	 * 
	 * @param first
	 *            Date 源日期
	 * @param second
	 *            Date 比较日期
	 * @return 返回源日期与比较日期相差天数
	 * @throws ParseException
	 */
	public static long getDayCompare(Date first, Date second)
			throws ParseException {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
		first = ft.parse(ft.format(first));
		second = ft.parse(ft.format(second));
		return first.getTime() / 1000 / 60 / 60 / 24 - second.getTime() / 1000
				/ 60 / 60 / 24;
	}

	/**
	 * 日期比较函数
	 * 
	 * @param first
	 *            Date 源日期
	 * @param second
	 *            Date 比较日期
	 * @return 返回源日期与比较日期相差天数
	 * @throws ParseException
	 */
	public static long getDayCompareDays(String first, String second)
			throws ParseException {
		Date dt;
		Date dts;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dts = ft.parse(first);
		dt = ft.parse(second);
		long l = dt.getTime() - dts.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * 日期比较函数
	 * 
	 * @param first
	 *            Date 源日期
	 * @param second
	 *            Date 比较日期
	 * @return 返回源日期与比较日期相差小时数
	 * @throws ParseException
	 */
	public static long getDayCompareHours(String first, String second)
			throws ParseException {
		Date dt;
		Date dts;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dts = ft.parse(first);
		dt = ft.parse(second);
		return dts.getTime() / 1000 / 60 / 60 - dt.getTime() / 1000 / 60 / 60;
	}

	/**
	 * 日期比较函数
	 * 
	 * @param first
	 *            Date 源日期
	 * @param second
	 *            Date 比较日期
	 * @return 返回源日期与比较日期相差小时数
	 * @throws ParseException
	 */
	public static long getDayCompareHourss(String first, String second)
			throws ParseException {
		Date dt;
		Date dts;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dts = ft.parse(first);
		dt = ft.parse(second);
		long l = dt.getTime() - dts.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		return hour;
	}

	/**
	 * 日期比较函数
	 * 
	 * @param first
	 *            Date 源日期
	 * @param second
	 *            Date 比较日期
	 * @return 返回源日期与比较日期相差分钟数
	 * @throws ParseException
	 */
	public static long getDayCompareMins(String first, String second)
			throws ParseException {
		Date dt;
		Date dts;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dts = ft.parse(first);
		dt = ft.parse(second);
		long l = dt.getTime() - dts.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		return min;
	}

	/**
	 * 日期比较函数
	 * 
	 * @param first
	 *            Date 源日期
	 * @param second
	 *            Date 比较日期
	 * @return 返回源日期与比较日期相差秒数
	 * @throws ParseException
	 */
	public static long getDayCompareSeconds(String first, String second)
			throws ParseException {
		Date dt;
		Date dts;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dts = ft.parse(first);
		dt = ft.parse(second);
		long l = dt.getTime() - dts.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		return s;
	}
	
	/**
	 * 取得某天所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		return c.getTime();
	}
	
	/**
	 * 取得某年某周的第一天 对于交叉:2009-12-29到2009-01-04属于2009年的最后一周,2009-01-05为2009年第一周的第一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar calFirst = Calendar.getInstance();
		calFirst.set(year, 0, 7);
		Date firstDate = DateUtils.getFirstDayOfWeek(calFirst.getTime());
		Calendar firstDateCal = Calendar.getInstance();
		firstDateCal.setTime(firstDate);
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));
		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, (week - 1) * 7);
		firstDate = DateUtils.getFirstDayOfWeek(cal.getTime());
		return firstDate;
	}

	/**
	 * 取得某月的的最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);// 年
		cal.set(Calendar.MONTH, month - 1);// 月，因为Calendar里的月是从0开始，所以要减1
		cal.set(Calendar.DATE, 1);// 日，设为一号
		cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
		cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天
		return cal.getTime();// 获得月末是几号
	}
	
	/**
	 * 取得某天所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
		return c.getTime();
	}
	
	/**
	 * 取得某年某周的最后一天
	 * 对于交叉:2009-12-29到2009-01-04属于2009年的最后一周,2009-01-04为2009年最后一周的最后一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek(int year, int week) {
		Calendar calLast = Calendar.getInstance();
		calLast.set(year, 0, 7);
		Date firstDate = DateUtils.getLastDayOfWeek(calLast.getTime());
		Calendar firstDateCal = Calendar.getInstance();
		firstDateCal.setTime(firstDate);
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));
		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, (week - 1) * 7);
		Date lastDate = DateUtils.getLastDayOfWeek(cal.getTime());
		return lastDate;
	}
	
	/**
	 * 取得某一年共有多少周
	 * 
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
		return DateUtils.getWeekOfYear(c.getTime());
	}
	
	/**
	 * 获得当前系统时间 列如:12:51:25
	 * 
	 * @return String 返回时间字符串
	 */
	public static String getNowTime() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(date);
	}
	
	/**
	 * 得到当前时间的时间戳
	 * 
	 * @return 当前时间戳
	 */
	public static Timestamp getNowTimestamp() {
		long curTime = System.currentTimeMillis();
		return new Timestamp(curTime);
	}
	
	/**
	 * 取当前打印日期  2014年10月23日
	 * 
	 * @return
	 * @throws java.lang.Exception
	 */
	public static String getPrintDate() {
		String printDate = "";
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		printDate += calendar.get(Calendar.YEAR) + "年";
		printDate += (calendar.get(Calendar.MONTH) + 1) + "月";
		printDate += calendar.get(Calendar.DATE) + "日";
		return printDate;
	}
	
	/**
	 * 将指定日期转换为 Timestamp
	 * 
	 * @param dateStr
	 *            指定日期格式为 "20030908"
	 * @return Timestamp
	 * @throws Exception
	 */
	public static Timestamp getTimestamp(String dateStr) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000");
		return Timestamp.valueOf(sdf.format(DateUtils.getDate(dateStr,
				"yyyyMMdd")));
	}
	
	/**
	 * 根据日期取得对应周周一日期  
	 * 周一：一周第一天
	 * @param date
	 * @return
	 */
	public static Date getMondayOfWeek(Date date) {
		Calendar monday = Calendar.getInstance();
		monday.setTime(date);
		monday.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);
		monday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return monday.getTime();
	}
	
	/**
	 * 根据日期取得对应周周日日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getSundayOfWeek(Date date) {
		Calendar sunday = Calendar.getInstance();
		sunday.setTime(date);
		sunday.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);
		sunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return sunday.getTime();
	}
	
	/**
	 * 取得月的剩余天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getRemainDayOfMonth(Date date) {
		int dayOfMonth = getDayOfMonth(date);
		int day = getPassDayOfMonth(date);
		return dayOfMonth - day;
	}

	/**
	 * 取得月已经过的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getPassDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得月天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得月第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 取得月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 取得季度第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfSeason(Date date) {
		return getFirstDateOfMonth(getSeasonDate(date)[0]);
	}

	/**
	 * 取得季度最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfSeason(Date date) {
		return getLastDateOfMonth(getSeasonDate(date)[2]);
	}

	/**
	 * 取得季度天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfSeason(Date date) {
		int day = 0;
		Date[] seasonDates = getSeasonDate(date);
		for (Date date2 : seasonDates) {
			day += getDayOfMonth(date2);
		}
		return day;
	}

	/**
	 * 取得季度剩余天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getRemainDayOfSeason(Date date) {
		return getDayOfSeason(date) - getPassDayOfSeason(date);
	}

	/**
	 * 取得季度已过天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getPassDayOfSeason(Date date) {
		int day = 0;

		Date[] seasonDates = getSeasonDate(date);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);

		if (month == Calendar.JANUARY || month == Calendar.APRIL
				|| month == Calendar.JULY || month == Calendar.OCTOBER) {// 季度第一个月
			day = getPassDayOfMonth(seasonDates[0]);
		} else if (month == Calendar.FEBRUARY || month == Calendar.MAY
				|| month == Calendar.AUGUST || month == Calendar.NOVEMBER) {// 季度第二个月
			day = getDayOfMonth(seasonDates[0])
					+ getPassDayOfMonth(seasonDates[1]);
		} else if (month == Calendar.MARCH || month == Calendar.JUNE
				|| month == Calendar.SEPTEMBER || month == Calendar.DECEMBER) {// 季度第三个月
			day = getDayOfMonth(seasonDates[0]) + getDayOfMonth(seasonDates[1])
					+ getPassDayOfMonth(seasonDates[2]);
		}
		return day;
	}

	/**
	 * 取得季度月
	 * 
	 * @param date
	 * @return
	 */
	public static Date[] getSeasonDate(Date date) {
		Date[] season = new Date[3];

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int nSeason = getSeason(date);
		if (nSeason == 1) {// 第一季度
			c.set(Calendar.MONTH, Calendar.JANUARY);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.FEBRUARY);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.MARCH);
			season[2] = c.getTime();
		} else if (nSeason == 2) {// 第二季度
			c.set(Calendar.MONTH, Calendar.APRIL);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.MAY);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.JUNE);
			season[2] = c.getTime();
		} else if (nSeason == 3) {// 第三季度
			c.set(Calendar.MONTH, Calendar.JULY);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.AUGUST);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.SEPTEMBER);
			season[2] = c.getTime();
		} else if (nSeason == 4) {// 第四季度
			c.set(Calendar.MONTH, Calendar.OCTOBER);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.NOVEMBER);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			season[2] = c.getTime();
		}
		return season;
	}

	/**
	 * 
	 * 1 第一季度 2 第二季度 3 第三季度 4 第四季度
	 * 
	 * @param date
	 * @return
	 */
	public static int getSeason(Date date) {

		int season = 0;

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		switch (month) {
		case Calendar.JANUARY:
		case Calendar.FEBRUARY:
		case Calendar.MARCH:
			season = 1;
			break;
		case Calendar.APRIL:
		case Calendar.MAY:
		case Calendar.JUNE:
			season = 2;
			break;
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.SEPTEMBER:
			season = 3;
			break;
		case Calendar.OCTOBER:
		case Calendar.NOVEMBER:
		case Calendar.DECEMBER:
			season = 4;
			break;
		default:
			break;
		}
		return season;
	}
}
