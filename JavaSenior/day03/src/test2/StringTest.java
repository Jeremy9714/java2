package test2;

/**
 * @author Chenyang
 * @create 2021-01-06-12:26
 */
public class StringTest {
    String str = "good";
    char[] ch = {'t', 'e', 's', 't'};

    //此str是引用类型
    public void change(String str, char[] ch) {
        //String具有不可变性，所以此处会指向一个新的地址
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest s = new StringTest();
        s.change(s.str,s.ch);
        System.out.println(s.str);
        System.out.println(s.ch);
    }
}
