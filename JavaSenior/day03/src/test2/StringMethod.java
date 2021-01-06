package test2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chenyang
 * @create 2021-01-06-12:42
 */
public class StringMethod {

    @Test
    public void test4(){
        String s1 = "helloworld99";
        String s2 = s1.replace('l','t');
        System.out.println(s2);
        String s3 = s1.replace("ll","yh");
        System.out.println(s3);
        String s4 = s1.replaceAll("\\d+", ",").replaceAll("^,|,$","");
        System.out.println(s4);

        String str = "12345";
        System.out.println(str.matches("\\d+"));

        String str2 = "0531-1234567";
        System.out.println(str2.matches("\\d+-\\d{7}"));

        String str3 = "hello|world|hello|world";
        String[] strs = str3.split("\\|");
        System.out.println(Arrays.toString(strs));
        String[] strs2 = str3.split("\\|",2);
        System.out.println(Arrays.toString(strs2));

    }

    @Test
    public void test3(){
        String s1 = "HelloWorld";
        boolean b1 = s1.endsWith("ld");
        System.out.println(b1);

        boolean b2 = s1.startsWith("he");
        System.out.println(b2);

        boolean b3 = s1.startsWith("ll", 2);//测试从指定索引开始的子字符串是否以指定前缀开始
        System.out.println(b3);

        String s2 = "Wo";
        System.out.println(s1.contains(s2));

        String s3 = "l";
        System.out.println(s1.indexOf(s3));
        System.out.println(s1.indexOf(s3,4));
        System.out.println(s1.lastIndexOf(s3));
        System.out.println(s1.lastIndexOf(s3,7));
        System.out.println(s1.indexOf("ee"));

    }

    @Test
    public void test2(){
        String s1 = "helloworld";
        String s2 = "HELLOWORLD";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        System.out.println(s5.compareTo("abe"));

        String s6 = "abcdefg";
        String s7 = s6.substring(2);
        String s8 = s6.substring(2,5);
        System.out.println(s7);
        System.out.println(s8);

    }

    @Test
    public void test1(){
        String s1 = " HelloWorld ";
        System.out.println(s1.length());
        System.out.println(s1.charAt(1));
        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        //s2 = s1.toUpperCase();
        System.out.println(s1);
        System.out.println(s2);

        String s3 = s1.trim();
        System.out.println(s3);

    }
}
