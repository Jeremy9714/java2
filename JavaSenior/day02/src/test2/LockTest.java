package test2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁解决线程安全问题
 *
 * @author Chenyang
 * @create 2021-01-05-12:25
 */

class Window implements Runnable {
    private int ticket = 100;
    //实例化一个Lock,默认参数为false;参数为true时,线程按照先进先出的顺序同步资源
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {

                //调用lock方法
                lock.lock();

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "售票，票号为:" + ticket);
                    ticket--;
                } else break;
            } finally {
                //调用解锁方法
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
