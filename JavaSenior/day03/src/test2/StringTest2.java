package test2;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Chenyang
 * @create 2021-01-06-15:22
 */
public class StringTest2 {

    /**
     * String与字节数组的相互转换
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test2() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        //编码
        byte[] bytes = str1.getBytes();//是用默认的字符集进行转换
        System.out.println(Arrays.toString(bytes));
        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));

        //解码
        String str2 = new String(bytes);//是用默认的字符集进行解码
        System.out.println(str2);
        String str3 = new String(gbks, "gbk");//解码时使用的字符及必须和编码时使用的字符集一致
        System.out.println(str3);

    }

    @Test
    public void test1() {
        String s1 = "abc123";
        char[] arr = s1.toCharArray();
        System.out.println(Arrays.toString(arr));

        char[] arr2 = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr2);
        System.out.println(str2);
    }

    @Test
    public void test() {
        String str = "123";
        int n1 = Integer.parseInt(str);
        System.out.println(n1);
        int n2 = 345;
        String str2 = String.valueOf(n2);
        System.out.println(str2);
        String str3 = n1 + "";
        System.out.println(str == str3);//只要存在变量，结果就在堆中

    }
}
