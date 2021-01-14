package test2;

import org.junit.Test;

/**
 * 通过反射创建运行时类的对象
 *
 * @author Chenyang
 * @create 2021-01-14-18:35
 */
public class NewInstanceTest {

    @Test
    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<Person> c1 = Person.class;
        //调用newInstance()方法，创建对应的运行时类的对象
        Person obj = c1.newInstance();
        Class c2 = Class.forName("test2.Person");
        Object obj1 = c2.newInstance();
        System.out.println(obj);
        System.out.println(obj1);
    }
}
