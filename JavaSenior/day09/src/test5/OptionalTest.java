package test5;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类的使用
 *
 * @author Chenyang
 * @create 2021-01-17-12:09
 */
public class OptionalTest {

    @Test
    public void test1() {
        Girl g1 = new Girl();
        //Optional.of(T t): 创建一个Optional实例，参数t不能为null
//        girl = null;
        Optional<Girl> girl = Optional.of(g1);
        System.out.println(girl);
        //Optional.empty(): 创建一个空的Optional实例
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        Girl g2 = new Girl();
        g2 = null;
        //Optional.ofNullable(T t): 创建一个Optional实例，参数t可以为null
        Optional<Girl> girl2 = Optional.ofNullable(g2);
        Girl target;
        //boolean ispresent(): 判断是否包含对象
        if(girl2.isPresent()){
            //T get(): 如果调用对象包含值，返回该值，否则抛异常
            target = girl2.get();
        }else{
            //T orElse(T other): 如果有值将其返回，否则返回指定的other对象
            target = girl2.orElse(new Girl("Lilly"));
        }
        System.out.println(target);
    }
}
