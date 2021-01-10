package test1;

import org.junit.Test;

import java.util.*;

/**
 * 泛型
 *
 * @author Chenyang
 * @create 2021-01-10-15:47
 */
public class GenericTest {

    //在集合中使用泛型之前的情况
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        //需求：存放学生成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
        list.add("AA");

        for (Object o : list) {
            //问题二：强转时，可能会出现ClassCastException
            int mark = (Integer) o;
            System.out.println(mark);
        }
    }

    //在集合中使用泛型的情况
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //编译时会进行类型检查
        //list.add("11");

        //方式一
//        for (Integer integer : list) {
//            //避免了强转操作
//            System.out.println(integer);
//        }

        //方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //在HashMap集合中使用泛型
    @Test
    public void test3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("tom", 12);
        map.put("sean", 13);
        map.put("jason", 14);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
