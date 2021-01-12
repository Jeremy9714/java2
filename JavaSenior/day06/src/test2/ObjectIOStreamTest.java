package test2;

import org.junit.Test;

import java.io.*;

/**
 * 对象流
 * ObjectInputStream
 * ObjectOutputStream
 *
 * @author Chenyang
 * @create 2021-01-12-13:45
 */
public class ObjectIOStreamTest {
    /*
    将内存中的java对象保存到磁盘中或通过网络传输出去
     */
    @Test
    public void test() {
        //序列化过程
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("字符串"));
            oos.flush();//刷新操作
            oos.writeObject(new Person("Tom", 12, new Account(12.10)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化过程
     */
    @Test
    public void test2() {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object o = ois.readObject();
            String str = (String) o;

            Person person = (Person) ois.readObject();
            System.out.println(str);
            System.out.println(person);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
