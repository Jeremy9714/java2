package test1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

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

    @Test
    public void test5(){
        File file = new File("D:\\Desktop\\Scripts\\Java\\workplace_idea\\JavaSenior\\day06");

        //boolean isDirectory(): 是否是目录
        System.out.println(file.isDirectory());
        //boolean isFile(): 是否是文件
        System.out.println(file.isFile());
        //boolean exists(): 是否存在
        System.out.println(file.exists());
        //boolean canRead(): 是否可读
        System.out.println(file.canRead());
        //boolwan canWrite(): 是否可写
        System.out.println(file.canWrite());
        //boolean isHidden(): 是否隐藏
        System.out.println(file.isHidden());
    }

    @Test
    public void test6() throws IOException {
        //创建文件目录
        File file1 = new File("D:\\Desktop\\Scripts\\Java\\FileTest\\test1");
        File file2 = new File("D:\\Desktop\\Scripts\\Java\\FileTest\\test1");

        //boolean mkdir(): 创建文件目录，如果此文件目录存在，就不创建了；如果上层文件目录不存在，也不创建
        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }

        //boolean mkdirs(): 创建文件目录，如果文件目录存在，就不创建了；如果上层目录不存在，则一并创建
        mkdir = file2.mkdirs();
        if(mkdir){
            System.out.println("创建成功2");
        }

        //创建文件
        File file3 = new File("D:\\Desktop\\Scripts\\Java\\FileTest\\hello.txt");

        if (!file3.exists()){
            //boolean createNewFile(): 创建文件，若文件存在，则不创建，返回false
            file3.createNewFile();
            System.out.println("文件创建成功");
        }
        if(file3.exists()){
            //boolean delete(): 删除文件或文件夹
            file3.delete();
            System.out.println("文件删除成功");
        }
    }
}
