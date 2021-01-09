package test5;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author Chenyang
 * @create 2021-01-09-18:41
 */
public class CollectionTest {
    @Test
    public void test() {
        //先hashCode()再equals()
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001, "CC"));
        System.out.println(set);
        set.add(new Person(1001, "AA"));
        System.out.println(set);
    }
}
