package test1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Chenyang
 * @create 2021-01-13-10:42
 */
public class TCPTest1 {
    @Test
    public void client() {
        System.out.println("客户端启动");
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;

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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
