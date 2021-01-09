package test4;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet的使用
 *
 * @author Chenyang
 * @create 2021-01-09-15:39
 */
public class TreeSetTest {
    @Test
    public void test() {
        TreeSet set = new TreeSet();

        //不能添加不同类的对象
//        set.add(123);
//        set.add(123);
//        set.add("AA");
//        set.add(new User(12, "tome"));

        //举例一
//        set.add(123);
//        set.add(456);
//        set.add(789);
//        set.add(0);

        set.add(new User(12, "Tom"));
        set.add(new User(18, "Jeremy"));
        set.add(new User(10, "Sean"));
        set.add(new User(15, "Jeck"));
        set.add(new User(13, "Jason"));
        set.add(new User(40, "Jason"));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1() {
        Comparator com = new Comparator() {
            @Override
            //按年龄从小到大排序
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else throw new RuntimeException("类型不匹配");
            }
        };

        //定制排序
        TreeSet set = new TreeSet(com);
        set.add(new User(12, "Tom"));
        set.add(new User(18, "Jeremy"));
        set.add(new User(10, "Sean"));
        set.add(new User(15, "Jeck"));
        set.add(new User(13, "Jason"));
        set.add(new User(13, "Peter"));
        set.add(new User(40, "Jason"));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("******************************");
        //Java8新特性: Lambda表达式
        set.forEach(System.out::println);
    }
}
