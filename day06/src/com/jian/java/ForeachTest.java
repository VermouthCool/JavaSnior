package com.jian.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Jiange
 * @create 2021-03-13-16:15
 *  foreach:    jdk5.0新加    用于遍历数组和集合
 */
public class ForeachTest {
    @Test
    public void test1(){
        Collection a = new ArrayList();
        a.add(123);
        a.add(456);
        a.add(new StringBuffer("123"));
        for (Object obj : a){//内部也是用了迭代器
            System.out.println(obj);
        }
        for (int b : new int[]{1,2,3,4,5,6}){//此时没有用迭代器
            System.out.println(b);
        }
    }
}
