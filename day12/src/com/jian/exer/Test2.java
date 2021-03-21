package com.jian.exer;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//import java.lang.reflect.Proxy;
//
///**
// * @author Jiange
// * @create 2021-03-19-21:30
// */
//
//interface ClothesFactory{
//    void produce();
//    void mai();
//}
//
//class Ling implements ClothesFactory{
//
//    @Override
//    public void produce() {
//
//    }
//
//    @Override
//    public void mai() {
//
//    }
//}
//
//class Proxy1{
//    public static Object getInstance(Object object){
//        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),)
//    }
//}
//
//class ProxyCate implements InvocationHandler {
//    private Object object;
//    public void bind(Object o){
//        this.object = o;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        method.invoke(this.object,args);
//    }
//}
//
//public class Test2 {
//    public static void main(String[] args) {
//        ClothesFactory instance = (ClothesFactory) Proxy1.getInstance(new Ling());
//        instance.mai();
//    }
//}

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Comparator;

public class Test2{
    @Test
    public void test1(){
        Class<Nike> nikeClass = Nike.class;
        Field[] fields = nikeClass.getFields();
        Class<? super Nike> superclass = nikeClass.getSuperclass();
        Type[] genericInterfaces = nikeClass.getGenericInterfaces();
        ParameterizedType parameterizedType = (ParameterizedType) genericInterfaces[0];
        for (Type genericInterface : genericInterfaces) {
            System.out.println(genericInterface.getTypeName());
        }
        Comparator<Integer> comparator = (a,b) -> a.compareTo(b);
    }
}