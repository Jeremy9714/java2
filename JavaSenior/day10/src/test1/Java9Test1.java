package test1;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Chenyang
 * @create 2021-01-17-18:14
 */
public class Java9Test1 {
    //Java9新特性: 集合工厂方法->创建只读集合
    @Test
    public void test1() {
        //Java8
//        List<String> list = new ArrayList<>();
//        list.add("Joe");
//        list.add("Jason");
//        list.add("Jeremy");
//        list = Collections.unmodifiableList(list);
////        strings.add("aa");
//        System.out.println(list);

        //只读集合
        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        list.add(10);
        System.out.println(list);

        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
//        set.add(10);
        System.out.println(set);

        Map<String, Integer> map = Map.of("Tom", 10, "Jason", 12);
//        map.put("Michael", 22);
        map.forEach((k, v) -> System.out.println(k + " " + v));

        Map<String, Integer> map1 = Map.ofEntries(Map.entry("Jeremy", 12), Map.entry("Jack", 10));
        System.out.println(map1);
    }

    //Java9新特性: InputStream新方法transferTo()
    @Test
    public void test2(){
        ClassLoader cl = this.getClass().getClassLoader();
        try(InputStream is = cl.getResourceAsStream("hello.txt");
            FileOutputStream os = new FileOutputStream("src\\hello1.txt")){
            //将输入流中的数据自动复制到输出流中
            is.transferTo(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
