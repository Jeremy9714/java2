package test1;

/**
 * 创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
 * 说明: 可以考虑使用当前类充当同步监视器(类名.class是一个对象)
 * @author Chenyang
 * @create 2021-01-04-18:09
 */
class Window extends Thread {
    private static int ticket = 100;
    //静态对象作为锁
    //private static final Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (obj) {
            synchronized (Window.class){ //Class cla = Window.class; Window.class只会加载一次
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ": 卖票，票号为" + ticket);
                    ticket--;
                } else break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
