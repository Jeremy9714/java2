package test3;

/**
 * 面试题 获取两个字符串中的最大相同子串
 *
 * @author Chenyang
 * @create 2021-01-06-19:18
 */
public class StringTest {

    public String task(String str1, String str2) {

        String maxString = str1.length()>=str2.length()?str1:str2;
        String minString = str1.length()<str2.length()?str1:str2;
        int length = minString.length();

        for(int i=0;i<length;++i){
            for(int x=0,y=length-i;y<=length;x++,y++){
                String sub = minString.substring(x,y);
                if(maxString.contains(sub)){
                    return sub;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        StringTest s = new StringTest();
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        String str = s.task(str1, str2);
        System.out.println(str);
    }
}
