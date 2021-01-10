package test6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties的使用
 *
 * @author Chenyang
 * @create 2021-01-10-14:02
 */
public class PropertiesTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println(name + ", " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
