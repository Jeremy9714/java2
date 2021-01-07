package test3;

import org.junit.Test;

import java.time.*;

/**
 * JDK 8的新日期时间API
 * @author Chenyang
 * @create 2021-01-07-12:21
 */
public class JDK8DateTimeTest {
    /**
     * Instant的使用
     * 类似于java.util.Date类的使用
     */
    @Test
    public void test1(){
        //now(): 获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli(): 获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli(): 通过给定的毫秒数，获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(milli);
        System.out.println(instant1);
    }

    /**
     * LocalDate、LocalTime、LocalDateTime类的使用
     */
    @Test
    public void test(){
        //now(): 获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println("**************************");

        //of(): 设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 1, 7, 12, 31, 0);
        System.out.println(localDateTime1);
        System.out.println("**************************");

        //getXXX(): 获取相关属性
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //withXXX(): 设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        //体现不可变性
        System.out.println(localDate);
        System.out.println(localDate1);
        LocalDateTime localDateTime2 = localDateTime.withMinute(10);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        System.out.println("**************************");

        //plusXXX()、minusXXX(): 添加对应属性的值、减去对应属性的值
        LocalDateTime localDateTime3 = localDateTime1.plusDays(10);
        LocalDateTime localDateTime4 = localDateTime1.plusYears(1);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);

        LocalDateTime localDateTime5 = localDateTime.minusMinutes(2);
        LocalDateTime localDateTime6 = localDateTime.minusHours(1);
        System.out.println(localDateTime5);
        System.out.println(localDateTime6);
    }
}
