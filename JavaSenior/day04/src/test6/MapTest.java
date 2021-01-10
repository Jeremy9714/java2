package test6;

import org.junit.Test;

import java.util.*;

/**
 * Map接口的常用方法
 *
 * @author Chenyang
 * @create 2021-01-09-19:43
 */
public class MapTest {
    /**
     * 元视图的操作方法
     */
    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 156);
        System.out.println(map);

        //Set keySet(): 返回所有key构成的Set集合
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        //Collection values(): 返回所有value构成的Collection集合
        Collection values = map.values();
        values.forEach(System.out::println);
        System.out.println();

        //Set entrySet(): 返回所有key-value对构成的Set集合
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    /**
     * 元素查询的操作
     */
    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 156);

        //Object get(Object key): 返回指定key对应的value
        System.out.println(map.get(45));

        //boolean containsKey(Object key): 是否包含指定key
        System.out.println(map.containsKey("BB"));

        //boolean containsValue(Object value): 是否包含指定value
        System.out.println(map.containsValue(123));

        //int size(): 返回map中包含的key-value对的个数
        System.out.println(map.size());

        //boolean isEmpty(): 判断当前map是否为空
        System.out.println(map.isEmpty());

        //boolean equals(Object obj): 判断当前map和参数对象obj是否相等
        Map map1 = new HashMap();
        map1.put("AA", 123);
        map1.put(45, 123);
        map1.put("BB", 156);
        System.out.println(map.equals(map1));
        System.out.println(map);
    }

    /**
     * 添加、删除、修改操作
     */
    @Test
    public void test1() {
        Map map = new HashMap();
        //Object put(Object key, Object value): 将指定key-value添加到(或修改)map对象中
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 156);
        //修改
        map.put("AA", 87);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 123);

        //void putAll(Map m): 将m中所有的key-value放入到当前map对象中
        map.putAll(map1);
        System.out.println(map);
        //System.out.println(map1);

        //Object remove(Object key): 移除指定key的key-value对，并返回value; key不存在则返回null
        Object obj = map.remove("CC");
        System.out.println(obj);
        System.out.println(map);

        //void clear(): 清空当前map中所有的数据
        map.clear();
        System.out.println(map.size());
        System.out.println(map);

    }

    @Test
    public void test() {
        Map map = new HashMap();
        map.put(null, null);
        //Hashtable不能存储null的key和value
//        map = new Hashtable();
//        map.put(null, 1);
    }
}
