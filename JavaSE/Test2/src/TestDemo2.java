/**
 * @Author Li_ZW
 * @Date: 2020/04/13
 * @Date: 18:52
 * @Description
 * 递归练习
 */
public class TestDemo2 {

    public static void main5(String[] args) {
        //求斐波那契数
        System.out.println(fib(40));
    }
    //递归
    public static int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }
    //非递归
    public static int fib(int n) {
        int last2 = 1;
        int last1 = 1;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = last1 + last2;
            last2 = last1;
            last1 = cur;
        }
        return cur;
    }
    public static void main4(String[] args) {
        //写一个递归方法，输入一个非负整数，返回组成它的数字之和. 例如，输入 1729, 则应该返回1+7+2+9，
        //它的和是19
        int num = 1729;
        int ret = sum1(num);
        System.out.println("ret = " + ret);
    }
    public static int sum1(int num) {
        if (num < 10) {
            return num;
        }
        return num % 10 + sum1(num / 10);
    }
    public static void main3(String[] args) {
        //递归求 1 + 2 + 3 + ... + 10
        int n = 10;
        int ret = sum(n);
        System.out.println("ret = " + ret);
    }
    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum(num - 1);
    }
    public static void main2(String[] args) {
        //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
        int n = 1234;
        print(n);
    }
    public static void print(int num) {
         if (num > 9) {
             print(num / 10);
         }
         System.out.println(num % 10);
    }

    public static void main1(String[] args) {
        //青蛙跳台阶问题
    //int n=4;
    int ret=tiao(5);
        System.out.println(ret);
    }
    public static int tiao(int i) {
        if (i==1) {
            return 1;
        } else if (i==2) {
            return 2;
        } else {
            return tiao(i-1)+tiao(i-2);
        }
    }
}
