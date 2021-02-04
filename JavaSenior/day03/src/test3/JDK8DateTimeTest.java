package test3;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * JDK 8的新日期时间API
 * @author Chenyang
 * @create 2021-01-07-12:21
 */
public class JDK8DateTimeTest {

    /**
     * DateTimeFormatter类: 格式化或解析时间、日期
     * 类似SimepleDateFormat
     */
    @Test
    public void test2(){
        //实例化: 三种方式

        //方式一: 预定义的标准格式(ISO_LOCAL_DATE_TIME、ISO_LOCAL_DATE、ISO_LOCAL_TIME)
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);
        //格式化
        String formatStr = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(formatStr);
        //解析
        TemporalAccessor parseStr = formatter.parse("2021-01-07T14:55:38.799885");
        System.out.println(parseStr);
        System.out.println("**************************************************");

        //方式二: 本地化相关的格式(ofLocalizedDateTime(FormatStyle)、ofLocalizedDate(FormatStyle))
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String formatStr1 = formatter1.format(localDateTime);
        System.out.println(formatStr1);
        //解析
        TemporalAccessor parseStr1 = formatter1.parse("2021/1/7 下午3:34");
        System.out.println(parseStr1);
        System.out.println("**************************************************");

        DateTimeFormatter formatter1_2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        LocalDate localDate = LocalDate.now(ZoneOffset.UTC);
        //格式化
        String formatStr1_2 = formatter1_2.format(localDate);
        System.out.println(formatStr1_2);
        //解析
        TemporalAccessor parseStr1_2 = formatter1_2.parse("2021年3月26日星期五");
        System.out.println(parseStr1_2);
        System.out.println("**************************************************");

//        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
//        String formatStr2 = formatter2.format(LocalTime.now());
//        System.out.println(formatStr2);

        //方式三: 自定义的格式(ofPattern("yyyy-MM-dd hh:mm:ss E"))
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String formatStr2 = formatter2.format(LocalDateTime.now());
        System.out.println(formatStr2);
        //解析
        TemporalAccessor parseStr2 = formatter2.parse("2021-01-07 03:36:24");
        System.out.println(parseStr2);

    }

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
