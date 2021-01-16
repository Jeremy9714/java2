package test3;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用与构造器引用
 *
 * @author Chenyang
 * @create 2021-01-16-17:30
 */

class Person {
    private String name;
    private static int age = 10;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public static int getAge() {
        return age;
    }
}

public class MethodReference {

    /*
    情况一: 对象::非静态方法名
     */
    @Test
    public void test1() {

        //Consumer中的void accept(T t)
        //PrintStream中的println(T t)
        PrintStream ps = System.out;
        Consumer<String> con = ps::println;
        con.accept("ref");

        System.out.println();

        //Supplier中的T get()
        //Person中的T getName()
        Person person = new Person("Tom", 18);
        Supplier<String> sup = () -> person.getName();
        System.out.println(sup.get());

        System.out.println();

        Supplier<String> sup1 = person::getName;
        System.out.println(sup1.get());
    }

    /*
    情况二: 类::静态方法名
     */
    @Test
    public void test2() {

        //Comparator中的int compare(T t1, T t2)
        //Integer中的int compare(T t1, T t2)
        Comparator<Integer> com = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com.compare(10, 10));

        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com1.compare(10, 11));

        System.out.println();

        //Function中的R apply(T t)
        //Math中的Long round(double d)
        Function<Double, Long> fun = d -> Math.round(d);
        Long apply = fun.apply(12.5);
        System.out.println(apply);

        Function<Double, Long> fun1 = Math::round;
        System.out.println(fun1.apply(33.6));
    }

    /*
    情况三: 类::实例方法
     */
    @Test
    public void test3() {

        //Comparator中的int compare(T t1, T t2)
        //String中的t1.compareTo(t2)
        Comparator<String> com = (t1, t2) -> t1.compareTo(t2);
        System.out.println(com.compare("abc", "abe"));

        Comparator<String> com1 = String::compareTo;
        System.out.println(com1.compare("abe", "abc"));

        System.out.println();

        //BiPredicate中的boolean test(T t1, T t2)
        //String中的boolean t1.equals(t2)
        BiPredicate<String, String> bip = (t1, t2) -> t1.equals(t2);
        System.out.println(bip.test("a", "b"));

        BiPredicate<String, String> bip1 = String::equals;
        System.out.println(bip1.test("a", "a"));

        System.out.println();

        //Function中的R apply(T t)
        //Person中的String getName()
        Person person = new Person("Tom", 18);
        Function<Person, String> fun = p -> p.getName();
        System.out.println(fun.apply(person));

        Function<Person, String> fun1 = Person::getName;
        System.out.println(fun1.apply(new Person("Tom", 19)));


    }
}
