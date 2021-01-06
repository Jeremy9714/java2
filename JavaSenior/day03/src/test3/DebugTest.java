package test3;

import org.junit.Test;

/**
 * @author Chenyang
 * @create 2021-01-06-20:46
 */
public class DebugTest {

    @Test
    public void test(){
        String str = null;
        StringBuffer sb1 = new StringBuffer();
        sb1.append(str);

        System.out.println(sb1.length());
        System.out.println(sb1);

//        StringBuffer sb2 = new StringBuffer(str);
//        System.out.println(sb2);

    }
}
