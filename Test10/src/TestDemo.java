import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @Author Li_ZW
 * @Date: 2020/05/07
 * @Time: 19:10
 * @Description
 * 字符串类型：String
 *
 */

public class TestDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "Hello";
        //反射  自省的过程
        Class cl = String.class;
        Field field = cl.getDeclaredField("value");
        field.setAccessible(true);
        char[] val = (char[]) field.get(str);
        val[0] = 'g';
        System.out.println(str);
    }

    public static void main10(String[] args) {
        String str = "Hello";
        str = "h" + str.substring(1);
        System.out.println(str);
    }

    public static void main9(String[] args) {
        String str = "hello ";
        str = str + " world ";
        str += " !!!";
        System.out.println(str);
    }

    public static void main8(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello").intern();

        System.out.println(str1 == str2); // true 比较的是引用
    }

    public static void main7(String[] args) {
        String str1 = "hello";

        System.out.println(str1.equals("hello")); // true
        System.out.println("hello".equals(str1)); // true
    }

    public static void main6(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");

        System.out.println(str1 == str2); //  false 比较的是引用
        System.out.println(str1.equals(str2)); //  true 比较的是字符串内容

        String str3 = "hello";
        System.out.println(str1 == str3); // true
        System.out.println(str1.equals(str3)); // true
    }

    public static void main5(String[] args) {
        String str1 = "hello";
        char[] val = {'a'};
        System.out.println(str1);
        System.out.println(Arrays.toString(val));

        func(str1,val);
        System.out.println(str1);
        System.out.println(Arrays.toString(val));
    }

    private static void func(String str, char[] array) {
        str = "abcdef";
        array[0] = 'g';
    }

    public static void main4(String[] args) {
        String str1 = "hello";
        String str2 = str1;
        System.out.println(str1);
        System.out.println(str2);

        str1 = "abc";
        System.out.println(str1);
        System.out.println(str2);
    }

    public static void main3(String[] args) {
        String str1 = "hello";
        String str2 = "hel" + "lo";
        System.out.println(str1 == str2); //true

        String str3 = new String("hel"+"lo");
        System.out.println(str1 == str3); //false
    }

    public static void main2(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1 == str2);//false

        String str3 = "hello";
        System.out.println(str1 == str3); //true
    }

    public static void main1(String[] args) {
        String str1 = "hello";
        System.out.println(str1);

        String str2 = new String("abcdef");
        System.out.println(str2);

        char[] val = {'a','b','c','d','e','f'};
        String str3 = new String(val);
        System.out.println(str3);
    }
}