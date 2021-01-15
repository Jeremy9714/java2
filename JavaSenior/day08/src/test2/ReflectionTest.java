package test2;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中的指定属性
 * @author Chenyang
 * @create 2021-01-15-11:20
 */
public class ReflectionTest {

    /*
    获取运行时类中的指定属性
     */
    @Test
    public void test1() throws Exception {
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();
        Field id = clazz.getField("id");
        id.set(p,12);
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    /*
    如何操作运行时类的指定属性
     */
    @Test
    public void test2() throws Exception{
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"Jason");
        String pName = (String) name.get(p);
        System.out.println(pName);
    }

    /*
    操作运行时类中的指定方法
     */
    @Test
    public void test3() throws Exception{
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        String nation = (String) show.invoke(p, "China");
        System.out.println(nation);

        //调用静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //调用静态方法时，参数1可以是任何Object
        Object returnVal = showDesc.invoke(null);
        System.out.println(returnVal);//null
    }

    /*
    调用运行时类的构造器
     */
    @Test
    public void test4() throws Exception{
        Class clazz = Person.class;
        Constructor cons = clazz.getDeclaredConstructor(String.class);
        cons.setAccessible(true);
        Person tom = (Person) cons.newInstance("Tom");
        System.out.println(tom);
    }
}
