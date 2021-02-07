package test3;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * NIO2中Path、Paths和Files类的使用
 * @author Chenyang
 * @create 2021-02-07-16:39
 */
public class NIO2Test {
    @Test
    public void test(){
        Path path = Paths.get("hello.txt");
        System.out.println(path.getFileName());
        System.out.println(path.isAbsolute());
        System.out.println(path.toAbsolutePath());
        System.out.println(path.startsWith(Paths.get("D:")));
        System.out.println(path.toFile());
    }
}
