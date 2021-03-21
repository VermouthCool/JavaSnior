package com.jian.java9;

import com.jian.java9test.Person;

import java.net.URL;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author Jiange
 * @create 2021-03-20-15:27
 * 接口的静态方法只能由接口自己调用
 * asList返会的集合也是只读集合 List.of也是 set.of Map.of(key,value)
 * transferto
 */
public class Jian implements inter {
    public static void main(String[] args) {
//        Person person = new Person("jian",18);
//        List list = List.of("jian",4,"jian");
//        Stream stream = Stream.of("jian",1);
//        Stream.iterate(0,t -> t+2).filter(e->e>10).limit(10).forEach(System.out::println);
        Map<String,Object> map = new HashMap();
        map.put("name","jiange");
        map.put("age",18);
        Stream<Map<String, Object>> map1 = Stream.of(map);
        map1.flatMap(x -> Stream.of(x)).forEach(System.out::println);
    }
}
interface inter{
    //允许定义私有方法
    @Deprecated
    static void ge(){
        var name = "jian";

    }
    private static void jian(){

    }
    default void lai(){

    }
}