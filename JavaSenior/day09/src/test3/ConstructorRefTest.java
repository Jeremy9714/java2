package test3;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用、数组引用
 *
 * @author Chenyang
 * @create 2021-01-16-18:36
 */
public class ConstructorRefTest {

    /*
    构造器引用
     */
    @Test
    public void test1() {

        //Supplier中的T get()
        Supplier<Employee> sup = () -> new Employee();
        Employee employee = sup.get();
        System.out.println(employee);

        Supplier<Employee> sup1 = Employee::new;
        System.out.println(sup1.get());

        System.out.println();

        //BiFunction中的R apply(T t, U u)
        BiFunction<String, Integer, Employee> bif = (name, age) -> new Employee(name, age);
        System.out.println(bif.apply("Tom", 18));

        BiFunction<String, Integer, Employee> bif1 = Employee::new;
        System.out.println(bif1.apply("Tom", 18));
    }

    /*
    数组引用
     */
    @Test
    public void test2() {

        //Function中的R apply(T t)
        Function<Integer, String[]> fun = num -> new String[num];
        String[] apply = fun.apply(5);
        System.out.println(apply);

        Function<Integer, String[]> fun1 = String[]::new;
        System.out.println(Arrays.toString(fun1.apply(5)));

    }
}
