package com.jian.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Jiange
 * @create 2021-03-12-19:04
 * 集合和数组都是容器
 * 存储：此时的存储指的是内存
 * 集合可以分为
 * Collection接口 单列集合  一个一个的对像
 * List接口 有序  动态数组 实现类 ArrayList LinkList Vector
 * set接口 无序   HashSet linkHashSet TreeSet
 * Map接口 双列集合 HashMap LinkMao TreeMap Hashtable Properties
 *
 */
public class CollectionTest {
    @Test
    public void test1(){
        //add(Object 0)
        Collection collection = new ArrayList();
        collection.add("aa");
        collection.add(123);//包装类
        collection.add(new Date());
        System.out.println(collection.size());//3
        Collection arr = new ArrayList();
        arr.add("123");
        arr.add(456);
        //addAll(Collection c)
        collection.addAll(arr);
        String a = "";
        System.out.println(a.isEmpty());
        System.out.println(a == "");
        System.out.println();
        StringBuilder b = new StringBuilder("123");
        StringBuilder c = new StringBuilder("121");
        System.out.println(b.compareTo(c));
        System.out.println(collection.isEmpty());//检查有几个元素
        collection.clear();//清空元素

        System.out.println(collection.toString());//[aa, 123, Fri Mar 12 19:51:35 CST 2021, 123, 456]
    }
}
