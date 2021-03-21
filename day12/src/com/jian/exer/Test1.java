package com.jian.exer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jiange
 * @create 2021-03-19-16:18
 */

interface MyClothFactory{
    void produce();
    void mai();
}

class Nike implements MyClothFactory{
    @Override
    public void produce() {
        System.out.println("Nike生产产品");
    }

    @Override
    public void mai() {
        System.out.println("NIke销售产品");
    }
}

class ProxyFactory{
    public static Object getInstance(Object object){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),myInvocationHandler);
    }
}

class MyInvocationHandler<T> implements InvocationHandler {

    private T object;
    public void bind(T obj){
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(object, args);
        return invoke;
    }
}

public class Test1 {
    public static void main(String[] args) {
        MyClothFactory instance = (MyClothFactory) ProxyFactory.getInstance(new Nike());
        instance.mai();
        instance.produce();
    }
}