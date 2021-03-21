package com.jian.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Properties;

/**
 * @author Jiange
 * @create 2021-03-19-12:42
 */
public class OtherTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getConstructors();//获取自己public的构造器 没有父类
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();//获取自己的所有的构造器
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    //获取父类 不包括接口
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    //获取带泛型的父类
    @Test
    public void test3(){
        Class personclass = Person.class;
        Type genericSuperclass = personclass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
//        System.out.println(genericSuperclass.getTypeName());
    }

    //获取接口
    @Test
    public void test4(){
        Class<Person> personClass = Person.class;
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            /*
            interface java.io.Serializable
            interface java.lang.Comparable
            interface com.jian.java.Jian
            * */
            System.out.println(anInterface);
        }
        Type[] genericInterfaces = personClass.getGenericInterfaces();
        ParameterizedType parameterizedType = (ParameterizedType) genericInterfaces[1];
        System.out.println("-----"+parameterizedType.getActualTypeArguments()[0]);
        for (Type genericInterface : genericInterfaces) {
            System.out.println(genericInterface);
            /**
             * interface java.io.Serializable
             * java.lang.Comparable<java.lang.String>
             * interface com.jian.java.Jian
             */
        }
    }
    //获取所在的包
    @Test
    public void test5(){
        System.out.println(Person.class.getPackage());//package com.jian.java
        System.out.println(Person.class.getPackageName());//com.jian.java
    }
    @Test
    public void test6() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        Constructor personConstructor = personClass.getConstructor(String.class,int.class);
        Person person = (Person) personConstructor.newInstance("jian",18);
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);//对于所有的权限不是public 的都得用这个
        name.set(person,"李子建");
        Object o = name.get(person);
        System.out.println(o);
    }
    @Test
    public void test7() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //操作方法
        Class<Person> personClass = Person.class;
        Constructor<Person> personConstructor = personClass.getConstructor(String.class,int.class);
        Person person = personConstructor.newInstance("jian",18);
        Method show = personClass.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Object 渐渐 = show.invoke(Object.class, "渐渐");//如果没有返回值 就是null  这里的person如果调用的是静态方法 则可以写为null或者是任意的类
        System.out.println(渐渐);
    }
    @Test
    public void test() throws IOException {
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
    }
}
