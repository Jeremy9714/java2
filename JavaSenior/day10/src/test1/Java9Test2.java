package test1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Chenyang
 * @create 2021-01-17-18:40
 */
public class Java9Test2 {
    //Stream API的加强
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(23, 43, 54, 67, 78, 32, 54, 65, 76, 41);
        //takeWhile(Predicate p): 返回从开头开始尽可能多的元素
        list.stream().takeWhile(x -> x < 60).forEach(System.out::println);
        System.out.println("******************************");

        //dropWhile(Predicate p): 与takeWhile()相反，返回剩余的元素
        list.stream().dropWhile(x -> x < 60).forEach(System.out::println);
    }

    @Test
    public void test2() {
        //of()参数中的多个元素，可以包含null值
        Stream<Integer> stream = Stream.of(1, 2, 3, null);
        stream.forEach(System.out::println);
        System.out.println();

        //Stream不能只填充一个null值
//        Stream<Object> stream1 = Stream.of(null);
//        stream1.forEach(System.out::println);

        //ofNullable(T...t):
        Stream<Object> stream1 = Stream.ofNullable(null);
        //stream1.forEach(System.out::println);
        System.out.println(stream1.count());
    }

    @Test
    public void test3() {
        //itreate(T t, Predicate p, UnaryOperator u):
        Stream.iterate(1, x -> x < 100, x -> x * 2).forEach(System.out::println);
        System.out.println();

        //Optional类中方法stream()的使用
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<List<Integer>> opt = Optional.ofNullable(list);
        Stream<List<Integer>> stream = opt.stream();
        stream.flatMap(x->x.stream()).forEach(System.out::println);
    }
}
