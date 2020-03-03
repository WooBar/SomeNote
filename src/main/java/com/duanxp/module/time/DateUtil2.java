package com.duanxp.module.time;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 */
public class DateUtil2 {

    private static final Logger LOG = LoggerFactory
            .getLogger(DateUtil2.class);

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss"; // 默认日期格式

    public static final String DATE_FORMAT = "yyyy-MM-dd"; // 默认日期格式

    /**
     * 构造函数
     */
    private DateUtil2() {
        throw new IllegalAccessError("Utility class");
    }


    /**
     * 按照指定的时间格式转换成Date对象
     *
     * @param format  格式字符串
     * @param dateStr 时间字符串
     * @return 时间
     */
    public static Date format(String format, String dateStr) {
        if(null==format||null==dateStr){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            LOG.error("format err", e);
        }
        return date;
    }

    /**
     * 将时间毫秒格式化为字符串
     *
     * @param format 时间格式
     * @param date   时间毫秒
     * @return 时间
     */
    public static String format(String format, Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 格式化到精确到秒的时间字符串
     * @param date 时间
     * @return 时间
     */
    public static String formatBySec(Date date) {
        return new SimpleDateFormat(DATETIME_FORMAT).format(date);
    }

    /**
     * 格式化到精确到秒的时间字符串
     * @param dateStr 时间
     * @return 时间
     */
    public static Date formatBySec(String dateStr) {
        return format(DATETIME_FORMAT, dateStr);
    }

    /**
     * 获取间隔一定月数的日期
     *
     * @param date 日期
     * @param month 月数
     * @return 时间
     */
    public static Date getIntervalMonth(Date date, int month) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(cal.MONTH, month);
        return cal.getTime();
    }

    /**
     * 获取间隔一定天数的日期
     *
     * @param date 日期
     * @param day 天数
     * @return 时间
     */
    public static Date getIntervalDay(Date date, long day) {
        Date result = new Date();
        result.setTime(date.getTime() + day * 1000 * 24 * 60 * 60l);
        return result;
    }

    /**
     * 获取间隔一定小时数的日期
     *
     * @param date 日期
     * @param hour 小时数
     * @return 时间
     */
    public static Date getIntervalHour(Date date, long hour) {
        Date result = new Date();
        result.setTime(date.getTime() + hour * 1000 * 60 * 60l);
        return result;
    }

    /**
     * 得到输入日期这个星期的星期一
     *
     * @param date 日期
     * @return 时间
     */
    public static Date getFirstDayOfWeek(Date date) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        switch (gc.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                gc.add(Calendar.DATE, -6);
                break;
            case Calendar.MONDAY:
                gc.add(Calendar.DATE, 0);
                break;
            case Calendar.TUESDAY:
                gc.add(Calendar.DATE, -1);
                break;
            case Calendar.WEDNESDAY:
                gc.add(Calendar.DATE, -2);
                break;
            case Calendar.THURSDAY:
                gc.add(Calendar.DATE, -3);
                break;
            case Calendar.FRIDAY:
                gc.add(Calendar.DATE, -4);
                break;
            case Calendar.SATURDAY:
                gc.add(Calendar.DATE, -5);
                break;
            default:
                LOG.error("getFirstDayOfWeek param err");
                break;
        }

