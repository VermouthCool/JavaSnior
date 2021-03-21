package com.jian.java;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @author Jiange
 * @create 2021-03-19-12:07
 * 获取运行时类的方法结构
 */
public class MethodTest {
    @Test
    public void test1() throws ClassNotFoundException {
        Class<Person> getPersonClass = (Class<Person>) Class.forName("com.jian.java.Person");
        Method[] methods = getPersonClass.getMethods();//获取所有的public的方法 不管是自己的还是父类的
        Annotation[] annotations1 = getPersonClass.getAnnotations();
        for (Annotation annotation : annotations1) {
            System.out.println(annotation);
        }
        for(Method method : methods){
            System.out.print(Modifier.toString(method.getModifiers()) +"\t");
            System.out.print(method.getReturnType().getName()+"\t");
            System.out.println(method.getName());
        }
        System.out.println("-------------------------------------------");
        Method[] declaredMethods = getPersonClass.getDeclaredMethods();//获取自己的方法 无论是什么权限
        for (Method method : declaredMethods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            System.out.print(Modifier.toString(method.getModifiers()) +"\t");
            System.out.print(method.getReturnType().getName()+"\t");
            System.out.print(method.getName());
            System.out.print("(");
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType().getName()+"\t");
                System.out.print(parameter.getName()+"\t");
            }
            System.out.println(")");
            Class[] exceptionTypes = method.getExceptionTypes();
            for (Class exceptionType : exceptionTypes) {
                System.out.println(exceptionType.getName());
            }
        }
    }
}
