package test1;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * 自定义泛型结构: 泛型类、泛型接口; 泛型方法
 *
 * @author Chenyang
 * @create 2021-01-10-20:06
 */
public class GenericTest1 {
    /**
     * 泛型类
     */
    @Test
    public void test1() {
        //要求: 如果定义了类是带泛型的, 建议在实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("abc");

        //指明类的泛型
        Order<String> order1 = new Order<>("orderA", 1, "AA");
//        order1.setOrderT("abc");
//        order1.setOrderT("def");
        System.out.println(order1.getOrderT());
        System.out.println(order1);
    }

    /**
     * 泛型类的继承问题
     */
    @Test
    public void test2() {
        SubOrder subOrder = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型. 则实例化子类对象时，不再需要指明泛型
        subOrder.setOrderT(12);
        System.out.println(subOrder.getOrderT());
        //非泛型类也可以有泛型方法
        List<String> list = subOrder.copyFromArrayToList1(new String[]{"AA","BB"});
        System.out.println(list);

        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("cba");
        System.out.println(subOrder1.getOrderT());
    }

    /**
     * 泛型方法
     */
    @Test
    public void test3() {
        Order<Integer> order = new Order<>("OrderBB", 2, 22);
        Integer[] arr = new Integer[]{1,2,3};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
