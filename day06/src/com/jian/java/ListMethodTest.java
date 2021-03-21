package com.jian.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * @author Jiange
 * @create 2021-03-13-19:36
 * LinkedList 方法测试
 * 总结
 *  add
 *  remove removeAll
 *  set
 *  get
 *  add()
 *  size()
 *  迭代器 foreach
 */
public class ListMethodTest {
    @Test
    public void test1(){
        LinkedList list = new LinkedList();
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(new StringBuffer("jian"));
        arrayList.add("ge");

        System.out.println(arrayList);

        //add(index,o) 插入
        arrayList.add(1,789);
        System.out.println(arrayList);

        //boolean addALl(inex,collection)
        arrayList.addAll(0,arrayList);
        System.out.println(arrayList);

        //get(index)
        System.out.println(arrayList.get(0));

        //indexOf(obj)没找到会返回-1  查找第一次出现的位置
        System.out.println(arrayList.indexOf(456));

        //lastindexof(obj)查找最后一次出现的位置
        arrayList.remove("ge");//只会删除第一次出现的这个对象
//        arrayList.removeAll(arrayList);
//        arrayList.removeAll(arrayList);
        System.out.println(arrayList);

        //Object remove(index) 删除指定位置的元素 返回被删除的元素
        Object remove = arrayList.remove(5);
        System.out.println(remove);
        System.out.println(arrayList);

        //Object set(index obj) 返回被修改的元素
        Object set = arrayList.set(0, 789);
        System.out.println(set);
        System.out.println(arrayList);

        //subList(start end) 不会改变原来的
        System.out.println(arrayList.subList(0,2));
        System.out.println(arrayList);

        arrayList.add(0,1);
        System.out.println(arrayList);
        arrayList.remove(Integer.valueOf(123));
    }
}
