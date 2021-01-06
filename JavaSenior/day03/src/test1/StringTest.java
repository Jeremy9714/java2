package test1;

import org.junit.Test;

/**
 * @author Chenyang
 * @create 2021-01-05-18:53
 */
public class StringTest {
    @Test
    public void test() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        //返回值得到s8使用的在常量池中已经存在的"javaEEhadoop"
        String s8 = s7.intern();

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false
        System.out.println(s3 == s8);//true

    }
}
