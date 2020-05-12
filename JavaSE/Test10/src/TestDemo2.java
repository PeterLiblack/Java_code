import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Author Li_ZW
 * @Date: 2020/05/07
 * @Time: 20:27
 * @Description
 * String相关使用
 */

public class TestDemo2 {
    public static void main(String[] args) {
        String str1 = " aba bcabcd  ";
        String ret1 = str1.trim();
        System.out.println(ret1);
        //代表从这个位置开始进行截取到结束位置

        String ret2 = str1.substring(1);
        System.out.println(ret2);

        ret2 = str1.substring(1,4);
        System.out.println(ret2);

        String ret3 = str1.replaceFirst("abc","pp");
        System.out.println(ret3);
    }

    public static void main4(String[] args) {
        String str1 = "fbcdefg";
        String str2 = "fbcdefg";

        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.compareTo(str2));
        System.out.println("刘".compareTo("杨"));
    }

    public static void main3(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {97,98,99,100};
        String str = new String(bytes);
        System.out.println(str);

        String str2 = "zhangsan";
        byte[] bytes1 = str2.getBytes("utf8");
        System.out.println("============");
        System.out.println(Arrays.toString(bytes1));
    }

    public static void main2(String[] args) {
        //判断是否都是数字
        String str = "123456";
        boolean flg = func(str);
        System.out.println(flg);
    }

    private static boolean func(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main1(String[] args) {
        char[] val = {'a','b','c','d','e'};
        String str = new String(val,1,3);
        System.out.println(str);

        String str2 = "hello";
        char ch = str2.charAt(3);
        System.out.println(ch);

        char[] val2 = str2.toCharArray();
        System.out.println(Arrays.toString(val2));
    }
    
}