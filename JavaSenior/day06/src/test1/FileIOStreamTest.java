package test1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInputStream和FileOutputStream
 *
 * @author Chenyang
 * @create 2021-01-11-19:52
 */
public class FileIOStreamTest {
    //使用字节流处理文本文件可能出现乱码
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //File file = new File("monster-hunter-rise-switch-hero.jpg");
            File file = new File("hello.txt");
            fis = new FileInputStream(file);
            byte[] bytes = new byte[5];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                String str = new String(bytes, 0, len);
                System.out.print(str);
            }
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

    /*
    实现对图片的复制
    */
    @Test
    public void testFileInputStream1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("monster-hunter-rise-switch-hero.jpg");
            File destFile = new File("MHRise.jpg");
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile, false);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile, false);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            System.out.println("复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test(){
        long startTime = System.currentTimeMillis();
        copyFile("monster-hunter-rise-switch-hero.jpg","MHRise.jpg");
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间: " + (endTime-startTime));
    }

}
