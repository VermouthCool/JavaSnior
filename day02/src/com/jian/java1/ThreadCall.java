package com.jian.java1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Jiange
 * @create 2021-03-09-17:02
 *  创建新的线程的方式三：JDK5.0新增
 *      第一步：创建Callable的实现类
 *      2：重写call方法
 *      3.创建callable实现类的对象
 *      4.将此实现类的对象作为参数传入FutureTask内构造期内创建对象
 *      5.创建Thread的实例 将FutureTask的实例传入到其中作为参数、调用start
 *      6.获取call的返回值
 *   call方法是可以有返回值的、可以抛出异常、支持泛型
 */

class NumThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println("i = " + i);
                sum+=i;
            }
        }
        return sum;
    }
}

public class ThreadCall {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        //FutureTask还可以确保即使调用了多次run方法，它都只会执行一次Runnable或者Callable任务，或者通过cancel取消FutureTask的执行等。
        new Thread(futureTask).start();
        System.out.println("ThreadCall.main");
        try {
            //get方法的返回值就是FutureTask的构造器参数Callable的实现类对象的call的返回值
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
