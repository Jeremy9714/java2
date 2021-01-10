package test3;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * 通配符的使用
 * @author Chenyang
 * @create 2021-01-10-22:02
 */
public class GenericTest1 {
    /*
    通配符: ?
     */
    @Test
    public void test1(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;
        print(list1);
        print(list2);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
