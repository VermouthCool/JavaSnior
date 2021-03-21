package com.jian.java;

/**
 * @author Jiange
 * @create 2021-03-08-17:05
 *  同步方法解决问题
 */

class Window1 implements Runnable{

    private int piao = 100;

    @Override
    public void run() {
        while (true){
            show();
            if(piao<=0){
                break;
            }
        }
    }
    private synchronized void show(){//同步监视器器就是this
        if(piao>0){
            System.out.println(Thread.currentThread().getName() + ":" + piao);
            piao--;
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        new Thread(window1).start();
        new Thread(window1).start();
    }
}
