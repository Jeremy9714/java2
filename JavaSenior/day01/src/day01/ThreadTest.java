package day01;

/**
 * @author Chenyang
 * @create 2021-01-04-11:12
 */
public class ThreadTest {
    public static void main(String[] args) {
        //创建Thread类的子类的对象
        MyThread myThread = new MyThread();
        //通过此对象调用start()方法
        myThread.start();//启动当前线程；调用当前线程的run()方法

        //重新创建一个线程的对象
        MyThread myThread1 = new MyThread();
        myThread1.start();

        //如下操作依然在main线程中运行
        for (int i = 0; i < 100; ++i) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

    }
}

//创建一个继承于Thread类的子类
class MyThread extends Thread {
    //重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
