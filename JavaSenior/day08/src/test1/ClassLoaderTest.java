package test1;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类的加载器
 *
 * @author Chenyang
 * @create 2021-01-14-17:26
 */
public class ClassLoaderTest {
    @Test
    public void test1() {
        //对于自定义类，使用系统类加载器进行加载
        //系统类加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器的getParent(): 获取扩展类加载器
        //扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //调用扩展类加载器的getParent(): 无法获取引导类加载器
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
    }

    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //读取配置文件的方式一:
//        FileInputStream fis = new FileInputStream("\\src\\jdbc1.properties");
//        pros.load(fis);

        //读取配置文件的方式二: 使用ClassLoader
        //配置文件默认识别为: 当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println(user + " " + password);
    }
}
