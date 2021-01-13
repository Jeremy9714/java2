package test2;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * @author Chenyang
 * @create 2021-01-13-13:11
 */
public class URLTest {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/hello.txt?username=Jeremy&password=123");

            //getProtocol(): 获取该URL的协议名
            System.out.println(url.getProtocol());
            //getHost(): 获取该URL的主机名
            System.out.println(url.getHost());
            //getPort(): 获取该URL的端口号
            System.out.println(url.getPort());
            //getPath(): 获取该URL的文件路径
            System.out.println(url.getPath());
            //getQuery(): 获取该URL的查询名
            System.out.println(url.getQuery());
            //getFile(): 获取该URL的文件名
            System.out.println(url.getFile());

            System.out.println(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
