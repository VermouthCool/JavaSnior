package jian.day1;

/**
 * @author Jiange
 * @create 2021-03-07-17:38
 * 多线程的创建方式一：继承Thread
 *  1.继承
 *  2.重写Thread的run方法 将此线程的执行的操作声明在这里
 *  3.创建子类对象
 *  4.调用start方法
 */
class MyThread extends Thread{
    public void jian(int[] a){
        a[1] = 50;
    }
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+ i);
            }
        }
    }
}

public class ThreadTest{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        int[] a = new int[5];
        myThread.jian(a);
        System.out.println(a[1]);
        //调用start方法 启动当前线程 调用当前线程的run方法
        /*
        * 不能直接调用 run方法 的方式启动线程
        * */
        //在启动以个线程
        myThread.start();
        //myThread.start(); 不能使已经start的线程继续 start 否则 java.lang.IllegalThreadStateException
        //我们需要重新创建一个对象 来再次开启一个新的线程
        MyThread myThread1 = new MyThread();
        myThread1.start();
        //如下的操作还是在main线程执行的
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName() +i+"*****");
            }
        }
    }
}