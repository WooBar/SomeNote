package com.duanxp.module.time;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * @Version
 * @Author dxp
 * @Date 2019/6/1 0001
 */
public class TestTime {


    public static void main(String[] args) {


        //获取当前日期
        LocalDate today = LocalDate.now();
        System.out.println("today  -----> "+today);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间-时分秒 ----> "+now);
        System.out.println("now  ----> "+now.toString().replace("T"," "));

        LocalTime now1 = LocalTime.now();
        System.out.println("now1  ----> "+now1);

        //构造时间
        LocalTime time = LocalTime.of(2,2,1);

        //根据年月日获取日期
        LocalDate of = LocalDate.of(2014, 2, 6);
        System.out.println("of ------> "+of+"___"+time);



        // 注意格式
        //System.out.println(LocalDate.parse("2019-2-6"));
        System.out.println(LocalDate.parse("2019-02-06"));
        //System.out.println(LocalDate.parse("2019-06-6"));
        System.out.println(LocalDateTime.parse("2019-05-30T17:46:46"));

        String sqlDate = "2019-04-29 10:11:11";
        String nsqlDate = sqlDate.replace(" ","T");

        System.out.println("nosql   -------> "+ nsqlDate);

        //比较时分秒返回的是 大的时间
        System.out.println("比较时分秒 after --->"+LocalDateTime.now().isAfter(LocalDateTime.parse("2019-06-30T17:46:46")));
        System.out.println("比较时分秒 before --->"+LocalDateTime.now().isBefore(LocalDateTime.parse("2019-06-30T17:46:46")));

        System.out.println("使用LocalDate比较项目时间格式 before "+LocalDateTime.now().isBefore(LocalDateTime.parse(nsqlDate)));
        System.out.println("使用LocalDate比较项目时间格式 after "+LocalDateTime.now().isAfter(LocalDateTime.parse(nsqlDate)));

        //时间比较
        int i = of.compareTo(LocalDate.parse("2019-02-06"));
        System.out.println("i ------> "+i);

        int i1 = of.compareTo(LocalDate.parse("2014-01-07"));
        System.out.println("i1 -----> "+i1);

        LocalDate localDate = LocalDate.of(2014,2,7);
        boolean after = of.isAfter(localDate);
        System.out.println("after ------> "+after);
        System.out.println("before  -------> " + of.isBefore(localDate));

        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); // 2014-12-01
        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); // 2014-12-02
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-31
        // 取下一天：
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2015-01-01
        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2015-01-05



        //日期计算
        //计算两个日期相差多少天
        LocalDate one = LocalDate.of(2014,2,7);
        System.out.println("one ------> "+one);
        LocalDate two = LocalDate.of(2015,3,7);
        System.out.println("two ------> "+two);
        Period next = Period.between(one,two);
        System.out.println("peiod 计算时间差  后边减前边 只有天数相减 ---------> "+next.getDays());
        System.out.println("peiod 计算时间差  后边减前边 只有天数相减 ---------> "+next.getDays());

        LocalDateTime now2 = LocalDateTime.now();
        //
        System.out.println(now2.toString().replace("T"," ").substring(0,19));















    }


}
