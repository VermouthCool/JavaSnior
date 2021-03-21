package com.jian.java;

/**
 * @author Jiange
 * @create 2021-03-08-16:40
 */

class mYThread implements Runnable{

    private int a = 100;

    @Override
    public void run() {
        while(true){
//            synchronized(mYThread.class){
              synchronized(this){
                if(a>0){
                    System.out.println(Thread.currentThread().getName() + ":" + a);
                    a--;
                }else{
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        mYThread c = new mYThread();
        new Thread(c).start();
        new Thread(c).start();
    }
}
