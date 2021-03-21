package com.jian.java1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Jiange
 * @create 2021-03-09-18:50
 *  创建线程的方式四：使用线程池
 *      1.提供指定数量的连接池的对象
 *      2.
 */

class NumberThread implements Runnable{

    private int i;
    @Override
    public void run() {
        for ( i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

public class ThreadTool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)  service;
//        threadPoolExecutor.setCorePoolSize();
        NumberThread numberThread = new NumberThread();
        service.execute(numberThread);
//        service.submit()这个可以使用callable
        service.execute(numberThread);
        service.shutdown();
    }
}
