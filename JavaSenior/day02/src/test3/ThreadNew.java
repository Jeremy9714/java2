package test3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Chenyang
 * @create 2021-01-05-15:20
 */

class NumThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 101; ++i) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

}

public class ThreadNew {
    public static void main(String[] args) {
        NumThread n = new NumThread();
        //将Callable实现类作为FutureTask类的构造器参数
        FutureTask<Integer> futureTask = new FutureTask<>(n);
        //FutureTask可以作为Runnable被线程执行
        Thread thread = new Thread(futureTask);
        //开启线程
        thread.start();

        try {
            //get()方法的返回值即为FutureTask构造器参数Callable实现类重写的call()方法的返回值
            Integer sum = futureTask.get();
            System.out.println("100以内的偶数的总和为: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
