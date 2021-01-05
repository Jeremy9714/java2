package test1;

/**
 * 死锁
 * @author Chenyang
 * @create 2021-01-05-12:04
 */
class A {
    public synchronized void foo(B b) {//同步监视器: A类的对象a
        System.out.println("线程名: " + Thread.currentThread().getName() + "进入了A实例的foo方法");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程名: " + Thread.currentThread().getName() + "企图调用B实例的last方法");
        b.last();
    }

    public synchronized void last() {//同步监视器: A类的对象a
        System.out.println("进入了A类的last方法内部");
    }
}

class B {
    public synchronized void foo(A a) {//同步监视器: B类的对象b
        System.out.println("线程名: " + Thread.currentThread().getName() + "进入了B实例的foo方法");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程名: " + Thread.currentThread().getName() + "企图调用A实例的last方法");
        a.last();
    }

    public synchronized void last() {//同步监视器: B类的对象b
        System.out.println("进入了B类的last方法内部");
    }
}

public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();

    public void init() {
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入了主线程之后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("子线程");
        b.foo(a);
        System.out.println("进入了子线程之后");
    }

    public static void main(String[] args) {
        DeadLock d = new DeadLock();
        new Thread(d).start();
        d.init();
    }
}