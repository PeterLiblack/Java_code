import java.util.Random;
import java.util.Scanner;

public class TestDemo {

    public static void main5(String[] args) {
        //猜数字
        Random random = new Random(); // 默认随机种子是系统时间
        Scanner sc = new Scanner(System.in);
        int toGuess = random.nextInt(100);
        // System.out.println("toGuess: " + toGuess);
        while (true) {
            System.out.println("请输入要输入的数字: (1-100)");
            int num = sc.nextInt();
            if (num < toGuess) {
                System.out.println("低了");
            } else if (num > toGuess) {
                System.out.println("高了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
        sc.close();
    }
    public static void main4(String[] args) {
        //循环结构——for循环
        //打印1-10
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
        //计算1-100的和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
        //计算5的阶乘
        int result = 1;
        for (int i = 1; i <= 5; i++) {
            result *= i;
        }
        System.out.println("result = " + result);
        //计算1!+2!+3!+4!+5!
        int sum2 = 0;
        for (int i = 1; i <= 5; i++) {
            int tmp = 1;
            for (int j = 1; j <= i; j++) {
                tmp *= j;
            }
            sum2 += tmp;
        }
        System.out.println("sum = " + sum2);

        //do while()循环
        //打印1-10
        int num = 1;
        do {
            System.out.println(num);
            num++;
        } while (num <= 10);
    }
    public static void main3(String[] args) {
        //循环结构——while循环
        //打印1-10
        int num1 = 1;
        while (num1 <= 10) {
            System.out.println(num1);
            num1++;
        }
        //计算1-100的和
        int num2 = 1;
        int result = 0;
        while (num2 <= 100) {
            result += num2;
            num2++;
        }
        System.out.println(result);
        //计算5的阶乘
        int num3 = 1;
        int ret = 1;
        while (num3 <= 5) {
            ret *= num3;
            num3++;
        }
        System.out.println(ret);
        //计算1!+2!+3!+4!+5!
        int num4 = 1;
        int sum = 0;
        // 外层循环负责求阶乘的和
        while (num4 <= 5) {
            int factorResult = 1;
            int tmp = 1;
            // 里层循环负责完成求阶乘的细节.
            while (tmp <= num4) {
                factorResult *= tmp;
                tmp++;
            }
            sum += factorResult;
            num4++;
        }
        System.out.println("sum = " + sum);
        //break
        int num5 = 100;
        while (num5 <= 200) {
            if (num5 % 3 == 0) {
                System.out.println("找到了 3 的倍数, 为:" + num5);
                break;
            }
            num5++;
        }
        //continue
        int num6 = 100;
        while (num6 <= 200) {
            if (num6 % 3 != 0) {
                num6++; // 这里的 ++ 不要忘记! 否则会死循环.
                continue;
            }
            System.out.println("找到了 3 的倍数, 为:" + num6);
            num6++;
        }
    }
    public static void main2(String[] args) {
        //顺序结构

        /*System.out.println("aaa");
        System.out.println("bbb");
        System.out.println("ccc");*/

        /*System.out.println("aaa");
        System.out.println("ccc");
        System.out.println("bbb");*/

        //分支结构--if语句
        /*int year = 2000;
        if (year % 100 == 0) {
        // 判定世纪闰年
            if (year % 400 == 0) {
                System.out.println("是闰年");
            } else {
                System.out.println("不是闰年");
            }
        } else {
            // 普通闰年
            if (year % 4 == 0) {
                System.out.println("是闰年");
            } else {
                System.out.println("不是闰年");
            }
        }
    }*/
        //分支结构——switch语句
        int day = 1;
        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }

    public static void main1(String[] args) {
        //打印水仙花数
        int i = 0;

        for (i = 1; i <= 999999; i++) {
            int tmp = i; //153
            int count = 0;
            while (tmp != 0) {
                tmp = tmp / 10; //15 1 0
                count++; //1 2 3
            }
            tmp = i; //153
            int sum = 0;
            while (tmp != 0) {
                sum += Math.pow(tmp % 10, count); //3,3  5,3  1,3
                tmp = tmp / 10; //15 1 0
            }
            if (sum == i) {
                System.out.println(sum);
            }
        }
    }
}
