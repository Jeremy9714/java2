package test4;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常用类的使用
 * System、Math、BigBiInteger和BigDecimal类的使用
 *
 * @author Chenyang
 * @create 2021-01-07-19:14
 */
public class OtherClassTest {

    @Test
    public void test1() {
        BigInteger bigInteger = new BigInteger("1111111111111111111111111111111111111111111111111111");
        System.out.println(bigInteger);
        BigDecimal bigDecimal = new BigDecimal("1234444444.55555554444444333333333222222222221111111111");
        BigDecimal bigDecimal1 = new BigDecimal("44444.333333666666666666777777777888888888999999");
        System.out.println(bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_HALF_UP));
        System.out.println(bigDecimal.divide(bigDecimal1, 10, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void test() {
        String s1 = System.getProperty("java.version");
        System.out.println("java运行时环境版本 " + s1);

        String s2 = System.getProperty("java.home");
        System.out.println("java的安装目录 " + s2);

        String s3 = System.getProperty("os.name");
        System.out.println("操作系统的名称 " + s3);

        String s4 = System.getProperty("os.version");
        System.out.println("操作系统的版本 " + s4);

        String s5 = System.getProperty("user.name");
        System.out.println("用户账户名 " + s5);

        String s6 = System.getProperty("user.home");
        System.out.println("用户主目录 " + s6);

        String s7 = System.getProperty("user.dir");
        System.out.println("用户的当前工作目录 " + s7);
    }

}
