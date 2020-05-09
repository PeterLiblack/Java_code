import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/09
 * @Time: 13:47
 * @Description
 *
 */
public class TestDemo {
    public static void main(String[] args) {
        String str = "abcdefg";
        String ret = reverse(str,0,str.length()-1);
        System.out.println(ret);
    }

    private static String reverse(String str, int begin, int end) {
        char[] value = str.toCharArray();
        while (begin < end) {
            char tmp = value[begin];
            value[begin] = value[end];
            value[end] = tmp;
            begin++;
            end--;
        }
        return String.copyValueOf(value);
    }

    public static void main5(String[] args) {
        String str = "abcdefAd高";
        String ret = str.toLowerCase();
        System.out.println(ret.length());

        int[] array = {1,2,3,4,5};
        System.out.println(array.length);

        String string = ""; //空串
        String string2 = null; //空对象
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String ret = func(str);
            System.out.println(ret);
        }
    }

    private static String func(String str) {
        String[] strings = str.split(" ");
        String ret = "";
        for (String s:strings
             ) {
            ret += s;
        }
        return ret;
    }

    public static void main3(String[] args) {
        String str = "name=zhangsan & age=18";
        String[] strings = str.split("&");
        for (String s1:strings
             ) {
            String[] strings2 = s1.split("=");
            //多次拆分
            for (String s2:strings2
                 ) {
                System.out.println(s2);
            }
        }
    }

    public static void main2(String[] args) {
        String str = "abc de f";
        String[] strings = str.split(" ");
        //字符串按空格拆分
        for (String s:strings
             ) {
            System.out.println(s);
        }

        String str2 = "199\\09\\28\\1";
        String[] strings2 = str2.split("\\\\");
        //字符串按\\拆分
        for (String s:strings2
             ) {
            System.out.println(s);
        }

        String str3 = "Java-split#boy";
        String[] strings3 = str3.split("|-|#");
        for (String s:strings3
             ) {
            System.out.println(s);
        }
    }

    public static void main1(String[] args) {
        String str = "ababcabcdabcde";
        int index = str.indexOf("abc",2);
        //从指定位置查找字符串的位置
        System.out.println(index);

        index = str.lastIndexOf("abc",3);
        //从指定位置向前查找字符串的位置
        System.out.println(index);

        boolean flg = str.startsWith("abc",2);
        //从指定位置向后判断是否以指定字符串开头
        flg = str.endsWith("bcde");
        System.out.println(flg);

    }

}
