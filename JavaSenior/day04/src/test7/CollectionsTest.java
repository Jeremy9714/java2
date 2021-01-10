package test7;

import org.junit.Test;

import java.util.*;

/**
 * Collections是操作List、Set、Map集合的工具类
 * @author Chenyang
 * @create 2021-01-10-14:22
 */
public class CollectionsTest {
    /**
     * 同步控制方法
     */
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(761);
        list.add(-12);
        list.add(0);
        list.add(123);

        //List synchronizedList(List list): 将指定集合包装成线程同步的集合
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);
    }

    /**
     * 查找、替换方法
     */
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(761);
        list.add(-12);
        list.add(0);
        list.add(123);

        //int frequency(Collection coll, Object o): 返回集合中指定元素o的出现次数
        int frequency = Collections.frequency(list, 123);
        System.out.println(frequency);

        //void copy(List dest, List src): 将src中的元素复制到dest中
        //dest的size()必须大于等于src的size(),否则报错
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest);
        Collections.copy(dest,list);
        System.out.println(dest);

        //boolean replaceAll(List list, Object oldVal, Object newVal):
        //使用新值newVal替换集合list中所有的旧值newVal
        Collections.replaceAll(list,123,321);
        System.out.println(list);
    }

    /**
     * 排序方法
     */
    @Test
    public void test(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(761);
        list.add(-12);
        list.add(0);

        //reverse(List list): 对指定集合进行反转排序
        Collections.reverse(list);

        //shuffle(List list): 对指定集合进行随机排序
        Collections.shuffle(list);

        //sort(List list): 根据元素的自然顺序对指定List集合元素进行排序
        Collections.sort(list);

        //sort(List list, Comparator com): 根据指定Comparator产生的顺序对集合进行排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer int1 = (Integer) o1;
                Integer int2 = (Integer) o2;
                return -Integer.compare(int1,int2);
            }
        });

        //swap(List list,int i,int j): 将list中i处的元素与j处的元素互换
        Collections.swap(list,2,3);
        System.out.println(list);
    }
}
