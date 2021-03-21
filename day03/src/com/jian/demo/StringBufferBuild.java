package com.jian.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Jiange
 * @create 2021-03-10-16:28
 */
class MyThread implements Callable{
    private int a = 100;
    @Override
    public Object call() throws Exception {
        for(;a>0;a--){
            if(a%2 == 0){
                System.out.println(Thread.currentThread().getName()+":" + a);
            }
        }
        return 0;
    }
}
public class StringBufferBuild {
    /*
    * String StringBuffer StringBuilder的三者的异同
    *   String：
    *       不可变的字符序列
    *   StringBuffer：
    *       不可变的字符序列，效率低，线程安全的
    *   StringBuilder：
    *       可变的字符序列，效率高，线程不安全
    *   这三者都是使用char数组存储
    * */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
//        FutureTask futureTask = new FutureTask(myThread);
//        new Thread(futureTask).start();
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(myThread);
        service.submit(myThread);
        service.shutdown();
    }
    @Test
    public void test(){
        /*
        * String:new String()的时候创建了char数组长度为0
        * StringBUffer:new StringBuffer()的时候这是char数组的长度为16 new StringBuffer("abc")这时char[3+16]
        * new StringBuffer().length()结果就是0
        * 当要添加的字符串总的长度超过总长度时会扩容到原来的2倍+2 StringBuilder也是
        * 开发当中 建议使用StringBuffer（int capacity）StringBuilder（int capacity）
        * StringBuffer的常用方法 StringBuilder也一样
        * append()
        * delete(start,end)
        * +：append 返回了this 链式调用
        * -:delete
        * 改：setCharAt(int ,char)  replace(start,end,str)
        * 查：charAt(index)
        * 插：insert(index,xxx)
        *
        *
        * */
        StringBuffer s1 = new StringBuffer(20);
        s1.append(1);
        s1.append('2');
        s1.append("565");
//        s1.append(new MyThread());
        System.out.println(s1.toString());
        s1.replace(2,4,"jian");
        System.out.println(s1);//12jian5
        s1.insert(2,"shuai");
        System.out.println(s1.length());//12
        System.out.println(s1);//12shuaijian5
        s1.reverse();
        System.out.println(s1);//5naijiauhs21
        s1.delete(2,4);
        System.out.println(s1);//125
        s1.indexOf("123");//只能是字符串
        String s2 = s1.substring(1);
        System.out.println(s1);//5njiauhs21
        System.out.println(s2);//njiauhs21
        String s3 = s1.substring(1,5);//不包括尾
        System.out.println(s3);//njia
        System.out.println(s1.length());//10
        System.out.println(s1.charAt(0));//5
        s1.setCharAt(0,'6');//6njiauhs21
        System.out.println(s1);
    }
    @Test
    public void test2(){
        String s1 = new String("123abc");
        System.out.println(s1.indexOf(1));//-1
        StringBuilder stringBuilder = new StringBuilder("123abc");
        stringBuilder.append(1);
        System.out.println(stringBuilder);//123abc1
        stringBuilder.delete(6,7);
        System.out.println(stringBuilder);//123abc
        stringBuilder.replace(3,6,"456");
        System.out.println(stringBuilder);//123456
        stringBuilder.insert(0,new String("789"));
        System.out.println(stringBuilder);//789123456
        System.out.println(stringBuilder.length());//9
        String s2 = "jain";
        s2.replace("j","jain");
        System.out.println(s2.length());//4
        System.out.println(stringBuilder.indexOf("jian",1));
        System.out.println(stringBuilder.lastIndexOf("jian",5));
        System.out.println(stringBuilder.charAt(0));
        stringBuilder.setCharAt(0,'1');
        System.out.println(stringBuilder);
        stringBuilder.reverse();
        System.out.println(stringBuilder.capacity());
        System.out.println(new String(stringBuilder));
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
        System.out.println(chars == chars.clone());//false
        System.out.println(Arrays.toString(chars.clone()));//[1, 2, 3, a, b, c]
    }
}
