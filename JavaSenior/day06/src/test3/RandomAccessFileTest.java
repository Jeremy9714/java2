package test3;

import org.junit.Test;

import java.io.*;

/**
 * 随机存取文件流
 *
 * @author Chenyang
 * @create 2021-01-12-16:37
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;

        try {
            raf1 = new RandomAccessFile(new File("MHRise.jpg"), "r");
            raf2 = new RandomAccessFile(new File("MHRise1.jpg"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
            System.out.println("复制完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    文本的覆盖
     */
    @Test
    public void test2() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile(new File("hello1.txt"), "rw");
            //作为输出流时，若输出到的文件已存在，则会对原有文件的内容进行覆盖(默认从头覆盖)
            //long seek(long pos): 将文件记录指针定位到pos位置
            raf1.seek(3);
            raf1.write("xyz".getBytes());
            //long getFilePointer(): 获取文件记录指针的当前位置
            System.out.println(raf1.getFilePointer());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    插入内容方式一
     */
    @Test
    public void test3() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello1.txt", "rw");
            raf1.seek(3);
            StringBuilder sb = new StringBuilder((int) new File("hello1.txt").length());
            byte[] bytes = new byte[20];
            int len;
            while ((len = raf1.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
            }
            raf1.seek(3);
            raf1.write("QQQ".getBytes());
            raf1.write(sb.toString().getBytes());
            System.out.println("插入完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    插入内容方式二
     */
    @Test
    public void test4() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        RandomAccessFile raf = new RandomAccessFile("hello1.txt", "rw");
        raf.seek(3);
        byte[] bytes = new byte[20];
        int len;
        while ((len = raf.read(bytes)) != -1) {
            baos.write(bytes, 0, len);
        }
        raf.seek(3);
        raf.write("QQQ".getBytes());
        raf.write(baos.toByteArray());
        System.out.println("插入完成");
        raf.close();
        baos.close();
    }
}
