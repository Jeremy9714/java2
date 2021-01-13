package test2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * URL实现服务端数据下载
 * @author Chenyang
 * @create 2021-01-13-13:35
 */
public class URLTest1 {
    public static void main(String[] args) {
        URL url = null;
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            url = new URL("www.baidu.com");
            urlConnection = (HttpURLConnection) url.openConnection();
            //获取连接
            urlConnection.connect();
            //获取输入流
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("taget.txt");
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭资源
            if(urlConnection!=null){
                urlConnection.disconnect();
            }
        }
    }
}
