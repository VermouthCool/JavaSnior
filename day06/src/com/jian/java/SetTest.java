package com.jian.java;

import org.junit.Test;

import java.util.*;

/**
 * @author Jiange
 * @create 2021-03-13-21:00
 * Set 接口没有额外的方法
 *  HashSet
 *      作为Set接口的主要的实现类：线程不安全的；可以存储null值 底层使用的数组
 *      jdk7.0：数组默认长度是16  存储的内容 并不是按照索引添加，而是根据数据的哈希值添加
 *  LinkedHashSet
 *      HashSet的子类，特点：linked，遍历其内部数据的时候，可以按照添加的顺序遍历
 *  TreeSet
 *      使用红黑树存储、要求此时存储的内容必须是同一个类的对象 可以按照对象的指定属性 进行排序
 *  List都可以添加null元素
 *
 * HashMap可以有1个key为null的元素，TreeMap不能有key为null的元素
 * Set底层是Map
 * 所以HashSet可以有1个null的元素，TreeSet不能有key为null的元素。
 *
 * 作者：我不懂我不懂a
 * 链接：https://www.jianshu.com/p/c32e192e371d
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SetTest {
    /*
    1.无序性
        无序性：不等于随机性。

    2.不可重复性
        不能添加一样的内容  调用equals方法判断是否一样
    3.添加元素的过程(hashset)
        hashset底层是数组，添加元素时 先调用所在类的hashcode的方法，计算元素的哈希值。然后通过某种算法
        计算出在底层hashset的存储位置索引，判断此位置是否有元素，如果没有，则则直接添加成功
        如果在此位置有其他元素（或者有链表的形式存在的多个元素）
        首先比较该位置上的元素与自己的hash值，
        如果不相同、则a添加成功
        相同，调用自己的equals方法，一个一个和链表huo位置元素比 返回true 则不会成功 false
        添加成功的时候，数据以链表的形式存储、
        jdk7.0 新添加成功的元素插入数组 指向原来的元素
        8.0     头插法
        向set的类添加的类要重新写 hashcode 和  equals  这两个方法要尽可能保持一致性  相等的内容
        哈希值也要一样
    * */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("jian");
        set.add(new StringBuffer("ge"));
        set.add(new StringBuffer("ge"));
        System.out.println(set.toString());

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(Arrays.toString(set.toArray()));
    }
    @Test
    public void test2(){
        List list = new LinkedList();
        list.add(123);
        list.add(1,456);
        list.add(789);
        list.add("jian");
        list.add(new StringBuffer("ge"));
        list.add(new StringBuffer("didi"));
//        list.addAll(list.size(),list);
        LinkedList<Object> objects = new LinkedList<>();
        objects.add(123);
        objects.add(456);
        objects.add(new StringBuffer("ge"));
        objects.add("jian");
        list.removeAll(objects);
        System.out.println(list.toString());
        list.toArray();
        new HashSet<>().toArray();
    }
    @Test
    public void test3(){
        //对于linkedHashSet 它也是无序的 底层用数组存储 只不过存数据的时候是存的链表的形式
        //存着上一个 下一个  记录新添加的顺序 1  频繁的遍历比较高效
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("jian");
        set.add(new StringBuffer("ge"));
        System.out.println(set.toString());//[123, 456, jian, ge]
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
