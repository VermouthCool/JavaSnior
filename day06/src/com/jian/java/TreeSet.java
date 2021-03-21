package com.jian.java;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;

/**
 * @author Jiange
 * @create 2021-03-14-12:16
 */
public class TreeSet {
    /*
    TreeSet必须是相同类的对象
    两种排序方式：自然排序  和  定制排序
    对于这个TreeSet来说   如果一样  就会调用compareAble接口compareTo方法
    new TreeSet(new Comparator(){

    })
    在定制排序时  使用compare
    * */
    @Test
    public void test1(){
        Set set = new java.util.TreeSet();
        set.add(15 );
        set.add(456);
        set.add(98);
        Iterator iterator = set.iterator();
        System.out.println(set);
        //存着的数据会 按从小到大的顺序
        while (iterator.hasNext()){
            System.out.println(iterator.next());//15   98   496
        }
    }
    @Test
    public void test2(){
        LinkedList list = new LinkedList();
        list.add(123);
        list.add(456);
        list.add("jian");
        list.add(new StringBuffer("ge"));
        List asList = Arrays.asList("jian", new StringBuffer("ge"));
        list.removeAll(asList);
        System.out.println(list);
    }

}
