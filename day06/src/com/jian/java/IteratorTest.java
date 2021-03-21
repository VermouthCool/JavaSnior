package com.jian.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Jiange
 * @create 2021-03-13-15:31
 * 集合元素的遍历  使用Iterator接口  迭代器接口
 *
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection a = new ArrayList();
        a.add(123);
        a.add(456);
        a.add(new StringBuffer("123"));
        Iterator iterator = a.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
////        System.out.println(iterator.next()=="123");//false
//        System.out.println( iterator.next() instanceof StringBuffer);//true
//        //java.util.NoSuchElementException 报错
//        System.out.println(iterator.next());
        System.out.println(iterator.toString());
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            if(Integer.valueOf(123).equals(iterator.next())){
                iterator.remove();
            }
//            System.out.println(iterator.next());
        }
        Iterator iterator1 = a.iterator();
        while(iterator1.hasNext()){

            System.out.println(iterator1.next());//456 123
        }
    }
}
