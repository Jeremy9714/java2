package test1;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Java9 新功能
 *
 * @author Chenyang
 * @create 2021-01-17-17:45
 */
public class Java9Test {

    //try语句升级
    public static void main(String[] args) {

        //Java8中资源关闭操作
        //资源自动关闭(要求流对象必须在try()中初始化)
//        try (InputStreamReader isr = new InputStreamReader(System.in)) {
//            char[] cbuf = new char[20];
//            int len;
//            while ((len = isr.read(cbuf)) != -1) {
//                String str = new String(cbuf,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Java9中资源关闭操作
        InputStreamReader reader = new InputStreamReader(System.in);
        try(reader){
            char[] cbuf = new char[20];
            int len;
            while ((len = reader.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
