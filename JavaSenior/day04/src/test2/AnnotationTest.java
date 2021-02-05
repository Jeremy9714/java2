package test2;

import org.junit.Test;

import java.lang.annotation.Annotation;
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

    @Test
    public void test(){
        Class testClass = Student.class;
        Annotation[] annotations = testClass.getAnnotations();
        for(Annotation a: annotations){
            System.out.println(a);
        }
    }

}

//@MyAnnotations({@MyAnnotation(),@MyAnnotation(value="world")})//JDK8之前重复注解的方法
@MyAnnotation(value="world")
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

@SuppressWarnings("unused")
//给元注解Target赋值TYPE_PARAMETER，使得被修饰的注解可以用于修饰泛型的类型
class Generic<@MyAnnotation T>{
    //给元注解Target赋值TYPE_USE, 使得被修饰的注解可以用于任何使用类型的地方
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }
}