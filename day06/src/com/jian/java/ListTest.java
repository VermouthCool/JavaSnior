package com.jian.java;

import org.junit.Test;

/**
 * @author Jiange
 * @create 2021-03-13-16:36
 * List 接口 存储可重复、有序的内容 动态数组
 *      ArrayList
 *          作为list接口的主要实现类、线程不安全、效率高、底层用Object[]存储
 *          jdk7.0：空参构造器 默认长度为10、扩容的时候  默认会扩容到1.5bei
 *          建议开发时使用带参的构造器 new ArrayList(50)
 *          jdk 8.0:空参时会创建一个空数组、当add时会创建数组 小于10时 创建10，扩容没变
 *          小结：7类似于饿汉式  8类似于懒汉式、节省内存
 *      LinkedList
 *          底层用双向链表存储、对于频繁的插入删除，使用此类效率高
 *
 *      Vector
 *          作为list接口的古老实现类、线程安全、效率慢、底层Object[]
 *          空参时 长度就是十，扩容的方法是2倍，以后基本不用
 *    三个实现类 都实现了 可重复、有序
 *    不同：
 */
public class ListTest {
    @Test
    public void test1(){
        Object[] objects = {};
        System.out.println(objects.length);
    }
}
