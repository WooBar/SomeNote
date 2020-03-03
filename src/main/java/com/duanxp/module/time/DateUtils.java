package com.duanxp.module.time;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * 类名
 * </p>
 * 日期工具类，快速获得日期，对日期格式进行转换
 *
 * @author Administrator
 * @version 1.0
 */
public class DateUtils {

	private static Logger log = Logger.getLogger(DateUtils.class);

	public static final String YYYY = "yyyy";
	public static final String MM = "MM";
	public static final String DD = "dd";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String HH_MM_SS = "HH:mm:ss";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String HH_MM = "HH:mm";
	public static final String HHMM = "HHmm";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String HHMMSS = "HHmmss";
	public static final String MM0DD0 = "MM月dd日";
	public static final String YYYYMMDDHHMM = "yyMMddHHmm";

	/**
	 * 获取当前日期
	 * @return 一个包含年月日的<code>Date</code>型日期
	 */
	public static synchronized Date getCurrDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	/**
	 * 获取当前时间
	 *
	 * @param pattern 返回时间的格式
	 * @return
	 */
	public static String getCurrentDateStr(String pattern) {
		return formatStr(null, pattern);
	}

	/**
	 * 把字符串日期转换为pattern指定格式的Data对象
	 *
	 * @param strDate 日期字符串,如果是当前日期传null
	 * @param pattern 日期格式
	 * @return
	 */
	public static Date formatDate(String strDate, String pattern) {
		Date d = new Date();
		if (StringUtils.isNotEmpty(strDate)) {
			try {
				d = getFormatter(pattern).parse(strDate);
			} catch (ParseException pex) {
				log.error("format -> 日期格式转换异常：" + pex.toString());
			}
		}
		return d;
	}

	/**
	 * 将日期转化为指定格式字符串
	 *
	 * @param date 指定日期，如果为当前日期传null
	 * @param pattern 指定格式
	 * @return
	 */
	public static String formatStr(Date date, String pattern) {
		if (date == null) {
			date = new Date();
		}

		return getFormatter(pattern).format(date);
	}

