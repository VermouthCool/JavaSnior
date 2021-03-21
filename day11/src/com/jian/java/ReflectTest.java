package com.jian.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Jiange
 * @create 2021-03-18-13:14
 *
 *  通过直接 new或者反射都可以调用类的结构  建议还是用new的方式  当编译的时候不知道用哪个类的对象 就用反射
 *  反射和封装性不矛盾、
 *      Class 理解：
 *          1.类的加载过程：程序在经过 javac 后会生成一个或者多个字节码文件，接着我们使用 然后再用java.exe
 *              运行字节码文件，相当于将某个字节码文件加载到内存 此过程叫做类的加载。加载到内存的类叫做运行时
 *              类，就叫做 Class的一个实例  加载到内存里的类的运行时类 会缓存一段时间
 *              class interface []  void  annotation  enum  int(...)  Class
 *              只要数组的类型和维度一样 运行类就一样
 *          2.类的加载器
 */
public class ReflectTest {
    //反射之前
    @Test
    public void test1(){
        Person person = new Person("李子建", 18);

        person.sleep();
        person.age = 20;

        //无法调用私有的结构
    }

    //反射之后
    @Test
    public void test2() throws Exception {
        //通过反射造对象
        Class<Person> personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class,int.class);
        Person person = (Person) constructor.newInstance("李子建",18);

        System.out.println(person.toString());

        //通过反射调用对象的方法  和  属性
        Field name = personClass.getDeclaredField("name");
        System.out.println(name);//private java.lang.String com.jian.java.Person.name
        name.setAccessible(true);
        name.set(person,"李子建间隔");
        System.out.println(person.toString());//Person{name='李子建间隔', age=18}

        Method method = personClass.getDeclaredMethod("show", String.class);
        method.setAccessible(true);
        Object invoke = method.invoke(person, "jianjian建🗡");
        System.out.println(invoke);//jianjian建🗡
    }
    @Test
    public void test3() throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class,int.class);
        Person person = constructor.newInstance("李子建", 18);

        Field field = personClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person,"jian");

        Method method = personClass.getDeclaredMethod("show", String.class);
        method.setAccessible(true);
        String s = (String) method.invoke(person,"jian");
        System.out.println(s);

        Map<String,? super Person> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
    }
    @Test
    public void test4() throws ClassNotFoundException {
        //获取Class 实例的方式
        //方式一：
        Class<Person> personClass = Person.class;
        System.out.println(personClass);//class com.jian.java.Person

        //方式二：
        Person person = new Person();
        Class personClass1 =  person.getClass();
        System.out.println(personClass1);//class com.jian.java.Person

        //方式三：
        Class personClass2 = Class.forName("com.jian.java.Person");
        System.out.println(personClass2);//class com.jian.java.Person

        //方式四：类的加载器
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        Class aClass = classLoader.loadClass("com.jian.java.Person");
        System.out.println(aClass);
    }
    @Test
    public void test5() throws Exception {
        Properties properties = new Properties();
//        FileInputStream fileInputStream = new FileInputStream("jian.properties");
//        properties.load(fileInputStream);
        ClassLoader classLoader = ReflectTest.class.getClassLoader();

        //使用classloader 默认从src下面
        InputStream resourceAsStream = classLoader.getResourceAsStream("jian.properties");
        properties.load(resourceAsStream);
        String user = properties.getProperty("user");
        String pass = properties.getProperty("pass");

    }
}
