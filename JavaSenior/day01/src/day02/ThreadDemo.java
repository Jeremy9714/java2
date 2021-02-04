package day02;

/**
 * 创建两个分线程，一个遍历100以内的奇数，一个遍历100以内的偶数
 *
 * @author Chenyang
 * @create 2021-01-04-15:35
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //Thread类的匿名子类的匿名对象
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; ++i) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; ++i) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}

