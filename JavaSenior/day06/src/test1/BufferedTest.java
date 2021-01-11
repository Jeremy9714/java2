package test1;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一: 缓冲流的使用
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * @author Chenyang
 * @create 2021-01-11-20:25
 */
public class BufferedTest {
    /*
    BufferedInputStream和BufferedOutputStream
     */
    @Test
    public void bufferedStreamTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("monster-hunter-rise-switch-hero.jpg");
            File destFile = new File("MHRise.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] bytes = new byte[10];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
//                bos.flush();//刷新缓冲区
            }
            System.out.println("拷贝完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //先关闭外层流，在关闭内层流
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //关闭外层流时，内层流会自动关闭
//            fis.close();
//            fos.close();
        }
    }

    public void copyFileWithBuffer(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("monster-hunter-rise-switch-hero.jpg");
            File destFile = new File("MHRise.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] bytes = new byte[10];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            System.out.println("拷贝完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //先关闭外层流，在关闭内层流
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        copyFileWithBuffer("monster-hunter-rise-switch-hero.jpg", "MHRise.jpg");
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间: " + (endTime - startTime));
        System.out.println();
    }

    /*
    BufferedReader和BufferedWriter
     */
    @Test
    public void testBufferedReaderWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("hello.txt"));
            bw = new BufferedWriter(new FileWriter("hello1.txt"));

            //方式一: 使用char[]数组
//            char[] chars = new char[10];
//            int len;
//            while ((len = br.read(chars)) != -1) {
//                bw.write(chars, 0, len);
//            }

            //方式二: 使用String
            String str;
            //String readLine(): 读取一整行数据(读到"\n"或"\r"结束)
            //读到文件末尾则返回null
            while ((str = br.readLine()) != null) {
                //方式一: 末尾添加换行符
//                bw.write(str + "\n");//字符串中不包含换行符
                //方式二:
                bw.write(str);
                bw.newLine();//提供换行的操作
            }
            System.out.println("复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
