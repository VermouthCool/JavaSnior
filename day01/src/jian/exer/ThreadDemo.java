package jian.exer;

/**
 * @author Jiange
 * @create 2021-03-07-21:48
 * 练习：一个线程遍历100以内的偶数、另一个线程遍历100以内的奇数
 */
abstract class MyThread extends Thread{
    @Override
    public void run() {
        this.method();
    }
    abstract void method();
}

class first extends MyThread {

    @Override
    void method() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class second extends MyThread{

    @Override
    void method() {
        for (int i = 0; i < 100; i++) {
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new first();
        MyThread myThread1 = new second();

        myThread.start();
        myThread1.start();
        new first(){
            @Override
            void method() {
                System.out.println("简便写法");
            }
        }.start();
    }
}
