package com.jian.java;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author Jiange
 * @create 2021-03-12-16:31
 * 1.JDK5.0新增 可以在类的加载、编译、运行的时候读取
 * 2.跟踪代码依赖性、实现替代配置文件的功能
 * 3.内置的注解
 *      @Deprecated
 *     @Override
 *     @SuppressWarnings()抑制编译器警告
 * 自定义注解
 *      自定义的注解没有成员、表明是一个表示作用
 *  四种自带的元注解
 *      @Retention():只能修饰一个Annotation，指定这个注释的生命周期包含了一个枚举类 source .class文件里没了  class 保留到.class文件内  默认就是这个 不会jvm虚拟机内会抛弃 runtime 保留在.class文件 jvm也会有
 *      @Target():定义注释可以修饰什么 当不定义时 表示什么都行
 *      @Documented：表示所修饰的注解在javadoc解析时 baoliuxialai
 *      @Inherited：被他修饰的注释将具有继承性
 *      通过反射 获取注解信息
 *  注解新特性：可重复注解、类型注解
 *      @Repeatable()
 */
@MyAnnotation(age = 10)
public class AnnotationTest {
    @Test
    public void test1(){
        Class<Jian> jianClass = Jian.class;
        Annotation[] annotations = jianClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));//[@com.jian.java.MyAnnotation(value={"jian", "ge"}, age=18)]
    }
}
@MyAnnotation( value = {"jian","ge"},age = 18)
class Person{
    private String name;
    private int age;
    @Deprecated
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("Person.eat");
    }
}
class Jian extends Person{
    @SuppressWarnings({"deprecated","unused"})
    public Jian(){

    }
    @Override
    public void eat() {
        System.out.println("Jian.eat");
    }
}
