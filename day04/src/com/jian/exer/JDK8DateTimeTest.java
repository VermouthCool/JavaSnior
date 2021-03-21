package com.jian.exer;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jiange
 * @create 2021-03-11-20:54
 */
public class JDK8DateTimeTest {
    @Test
    public void test1(){
        Date date = new Date(2020-1900,9-1,1);
        //Date里的月份是从1900年开始的、月份是从0月开始的
        System.out.println(date.toString());
    }
    @Test
    public void test2(){
        LocalDate now = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now);
        System.out.println(localTime);
        System.out.println(now1);
        /*
        2021-03-11
21:14:54.803379700
2021-03-11T21:14:54.803379700
        * */
        //of指定年月日时分秒没有偏移量
        LocalDateTime of = LocalDateTime.of(2020, 3, 11, 21, 18, 10);
        System.out.println(of);

        //getxxx
        System.out.println(now1.getDayOfMonth());
        System.out.println(now1.getDayOfWeek());
        System.out.println(now1.getMonth());
        System.out.println(now1.getMonthValue());
        System.out.println(now1.getMinute());

        //with 修改了自身不会变  不可变性
        System.out.println(now1.withDayOfMonth(10));
        System.out.println(now1);

        //plusxxx不可变性  负责添加 当然也可以写负数
        System.out.println(now1.plusDays(-10));
        System.out.println(now1);

        //minus 不可变性
        System.out.println(now1.minusDays(-10));
        System.out.println(now1);
    }
    @Test
    public void test3(){
        //instant的使用
        Instant time1 = Instant.now();//本初子午线的地点的时间
        OffsetDateTime offsetDateTime = time1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(time1);
        System.out.println(offsetDateTime);
        System.out.println(time1.toEpochMilli());//时间戳
        Instant instant = Instant.ofEpochMilli(1615470156089l);
    }
    @Test
    public void test4(){
        /*
        DateTimeFormatter:格式化或者解析日期、时间
        类似于SimpleDateFormat
        * */
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//        LocalDate now = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        System.out.println(isoLocalDateTime.format(now));
        TemporalAccessor parse = isoLocalDateTime.parse(isoLocalDateTime.format(now));
        System.out.println(parse);
//        2021-03-11T22:15:16.8219323
//        {},ISO resolved to 2021-03-11T22:15:16.821932300
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneOffset.ofHours(8));
        System.out.println(formatter.format(now));
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter1.format(LocalDateTime.now()));
        TemporalAccessor parse1 = formatter1.parse("2021-03-11 22:35:53");
        System.out.println(parse1);
    }
    @Test
    public void test5() throws ParseException {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        System.out.println(instance.get(instance.DAY_OF_YEAR));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        Date parse = simpleDateFormat.parse(format);
        System.out.println(localDateTime.getMinute());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(localDateTime));
//        dateTimeFormatter.parse()
    }
}
