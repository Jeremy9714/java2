package day01;

/**
 * @author Chenyang
 * @create 2021-01-04-11:12
 */
public class ThreadTest {
    public static void main(String[] args) {
        //创建Thread类的子类的对象
        MyThread myThread = new MyThread();
        //通过此对象调用start()方法
        myThread.start();

    }
}

//创建一个继承于Thread类的子类
class MyThread extends Thread {
    //重写run()方法
    @Override
    public void run() {
        for(int i=0;i<100;++i){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}
