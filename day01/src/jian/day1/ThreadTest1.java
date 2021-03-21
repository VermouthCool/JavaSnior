package jian.day1;

/**
 * @author Jiange
 * @create 2021-03-08-12:12
 * 创建多线程的方式二：实现runnable接口
 *  1.创建实现了runnable接口的类
 *  2.实现类去实现Runnable的run方法
 *  3.创建实现类的对象
 *  4.将此对象、传递到Thread的构造器内 调用start方法
 */

class MThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName() + ":" + i + ":" + Thread.currentThread().getPriority());
            }
        }
    }
}


public class ThreadTest1 {
    public static void main(String[] args) {
        new ThreadTest1(){
         void eat(){
             System.out.println("ThreadTest1.eat");
         };
         public int age = 10;
        }.eat();
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
    }
}
