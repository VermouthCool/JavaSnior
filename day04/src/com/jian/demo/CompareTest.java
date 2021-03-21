package com.jian.demo;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiange
 * @create 2021-03-11-23:00
 * Comparable 自然排序
 *      1.像String、包装类等实现了Comparable接口、重写了compareTo方法，这样就能使用Arrays.sort()
 *      2.重写compareTo的规则
 *          小返回负数
 *          大返回正数
 *          等于返回0
 *      3.对于自定义类想要排序 就要实现Comparable接口 重写方法 才能调用Arrays。sort()
 * Comparator 定制排序
 *      1.当元素的类型没有实现接口也不能去修改类或者实现了不符合要求
 *
 */
public class CompareTest {
    @Test
    public void test1(){
        String[] strings = new String[]{"aa","bb","cc","aa"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));//[aa, aa, bb, cc]
    }
    @Test
    public void test2(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(localDateTime).toString());
        TemporalAccessor parse = formatter.parse("2021-03-12 12:50:15");
        System.out.println(formatter.format(parse));
    }
    @Test
    public void test3(){
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("lianxiang",34);
        goods[1] = new Goods("daier",4);
        goods[2] = new Goods("xiaomi",44);
        goods[3] = new Goods("huawei",94);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }
    @Test
    public void test4(){
        String[] strings = new String[]{"aa","bb","cc","aa"};
        Arrays.sort(strings,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof  String){
                    String o11 = (String) o1;
                    String o21 = (String) o2;
                    return o21.compareTo(o11);
                }else {
                    throw new RuntimeException("输入的不一致");
                }
            }
        });
        System.out.println(Arrays.toString(strings));
    }
}
