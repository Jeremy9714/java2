package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 标准输入输出流练习
 * 从键盘获取所有基本类型的值
 *
 * @author Chenyang
 * @create 2021-02-07-11:49
 */
public class MyInput {
    public static void main(String[] args) {
        System.out.println("请输入");
        var a = readDouble();
        System.out.println(a);
    }

    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        try {
            string = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static int readInteger() {
        return Integer.parseInt(readString());
    }

    public static short readShort() {
        return Short.parseShort(readString());
    }

    public static long readLong() {
        return Long.parseLong(readString());
    }

    public static double readFloat() {
        return Float.parseFloat(readString());
    }

    public static double readDouble() {
        return Double.parseDouble(readString());
    }

}
