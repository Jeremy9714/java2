package test2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
    供给型接口的使用
     */

    @Test
    public void test2() {
        List<Integer> list = getIntegerList(10, () -> (int) (Math.random() * 10));
        list.forEach(System.out::println);
    }

    public List<Integer> getIntegerList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            list.add(sup.get());
        }
        return list;
    }

    /*
    函数型接口的使用
     */
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = intToDouble(list, integer -> (double) integer);
        doubles.forEach(System.out::println);
    }

    public List<Double> intToDouble(List<Integer> list, Function<Integer, Double> func) {
        List<Double> returnList = new ArrayList<>();
        for (Integer integer : list) {
            returnList.add(func.apply(integer));
        }
        return returnList;
    }


    /*
    断定型接口的使用
     */
    @Test
    public void test4() {
        List<String> list = Arrays.asList("南京", "北京", "天津", "东京");
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
