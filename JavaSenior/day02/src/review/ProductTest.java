package review;

/**
 * 生产者消费者问题
 *
 * @author Chenyang
 * @create 2021-02-04-11:06
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Producer p2 = new Producer(clerk);
        p1.setName("生产者1");
        p2.setName("生产者2");
        Customer c1 = new Customer(clerk);
        Customer c2 = new Customer(clerk);
        c1.setName("顾客1");
        c2.setName("顾客2");
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产产品");
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Clerk {
    private int productNum = 0;

    public synchronized void produceProduct() {
        if (productNum < 20) {
            productNum++;
            System.out.println(Thread.currentThread().getName() + "正在生产第" + productNum + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if (productNum > 0) {
            System.out.println(Thread.currentThread().getName() + "正在消费第" + productNum + "个产品");
            productNum--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer extends Thread {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}