package test3;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前的日期和时间的API测试
 *
 * @author Chenyang
 * @create 2021-01-06-18:20
 */
public class TimeTest {

    @Test
    public void test2(){
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        Date date2 = new Date(1609957785442L);
        System.out.println(date2.toString());
        System.out.println("......................");

        java.sql.Date sqlDate1 = new java.sql.Date(1609957785442L);
        System.out.println(sqlDate1.toString());
        System.out.println(sqlDate1.getTime());

        //java.util.Date对象转换为java.sql.Date对象
        Date date3 = new Date();
        java.sql.Date sqlDate2 = new java.sql.Date(date3.getTime());
        System.out.println(sqlDate2.toString());


    }

    @Test
    public void test(){
        long time = System.currentTimeMillis();
        System.out.println(time);

    }
}
