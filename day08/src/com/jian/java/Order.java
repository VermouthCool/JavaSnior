package com.jian.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiange
 * @create 2021-03-15-15:46
 */
public class Order<T> {
    String name;
    int ID;

    //类的内部结构可以使用泛型

    T orderT;
    public Order(){

    }
    public Order(String name,int ID,T orderT){
        this.orderT = orderT;
        this.name = name;
        this.ID = ID;
//        T[] b = new T[5];  不能这样
        T[] a =(T[]) new Object[2];
    }
    public <E> List<E> eat(E[] a){
        ArrayList<E> arrayList = new ArrayList<>();
        for (E e : a) {
            arrayList.add(e);
        }
        return arrayList;
    }
    public static <E> E sleep(){

        return (E) "jian";
    }
}

class Jian<T> extends Order<T>{
    public static  <E> E sleep(){
        return (E) "ge";
    }
}
class Ge extends Order<String>{

}