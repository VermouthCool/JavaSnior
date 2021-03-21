package com.jian.java;

import com.jian.exer.DAO;
import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;


/**
 * @author Jiange
 * @create 2021-03-15-15:06
 * 泛型 5 新增
 * 在生命的时候 可以使用 ，实例化时可以填上  泛型的值 必须是类
 * 如果实例化时没有指明泛型的类型 则 默认就按照Object类型处理、但不等价于Object
 *      如果用了泛型 就一直用  不用  就一直不用
 * 泛型不同的不能 互相赋值 无论是否 是 继承关系
 * 类 a 是 b的父类 G<a> 和 G<b>是平级的 不能互相赋值
 * a<G> 是 b<G> 的父类
 * 静态方法、属性 不能 使用 泛型
 * 异常类 不能是泛型  catch里也不能用
 * T[] a =(T[]) new Object[2];
 *      泛型方法：在方法内 出现了泛型的结构 泛型的参数 和类的泛型参数不一样
 *      ------------------------------------------------------
 *      public <E> List<E> eat(E[] a){
 *         ArrayList<E> arrayList = new ArrayList<>();
 *         for (E e : a) {
 *             arrayList.add(e);
 *         }
 *         return arrayList;
 *     }
 *     ---------------------------------------
 *     通配符：？
 *          有限制条件的通配符
// *          <? extends Person> <=
 *          <? super Person>  >= add new PErson new Jian
 *
 */
public class GenericTest {
    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();

        arrayList.add(89);
        arrayList.add(97);
        arrayList.add(56);
        //类型不安全
        arrayList.add("jian");
        //强制类型转换时 可能出现问题
    }
    @Test
    public void test2(){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(12);
        integers.add(59);//编译时会检查
        for (Integer integer : integers) {
            //避免了强制转换的操作
        }

    }
    @Test
    public void test3(){
        //必须两个都写
        Map<String,Object> map = new HashMap();
        Map<Integer,Object> map1 = new HashMap<>();
        map.put("name","李子建");
        map.put("age",18);
        map.put(null,45);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Order<String> stringOrder = new Order("jian",18,"ge");
        List<Integer> eat = new Order<String>().eat(new Integer[]{1,23,4,5});
        String jian = new Order<String>().sleep();
        Object sleep = new Jian().sleep();
        System.out.println(sleep);
        List<Order> list = new ArrayList<>();
        List<Ge> geList = new ArrayList<>();
    }
    @Test
    public void test4(){
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;
        list = list1;
        list = list2;
        //对于list<?>就不能向内部添加数据了  除了添加null之外
//        list.add();

        //可以获取数据 读取的类型为Object
        System.out.println(list.get(10));

        //
    }
    @Test
    public void test5(){
        List<? extends Order> list = new ArrayList();
        List<? super Order> list1 = null;

        List<Ge> geList = null;
        List<Order> jianList = null;
        List<Object> objectList = null;

        list = geList;
        list = jianList;
//        list = objectList;//报错

//        list1 = geList;//报错
        list1 = jianList;
        list1 = objectList;
        Order order = list.get(10);

        Object object = list1.get(10);
    }
    @Test
    public void test6(){
        DAO objectDAO = new DAO();
        System.out.println(objectDAO.age);

    }
}
