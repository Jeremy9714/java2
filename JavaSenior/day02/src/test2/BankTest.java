package test2;

/**
 * 线程同步的懒汉式单例模式
 *
 * @author Chenyang
 * @create 2021-02-03-17:00
 */
public class BankTest {
    public static void main(String[] args) {
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; ++i) {
//                    System.out.println("线程1 " + i);
//                }
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; ++i) {
//                    System.out.println("线程2 " + i);
//                }
//            }
//        }.start();
        Number1 n1 = new Number1();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}

class Bank {
    private Bank() {
    }

    private static Bank bank = null;

    //方式一
//    public synchronized static Bank getInstance(){
    public static Bank getInstance() {
        if (bank == null) {
            synchronized (Bank.class) {
                if (bank == null) {
                    bank = new Bank();
                }
            }
        }
        return bank;
    }
}

class Number1 implements Runnable {
    private int num = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num--;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;
            }
        }
    }
}