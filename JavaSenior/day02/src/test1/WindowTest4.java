package test1;

/**
 * 使用同步方法解决使用继承Thread类的方式的线程安全问题
 *
 * @author Chenyang
 * @create 2021-01-04-22:42
 */
class Window3 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show() { //同步监视器: Window3.class
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为" + ticket);
            ticket--;
        } else {
            System.exit(0);
        }
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}

