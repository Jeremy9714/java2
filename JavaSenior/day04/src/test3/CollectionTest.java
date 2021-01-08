package test3;

import org.junit.Test;

import java.util.*;

/**
 * 集合框架概述
 * Collection接口的常用方法
 *
 * @author Chenyang
 * @create 2021-01-08-16:32
 */
public class CollectionTest {

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Tom", 12));
        coll.add(new String("tom"));
        coll.add(false);

        System.out.println(coll);

        //toArray(): 集合-->数组
        Object[] arr = coll.toArray();
        for (Object obj : arr) {
            System.out.println(obj);
        }

        //数组-->集合
        Object[] objects = {"AA", 123, new Date(), new String("Tom")};
        Collection coll1 = Arrays.asList(objects);
        System.out.println(coll1);
        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(strings);

        //错误示例: 基本数据类型的数组会被看作是一个元素
        List<int[]> list = Arrays.asList(new int[]{1, 2, 3});
        System.out.println(list + " " + list.size());

        List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3});
        System.out.println(integers + " " + integers.size());
    }

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.add(new String("tom"));
        coll.add(new Person("Tom", 12));

        //contains(Object obj): 判断当前集合中是否包含obj
        System.out.println(coll.contains(new String("tom")));
        //判断对象时调用对象的equals()方法
        System.out.println(coll.contains(new Person("Tom", 12)));

        //containsAll(Object obj): 判断形参coll中所有的元素是否都在当前集合中
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));

        //remove(Object obj): 移除集合中的obj对象
        System.out.println(coll.remove(123));
        System.out.println(coll);
        System.out.println(coll.remove(new Date()));

        //removeAll(Collection coll): 从当前集合中移除coll中所有的元素
        Collection coll2 = Arrays.asList(456, 789);
        System.out.println(coll.removeAll(coll2));
        System.out.println(coll);

        //retainAll(Collection coll): 获取当前集合和coll集合的交集，并返回给当前集合
        Collection coll3 = Arrays.asList("tom", false);
        System.out.println(coll.retainAll(coll3));
        System.out.println(coll);

        //equals(Object obj): 判断当前集合和形参集合的元素是否全部相同(包括顺序)
        Collection coll4 = new ArrayList();
        coll4.add(false);
        coll4.add("tom");
        System.out.println(coll.equals(coll4));
        System.out.println(coll.equals(coll3)); //集合元素顺序不同

        //hashcode(): 返回当前对象的哈希值
        System.out.println(coll.hashCode());
    }

    @Test
    public void test() {
        Collection coll = new ArrayList();
        //add(Object obj): 将对象添加到集合中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());
        System.out.println(coll);

        Collection coll1 = new ArrayList();
        coll1.add("CC");
        //add(Collection coll): 将一个集合中的元素添加到另一个集合中
        coll.addAll(coll1);
        System.out.println(coll);
        System.out.println(coll1);

        //size(): 获取添加元素的个数
        System.out.println(coll.size());

        //clear(): 清空当前集合
        coll.clear();

        //isEmpty(): 判断当前集合是否为空
        System.out.println(coll.isEmpty());

    }
}
