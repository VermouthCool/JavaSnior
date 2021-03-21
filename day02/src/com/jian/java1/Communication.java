package com.jian.java1;

/**
 * @author Jiange
 * @create 2021-03-09-12:23
 *  线程通信的例子  使用两个线程 交替打印1-100
 *  wait() :当前线程变成阻塞状态、释放同步监视器
 *  notify() ：唤醒一个被wait的线程 、多个时 唤醒优先级高的、优先级相同时 随机唤醒
 *  notifyAll()：唤醒所有被wait的线程
 *  这三种方法只能用在 同步代码块和同步方法内，这三个方法的调用者必须是 同步代码的监视器
 *  这三个方法是定义在Object里的
 *      面试题：
 *      sleep和wait的异同：
 *      相同点：都会使线程变成阻塞状态
 *      不同点：1.两个方法的声明的位置不一样：Thread里有sleep Object里有wait
 *              2.sleep可以在任意的地方调用、wait只能在同步代码内
 *              3.sleep不会释放监视器、wait会
 */

class Number implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true){
            synchronized (Number.class) {
                Number.class.notify();
                if(number<=100){
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        Number.class.wait();//wait会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else break;
            }
        }
    }
}

public class Communication {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(number).start();
        new Thread(number).start();
    }
}
