import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/09
 * @Time: 15:07
 * @Description
 *
 */
public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        String ret = func(str,n);
        System.out.println(ret);
    }

    private static String func(String str, int n) {
        if (str == null || n <= 0 || n >= str.length()) {
            return null;
        }
        str = reverse(str,0,n-1);
        str = reverse(str,n,str.length()-1);
        str = reverse(str,0,str.length()-1);
        return str;
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

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append(scanner.next());
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb2.append("a");
        }
        System.out.println(sb2);

        StringBuilder sb3 = new StringBuilder();
        sb3.append("hello");
        StringBuilder stringBuilder = sb3.reverse();
        System.out.println(stringBuilder);

        String s = "hello";
        s = s + "world";
        System.out.println(s);
        StringBuilder s2 = new StringBuilder();
        s2.append("hello");
        s2.append("world");
        String ret = s2.toString();

        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("efg").append("1234");
        System.out.println(stringBuilder1);
    }

    public static void main1(String[] args) {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str += 'a';
        }
        System.out.println(str);

        String str2 = "abcdef";
        str2 = str2 + "hello";
        System.out.println(str2);
    }
}
