package jian.day1;

/**
 * @author Jiange
 * @create 2021-03-08-11:28
 * 创建三个窗口买票 总票数为100张 存在线程安全问题
 */

class Window extends Thread{
    private static int piao = 100;
    @Override
    public void run() {
        for(;piao>0;piao--){
            System.out.println(Thread.currentThread().getName() + ":" + piao);
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
