package test1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 实现TCP的网络编程
 * 例子1: 客户端给服务端发送信息，服务端将数据显示在控制台上
 *
 * @author Chenyang
 * @create 2021-01-12-22:59
 */
public class TCPTest {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            //InetAddress inet = InetAddress.getByName("134.83.246.109");

            //创建Socket对象，指明服务器和端口号
            socket = new Socket(inet, 8899);

            //获取一个输入流
            os = socket.getOutputStream();

            //写出数据
            os.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    //服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //创建服务器端的ServerSocket, 指明自己的端口号
            ss = new ServerSocket(8899);

            //调用accept()方法表示接收来自客户端的Socket
            socket = ss.accept();

            //获取输入流
            is = socket.getInputStream();

            //使用ByteArrayOutputStream流获取信息(不需要输出位置)
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            //调用toString()方法获取流中的数据
            System.out.println(baos.toString());
            //调用getUnetAddress()获取接收的Scoket中的客户端信息
            System.out.println("收到了来自于" + socket.getInetAddress().getHostName() + "发送的文件");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test3() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
    }

}
