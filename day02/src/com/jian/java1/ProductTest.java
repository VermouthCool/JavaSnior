package com.jian.java1;

/**
 * @author Jiange
 * @create 2021-03-09-13:30
 */

class Clerk{
    private int productNumber = 0;
    public synchronized void add() throws InterruptedException {
        notifyAll();
        if(productNumber<20){
            Thread.sleep(10);
            productNumber++;
            System.out.println(Thread.currentThread().getName()+"开始生产第"+productNumber+"个产品");
        }else {
            wait();
        }
    }

    public synchronized void reduce() throws InterruptedException {
        notifyAll();
        if(productNumber>0){
            System.out.println("消费者"+Thread.currentThread().getName()+"消费了第"+productNumber);
            Thread.sleep(20);
            productNumber--;
        }else {
            wait();
        }
    }
}

class Producor implements Runnable {

    private final Clerk clerk;

    public Producor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者:"+Thread.currentThread().getName()+"开始生产");
        while (true){
            try {
                clerk.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                clerk.reduce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producor producor = new Producor(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(producor).start();
        new Thread(producor).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
