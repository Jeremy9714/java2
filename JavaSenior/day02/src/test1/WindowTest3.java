package test1;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * @author Chenyang
 * @create 2021-01-04-22:24
 */
class Window2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() {//同步监视器this
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票，票号为" + ticket);
            ticket--;
        }else{
            System.exit(0);
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window2 window = new Window2();
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

