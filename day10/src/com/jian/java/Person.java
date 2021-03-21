package com.jian.java;

import java.io.Serializable;

/**
 * @author Jiange
 * @create 2021-03-17-13:53
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 49835186613486l;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static void sleep(){
        System.out.println("jiangezuishuai");
    }
}
