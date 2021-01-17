package test4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Stream API的中止操作
 *
 * @author Chenyang
 * @create 2021-01-17-11:08
 */
public class StreamAPITest2 {

    //匹配和查找
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();

        //allMatch(Predicate p): 检查是否匹配所有元素
        boolean allMatch = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        //anyMatch(Predicate p): 检查是否至少匹配一个元素
        boolean anyMatch = list.stream().anyMatch(e -> e.getAge() > 10);
        System.out.println(anyMatch);

        //noneMatch(Predicate p): 检查是否没有匹配的元素
        boolean noneMatch = list.stream().noneMatch(e -> e.getName().startsWith("J"));
        System.out.println(noneMatch);

        //findFirst(): 返回第一个元素
        Optional<Employee> first = list.stream().findFirst();
        System.out.println(first);

        //findAny(): 返回当前流中的任意一个元素
        Optional<Employee> any = list.parallelStream().findAny();
        System.out.println(any);

    }

    @Test
    public void test2() {

        List<Employee> list = EmployeeData.getEmployees();

        //count(): 返回流中元素的总个数
        long count = list.stream().filter(e -> e.getAge() > 30).count();
        System.out.println(count);

        //max(Comparator c): 返回流中最大值
        Optional<Integer> max = list.stream().map(e -> e.getAge()).max(Integer::compare);
        System.out.println(max);

        //min(Comparator c): 返回流中最小值
        Optional<Employee> min = list.stream().min((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(min);

        //forEach(Consumer c): 内部迭代
        list.stream().forEach(System.out::println);

        //使用集合的遍历操作
        list.forEach(System.out::println);
    }

    //归约
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //reduce(T identity, BinaryOperator bo): 可以将流中元素反复结合起来，得到一个值，返回一个T
        Integer result = list.stream().reduce(0, Integer::sum);
        System.out.println(result);

        //reduce(BinaryOperator bo): 可以将流中元素结合起来，得到一个值，返回optional<T>
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Integer> reduce = employees.stream().map(Employee::getAge).reduce(Integer::sum);
        System.out.println(reduce);
    }

    //收集
    @Test
    public void test4() {
        List<Employee> list = EmployeeData.getEmployees();

        //collect(Collector c): 将流转换成其他形式，接收一个Collector接口的实现
        //用于给stream中元素做汇总的方法
        List<Employee> collect = list.stream().filter(e -> e.getAge() > 25).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
