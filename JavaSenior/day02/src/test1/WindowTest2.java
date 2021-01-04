package test1;

/**
 * @author Chenyang
 * @create 2021-01-04-18:46
 */

class Window1 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票，票号为" + ticket);
                ticket--;
            } else break;
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
