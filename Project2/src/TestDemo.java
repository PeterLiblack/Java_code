import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/04/30
 * @Time: 14:41
 * @Description
 *方法练习
 */
public class TestDemo {

    public static void main1(String[] args) {
        //求斐波那契数列的第n项。(迭代实现)
        int n = 6;
        System.out.println(fib(6));
    }
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

    public static void main2(String[] args) {
        //求1！+2！+3！+4！+........+n!的和
        int n = 5;
        System.out.println(fac(5));
    }

    private static int fac(int n) {
        int sum = 0;
        int ret = 1;
        for (int i = 1; i <= n; i++) {
           ret *= i;
           //System.out.println(ret);
           sum += ret;
        }
        return sum;
    }


    public static void main3(String[] args) {
        //求 N 的阶乘 。
        int n = 5;
        System.out.println(fab(5));
    }

    private static int fab(int i) {
        int ret = 1;
        for (int j = 1; j <= i; j++) {
            ret *= j;
        }
        return ret;
    }

    public static void main4(String[] args) {
        //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
        int[] arr = {1,2,3,4,5,6};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void transform(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            while (left < right && arr[left]%2 != 0) {
                left++;
            }
            while (left < right && arr[right]%2 == 0) {
                right--;
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }

    public static void main5(String[] args) {
        //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
        int a = 2;
        int b = 3;
        int c = 4;
        int max = Max(a,b);
        int max1 = MAx(a,b,c);
        System.out.println(max);
        System.out.println(max1);
    }

    private static int MAx(int a, int b, int c) {
        int ret = (a > b) ? a : b;
        return  (ret > c) ? ret : c;
    }

    private static int Max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main6(String[] args) {
        //​ 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
        int a = 2;
        int b = 3;
        int c = 4;
        int max = Max(a,b);
        max = Max(Max(a,b),c);
        System.out.println(max);
    }

    public static void main7(String[] args) {
        //在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，
        //还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
        int a = 1;
        int b = 3;
        int ret = Max(a,b);
        System.out.println(ret);

        double a2 = 1.0;
        double b2 = 2.0;
        double ret2 = Max(a2,b2);
        System.out.println(ret2);

        double ret3 = Max(b,a2,b2);
        System.out.println((int) ret3);
    }

    private static double Max(int b, double a2, double b2) {
        double ret = (a2 > b) ? a2 : b;
        return  (ret > b2) ? ret : b2;
    }

    private static double Max(double a, double b) {
        return (a > b) ? a : b;
    }

    public static void main8(String[] args) {
        //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
        int a = 10;
        int b = 20;
        int ret = add(a, b);
        System.out.println("ret = " + ret);
        
        double a2 = 10.5;
        double b2 = 20.5;
        double c2 = 15.5;
        double ret2 = add(a2, b2, c2);
        System.out.println("ret2 = " + ret2);
        
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static double add(double a2,double b2,double c2) {
        return a2+b2+c2;
    }

    public static void main9(String[] args) {
        //青蛙跳台阶问题
        System.out.println("请输入台阶数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = jumpFloor(n);
        int ret2 = abnormalJumpFloor(n);
        System.out.println("正常跳：一共有" + ret + "种跳法");
        System.out.println("变态跳：一共有" + ret2 + "种跳法");
    }

    private static int abnormalJumpFloor(int n) {
        int ret = 0;
        if (n == 0) {
            return 1;
        }else if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else {
            for (int i = 0; i < n; i++) {
                ret += abnormalJumpFloor(i);
            }
        }
        return ret;
    }

    private static int jumpFloor(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else
            return jumpFloor(n-1) + jumpFloor(n-2) + jumpFloor(n-3);
    }

    public static void main10(String[] args) {
        //递归求解汉诺塔问题
        System.out.println("请输入盘子数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        hanoi(n,'A','B','C');
    }

    private static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.print(A + "-->" + C + "\n");
        }
        if (n > 1) {
            hanoi(n-1,A,C,B);
            System.out.print(A + "-->" + C + "\n");
            hanoi(n-1,B,A,C);
        }
        System.out.println();
    }

    public static void main11(String[] args) {
        //递归求斐波那契数列的第 N 项
        int n = 5;
        int ret = fib2(5);
        System.out.println(ret);

    }

    private static int fib2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main12(String[] args) {
        //写一个递归方法，输入一个非负整数，返回组成它的数字之和
        System.out.println("请输入整数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = sum2(n);
        System.out.println(ret);
    }

    public static int sum2(int num) {
        if (num < 10) {
            return num;
        }
        return num % 10 + sum2(num / 10);
    }

    public static void main13(String[] args) {
        //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
        System.out.println("请输入整数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        print(n);

    }
    public static void print(int num) {
        if (num > 9) {
            print(num / 10);
        }
        System.out.println(num % 10);
    }

    public static void main14(String[] args) {
        //递归求 1 + 2 + 3 + ... + 10
        int n = 10;
        int ret = sum3(n);
        System.out.println(ret);
    }
    public static int sum3(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum3(num - 1);
    }

    public static void main(String[] args) {
        //递归求 N 的阶乘
        int n = 5;
        int ret = factor(5);
        System.out.println(ret);
    }
    public static int factor(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factor(n - 1);
    }
}