        return gc.getTime();
    }

    /**
     * 是否是周末
     * @param date  时间
     * @return TRUE or FLASE
     */
    public static boolean isWeekend(Date date) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        int temp=gc.get(Calendar.DAY_OF_WEEK);
        return temp== Calendar.SUNDAY||temp== Calendar.SATURDAY;
    }

    /**
     * 得到一周的日期
     *
     * @param date 时间
     * @return 时间
     */
    public static List<Date> getWeek(Date date) {
        List<Date> list = new ArrayList<>();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        Date dateTemp = getTodayStart(date);
        gc.setTime(dateTemp);
        int num = gc.get(Calendar.DAY_OF_WEEK) - 1;
        if (num == 0) {
            num = 7;
        }
        for (int i = 1; i <= 7; i++) {
            gc.setTime(dateTemp);
            gc.add(Calendar.DATE, i - num);
            list.add(gc.getTime());
        }

        return list;
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param date1 比较的日期
     * @param date2 比较的日期
     * @return  TRUE or FLASE
     */
    public static boolean isSameDay(Date date1, Date date2) {
        return getDateDiff(date1, date2) == 0 ? true : false;
    }

    /**
     * 获取两个时间的小时差
     *
     * @param date1 比较的日期
     * @param date2 比较的日期
     * @return 小时差
     */
    public static int getHourDiff(Date date1, Date date2) {
        return Math
                .abs((int) ((date1.getTime() - date2.getTime()) / 1000 / 60 / 60));
    }

    /**
     * 获取两个时间的分钟差
     *
     * @param date1 比较的日期
     * @param date2 比较的日期
     * @return 分钟差
     */
    public static int getMinuteDiff(Date date1, Date date2) {
        return Math
                .abs((int) ((date1.getTime() - date2.getTime()) / 1000 / 60));
    }

    /**
     * 获取两个时间的秒数差
     *
     * @param date1 比较的日期
     * @param date2 比较的日期
     * @return 描述差
     */
    public static int getSecondDiff(Date date1, Date date2) {
        return Math.abs((int) ((date1.getTime() - date2.getTime()) / 1000));
    }

    /**
     * 获取两个时间的天数差
     *
     * @param date1 比较的日期
     * @param date2 比较的日期
     * @return 天数差
     */
    public static int getDateDiff(Date date1, Date date2) {
        return Math
                .abs((int) ((date1.getTime() - date2.getTime()) / 1000 / 60 / 60 / 24));
    }

    /**
     * 获取两个时间的年数查
     *
     * @param begin 比较的日期
     * @param end 比较的日期
     * @return 天数差
     */
    public static int getYearDiff(Date begin, Date end) {
        Calendar calBegin = Calendar.getInstance(); //获取日历实例
        Calendar calEnd = Calendar.getInstance();
        calBegin.setTime(begin); //字符串按照指定格式转化为日期
        calEnd.setTime(end);
        return calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR);
    }

    /**
     * 计算年龄
     * @param begin 出生日期
     * @param end 当前事件
     * @return 返回年龄
     */
    public static int getAge(Date begin, Date end){
        Calendar calBegin = Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();
        if (calEnd.before(begin)){
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }
        calBegin.setTime(begin);
        calEnd.setTime(end);
        int age = calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR);
        if (calBegin.get(Calendar.MONTH) > calEnd.get(Calendar.MONTH)){
            age --;
        } else if (calBegin.get(Calendar.MONTH) == calEnd.get(Calendar.MONTH)
                && calBegin.get(Calendar.DAY_OF_MONTH) > calEnd.get(Calendar.DAY_OF_MONTH)){
            age --;
        }
        return age;
    }

    /**
     * 获取半小时前时间
     * @param date 日期
     * @return 半小时前时间
     */
    public static Date getHalfHourBefore(Date date){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE,-30);
        return cal.getTime();
    }

    /**
     * 得到这个日期的最后一秒
     *
     * @param date 日期
     * @return 时间
     */
    public static Date getTodayEnd(Date date) {
        String day = new SimpleDateFormat(DATE_FORMAT).format(date);
        day = day + " 23:59:59";
        Date result = null;
        try {
            result = new SimpleDateFormat(DATETIME_FORMAT).parse(day);
        } catch (ParseException e) {
            LOG.error("ParseException", e);
        }
        return result;
    }

    /**
     * 得到这个日期的第一秒
     *
     * @param date 日期
     * @return 时间
     */
    public static Date getTodayStart(Date date) {
        String day = new SimpleDateFormat(DATE_FORMAT).format(date);
        day = day + " 00:00:00";
        Date result = null;
        try {
            result = new SimpleDateFormat(DATETIME_FORMAT).parse(day);
        } catch (ParseException e) {
            LOG.error("ParseException", e);
        }
        return result;
    }

    /**
     * 得到输入日期的间隔所有日期（包括输入日期）
     *
     * @param date 日期
     * @param day 天数
     * @param format 格式
     * @return 时间
     */
    public static List<String> getDays(Date date, int day, String format) {
        int i = 0;
        int j =day;
        if (j < 0) {
            i = j;
            j = 0;
        }
        List<String> list = new ArrayList<>();
        for (; i <= j; i++) {
            Date temp = getIntervalDay(date, i);
            list.add(format(format, temp));
        }
        return list;
    }

    /**
     * 返回时间
     * @param date1 比较的日期
     * @param date2 比较的日期
     * @return 时间
     */
    public static List<String> getDays(Date date1, Date date2) {
        int num = getDateDiff(date1, date2);
        Date start = date1;
        if (date1.getTime() > date2.getTime()) {
            start = date2;
        }
        return  getDays(start, num, DATE_FORMAT);
    }

    /**
     * 相同的月份
     * @param date1  比较的日期
     * @param date2 比较的日期
     * @return 时间
     */
    public static boolean isSameMonth(Date date1, Date date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String param1 = sdf.format(date1);//参数时间
        String param2 = sdf.format(date2);//当前时间
        return param1.equals(param2);

    }

    /**
     * 同一年
     * @param date1 比较的日期
     * @param date2 比较的日期
     * @return 是否同一年
     */
    public static boolean isSameYear(Date date1, Date date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String param1 = sdf.format(date1);//参数时间
        String param2 = sdf.format(date2);//当前时间
        return param1.equals(param2);
    }

    /**
     * 得到月份
     * @param data 日期
     * @return 月份
     */
    public static int getMonth(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获得间隔N个月的第一天
     * @param data 日期
     * @param num 间隔月份
     * @return 日期
     */
    public static Date getFirstMonthdate(Date data, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.MONTH, num);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }



}
