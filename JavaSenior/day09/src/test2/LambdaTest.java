package test2;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式
 * @author Chenyang
 * @create 2021-01-16-12:40
 */
public class LambdaTest {

    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程一");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();

        System.out.println();

        //Lambda表达式的写法
        Runnable r2 = () -> System.out.println("线程二");
        Thread t2 = new Thread(r2);
        t2.start();
    }

    @Test
    public void test2(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(com1.compare(11, 33));

        System.out.println();

        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println(com2.compare(22, 10));

        System.out.println();

        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        System.out.println(com3.compare(10, 10));

    }
}
