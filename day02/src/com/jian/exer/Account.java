package com.jian.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jiange
 * @create 2021-03-08-22:42
 */

class Customer extends Thread{
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.add(1000);
        }
    }
}

public class Account {

//    ReentrantLock reentrantLock = new ReentrantLock(true);

    public void add(double amt){
//        reentrantLock.lock();
//        if(amt>0){
//            balance+=amt;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+ "存钱成功，余额为" + balance);
//        }else {
////            reentrantLock.unlock();
//            throw new NumberFormatException();
//        }

//        reentrantLock.unlock();
        synchronized (Account.class) {
            if(amt>0){
                balance+=amt;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ "存钱成功，余额为" + balance);
            }else {
    //            reentrantLock.unlock();
                throw new NumberFormatException();
            }
        }
    }

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
}
class AccountTest{
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer customer = new Customer(account);
        Customer customer1 = new Customer(account);
        customer.setName("老公 ：");
        customer1.setName("老婆 ： ");
        customer.start();
        customer1.start();
    }
}
