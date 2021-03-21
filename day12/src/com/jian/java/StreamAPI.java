package com.jian.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Jiange
 * @create 2021-03-20-13:00
 * Stream 是做计算的 面向cpu  是不可变的  操作是延迟的  需要结果的时候才执行 只能用一次
 * 通过集合 数组  自己的of
 * allMatch
 * anyMatch
 * nonematch
 * findFirst
 *findAny
 * count
 * max
 * min
 * foreach
 *
 */
public class StreamAPI {
    List<Object> list = new ArrayList<>();

    //返回一个顺序流
    Stream<Object> stream = list.stream();

    //返回一个并行流
    Stream<Object> getStream = list.parallelStream();

    @Test
    public void test1(){
        Stream.iterate(0, t -> t+2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
    @Test
    public void test2(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
        Stream.iterate(0, t -> t+2).limit(10).filter( e -> e.compareTo(10)>0).forEach(System.out::println);

        //skip() 跳过前几个方法  distinct 去重调用hashcode 和 equals
        stream.filter(e ->e.compareTo(1)>0).forEach(System.out::println);
        var jian = "jian";
        List<String> strings = Arrays.asList("jian", "2", "3", "a");
        strings.stream().map(e -> e.toUpperCase()).forEach(System.out::println);

    }
}
