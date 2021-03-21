package jian.day1;

/**
 * @author Jiange
 * @create 2021-03-08-12:52
 *  第二种方式实现买票
 */

class mThread implements Runnable{

    private int i = 100;
    @Override
    public void run() {
        for (; i >0; i--) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        System.out.println("卖完了");
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        mThread mThread = new mThread();
        new Thread(mThread).start();//共有一个对象相当于就是只有100张
        new Thread(mThread).start();
        new Thread(mThread).start();

    }
}
