package test2;

import org.junit.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1.标准输入、输出流
 * 2.打印流
 * 3.数据流
 *
 * @author Chenyang
 * @create 2021-01-12-12:08
 */
public class OtherStreamTest {
    /*
    标注输入、输出流
    System.in: 标准输入流，默认从键盘输入
    System.out: 标准输出流，默认从控制台输出
     */

    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("输入字符串");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("退出程序");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
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
        }

    }

    /*
    打印流
    PrintStream和PrintWriter
     */
    @Test
    public void test1() {
        PrintStream ps = null;

        try {
            //创建打印输出流，设置为自动刷新模式(写入换行符或字节'\n'时都会刷新输出缓冲区)
            ps = new PrintStream(new FileOutputStream("gbk.txt"), true);
            if (ps != null) {
                //重定向
                System.setOut(ps);
            }
            //将ascii码表输出到指定文件中
            for (int i = 0; i < 256; ++i) {
                System.out.println((char) i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /*
    数据流
    DataInputStream和DataOutputStream
     */
    @Test
    public void test2() throws IOException {
        //将内存中的字符串、基本数据类型变量写入到文件中
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("DOS.txt"));
        dos.writeUTF("字符串");
        dos.writeInt(1);
        dos.writeByte(1);
        dos.writeChar('a');
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }

    //将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
    @Test
    public void test3() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("DOS.txt"));

        String str = dis.readUTF();
        int age = dis.readInt();
        byte b = dis.readByte();
        char c = dis.readChar();
        boolean gender = dis.readBoolean();
        System.out.println(str + age + b + c + gender);
    }
}
