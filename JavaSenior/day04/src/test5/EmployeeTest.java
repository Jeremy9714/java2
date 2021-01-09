package test5;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Chenyang
 * @create 2021-01-09-17:57
 */
public class EmployeeTest {
    @Test
    public void test() {
        //按照名字排序
        TreeSet set = new TreeSet();
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        set.forEach(System.out::println);
    }

    @Test
    public void test1() {
        //按照生日(年月日)排序
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate md1 = e1.getBirthday();
                    MyDate md2 = e2.getBirthday();

//                    //比较年
//                    int minusYear = md1.getYear() - md2.getYear();
//                    if (minusYear != 0) {
//                        return minusYear;
//                    }
//                    //比较月
//                    int minusMonth = md1.getMonth() - md2.getMonth();
//                    if (minusMonth != 0) {
//                        return minusMonth;
//                    }
//                    //比较日
//                    return md1.getDay() - md2.getDay();
                    return md1.compareTo(md2);
                } else throw new RuntimeException("类型不匹配");
            }
        };
        TreeSet set = new TreeSet(com);
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        set.forEach(System.out::println);
    }

}
