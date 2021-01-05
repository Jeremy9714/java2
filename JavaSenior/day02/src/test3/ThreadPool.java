package test3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式: 线程池
 *
 * @author Chenyang
 * @create 2021-01-05-16:01
 */
class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

//        //设置线程池的属性
//        service1.setCorePoolSize(5);

        //执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service1.execute(new MyThread());//execute()方法适合使用于Runnable
        service1.execute(new MyThread1());//execute()方法适合使用于Runnable

        //关闭连接池
        service1.shutdown();

//        service.submit();//适合使用于Callable

    }
}
