import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/11
 * @Time: 16:06
 * @Description
 * 泛型
 */

public class TestDemo {
    public static void main0(String[] args) {
        TestMain2<Integer> testMain2 = new TestMain2<>();
        System.out.println(testMain2);

    }

    public static void main4(String[] args) {
        TestMain2<Integer> testMain2 = new TestMain2<>();
        testMain2.add(2);
        testMain2.add(3);
        testMain2.add(3);

        int val = testMain2.getVal(1);
        System.out.println(val);

        TestMain2<String> testMain22 = new TestMain2<>();
        testMain22.add("hello");
        String val2 = testMain22.getVal(0);
        System.out.println(val2);
    }

    public static void main3(String[] args) {
        TestMain2 testMain2 = new TestMain2();
        testMain2.add("hello");
        testMain2.add(2);

        int val = (int)testMain2.getVal(1);
        System.out.println(val);
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                String tmp = ret.toString();
                if (!tmp.contains(ch+"")) {
                    ret.append(ch);
                }
            }
            System.out.println(ret);
        }
    }

    public static boolean isAdmin(String user) {
        return user.toLowerCase()=="admin";
    }
    public static void main1(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
}
