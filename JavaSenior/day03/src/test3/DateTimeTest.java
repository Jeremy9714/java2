package test3;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JDK 8之前的日期时间API
 * SimpleDateFormat、Calender
 * @author Chenyang
 * @create 2021-01-07-10:47
 */
public class DateTimeTest {

    @Test
    public void test4(){
        Date date1 = new Date(1990, 1, 1);
        Date date2 = new Date(2020, 9, 8);
        int days = (int)((date2.getTime()-date1.getTime())/(1000*3600*24))+1;
        System.out.println(days);
        int res = days%5;
        System.out.println(res);

    }

    @Test
    public void test3() throws ParseException {
        //格式化字符串转换为java.sql.Date对象
        String str = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        System.out.println(date);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
    }

    @Test
    public void test2() throws ParseException {
        //按照指定方式格式化和解析: 调用带参的构造器
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String str = sdf.format(date);
        System.out.println(str);

        //解析
        Date date1 = sdf.parse("2020-01-07 11:06:31");
        System.out.println(date1.toString());
    }

    @Test
    public void test() throws ParseException {
        //实例化: 是用默认的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        //格式化: 日期-->字符串
        Date date1 = new Date();
        String format = sdf1.format(date1);
        System.out.println(format);

        //解析: 字符串-->日期
        String format1 = "2021/1/7 上午11:43";
        Date date2 = sdf1.parse(format1);
        System.out.println(date2.toString());

    }

}
