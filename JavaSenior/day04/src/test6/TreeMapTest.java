package test6;

import org.junit.Test;

import java.util.*;

/**
 * @author Chenyang
 * @create 2021-01-10-13:48
 */
public class TreeMapTest {
    //定制排序
    @Test
    public void test1(){
        Map map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else throw new RuntimeException("类型不匹配");
            }
        });

        User user = new User(23, "Tom");
        User user1 = new User(32, "Jack");
        User user2 = new User(20, "Sean");
        User user3 = new User(18, "David");

        map.put(user, 98);
        map.put(user1, 89);
        map.put(user2, 76);
        map.put(user3, 100);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    //自然排序
    @Test
    public void test() {
        Map map = new TreeMap();
        User user = new User(23, "Tom");
        User user1 = new User(32, "Jack");
        User user2 = new User(20, "Sean");
        User user3 = new User(18, "David");

        map.put(user, 98);
        map.put(user1, 89);
        map.put(user2, 76);
        map.put(user3, 100);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}
