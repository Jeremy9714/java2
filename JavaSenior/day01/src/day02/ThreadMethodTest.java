package day02;

/**
 * Thread中的常用方法
 *
 * @author Chenyang
 * @create 2021-01-04-15:50
 */
class HelloThread extends Thread {
    public HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(getName() + ":" + getPriority() + ":" + i);
            }
//            if(i%20==0){
//                Thread.yield();
//            }
        }
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        //线程改名
        Thread.currentThread().setName("主线程");
        //通过构造器给线程命名
        HelloThread thread = new HelloThread("线程一");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

        for (int i = 0; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
//            if (i == 20) {
//                try {
//                    thread.join();//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        System.out.println(thread.isAlive());
    }
}