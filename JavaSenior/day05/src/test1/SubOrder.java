package test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chenyang
 * @create 2021-01-10-20:13
 */
public class SubOrder extends Order<Integer>{//SubOrder不是泛型类
    public <E> List<E> copyFromArrayToList1(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
