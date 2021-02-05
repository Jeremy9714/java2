package test3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List接口: 存储有序的可重复的数据
 *
 * @author Chenyang
 * @create 2021-01-08-20:23
 */
public class ListTest {
    @Test
    public void test() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);
        System.out.println(list);

        //void add(int index, Object ele): 在index位置上插入ele元素
        list.add(1, "BB");
        System.out.println(list);

        //boolean addAll(int index, Collection coll): 从index位置上开始将coll中所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(2, list1);
//        list.add(list1);
        System.out.println(list + " " + list.size());

        //Object get(int index): 获取指定index位置的元素
        Object o = list.get(1);
        System.out.println(o);

        //int indexOf(Object obj): 返回obj在集合中首次出现的位置；没有则返回-1
        int tom = list.indexOf(new Person("Tom", 12));
        System.out.println(tom);

        //Object remove(int index): 删除指定index位置的元素，并返回此元素
        Object removeObj = list.remove(2);
        System.out.println(removeObj);
        System.out.println(list);

        //Object set(int index, Object obj): 设置index位置的元素为obj
        Object last = list.set(7, new String("last"));
        System.out.println(last);//返回值为更改前的元素
        System.out.println(list);

        //List subList(int fromIndex, int toIndex): 返回从fromIndex到toIndex位置的子集合
        List subList = list.subList(0, 3);
        System.out.println(subList);
        System.out.println(list);

    }
}
