package test1;

import org.junit.Test;

import java.io.*;

/**
 * @author Chenyang
 * @create 2021-01-11-15:51
 */
public class FileReadedWriterTest {
    /**
     * 将文件读入到内存并输出到控制台
     */
    @Test
    public void testFileReader() {
        FileReader fileReader = null;
        try {
            //File file = new File("hello.txt");
            //fileReader = new FileReader(file);
            fileReader = new FileReader("hello.txt");

            //int read(): 返回读入的一个字符，如果达到文件末尾，返回-1
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭操作
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //read重载方法
    @Test
    public void testFileReader1() {
        FileReader reader = null;
        try {
            File file = new File("hello.txt");
            reader = new FileReader(file);

            char[] cbuf = new char[5];
            int len;
            //read(char[] cbuf): 返回每次读入的cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            while ((len = reader.read(cbuf)) != -1) {
//                for (int i=0;i<len;++i){
//                    System.out.print(cbuf[i]);
//                }
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileWriter() {
        FileWriter writer = null;
        try {
            File file = new File("hello1.txt");
            //FileWriter(File file[, boolean append]): 从内存中写出数据到file对应的硬盘文件里
            //若file不存在，则创建该文件
            //若file已存在
            //如果使用FileWriter(file)或FileWriter(file, false)构造器，则对原有文件进行覆盖
            //如果使用FileWriter(file, true)构造器，则在原有文件末尾写入
            writer = new FileWriter(file, true);

            writer.write("Hello World\n");
            writer.write("From IDEA");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReaderWriter() {
        FileReader reader = null;
        FileWriter writer = null;

        try {
            File file1 = new File("hello.txt");
            File file2 = new File("hello1.txt");
            reader = new FileReader(file1);
            writer = new FileWriter(file2, true);
            char[] chars = new char[5];
            int len;
            while ((len = reader.read(chars)) != -1) {
                writer.write(chars, 0, len);
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
