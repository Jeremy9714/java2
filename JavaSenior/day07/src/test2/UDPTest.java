package test2;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP网络编程
 *
 * @author Chenyang
 * @create 2021-01-13-12:40
 */
public class UDPTest {

    //发送端
    @Test
    public void send() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] data = "我是UDP发送端".getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(data, 0, data.length, inet, 9999);
        socket.send(dp);
        socket.close();
    }

    //接收端
    @Test
    public void receive() throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buffer = new byte[100];
        DatagramPacket dp = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(dp);
        System.out.println(new String(dp.getData(),0,dp.getLength()));
        socket.close();
    }
}
