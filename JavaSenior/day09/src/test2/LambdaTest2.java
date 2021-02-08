package test2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的四大核心函数式接口
 * <p>
 * 消费型接口 Consumer<T>    void accept(T t)
 * 供给型接口 Supplier<T>    T get()
 * 函数型接口 Function<T,R>  R apply(T t)
 * 断定型接口 Predicate<T>   boolean test(T t)
 *
 * @author Chenyang
 * @create 2021-01-16-15:39
 */
public class LambdaTest2 {

    /*
    消费型接口使用
     */
    @Test
    public void test1() {
        deposit(100, money -> System.out.println(money));

    }

    public void deposit(double money, Consumer<Double> con) {
        con.accept(money);
    }

    /*
    断定型接口的使用
     */
    @Test
    public void test2() {
        List<String> list = Arrays.asList("南京","北京","天津","东京");
//        List<String> filterList = filterString(list, new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.contains("京");
//            }
//        });
//        System.out.println(filterList);
        List<String> strings = filterString(list, str -> str.contains("京"));
        System.out.println(strings);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
