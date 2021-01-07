package test3;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * LocalDate、LocalTime、LocalDateTime的使用
 * @author Chenyang
 * @create 2021-01-07-12:21
 */
public class JDK8DateTimeTest {

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
