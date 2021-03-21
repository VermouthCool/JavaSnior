package com.jian.exer;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Jiange
 * @create 2021-03-11-15:47
 * jdk 8.0之前的测试
 * SimpleDateFormat
 */
public class DateTimeTest {
    /*
    * simpleDateFormat 对Date的格式化
    *   1.格式化：日期----->字符串
    *   2.解析：字符串---->日期
    *
    * */
    @Test
    public void test1() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        //格式化
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println(format);//2021/3/11 下午3:57
        Date date1 = simpleDateFormat.parse("2021/3/11 下午3:57");
        System.out.println(date1.toString());
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat1.format(date));
    }
    @Test
    public void test2() throws ParseException {
        StringBuilder stringBuilder = new StringBuilder(10);
        stringBuilder.append(1).append(23456);
        System.out.println(stringBuilder.indexOf("1"));
        String s1 = new String("123456");
        System.out.println(s1.indexOf(1));
        s1.replace("a","jian");
        s1.replaceAll("\\|","jian");
        s1.split("\\|",2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        Date date1 = simpleDateFormat.parse(format);
        System.out.println(date1.toString());
        StringBuilder stringBuilder1 = new StringBuilder(10);
        stringBuilder1.append(123456);
        stringBuilder1.insert(0,10);

    }
    @Test
    public void test3(){
        /**
         *  Calander 是一个抽象类
         *  方式一：new 子类GregorianCalendar
         *  方式二：Calendar.getInstance（）
         *      常用操作：
         *          get
         *
         *          set
         *          add
         *          getTime
         *          setTime
         * */
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(gregorianCalendar.get(gregorianCalendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        calendar.set(calendar.DAY_OF_YEAR,10);
        System.out.println(calendar.get(calendar.DAY_OF_YEAR));
        calendar.add(calendar.DAY_OF_YEAR,-3);
        System.out.println(calendar.get(calendar.DAY_OF_YEAR));
        Date time = calendar.getTime();
        System.out.println(time.toString());
        calendar.setTime(time);
        System.out.println(calendar.toString());
    }
    @Test
    public void test4() throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
//        Date parse = simpleDateFormat.parse("");
        Calendar calendar = Calendar.getInstance();
        calendar.get(calendar.DAY_OF_YEAR);
//        calendar.set(calendar.DAY_OF_YEAR,20);
        Date time = calendar.getTime();
        calendar.setTime(time);
        calendar.add(calendar.DAY_OF_YEAR,2);

        System.out.println(calendar.get(calendar.MONTH));
    }

}
