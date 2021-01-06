package test2;

import org.junit.Test;

/**
 * StringBuffer和StringBuilder的常用方法
 * @author Chenyang
 * @create 2021-01-06-16:31
 */
public class StringBufferBuilderTest {

    @Test
    public void test2(){
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();

        startTime = System.currentTimeMillis();
        for(int i=0;i<20000;++i){
            buffer.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间为:" + (endTime-startTime));

        startTime = System.currentTimeMillis();
        for(int i=0;i<20000;++i){
            builder.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间为:" + (endTime-startTime));

        startTime = System.currentTimeMillis();
        for(int i=0;i<20000;++i){
            text += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间为:" + (endTime-startTime));

    }

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer();
        sb1.append(1);
        sb1.append('a');
        sb1.append("bcd");
        sb1.append(true);
        sb1.append(new StringBuffer("abc123"));
        System.out.println(sb1);

        sb1.delete(3,20);
        System.out.println(sb1);
        sb1.replace(0,100,"hello");
        System.out.println(sb1);

        sb1.insert(0,"world");
        System.out.println(sb1);

        sb1.reverse();
        System.out.println(sb1);

        System.out.println(sb1.length());

        String s1 = sb1.substring(0,5);
        System.out.println(s1);
        System.out.println(sb1);


    }

    @Test
    public void test(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
    }
}
