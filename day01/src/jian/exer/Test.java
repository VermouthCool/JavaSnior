package jian.exer;


import java.awt.*;
import java.lang.annotation.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jiange
 * @create 2021-03-07-23:00
 */

//class MyThread1 extends Thread{
//    private static int piao = 100;
////    private static final ReentrantLock lock = new ReentrantLock(true);
//    @Override
//    public void run() {
//        while (true){
//            synchronized (this) {
//                this.notify();
//                if(piao>0){
//                    System.out.println(getName()+":"+piao);
//                    piao--;
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    break;
//                }
//            }
//        }
//    }
////    private static synchronized void lai() throws InterruptedException {
////            MyThread1.class.notify();
////            if(piao>0){
////
////                System.out.println(Thread.currentThread().getName()+":"+piao);
////                piao--;
////                MyThread1.class.wait();
////            }
////
////    }
////    @Override
////    public void run() {
////        while (true){
//////            lock.lock();
//////            if(piao>0){
//////                System.out.println(Thread.currentThread().getName()+":"+piao);
//////                piao--;
//////            }else {
//////                lock.unlock();
//////                break;
//////            }
////            try {
////                lai();
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            if(piao<=0){
////
////                break;
////            }
////        }
////    }
//}

//    class MyThread1 extends Thread{
//        public static int number = 1;
//    @Override
//    public void run() {
//        while (true){
//            synchronized (MyThread1.class) {
//                MyThread1.class.notify();
//                if(number<=100){
//                    System.out.println(Thread.currentThread().getName() + ":" + number);
//                    number++;
//                    try {
//                        MyThread1.class.wait();//wait会释放锁
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }else break;
//            }
//        }
//    }
//}

//class MyThread1 implements Runnable{
//    private int piao = 1;
//    private final ReentrantLock lock = new ReentrantLock(true);
//    @Override
//    public void run() {
//        while(true){
//            lock.lock();
//            if(piao<101){
//                System.out.println(Thread.currentThread().getName()+":"+piao);
//                piao++;
//            }else {
//                lock.unlock();
//                break;
//            }
//            lock.unlock();
//        }
//    }
//}

class MyThread1 implements Callable{
    private int piao = 100;
    @Override
    public Object call() throws Exception {
        while (true){
            synchronized(MyThread1.class){
                MyThread1.class.notifyAll();
                if(piao>0){
                    System.out.println(Thread.currentThread().getName()+":"+piao);
                    piao--;
                    MyThread1.class.wait();
                }else {
                    break;
                }
            }
        }
        return Integer.valueOf(0);
    }
}
public class Test{
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
        System.out.println(executor.submit(thread1));
        System.out.println(executor.submit(thread1));
        System.out.println(executor.submit(thread1));
        executor.shutdown();
//        FutureTask futureTask = new FutureTask(thread1);
//        Thread myThread1 = new Thread(futureTask);
//        Thread myThread2 = new Thread(futureTask);
//
//        myThread1.setName("线程一");
//        myThread2.setName("线程二");
//        myThread2.start();
//        myThread1.start();

//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        String a = "123456";
//        a.indexOf("1");
//        StringBuilder stringBuilder = new StringBuilder("123");

    }
}
//enum Enum{
//    春("春"),
//    夏("夏"),
//    秋("秋"),
//    冬("冬");
//    private String name;
//    Enum(){
//
//    }
//    Enum(String name){
//        this.name = name;
//    }
//}
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Target({ElementType.TYPE_PARAMETER,ElementType.FIELD})
//@Inherited
//
//@interface MyAnnotation{
//    String value();
//}