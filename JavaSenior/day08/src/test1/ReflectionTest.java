package test1;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * @author Chenyang
 * @create 2021-01-14-11:42
 */
public class ReflectionTest {

    //反射之前，对于自定义类的操作
    @Test
    public void test1() {
        Person p1 = new Person("Tom", 12);
        p1.setAge(18);
        System.out.println(p1);
        p1.show();

        //在类的外部，不可以通过类的对象调用内部的私有结构
    }

    //反射之后，对于自定义类的操作
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //通过反射，创建类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 18);
        Person p = (Person) obj;
        System.out.println(p);

        //通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p);

        //调用方法
        Method show = clazz.getMethod("show");
        show.invoke(p);

        System.out.println("*******************************");

        //通过反射，可以调用类的私有结构
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Sean");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Jack");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //返回值即为被调用的方法的返回值
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);
    }

    //Class的实例的获取方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一: 调用运行时类的属性.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二: 通过运行时类的对象，调用getClass()
        Person p = new Person();
        Class clazz2 = p.getClass();
        System.out.println(clazz2);

        //方式三: 调用Class的静态方法forName(String classPath); classPath是类的全路径(包名.类名)
        Class clazz3 = Class.forName("test1.Person");
        System.out.println(clazz3);

        //方式四: 实用类的加载器ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("test1.Person");
        System.out.println(clazz4);

        //同一个运行时类
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);

    }

    /*
    Class实例可以是哪些结构的说明
     */
    @Test
    public void test4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String.class;
        Class c4 = int.class;
        Class c5 = int[][].class;
        Class c6 = void.class;
        Class c8 = Override.class;
        Class c9 = ElementType.class;
        Class c7 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];

        Class c10 = a.getClass();
        Class c11 = b.getClass();
        //只要元素类型和维度一样，就是同一个Class
        System.out.println(c10==c11);
    }
}
