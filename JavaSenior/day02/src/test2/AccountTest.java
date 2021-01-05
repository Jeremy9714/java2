package test2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chenyang
 * @create 2021-01-05-12:58
 */

class Account {
    private double balance;
    private static final ReentrantLock lock = new ReentrantLock(true);

    public Account(double balance) {
        this.balance = balance;
    }

    public void add(double deposit) {
//        synchronized (this) {
        lock.lock();
        try {
            balance += deposit;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "向账户存款" + deposit + "，余额为: " + balance);
        } finally {
            lock.unlock();
        }
//        }
    }
}

class Customer extends Thread {
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; ++i) {
            account.add(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account a = new Account(0);
        Customer c1 = new Customer(a);
        Customer c2 = new Customer(a);
        c1.setName("顾客一");
        c2.setName("顾客二");
        c1.start();
        c2.start();
    }
}
