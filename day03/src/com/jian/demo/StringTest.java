package com.jian.demo;

import org.junit.Test;

/**
 * @author Jiange
 * @create 2021-03-09-21:55
 * String的使用
 */
public class StringTest {
    private int age;
    /*
    * String:字符串 使用一对“”
    *   1.String是被声明为final的不能被继承
    *   2.String实现了Serializable接口：可以用来序列化。实现了Comparable接口、所以String可以比较大小
    *   3.String 内部定义了final char value[]用于存储字符串数据 11用的是 final Byte[]
    *   4.String：代表了不可变的字符序列简称：不可变性
    *   5.通过字面量的形式给字符串赋值 此时的变量存在方法区的常量池内
    *   6.字符串常量池中不会存储相同的字符串
    *   7.当对字符串重新赋值的时候、需要重新赋值内存地址
    *   8.当调用replace方法修改指定的字符修改时、也不能在原有的字符上修改
    * */
    @Test
    public void method(){
        String s1 = "abc";//字面量
        String s2 = "abc";
//        s1 = "abc";
//        s1 = "hel";
        System.out.println(s1 == s2);//比较地址值
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("*****************************");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);
        String s4 = "abcdef";
        System.out.println(s2);
        System.out.println(s3 == s4);//false
        String s5 = "abc";
        String s6 = s5.replace('a','m');
        System.out.println(s5);//abc
        System.out.println(s6);//mbc
        System.out.println(s1 == "abc");//true
        System.out.println("abc"=="abc");//true
        System.out.println(s3 == "abcdef");//false
    }
    /*
    * String实例化的方式：
    *   1.通过字面量的方式
    *   2.通过new 构造器
    * new String() 的时候是创建了两个对象一个是new出来的堆内的结构、另一个是常量池的数据：本质上的内容
    * */
    @Test
    public void method2(){
        //此时的s1和s2存在常量池内
        String s1 = "java";
        String s2 = "java";

        //s3 s4是堆空间开辟的地址值
        String s3 = new String("java");//此时的string对象的value属性存着常量池的java的地址
        String s4 = new String("java");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false
        System.out.println("jian"+"ge" == "jiange");//true
        System.out.println(s3+"jian" == "javajian");//false
        System.out.println(s1+"ge"=="javage");//false
        System.out.println(s1+"ge"==s1);//false
    }
    public StringTest(){

    }
    /**
     *  常量和常量拼接的结果在常量池、常量池不会存相同的变量
     *  只要有一个变量参与、就会在堆空间新开辟 这个变量可以是其他类型的变量
     * */
    @Test
    public void method3(){
        String s1 = "javaee";
        String s2 = "hadoop";

        String s3 = "javaeehadoop";
        String s4 = "javaee"+"hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaee"+s2;
        String s7 = s1+s2;
        String s8 = s5.intern();//此时返回值得到的就是使用的常量池中存在的地址

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s6 == s7);//false
        System.out.println(s3 == s8);//true

        String sa = "jian";
        sa = "ge";
        String sb = new String("jian");
        sb = "ge";
        System.out.println(sa);//ge
        System.out.println(sb);//ge
        System.out.println(sa == sb);//true

        char a = 1;//把Unicode编码中的第一位的字符赋给它
        System.out.println(a);
    }
}
