package test4;

import org.junit.Test;

import java.util.Arrays;

/**
 * Comparable接口和Comparator接口的应用
 *
 * @author Chenyang
 * @create 2021-01-07-17:22
 */
public class CompareTest {
    @Test
    public void test1(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovo",34);
        arr[1] = new Goods("microsoft",43);
        arr[2] = new Goods("xiaomi",12);
        arr[3] = new Goods("huawei",65);
        arr[4] = new Goods("dell",43);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test(){
        String[] arr = {"AA", "BB", "DD", "CC"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
