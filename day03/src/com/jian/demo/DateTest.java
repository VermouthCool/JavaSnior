package com.jian.demo;

import org.junit.Test;

import java.util.Date;

/**
 * @author Jiange
 * @create 2021-03-10-17:44
 */
public class DateTest {
    @Test
    public void test1(){
        System.out.println(System.currentTimeMillis());//1615369557646  时间戳

    }
    @Test
    public void test2(){
        /*
        *  java.sql.Date extends java.util.Date
        * java.util.Date:
        *   1.两个构造器的使用
        *   2.两个方法的使用
        *       toString():输出Wed Mar 10 17:51:45 CST 2021
        *       getTime():获取当前时间的时间戳
        *java.sql.Date:
        * 如何将sql的date对象变成util的
        * new sql(date.getTime())
        * */
        Date date = new Date();
        System.out.println(date.toString());//Wed Mar 10 17:51:45 CST 2021
        System.out.println(date.getTime());//1615369973601
        Date date1 = new Date(1615369973601l);//创建指定时间的对象
        System.out.println(date1);

        java.sql.Date date2 = new java.sql.Date(1615369973601l);
        System.out.println(date2);//2021-03-10
        System.out.println(date2.getTime());//1615369973601
    }
}
