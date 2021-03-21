package com.jian.java;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Jiange
 * @create 2021-03-18-19:10
 */
public class MessageClassTest {
    @Test
    public void test1() throws Exception {
        Class personClass = Class.forName("com.jian.java.Person");

        //获取单个属性：
        Field age = personClass.getDeclaredField("age");

        //获取多个属性：
        Field[] fields = personClass.getFields();//只能自己 及其 父类,接口中声明为 public属性
        for(Field field : fields){
            System.out.println(field);
        }

        //获取当前运行时类中所有的属性 不包括父类的属性
        Field[] fields1 = personClass.getDeclaredFields();
        for (Field field:fields1){
            System.out.println(field);
        }
    }
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field field:declaredFields){
            //获取权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers)+"\t");
            //获取数据类型
            Class<?> type = field.getType();
            System.out.print(type.getName()+"\t");
            //获取变量名
            String name = field.getName();
            System.out.println(name);
        }
    }
    @Test
    public void test3(){
        //会进去判断 参数是否是String的实例
        String a = "jian";
        String s = a.toUpperCase();
        String s1 = a.toLowerCase();
        System.out.println(s);//JIAN
        System.out.println(s1);//jian
    }
}
