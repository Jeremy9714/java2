package test2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Annotation的使用
 *
 * @author Chenyang
 * @create 2021-01-08-10:09
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person person = new Student();
        person.walk();

        @SuppressWarnings("unused")
        int num = 10;

        @SuppressWarnings({"unused","rawtypes"})
        ArrayList arrayList = new ArrayList();

    }

}

//@MyAnnotation(value="hello")
@MyAnnotation() //定义的注解含有配置参数时，使用时必须指定参数值
abstract class Person {
    public Person() {
    }

    abstract void walk();
}

class Student extends Person {

    @Override
    void walk() {
        @Deprecated
        Date date = new Date(2020, 10, 11);
        System.out.println(date);
    }
}