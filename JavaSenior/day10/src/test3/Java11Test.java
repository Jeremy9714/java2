package test3;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Java 11新特性
 * @author Chenyang
 * @create 2021-01-17-19:50
 */
public class Java11Test {

    //Java11新特性: 基本变量类型推断的升级
    @Test
    public void test1(){
        //使用var的好处是在使用Lambda表达式时给参数加上注解
        Consumer<String> con = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }
}
