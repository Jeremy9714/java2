package test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 面试题
 *
 * @author Chenyang
 * @create 2021-01-06-16:11
 */
public class StringTest3 {
    public static void main(String[] args) {

        //1.去除字符串两端的空格
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个字符串");
        String s = scanner.nextLine().trim();
        System.out.println(s);
        scanner.close();

        //2.将一个字符串中的指定部分进行反转
        String str = "123abc";
        char[] arr = str.toCharArray();
        int startIndex = 1;
        int endIndex = 4;
        for (int x = startIndex, y = endIndex; x < y; x++, y--) {
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        String res = new String(arr);
        System.out.println(res);

        //3.获取一个字符串在另一个字符串出现的次数
        String str1 = "abkkcadkabsdacababssdab";
        String str2 = "ab";
        int count = 0;
        int index = 0;
        while ((index = str1.indexOf(str2, index)) != -1) {
            ++count;
            index += str2.length();
        }
        System.out.println(count);

        //方法二
        String temp = str1.replace(str2, "");
        int result = str1.length() - temp.length();
        System.out.println(result / 2);

        //4.将字符串中数字进行排序
        String str3 = "654321";
        char[] numArr = str3.toCharArray();
        Arrays.sort(numArr);
        String str4 = new String(numArr);
        System.out.println(str4);
    }
}

