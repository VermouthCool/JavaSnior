package com.jian.demo;

/**
 * @author Jiange
 * @create 2021-03-08-20:16
 *
 * 使用同步机制将单例模式里的懒汉式 改写为线程安全的
 */
public class BankTest {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        new Thread(myThread1).start();
        new Thread(myThread1).start();
    }
}
class Bank{
    private String name = "李子建";
    private Bank(){

    }
    private static Bank bank =null ;
    public static Bank getBank(){
//        synchronized (Bank.class){
//            if(bank==null) {
//                bank = new Bank();
//            }
//            return bank;
//        }
        if(bank==null){//效率更高
            synchronized (Bank.class){
                if(bank==null) {
                    bank = new Bank();
                }
            }
        }
        return bank;
    }

    @Override
    public String toString() {
        return  this.name;
    }
}
class MyThread1 implements Runnable{
    @Override
    public void run() {
        System.out.println(Bank.getBank());
    }
}
