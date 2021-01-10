package test3;

import org.junit.Test;

import java.util.ArrayList;
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

        //通配符?: 公共父类
        List<?> list = null;
        list = list1;
        list = list2;
        //编译通过
//        print(list1);
//        print(list2);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;

        //添加(写): 对于List<?>就不能向其内部添加数据
        //除了添加null以外
//        list.add("AA");
        list.add(null);

        //获取(读): 允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);

    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
