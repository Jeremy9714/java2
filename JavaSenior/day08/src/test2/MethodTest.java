package test2;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法
 *
 * @author Chenyang
 * @create 2021-01-14-19:41
 */
public class MethodTest {

    @Test
    public void test1() {
        Class clazz = Person.class;
        //getMethods(): 获取当前运行时类及其所有父类中声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("*******************************");

        //getDeclaredMethods(): 获取当前运行时类中所有定义的方法
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
    }

    /*
    @Xxxx
    权限修饰符、返回值类型、方法名(参数类型1...参数类型N) throws XxxException{}
     */
    @Test
    public void test2() {
        Class clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            //获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a : annos) {
                System.out.print(a + "\t");
            }

            //权限修饰符
            int modifiers = m.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //方法名
            System.out.print(m.getName() + "(");

            //形参列表
            Class[] parameters = m.getParameterTypes();
            if (!(parameters == null || parameters.length == 0)) {
                for (int i = 0; i < parameters.length; ++i) {
                    if (i == parameters.length - 1) {
                        System.out.print(parameters[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameters[i].getName() + " args_" + i + ", ");
                }
            }
            System.out.print(") ");

            //抛出的异常
            Class[] exceptions = m.getExceptionTypes();
            if (!(exceptions == null || exceptions.length == 0)) {
                System.out.print(" throws ");
                for (int i = 0; i < exceptions.length; ++i) {
                    if (i == exceptions.length - 1) {
                        System.out.print(exceptions[i].getName());
                        break;
                    }
                    System.out.print(exceptions[i].getName() + ", ");
                }
            }

            System.out.println();
        }
    }
}
