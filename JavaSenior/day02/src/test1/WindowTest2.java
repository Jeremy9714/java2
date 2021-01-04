package test1;

/**
 * 创建三个窗口卖票，，总票数为100张，使用实现Runnable接口的方式
 * 说明: 可以考虑使用this充当同步监视器
 * @author Chenyang
 * @create 2021-01-04-18:46
 */
//class Dog{}

class Window1 implements Runnable {
    private int ticket = 100;
    //同步监视器可以是任何一个类的对象; 多个线程必须要共用同一把锁
    //Dog dog  = new Dog();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {//同步代码块
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，票号为" + ticket);
                    ticket--;
                } else break;
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window1 window = new Window1();
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
