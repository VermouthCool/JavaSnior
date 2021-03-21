package com.jian.java;

/**
 * @author Jiange
 * @create 2021-03-08-17:39
 */

class MyThread1 extends Thread{

    private static int anInt = 100;

    @Override
    public void run() {
        while (true){
            show();
            if(!(anInt>0)){
                break;
            }
        }
    }

    private static synchronized void show(){
        if(anInt>0){
            System.out.println(Thread.currentThread().getName() + ":" + anInt);
            anInt--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("线程一");
        myThread1.start();
        MyThread1 myThread2 = new MyThread1();
        myThread2.setName("线程二");
        myThread2.start();
    }
}
