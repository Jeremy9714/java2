package test4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream API的使用
 *
 * @author Chenyang
 * @create 2021-01-16-19:14
 */
public class StreamAPITest {

    //创建Stream方式一: 通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        //default Stream<E> stream(): 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelSteram(): 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();

    }

    //创建Stream方式二: 通过数组
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(arr);

        Employee e1 = new Employee("Tom", 18);
        Employee e2 = new Employee("Jeremy", 28);
        Employee[] employees = {e1, e2};
        Stream<Employee> employeeStream = Arrays.stream(employees);
    }

    //创建Stream方式三: 通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    //创建Stream方式四: 创建无限流
    @Test
    public void test4() {
        //迭代
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

}
