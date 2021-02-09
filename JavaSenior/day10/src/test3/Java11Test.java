package test3;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Java 11新特性
 *
 * @author Chenyang
 * @create 2021-01-17-19:50
 */
public class Java11Test {

    //String类中新增的方法
    @Test
    public void test() {
        String s1 = "  ";
        String s2 = "\n";

        //boolean isBlank(): 判断字符串是否为空白(空格、制表符、换行符)
        System.out.println(s1.isBlank());
        System.out.println(s2.isBlank());

        //String strip(): 去除字符串的首尾空白(空格、制表符、换行符)
        String s3 = "  ss s  \t";
        System.out.println(s3.strip());

        //String stripTrailing(): 去除字符串的尾部空白(空格、制表符、换行符)
        String s4 = "  ss\t";
        System.out.println(s4.stripTrailing());

        //String stripLeading(): 去除字符串的首部空白(空格、制表符、换行符)
        String s5 = "\n\tss  ";
        System.out.println(s5.stripLeading());

        //String repeat(int count): 将调用该方法的字符串复制count遍，并反返回一个新的字符串
        String s6 = " ss";
        System.out.println(s6.repeat(5));

        //lines().count(): 行数统计(包括\n，但不包括末尾的\n)
        String s7 = "\n\ts s\t\n";
        System.out.println(s7.lines().count());
    }

    //Optional类中新增的方法
    @Test
    public void test1(){
        Object obj = new Object();
        var oob = Optional.ofNullable(obj);
        var empty = Optional.empty();

        //boolean isEmpty(): 判断value是否为空
        System.out.println(oob.isEmpty());
        System.out.println(empty.isEmpty());

        //T orElseThrow(): 若value非空，则返回该value;若value为空，则抛出NoSuchElementException异常
        //oob = Optional.ofNullable(null);
        var value = oob.orElseThrow();

        //Stream<T> Stream(): 若value非空，则返回仅包含当前value的Stream; 否则，返回一个空的Stream
        Stream<Object> stream = empty.stream();
        System.out.println(stream.count());

        //Optional<T> or(Supplier<T> sup): 若value非空，则返回当前Optional对象;
        //否则，返回形参封装的Optional对象
        Optional<String> hello = Optional.of("hello");
        //empty = Optional.of("world");
        Optional<Object> or = empty.or(() -> hello);
        System.out.println(or);

    }

    //基本变量类型推断的升级
    @Test
    public void test2() {
        //使用var的好处是在使用Lambda表达式时给参数加上注解
        Consumer<String> con = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }
}
