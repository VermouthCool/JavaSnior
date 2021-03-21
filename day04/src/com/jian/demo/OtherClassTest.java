package com.jian.demo;

import org.junit.Test;

import static java.lang.System.getProperty;


/**
 * @author Jiange
 * @create 2021-03-12-14:00
 * System 都是静态属性和方法
 * Math
 * BigInteger 整型
 * BigDecimal 浮点型
 *
 */
public class OtherClassTest {
    @Test
    public void test1(){
        System.out.println(getProperty("os.name"));
    }
}
