package test2;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *
 * @author Chenyang
 * @create 2021-01-14-20:27
 */
public class OtherTest {

    /*
    获取运行时类的构造器结构
     */
    @Test
    public void test1(){
        Class clazz = Person.class;
        //后驱当前运行时类中声明为public的构造器
        Constructor[] cons = clazz.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
        System.out.println("***************************");

        //获取当前运行时类中所有定义的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    /*
    获取当前运行时类的带泛型的父类
     */
    @Test
    public void test2(){
        Class clazz = Person.class;
        //获取当前运行时类的父类
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);

        //获取当前运行时类的带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        //获取当前运行时类的带泛型父类的泛型
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());

    }

    /*
    获取当前运行时类实现的接口
     */
    @Test
    public void test3(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class aClass : interfaces1) {
            System.out.println(aClass);
        }
    }

    /*
    获取当前运行时类所在的包
     */
    @Test
    public void test4(){
        Class clazz = Person.class;
        Package p = clazz.getPackage();
        System.out.println(p.getName());
    }

    /*
    获取当前运行时类声明的注解
     */
    @Test
    public void test5(){
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
