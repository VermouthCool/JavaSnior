package com.jian.demo;

/**
 * @author Jiange
 * @create 2021-03-08-20:56
 *  演示死锁问题
 *
 */


public class ThreadTest {
    public static void main(String[] args) {


        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer1 = new StringBuffer();
        new Thread(){
            @Override
            public void run() {
                synchronized(stringBuffer){
                    stringBuffer.append('a');
                    stringBuffer1.append(1);
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (stringBuffer1){
                        stringBuffer.append('b');
                        stringBuffer1.append(2);
                        System.out.println(stringBuffer);
                        System.out.println(stringBuffer1);
                    }
                }
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(stringBuffer1){
                    stringBuffer.append('c');
                    stringBuffer1.append(3);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (stringBuffer){
                        stringBuffer.append('d');
                        stringBuffer1.append(4);
                        System.out.println(stringBuffer);
                        System.out.println(stringBuffer1);
                    }
                }
            }
        }).start();
    }
}
