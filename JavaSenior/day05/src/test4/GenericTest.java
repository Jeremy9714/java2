package test4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 有限制条件的通配符使用
 * @author Chenyang
 * @create 2021-01-10-22:21
 */
public class GenericTest {

    /*
    有限制条件的通配符的使用
        ? extends Person: 只允许泛型类型为Person及其子类的引用调用(<= Person)
        ? super Person: 只允许泛型类型为Person及其父类的引用调用(>= Person)
     */
    @Test
    public void test1(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据
        Person person = list1.get(0);
        Object object = list2.get(0);

        //写入数据
//        list1.add(new Student());
        list2.add(new Student());
    }
}
