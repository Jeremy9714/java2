package test3;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.泛型在集成方面的体现
 * 2.通配符的使用
 *
 * @author Chenyang
 * @create 2021-01-10-21:40
 */
public class GenericTest {
    @Test
    public void test1() {

        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;


        ArrayList<Object> list1 = null;
        ArrayList<String> list2 = new ArrayList<>();
        //此时的list1和list2不具备子父类的关系
//        list1 = list2;
        /*
        反证法
        假设list1=list2;
            那么栈中的list1便指向list2在对空间中实例化的ArrayList
            list1.add(123);导致混入非String的数据。出错

         */
        show(list1);
//        show(list2);

        showMore(list1);
        showMore(list2);

    }

    public void show(List<Object> list){
    }

    public <T> void showMore(List<T> list){

    }

    @Test
    public void test2(){
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<String>();
    }

}
