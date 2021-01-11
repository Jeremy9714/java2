package test1;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二: 转换流(属于字符流)的使用
 * InputStreamReader: 将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter: 将一个字符的输出流转换为字节的输出流
 * 提供字符流与字节流之间的转换
 *
 * @author Chenyang
 * @create 2021-01-11-21:35
 */
public class IOStreamReaderWriterTest {

    @Test
    public void test1() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //InputStreamReader(FileInputStream fis[, String charseName])
            //第二个参数是字符集，默认使用系统默认的字符集
            isr = new InputStreamReader(new FileInputStream("hello.txt"), "UTF-8");
            osw = new OutputStreamWriter(new FileOutputStream("bgk.txt",false),"GBK");

            char[] chars = new char[20];
            int len;
            while ((len = isr.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                osw.write(str, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
