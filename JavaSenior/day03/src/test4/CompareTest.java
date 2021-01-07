package test4;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparable接口和Comparator接口的应用
 *
 * @author Chenyang
 * @create 2021-01-07-17:22
 */
public class CompareTest {

    @Test
    public void test3(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovo", 34);
        arr[1] = new Goods("microsoft", 43);
        arr[2] = new Goods("xiaomi", 12);
        arr[3] = new Goods("huawei", 65);
        arr[4] = new Goods("dell", 43);

        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getName().equals(o2.getName())) {
                    return -Integer.compare(o1.getPrice(),o2.getPrice());
                }else{
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        String[] arr = {"AA", "BB", "DD", "CC"};

        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("类型不匹配");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test1() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovo", 34);
        arr[1] = new Goods("microsoft", 43);
        arr[2] = new Goods("xiaomi", 12);
        arr[3] = new Goods("huawei", 65);
        arr[4] = new Goods("dell", 43);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test() {
        String[] arr = {"AA", "BB", "DD", "CC"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
