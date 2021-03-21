package com.jian.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jiange
 * @create 2021-03-19-15:13
 * 动态代理：
 *      1.如何根据加载到内存里的被代理类动态的创建代理类对象
 *      2.如何通过代理类的方法调用被代理类的方法
 */

interface Human{
    String getbelief();
    void eat(String food);
}

class Man implements Human{
    @Override
    public String getbelief() {
        return "李子建";
    }

    @Override
    public void eat(String food) {
        System.out.println("建哥要吃饭");
    }
}

class MyInvocationHandler implements InvocationHandler {
    private static Object obj;
    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }
    public MyInvocationHandler(){

    }
    public void bind(Object obj){
        MyInvocationHandler.obj = obj;
    }

    //当我们调用代理类的方法a时就会自动的调用这个方法
    //proxy : 为代理类对象
    //method为：代理类调用的方法
    //
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        Object invoke = method.invoke(MyInvocationHandler.obj, args);
        return invoke;
    }
}

class ProxyFactory<T>{
    //调用此方法返回一个代理类的对象
    public static Object getProxyInstance(Object object){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),myInvocationHandler);
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(new Man());
        proxyInstance.eat("建哥");
        proxyInstance.getbelief();
    }
}
