package test1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP网络编程例题
 * @author Chenyang
 * @create 2021-01-13-11:07
 */
public class TCPTest2 {
    /*
    从客户端发送文件给服务端，服务端保存到本地。并返回"发送成功"给客户端，并关闭相应的连接
     */

    @Test
    public void client() {
        System.out.println("客户端启动");
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            InetAddress inet = InetAddress.getLocalHost();
            socket = new Socket(inet, 9090);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("MHRise.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            //关闭数据的输出
            socket.shutdownOutput();

            //接收来自服务端的数据，并显示到控制台上
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            buffer = new byte[10];
            while((len = is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            String str = baos.toString();
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server() {
        System.out.println("服务端启动");
        ServerSocket ss = null;
        InputStream is = null;
        Socket socket = null;
        FileOutputStream fos = null;
        OutputStream os = null;

        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("MHRise1.jpg"));
            byte[] buffer = new byte[10];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer,0,len);
            }
            System.out.println("图片传输完成");

            //服务器端给与客户端反馈
            os = socket.getOutputStream();
            os.write("发送成功".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
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
}
