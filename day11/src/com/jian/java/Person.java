package com.jian.java;

import java.io.Serializable;

/**
 * @author Jiange
 * @create 2021-03-18-13:14
 */
@MyAnnotaion(jian = "jiange")
public class Person implements Serializable,Comparable<String>,Jian {
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name){
        this.name = name;
    }

    public void sleep(){
        System.out.println("jiange");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private static String show(String nation) throws NumberFormatException {
        System.out.println("建哥");
        return nation;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

}
interface Jian{
    String name="jian";
}