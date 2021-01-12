package test1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络编程
 * @author Chenyang
 * @create 2021-01-12-21:48
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            //实例化InetAddress对象
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            //本机ip对象
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName(): 获取域名
            System.out.println(inet2.getHostName());
            //getHostAddress(): 获取主机的地址
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
