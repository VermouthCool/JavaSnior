package com.jian.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiange
 * @create 2021-03-19-17:25
 * lambda表达式  只能用于接口 此接口作为函数式接口的实例
 * 如果此接口只声明了一个抽象方法 则成为函数式接口  @FunctionalInterface
 *      ->左边：形参列表
 *      ->右边：方法体
 *      使用：
 *          1.无参，无返回值
 *          2.有一个参数 无返回值
 *          3.类型推断
 *          4.当只有一个参数时 可以省略括号
 *          5.只有一条执行语句时 可以省略括号 return也可以省略
 *          6.
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("建哥");
            }
        };
        new Thread(runnable).start();
        Runnable runnable1 = () -> System.out.println("jian");
        new Thread(runnable1).start();
        Comparator<Integer> comparator = ( a, b) -> a.compareTo(b);

    }
}
@FunctionalInterface
interface Jian{
    public abstract void sleep();
}