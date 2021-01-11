package test1;

import org.junit.Test;

import java.io.File;

/**
 * @author Chenyang
 * @create 2021-01-11-11:06
 */
public class FileTest {
    @Test
    public void test1() {
        //构造器1:
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\Desktop\\Scripts\\Java\\workplace_idea\\JavaSenior\\day06\\he.txt");
        System.out.println(file1);
        System.out.println(file2);

        //构造器2:
        File file3 = new File("D:\\Desktop\\Scripts\\Java\\workplace_idea", "JavaSenior");
        System.out.println(file3);

        //构造器3:
        File file4 = new File(file3, "hello.txt");
        System.out.println(file4);
    }

    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\Desktop\\Scripts\\Java\\workplace_idea\\JavaSenior\\day06\\hi.txt");

        //String getAbsolutePath(): 获取绝对路径
        System.out.println(file1.getAbsolutePath());
        //String getPath(): 获取路径
        System.out.println(file1.getPath());
        //String getName(): 获取名称
        System.out.println(file1.getName());
        //String getParent(): 获取上层文件目录路径(根据初始化时的路径字符串得出)。若无，返回null
        System.out.println(file1.getParentFile());
        //long length(): 获取文件长度(字节数); 不能获取目录的长度
        System.out.println(file1.length());
        //long lastModified(): 获取最后一次的修改时间(毫秒数)
        System.out.println(file1.lastModified());
        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParentFile());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void test3(){
        File file = new File("D:\\Desktop\\Scripts\\Java\\workplace_idea\\JavaSenior");

        //String[] list(): 获取指定目录下所有文件或文件目录名称的数组
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();

        //File[] listFiles(): 获取指定目录下所有的文件或文件目录的File数组
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    @Test
    public void test4(){
        File file1 = new File("D:\\Desktop\\Scripts\\Java\\workplace_idea\\JavaSenior\\day06\\hello.txt");
        File file2 = new File("D:\\Desktop\\Scripts\\Java\\workplace_idea\\JavaSenior\\day06\\hi.txt");

        //boolean renameTo(File f): 把文件重命名为指定的文件路径
        //如果想返回true, 重命名的文件必须存在，且File f不能存在
        boolean b = file1.renameTo(file2);
        System.out.println(b);

        System.out.println(file2.renameTo(file1));

    }
}
