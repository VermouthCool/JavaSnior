package com.jian.java;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * @author Jiange
 * @create 2021-03-20-12:01
 * 当要传递给lamnba体的操作，已经有实现的方法 可以使用方法引用
 * 类（对象） ::  方法名
 * 具体的分为三种情况
 *      对象 :: 非静态
 *      类 :: 静态
 *
 *
 *      类 :: 非静态
 *     要求 接口的抽象方法 形参列表 和 返回值类型 得和方法引用的同一个类型
 */
public class MethodTest {
    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("jian");
        PrintStream printStream = System.out;
        Consumer<String> consumer = printStream::println;
    }
}
