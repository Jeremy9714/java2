package test4;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Set接口的使用
 *
 * @author Chenyang
 * @create 2021-01-09-12:16
 */
public class SetTest {
    /**
     * HashSet
     */
    @Test
    public void test() {
        Set set = new HashSet();
        set.add(123);//不可重复性
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User(12, "Tom"));
        set.add(new User(12, "Tom"));
        set.add(129);

        Iterator iterator = set.iterator();
        //无序性: 存储的数据在底层并非按照数组索引的顺序进行添加，而是按照数据的哈希值决定的
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * LinkedHashSet
     */
    @Test
    public void test1() {
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User(12, "Tom"));
        set.add(new User(12, "Tom"));
        set.add(129);

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
