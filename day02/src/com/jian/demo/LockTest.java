package com.jian.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jiange
 * @create 2021-03-08-21:30
 * 解决线程安全问题的方式三：Lock锁 JDK5.0新增
 *  1.先创建ReentrantLock的实例
 *  2.调用lock方法
 *  3.调用unLock方法结束 不然线程不会结束
 *  synchronized和Lock的异同
 *      1.都可以解决线程安全问题
 *      2.Lock是手动的上锁和解锁，synchronized是执行完代码后、自动的释放同步监视器
 *      3.
 *
 */

class MyThread2 implements Runnable{
    {
        System.out.println("MyThread2.instance initializer");
    }
    private int piao = 100;
    ReentrantLock reentrantLock = new ReentrantLock(true);//三个线程轮流按一定的顺序执行
    @Override
    public void run() {
        while (true){
            reentrantLock.lock();
            if(piao>0){
                System.out.println(Thread.currentThread().getName() + ":" + piao);
                piao--;
            }else {
                reentrantLock.unlock();
                break;
            }
            reentrantLock.unlock();
        }
    }
}

public class LockTest{
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread t1 = new Thread(myThread2);
        Thread t2 = new Thread(myThread2);
        Thread t3 = new Thread(myThread2);
        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");
        t1.start();
        t2.start();
        t3.start();
    }
}
