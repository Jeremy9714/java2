package test2;

/**
 * 线程的通信(线程交替执行)
 * wait()、notify()、notifyAll()三个方法必须使用在同步代码块或同步方法中
 * @author Chenyang
 * @create 2021-01-05-13:28
 */

class Number implements Runnable {
    private int number = 1;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                //唤醒所有被wait的线程; 该方法的调用者必须是同步监视器
                obj.notifyAll();
                if (number < 101) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;

                    try {
                        //使得调用wait()方法的线程进入阻塞状态; wait()会释放锁; 该方法的调用者必须是同步监视器
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else break;
            }
        }
    }
}

public class Communication {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}
