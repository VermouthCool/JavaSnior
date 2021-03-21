package com.jian.java;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * @author Jiange
 * @create 2021-03-13-13:45
 * Collection的方法
 */
public class CollectionTest {
    @Test
    public void test1(){
        //contains  判断时 调用参数对象所在类的equals方法  contains的参数.equals(集合元素)
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add("Tom");
        collection.add(false);
        collection.add(new StringBuffer("jian"));
        collection.add(new String("ge"));
        System.out.println(collection.contains(123));//true
        System.out.println(collection.contains(new StringBuffer("jian")));//false
        System.out.println(collection.contains(new String("ge")));//true

        //containsAll()判断形参里的所有元素是否都在调用者内
        System.out.println(collection.containsAll(collection));
    }
    @Test
    public void test2(){
        //remove() 从当前元素删除参数对象、成功 返回true 否则 false 调用时 会调用toString方法
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        System.out.println(collection.remove(12));//false
        System.out.println(collection.toString());//[123,456]
        collection.add(new StringBuffer("789"));
        collection.add(new String("101112"));
        System.out.println(collection.remove(new StringBuffer("789")));//false
        collection.remove("101112");
        System.out.println(collection.toString());
        collection.addAll(collection);
        System.out.println(collection);
        collection.removeAll(new ArrayList<>());
        System.out.println(collection);
        System.out.println(collection.removeAll(collection));
        System.out.println(collection);
        collection.clear();
        System.out.println(collection);
        System.out.println(collection.toString() == "[]");

        //retainAll() 获取当前集合和形参集合的交集，并返回给当前集合
        Collection list = Arrays.asList("123", 456);

        collection.add(123);
        collection.addAll(list);
        collection.retainAll(list);//true
        collection.retainAll(new ArrayList());//true
        System.out.println(collection);//true

        //equals()
        Collection a = new ArrayList();
        a.add(123);
        a.add(new StringBuffer("建哥"));
        Collection b = new ArrayList();
        b.add(123);
        b.add(new StringBuffer("建哥"));
        System.out.println(a.equals(b));//false

    }
    @Test
    public void test3(){
        Collection a = new ArrayList();
        a.add(123);
        a.add(456);
        a.add("jian");
        a.add(new StringBuffer("ge"));

        //hasCode()  返回当前对象的哈希值  该方法是定义在Objec上的
        System.out.println(a.hashCode());//1735748248

        //集合---->数组 （Object[]）
        Object[] objects = a.toArray();
        System.out.println(Arrays.toString(objects));

        //数组----->集合
        List strings =  Arrays.asList(new int[]{1,2});
        System.out.println(strings.size());//1

        List<Integer> integers = Arrays.asList(new Integer[]{1,2,3});
        System.out.println(integers.size());//3

        //iterator() 返回Iterator的接口的实例  每次调用都会得到一个新的Iteator对象 并且处在第一个位置之前的位置

    }
}
