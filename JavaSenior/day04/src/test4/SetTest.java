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
     * HashSet的使用
     * 线程不安全，可以存储null值
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
     * LinkedHashSet的使用
     * 可以按照添加顺序遍历
     */
    @Test
    public void test1() {
        Set set = new LinkedHashSet();
        //再添加数据的同时，每个数据还维护了两个引用，记录次数据的前一个/后一个数据
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
