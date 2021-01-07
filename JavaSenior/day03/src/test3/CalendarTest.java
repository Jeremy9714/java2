package test3;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar类
 *
 * @author Chenyang
 * @create 2021-01-07-11:32
 */
public class CalendarTest {
    @Test
    public void test(){
        //实例化
        //方式一: 创建其子类(GregorianCalendar)的对象
        //方式二: 调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        //System.out.println(instance.getClass());

        //常用方法
        //get()
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_YEAR,2);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        //getTime(): 日历类-->Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime(): Date-->日历类
        Date date1 = new Date();
        System.out.println(date1);
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

    }
}
