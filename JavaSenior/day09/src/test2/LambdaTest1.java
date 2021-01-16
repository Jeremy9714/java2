package test2;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式语法的使用
 *
 * @author Chenyang
 * @create 2021-01-16-12:56
 */
public class LambdaTest1 {

    @Test
    public void test1() {
        //语法格式一: 无参、无返回值
        Runnable r = () -> {
            System.out.println("新线程");
        };
        r.run();

        //语法格式二: 有参、无返回值
//        Consumer<String> con = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
        Consumer<String> con = (String s) -> {
            System.out.println(s);
        };
        con.accept("一句话");

        //语法格式三: 数据类型可以省略，类型可以由编译器推断得出
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("另一句话");

        //语法格式四: Lambda表达式若只有一个参数，参数的小括号可以省略
        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("还有一句话");

    }

    @Test
    public void test2() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //多条执行语句
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1, o2);
            }
        };
        //语法格式五: Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
        int compare = com1.compare(10, 12);
        System.out.println(compare);

        //语法格式六: 当Lambda体只有一条语句时，return与大括号若存在，则都可以省略
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(10, 10));
    }
}
