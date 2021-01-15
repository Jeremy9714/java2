package test2;

import org.junit.Test;

import java.lang.reflect.Field;

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
}
