package test3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 实现Iterator接口去遍历集合元素
 * @author Chenyang
 * @create 2021-01-08-19:11
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Tom", 12));
        coll.add(new String("tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            //迭代器的remove(): 将迭代器得到的最后一个对象从该集合中移除
            Object obj = iterator.next();
            if("tom".equals(obj)){
                iterator.remove();
            }else{
                System.out.println(obj);
            }
        }


    }

    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Tom", 12));
        coll.add(new String("tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //hasNext(): 判断是否还有下一个元素
        while (iterator.hasNext()) {
            //next(): 指针下移，然后将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }
}
