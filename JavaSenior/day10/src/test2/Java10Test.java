package test2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java 10新特性
 *
 * @author Chenyang
 * @create 2021-01-17-19:12
 */
public class Java10Test {

    //Java10新特性: 局部变量类型推断
    @Test
    public void test1() {
        //声明变量时，根据所赋的值，推断变量的类型
        var num = 10;
        System.out.println(num);

        var list = Arrays.asList(1, 2, 3, 4, 5);
        for (var v : list) {
            System.out.println(v);
        }
    }


    //局部变量类型推断不适用的情况
    @Test
    public void test2() {

//        //初始值为null
//        var num = 10;
//        var num = null;

//        //Lambda表达式
//        Function<Integer,String> fun = x-> x.toString();
//        var l = x -> x.toString();

//        //方法引用
//        Consumer<String> con = System.out::println;
//        var r = System.out::println;

//        //为数组静态初始化
//        String[] arr = {"a","b"};
//        var arr = {"a","b"};
    }

    @Test
    public void test3() {
        //情况1: 没有初始化的局部变量声明
//        var s = null;

        //情况2: 方法的返回类型
//        public var method(){return 0;}

        //情况3: 方法的参数类型
//        public void method(var num){}

        //情况4: 构造器的参数类型
//        public Java10Test(var num){}

        //情况5: 属性
//        class A{var num;}

        //情况6: catch块
//        try{}catch(var e){}

    }

    //Java10新特性: 集合中新增方法copyOf(),用于创建一个只读的集合
    @Test
    public void test4() {

        var list1 = List.of(1, 2, 3, 4);
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1);

        var list2 = new ArrayList<String>();
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2);

    }
}
