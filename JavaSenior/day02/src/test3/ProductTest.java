package test3;

/**
 * 线程通信的应用: 经典例题: 生产者/消费者问题
 *
 * @author Chenyang
 * @create 2021-01-05-13:59
 */
//店员
class Clerk {
    private int numOfProduct = 0;

    //生产产品
    public synchronized void produceProduct() {
        if(numOfProduct<20){
            ++numOfProduct;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + numOfProduct + "个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if(numOfProduct>0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + numOfProduct + "个产品");
            --numOfProduct;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//生产者
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
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}

//消费者
class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费产品");

        while (true) {

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Producer p2 = new Producer(clerk);
        p1.setName("生产者1");
        p2.setName("生产者2");
        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");
        p1.start();
        p2.start();
        c1.start();
    }
}
