package jian.day1;

/**
 * @author Jiange
 * @create 2021-03-07-22:10
 * 测试Thread的常用方法、
 * 1.start() 启动当前的线程、调用当前线程的run方法
 * 2.run() 重写此方法 表示此线程具体要操作的东西
 * 3.currentThread() 静态方法、返回执行当前代码的线程对象
 * 4.getName() 获取名字
 * 5.setName() 设置当前线程的名字
 * 6.yield() 释放当前CPU的执行权 但是不一定就由其他的线程执行
 * 7.join() 让调用该方法的线程 一直执行到结束 其他线程阻塞、直到调用的线程执行完毕 才结束阻塞状态
 * 8.stop() 强制当前线程结束  已经过时
 * 9.sleep(long millontime) 单位毫秒 睡多久 在这段时间是阻塞状态
 * 10.isAlive() 判断当前进程是否还存在 返回布尔值
 *
 * 线程的优先级
 *  1.MAX_PRIORITY:10
 *  默认是普通的权限 5
 *  2.获取、设置当前线程的优先级
 *      getPriority()
 *      setPriority(int p) 高的优先级不一定就会先执行 只不过 高优先级的高概率被执行 不是 高优先级的执行完低的才执行
 */

class ThreadMy extends Thread {

    public ThreadMy(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            if(i%20==0){
//                yield();
//            }

//                stop();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":" + i+Thread.currentThread().getPriority());
        }
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        ThreadMy threadMy = new ThreadMy("建哥最帅-");//通过构造器的方式起名
//        threadMy.setName("李子建");
        threadMy.setPriority(Thread.MAX_PRIORITY);
        threadMy.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                try {
                    threadMy.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + i+Thread.currentThread().getPriority());
        }
        System.out.println(Thread.currentThread().isAlive());//true 主线程还在
        System.out.println(threadMy.isAlive());//false
    }
}
