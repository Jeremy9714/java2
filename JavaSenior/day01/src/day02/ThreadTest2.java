package day02;

/**
 * 创建多线程的方式二：实现Runnable接口
 *
 * @author Chenyang
 * @create 2021-01-04-18:27
 */

class MThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ";" + i);
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MThread m = new MThread();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }


}