	/**
	 * 获取当前日期的后？个月日期
	 *
	 * @param num ?个月
	 * @param pattern 返回日期格式
	 * @return ？个月后的时间
	 */
	public static String getNextMonth(int num, String pattern) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, num);
		Date otherDate = cal.getTime();

		return getFormatter(pattern).format(otherDate);
	}

	/**
	 * 获取给定日前的后intevalDay天的日期
	 *
	 * @param refenceDate Date 给定日期,如果是当前日期传null
	 * @param intevalDays int 间隔天数
	 * @param pattern 返回日期格式
	 * @return String 计算后的日期
	 */
	public static String getNextDate(Date refenceDate, int intevalDays, String pattern) {
		String targetDate = null;
		try {
			if (refenceDate == null) {
				refenceDate = new Date();
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(refenceDate);
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + intevalDays);
			targetDate = getFormatter(pattern).format(calendar.getTime());
		} catch (Exception ee) {
			log.error("getNextDate -> 获取指定日期后指定天的日期异常：" + ee.toString());
		}

		return targetDate;
	}


	/**
	 * 获取给定时间的后指定毫秒数的时间
	 *
	 * @param refenceDate Date 给定日期,如果是当前日期传null
	 * @param milli 延后时间的毫秒数
	 * @param pattern 返回日期格式
	 * @return String 计算后的日期
	 */
	public static String getNextTime(Date refenceDate, long milli, String pattern) {
		String targetDate = null;
		try {
			if (refenceDate == null) {
				refenceDate = new Date();
			}
			long curMilli = refenceDate.getTime();
			long targetMili = curMilli + milli;
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(targetMili);
			targetDate = getFormatter(pattern).format(calendar.getTime());
		} catch (Exception ee) {
			log.error("getNextDate -> 获取指定时间后指定毫秒数的时间异常：" + ee.toString());
		}

		return targetDate;
	}

	/**
	 * 求两个日期的相差天数
	 *
	 * @param startDate 指定日期字符串,如果是当天传null
	 * @param endDate 指定结束日期，如果是当天传null
	 * @param pattern 指定日期所用格式
	 *
	 * @return
	 */
	public static long getDaysBetweenTwoDate(String startDate, String endDate, String pattern) {
		long days = 0;
		try {
			long startTimer = 0L, endTimer = 0L;
			SimpleDateFormat sdf = getFormatter(pattern);
			if (startDate == null) {
				startTimer = new Date().getTime();
			} else {
				startTimer = sdf.parse(startDate).getTime();
			}
			if (endDate == null) {
				endTimer = new Date().getTime();
			} else {
				endTimer = sdf.parse(endDate).getTime();
			}
			// 两个时间之间的天数
			days = (endTimer - startTimer) / (24 * 60 * 60 * 1000);
		} catch (Exception ee) {
			log.error("getTodayIntevalDays -> 获取当前日期与指定日期间隔天数异常：" + ee.toString());
		}

		return days;
	}

	/**
	 * 根据指定时间获取该时间指定分钟数后的时间的倒计时秒数
	 *
	 * @param startDate 指定的计时开始时间
	 * @param pattern 传入的时间格式
	 * @param minus 指定时间后的分钟数（如果是截至当前时间则传0）
	 * @return
	 */
	public static long getTimer(String startDate, String pattern, int mins) {
		long seconds = 0;
		try {
			Date currentDate = new Date();// 当前时间
			Date theDate = getFormatter(pattern).parse(startDate);// 指定日期
			long endtime = theDate.getTime() + (mins * 60 * 1000);
			// 两个时间之间的天数
			seconds = ((endtime - currentDate.getTime()) / 1000);
		} catch (Exception ee) {
			log.error("getOrderPaySeconds -> 获取订单支付倒计时秒数异常：" + ee.toString());
		}

		return seconds;
	}

	/**
	 * 根据指定日期获取星期几
	 *
	 * @param time 指定日期，如果是当前日期请传null
	 * @param pattern 指定日期的格式
	 * @param args
	 */
	public static String getWeekDay(String time, String pattern) {
		if (time == null) {
			pattern = YYYY_MM_DD;
			time = getFormatter(pattern).format(new Date());
		}
		String[] str = { "", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", };
		return str[weekOfDay(time, pattern)];
	}

	/**
	 * 获取指定日期在星期七天中的序列
	 *
	 * @param time 指定日期
	 * @param pattern 指定日期的格式
	 * @return
	 */
	public static int weekOfDay(String time, String pattern) {
		Calendar calendar = Calendar.getInstance();// 获得一个日历
		try {
			Date date = getFormatter(pattern).parse(time);
			calendar.setTime(date);
		} catch (ParseException e) {
			log.error("weekOfDay -> 获取指定时间的星期异常：" + e.toString());
		}

		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 判断当前是否在时间1、时间2之间
	 *
	 * @param date1 前时间
	 * @param date2 后时间
	 * @param pattern 传入时间的格式
	 * @return
	 */
	public static boolean isDateIn(String date1, String date2, String pattern) {
		boolean flag = false;
		try {
			Date date = new Date();
			SimpleDateFormat df = getFormatter(pattern);
			flag = date.after(df.parse(date1)) && date.before(df.parse(date2));
		} catch (ParseException e) {
			log.error("isDateIn -> 判断当前时间是否在两个时间之间异常：" + e.toString());
		}

		return flag;
	}

	/**
	 * 功能描述：返回小
	 *
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar  calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 日期时间字符串格式转换
	 *
	 * @param dateTime 指定日期时间字符串
	 * @param patternSource 源日期时间格式
	 * @param patternTarget 目标时间日期格式
	 * @return
	 */
	public static String transformat(String dateTime, String patternSource, String patternTarget) {
		String s = null;
		try {
			s = getFormatter(patternTarget).format(getFormatter(patternSource).parse(dateTime));
		} catch (ParseException e) {
			log.error("transformat -> 日期格式转换异常：" + e.toString());
		}

		return s;
	}

	/**
	 * 获取一个简单的日期格式化对象
	 *
	 * @return 一个简单的日期格式化对象
	 */
	private static SimpleDateFormat getFormatter(String parttern) {
		return new SimpleDateFormat(parttern);
	}

	/**
	 * 获取某个时间 之后多少天的那个时间
	 * @param date
	 * @param day
	 * @return
	 * @throws Exception
	 */
    public static Date addDate(Date date,long day) throws Exception {
        long time = date.getTime(); // 得到指定日期的毫秒数
        day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
        time+=day; // 相加得到新的毫秒数
        return new Date(time); // 将毫秒数转换成日期
    }

    /**
     * -两个时间相加
     * @param date1
     * @param date2
     * @return
     * @throws Exception
     * @author Guo
     * @date 2019年4月29日 上午9:53:52
     */
    public static String addDate(String date1,Date date2) throws Exception {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	Date firstDate = df.parse(date1);
    	long time1 = firstDate.getTime();
    	long time2 = date2.getTime(); // 得到指定日期的毫秒数
    	Date date = new Date(time1 + time2);
    	return String.valueOf(date);
    }

    /**
     * -两个时间相加
     * @param date1
     * @param day
     * @return
     * @throws Exception
     * @author Guo
     * @date 2019年4月29日 上午10:28:33
     */
    public static String addDate(String date1,long day) throws Exception {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	Date firstDate = df.parse(date1);
    	long time1 = firstDate.getTime();
        day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
        Date date = new Date(time1 + day);
    	return String.valueOf(date);
    }

    /**
     * 获取指定时间的毫秒数
     * @Description  给定一个时间格式，获取这个时间的毫秒数
     * @param str 字符串类型的时间
     * @param pattern 字符串类型的时间格式
     * @return long类型的毫秒数
     * @throws Exception
     * @author Guo
     * @date 2019年5月9日 上午10:13:16
     */
    public static Long strToLong(String str, String pattern) throws Exception {
    	SimpleDateFormat sf = new SimpleDateFormat(pattern);
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(sf.parse(str));
    	return calendar.getTimeInMillis();
    }

	public static void main(String[] args) throws ParseException {
		/*
		 * System.out.println(getNextMonth(12, YYYY_MM_DD_HH_MM_SS));
		 *
		 * String weekDay = getWeekDay(null, YYYY_MM_DD_HH_MM_SS);
		 * System.out.println(weekDay);
		 */

//		long daysBetweenTwoDate = getDaysBetweenTwoDate("2019-02-01 10:00", "2019-02-02 10:00",
//				DateUtils.YYYY_MM_DD_HH_MM);
//		String time = "2019-05-08 15:00:45";
		Calendar calendar = Calendar.getInstance();

		System.out.println(calendar.getTimeInMillis());
		System.out.println(Calendar.getInstance().getTimeInMillis());

		SimpleDateFormat df = getFormatter(DateUtils.YYYY_MM_DD_HH_MM_SS);
		Date parse = df.parse("2019-05-10 13:57:00");
		System.out.println(new Date().before(parse));

		boolean dateIn = isDateIn("2019-05-10 13:57:00", "2019-05-10 14:57:00", DateUtils.YYYY_MM_DD_HH_MM_SS);
		System.out.println(dateIn);

	}


//	public static String compareDateStatus(String startTime, String endTime){
//
//    	if (StringUtils.isBlank(startTime) || StringUtils.isBlank(endTime)){
//    		return "";
//		}
//
//		//判断当前是否在时间1、时间2之间
//		boolean dateIn = DateUtils.isDateIn(startTime, endTime, DateUtils.YYYY_MM_DD);
//		//获取 当前时间和结束时间的差
//		long daysBetweenEndAndNow = DateUtils.getDaysBetweenTwoDate(DateUtils.getCurrentDateStr(DateUtils.YYYY_MM_DD),startTime, DateUtils.YYYY_MM_DD);
//		//获取 当前时间与开始时间的差
//		long daysbetweenStartAndNow = DateUtils.getDaysBetweenTwoDate(DateUtils.getCurrentDateStr(DateUtils.YYYY_MM_DD), startTime, DateUtils.YYYY_MM_DD);
//
//		long nowDate = System.currentTimeMillis();
//
//
//		if (dateIn){
//			return "进行中";
//		}
//
//
//
//
//
////
//////
//////		if (StringUtils.isBlank(startTime) && StringUtils.isBlank(activity.getEndTime())){
//////			activity.setActivitySatus("0");
//////		}else {
//////			//现在时间在开始时间和结束时间之内  或者 开始时间与现在的是时间差为0  或者 结束时间与现在的时间差为 0   已经在添加时间的时候排除结束时间大于开始时间的情况
//////			if (dateIn || daysbetweenStartAndNow == 0 || daysBetweenEndAndNow == 0){
//////				//  进行中
//////				activity.setActivitySatus("1");
//////			}else if (daysBetweenEndAndNow < 0 ){
//////				//开始时间和结束时间都不为空  已结束
//////				activity.setActivitySatus("2");
//////			}else if (daysbetweenStartAndNow > 0 && daysBetweenEndAndNow > 0){
//////				//未开始
//////				activity.setActivitySatus("0");
//////			}else {
//////				return new ResultDto(AppCode.LOGIC, AppMessage.PARAM);
//////			}
////		}
//
//	}
//















}

