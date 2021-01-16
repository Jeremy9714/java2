package test4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream API的中间操作
 *
 * @author Chenyang
 * @create 2021-01-16-21:21
 */
public class StreamAPITest1 {

    //筛选与切片
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();

        //filter(Predicate p): 接收Lambda,从流中排除某些元素
        stream.filter(e -> e.getAge() < 20).forEach(System.out::println);
        System.out.println("************************");

        //limit(n): 截断流，使其元素不超过给定的数量
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println("************************");

        //skip(n): 跳过元素, 返回一个扔掉了前n个元素的流；若流中元素不足n个，则返回一个空流
        employees.stream().skip(15).forEach(System.out::println);
        System.out.println("************************");

        //distinct(): 筛选，通过流所生成的元素的hashcode()和equals()去除重复元素
        employees.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        //map(Function f): 接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println("************************");

        //练习: 获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee::getName).filter(str -> str.length() > 3).forEach(System.out::println);
        System.out.println("************************");

        //练习: 一个元素类型为Stream的Stream
        Stream<Stream<Character>> listStream = list.stream().map(StreamAPITest1::fromStringToStream);
        listStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println("************************");

        //flatMap(Function f): 接受一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有流连接成一个流
        list.stream().flatMap(StreamAPITest1::fromStringToStream).forEach(System.out::println);

    }

    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

}
