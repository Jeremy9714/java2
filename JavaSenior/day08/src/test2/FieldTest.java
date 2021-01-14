package test2;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 * @author Chenyang
 * @create 2021-01-14-19:20
 */
public class FieldTest {

    @Test
    public void test1() {
        Class clazz = Person.class;
        //getFields(): 获取当前运行时类及其父类中声明为public权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("*************************************");
        //getDeclaredFields(): 获取当前运行时类中所有定义的属性(不包含父类)
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }
    }

    //权限修饰符、数据类型、变量名
    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
//            System.out.println(f);
            //权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //变量名
            String name = f.getName();
            System.out.println(name);

        }
    }
}
