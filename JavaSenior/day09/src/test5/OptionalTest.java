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
        System.out.println();

        //Optional.empty(): 创建一个空的Optional实例
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        System.out.println();

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
        System.out.println();

        Girl g3 = null;
        Optional<Girl> girl3 = Optional.ofNullable(g3);
        if (girl3.isPresent()){
            target = girl3.get();
        }else{
            //T orElseGet(Supplier<? extends T> sup): 如果有值将其返回，否则返回由供给型接口实现提供的对象
            target = girl3.orElseGet(Girl::new);
        }
        System.out.println(target);
    }

    //Optional类应用实例
    public String getGirlName(Boy boy){
        Optional<Boy> ob = Optional.ofNullable(boy);
        Boy newBoy = ob.orElse(new Boy(new Girl("生成的男友的女友")));

        Girl girl = newBoy.getGirl();
        Optional<Girl> og = Optional.ofNullable(girl);
        Girl newGirl = og.orElse(new Girl("生成的女友"));
        return newGirl.getName();
    }

    @Test
    public void test2(){
        //Boy boy = null;
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

}
