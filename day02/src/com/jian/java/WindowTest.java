package com.jian.java;

/**
 * @author Jiange
 * @create 2021-03-08-11:28
 * 创建三个窗口买票 总票数为100张 存在线程安全问题
 * 买票过程中、出现了重票和错票----->出现了线程安全问题
 * 问题出现的原因：当某个线程操作车票的过程 其他线程也参与进来错做数据
 * 如何解决：当一个线程在操作票时 其他线程不能参与进来直到这个进程操作完其他线程才可以参与进来、这种情况即使这个线程出现了阻塞、其他线程也不能进去
 *  通过同步机制解决问题：
 *     1.同步代码块：
 *      syncronized(同步监视器){
 *          需要被同步的代码
 *          //操作共享数据的代码就是需要同步的代码
 *          //同步监视器 就是锁 放个任意类的对象的实例  要求多个线程必须要共用一把锁
 *      }
 *     2.同步方法
 *          如果操作共享数据的代码完整的声明在一个方法内 我们就把这个方法设置为同步的
 *          同步方法仍然涉及同步监视器，只是不需要显示声明
 *          非静态的同步方法是this 静态的是当前类本身
 *  同步的方式，解决了线程的安全问题  ----好处
 *  操作同步代码时，只能有一个线程参与、其他线程等待、相当于单线程、效率低
 *
 *
 */

class Window extends Thread{
    private static int piao = 100;

    final static Object object = new Object();

    @Override
    public void run() {
        while (true){
//            synchronized(object){
            synchronized(Window.class){//类也是对象  Window只会加载一次 所以用他也是可以的
                if(piao>0){
                    System.out.println(getName() + ":" + piao);
                    piao--;
                }else {
                    break;
                }
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        new Window().start();
        new Window().start();
        new Window().start();

    }
}
